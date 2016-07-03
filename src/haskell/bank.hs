module Bank where

import HardwareTypes
import BasicFunctions
import Sprockell
import System
import Simulation

-- Global variables
saldo = 3
x     = 5
name  = 7

program :: [Instruction]
program = [ LoadConst 0 regA
          , WriteInstr regA (DirAddr saldo)
          , LoadConst 2 regA
          , WriteInstr regA (DirAddr x)
          , LoadConst 98 regA
          , LoadConst 97 regB
          , LoadConst 110 regC
          , LoadConst 107 regD
          , WriteInstr regA (DirAddr (name + 0))
          , WriteInstr regB (DirAddr (name + 1))
          , WriteInstr regC (DirAddr (name + 2))
          , WriteInstr regD (DirAddr (name + 3))
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
          , LoadConst 1 regD
          , Load (ImmValue (-1)) regE
          , Compute Mul regD regE regE
          , Compute NEq regC regE regD
          , Branch regD (Rel 2)
          , Jump (Rel 6)
          , ReadInstr (DirAddr saldo)
          , Receive regC
          , LoadConst 20 regE
          , Compute Add regC regE regF
          , WriteInstr regF (DirAddr saldo)
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
          , LoadConst 10 regC
          , Compute Add regA regC regE
          , WriteInstr regE (DirAddr saldo)
          , LoadConst 1 regE
          , WriteInstr regE (DirAddr 0)
          , WriteInstr regE (DirAddr 1)
          , WriteInstr regE (DirAddr 2)
          , TestAndSet (DirAddr (x + 1))
          , Receive regA
          , Branch regA (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr x)
          , Receive regC
          , LoadConst 58 regH
          , Compute Add regC regH regG
          , WriteInstr regG (DirAddr x)
          , WriteInstr reg0 (DirAddr (x + 1))
          , ReadInstr (DirAddr 0)
          , Receive regE
          , Compute Equal reg0 regE regE
          , Branch regE (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 1)
          , Receive regE
          , Compute Equal reg0 regE regE
          , Branch regE (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 2)
          , Receive regE
          , Compute Equal reg0 regE regE
          , Branch regE (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 0)
          , Receive regE
          , Compute Equal reg0 regE regE
          , Branch regE (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr 1)
          , Receive regE
          , Compute Equal reg0 regE regE
          , Branch regE (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr 2)
          , Receive regE
          , Compute Equal reg0 regE regE
          , Branch regE (Rel 2)
          , Jump (Rel (-3))
          , LoadConst 1 regE
          , WriteInstr regE (DirAddr 0)
          , WriteInstr regE (DirAddr 1)
          , WriteInstr regE (DirAddr 2)
          , ReadInstr (DirAddr 0)
          , Receive regE
          , EndProg ]


program0 :: [Instruction]
program0 = [ ReadInstr (DirAddr 0)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 5 regB
           , LoadConst 0 regF
           , Compute GtE regB reg0 regC
           , Branch regC (Rel 2)
           , Jump (Rel 12)
           , TestAndSet (DirAddr (saldo + 1))
           , Receive regE
           , Branch regE (Rel 2)
           , Jump (Rel (-3))
           , ReadInstr (DirAddr saldo)
           , Receive regG
           , Compute Add regG regB regH
           , WriteInstr regH (DirAddr saldo)
           , WriteInstr reg0 (DirAddr (saldo + 1))
           , Compute Decr regB reg0 regB
           , Jump (Rel (-13))
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
           , Receive regE
           , Compute Equal reg0 regE regE
           , Branch regE (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regE
           , Branch regE (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (saldo + 1))
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 0 regG
           , LoadConst 8 regC
           , Compute Lt regG regC regH
           , Branch regH (Rel 2)
           , Jump (Rel 8)
           , ReadInstr (DirAddr saldo)
           , Receive regB
           , LoadConst 10 regF
           , Compute Sub regB regF regF
           , WriteInstr regF (DirAddr saldo)
           , Compute Incr regG reg0 regG
           , Jump (Rel (-9))
           , WriteInstr reg0 (DirAddr (saldo + 1))
           , WriteInstr reg0 (DirAddr 0)
           , ReadInstr (DirAddr 0)
           , Receive regE
           , Compute Equal reg0 regE regE
           , Branch regE (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regE
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
           , ReadInstr (DirAddr 1)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 1)
           , ReadInstr (DirAddr 1)
           , Receive regE
           , Compute Equal reg0 regE regE
           , Branch regE (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 1)
           , Receive regE
           , Branch regE (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (x + 1))
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , ReadInstr (DirAddr x)
           , Receive regH
           , LoadConst 40 regF
           , Compute Add regH regF regB
           , WriteInstr regB (DirAddr x)
           , WriteInstr reg0 (DirAddr (x + 1))
           , WriteInstr reg0 (DirAddr 1)
           , ReadInstr (DirAddr 1)
           , Receive regE
           , Compute Equal reg0 regE regE
           , Branch regE (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regE
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
           , Receive regE
           , Compute Equal reg0 regE regE
           , Branch regE (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 2)
           , Receive regE
           , Branch regE (Rel 2)
           , Jump (Rel (-3))
           , WriteInstr reg0 (DirAddr 2)
           , ReadInstr (DirAddr 2)
           , Receive regE
           , Compute Equal reg0 regE regE
           , Branch regE (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regE
           , EndProg ]

testProgram = sysTest [program, program0, program1, program2]
