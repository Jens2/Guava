module Bank where

import HardwareTypes
import BasicFunctions
import Sprockell
import System
import Simulation

-- Global variables
saldo = 3
x     = 5

-- Local variables
s = 1
k = 2

program :: [Instruction]
program = [ LoadConst 0 regA
          , WriteInstr regA (DirAddr saldo)
          , LoadConst 2 regA
          , WriteInstr regA (DirAddr x)
          , LoadConst 1 regA
          , WriteInstr regA (DirAddr 0)
          , WriteInstr regA (DirAddr 1)
          , WriteInstr regA (DirAddr 2)
          , TestAndSet (DirAddr (saldo + 1))
          , Receive regB
          , Branch regB (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr saldo)
          , Receive regC
          , LoadConst 20 regD
          , Compute Add regC regD regE
          , WriteInstr regE (DirAddr saldo)
          , WriteInstr reg0 (DirAddr (saldo + 1))
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
          , ReadInstr (DirAddr saldo)
          , Receive regA
          , LoadConst 10 regG
          , Compute Add regA regG regD
          , WriteInstr regD (DirAddr saldo)
          , LoadConst 1 regD
          , WriteInstr regD (DirAddr 0)
          , WriteInstr regD (DirAddr 1)
          , WriteInstr regD (DirAddr 2)
          , LoadConst 2 regA
          , Store regA (DirAddr s)
          , ReadInstr (DirAddr 0)
          , Receive regD
          , Compute Equal reg0 regD regD
          , Branch regD (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 1)
          , Receive regD
          , Compute Equal reg0 regD regD
          , Branch regD (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 2)
          , Receive regD
          , Compute Equal reg0 regD regD
          , Branch regD (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 0)
          , Receive regD
          , Compute Equal reg0 regD regD
          , Branch regD (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr 1)
          , Receive regD
          , Compute Equal reg0 regD regD
          , Branch regD (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr 2)
          , Receive regD
          , Compute Equal reg0 regD regD
          , Branch regD (Rel 2)
          , Jump (Rel (-3))
          , LoadConst 1 regD
          , WriteInstr regD (DirAddr 0)
          , WriteInstr regD (DirAddr 1)
          , WriteInstr regD (DirAddr 2)
          , ReadInstr (DirAddr 0)
          , Receive regD
          , EndProg ]


program0 :: [Instruction]
program0 = [ ReadInstr (DirAddr 0)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (saldo + 1))
           , Receive regB
           , Branch regB (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 0 regE
           , LoadConst 23 regC
           , Compute Lt regE regC regD
           , Branch regD (Rel 2)
           , Jump (Rel 8)
           , ReadInstr (DirAddr saldo)
           , Receive regF
           , LoadConst 2 regG
           , Compute Add regF regG regH
           , WriteInstr regH (DirAddr saldo)
           , Compute Incr regE reg0 regE
           , Jump (Rel (-9))
           , WriteInstr reg0 (DirAddr (saldo + 1))
           , WriteInstr reg0 (DirAddr 0)
           , ReadInstr (DirAddr 0)
           , Receive regA
           , Compute Equal reg0 regA regA
           , Branch regA (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 0)
           , ReadInstr (DirAddr 0)
           , Receive regD
           , Compute Equal reg0 regD regD
           , Branch regD (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regD
           , Branch regD (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (saldo + 1))
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 69 regG
           , Store regG (DirAddr k)
           , LoadConst 0 regG
           , LoadConst 8 regE
           , Compute Lt regG regE regC
           , Branch regC (Rel 2)
           , Jump (Rel 8)
           , ReadInstr (DirAddr saldo)
           , Receive regB
           , LoadConst 10 regH
           , Compute Sub regB regH regF
           , WriteInstr regF (DirAddr saldo)
           , Compute Incr regG reg0 regG
           , Jump (Rel (-9))
           , WriteInstr reg0 (DirAddr (saldo + 1))
           , WriteInstr reg0 (DirAddr 0)
           , ReadInstr (DirAddr 0)
           , Receive regD
           , Compute Equal reg0 regD regD
           , Branch regD (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regD
           , EndProg ]


program1 :: [Instruction]
program1 = [ ReadInstr (DirAddr 1)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 0 regB
           , LoadConst 23 regH
           , Compute Lt regB regH regF
           , Branch regF (Rel 2)
           , Jump (Rel 13)
           , TestAndSet (DirAddr (saldo + 1))
           , Receive regG
           , Branch regG (Rel 2)
           , Jump (Rel (-3))
           , ReadInstr (DirAddr saldo)
           , Receive regE
           , LoadConst 2 regC
           , Compute Sub regE regC regD
           , WriteInstr regD (DirAddr saldo)
           , WriteInstr reg0 (DirAddr (saldo + 1))
           , Compute Incr regB reg0 regB
           , Jump (Rel (-14))
           , WriteInstr reg0 (DirAddr 1)
           , ReadInstr (DirAddr 1)
           , Receive regA
           , Compute Equal reg0 regA regA
           , Branch regA (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 1)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 1)
           , ReadInstr (DirAddr 1)
           , Receive regD
           , Compute Equal reg0 regD regD
           , Branch regD (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 1)
           , Receive regD
           , Branch regD (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 1)
           , ReadInstr (DirAddr 1)
           , Receive regD
           , Compute Equal reg0 regD regD
           , Branch regD (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regD
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
           , ReadInstr (DirAddr 2)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 2)
           , ReadInstr (DirAddr 2)
           , Receive regD
           , Compute Equal reg0 regD regD
           , Branch regD (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 2)
           , Receive regD
           , Branch regD (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 2)
           , ReadInstr (DirAddr 2)
           , Receive regD
           , Compute Equal reg0 regD regD
           , Branch regD (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regD
           , EndProg ]

testProgram = sysTest [program, program0, program1, program2]
