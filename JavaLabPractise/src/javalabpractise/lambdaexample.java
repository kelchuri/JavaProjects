/*Our goal is to print out all the animals in a list according to some criteria. We’ll show you
how to do this without lambdas to illustrate how lambdas are useful. We start out with the
Animal class:*/
public class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;
	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}
	public boolean canHop() { return canHop; }
	public boolean canSwim() { return canSwim; }
	public String toString() { return species; }
}
/*The Animal class has three instance variables, which are set in the constructor. It has
two methods that get the state of whether the animal can hop or swim. It also has a
toString() method so we can easily identify the Animal in programs.
We plan to write a lot of different checks, so we want an interface. You’ll learn more
about interfaces in the next chapter. For now, it is enough to remember that an interface
specifi es the methods that our class needs to implement:*/

interface CheckTrait {
	boolean test(Animal a);
}

/* first thing we want to check is whether the Animal can hop. We provide
a class that can check this:*/

class CheckIfHopper implements CheckTrait {
	public boolean test(Animal a) {
		return a.canHop();
	}
}
/*is class may seem simple—and it is. This is actually part of the problem that lambdas
solve. Just bear with us for a bit. Now we have everything that we need to write our code to
fi nd the Animals that hop:*/

public class TraditionalSearch {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>(); // list of animals
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));

		print(animals, new CheckIfHopper()); // pass class that does check
		// print(animals, a -> a.canHop());
	}
	private static void print(List<Animal> animals, CheckTrait checker) {
		for (Animal animal : animals) {
			if (checker.test(animal)) // the general check
			System.out.print(animal + " ");
		}
		System.out.println();
	}
}
/*The print() method on line 11 method is very general—it can check for any trait. This
is good design. It shouldn’t need to know what specifi cally we are searching for in order to
print a list of animals.
Now what happens if we want to print the Animals that swim? Sigh. We need to write
another class CheckIfSwims. Granted, it is only a few lines. Then we need to add a new line
under line 9 that instantiates that class. That’s two things just to do another check.
Why can’t we just specify the logic we care about right here? Turns out that we can with
lambda expressions. We could repeat that whole class here and make you fi nd the one line
that changed. Instead, we’ll just show you. We could replace line 49 with the following, which
uses a lambda: print(animals, a -> a.canHop());*/

/* It doesn’t take much imagination to figure how we would add logic to get the Animals
that can swim. We only have to add one line of code—no need for an extra class to do
something simple. Here’s that other line:*/

// print(animals, a -> a.canSwim());

// How about Animals that cannot swim?

//print(animals, a -> ! a.canSwim());

/*The point here is that it is really easy to write code that uses lambdas once you get the
basics in place. This code uses a concept called deferred execution. Deferred execution
means that code is specifi ed now but will run later. In this case, later is when the print()
method calls it.*/



