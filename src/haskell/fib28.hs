module Fib28 where

import HardwareTypes
import BasicFunctions
import Sprockell
import System
import Simulation


-- Local variables
n      = 1
result = 2
curr   = 3
prev   = 4
copy   = 5

program :: [Instruction]
program = [ LoadConst 28 regA
          , Store regA (DirAddr n)
          , LoadConst 0 regA
          , Store regA (DirAddr result)
          , Load (DirAddr n) regA
          , LoadConst 1 regB
          , Compute LtE regA regB regC
          , Branch regC (Rel 2)
          , Jump (Rel 4)
          , LoadConst 1 regA
          , Store regA (DirAddr result)
          , Jump (Rel 22)
          , LoadConst 1 regA
          , Store regA (DirAddr curr)
          , LoadConst 1 regA
          , Store regA (DirAddr prev)
          , LoadConst 2 regA
          , Load (DirAddr n) regB
          , Compute Lt regA regB regD
          , Branch regD (Rel 2)
          , Jump (Rel 11)
          , Load (DirAddr curr) regE
          , Store regE (DirAddr copy)
          , Load (DirAddr curr) regF
          , Load (DirAddr prev) regG
          , Compute Add regF regG regH
          , Store regH (DirAddr curr)
          , Load (DirAddr copy) regI
          , Store regI (DirAddr prev)
          , Compute Incr regA reg0 regA
          , Jump (Rel (-12))
          , Load (DirAddr curr) regI
          , Store regI (DirAddr result)
          , ReadInstr (DirAddr 0)
          , Receive regI
          , EndProg ]

testProgram = sysTest [program]
