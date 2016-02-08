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

import h.Agedge_s;
import h.Agedgeinfo_t;
import h.bezier;
import h.boxf;
import h.pointf;
import h.splines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.UnsupportedAddressTypeException;

import smetana.core.amiga.StarArrayOfPtr;
import smetana.core.amiga.StarArrayOfStruct;
import smetana.core.amiga.StarStar;
import smetana.core.amiga.StarStruct;
import smetana.core.debug.Debug;

// http://docs.oracle.com/javase/specs/jls/se5.0/html/expressions.html#15.7.4
// http://www.jbox.dk/sanos/source/lib/string.c.html

public class JUtils {

	public static int USHRT_MAX = 65535;

	public static size_t sizeof(Class cl) {
		return new size_t_struct(cl);
	}

	public static size_t sizeof(__ptr__ element) {
		return new size_t_of_element(element);
	}

	public static size_t sizeof(String name, int sz) {
		if (name.equals("char*")) {
			return new size_t_array_of_charstars(sz);
		}
		throw new UnsupportedOperationException();
	}

	public static size_t sizeof(Class cl, int nb) {
		return new size_t_array_of_something(cl, nb);
	}

	public static size_t size_t_array_of_integer(int nb) {
		return new size_t_array_of_integer(nb);
	}

	public static size_t sizeof_starstar_empty(Class cl, int nb) {
		return new size_t_array_of_array_of_something_empty(cl, nb);
	}

	public static int strcmp(CString s1, CString s2) {
		return s1.compareTo(s2);
		// throw new UnsupportedOperationException("s1="+s1+" s2="+s2);
	}

	public static CString strstr(CString s1, CString s2) {
		throw new UnsupportedOperationException("s1=" + s1 + " s2=" + s2);
	}

	public static void strncpy(CString destination, CString source, int nb) {
		destination.copyFrom(source, nb);
	}

	public static CString strchr(CString str, char c) {
		return str.strchr(c);
	}

	public static int strtol(CString str, CString[] endptr, int base) {
		if (base != 10) {
			throw new IllegalArgumentException();
		}
		CString end = str;
		throw new UnsupportedOperationException();
	}
	
	public static double strtod (CString str, CString[] endptr) {
		final double result = Double.parseDouble(str.getContent());
		return result;
	}
	

	public static double atof(CString str) {
		return Double.parseDouble(str.getContent());
	}

	public static int memcmp(__ptr__ s1, __ptr__ s2, int sz) {
		throw new UnsupportedOperationException("s1=" + s1 + " s2=" + s2 + " sz=" + sz);
	}

	public static void memset(__ptr__ obj, int value, size_t nbytes) {
		if (value != 0) {
			throw new UnsupportedOperationException();
		}
	}

	public static int strlen(CString s) {
		return s.length();
	}

	public static double abs(double x) {
		return Math.abs(x);
	}

	public static double cos(double x) {
		return Math.cos(x);
	}

	public static double sin(double x) {
		return Math.sin(x);
	}
	

	public static double sqrt(double x) {
		return Math.sqrt(x);
	}

	public static double atan2(double a, double b) {
		return Math.atan2(a, b);
	}

	public static double pow(double a, double b) {
		return Math.pow(a, b);
	}

	public static boolean isdigit(char c) {
		return Character.isDigit(c);
	}

	public static int atoi(CString s) {
		return Integer.parseInt(s.getContent());
	}

	public static char tolower(char c) {
		return Character.toLowerCase(c);
	}

	public static CFunction function(Class codingClass, String name) {
		return CFunctionImpl.create(codingClass, name);
	}

	public static int enumAsInt(Class enumClass, String name) {
		CEnumInterpretor interpretor = new CEnumInterpretor(enumClass);
		final int result = interpretor.valueOf(name);
		JUtils.LOG("result for " + name + " is " + result);
		return result;
	}

	public static CString getenv(CString var) {
		return null;
	}

	public static void LOG(String s) {
		// System.err.println(s);
	}

	public static boolean EQ(Object o1, Object o2) {
		if (o1 == o2) {
			return true;
		}
		if (o1 == null && o2 != null) {
			return false;
		}
		if (o2 == null && o1 != null) {
			return false;
		}
		// if (o1 instanceof AreaArray && o2 instanceof AreaArray) {
		// return ((AreaArray) o1).isSameThan((AreaArray) o2);
		// }
		if (o1 instanceof StarStruct && o2 instanceof StarStruct) {
			return ((StarStruct) o1).isSameThan((StarStruct) o2);
		}
		if (o1 instanceof CString && o2 instanceof CString) {
			return ((CString) o1).isSameThan((CString) o2);
		}
		if (o1 instanceof StarArrayOfPtr && o2 instanceof StarArrayOfPtr) {
			return ((StarArrayOfPtr) o1).isSameThan((StarArrayOfPtr) o2);
		}
		if (o1 instanceof StarStar && o2 instanceof StarStruct) {
			__ptr__ o1b = ((StarStar) o1).getPtr();
			if (((StarStruct) o1b).getRealClass() != ((StarStruct) o2).getRealClass()) {
				throw new UnsupportedOperationException();
			}
			return EQ(o1b, o2);
		}
		if (o1 instanceof StarStruct && o2 instanceof StarArrayOfPtr) {
			__ptr__ o2b = ((StarArrayOfPtr) o2).getPtrForEquality();
			if (((StarStruct) o1).getRealClass() != ((StarStruct) o2b).getRealClass()) {
				throw new UnsupportedOperationException();
			}
			return EQ(o1, o2b);
		}
		if (o1 instanceof StarStruct && o2 instanceof StarArrayOfStruct) {
			__ptr__ o2b = ((StarArrayOfStruct) o2).getPtrForEquality();
			if (((StarStruct) o1).getRealClass() != ((StarStruct) o2b).getRealClass()) {
				throw new UnsupportedOperationException();
			}
			return EQ(o1, o2b);
		}
		if (o1 instanceof StarStar && o2 instanceof StarArrayOfPtr) {
			__ptr__ o1b = ((StarStar) o1).getPtr();
			__ptr__ o2b = ((StarArrayOfPtr) o2).getPtr();
			if (((StarStruct) o1b).getRealClass() != ((StarStruct) o2b).getRealClass()) {
				throw new UnsupportedOperationException();
			}
			return EQ(o1b, o2b);
		}
		System.err.println("o1=" + o1.getClass() + " " + o1);
		System.err.println("o2=" + o2.getClass() + " " + o2);
		throw new UnsupportedOperationException();
	}

