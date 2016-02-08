/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.sourceforge.net
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * Original Author:  Arnaud Roques
 * 
 */
package smetana.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StructureDefinition {

	private static final Map<Class, StructureDefinition> all = new HashMap<Class, StructureDefinition>();

	public static StructureDefinition from(Class cl) {
		if (cl == null) {
			throw new IllegalArgumentException();
		}
		StructureDefinition result = all.get(cl);
		if (result == null) {
			result = new StructureDefinition(cl);
			all.put(cl, result);
		}
		return result;
	}

	private final Class cl;
	private Map<String, Bucket> buckets; // = new LinkedHashMap<String, StructureDefinition.Bucket>();

	private StructureDefinition(Class cl) {
		// JUtils.LOG("BUIDLING StructureDefinition " + cl);
		this.cl = cl;
	}

	public String toString() {
		return (cl == null ? "NO_CLASS" : cl.getName()) + " " + buckets;
	}

	private Map<String, Bucket> buckets() {
		if (buckets == null) {
			final List<String> definition = CType.getDefinition(cl);
			JUtils.LOG("StructureDefinition::run for " + cl);
			JUtils.LOG("def=" + definition);
			JUtils.LOG("first=" + definition.get(0));

			buckets = new LinkedHashMap<String, Bucket>();

			if (definition.get(0).equals("typedef enum")) {
				final String last = definition.get(definition.size() - 1);
				if (last.matches("\\w+") == false) {
					throw new UnsupportedOperationException();
				}
				buckets.put(last, Bucket.buildEnum(last, definition));
				return buckets;
			}

			if (definition.get(0).equals("typedef struct gvplugin_active_textlayout_s") == false
					&& definition.get(0).equals("typedef struct color_s") == false
					&& definition.get(0).equals("typedef struct") == false
					&& definition.get(0).equals("typedef struct pointf_s") == false
					&& definition.get(0).equals("typedef struct gvplugin_active_layout_s") == false
					&& definition.get(0).equals("typedef struct GVCOMMON_s") == false
					&& definition.get(0).equals("struct " + cl.getSimpleName()) == false
					&& definition.get(0).equals("typedef struct " + cl.getSimpleName()) == false
					&& definition.get(0).equals("typedef struct " + cl.getSimpleName().replaceFirst("_t", "_s")) == false
					&& definition.get(0).equals("typedef union " + cl.getSimpleName()) == false) {
				throw new IllegalStateException("<struct " + cl.getSimpleName() + "> VERSUS <" + definition.get(0)
						+ ">");
			}
			if (definition.get(1).equals("{") == false) {
				throw new IllegalStateException();
			}

			int last = definition.size() - 1;
			if (definition.get(definition.size() - 2).equals("}")
					&& definition.get(definition.size() - 1).equals(cl.getSimpleName())) {
				last--;
			}

			if (definition.get(last).equals("}") == false) {
				throw new IllegalStateException();
			}

			for (Iterator<String> it = definition.subList(2, last).iterator(); it.hasNext();) {
				buckets.putAll(Bucket.buildSome(it));
			}
		}
		return buckets;
	}

	public Set<String> getFields() {
		return buckets().keySet();
	}

	public Collection<Bucket> getBuckets() {
		return buckets().values();
	}

	public Map<String, Bucket> getBucketsMap() {
		return buckets();
	}

	public Bucket getBucket(String field) {
		final Bucket result = buckets().get(field);
		if (result == null) {
			throw new IllegalArgumentException(field);
		}
		return result;
	}

	public Class getTheClass() {
		return cl;
	}

	public boolean containsFieldName(String fieldName) {
		return buckets().keySet().contains(fieldName);
	}

	// private static int getCSizeInByte(String name) {
	// // JUtils.LOG("getCSizeInByte " + name);
	// if (name.equals("char")) {
	// return 1;
	// }
	// if (name.equals("long")) {
	// return 4;
	// }
	// if (name.equals("int")) {
	// return 4;
	// }
	// if (name.equals("h.Agtag_s") || name.equals("Agtag_t")) {
	// return 4 + 4;
	// }
	// if (name.equals("h._dtlink_s") || name.equals("_dtlink_t")) {
	// return 4 + 4;
	// }
	// if (name.equals("h.Agobj_s") || name.equals("Agobj_t")) {
	// return getCSizeInByte("h.Agtag_s") + 4;
	// }
	// if (name.equals("h.Agdesc_s") || name.equals("Agdesc_t")) {
	// return 4;
	// }
	// if (name.equals("h.Agdisc_s") || name.equals("Agdisc_t")) {
	// return 4 + 4 + 4;
	// }
	// if (name.equals("h.Agdstate_s") || name.equals("Agdstate_t")) {
	// return 4 + 4;
	// }
	// if (name.equals("h._dtlink_s") || name.equals("Dtlink_t")) {
	// return 4 + 4;
	// }
	// JUtils.LOG("UNKNOW " + name);
	// throw new IllegalArgumentException(name);
	// }

	// public int getOffset(String fieldName) {
	// int offset = 0;
	// for (Map.Entry<String, Bucket> ent : mem.entrySet()) {
	// if (fieldName.equals(ent.getKey())) {
	// JUtils.LOG("getOffset Result for " + fieldName + " is " + offset);
	// return offset;
	// }
	// offset += ent.getValue().sizeInByte;
	// }
	// throw new IllegalArgumentException(fieldName);
	// }

}
