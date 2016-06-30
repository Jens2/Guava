package spril;

public class Instruction {

    /**
     * Copy value from reg1 to reg2
     */
    static public class RegCopy extends Instruction {
        private String operation = "RegCopy ";
        public RegCopy(String reg0, String reg1) {
            operation = operation + reg0 + " " + reg1;
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Store immediate value in reg1
     */
    static public class LoadConst extends Instruction {
        private String operation = "LoadConst ";
        public LoadConst(String val, String reg0) {
            operation = operation + Integer.parseInt(val) + " " + reg0;
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Perform computation 'op' to reg1 and reg2 and save result in reg3
     */
    static public class Compute extends Instruction {
        private String operation = "Compute ";
        public Compute(Op op, String reg0, String reg1, String reg2) {
            operation = operation + op + " " + reg0 + " " + reg1 + " " + reg2;
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Load value from mem1 into reg1
     */
    static public class Load extends Instruction {
        private String operation = "Load ";
        public Load(MemAddr m, String addr, String reg) {
            assert !addr.equals("-1");
            operation = operation + "(" + m + " " + addr + ") " + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Store value from reg1 in mem1
     */
    static public class Store extends Instruction {
        private String operation = "Store ";
        public Store(String reg, MemAddr m, String addr) {
            operation = operation + reg + " (" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Branch if reg1 == True
     */
    static public class Branch extends Instruction {
        private String operation = "Branch ";
        public Branch(String reg, Target t, String addr) {
            operation = operation + reg + " (" + t + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Jump
     */
    static public class Jump extends Instruction {
        private String operation = "Jump ";
        public Jump(Target t, String addr) {
            operation = operation + "(" + t + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Send request to read shared_mem1
     */
    static public class ReadInstr extends Instruction {
        private String operation = "ReadInstr ";
        public ReadInstr(MemAddr m, String addr) {
            operation = operation + "(" + m + " " + addr + ")";
        }
        public String toString(){
            return operation;
        }
    }

    /**
     * Receive value from shared_mem in reg1
     */
    static public class Receive extends Instruction {
        private String operation = "Receive ";
        public Receive(String reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Write to shared_mem1
     */
    static public class WriteInst extends Instruction {
        private String operation = "WriteInstr ";
        public WriteInst(String reg, MemAddr m, String addr) {
            operation = operation + reg + " (" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * TestAndSet
     */
    static public class TestAndSet extends Instruction {
        private String operation = "TestAndSet ";
        public TestAndSet(MemAddr m, String addr) {
            operation = operation + "(" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /**
     * Nop
     */
    static public class Nop extends Instruction {
        private String operation = "Nop";
        public String toString() {
            return operation;
        }
    }

    /**
     * EndProg
     */
    static public class EndProg extends Instruction {
        private String operation = "EndProg";
        public String toString() {
            return operation;
        }
    }
}
