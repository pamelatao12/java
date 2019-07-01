package RadioRecommender;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Song {
	private String name;
	private String artist;
	private int id; // length of playlist on this station
	private int[] stationPlays;
	private int songIndex;
	private int mostPlays;
	private int leastPlays;
	private int[][] playlog;
	
	public Song(String name, String artist, int id) throws FileNotFoundException {
		this.name = name;
		this.artist = artist;
		this.id = id;
//		this.playlog = p.processSongLog();
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
		return stationPlays;
	}
	
	public void setStationPlays(int[][] playlog) {
		int[] numPlays = new int[playlog.length / 4];
		int songIndex = 0;
		while (playlog[1][songIndex] != id) {
			songIndex++;
		}
		
		// record playlog[2][songIndex] for each station
		int stationIndex = 2;
		int numIndex = 0;
		while (stationIndex < playlog.length) {
			numPlays[numIndex] = playlog[stationIndex][songIndex];
			numIndex++;
			stationIndex += 4;
		}
		stationPlays = numPlays;
	}
	
	/**
	 * Returns an array of length 6 containing statistics about the song
	 * @return array containing statistics about the song
	 */
	public int[] getStatistics() {
		return new int[] {averagePlays(), totalPlays(), mostPlays, maxPlays(), leastPlays, minPlays()};
	}
	
	/**
	 * Returns last time step this song was played on the given station
	 * @param stationId - the specified station ID to determine the time this song was last played
	 * @return last time song was played on given station, or 0 if never
	 */
	public int getLastPlayed(int stationId) {
		// NEEDS TEST
		
		int stationIndex = 0;
		while (playlog[stationIndex][0] != stationId) {
			stationIndex += 4;
		}
		setSongIndex();
		return playlog[stationIndex + 3][songIndex];
	}
	
	public void setPlaylog(int[][] playlog) {
		this.playlog = playlog;
	}
	
	public void setSongIndex() {
		songIndex = 0;
		while (playlog[1][songIndex] != this.id) {
			songIndex++;
		}
	}
	
	public void setStatistics(int[][] playlog) {
		mostPlays = mostPlaysStation(playlog);
		leastPlays = leastPlaysStation(playlog);
	}
	
	/**
	 * Returns average number of plays of this song on stations that carry it
	 * @return average number of plays of this song on stations that carry it
	 */
	private int averagePlays() {
		int[] numPlays = this.stationPlays();
		int avg = 0;
		int numStations = 0;
		for (int i : numPlays) {
			if (i != 0) {
				numStations++;
				avg = (avg + i) / numStations;
			}
		}
		return avg;
	}
	
	/**
	 * Returns total number of plays across all stations
	 * @return
	 */
	private int totalPlays() {
		int[] numPlays = this.stationPlays();
		int sum = 0;
		for (int i : numPlays) {
			sum += i;
		}
		return sum;
	}
	
	/**
	 * Returns ID of station that plays this song the most
	 * @return
	 */
	private int mostPlaysStation(int[][] playlog) {
		int max = this.maxPlays();
		int id = 0;
		for (int i = 2; i < playlog.length; i += 4) {
			if (playlog[i][songIndex] == max) {
				id = Integer.max(id, playlog[i - 2][0]);
			}
		}
		return id;
	}
	
	/**
	 * Returns maximum number of plays on any one station
	 * @return
	 */
	private int maxPlays() {
		int[] numPlays = this.stationPlays();
		Arrays.sort(numPlays);
		return numPlays[numPlays.length - 1];
	}
	
	/**
	 * Returns ID of station that plays this song the least
	 * @return
	 */
	private int leastPlaysStation(int[][] playlog) {
		int min = this.minPlays();
		int id = 0;
		setSongIndex();
		for (int i = 2; i < playlog.length; i += 4) {
			if (playlog[i][songIndex] == min) {
				id = Integer.max(id, playlog[i - 2][0]);
			}
		}
		return id;
	}
	
	/**
	 * Returns minimum number of plays on any one station (could be zero)
	 * @return
	 */
	private int minPlays() {
		int[] numPlays = this.stationPlays();
		Arrays.sort(numPlays);
		return numPlays[0];
	}
	
	/**
	 * Returns number of times this song was played on the specified station
	 * @param station
	 */
	public int numPlaysOnStation(Station station) {
		int stationIndex = 0;
		while (this.playlog[stationIndex][0] != station.getId()) {
			stationIndex += 4;
		}
		return this.playlog[stationIndex + 2][this.songIndex];
	}
	
	public String toString() {
		return this.id + ". " + this.artist + " - " + this.name;
	}
}
