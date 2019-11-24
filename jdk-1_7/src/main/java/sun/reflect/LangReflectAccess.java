/*
 * Copyright (c) 2001, 2004, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package sun.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * An interface which gives privileged packages Java-level access to
 * internals of java.lang.reflect.
 */

public interface LangReflectAccess {
    /**
     * Creates a new java.lang.reflect.Field. Access checks as per
     * java.lang.reflect.AccessibleObject are not overridden.
     */
    Field newField(Class declaringClass,
                   String name,
                   Class type,
                   int modifiers,
                   int slot,
                   String signature,
                   byte[] annotations);

    /**
     * Creates a new java.lang.reflect.Method. Access checks as per
     * java.lang.reflect.AccessibleObject are not overridden.
     */
    Method newMethod(Class declaringClass,
                     String name,
                     Class[] parameterTypes,
                     Class returnType,
                     Class[] checkedExceptions,
                     int modifiers,
                     int slot,
                     String signature,
                     byte[] annotations,
                     byte[] parameterAnnotations,
                     byte[] annotationDefault);

    /**
     * Creates a new java.lang.reflect.Constructor. Access checks as
     * per java.lang.reflect.AccessibleObject are not overridden.
     */
    <T> Constructor<T> newConstructor(Class<T> declaringClass,
                                      Class[] parameterTypes,
                                      Class[] checkedExceptions,
                                      int modifiers,
                                      int slot,
                                      String signature,
                                      byte[] annotations,
                                      byte[] parameterAnnotations);

    /**
     * Gets the MethodAccessor object for a java.lang.reflect.Method
     */
    MethodAccessor getMethodAccessor(Method m);

    /**
     * Sets the MethodAccessor object for a java.lang.reflect.Method
     */
    void setMethodAccessor(Method m, MethodAccessor accessor);

    /**
     * Gets the ConstructorAccessor object for a
     * java.lang.reflect.Constructor
     */
    ConstructorAccessor getConstructorAccessor(Constructor c);

    /**
     * Sets the ConstructorAccessor object for a
     * java.lang.reflect.Constructor
     */
    void setConstructorAccessor(Constructor c,
                                ConstructorAccessor accessor);

    /**
     * Gets the "slot" field from a Constructor (used for serialization)
     */
    int getConstructorSlot(Constructor c);

    /**
     * Gets the "signature" field from a Constructor (used for serialization)
     */
    String getConstructorSignature(Constructor c);

    /**
     * Gets the "annotations" field from a Constructor (used for serialization)
     */
    byte[] getConstructorAnnotations(Constructor c);

    /**
     * Gets the "parameterAnnotations" field from a Constructor (used for serialization)
     */
    byte[] getConstructorParameterAnnotations(Constructor c);

    //
    // Copying routines, needed to quickly fabricate new Field,
    // Method, and Constructor objects from templates
    //

    /**
     * Makes a "child" copy of a Method
     */
    Method copyMethod(Method arg);

    /**
     * Makes a "child" copy of a Field
     */
    Field copyField(Field arg);

    /**
     * Makes a "child" copy of a Constructor
     */
    <T> Constructor<T> copyConstructor(Constructor<T> arg);
}
