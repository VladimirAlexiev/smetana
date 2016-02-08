#line 1 "graphviz-2.38.0\\lib\\common\\memory.c" 1
/* $Id$ $Revision$ */
/* vim:set shiftwidth=4 ts=8: */

/*************************************************************************
 * Copyright (c) 2011 AT&T Intellectual Property 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: See CVS logs. Details at http://www.graphviz.org/
 *************************************************************************/


#line 1 "graphviz-2.38.0\\lib\\common\\memory.c" 1


#line 1 "graphviz-2.38.0\\lib\\common\\memory.c" 1
#line 1 "graphviz-2.38.0\\lib\\common\\memory.c" 1
#line 1 "graphviz-2.38.0\\lib\\common\\memory.h" 1
/* $Id$ $Revision$ */
/* vim:set shiftwidth=4 ts=8: */

/*************************************************************************
 * Copyright (c) 2011 AT&T Intellectual Property 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: See CVS logs. Details at http://www.graphviz.org/
 *************************************************************************/




#line 1 "graphviz-2.38.0\\lib\\common\\memory.h" 1










































    extern void *zmalloc(size_t);
    extern void *zrealloc(void *, size_t, size_t, size_t);
    extern void *gmalloc(size_t);
	extern void *grealloc(void *, size_t);







#line 20 "graphviz-2.38.0\\lib\\common\\memory.c" 2

void *zmalloc(size_t nbytes)
{
    char *rv;
    if (nbytes == 0)
	return 0;
    rv = gmalloc(nbytes);
    memset(rv, 0, nbytes);
    return rv;
}

void *zrealloc(void *ptr, size_t size, size_t elt, size_t osize)
{
    void *p = realloc(ptr, size * elt);
    if (p == NULL && size) {
	fprintf(stderr, "out of memory\n");
	return p;
    }
    if (osize < size)
	memset((char *) p + (osize * elt), '\0', (size - osize) * elt);
    return p;
}

void *gmalloc(size_t nbytes)
{
    char *rv;
    if (nbytes == 0)
	return NULL;
    rv = malloc(nbytes);
    if (rv == NULL) {
	fprintf(stderr, "out of memory\n");
    }
    return rv;
}

void *grealloc(void *ptr, size_t size)
{
    void *p = realloc(ptr, size);
    if (p == NULL && size) {
	fprintf(stderr, "out of memory\n");
    }
    return p;
}
