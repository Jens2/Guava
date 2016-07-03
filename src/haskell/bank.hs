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
turn  = 12
flag  = 14

-- Local variables
k = 1

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
          , LoadConst 0 regA
          , LoadConst 0 regB
          , WriteInstr regA (DirAddr (flag + 0))
          , WriteInstr regB (DirAddr (flag + 1))
          , LoadConst 1 regA
          , WriteInstr regA (DirAddr 0)
          , WriteInstr regA (DirAddr 1)
          , WriteInstr regA (DirAddr 2)
          , LoadConst 1 regB
          , WriteInstr regB (DirAddr (flag + 0))
          , LoadConst 1 regB
          , WriteInstr regB (DirAddr turn)
          , Load (DirAddr (flag + 1)) regB
          , ReadInstr (DirAddr turn)
          , Receive regC
          , LoadConst 1 regD
          , Compute Equal regC regD regE
          , Compute And regB regE regC
          , Branch regC (Rel 2)
          , Jump (Rel 2)
          , Jump (Rel (-8))
          , ReadInstr (DirAddr saldo)
          , Receive regB
          , LoadConst 13 regE
          , Compute Add regB regE regD
          , WriteInstr regD (DirAddr saldo)
          , LoadConst 0 regD
          , WriteInstr regD (DirAddr (flag + 0))
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
          , LoadConst 10 regF
          , Compute Add regA regF regG
          , WriteInstr regG (DirAddr saldo)
          , LoadConst 1 regG
          , WriteInstr regG (DirAddr 0)
          , WriteInstr regG (DirAddr 1)
          , WriteInstr regG (DirAddr 2)
          , TestAndSet (DirAddr (x + 1))
          , Receive regA
          , Branch regA (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr x)
          , Receive regF
          , LoadConst 58 regI
          , Compute Add regF regI regH
          , WriteInstr regH (DirAddr x)
          , WriteInstr reg0 (DirAddr (x + 1))
          , ReadInstr (DirAddr 0)
          , Receive regG
          , Compute Equal reg0 regG regG
          , Branch regG (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 1)
          , Receive regG
          , Compute Equal reg0 regG regG
          , Branch regG (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 2)
          , Receive regG
          , Compute Equal reg0 regG regG
          , Branch regG (Rel 2)
          , Jump (Rel (-4))
          , ReadInstr (DirAddr 0)
          , Receive regG
          , Compute Equal reg0 regG regG
          , Branch regG (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr 1)
          , Receive regG
          , Compute Equal reg0 regG regG
          , Branch regG (Rel 2)
          , Jump (Rel (-3))
          , ReadInstr (DirAddr 2)
          , Receive regG
          , Compute Equal reg0 regG regG
          , Branch regG (Rel 2)
          , Jump (Rel (-3))
          , LoadConst 1 regG
          , WriteInstr regG (DirAddr 0)
          , WriteInstr regG (DirAddr 1)
          , WriteInstr regG (DirAddr 2)
          , ReadInstr (DirAddr 0)
          , Receive regG
          , EndProg ]


