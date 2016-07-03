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
program = [ LoadConst 5 regA
          , LoadConst 2 regB
          , Compute Pow regB regA regC
          , EndProg ]

testProgram = sysTest [program]
