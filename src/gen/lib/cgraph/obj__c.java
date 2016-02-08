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
package gen.lib.cgraph;
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

public class obj__c {
//1 9k44uhd5foylaeoekf3llonjq
// extern Dtmethod_t* 	Dtset


//1 1ahfywsmzcpcig2oxm7pt9ihj
// extern Dtmethod_t* 	Dtbag


//1 anhghfj3k7dmkudy2n7rvt31v
// extern Dtmethod_t* 	Dtoset


//1 5l6oj1ux946zjwvir94ykejbc
// extern Dtmethod_t* 	Dtobag


//1 2wtf222ak6cui8cfjnw6w377z
// extern Dtmethod_t*	Dtlist


//1 d1s1s6ibtcsmst88e3057u9r7
// extern Dtmethod_t*	Dtstack


//1 axa7mflo824p6fspjn1rdk0mt
// extern Dtmethod_t*	Dtqueue


//1 ega812utobm4xx9oa9w9ayij6
// extern Dtmethod_t*	Dtdeque


//1 cyfr996ur43045jv1tjbelzmj
// extern Dtmethod_t*	Dtorder


//1 wlofoiftbjgrrabzb2brkycg
// extern Dtmethod_t*	Dttree


//1 12bds94t7voj7ulwpcvgf6agr
// extern Dtmethod_t*	Dthash


//1 9lqknzty480cy7zsubmabkk8h
// extern Dtmethod_t	_Dttree


//1 bvn6zkbcp8vjdhkccqo1xrkrb
// extern Dtmethod_t	_Dthash


//1 9lidhtd6nsmmv3e7vjv9e10gw
// extern Dtmethod_t	_Dtlist


//1 34ujfamjxo7xn89u90oh2k6f8
// extern Dtmethod_t	_Dtqueue


//1 3jy4aceckzkdv950h89p4wjc8
// extern Dtmethod_t	_Dtstack


//1 8dfqgf3u1v830qzcjqh9o8ha7
// extern Agmemdisc_t AgMemDisc


//1 18k2oh2t6llfsdc5x0wlcnby8
// extern Agiddisc_t AgIdDisc


//1 a4r7hi80gdxtsv4hdoqpyiivn
// extern Agiodisc_t AgIoDisc


//1 bnzt5syjb7mgeru19114vd6xx
// extern Agdisc_t AgDefaultDisc


//1 35y2gbegsdjilegaribes00mg
// extern Agdesc_t Agdirected, Agstrictdirected, Agundirected,     Agstrictundirected


//1 c2rygslq6bcuka3awmvy2b3ow
// typedef Agsubnode_t	Agnoderef_t


//1 xam6yv0dcsx57dtg44igpbzn
// typedef Dtlink_t	Agedgeref_t


//1 6ayavpu39aihwyojkx093pcy3
// extern Agraph_t *Ag_G_global


//1 871mxtg9l6ffpxdl9kniwusf7
// extern char *AgDataRecName


//1 c0o2kmml0tn6hftuwo0u4shwd
// extern Dtdisc_t Ag_subnode_id_disc


//1 8k15pyu256unm2kpd9zf5pf7k
// extern Dtdisc_t Ag_subnode_seq_disc


//1 e3d820y06gpeusn6atgmj8bzd
// extern Dtdisc_t Ag_mainedge_id_disc


//1 cbr0772spix9h1aw7h5v7dv9j
// extern Dtdisc_t Ag_subedge_id_disc


//1 akd0c3v0j7m2npxcb9acit1fa
// extern Dtdisc_t Ag_mainedge_seq_disc


//1 12d8la07351ww7vwfzucjst8m
// extern Dtdisc_t Ag_subedge_seq_disc


//1 29eokk7v88e62g8o6lizmo967
// extern Dtdisc_t Ag_subgraph_id_disc


//1 4xd9cbgy6hk5g6nhjcbpzkx14
// extern Agcbdisc_t AgAttrdisc




//3 6wm1l0y857iajfoa6ywpotkld
// int agdelete(Agraph_t * g, void *obj) 
public static Object agdelete(Object... arg) {
UNSUPPORTED("26js2ch8px4mwz3gqvjehanq1"); // int agdelete(Agraph_t * g, void *obj)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("9w2ooy12wluvhcufehln1sob3"); //     if ((AGTYPE((Agobj_t *) obj) == AGRAPH) && (g != agparent(obj))) {
UNSUPPORTED("8iap36ny5lwbj2qog193slebp"); // 	agerr(AGERR, "agdelete on wrong graph");
UNSUPPORTED("8d9xfgejx5vgd6shva5wk5k06"); // 	return -1;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("bldax4f6o5yyujcnonbszc0kv"); //     switch (AGTYPE((Agobj_t *) obj)) {
UNSUPPORTED("6x7ztvlgv763oeop84udp1egg"); //     case AGNODE:
UNSUPPORTED("4fefei0lku9f461nifc1j9d6j"); // 	return agdelnode(g, obj);
UNSUPPORTED("c9o8hr6x8n5dty1y3eej1fept"); //     case AGINEDGE:
UNSUPPORTED("a6ls4lkgjoheqwo2e7yqt9zz8"); //     case AGOUTEDGE:
UNSUPPORTED("5g9ficurorxyixy3ipj7d410l"); // 	return agdeledge(g, obj);
UNSUPPORTED("eyna33dobiebmtd0nihpgura4"); //     case AGRAPH:
UNSUPPORTED("bbhf83j2cbqobo0q3vhbqmjnt"); // 	return agclose(obj);
UNSUPPORTED("8l3rwj6ctswoa4gvh2j4poq70"); //     default:
UNSUPPORTED("23wxcrpaiuw9ahrx92r6h8z42"); // 	agerr(AGERR, "agdelete on bad object");
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("6z6pjcdqmwle9axtu8m7zzsbc"); //     return 0;		/* not reached */
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 beny4i1ucvryk03o1m3x4mo1o
// int agrename(Agobj_t * obj, char *newname) 
public static Object agrename(Object... arg) {
UNSUPPORTED("7b62oxoln2q7p4wdewli878zt"); // int agrename(Agobj_t * obj, char *newname)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("1dbyk58q3r4fyfxxo7ovemkpu"); //     Agraph_t *g;
UNSUPPORTED("cjioztm3ayr9deoc1btg630su"); //     unsigned long old_id, new_id;
UNSUPPORTED("3kwdmn4ezymvab9oercol2gfj"); //     switch (AGTYPE(obj)) {
UNSUPPORTED("eyna33dobiebmtd0nihpgura4"); //     case AGRAPH:
UNSUPPORTED("6bhsf6u3syvq4i1b3afpo0tcl"); // 	old_id = AGID(obj);
UNSUPPORTED("46q8c52lbrpze2lfwf32dvmxs"); // 	g = agraphof(obj);
UNSUPPORTED("erenne373dge3axb6rjm1fe2n"); // 	/* can we reserve the id corresponding to newname? */
UNSUPPORTED("daa8h6fs7x6psvrayyh4ajdxx"); // 	if (agmapnametoid(agroot(g), AGTYPE(obj), newname,
UNSUPPORTED("6eajcdkt2sqkuzinzzpg892gl"); // 			  &new_id, (0)) == 0)
UNSUPPORTED("aivfd7ajlfz8o8oi68d4u5s5z"); // 	    return -1;
UNSUPPORTED("d0w95irsvkkzxory1vu3oibja"); // 	if (new_id == old_id)
UNSUPPORTED("6f1138i13x0xz1bf1thxgjgka"); // 	    return 0;
UNSUPPORTED("daa8h6fs7x6psvrayyh4ajdxx"); // 	if (agmapnametoid(agroot(g), AGTYPE(obj), newname,
UNSUPPORTED("4nvglmcaimqliy54ir51j81yx"); // 			  &new_id, (!(0))) == 0)
UNSUPPORTED("aivfd7ajlfz8o8oi68d4u5s5z"); // 	    return -1;
UNSUPPORTED("eaoz5g3p9152utcqjz5d2fgdf"); //         /* obj* is unchanged, so no need to re agregister() */
UNSUPPORTED("6vyma7idxllhf3a3xbklkk7kv"); // 	if (agparent(g) && agidsubg(agparent(g), new_id, 0))
UNSUPPORTED("aivfd7ajlfz8o8oi68d4u5s5z"); // 	    return -1;
UNSUPPORTED("192p8yjash0gcaukx3zukgl4h"); // 	agfreeid(g, AGRAPH, old_id);
UNSUPPORTED("beefe1mg4aug53iqxfnua8enw"); // 	AGID(g) = new_id;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("6x7ztvlgv763oeop84udp1egg"); //     case AGNODE:
UNSUPPORTED("73cww6u88cevoi6i0y8rfti15"); // 	return agrelabel_node((Agnode_t *) obj, newname);
UNSUPPORTED("bh5gwywn5664iko5vqzvd45x4"); // 	agrename(obj, newname);
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("c9o8hr6x8n5dty1y3eej1fept"); //     case AGINEDGE:
UNSUPPORTED("a6ls4lkgjoheqwo2e7yqt9zz8"); //     case AGOUTEDGE:
UNSUPPORTED("8d9xfgejx5vgd6shva5wk5k06"); // 	return -1;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("5oxhd3fvp0gfmrmz12vndnjt"); //     return 0;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 c4ft3rxx9au29a2ns2nhod4dn
// void agmethod_init(Agraph_t * g, void *obj) 
public static void agmethod_init(Agraph_s g, __ptr__ obj) {
ENTERING("c4ft3rxx9au29a2ns2nhod4dn","agmethod_init");
try {
    if (g.getPtr("clos").getBoolean("callbacks_enabled"))
	aginitcb(g, obj, (Agcbstack_s) g.getPtr("clos").getPtr("cb"));
    else
	agrecord_callback(g, obj, 100, null);
} finally {
LEAVING("c4ft3rxx9au29a2ns2nhod4dn","agmethod_init");
}
}




//3 eobcsheti70b9gzoi3z968zev
// void aginitcb(Agraph_t * g, void *obj, Agcbstack_t * cbstack) 
public static void aginitcb(Agraph_s g, __ptr__ obj, Agcbstack_s cbstack) {
ENTERING("eobcsheti70b9gzoi3z968zev","aginitcb");
try {
    agobjfn_t fn;
    if (cbstack == null)
	return;
UNSUPPORTED("cv6tr3wc0y2e3s7hrj040fbgz"); //     aginitcb(g, obj, cbstack->prev);
UNSUPPORTED("ugu810574xlbrchajuiqvlbj"); //     fn = ((agobjfn_t)0);
UNSUPPORTED("afk5q8b9fd4sednpczh6r1eg9"); //     switch (((((Agobj_t*)(obj))->tag).objtype)) {
UNSUPPORTED("70xjc0sbkjvexfar5luzibcgf"); //     case 0:
UNSUPPORTED("33rj0o79bxra63omicn33shh1"); // 	fn = cbstack->f->graph.ins;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("d0gk15gzj4wz8nv54zbr285hm"); //     case 1:
UNSUPPORTED("43opp5hvwaad6urofp737fx95"); // 	fn = cbstack->f->node.ins;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("4u5xz2u3urj13y0aw30fdyup5"); //     case 2:
UNSUPPORTED("7k5xv2n0vdcq7e1h7c511n2vt"); // 	fn = cbstack->f->edge.ins;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("b9a2u7luojz68ys0qfhdssxc5"); //     if (fn)
UNSUPPORTED("d6swsvu9o2h2ajgawq3fidg54"); // 	fn(g, obj, cbstack->state);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
} finally {
LEAVING("eobcsheti70b9gzoi3z968zev","aginitcb");
}
}




//3 29p743rx2pw81slkoaayfeael
// void agmethod_upd(Agraph_t * g, void *obj, Agsym_t * sym) 
public static void agmethod_upd(Agraph_s g, __ptr__ obj, Agsym_s sym) {
ENTERING("29p743rx2pw81slkoaayfeael","agmethod_upd");
try {
    if (g.getPtr("clos").getBoolean("callbacks_enabled"))
	agupdcb(g, obj, sym, (Agcbstack_s) g.getPtr("clos").getPtr("cb"));
    else
	agrecord_callback(g, obj, 101, sym);
} finally {
LEAVING("29p743rx2pw81slkoaayfeael","agmethod_upd");
}
}




//3 8t9rkcpdvmxph6krjvfmz3s51
// void agupdcb(Agraph_t * g, void *obj, Agsym_t * sym, Agcbstack_t * cbstack) 
public static void agupdcb(Agraph_s g, __ptr__ obj, Agsym_s sym, Agcbstack_s cbstack) {
ENTERING("8t9rkcpdvmxph6krjvfmz3s51","agupdcb");
try {
    agobjupdfn_t fn;
    if (cbstack == null)
	return;
UNSUPPORTED("7xps60r7235mbe5tshsk48gqu"); //     agupdcb(g, obj, sym, cbstack->prev);
UNSUPPORTED("coxarw2y9j5pc184wun1hzqh4"); //     fn = ((agobjupdfn_t)0);
UNSUPPORTED("afk5q8b9fd4sednpczh6r1eg9"); //     switch (((((Agobj_t*)(obj))->tag).objtype)) {
UNSUPPORTED("70xjc0sbkjvexfar5luzibcgf"); //     case 0:
UNSUPPORTED("edztg04z181ml2fb23vg86p4"); // 	fn = cbstack->f->graph.mod;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("d0gk15gzj4wz8nv54zbr285hm"); //     case 1:
UNSUPPORTED("dt0aez1qarpjppkqak7liv45r"); // 	fn = cbstack->f->node.mod;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("4u5xz2u3urj13y0aw30fdyup5"); //     case 2:
UNSUPPORTED("dw5h49n9x5t8rmlgpk6lvanem"); // 	fn = cbstack->f->edge.mod;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("b9a2u7luojz68ys0qfhdssxc5"); //     if (fn)
UNSUPPORTED("ecckhw6badvki2tacvj1ch4bu"); // 	fn(g, obj, cbstack->state, sym);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
} finally {
LEAVING("8t9rkcpdvmxph6krjvfmz3s51","agupdcb");
}
}




//3 ejz0zke1kl32wjhs6y52llib0
// void agmethod_delete(Agraph_t * g, void *obj) 
public static Object agmethod_delete(Object... arg) {
UNSUPPORTED("6y7r2ytsjwcyj4if496cwdjjp"); // void agmethod_delete(Agraph_t * g, void *obj)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("4rvy8xnzxoccnwfcit2isk96h"); //     if (g->clos->callbacks_enabled)
UNSUPPORTED("ado8gbbdmkf8owwnknnthuzq0"); // 	agdelcb(g, obj, g->clos->cb);
UNSUPPORTED("div10atae09n36x269sl208r1"); //     else
UNSUPPORTED("do5egp79i4bb6mod85t9nr77i"); // 	agrecord_callback(g, obj, 102, ((Agsym_t*)0));
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 78ludy47c4yx2luf78lkk42z8
// void agdelcb(Agraph_t * g, void *obj, Agcbstack_t * cbstack) 
public static Object agdelcb(Object... arg) {
UNSUPPORTED("1r4i928dlzzl0gpzpersr9rt7"); // void agdelcb(Agraph_t * g, void *obj, Agcbstack_t * cbstack)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("f58pg7odheiwpqukdszo4ojxe"); //     agobjfn_t fn;
UNSUPPORTED("evtudqllt7mv38ny577gwtz4q"); //     if (cbstack == ((Agcbstack_t *)0))
UNSUPPORTED("a7fgam0j0jm7bar0mblsv3no4"); // 	return;
UNSUPPORTED("49guj1vkw5luz54hl17unr7cg"); //     agdelcb(g, obj, cbstack->prev);
UNSUPPORTED("ugu810574xlbrchajuiqvlbj"); //     fn = ((agobjfn_t)0);
UNSUPPORTED("3kwdmn4ezymvab9oercol2gfj"); //     switch (AGTYPE(obj)) {
UNSUPPORTED("eyna33dobiebmtd0nihpgura4"); //     case AGRAPH:
UNSUPPORTED("dmw30r6pv5ptb6ffpgbo1hom8"); // 	fn = cbstack->f->graph.del;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("6x7ztvlgv763oeop84udp1egg"); //     case AGNODE:
UNSUPPORTED("c7rd727688cteu7m0deevr0c1"); // 	fn = cbstack->f->node.del;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("2dqikmmb6ag0anvbzo5tybf1r"); //     case AGEDGE:
UNSUPPORTED("ht500g7ljjhniqaq4c7hp6zm"); // 	fn = cbstack->f->edge.del;
UNSUPPORTED("6aw91xzjmqvmtdvt1di23af8y"); // 	break;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("b9a2u7luojz68ys0qfhdssxc5"); //     if (fn)
UNSUPPORTED("d6swsvu9o2h2ajgawq3fidg54"); // 	fn(g, obj, cbstack->state);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 53858x47ifwq7ldf9ukvpdc5r
// Agraph_t *agroot(void* obj) 
public static Agraph_s agroot(__ptr__ obj) {
ENTERING("53858x47ifwq7ldf9ukvpdc5r","agroot");
try {
    switch (AGTYPE(obj)) {
    case AGINEDGE:
    case AGOUTEDGE:
	return (Agraph_s) obj.castTo(Agedge_s.class).getPtr("node").getPtr("root");
    case AGNODE:
	return (Agraph_s) obj.castTo(Agnode_s.class).getPtr("root");
    case AGRAPH:
	return (Agraph_s) obj.castTo(Agraph_s.class).getPtr("root");
    default:			/* actually can't occur if only 2 bit tags */
	System.err.println("agroot of a bad object");
	return null;
    }
} finally {
LEAVING("53858x47ifwq7ldf9ukvpdc5r","agroot");
}
}




//3 brxx6qho8cw09dg7o27lc7c6z
// Agraph_t *agraphof(void *obj) 
public static Agraph_s agraphof(__ptr__ obj) {
ENTERING("brxx6qho8cw09dg7o27lc7c6z","agraphof");
try {
    switch (AGTYPE(obj)) {
    case AGINEDGE:
    case AGOUTEDGE:
    return (Agraph_s) obj.castTo(Agedge_s.class).getPtr("node").getPtr("root").castTo(Agraph_s.class);
    case AGNODE:
    return (Agraph_s) obj.castTo(Agnode_s.class).getPtr("root").castTo(Agraph_s.class);
    case AGRAPH:
	return (Agraph_s) obj.castTo(Agraph_s.class);
    default:			/* actually can't occur if only 2 bit tags */
	System.err.println("agraphof a bad object");
	return null;
    }
} finally {
LEAVING("brxx6qho8cw09dg7o27lc7c6z","agraphof");
}
}




//3 69nqqbr1rod9mgh62okni1oad
// void agpushdisc(Agraph_t * g, Agcbdisc_t * cbd, void *state) 
public static Object agpushdisc(Object... arg) {
UNSUPPORTED("cjczq9f29j6pc2upzc84528li"); // void agpushdisc(Agraph_t * g, Agcbdisc_t * cbd, void *state)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("1zz0va4dgarmwtr54f41ny6ep"); //     Agcbstack_t *stack_ent;
UNSUPPORTED("e78wtj8j0f1j2pj8qkxr6rmah"); //     stack_ent = ((Agcbstack_t*)(agalloc(g,sizeof(Agcbstack_t))));
UNSUPPORTED("l45frjjz3xaewezkndogwwdl"); //     stack_ent->f = cbd;
UNSUPPORTED("a7fydebz14wgtgsdgcbk47xbh"); //     stack_ent->state = state;
UNSUPPORTED("3m8erap924ma44o2eehvy06g9"); //     stack_ent->prev = g->clos->cb;
UNSUPPORTED("5y8aaijkgasby7ijmcat25ch7"); //     g->clos->cb = stack_ent;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 2v86foeia3dqpw9r50vioh1g1
// int agpopdisc(Agraph_t * g, Agcbdisc_t * cbd) 
public static Object agpopdisc(Object... arg) {
UNSUPPORTED("779wduvcdcw9g5ldu82jdwlr0"); // int agpopdisc(Agraph_t * g, Agcbdisc_t * cbd)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("1zz0va4dgarmwtr54f41ny6ep"); //     Agcbstack_t *stack_ent;
UNSUPPORTED("3ytu4cno18uw06z7dh1w52rxb"); //     stack_ent = g->clos->cb;
UNSUPPORTED("811oimiu4ldzfuv78w6eictam"); //     if (stack_ent) {
UNSUPPORTED("csgw4fukha77kldy7blppfigk"); // 	if (stack_ent->f == cbd)
UNSUPPORTED("9ijeaaarq6dcl8wjmum8mpkdl"); // 	    g->clos->cb = stack_ent->prev;
UNSUPPORTED("8k75h069sv2k9b6tgz77dscwd"); // 	else {
UNSUPPORTED("36abb5zemj483qnasuoyx3cm8"); // 	    while (stack_ent && (stack_ent->prev->f != cbd))
UNSUPPORTED("d88q78r1snlry24g7fv6r1s6l"); // 		stack_ent = stack_ent->prev;
UNSUPPORTED("2fiyg59a40jxjgiy8ukb4pl8q"); // 	    if (stack_ent && stack_ent->prev)
UNSUPPORTED("eyr2q7dj98xk08fwf7mna4oab"); // 		stack_ent->prev = stack_ent->prev->prev;
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("b04xm15d95y51ybg4xjc6ldgb"); // 	if (stack_ent) {
UNSUPPORTED("8fbzjhtu9d5u96240285dcdh5"); // 	    agfree(g, stack_ent);
UNSUPPORTED("6f1138i13x0xz1bf1thxgjgka"); // 	    return 0;
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("8azkpi8o0wzdufa90lw8hpt6q"); //     return -1;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 a6xpy2adrht1nhb4hi85ex02s
// void *aggetuserptr(Agraph_t * g, Agcbdisc_t * cbd) 
public static Object aggetuserptr(Object... arg) {
UNSUPPORTED("73eofxl7fdezesezfrckc4bgx"); // void *aggetuserptr(Agraph_t * g, Agcbdisc_t * cbd)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("1zz0va4dgarmwtr54f41ny6ep"); //     Agcbstack_t *stack_ent;
UNSUPPORTED("2yjmkfk0h1wnw98ga8d0tz93x"); //     for (stack_ent = g->clos->cb; stack_ent; stack_ent = stack_ent->prev)
UNSUPPORTED("csgw4fukha77kldy7blppfigk"); // 	if (stack_ent->f == cbd)
UNSUPPORTED("6cih8jl2vq8k0dbeiwp44mpgs"); // 	    return stack_ent->state;
UNSUPPORTED("3fyiqswglr6w96ojb2huillz0"); //     return ((void *)0);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 91ej8cxcc0kzgkg2yk3pdiifs
// int agcontains(Agraph_t* g, void* obj) 
public static Object agcontains(Object... arg) {
UNSUPPORTED("f00633txa6d2hv86sv7ifepbf"); // int agcontains(Agraph_t* g, void* obj)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("6fav2eq8otcpsz36rup4o6aqu"); //     Agraph_t* subg;
UNSUPPORTED("q5u19zhou9itfzxv0l6e5a9p"); //     if (agroot (g) != agroot (obj)) return 0;
UNSUPPORTED("3kwdmn4ezymvab9oercol2gfj"); //     switch (AGTYPE(obj)) {
UNSUPPORTED("eyna33dobiebmtd0nihpgura4"); //     case AGRAPH:
UNSUPPORTED("5fyr1r26q15uog4pl9eo2iohc"); // 	subg = (Agraph_t *) obj;
UNSUPPORTED("8vxyvy38lzpbd83cu26nejaan"); // 	do {
UNSUPPORTED("dqlpdwxfm3o0e4atzaam04f9m"); // 	    if (subg == g) return 1;
UNSUPPORTED("4oqg7vqjjx3n3761fp7f2xld9"); // 	} while ((subg = agparent (subg)));
UNSUPPORTED("c9ckhc8veujmwcw0ar3u3zld4"); // 	return 0;
UNSUPPORTED("okhalz07p4k1n8z38d6gsxae"); //     case AGNODE: 
UNSUPPORTED("a88kb5mtps50qe50k0138pgqo"); //         return (agidnode(g, AGID(obj), 0) != 0);
UNSUPPORTED("8l3rwj6ctswoa4gvh2j4poq70"); //     default:
UNSUPPORTED("f29k5hy3r2iho2i4v0qyo99ul"); //         return (agsubedge(g, (Agedge_t *) obj, 0) != 0);
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 bbe1e9wqmcr8dz9pswpxff0fr
// int agobjkind(void *arg) 
public static int agobjkind(__ptr__ arg) {
ENTERING("bbe1e9wqmcr8dz9pswpxff0fr","agobjkind");
try {
	return AGTYPE(arg);
} finally {
LEAVING("bbe1e9wqmcr8dz9pswpxff0fr","agobjkind");
}
}


}
