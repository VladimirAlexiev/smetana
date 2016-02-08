/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
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
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 *
 *
 *
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
 */
package gen.lib.pathplan;
import h.*;
import smetana.core.*;
import static smetana.core.Macro.*;
import static smetana.core.JUtils.*;
import static gen.lib.cdt.dtclose__c.*;
import static gen.lib.cdt.dtdisc__c.*;
import static gen.lib.cdt.dtextract__c.*;
import static gen.lib.cdt.dtflatten__c.*;
import static gen.lib.cdt.dthash__c.*;
import static gen.lib.cdt.dtlist__c.*;
import static gen.lib.cdt.dtmethod__c.*;
import static gen.lib.cdt.dtopen__c.*;
import static gen.lib.cdt.dtrenew__c.*;
import static gen.lib.cdt.dtrestore__c.*;
import static gen.lib.cdt.dtsize__c.*;
import static gen.lib.cdt.dtstat__c.*;
import static gen.lib.cdt.dtstrhash__c.*;
import static gen.lib.cdt.dttreeset__c.*;
import static gen.lib.cdt.dttree__c.*;
import static gen.lib.cdt.dtview__c.*;
import static gen.lib.cdt.dtwalk__c.*;
import static gen.lib.cgraph.agerror__c.*;
import static gen.lib.cgraph.agxbuf__c.*;
import static gen.lib.cgraph.apply__c.*;
import static gen.lib.cgraph.attr__c.*;
import static gen.lib.cgraph.cmpnd__c.*;
import static gen.lib.cgraph.edge__c.*;
import static gen.lib.cgraph.flatten__c.*;
import static gen.lib.cgraph.grammar__c.*;
import static gen.lib.cgraph.graph__c.*;
import static gen.lib.cgraph.id__c.*;
import static gen.lib.cgraph.imap__c.*;
import static gen.lib.cgraph.io__c.*;
import static gen.lib.cgraph.main__c.*;
import static gen.lib.cgraph.mem__c.*;
import static gen.lib.cgraph.node__c.*;
import static gen.lib.cgraph.obj__c.*;
import static gen.lib.cgraph.pend__c.*;
import static gen.lib.cgraph.rec__c.*;
import static gen.lib.cgraph.refstr__c.*;
import static gen.lib.cgraph.scan__c.*;
import static gen.lib.cgraph.subg__c.*;
import static gen.lib.cgraph.tester__c.*;
import static gen.lib.cgraph.utils__c.*;
import static gen.lib.cgraph.write__c.*;
import static gen.lib.cgraph.y_tab__c.*;
import static gen.lib.circogen.blockpath__c.*;
import static gen.lib.circogen.blocktree__c.*;
import static gen.lib.circogen.block__c.*;
import static gen.lib.circogen.circpos__c.*;
import static gen.lib.circogen.circularinit__c.*;
import static gen.lib.circogen.circular__c.*;
import static gen.lib.circogen.deglist__c.*;
import static gen.lib.circogen.edgelist__c.*;
import static gen.lib.circogen.nodelist__c.*;
import static gen.lib.circogen.nodeset__c.*;
import static gen.lib.common.args__c.*;
import static gen.lib.common.arrows__c.*;
import static gen.lib.common.colxlate__c.*;
import static gen.lib.common.ellipse__c.*;
import static gen.lib.common.emit__c.*;
import static gen.lib.common.geom__c.*;
import static gen.lib.common.globals__c.*;
import static gen.lib.common.htmllex__c.*;
import static gen.lib.common.htmlparse__c.*;
import static gen.lib.common.htmltable__c.*;
import static gen.lib.common.input__c.*;
import static gen.lib.common.intset__c.*;
import static gen.lib.common.labels__c.*;
import static gen.lib.common.memory__c.*;
import static gen.lib.common.ns__c.*;
import static gen.lib.common.output__c.*;
import static gen.lib.common.pointset__c.*;
import static gen.lib.common.postproc__c.*;
import static gen.lib.common.psusershape__c.*;
import static gen.lib.common.routespl__c.*;
import static gen.lib.common.shapes__c.*;
import static gen.lib.common.splines__c.*;
import static gen.lib.common.strcasecmp__c.*;
import static gen.lib.common.strncasecmp__c.*;
import static gen.lib.common.taper__c.*;
import static gen.lib.common.textspan__c.*;
import static gen.lib.common.timing__c.*;
import static gen.lib.common.utils__c.*;
import static gen.lib.common.y_tab__c.*;
import static gen.lib.dotgen.acyclic__c.*;
import static gen.lib.dotgen.aspect__c.*;
import static gen.lib.dotgen.class1__c.*;
import static gen.lib.dotgen.class2__c.*;
import static gen.lib.dotgen.cluster__c.*;
import static gen.lib.dotgen.compound__c.*;
import static gen.lib.dotgen.conc__c.*;
import static gen.lib.dotgen.decomp__c.*;
import static gen.lib.dotgen.dotinit__c.*;
import static gen.lib.dotgen.dotsplines__c.*;
import static gen.lib.dotgen.fastgr__c.*;
import static gen.lib.dotgen.flat__c.*;
import static gen.lib.dotgen.mincross__c.*;
import static gen.lib.dotgen.position__c.*;
import static gen.lib.dotgen.rank__c.*;
import static gen.lib.dotgen.sameport__c.*;
import static gen.lib.dotgen2.decomp__c.*;
import static gen.lib.dotgen2.dotinit__c.*;
import static gen.lib.dotgen2.groups__c.*;
import static gen.lib.dotgen2.level__c.*;
import static gen.lib.dotgen2.minc2__c.*;
import static gen.lib.dotgen2.minc_utils__c.*;
import static gen.lib.dotgen2.ns__c.*;
import static gen.lib.fdpgen.clusteredges__c.*;
import static gen.lib.fdpgen.comp__c.*;
import static gen.lib.fdpgen.dbg__c.*;
import static gen.lib.fdpgen.fdpinit__c.*;
import static gen.lib.fdpgen.grid__c.*;
import static gen.lib.fdpgen.layout__c.*;
import static gen.lib.fdpgen.tlayout__c.*;
import static gen.lib.fdpgen.xlayout__c.*;
import static gen.lib.gvc.gvbuffstderr__c.*;
import static gen.lib.gvc.gvconfig__c.*;
import static gen.lib.gvc.gvcontext__c.*;
import static gen.lib.gvc.gvc__c.*;
import static gen.lib.gvc.gvdevice__c.*;
import static gen.lib.gvc.gvevent__c.*;
import static gen.lib.gvc.gvjobs__c.*;
import static gen.lib.gvc.gvlayout__c.*;
import static gen.lib.gvc.gvloadimage__c.*;
import static gen.lib.gvc.gvplugin__c.*;
import static gen.lib.gvc.gvrender__c.*;
import static gen.lib.gvc.gvtextlayout__c.*;
import static gen.lib.gvc.gvusershape__c.*;
import static gen.lib.gvc.regex_win32__c.*;
import static gen.lib.label.index__c.*;
import static gen.lib.label.node__c.*;
import static gen.lib.label.nrtmain__c.*;
import static gen.lib.label.rectangle__c.*;
import static gen.lib.label.split_q__c.*;
import static gen.lib.label.xlabels__c.*;
import static gen.lib.ortho.fPQ__c.*;
import static gen.lib.ortho.maze__c.*;
import static gen.lib.ortho.ortho__c.*;
import static gen.lib.ortho.partition__c.*;
import static gen.lib.ortho.rawgraph__c.*;
import static gen.lib.ortho.sgraph__c.*;
import static gen.lib.ortho.trapezoid__c.*;
import static gen.lib.pack.ccomps__c.*;
import static gen.lib.pack.pack__c.*;
import static gen.lib.pack.ptest__c.*;
import static gen.lib.pathplan.cvt__c.*;
import static gen.lib.pathplan.inpoly__c.*;
import static gen.lib.pathplan.route__c.*;
import static gen.lib.pathplan.shortestpth__c.*;
import static gen.lib.pathplan.shortest__c.*;
import static gen.lib.pathplan.solvers__c.*;
import static gen.lib.pathplan.triang__c.*;
import static gen.lib.pathplan.util__c.*;
import static gen.lib.pathplan.visibility__c.*;
import static gen.lib.xdot.xdot__c.*;