program0 :: [Instruction]
program0 = [ ReadInstr (DirAddr 0)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 1 regD
           , WriteInstr regD (DirAddr (flag + 1))
           , LoadConst 0 regD
           , WriteInstr regD (DirAddr turn)
           , Load (DirAddr (flag + 0)) regD
           , ReadInstr (DirAddr turn)
           , Receive regB
           , LoadConst 0 regE
           , Compute Equal regB reg0 regE
           , Compute And regD regE regB
           , Branch regB (Rel 2)
           , Jump (Rel 2)
           , Jump (Rel (-7))
           , ReadInstr (DirAddr saldo)
           , Receive regD
           , LoadConst 17 regE
           , Compute Add regD regE regE
           , WriteInstr regE (DirAddr saldo)
           , LoadConst 0 regE
           , WriteInstr regE (DirAddr (flag + 1))
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
           , Receive regG
           , Compute Equal reg0 regG regG
           , Branch regG (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regG
           , Branch regG (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (saldo + 1))
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 0 regH
           , LoadConst 8 regF
           , Compute Lt regH regF regI
           , Branch regI (Rel 2)
           , Jump (Rel 8)
           , ReadInstr (DirAddr saldo)
           , Receive regE
           , LoadConst 10 regD
           , Compute Sub regE regD regD
           , WriteInstr regD (DirAddr saldo)
           , Compute Incr regH reg0 regH
           , Jump (Rel (-9))
           , WriteInstr reg0 (DirAddr (saldo + 1))
           , WriteInstr reg0 (DirAddr 0)
           , ReadInstr (DirAddr 0)
           , Receive regG
           , Compute Equal reg0 regG regG
           , Branch regG (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regG
           , EndProg ]


program1 :: [Instruction]
program1 = [ ReadInstr (DirAddr 1)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (saldo + 1))
           , Receive regE
           , Branch regE (Rel 2)
           , Jump (Rel (-3))
           , ReadInstr (DirAddr saldo)
           , Receive regD
           , LoadConst 1 regE
           , Load (ImmValue (-1)) regF
           , Compute Mul regE regF regF
           , Compute NEq regD regF regE
           , Branch regE (Rel 2)
           , Jump (Rel 14)
           , LoadConst 20 regD
           , Store regD (DirAddr k)
           , Load (DirAddr k) regD
           , LoadConst 3 regF
           , Compute Mul regD regF regG
           , Store regG (DirAddr k)
           , ReadInstr (DirAddr saldo)
           , Receive regG
           , Load (DirAddr k) regD
           , Compute Add regG regD regF
           , LoadConst 40 regG
           , Compute Sub regF regG regD
           , WriteInstr regD (DirAddr saldo)
           , WriteInstr reg0 (DirAddr (saldo + 1))
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
           , Receive regG
           , Compute Equal reg0 regG regG
           , Branch regG (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 1)
           , Receive regG
           , Branch regG (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (x + 1))
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , ReadInstr (DirAddr x)
           , Receive regI
           , LoadConst 40 regD
           , Compute Add regI regD regE
           , WriteInstr regE (DirAddr x)
           , WriteInstr reg0 (DirAddr (x + 1))
           , WriteInstr reg0 (DirAddr 1)
           , ReadInstr (DirAddr 1)
           , Receive regG
           , Compute Equal reg0 regG regG
           , Branch regG (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regG
           , EndProg ]


program2 :: [Instruction]
program2 = [ ReadInstr (DirAddr 2)
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 5 regE
           , LoadConst 0 regD
           , Compute GtE regE reg0 regF
           , Branch regF (Rel 2)
           , Jump (Rel 12)
           , TestAndSet (DirAddr (saldo + 1))
           , Receive regG
           , Branch regG (Rel 2)
           , Jump (Rel (-3))
           , ReadInstr (DirAddr saldo)
           , Receive regH
           , Compute Add regH regE regI
           , WriteInstr regI (DirAddr saldo)
           , WriteInstr reg0 (DirAddr (saldo + 1))
           , Compute Decr regE reg0 regE
           , Jump (Rel (-13))
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
           , Receive regG
           , Compute Equal reg0 regG regG
           , Branch regG (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 2)
           , Receive regG
           , Branch regG (Rel 2)
           , Jump (Rel (-3))
           , TestAndSet (DirAddr (name + 5))
           , Receive regA
           , Branch regA (Rel 2)
           , Jump (Rel (-3))
           , LoadConst 65 regE
           , WriteInstr regE (DirAddr (name + 0))
           , LoadConst 65 regE
           , WriteInstr regE (DirAddr (name + 1))
           , LoadConst 65 regE
           , WriteInstr regE (DirAddr (name + 2))
           , LoadConst 65 regE
           , WriteInstr regE (DirAddr (name + 3))
           , WriteInstr reg0 (DirAddr (name + 5))
           , WriteInstr reg0 (DirAddr 2)
           , ReadInstr (DirAddr 2)
           , Receive regG
           , Compute Equal reg0 regG regG
           , Branch regG (Rel 2)
           , Jump (Rel (-5))
           , ReadInstr (DirAddr 0)
           , Receive regG
           , EndProg ]

testProgram = sysTest [program, program0, program1, program2]
