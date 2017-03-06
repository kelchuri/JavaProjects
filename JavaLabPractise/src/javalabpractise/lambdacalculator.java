 interface IntegerMath {
        int operation(int a, int b);   
    }

public class Calculator {
  
   
  
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
 
    public static void main(String... args) {
    
        Calculator myApp = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));  
// can also use lambda directly		myApp.operateBinary(40, 2, (a, b) -> a + b))	
    }
}

/*The method operateBinary performs a mathematical operation on two integer operands. The operation itself is specified by an instance of IntegerMath. The example defines two operations with lambda expressions, addition and subtraction. The example prints the following:

40 + 2 = 42
20 - 10 = 10
*/