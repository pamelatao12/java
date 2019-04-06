package Animal;

public abstract class Dog implements Animal {

	@Override
	public int numLegs() {
		return 4;
	}

	@Override
	public String speak() {
		return "woof";
	}
}
