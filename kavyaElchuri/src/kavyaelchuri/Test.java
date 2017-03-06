/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuri;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;


/**
 *
 * @author kavya
 */

class $Test{
}

abstract class _Test {}

 class Test {}

final class test {

    test() {

    }
    
    public static void validatePrime() {
   long p = 99; // 'prime number' candidate
   double primeSquareRoot = Math.sqrt(p);
   boolean isPrime = true;
   for (long j = 2; j <= (long) primeSquareRoot; j++) {
     if (p % j == 0) {
     // Print divisors
        System.out.println(j + "x" + p / j);
        isPrime = false;
     }
   }
   System.out.println("Prime number: " + isPrime);
}
    
    



    final public static void main(String []args) {
//        B b = new B();
//C c = new C();
//D d = new D();
//
//A a = d;
String str2 = new String(new char[]{'a','b','c'});

String str = "Java Learners";
  StringBuffer sb = new StringBuffer();
  for(int i=0; i < str.length(); i++)
  sb.append(str.charAt(i));
  System.out.println(sb);



        
        
        Super x = new Super();
Sub y;
y = (Sub) x;

        final int j;
  for (int i = 0; i< j; i++)
  {
    if ( i < j-- )
       System.out.print(  (i*j)  + " ");
  }
  
  
  int sum = 0;
             for (int i = 0, j = 0; i < 5 & j < 5; ++i, j = i + 1)
                 sum += i;
 	     System.out.println(sum);
             
             
             
        if( "Welcome".trim() == "Welcome".trim() )
System.out.println("Equal");
else
System.out.println("Not Equal");
        
        int[] arr = new int[]{1,2,3};
     System.out.println(arr[1]);


         try 
        { 
            return; 
        } 
         catch(Exception e) {
             e.printStackTrace();
         }
        finally 
        {
            System.out.println( "Finally" ); 
        } 
        
//        int x = 0, y = 1, z;
//		if(x) 
//		z = 0;
//		else
//		z = 1;
//		if(y) 
//		 z = 2;
//		else
//		z = 3;
//		System.out.println(z); 	
//
//        validatePrime();
//        int i, j = 0;
//        for (i = 10; i < 0; i--) {
//            j++;
//        }
//        System.out.println(j);
//        switch (j) {
//            case (0):
//                j = j + 1;
//            case (1):
//                j = j + 2;
//                break;
//            case (2):
//                j = j + 3;
//                break;
//            case (10):
//                j = j + 10;
//                break;
//            default:
//                break;
//        }
//        System.out.println(j);

//        int[] arr[] = new int[5][5];
//        boolean t;
//        int i=5;
//        i = ++i;
//        
//        byte x = 4;
//			x = (byte)~x;
//			System.out.println(x);
//			int i,j,k,l=0;
//		k = l++;
//		j = ++k;
//		i = j++;
//		System.out.println(i);	
//                for(int i = 1; i < 3; i++)
//  for(int j = 3; j >= 1; j--)
//     assert i!=j : i; 
//        int i = 0, k = 0;
//
//        k++;
//        boolean t = true;
//        boolean f = false, b;
//        b = (((i++) == 0) || t);
//        
//        System.out.println(k+ " " + i);
//        b = (f || ((i += 2) > 0));
//        System.out.println(i);
    }
}
//public class Test {
//	public static void main(String args[]) {
////            int[] []x[];
////		char c;
////		int i;
////		c = 'A';		// 1
////		i = c;		//2
////		c = i + 1;	//3
////		c++;		//4
////                
//                
//                for(int i = 1; i < 3; i++)
//  for(int j = 3; j >= 1; j--)
//     assert i!=j ; {System.out.print(args);i;} 
//	}
//        
//        
//        
//}
//protected class example {
//	public static void main(String args[]) {
//		String test = "abc";
//		test = test + test;
//		System.out.println(test);
//	}
//	}

//
//class test1 extends test{
//    
//}


 class Account {
  private double balance;
  public Account(double balance) { this.balance = balance; }
  //public Account(){}
  //... getter and setter for balance
}
 class Savings extends Account {
  private double interestRate;
  public Savings(double rate) { super(rate);interestRate = rate; }
}


class Bird {
public static String s = "";
public  static void fly() { System.out.println("In  bird"); s += "fly "; }
 }


 class Hummingbird extends Bird {
   public static void fly() { System.out.println("In Humming bird"); s += "hover "; }
    public static void main(String[] args) {
      Bird b1 = new Bird();
     Bird b2 = new Hummingbird();
     Bird b3 = (Hummingbird)b2;
     Hummingbird b4 = (Hummingbird)b2;

      b2.fly();
      
     System.out.println(s);
 } }


 class Test {
 public static void main(String[] args) {
  Test test = new Test();
  System.out.println(test.setAction3(	
(e) -> e * 2));
 }
 
  double setAction3(T3 t) {
  return t.m(5.5);
 }
}

interface T3 {
 public double m(Double d);
}


// class test1 {
//    public static void main(String args[]) { 
//    String s1 = new String("abc");
//    String s2 = new String("abc");
//    if(s1 == s2)
//        System.out.println(1);
//    else
//        System.out.println(2);
//    if(s1.equals(s2))
//        System.out.println(3);
//    else
//        System.out.println(4);
//    }
//}

class test1
{
	public static void main() 
	{
            int i[][];
	int j[][]; 
	int []k[];
	int l[5][5]; 
	int[][] a; 
	      System.out.println("test");
	}
}


class Test1 implements Runnable
{
public void run(Thread t)
{
System.out.println("Running...");
}
public static void main(String [] args)
{
    Thread thread = new Thread();
new thread(new Test()).start();
}

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

// Class declarations :
class Super {}
class Sub extends Super {}
 
// Reference declarations :


// Class declarations :
interface A {}
class B {}
class C extends B implements A {}
class D implements A {}
 
// Declaration statements :


class Super1
{
 void show() 
 { System.out.println("parent"); }
}

final class Sub1 extends Super1 
{
    public Sub1(){
        
    }
   abstract void show() ;	
  { } 

  public static void main( String[] args )
  {
    Super1 s = new Sub1();
    s.show();
  }  
}


class MyThread extends Thread 
{
 public static void main(String[] args)
 {
  MyThread my = new MyThread();
  Thread t = new Thread(my);
  t.start();
 }
public void run()
{
 for(int i=0; i< 3; i++){
 System.out.println(i+"..");
} } }


public class Test2 implements Runnable
{
  public void run()
  {
    System.out.println("r1 ");
    System.out.println("r2 ");
  }
    
 public static void main( String[] args )
 {
    Thread t = new Thread(new Test2()); 
    t.start();
    System.out.println("m1 ");
    t.join();
    System.out.println("m2 ");
 }
}


class access{
        public int x;
 	static int y;
        void cal(int a, int b){
            x +=  a ;
            y +=  b;
        }        
    }    
    class static_specifier {
        public static void main(String args[])
        {
            access obj1 = new access();
            access obj2 = new access();   
            obj1.x = 0;
            obj1.y = 0;
            obj1.cal(1, 2);
            obj2.x = 0;
            obj2.cal(2, 3);
            System.out.println(obj1.x + " " + obj2.y);     
        }
   }

 class Test3 {
    Test3() { } // line 1
    static void Test3() { this(); } // line 2  
    public static void main(String[] args) { // line 3
      Test(); // line 4
    }
}