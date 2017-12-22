/*******************************************************************************
 * Copyright (c) 2004, 2017 IBM Corp. and others
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution and is available at https://www.eclipse.org/legal/epl-2.0/
 * or the Apache License, Version 2.0 which accompanies this distribution and
 * is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following
 * Secondary Licenses when the conditions for such availability set
 * forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
 * General Public License, version 2 with the GNU Classpath
 * Exception [1] and GNU General Public License, version 2 with the
 * OpenJDK Assembly Exception [2].
 *
 * [1] https://www.gnu.org/software/classpath/license.html
 * [2] http://openjdk.java.net/legal/assembly-exception.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
 *******************************************************************************/

abstract class TestCondition {
	static final int SUCCESS = 0;
	static final int FAILURE = 1;
	static final int REQUIRED = 2;

	protected static int parseType( String s ) {
		if (s == null || s.equalsIgnoreCase("success")) {
			return SUCCESS;
		} else if (s.equalsIgnoreCase("failure")) {
			return FAILURE;
		} else if (s.equalsIgnoreCase("required")) {
			return REQUIRED;
		}
		return SUCCESS;
	}
	
	abstract int getType();
	abstract boolean match( Object o );
	public abstract String toString();
}
