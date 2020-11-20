/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * Project Info:  http://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * http://plantuml.com/patreon (only 1$ per month!)
 * http://plantuml.com/paypal
 * 
 * This file is part of Smetana.
 * Smetana is a partial translation of Graphviz/Dot sources from C to Java.
 *
 * (C) Copyright 2009-2022, Arnaud Roques
 *
 * This translation is distributed under the same Licence as the original C program:
 * 
 *************************************************************************
 * Copyright (c) 2011 AT&T Intellectual Property 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: See CVS logs. Details at http://www.graphviz.org/
 *************************************************************************
 *
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS ECLIPSE PUBLIC
 * LICENSE ("AGREEMENT"). [Eclipse Public License - v 1.0]
 * 
 * ANY USE, REPRODUCTION OR DISTRIBUTION OF THE PROGRAM CONSTITUTES
 * RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.
 * 
 * You may obtain a copy of the License at
 * 
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package h;

import smetana.core.CFunction;
import smetana.core.UnsupportedStructAndPtr;
import smetana.core.__ptr__;
import smetana.core.amiga.StarStruct;

public class ST_splineInfo extends UnsupportedStructAndPtr {

	public CFunction swapEnds;
	public CFunction splineMerge;
	public boolean ignoreSwap;
	public boolean isOrtho;

	public ST_splineInfo() {
		this(null);
	}

	public ST_splineInfo(StarStruct parent) {
	}

	@Override
	public __ptr__ setPtr(String fieldName, __ptr__ newData) {
		if (fieldName.equals("swapEnds")) {
			this.swapEnds = (CFunction) newData;
			return swapEnds;
		}
		if (fieldName.equals("splineMerge")) {
			this.splineMerge = (CFunction) newData;
			return splineMerge;
		}
		return super.setPtr(fieldName, newData);
	}

	// public interface ST_splineInfo extends __ptr__ {
	// public static List<String> DEFINITION = Arrays.asList(
	// "typedef struct",
	// "{",
	// "boolean(*swapEnds) (edge_t * e)",
	// "boolean(*splineMerge) (node_t * n)",
	// "boolean ignoreSwap",
	// "boolean isOrtho",
	// "}",
	// "splineInfo");
}

// typedef struct {
// boolean(*swapEnds) (edge_t * e); /* Should head and tail be swapped? */
// boolean(*splineMerge) (node_t * n); /* Is n a node in the middle of an edge? */
// boolean ignoreSwap; /* Test for swapped edges if false */
// boolean isOrtho; /* Orthogonal routing used */
// } splineInfo;