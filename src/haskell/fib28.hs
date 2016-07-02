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
          , Load (DirAddr curr) regA
          , Load (DirAddr prev) regB
          , Compute Add regE regB regE
          , Store regE (DirAddr curr)
          , Load (DirAddr copy) regE
          , Store regE (DirAddr prev)
          , Compute Incr regA reg0 regA
          , Jump (Rel (-12))
          , Load (DirAddr curr) regD
          , Store regD (DirAddr result)
          , ReadInstr (DirAddr 0)
          , Receive regD
          , EndProg ]

testProgram = sysTest [program]
