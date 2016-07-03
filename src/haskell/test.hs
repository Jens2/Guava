module Test where

import HardwareTypes
import BasicFunctions
import Sprockell
import System
import Simulation


-- Local variables
a = 1
b = 2

program :: [Instruction]
program = [ LoadConst 97 regA
          , Store regA (DirAddr a)
          , Load (DirAddr a) regA
          , LoadConst 98 regB
          , Compute Gt regA regB regC
          , Store regC (DirAddr b)
          , ReadInstr (DirAddr 0)
          , Receive regC
          , EndProg ]

testProgram = sysTest [program]