public class util__c {
//1 baedz5i9est5csw3epz3cv7z
// typedef Ppoly_t Ppolyline_t


//1 7pb9zum2n4wlgil34lvh8i0ts
// typedef double COORD




//3 carluwds75s8h206m05m74b3h
// Ppoly_t copypoly(Ppoly_t argpoly) 
public static Object copypoly(Object... arg) {
UNSUPPORTED("98pcxyqxy9rpxukga9lzhom1l"); // Ppoly_t copypoly(Ppoly_t argpoly)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("dzef9h5fvxtkk8wkn4kn0edc"); //     Ppoly_t rv;
UNSUPPORTED("b17di9c7wgtqm51bvsyxz6e2f"); //     int i;
UNSUPPORTED("cd3pkstbs6ds3ufjvrms7zt87"); //     rv.pn = argpoly.pn;
UNSUPPORTED("7h1rkca2bkbjau89uq44bj6rc"); //     rv.ps = malloc(sizeof(Ppoint_t) * argpoly.pn);
UNSUPPORTED("bc26n5uxrnb6d5gdge4vsdufw"); //     for (i = 0; i < argpoly.pn; i++)
UNSUPPORTED("extja5g4z7gbi72cffs9hjfkz"); // 	rv.ps[i] = argpoly.ps[i];
UNSUPPORTED("v7vqc9l7ge2bfdwnw11z7rzi"); //     return rv;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 74f2l3kbysoz1jx37ybw786si
// void freePath(Ppolyline_t* p) 
public static Object freePath(Object... arg) {
UNSUPPORTED("arisensk81s44uevsoenjkx4k"); // void freePath(Ppolyline_t* p)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("4wfnv6rzlk455oiie96g1328x"); //     free(p->ps);
UNSUPPORTED("bo0y3vz195pcz24vm46pixpb2"); //     free(p);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 b1oegen4vbhrooizaesj0qbc4
// void freepoly(Ppoly_t argpoly) 
public static Object freepoly(Object... arg) {
UNSUPPORTED("37smh22suphf2psfo815rvfa5"); // void freepoly(Ppoly_t argpoly)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("evt1iow9xd0lxmcp9o1ystvr4"); //     free(argpoly.ps);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 4lkt0le495f2sbojevq677n62
// int Ppolybarriers(Ppoly_t ** polys, int npolys, Pedge_t ** barriers, 		  int *n_barriers) 
public static Object Ppolybarriers(Object... arg) {
UNSUPPORTED("6tzncqs5o5i3rjuimqmwkco8c"); // int Ppolybarriers(Ppoly_t ** polys, int npolys, Pedge_t ** barriers,
UNSUPPORTED("1ciabmjyrm3si7ov5e2nq2yre"); // 		  int *n_barriers)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("l9iv7kwx0qdqzyzbm9jzmoeh"); //     Ppoly_t pp;
UNSUPPORTED("ri456px9wye6dag9hjrx9igj"); //     int i, j, k, n, b;
UNSUPPORTED("3qifo11sfcapaabkt29qxeyf3"); //     Pedge_t *bar;
UNSUPPORTED("5479ingjjk6qn2seps3k0btka"); //     n = 0;
UNSUPPORTED("7hu2o6gt6a1x3hz06uqj88mvq"); //     for (i = 0; i < npolys; i++)
UNSUPPORTED("770fj3pnbv37giif1b0tfjafy"); // 	n = n + polys[i]->pn;
UNSUPPORTED("67tf52l267s83r3u3t4vz2fb3"); //     bar = malloc(n * sizeof(Pedge_t));
UNSUPPORTED("5bkjzlhrfwudnhdqvgcum89jk"); //     b = 0;
UNSUPPORTED("409l75vikw9qauilz9d2vztce"); //     for (i = 0; i < npolys; i++) {
UNSUPPORTED("ct16i4ubqpsg61cvvo21el407"); // 	pp = *polys[i];
UNSUPPORTED("86ht42bn8i5wfk2joxg3g8876"); // 	for (j = 0; j < pp.pn; j++) {
UNSUPPORTED("x1ux3l93pwkw8ri2200m18g7"); // 	    k = j + 1;
UNSUPPORTED("e103u6wglmn9dhi7e4a4okoz9"); // 	    if (k >= pp.pn)
UNSUPPORTED("c4bsmdfnwwk5rcxfmp596kqdg"); // 		k = 0;
UNSUPPORTED("elv4yjqfsvkrgr9w336r9pnqp"); // 	    bar[b].a = pp.ps[j];
UNSUPPORTED("98pws89dkn1po2vhy5by2fbxx"); // 	    bar[b].b = pp.ps[k];
UNSUPPORTED("7vp6sv54f23ddwn8k74yzt98"); // 	    b++;
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("d5kgqcba92v9u40uo4kdwuexd"); //     assert(b == n);
UNSUPPORTED("16w4tlbc3naryaamw0wn6jfip"); //     *barriers = bar;
UNSUPPORTED("brj70oj6k1scg3kfvjtk13idx"); //     *n_barriers = n;
UNSUPPORTED("3tcgz4dupb6kw5tdk7n3pca2l"); //     return 1;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 ct6tszngugakbl42zkaqrt7p1
// void make_polyline(Ppolyline_t line, Ppolyline_t* sline) 
public static Object make_polyline(Object... arg) {
UNSUPPORTED("c01vxogao855zs8fe94tpim9g"); // void
UNSUPPORTED("caslgp07xc1rz7m4io9o6y06u"); // make_polyline(Ppolyline_t line, Ppolyline_t* sline)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("69kg050pehcqgm1vozba79nx6"); //     static int isz = 0;
UNSUPPORTED("4fjyhrgkxtd8bira8nmu5i8b3"); //     static Ppoint_t* ispline = 0;
UNSUPPORTED("dzpsknrwv8qkqq20hjnjpjn68"); //     int i, j;
UNSUPPORTED("93m2yes5av2bhu9cbgdvgao05"); //     int npts = 4 + 3*(line.pn-2);
UNSUPPORTED("c0tj1d84o2ebjy9ke6sgke9m8"); //     if (npts > isz) {
UNSUPPORTED("av96wgpkd1n2udjlb9h7j3y3y"); // 	ispline = (ispline? (Ppoint_t*)realloc(ispline,(npts)*sizeof(Ppoint_t)):(Ppoint_t*)malloc((npts)*sizeof(Ppoint_t))); 
UNSUPPORTED("ehmbnzpsz0najunz7f2xuutcf"); // 	isz = npts;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("cjbplkbp2r33l9lxd9f4plw8q"); //     j = i = 0;
UNSUPPORTED("3sl38lopto9lxrp6b54bo2mp9"); //     ispline[j+1] = ispline[j] = line.ps[i];
UNSUPPORTED("1jxyp8hw11938jx60dm71z97j"); //     j += 2;
UNSUPPORTED("6xu6l640dwkn7142pwdqqinwh"); //     i++;
UNSUPPORTED("73ap4ch7ov640gtez9np1qdy"); //     for (; i < line.pn-1; i++) {
UNSUPPORTED("9mzuffh5epf8o14tph3qhs6bb"); // 	ispline[j+2] = ispline[j+1] = ispline[j] = line.ps[i];
UNSUPPORTED("b6bx299910tris4yhn65it5di"); // 	j += 3;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("3sl38lopto9lxrp6b54bo2mp9"); //     ispline[j+1] = ispline[j] = line.ps[i];
UNSUPPORTED("1m0hhl8du9lwz0vqvit6zf4cv"); //     sline->pn = npts;
UNSUPPORTED("bsi255abbfm738aeiyf2i04u8"); //     sline->ps = ispline;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}


}
