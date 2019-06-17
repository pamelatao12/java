package RadioRecommender;

public class Station {
	private String name;
	private int id;
	private int length; // length of playlist on this station
	
	public Station(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public String toString() {
		return this.id + ". " + this.name;
	}
	
}
