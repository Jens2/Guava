package instructions;

/**
 * Created by Jens on 15-6-2016.
 *
 */
public class SPRIL {

    /** This class contains all possible instructions. */
    /** Copy value from register to another register */
    static public class REGCOPY {
        private String operation = "RegCopy ";
        public REGCOPY(String reg0, String reg1) {
            operation = operation + reg0 + " " + reg1;
        }
        public String toString() {
            return operation;
        }
    }
    /** Load constant. */
    static public class CONST {
        private String operation = "LoadConst ";
        public CONST(String val, String reg0) {
            operation = operation + Integer.parseInt(val) + " " + reg0;
        }
        public String toString() {
            return operation;
        }
    }
    /** Compute instruction.*/
    static public class COMP {
        private String operation = "Compute ";
        public COMP(Op op, String reg0, String reg1, String reg2) {
            operation = operation + op + " " + reg0 + " " + reg1 + " " + reg2;
        }
        public String toString() {
            return operation;
        }
    }

    /** Load instruction.*/
    static public class LOAD {
        private String operation = "Load ";
        public LOAD(MemAddr m, String addr, String reg) {
            assert !addr.equals("-1");
            operation = operation + "(" + m + " " + addr + ") " + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Store instruction.*/
    static public class STORE {
        private String operation = "Store ";
        public STORE(String reg, MemAddr m, String addr) {
            operation = operation + reg + " (" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Branch instruction.*/
    static public class BRANCH {
        private String operation = "Branch ";
        public BRANCH(String reg, Target t, String addr) {
            operation = operation + reg + " (" + t + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Jump instruction.*/
    static public class JUMP {
        private String operation = "Jump ";
        public JUMP(Target t, String addr) {
            operation = operation + "(" + t + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Push instruction.*/
    static public class PUSH {
        private String operation = "Push ";
        public PUSH(String reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Pop instruction.*/
    static public class POP {
        private String operation = "Pop ";
        public POP(String reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Read instruction.*/
    static public class READ {
        private String operation = "Read ";
        public READ(MemAddr m, String addr) {
            operation = operation + "(" + m + " " + addr + ")";
        }
        public String toString(){
            return operation;
        }
    }

    /** Receive instruction.*/
    static public class RECEIVE {
        private String operation = "Receive ";
        public RECEIVE(String reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Write instruction.*/
    static public class WRITE {
        private String operation = "Write ";
        public WRITE(String reg, MemAddr m, String addr) {
            operation = operation + reg + " (" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** TestAndSet operation.*/
    static public class TAS {
        private String operation = "TestAndSet ";
        public TAS(MemAddr m, String addr) {
            operation = operation + "(" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Nop instruction.*/
    static public class NOP {
        private String operation = "Nop";
        public String toString() {
            return operation;
        }
    }

    /** EndProg instruction.*/
    static public class ENDPROG {
        private String operation = "EndProg";
        public String toString() {
            return operation;
        }
    }
}
