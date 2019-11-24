/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.source.tree;

/**
 * A tree node for a parenthesized expression.  Note: parentheses
 * not be preserved by the parser.
 * <p>
 * For example:
 * <pre>
 *   ( <em>expression</em> )
 * </pre>
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @jls section 15.8.5
 * @since 1.6
 */
public interface ParenthesizedTree extends ExpressionTree {
    ExpressionTree getExpression();
}
