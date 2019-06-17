package RadioRecommender;

public class Song {
	private String name;
	private String artist;
	private int id; // length of playlist on this station
	
	public Song(String name, String artist, int id) {
		this.name = name;
		this.artist = artist;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * Returns array of number of times this song is played on each station's playlist
	 * @return array of number of times this song is played on each station's playlist
	 */
	public int[] stationPlays() {
		//TODO
		return new int[0];
	}
	
	/**
	 * Returns an array of length 6 containing statistics about the song
	 * @return array containing statistics about the song
	 */
	public int[] getStatistics() {
		return new int[] {averagePlays(), totalPlays(), mostPlaysStation(), maxPlays(), leastPlaysStation(), minPlays()};
	}
	
	/**
	 * Returns last time step this song was played on the given station
	 * @param stationId - the specified station ID to determine the time this song was last played
	 * @return last time song was played on given station, or 0 if never
	 */
	public int getLastPlayed(int stationId) {
		//TODO
		return 0;
	}
	
	/**
	 * Returns average number of plays of this song on stations that carry it
	 * @return average number of plays of this song on stations that carry it
	 */
	private int averagePlays() {
		
	}
	
	/**
	 * Returns total number of plays across all stations
	 * @return
	 */
	private int totalPlays() {
		
	}
	
	/**
	 * Returns ID of station that plays this song the most
	 * @return
	 */
	private int mostPlaysStation() {
		
	}
	
	/**
	 * Returns maximum number of plays on any one station
	 * @return
	 */
	private int maxPlays() {
		
	}
	
	/**
	 * Returns ID of station that plays this song the least
	 * @return
	 */
	private int leastPlaysStation() {
		
	}
	
	/**
	 * Returns minimum number of plays on any one station (could be zero)
	 * @return
	 */
	private int minPlays() {
		
	}
	
	public String toString() {
		return this.id + ". " + this.artist + " - " + this.name;
	}
}
