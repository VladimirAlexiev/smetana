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
package gen.lib.label;
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

public class index__c {


//3 1rfaqe5urty5uyp5xb2r0idce
// LeafList_t *RTreeNewLeafList(Leaf_t * lp) 
public static Object RTreeNewLeafList(Object... arg) {
UNSUPPORTED("bu04wzk5vh5g14rcm11j6y1bc"); // LeafList_t *RTreeNewLeafList(Leaf_t * lp)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("8mcrniwafqlmy5ysg6jeand6o"); //     LeafList_t *llp;
UNSUPPORTED("3b215c61vcll0rkorzyelp40j"); //     if ((llp = (LeafList_t*)zmalloc(sizeof(LeafList_t)))) {
UNSUPPORTED("48u04cv4b40c0avzy99mdycx5"); // 	llp->leaf = lp;
UNSUPPORTED("bbvk7v1s0z6yw1xdoq99v233w"); // 	llp->next = 0;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("5a1d3zolzdjict0gus6vz04a2"); //     return llp;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 6pvstz7axi8a7saeqe3nrrmg5
// LeafList_t *RTreeLeafListAdd(LeafList_t * llp, Leaf_t * lp) 
public static Object RTreeLeafListAdd(Object... arg) {
UNSUPPORTED("eiwtmfygcnm8i2i38dywdrxvu"); // LeafList_t *RTreeLeafListAdd(LeafList_t * llp, Leaf_t * lp)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("c8jefspkzejjwynx8rg8zejbx"); //     LeafList_t *nlp;
UNSUPPORTED("5whcehr1j26r7aahssfvo2dxa"); //     if (!lp)
UNSUPPORTED("1sxqq75kqdqzr0enoukqqx3m1"); // 	return llp;
UNSUPPORTED("adl5lp3lwoh3u5zssznsdnxms"); //     nlp = RTreeNewLeafList(lp);
UNSUPPORTED("373n3s0slcur0mj477nbkp2z9"); //     nlp->next = llp;
UNSUPPORTED("c398zm44c0kp59y82avlt28qs"); //     return nlp;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 6zraor7x44vrnm19d2igkvow2
// void RTreeLeafListFree(LeafList_t * llp) 
public static Object RTreeLeafListFree(Object... arg) {
UNSUPPORTED("cwsuv5x6hz2atkriag0lyrwpq"); // void RTreeLeafListFree(LeafList_t * llp)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("96shepyp7pgdusod9eu04oqsa"); //     LeafList_t *tlp;
UNSUPPORTED("66etdhvz2fmsepzj2nfiioze9"); //     while (llp->next) {
UNSUPPORTED("aa7iqc08758zwe37qyy2wffec"); // 	tlp = llp->next;
UNSUPPORTED("efbq5hg14ncf3x5du5wro1m6d"); // 	free(llp);
UNSUPPORTED("6qcaq7a673zdej3uu1ke2kz0a"); // 	llp = tlp;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("41smjtwh6jsdofomjdbd76o7j"); //     free(llp);
UNSUPPORTED("b9185t6i77ez1ac587ul8ndnc"); //     return;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 3wss9r0zgt5k06j8ovjv7hq0d
// int RTreeInsert(RTree_t * rtp, Rect_t * r, void *data, Node_t ** n, int level) 
public static Object RTreeInsert(Object... arg) {
UNSUPPORTED("etrjsq5w49uo9jq5pzifohkqw"); // int
UNSUPPORTED("4vefy88zis2pcgmerh9m6nllk"); // RTreeInsert(RTree_t * rtp, Rect_t * r, void *data, Node_t ** n, int level)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("8ey3knwkpac8aeth9v8pxu3jo"); //     /* RTreeInsert(RTree_t*rtp, Rect_t*r, int data, Node_t**n, int level) { */
UNSUPPORTED("pp6gyv6pecd6kik4hoguluwp"); //     register int i;
UNSUPPORTED("bp3fw6x5k0c1muih5wl2fmk9n"); //     register Node_t *newroot;
UNSUPPORTED("k2d14nu7r2g4yefydufxqa6l"); //     Node_t *newnode=0;
UNSUPPORTED("8jhu5fyksz5wgdvvak4rqzjog"); //     Branch_t b;
UNSUPPORTED("1dfkfq72ilaevpylx2giyequh"); //     int result = 0;
UNSUPPORTED("3lp95fcfxfbsb08w5umj6mjxb"); //     assert(r && n);
UNSUPPORTED("jakzrkbz09r9gvlx5yfqsq4t"); //     assert(level >= 0 && level <= (*n)->level);
UNSUPPORTED("1acecsj25mg52d6624llst9la"); //     for (i = 0; i < 2; i++)
UNSUPPORTED("au1dzglobtl3y92py1o59k29w"); // 	assert(r->boundary[i] <= r->boundary[2 + i]);
UNSUPPORTED("21ol6vbghnu1ewovfs645sts7"); //     if (rtp->StatFlag) {
UNSUPPORTED("akhni40ndam0u9c6i7raxw4mp"); // 	if (rtp->Deleting)
UNSUPPORTED("bzb1oqc35evr96528iv16glb0"); // 	    rtp->ReInsertCount++;
UNSUPPORTED("9352ql3e58qs4fzapgjfrms2s"); // 	else
UNSUPPORTED("3kxquse3qg2crme5dzybg9jxe"); // 	    rtp->InsertCount++;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("872g4yc6sa8rtep8wdqiys74d"); //     if (!rtp->Deleting)
UNSUPPORTED("4kv2cwozm6o06e73mjdidn17p"); // 	rtp->RectCount++;
UNSUPPORTED("p721o575619ujgj5774sswe4"); //     if (RTreeInsert2(rtp, r, data, *n, &newnode, level)) {	/* root was split */
UNSUPPORTED("dhd7sfbis7klukcyf8rg2skvp"); // 	if (rtp->StatFlag) {
UNSUPPORTED("2y8kv6b3ysrr61q7tqn76rhhc"); // 	    if (rtp->Deleting)
UNSUPPORTED("dn4oynmx9ugizzs5pkxiyptbi"); // 		rtp->DeTouchCount++;
UNSUPPORTED("5c97f6vfxny0zz35l2bu4maox"); // 	    else
UNSUPPORTED("2u8wpa4w1q7rg14t07bny6p8i"); // 		rtp->InTouchCount++;
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("f1ubx3a7wizvjmsawzdn97nwy"); // 	newroot = RTreeNewNode(rtp);	/* grow a new root, make tree taller */
UNSUPPORTED("cb1h5p8jnxwwzvaoyg1k27xmf"); // 	rtp->NonLeafCount++;
UNSUPPORTED("1611m4hdihz2ns6tzb00du4f"); // 	newroot->level = (*n)->level + 1;
UNSUPPORTED("7abewx8c16vuk9ksc6dh0co53"); // 	b.rect = NodeCover(*n);
UNSUPPORTED("465b8w8j2mnvocx78bsxgs0si"); // 	b.child = *n;
UNSUPPORTED("8lf6tafgpibucjtrng2bzhqt"); // 	AddBranch(rtp, &b, newroot, (void *)0);
UNSUPPORTED("5ncet5h2bsh7p0gqx0zcjk8zs"); // 	b.rect = NodeCover(newnode);
UNSUPPORTED("2iec9n0l9utuq5wm6188trocr"); // 	b.child = newnode;
UNSUPPORTED("8lf6tafgpibucjtrng2bzhqt"); // 	AddBranch(rtp, &b, newroot, (void *)0);
UNSUPPORTED("9kv07evealck0kkd4uos4gkz"); // 	*n = newroot;
UNSUPPORTED("6s4qssw97iu3cy7cu2z00dnd"); // 	// rtp->root = newroot;
UNSUPPORTED("5iff078lko2zs9b2cm7erd5kj"); // 	rtp->EntryCount += 2;
UNSUPPORTED("akq58xm5u8sg03eunssjzl44f"); // 	result = 1;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("e73y2609z2557xahrcvzmcb8e"); //     return result;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 bsc9m7d7qc06m8id896e60lkg
// static int RTreeInsert2(RTree_t * rtp, Rect_t * r, void *data, 	     Node_t * n, Node_t ** new, int level) 
public static Object RTreeInsert2(Object... arg) {
UNSUPPORTED("eyp5xkiyummcoc88ul2b6tkeg"); // static int
UNSUPPORTED("e1c7cm1mq875co9obwzzyyxt"); // RTreeInsert2(RTree_t * rtp, Rect_t * r, void *data,
UNSUPPORTED("4errdslfbv5x54v81wpgk55l7"); // 	     Node_t * n, Node_t ** new, int level)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("d5termnm5bwrhia82rw6jvi00"); //     /*static int */
UNSUPPORTED("12ickqloxyobilus63e3bdi65"); //     /* RTreeInsert2(RTree_t*rtp, Rect_t*r,
UNSUPPORTED("e27l28tilpvjc3y9m1iz6c51k"); //        int data, Node_t*n, Node_t**new, int level) {
UNSUPPORTED("795vpnc8yojryr8b46aidsu69"); //      */
UNSUPPORTED("6crctkpvpno5y1bsv7yuqjnm2"); //     register int i=0;
UNSUPPORTED("8jhu5fyksz5wgdvvak4rqzjog"); //     Branch_t b;
UNSUPPORTED("4dqkrcduvdmv3d5fgv1enjacs"); //     Node_t *n2=0;
UNSUPPORTED("bsrr9pvjfr4ki5il3quxx4rqg"); //     assert(r && n && new);
UNSUPPORTED("5xudi4txe3k13af1mbe43tgbn"); //     assert(level >= 0 && level <= n->level);
UNSUPPORTED("21ol6vbghnu1ewovfs645sts7"); //     if (rtp->StatFlag) {
UNSUPPORTED("akhni40ndam0u9c6i7raxw4mp"); // 	if (rtp->Deleting)
UNSUPPORTED("8k1kgaoa4b2mcye1xthc3f1kf"); // 	    rtp->DeTouchCount++;
UNSUPPORTED("9352ql3e58qs4fzapgjfrms2s"); // 	else
UNSUPPORTED("1um729vqiy3529kbsrzyl9u3y"); // 	    rtp->InTouchCount++;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("6bsiysfcc9wix18ej9zs9z659"); //     /* Still above level for insertion, go down tree recursively */
UNSUPPORTED("4hz5jfabrdewpogbs7ahesjld"); //     if (n->level > level) {
UNSUPPORTED("2sz071aqfm5owiilsfyuw76rn"); // 	i = PickBranch(r, n);
UNSUPPORTED("9qcjfckv31n1pds6m7zevi25p"); // 	if (!RTreeInsert2(rtp, r, data, n->branch[i].child, &n2, level)) {	/* recurse: child was not split */
UNSUPPORTED("8yht6usxlnq2ubp9xeqjz71o"); // 	    n->branch[i].rect = CombineRect(r, &(n->branch[i].rect));
UNSUPPORTED("6f1138i13x0xz1bf1thxgjgka"); // 	    return 0;
UNSUPPORTED("99yufmtztzeyeo68jo3yftbcf"); // 	} else {		/* child was split */
UNSUPPORTED("7evrfdq7uc1smqislqm9d82l6"); // 	    n->branch[i].rect = NodeCover(n->branch[i].child);
UNSUPPORTED("echuth2qnq0o4n5gkzgtu5bgs"); // 	    b.child = n2;
UNSUPPORTED("50z4r9qcomgi4o7vvwq0v0xs"); // 	    b.rect = NodeCover(n2);
UNSUPPORTED("451qw2ioqybj69k9abzvqw4mk"); // 	    rtp->EntryCount++;
UNSUPPORTED("9uz11nbvh6yp6yq2axvo7e0fb"); // 	    return AddBranch(rtp, &b, n, new);
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("3uu0fkl3xw648hn9rehmuq54y"); //     } else if (n->level == level) {	/* at level for insertion. */
UNSUPPORTED("cwtg3er5fpt2rr0k2efjapdmq"); // 	/*Add rect, split if necessary */
UNSUPPORTED("1xql4kr4r981y1whzdo5zavad"); // 	b.rect = *r;
UNSUPPORTED("7w1b5nw2bj3zmo70m9bczwwov"); // 	b.child = (Node_t *) data;
UNSUPPORTED("7476ssw2oyxxzrqtz24g9cecp"); // 	rtp->EntryCount++;
UNSUPPORTED("8gejxq93li6nilezate9nd078"); // 	return AddBranch(rtp, &b, n, new);
UNSUPPORTED("an9bctf9o42m97fmlr7tb3xd5"); //     } else {			/* Not supposed to happen */
UNSUPPORTED("22oqraxnqrjall7fj6pooexmi"); // 	assert((0));
UNSUPPORTED("c9ckhc8veujmwcw0ar3u3zld4"); // 	return 0;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 eybi74pqddw71yno71n1dxch1
// static void FreeListNode(register struct ListNode *p) 
public static Object FreeListNode(Object... arg) {
UNSUPPORTED("enkn7pc4meks3igihpafaoxnl"); // static void FreeListNode(register struct ListNode *p)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("bo0y3vz195pcz24vm46pixpb2"); //     free(p);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 a4tq9skwvzdutka9ei6pbydrk
// int RTreeDelete(RTree_t * rtp, Rect_t * r, void *data, Node_t ** nn) 
public static Object RTreeDelete(Object... arg) {
UNSUPPORTED("dxan13j7zc5tysdskndrhp0jy"); // int RTreeDelete(RTree_t * rtp, Rect_t * r, void *data, Node_t ** nn)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("a12nb5dbhoiu403g443fctkns"); //     /* int */
UNSUPPORTED("db7nkyc7g4zod4pcosw0eosmi"); //     /* RTreeDelete(RTree_t*rtp, Rect_t*r, int data, Node_t**nn) { */
UNSUPPORTED("pp6gyv6pecd6kik4hoguluwp"); //     register int i;
UNSUPPORTED("ben8zsxtpzeiqo8eli2l8uwl0"); //     register Node_t *t;
UNSUPPORTED("5pdj91y3888dsu9aiv163adqi"); //     struct ListNode *reInsertList = (void *)0;
UNSUPPORTED("ej513ottpyeoq8nr5ek3cqnyu"); //     register struct ListNode *e;
UNSUPPORTED("9fgs287rhe40d3q36tlijajk3"); //     assert(r && nn);
UNSUPPORTED("djo1drf8zqgd4dlmtnp8268ma"); //     assert(*nn);
UNSUPPORTED("aickurv6sbkajrl6u32h8s7n0"); //     assert(data >= 0);
UNSUPPORTED("d7p6had3bhs1yux0acgomhxcq"); //     rtp->Deleting = (!(0));
UNSUPPORTED("607lavmustb15rxzq2849utq7"); //     if (!RTreeDelete2(rtp, r, data, *nn, &reInsertList)) {
UNSUPPORTED("78928a78vetdygse25vd6qw33"); // 	/* found and deleted a data item */
UNSUPPORTED("bi6ay2t4s62zfticozlr791yq"); // 	if (rtp->StatFlag)
UNSUPPORTED("aiqjtlu1lbfame9tsdduxksph"); // 	    rtp->DeleteCount++;
UNSUPPORTED("337cl2y5ymgyje4han1uiddia"); // 	rtp->RectCount--;
UNSUPPORTED("dm3fsqsr312twcwr7ejz72sd5"); // 	/* reinsert any branches from eliminated nodes */
UNSUPPORTED("3miqozg3j3sz0440ya0edtkn1"); // 	while (reInsertList) {
UNSUPPORTED("8bi7drdkfhozlzpnr9a8beo9r"); // 	    t = reInsertList->node;
UNSUPPORTED("ehzcswv2o675ah20nlk8ll73b"); // 	    for (i = 0; i < 64; i++) {
UNSUPPORTED("16k4a0oof3m3shq22rp10sufm"); // 		if (t->branch[i].child) {
UNSUPPORTED("4pmqw3ejoeiktbmgw5li4osuk"); // 		    RTreeInsert(rtp, &(t->branch[i].rect),
UNSUPPORTED("jn668g7qkg8vdom23tf6xyua"); // 				/* (int)t->branch[i].child, nn, t->level); */
UNSUPPORTED("cr2tz58k73uenuatj8dllr5e"); // 				t->branch[i].child, nn, t->level);
UNSUPPORTED("3ll931j526x4h3iq2n8lb8npl"); // 		    rtp->EntryCount--;
UNSUPPORTED("6eq5kf0bj692bokt0bixy1ixh"); // 		}
UNSUPPORTED("6t98dcecgbvbvtpycwiq2ynnj"); // 	    }
UNSUPPORTED("a0driook10zxazzgo71kxwf5t"); // 	    e = reInsertList;
UNSUPPORTED("3ycjjmywhr2h58szv9f0c3r67"); // 	    reInsertList = reInsertList->next;
UNSUPPORTED("2l03pg61762f3m81wcifv6o2t"); // 	    RTreeFreeNode(rtp, e->node);
UNSUPPORTED("2nfqlmqqiafmfh2uxj5r72e5z"); // 	    FreeListNode(e);
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("3uomzgqvjm03fwau1petngub8"); // 	/* check for redundant root (not leaf, 1 child) and eliminate */
UNSUPPORTED("crynploao8fgrtf7envjtfdaz"); // 	if ((*nn)->count == 1 && (*nn)->level > 0) {
UNSUPPORTED("a588ej7tdnabye2dhwn96zbay"); // 	    if (rtp->StatFlag)
UNSUPPORTED("4bzchhtuz1r199e9mi0bp1ece"); // 		rtp->ElimCount++;
UNSUPPORTED("6u2n1qlqovrhoecwygc6fuq2c"); // 	    rtp->EntryCount--;
UNSUPPORTED("ehzcswv2o675ah20nlk8ll73b"); // 	    for (i = 0; i < 64; i++) {
UNSUPPORTED("jk2oyzi48hf05v99gu6wc2o2"); // 		if ((t = (*nn)->branch[i].child))
UNSUPPORTED("czyohktf9bkx4udfqhx42f4lu"); // 		    break;
UNSUPPORTED("6t98dcecgbvbvtpycwiq2ynnj"); // 	    }
UNSUPPORTED("5ba1w7saym0g246ykbjnn0qrf"); // 	    RTreeFreeNode(rtp, *nn);
UNSUPPORTED("dnoogjer2v3hmfm7qtw2p4qrv"); // 	    *nn = t;
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("cpwomgmpysmof2uglfr37v494"); // 	rtp->Deleting = (0);
UNSUPPORTED("c9ckhc8veujmwcw0ar3u3zld4"); // 	return 0;
UNSUPPORTED("c07up7zvrnu2vhzy6d7zcu94g"); //     } else {
UNSUPPORTED("cpwomgmpysmof2uglfr37v494"); // 	rtp->Deleting = (0);
UNSUPPORTED("eleqpc2p2r3hvma6tipoy7tr"); // 	return 1;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 bax12o5n6n8s94wnn7cxgn99
// static int RTreeDelete2(RTree_t * rtp, Rect_t * r, void *data, Node_t * n, 	     ListNode_t ** ee) 
public static Object RTreeDelete2(Object... arg) {
UNSUPPORTED("eyp5xkiyummcoc88ul2b6tkeg"); // static int
UNSUPPORTED("dl163ikex89epdeiymlnlhkkt"); // RTreeDelete2(RTree_t * rtp, Rect_t * r, void *data, Node_t * n,
UNSUPPORTED("7cv8lwqbi5i6si9trbnke7zl9"); // 	     ListNode_t ** ee)
UNSUPPORTED("8suowst9wgd6gxhgbdi3h24b7"); // /* static int */
UNSUPPORTED("ap2yhjmvw1l4wh1rujus8t8ef"); // /* RTreeDelete2(RTree_t*rtp, Rect_t*r, int data, Node_t*n, ListNode_t**ee) */
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("pp6gyv6pecd6kik4hoguluwp"); //     register int i;
UNSUPPORTED("9yzorirytkswjf0omka5g4c20"); //     assert(r && n && ee);
UNSUPPORTED("aickurv6sbkajrl6u32h8s7n0"); //     assert(data >= 0);
UNSUPPORTED("btdpzkb56pz41hfftabazxn4s"); //     assert(n->level >= 0);
UNSUPPORTED("c435v08qyezw1xnbv2zrqr3te"); //     if (rtp->StatFlag)
UNSUPPORTED("9qx61yt5qzelxylomit9cn4rv"); // 	rtp->DeTouchCount++;
UNSUPPORTED("5zjfl81difxhf334pznet7o8z"); //     if (n->level > 0) {		/* not a leaf node */
UNSUPPORTED("r6wug9hvutzrx2jp04v9slbe"); // 	for (i = 0; i < 64; i++) {
UNSUPPORTED("9cxgoq0fd8kxz4eymv34vt66k"); // 	    if (n->branch[i].child && Overlap(r, &(n->branch[i].rect))) {
UNSUPPORTED("9c2dxowbn34szo9si1s67zn1d"); // 		if (!RTreeDelete2(rtp, r, data, n->branch[i].child, ee)) {	/*recurse */
UNSUPPORTED("1p8d3xzz5d8g7ach93r5dkfpy"); // 		    if (n->branch[i].child->count >= rtp->MinFill)
UNSUPPORTED("8qc1vxcpq7d0q3d4pt56sagi6"); // 			n->branch[i].rect = NodeCover(n->branch[i].child);
UNSUPPORTED("1pj51sbe7du437gcgun1tdp0c"); // 		    else {	/* not enough entries in child, eliminate child node */
UNSUPPORTED("1mqsg2rc7oaykxyne9jioil3j"); // 			RTreeReInsert(rtp, n->branch[i].child, ee);
UNSUPPORTED("36htmotk6j7fq59vwfp4lanaj"); // 			DisconBranch(n, i);
UNSUPPORTED("614qavwsv6dpxdog4wxkb2op0"); // 			rtp->EntryCount--;
UNSUPPORTED("ad48i843uruoaahfmd2nxb4qv"); // 			if (rtp->StatFlag)
UNSUPPORTED("jk9sg727bbh6mlccfj53sg1m"); // 			    rtp->ElimCount++;
UNSUPPORTED("dkxvw03k2gg9anv4dbze06axd"); // 		    }
UNSUPPORTED("y2l9mpq5754ggnklm39b7wg"); // 		    return 0;
UNSUPPORTED("6eq5kf0bj692bokt0bixy1ixh"); // 		}
UNSUPPORTED("6t98dcecgbvbvtpycwiq2ynnj"); // 	    }
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("eleqpc2p2r3hvma6tipoy7tr"); // 	return 1;
UNSUPPORTED("dppt1v5lkz1rfqbwx4n4xwltd"); //     } else {			/* a leaf node */
UNSUPPORTED("r6wug9hvutzrx2jp04v9slbe"); // 	for (i = 0; i < 64; i++) {
UNSUPPORTED("5g2zznotye25yuclpeyzatgrf"); // 	    if (n->branch[i].child
UNSUPPORTED("dx5d5kpda621ehao92qybpo7n"); // 		&& n->branch[i].child == (Node_t *) data) {
UNSUPPORTED("3nnhyf15i3s8j44ptc0zjxkof"); // 		DisconBranch(n, i);
UNSUPPORTED("cazijll74xx4uxev9qe61vl0h"); // 		rtp->EntryCount--;
UNSUPPORTED("5izxoao5ryte71964f8yjfd5y"); // 		return 0;
UNSUPPORTED("6t98dcecgbvbvtpycwiq2ynnj"); // 	    }
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("eleqpc2p2r3hvma6tipoy7tr"); // 	return 1;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}


}
