package RadioRecommender;

import java.io.FileNotFoundException;

public class Station {
	private String name;
	private int id;
	private int stationIndex;
	private int length; // length of playlist on this station
	private int[] playlist; // playlist of station
	private int[][] playlog;
	
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
	
	public int getLength() {
		this.setStationIndex();
		for (int i = 0; i < playlog[stationIndex + 2].length; i++) {
			if (playlog[stationIndex + 2][i] != 0) {
				this.length++;
			}
		}
		playlist = new int[length];
		return this.length;
	}
	
	public int[] getPlaylist() {
		this.getLength();
		int index = 0;
		for (int i = 0; i < playlog[stationIndex + 2].length; i++) {
			if (playlog[stationIndex + 2][i] != 0) {
				playlist[index] = playlog[stationIndex + 2][i];
				index++;
			}
		}
		return playlist;
	}
	
	public String toString() {
		return this.id + ". " + this.name;
	}
	
}
