package RadioRecommender;

import java.io.FileNotFoundException;

public class Station {
	private String name;
	private int id;
	private int stationIndex;
	private int length; // length of playlist on this station
	private int[] playlist; // playlist of station
	private int[][] playlog;
	private int totalPlays;
	private int[] numPlays; // number of times each song played on this station
	
	public Station(String name, int id) throws FileNotFoundException {
		this.name = name;
		this.id = id;
//		this.playlog = p.processSongLog();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setPlaylog(int[][] playlog) {
		this.playlog = playlog;
	}
	
	private void setStationIndex() {
		int stationIndex = 0;
		while (playlog[stationIndex][0] != id) {
			stationIndex += 4;
		}
	}
	
	public int getStationIndex() {
		this.setStationIndex();
		return stationIndex;
	}
	
	public void setLength() {
		this.setStationIndex();
		for (int i = 0; i < playlog[stationIndex + 2].length; i++) {
			if (playlog[stationIndex + 2][i] != 0) {
				this.length++;
			}
		}
		playlist = new int[length];
	}
	
	public int getLength() {
		return this.length;
	}
	
	/**
	 * int array of number of times each song played on station
	 */
	public void setnumPlays() {
		numPlays = new int[playlog[stationIndex + 2].length];
		int index = 0;
		for (int i = 0; i < playlog[stationIndex + 2].length; i++) {
			// set totalPlays in the meantime
			numPlays[index] = playlog[stationIndex + 2][i];
			index++;
		}
	}
	
	public int[] getNumPlays() {
		return numPlays;
	}
	
	/**
	 * int[] of each song ID in playlist
	 */
	public void setPlaylist() {
		this.getLength();
		int index = 0;
		for (int i = 0; i < playlog[stationIndex + 2].length; i++) {
			// set totalPlays in the meantime
			totalPlays += playlog[stationIndex + 2][i];
			if (playlog[stationIndex + 2][i] != 0) {
				playlist[index] = playlog[stationIndex + 1][i];
				index++;
			}
		}
	}
	
	public int[] getPlaylist() {
		return playlist;
	}
	
	public int getTotalPlays() {
		return totalPlays;
	}
	
	public String toString() {
		return this.id + ". " + this.name;
	}
	
}
