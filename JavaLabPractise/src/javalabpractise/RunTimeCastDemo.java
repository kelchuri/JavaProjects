//Animal (X)  is a super class of Dog (Y)  and Cat (Z)  which //are siblings. Elmo is a toy.

interface Pet {
	void cuddle();
	void dance();
}

class Elmo implements Pet{
}

class Animal{
	void move();
}

class Dog extends Animal implements Pet,Comparable<Dog>{
	void drool();
}
class Cat extends Animal implements Pet,Comparable<Cat>{
	void beLazy();
}
public class RunTimeCastDemo {

	public static void main(String args[]) { 
		Pet p1 = new Dog(); // Dog and Cat implement the Pet interface
		Pet p2 = new Cat();
		p2.cuddle(); 
		p1.cuddle();
		p1.bark() // will not work bark() is defined in dog not in Pet

		Animal  x = new Animal (); 
		Dog  y = new Dog (); 
		Cat  z = new Cat (); 
		Animal  xy = new Dog(); // compiles ok (up the hierarchy) 
		Animal  xz = new Cat(); // compiles ok (up the hierarchy) 
		// Dog  yz = new Cat(); incompatible type (siblings) 
		// Dog  y1 = new Animal (); Animal  is not a Dog  
		// Cat  z1 = new Animal (); Animal  is not a Cat  
		Animal  x1 = y; // compiles ok (y is subclass of Animal ) 
		Animal  x2 = z; // compiles ok (z is subclass of Animal ) 



		if (xy instanceof Dog){
			Dog  y1 = (Dog ) xy; // compiles ok 
		}
		Cat  z1 = (Cat ) x; // compiles ok but produces runtime error 
		Dog  y2 = (Dog ) x1; // compiles and runs ok (x1 is type Dog ) 
		Cat  z2 = (Cat ) x2; // compiles and runs ok (x2 is type Cat ) 
		// Dog  y3 = (Dog ) z; inconvertible types (siblings) 
		// Cat  z3 = (Cat ) y; inconvertible types (siblings) 
		Object o = z; 
		Object o1 = (Dog ) o; // compiles ok but produces runtime error
	} 
} 


static void allDance(Pet[] p){
	
	for(i=0;i < p.length;i++){
		p[i].dance();
		p[i].cuddle();
		if (p[i] instanceof Dog)
		((Dog) p[i]).drool();
		if (p[i] instanceof Cat)
		((Cat) a[i]).beLazy();
	}
}

static void allMove(Animal[] a){
	
	for(i=0;i < a.length;i++){
		a[i].move();
		if (a[i] instanceof Dog)
		((Dog) a[i]).drool();
		if (a[i] instanceof Cat)
		((Cat) a[i]).beLazy();
	}
}

