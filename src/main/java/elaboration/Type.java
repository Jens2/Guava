package elaboration;

import grammar.GuavaParser;

import java.util.List;

abstract public class Type {
    public static final Type INT = new Int();
    public static final Type BOOL = new Bool();
    public static final Type CHAR = new Char();
    public static final Type ERROR = new Error();

    private final PrimitiveTypes kind;

    private Type(PrimitiveTypes kind) {
        this.kind = kind;
    }

    public PrimitiveTypes getKind() {
        return this.kind;
    }

    static private class Int extends Type {
        private Int() {
            super(PrimitiveTypes.INT);
        }

        @Override
        public String toString() {
            return "Integer";
        }
    }

    static private class Bool extends Type {
        private Bool() {
            super(PrimitiveTypes.BOOL);
        }

        @Override
        public String toString() {
            return "Bool";
        }
    }

    static private class Char extends Type {
        private Char() {
            super(PrimitiveTypes.CHAR);
        }

        @Override
        public String toString() {
            return "Char";
        }
    }

    static public class Array extends Type {
        private final Type elemType;

        public Array(Type elemType) {
            super(PrimitiveTypes.ARRAY);
            this.elemType = elemType;
        }

        Type getElemType() {
            return this.elemType;
        }

        @Override
        public String toString() {
            return "Array of " + this.elemType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Array)) {
                return false;
            }

            Array other = (Array) obj;
            if (!this.elemType.equals(other.elemType)) {
                return false;
            }

            return true;
        }
    }

    static public class Error extends Type {
        private Error() {
            super(PrimitiveTypes.ERROR);
        }

        @Override
        public String toString() {
            return "Error";
        }
    }
}
