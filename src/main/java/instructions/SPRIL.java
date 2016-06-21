package instructions;

/**
 * Created by Jens on 15-6-2016.
 *
 */
public class SPRIL {

    /** This class contains all possible instructions. */
    /** Compute instruction.*/
    public class COMP {
        private String operation = "Compute ";
        public COMP(Op op, int reg0, int reg1, int reg2) {
            operation = operation + op + " " + reg0 + " " + reg1 + " " + reg2;
        }
        public String toString() {
            return operation;
        }
    }

    /** Load instruction.*/
    public class LOAD {
        private String operation = "Load ";
        public LOAD(MemAddr m, int addr, int reg) {
            operation = operation + "(" + m + " " + addr + ") " + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Store instruction.*/
    public class STORE {
        private String operation = "Store ";
        public STORE(int reg, MemAddr m, int addr) {
            operation = operation + reg + " (" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Branch instruction.*/
    public class BRANCH {
        private String operation = "Branch ";
        public BRANCH(int reg, Target t, int addr) {
            operation = operation + reg + " (" + t + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Jump instruction.*/
    public class JUMP {
        private String operation = "Jump ";
        public JUMP(Target t, int addr) {
            operation = operation + "(" + t + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Push instruction.*/
    public class PUSH {
        private String operation = "Push ";
        public PUSH(int reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Pop instruction.*/
    public class POP {
        private String operation = "Pop ";
        public POP(int reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Read instruction.*/
    public class READ {
        private String operation = "Read ";
        public READ(MemAddr m, int addr) {
            operation = operation + "(" + m + " " + addr + ")";
        }
        public String toString(){
            return operation;
        }
    }

    /** Receive instruction.*/
    public class RECEIVE {
        private String operation = "Receive ";
        public RECEIVE(int reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Write instruction.*/
    public class WRITE {
        private String operation = "Write ";
        public WRITE(int reg, MemAddr m, int addr) {
            operation = operation + reg + " (" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** TestAndSet operation.*/
    public class TAS {
        private String operation = "TestAndSet ";
        public TAS(MemAddr m, int addr) {
            operation = operation + "(" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Nop instruction.*/
    public class NOP {
        private String operation = "Nop";
        public String toString() {
            return operation;
        }
    }

    /** EndProg instruction.*/
    public class ENDPROG {
        private String operation = "EndProg";
        public String toString() {
            return operation;
        }
    }
}
