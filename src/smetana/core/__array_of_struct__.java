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

import java.util.ArrayList;
import java.util.List;

import smetana.core.amiga.Area;
import smetana.core.amiga.BuilderArea;
import smetana.core.amiga.StarArrayOfStruct;
import smetana.core.amiga.StarStruct;

public class __array_of_struct__ implements Area {

	private final List<Area> data;
	private final int currentPos;

	private final int UID = StarStruct.CPT++;

	public String getUID36() {
		return Integer.toString(UID, 36);
	}

	public void swap(int i, int j) {
		Area e1 = data.get(i);
		Area e2 = data.get(j);
		data.set(i, e2);
		data.set(j, e1);
	}

	@Override
	public String toString() {
		if (data.get(0) != null) {
			return "__array_of_struct__ " + getUID36() + " " + currentPos + "/" + data.size() + " "
					+ data.get(0).toString();
		}
		return "__array_of_struct__ " + getUID36() + " " + currentPos + "/" + data.size();
	}

	public void realloc(int nb) {
		while (data.size() < nb + currentPos) {
			data.add(null);
		}
	}

	public __ptr__ asPtr() {
		return new StarArrayOfStruct(this);
	}

	public int comparePointerInternal(__array_of_struct__ other) {
		if (this.data != other.data) {
			throw new IllegalArgumentException();
		}
		return this.currentPos - other.currentPos;
	}

	public static __array_of_struct__ malloc(final Class cl, int nb) {
		return new __array_of_struct__(nb, new BuilderArea() {
			public Area createArea() {
				return new __struct__(cl);
			}
		});
	}

	private __array_of_struct__(List<Area> data, int currentPos) {
		this.data = data;
		this.currentPos = currentPos;
		check();
	}

	public __array_of_struct__(int size, BuilderArea builder) {
		this.data = new ArrayList<Area>();
		this.currentPos = 0;
		for (int i = 0; i < size; i++) {
			final Area tmp = builder.createArea();
			data.add(tmp);
		}
		check();
	}

	private void check() {
		if (getUID36().equals("194")) {
			JUtils.LOG("It's me");
		}
	}

	public __array_of_struct__ move(int delta) {
		return new __array_of_struct__(data, currentPos + delta);
	}

	public __array_of_struct__ plus(int delta) {
		return move(delta);
	}

	public Area getInternal(int idx) {
		return data.get(idx + currentPos);
	}

	public void setInternalByIndex(int idx, Area value) {
		if (value == this) {
			throw new IllegalArgumentException();
		}
		if (value instanceof __array_of_struct__) {
			throw new IllegalArgumentException();
		}
		data.set(idx + currentPos, value);
	}

	public void memcopyFrom(Area source) {
		throw new UnsupportedOperationException();
	}

	//

	public __ptr__ getPtr() {
		return ((__struct__) getInternal(0)).amp();
	}

	public __struct__ getStruct() {
		return (__struct__) getInternal(0);
	}

	public void setStruct(__struct__ value) {
		final Area area = getInternal(0);
		((__struct__) area).____(value);
	}

	public double getDouble(String fieldName) {
		final Area tmp1 = getInternal(0);
		return ((__struct__) tmp1).getDouble(fieldName);
	}

	public void setDouble(String fieldName, double value) {
		final Area tmp1 = getInternal(0);
		((__struct__) tmp1).setDouble(fieldName, value);
	}

	public __struct__ getStruct(String fieldName) {
		return ((StarStruct) getInternal(0)).getStruct(fieldName);
	}

}
