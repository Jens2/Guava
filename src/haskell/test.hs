module Test where

import HardwareTypes
import BasicFunctions
import Sprockell
import System
import Simulation

-- Global variables
i = 3

program :: [Instruction]
program = [ LoadConst 0 regA
          , WriteInstr regA (DirAddr i)
          , LoadConst 1 regA
          , WriteInstr regA (DirAddr 0)
          , WriteInstr regA (DirAddr 1)
          , WriteInstr regA (DirAddr 2)
          , TestAndSet (DirAddr (i + 1))
          , Receive regB
          , Branch regB (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr i)
          , Receive regC
          , LoadConst 2 regD
          , Compute Add regC regD regE
          , WriteInstr regE (DirAddr i)
          , WriteInstr reg0 (DirAddr (i + 1))
          , ReadInstr (DirAddr 0)
          , Receive regA
          , Compute Equal reg0 regA regA
          , Branch regA (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 1)
          , Receive regA
          , Compute Equal reg0 regA regA
          , Branch regA (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 2)
          , Receive regA
          , Compute Equal reg0 regA regA
          , Branch regA (Rel 2)
          , Jump (Rel (-4))
          , TestAndSet (DirAddr (i + 1))
          , Receive regA
          , Branch regA (Rel 2)
          , Jump (Rel (-3))
          , WriteInstr reg0 (DirAddr (i + 1))
          , ReadInstr (DirAddr 0)
          , Receive regA
          , Compute Equal reg0 regA regA
          , Branch regA (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr 1)
          , Receive regA
          , Compute Equal reg0 regA regA
          , Branch regA (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr 2)
          , Receive regA
          , Compute Equal reg0 regA regA
          , Branch regA (Rel 2)
          , Jump (Rel (-3))
          , EndProg ]


program0 :: [Instruction]
program0 = [ ReadInstr (DirAddr 0)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (i + 1))
           , Receive regB
           , Branch regB (Rel 2)
           , Jump (Rel (-3))
           , ReadInstr (DirAddr i)
           , Receive regE
           , LoadConst 5 regC
           , Compute Add regE regC regD
           , WriteInstr regD (DirAddr i)
           , WriteInstr reg0 (DirAddr (i + 1))
           , WriteInstr reg0 (DirAddr 0)
           , ReadInstr (DirAddr 0)
           , Receive regA
           , Compute Equal reg0 regA regA
           , Branch regA (Rel 2)
           , Jump (Rel (-5))
           , EndProg ]


program1 :: [Instruction]
program1 = [ ReadInstr (DirAddr 1)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 1)
           , ReadInstr (DirAddr 1)
           , Receive regA
           , Compute Equal reg0 regA regA
           , Branch regA (Rel 2)
           , Jump (Rel (-5))
           , EndProg ]


program2 :: [Instruction]
program2 = [ ReadInstr (DirAddr 2)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 2)
           , ReadInstr (DirAddr 2)
           , Receive regA
           , Compute Equal reg0 regA regA
           , Branch regA (Rel 2)
           , Jump (Rel (-5))
           , EndProg ]

testProgram = sysTest [program, program0, program1, program2]
