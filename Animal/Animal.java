package Animal;

/**
 * 
 * @author pamelatao
 *
 */
public interface Animal {

	/**
	 * @return Integer representing the number of legs that the animal has.
	 */
	int numLegs();

	/**
	 * @return String representing the sound the animal makes.
	 */
	String speak();
	
	/**
	 * @return String representing the name of the animal.
	 */
	String getName();
}