	public static boolean NEQ(Object o1, Object o2) {
		return EQ(o1, o2) == false;
	}

	public static void qsortOld(__ptr__ array, int nb, size_t size, CFunction compare) {
		if (nb <= 1) {
			return;
		}
		System.err.println("array=" + array);
		System.err.println("nb=" + nb);
		System.err.println("size=" + size);
		System.err.println("compare=" + compare);
		for (int i = 0; i < nb - 1; i++) {
			__ptr__ element1 = array.plus(i);
			__ptr__ element2 = array.plus(i + 1);
			System.err.println("element1=" + element1);
			System.err.println("element2=" + element2);
			Integer cmp = (Integer) compare.exe(element1, element2);
			System.err.println("cmp=" + cmp);
			if (cmp.intValue() > 0) {
				throw new UnsupportedOperationException();
			}
		}
	}

	public static void qsort(__ptr__ array, int nb, size_t size, CFunction compare) {
		if (nb <= 1) {
			return;
		}
		System.err.println("array=" + array);
		System.err.println("nb=" + nb);
		System.err.println("size=" + size);
		System.err.println("compare=" + compare);
		boolean change;
		do {
			change = false;
			for (int i = 0; i < nb - 1; i++) {
				__ptr__ element1 = array.plus(i);
				__ptr__ element2 = array.plus(i + 1);
				Integer cmp = (Integer) compare.exe(element1, element2);
				System.err.println("cmp=" + cmp);
				if (cmp.intValue() > 0) {
					change = true;
					((StarStar) array).swap(i, i + 1);
				}
			}
		} while (change);
		for (int i = 0; i < nb - 1; i++) {
			__ptr__ element1 = array.plus(i);
			__ptr__ element2 = array.plus(i + 1);
			System.err.println("element1=" + element1);
			System.err.println("element2=" + element2);
			Integer cmp = (Integer) compare.exe(element1, element2);
			System.err.println("cmp=" + cmp);
			if (cmp.intValue() > 0) {
				throw new IllegalStateException();
			}
		}
	}

	private final static CallStack callStack = new CallStack();
	private final static Debug debug = new Debug();

	static public void ENTERING(String signature, String methodName) {
		callStack.entering(signature, methodName);
		debug.entering(signature, methodName);
	}

	static public void LEAVING(String signature, String methodName) {
		callStack.leaving(signature, methodName);
		debug.leaving(signature, methodName);
	}

	static public void printCallStack(File f) throws FileNotFoundException {
		final PrintWriter pw = new PrintWriter(f);
		pw.println("@startuml");
		pw.println("digraph call {");
		pw.println("rankdir=LR;");
		callStack.printCallStack(pw);
		pw.println("}");
		pw.println("@enduml");
		pw.close();
	}

	static public int setjmp(jmp_buf jmp) {
		// if (jmp.hasBeenCalled()) {
		// throw new UnsupportedOperationException();
		// }
		jmp.saveCallingEnvironment();
		return 0;
	}

	public static void printMethods() throws IOException {
		callStack.printMethods();
	}

	// DEBUG

	public static void printDebugEdge(Agedge_s e) {
		System.err.println("*********** PRINT EDGE ********** ");
		final Agedgeinfo_t data = (Agedgeinfo_t) Macro.AGDATA(e).castTo(Agedgeinfo_t.class);
		final splines splines = (splines) data.getPtr("spl");
		__struct__<boxf> bb = splines.getStruct("bb");
		final bezier list = (bezier) splines.getPtr("list");
		System.err.println("splines.size=" + splines.getInt("size"));
		System.err.println("bb.LL=" + pointftoString(bb.getStruct("LL")));
		System.err.println("bb.UR=" + pointftoString(bb.getStruct("UR")));
		printDebugBezier((bezier) splines.getPtr("list").getPtr());

	}

	private static String pointftoString(__struct__<pointf> point) {
		final StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(point.getDouble("x"));
		sb.append(" ; ");
		sb.append(point.getDouble("y"));
		sb.append(")");
		return sb.toString();
	}

	private static void printDebugBezier(bezier bezier) {
		System.err.println("bezier.size=" + bezier.getInt("size"));
		System.err.println("bezier.sflag=" + bezier.getInt("sflag"));
		System.err.println("splines.eflag=" + bezier.getInt("eflag"));
		System.err.println("bezier.sp=" + pointftoString(bezier.getStruct("sp")));
		System.err.println("bezier.ep=" + pointftoString(bezier.getStruct("ep")));
		for (int i = 0; i < bezier.getInt("size"); i++) {
			final __ptr__ pt = bezier.getPtr("list").plus(i).getPtr();
			System.err.println("pt=" + pointftoString(pt));
		}
	}

	private static String pointftoString(__ptr__ point) {
		final StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(point.getDouble("x"));
		sb.append(" ; ");
		sb.append(point.getDouble("y"));
		sb.append(")");
		return sb.toString();
	}

}
