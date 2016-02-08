#line 1 "graphviz-2.38.0\\lib\\cdt\\dtmethod.c" 1
#line 1 "graphviz-2.38.0\\lib\\cdt\\dthdr.h" 1






/*	Internal definitions for libcdt.
**	Written by Kiem-Phong Vo (5/25/96)
*/




#line 1 "graphviz-2.38.0\\lib\\cdt\\dthdr.h" 1


#line 1 "graphviz-2.38.0\\lib\\cdt\\cdt.h" 1



/*	Public interface for the dictionary library
**
**      Written by Kiem-Phong Vo
*/











#line 1 "graphviz-2.38.0\\lib\\cdt\\cdt.h" 1
#line 1 "graphviz-2.38.0\\lib\\cdt\\cdt.h" 1






















typedef struct _dtlink_s	Dtlink_t;
typedef struct _dthold_s	Dthold_t;
typedef struct _dtdisc_s	Dtdisc_t;
typedef struct _dtmethod_s	Dtmethod_t;
typedef struct _dtdata_s	Dtdata_t;
typedef struct _dt_s		Dt_t;
typedef struct _dt_s		Dict_t;	/* for libdict compatibility */
typedef struct _dtstat_s	Dtstat_t;
typedef void*			(*Dtmemory_f)(Dt_t*,void*,size_t,Dtdisc_t*);
typedef void*			(*Dtsearch_f)(Dt_t*,void*,int);
typedef void* 		(*Dtmake_f)(Dt_t*,void*,Dtdisc_t*);
typedef void 			(*Dtfree_f)(Dt_t*,void*,Dtdisc_t*);
typedef int			(*Dtcompar_f)(Dt_t*,void*,void*,Dtdisc_t*);
typedef unsigned int		(*Dthash_f)(Dt_t*,void*,Dtdisc_t*);
typedef int			(*Dtevent_f)(Dt_t*,int,void*,Dtdisc_t*);

struct _dtlink_s
{	Dtlink_t*	right;	/* right child		*/
	union
	{ unsigned int	_hash;	/* hash value		*/
	  Dtlink_t*	_left;	/* left child		*/
	} hl;
};

/* private structure to hold an object */
struct _dthold_s
{	Dtlink_t	hdr;	/* header		*/
	void*		obj;	/* user object		*/
};

/* method to manipulate dictionary structure */
struct _dtmethod_s 
{	Dtsearch_f	searchf; /* search function	*/
	int		type;	/* type of operation	*/
};

/* stuff that may be in shared memory */
struct _dtdata_s
{	int		type;	/* type of dictionary			*/
	Dtlink_t*	here;	/* finger to last search element	*/
	union
	{ Dtlink_t**	_htab;	/* hash table				*/
	  Dtlink_t*	_head;	/* linked list				*/
	} hh;
	int		ntab;	/* number of hash slots			*/
	int		size;	/* number of objects			*/
	int		loop;	/* number of nested loops		*/
	int		minp;	/* min path before splay, always even	*/
				/* for hash dt, > 0: fixed table size 	*/
};

/* structure to hold methods that manipulate an object */
struct _dtdisc_s
{	int		key;	/* where the key begins in an object	*/
	int		size;	/* key size and type			*/
	int		link;	/* offset to Dtlink_t field		*/
	Dtmake_f	makef;	/* object constructor			*/
	Dtfree_f	freef;	/* object destructor			*/
	Dtcompar_f	comparf;/* to compare two objects		*/
	Dthash_f	hashf;	/* to compute hash value of an object	*/
	Dtmemory_f	memoryf;/* to allocate/free memory		*/
	Dtevent_f	eventf;	/* to process events			*/
};













/* the dictionary structure itself */
struct _dt_s
{	Dtsearch_f	searchf;/* search function			*/
	Dtdisc_t*	disc;	/* method to manipulate objs		*/
	Dtdata_t*	data;	/* sharable data			*/
	Dtmemory_f	memoryf;/* function to alloc/free memory	*/
	Dtmethod_t*	meth;	/* dictionary method			*/
	int		type;	/* type information			*/
	int		nview;	/* number of parent view dictionaries	*/
	Dt_t*		view;	/* next on viewpath			*/
	Dt_t*		walk;	/* dictionary being walked		*/
	void*		user;	/* for user's usage			*/
};

/* structure to get status of a dictionary */
struct _dtstat_s
{	int	dt_meth;	/* method type				*/
	int	dt_size;	/* number of elements			*/
	int	dt_n;		/* number of chains or levels		*/
	int	dt_max;		/* max size of a chain or a level	*/
	int*	dt_count;	/* counts of chains or levels by size	*/
};

/* flag set if the last search operation actually found the object */


/* supported storage methods */










/* asserts to dtdisc() */



/* types of search */















/* events */








1	/* public data */







extern Dtmethod_t* 	Dtset;
extern Dtmethod_t* 	Dtbag;
extern Dtmethod_t* 	Dtoset;
extern Dtmethod_t* 	Dtobag;
extern Dtmethod_t*	Dtlist;
extern Dtmethod_t*	Dtstack;
extern Dtmethod_t*	Dtqueue;
extern Dtmethod_t*	Dtdeque;

