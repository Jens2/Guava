module Test where

import HardwareTypes
import BasicFunctions
import Sprockell
import System
import Simulation

program :: [Instruction]
program = [ LoadConst 10 regA
          , RegCopy regA regB
          , EndProg]

testProgram = sysTest [program]
