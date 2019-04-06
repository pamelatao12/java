package Animal;

public final class Human implements Animal {
	private String name;
	private Pomeranian pompom;

	public Human(String name, Pomeranian pompom) {
		this.name = name;
		this.pompom = pompom;
	}
	
	@Override
	public int numLegs() {
		return 2;
	}

	@Override
	public String speak() {
		return "hi";
	}
	
	public boolean canFart() {
		return true;
	}

	@Override
	public String getName() {
		return name;
	}

}