/* compatibility stuff; will go away */

extern Dtmethod_t*	Dtorder;
extern Dtmethod_t*	Dttree;
extern Dtmethod_t*	Dthash;
extern Dtmethod_t	_Dttree;
extern Dtmethod_t	_Dthash;
extern Dtmethod_t	_Dtlist;
extern Dtmethod_t	_Dtqueue;
extern Dtmethod_t	_Dtstack;





1	/* public functions */




extern Dt_t*		dtopen (Dtdisc_t*, Dtmethod_t*);
extern int		dtclose (Dt_t*);
extern Dt_t*		dtview (Dt_t*, Dt_t*);
extern Dtdisc_t*	dtdisc (Dt_t* dt, Dtdisc_t*, int);
extern Dtmethod_t*	dtmethod (Dt_t*, Dtmethod_t*);

extern Dtlink_t*	dtflatten (Dt_t*);
extern Dtlink_t*	dtextract (Dt_t*);
extern int		dtrestore (Dt_t*, Dtlink_t*);

extern int		dttreeset (Dt_t*, int, int);

extern int		dtwalk (Dt_t*, int(*)(Dt_t*,void*,void*), void*);

extern void*		dtrenew (Dt_t*, void*);

extern int		dtsize (Dt_t*);
extern int		dtstat (Dt_t*, Dtstat_t*, int);
extern unsigned int	dtstrhash (unsigned int, void*, int);











/* internal functions for translating among holder, object and key */












/* special search function for tree structure only */

























































#line 11 "graphviz-2.38.0\\lib\\cdt\\dthdr.h" 2

/* short-hand notations */








/* this must be disjoint from DT_METHODS */



/* how the Dt_t handle was allocated */



/* max search length before splaying */


/* hash start size and load factor */








/* tree rotation/linking functions */









1
extern void*	malloc (size_t);
extern void*	realloc (void*, size_t);
extern void	free (void*);




#line 3 "graphviz-2.38.0\\lib\\cdt\\dtmethod.c" 2

/*	Change search method.
**
**	Written by Kiem-Phong Vo (05/25/96)
*/


Dtmethod_t* dtmethod(Dt_t* dt, Dtmethod_t* meth)





{
	register Dtlink_t	*list, *r;
	register Dtdisc_t*	disc = dt->disc;
	register Dtmethod_t*	oldmeth = dt->meth;

	if(!meth || meth->type == oldmeth->type)
		return oldmeth;

	if(disc->eventf &&
	   (*disc->eventf)(dt,4,(void*)meth,disc) < 0)
		return ((Dtmethod_t*)0);

	dt->data->minp = 0;

	/* get the list of elements */
	list = dtflatten(dt);

	if(dt->data->type&(0000020|0000040|0000100) )
		dt->data->hh._head = ((Dtlink_t*)0);
	else if(dt->data->type&(0000001|0000002) )
	{	if(dt->data->ntab > 0)
			(*dt->memoryf)(dt,(void*)dt->data->hh._htab,0,disc);
		dt->data->ntab = 0;
		dt->data->hh._htab = ((Dtlink_t**)0);
	}

	dt->data->here = ((Dtlink_t*)0);
	dt->data->type = (dt->data->type&~(0000377|010000)) | meth->type;
	dt->meth = meth;
	if(dt->searchf == oldmeth->searchf)
		dt->searchf = meth->searchf;

	if(meth->type&(0000020|0000040|0000100) )
	{	if(!(oldmeth->type&(0000020|0000040|0000100)) )
		{	if((r = list) )
			{	register Dtlink_t*	t;
				for(t = r->right; t; r = t, t = t->right )
					t->hl._left = r;
				list->hl._left = r;
			}
		}
		dt->data->hh._head = list;
	}
	else if(meth->type&(0000004|0000010))
	{	dt->data->size = 0;
		while(list)
		{	r = list->right;
			(*meth->searchf)(dt,(void*)list,0000040);
			list = r;
		}
	}
	else if(!((meth->type&0000002) && (oldmeth->type&0000001)) )
	{	int	rehash;
		if((meth->type&(0000001|0000002)) && !(oldmeth->type&(0000001|0000002)))
			rehash = 1;
		else	rehash = 0;

		dt->data->size = dt->data->loop = 0;
		while(list)
		{	r = list->right;
			if(rehash)
			{	register void* key = (disc->link < 0 ? ((Dthold_t*)(list))->obj : (void*)((char*)(list) - disc->link) );
				key = (void*)(disc->size < 0 ? *((char**)((char*)(key)+disc->key)) : ((char*)(key)+disc->key));
				list->hl._hash = (disc->hashf ? (*disc->hashf)(dt,key,disc) : dtstrhash(0,key,disc->size) );
			}
			(void)(*meth->searchf)(dt,(void*)list,0000040);
			list = r;
		}
	}

	return oldmeth;
}
