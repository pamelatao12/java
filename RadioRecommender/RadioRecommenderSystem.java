package RadioRecommender;

import java.io.FileNotFoundException;

public class RadioRecommenderSystem {
	Parser parser;
	
	public RadioRecommenderSystem(Parser p) throws FileNotFoundException {
		this.parser = p;
	}
	/**
	 * Return a double between 0 and 1 that measures how similar two songs are
	 * The higher the value, the more similar
	 * @return
	 */
	public double songSimilarity(Song s1, Song s2) {
		// TEST;
		int[] aPlays = s1.stationPlays();
		int[] bPlays = s2.stationPlays();
		double similarity = 0;
		double aDenom = 0;
		double bDenom = 0;
		
		for (int i = 0; i < aPlays.length; i++) {
			similarity += (aPlays[i] * bPlays[i]);
			aDenom += (aPlays[i] * aPlays[i]);
			bDenom += (bPlays[i] * bPlays[i]);
		}
		// if song hasn't been played on any station, then return 0
		if (aDenom == 0 || bDenom == 0) {
			return 0;
		}
		similarity /= (Math.sqrt(aDenom) * Math.sqrt(bDenom));
		return similarity;
	}
	
	/**
	 * Return a double between 0 and 1 that measures how similar two stations are
	 * The higher the value, the more similar
	 * @return
	 */
	public double stationSimilarity(Station st1, Station st2) {
		// TODO;
		int[] st1List = st1.getPlaylist();
		int[] st2List = st2.getPlaylist();
		
		double similarity = 0;
		double st1Denom = 0;
		double st2Denom = 0;
		
		for (int i = 0; i < st1List.length; i++) {
			similarity += (st1List[i] * st2List[i]);
			st1Denom += (st1List[i] * st1List[i]);
			st2Denom += (st2List[i] * st2List[i]);
		}
		// if one playlist is empty, then return 0
		if (st2Denom == 0 || st1Denom == 0) {
			return 0;
		}
		similarity /= (Math.sqrt(st1Denom) * Math.sqrt(st2Denom));
		return similarity;
	}
	
	/**
	 * Returns the ID of the song closest to the provided song
	 * @param s
	 * @return
	 */
	public int closestSong(Song s) {
		double similarity = 0;
		double currSimilarity = 0;
		int closestSongId = 0;
		for (Song sCompare : parser.getSongs()) {
			if (s.getId() != sCompare.getId()) {
				currSimilarity = songSimilarity(s, sCompare);
				closestSongId = currSimilarity == similarity ? Math.max(s.getId(), sCompare.getId()) : (currSimilarity > similarity ? sCompare.getId() : s.getId()); 
			}
		}
		return closestSongId;
	}
	
	/**
	 * Returns the ID of the station closest to the provided station
	 * @param s
	 * @return
	 */
	public int closestStation(Station s) {
		double similarity = 0;
		double currSimilarity = 0;
		int closestStationId = 0;
		for (Station sCompare : parser.getStations()) {
			if (s.getId() != sCompare.getId()) {
				currSimilarity = stationSimilarity(s, sCompare);
				closestStationId = currSimilarity > similarity ? sCompare.getId() : s.getId();
			}
		}
		return closestStationId;
	}
	
	/**
	 * Returns a value to recommend song specified to station specified
	 * @return
	 */
	public double makeRecommendation(int recSongID, int radioID) {
		//find song with given ID
		Song recSong = null;
		for (Song s : parser.getSongs()) {
			if (s.getId() == recSongID) {
				recSong = s;
			} 
		}
		if (recSong == null) {
			throw new IllegalArgumentException("invalid song ID");
		}
		
		double multiplier = 0.0;
		double tS = 0.0;
		double numerator = 0;
		double denominator = 0;
		double result = 0;
		
		multiplier = Math.exp(-1.0 / Math.sqrt(parser.getLogLength() + 1 - recSong.getLastPlayed(radioID)));
		
		result = multiplier * (avgSongStation(radioID) + (numerator / denominator));
		return result;
	}
	
	/**
	 * Returns average number of times any song is played at station specified
	 * @param radioID
	 * @return
	 */
	private double avgSongStation(int radioID) {
		double avg = 0;
		Station radio = null;
		// total # of times any song is played / # songs
		// get total # times every song is played on station
		for (Station s : parser.getStations()) {
			if (s.getId() == radioID) {
				radio = s;
			} 
		}
		if (radio == null) {
			throw new IllegalArgumentException("invalid station ID");
		} 
		
		
		// get total number of songs = parser.getSongs().length
		return avg;
	}
	
	/**
	 * Returns the song which is the best recommendation for the radio station given
	 * In case of tie, return song whose most recent play on the given station was earliest in time
	 * @param radioID
	 * @return
	 */
	public Song bestRecommendation(int radioID) {
		
	}
}
