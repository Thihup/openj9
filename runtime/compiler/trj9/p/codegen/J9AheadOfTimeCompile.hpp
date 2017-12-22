/*******************************************************************************
 * Copyright (c) 2000, 2016 IBM Corp. and others
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

#ifndef J9_PPC_AHEADOFTIMECOMPILE_INCL
#define J9_PPC_AHEADOFTIMECOMPILE_INCL

#ifndef J9_AHEADOFTIMECOMPILE_CONNECTOR
#define J9_AHEADOFTIMECOMPILE_CONNECTOR
namespace J9 { namespace Power { class AheadOfTimeCompile; } }
namespace J9 { typedef J9::Power::AheadOfTimeCompile AheadOfTimeCompileConnector; }
#endif // J9_AHEADOFTIMECOMPILE_CONNECTOR

#include "trj9/codegen/J9AheadOfTimeCompile.hpp"
#include "compile/SymbolReferenceTable.hpp"
#include "p/codegen/PPCAOTRelocation.hpp"

namespace TR { class CodeGenerator; }

/*************************************************************************
 *  Change on this numbering scheme (even only value change) has to be   *
 *  reflected on the cookie map. More importantly, it should be reflected*
 *  on the trampoline setup and PicBuilder requests.                     *
 *************************************************************************/

namespace J9
{

namespace Power
{ 

class OMR_EXTENSIBLE AheadOfTimeCompile : public J9::AheadOfTimeCompile
   {
   public:
   AheadOfTimeCompile(TR::CodeGenerator *cg);

   virtual void     processRelocations();
   virtual uint8_t *initialiseAOTRelocationHeader(TR::IteratedExternalRelocation *relocation);

   private:
   TR::CodeGenerator *_cg;
   static uint32_t _relocationTargetTypeToHeaderSizeMap[TR_NumExternalRelocationKinds];
   };

} // namespace Power

} // namespace J9

#endif
