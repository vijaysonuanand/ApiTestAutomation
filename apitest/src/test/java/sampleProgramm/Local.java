package sampleProgramm;

public class Local {

        public static void main(String[] args) {
            try {

                methodA();
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage());
                System.out.println("Cause: " + e.getCause());
            }
        }

        public static void methodA() throws Exception {
            try {
                methodB();
            } catch (ArithmeticException e) {
                throw new Exception("Error in method B", e);
            }
        }

        public static void methodB() {
            throw new ArithmeticException("Division by zero in methodB");
        }
    }


