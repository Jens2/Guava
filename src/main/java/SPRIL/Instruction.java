package spril;

/**
 * Created by Jens on 15-6-2016.
 *
 */
public class Instruction {

    /** This class contains all possible instructions. */
    /** Copy value from register to another register */
    static public class RegCopy extends Instruction {
        private String operation = "RegCopy ";
        public RegCopy(String reg0, String reg1) {
            operation = operation + reg0 + " " + reg1;
        }
        public String toString() {
            return operation;
        }
    }

    /** Load constant. */
    static public class LoadConst extends Instruction {
        private String operation = "LoadConst ";
        public LoadConst(String val, String reg0) {
            operation = operation + Integer.parseInt(val) + " " + reg0;
        }
        public String toString() {
            return operation;
        }
    }

    /** Compute instruction.*/
    static public class Compute extends Instruction {
        private String operation = "Compute ";
        public Compute(Op op, String reg0, String reg1, String reg2) {
            operation = operation + op + " " + reg0 + " " + reg1 + " " + reg2;
        }
        public String toString() {
            return operation;
        }
    }

    /** Load instruction.*/
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

    /** Store instruction.*/
    static public class Store extends Instruction {
        private String operation = "Store ";
        public Store(String reg, MemAddr m, String addr) {
            operation = operation + reg + " (" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Branch instruction.*/
    static public class Branch extends Instruction {
        private String operation = "Branch ";
        public Branch(String reg, Target t, String addr) {
            operation = operation + reg + " (" + t + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Jump instruction.*/
    static public class Jump extends Instruction {
        private String operation = "Jump ";
        public Jump(Target t, String addr) {
            operation = operation + "(" + t + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Push instruction.*/
    static public class Push extends Instruction {
        private String operation = "Push ";
        public Push(String reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** Pop instruction.*/
    static public class Pop extends Instruction {
        private String operation = "Pop ";
        public Pop(String reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** ReadInstr instruction.*/
    static public class ReadInstr extends Instruction {
        private String operation = "ReadInstr ";
        public ReadInstr(MemAddr m, String addr) {
            operation = operation + "(" + m + " " + addr + ")";
        }
        public String toString(){
            return operation;
        }
    }

    /** Receive instruction.*/
    static public class Receive extends Instruction {
        private String operation = "Receive ";
        public Receive(String reg) {
            operation = operation + reg;
        }
        public String toString() {
            return operation;
        }
    }

    /** WriteInst instruction.*/
    static public class WriteInst extends Instruction {
        private String operation = "WriteInstr ";
        public WriteInst(String reg, MemAddr m, String addr) {
            operation = operation + reg + " (" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** TestAndSet operation.*/
    static public class TestAndSet extends Instruction {
        private String operation = "TestAndSet ";
        public TestAndSet(MemAddr m, String addr) {
            operation = operation + "(" + m + " " + addr + ")";
        }
        public String toString() {
            return operation;
        }
    }

    /** Nop instruction.*/
    static public class Nop extends Instruction {
        private String operation = "Nop";
        public String toString() {
            return operation;
        }
    }

    /** EndProg instruction.*/
    static public class EndProg extends Instruction {
        private String operation = "EndProg";
        public String toString() {
            return operation;
        }
    }
}
