/*******************************************************************************
 * Copyright (c) 2001, 2012 IBM Corp. and others
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
package j9vm.test.terminate;


public class TerminateTest {

public static void main(String[] args) { 
	/* This test just waits to be killed by TerminateTestRunner.  If the process
		is not terminated within 3 minutes or so, it will print out a failure
		message and (try to) exit normally. */
	
	System.out.println("- - - - - - - - - - - - - -");
	System.out.println("Sacrificial process running");
	System.out.println("- - - - - - - - - - - - - -");
	for (int i = 0; i<180; i++)  {
		try  {
			Thread.sleep(1000);
		} catch (InterruptedException e)  {
			System.out.println("child sleep() interrupted");	
		}
		if ((i % 60) == 59)  {
			System.out.println(".");
		} else {
			System.out.print(".");
		}
	}
	System.out.println("");
	System.out.println("~3 mins but sacrificial process not killed!");
}

}
