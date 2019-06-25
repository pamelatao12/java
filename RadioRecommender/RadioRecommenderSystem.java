package RadioRecommender;

import java.io.FileNotFoundException;

public class RadioRecommenderSystem {
	private int[][] playlog;
	
	public RadioRecommenderSystem(Parser p) throws FileNotFoundException {
		playlog = p.processSongLog();
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
		int[] st1List = playlog[st1.getStationIndex() + 2];
		int[] st2List = playlog[st2.getStationIndex() + 2];
		
		double similarity = 0;
		double st1Denom = 0;
		double st2Denom = 0;
		
		for (int i = 0; i < st1List.length; i++) {
			similarity += (st1List[i] * st2List[i]);
			st1Denom += (st1List[i] * st1List[i]);
			st2Denom += (st2List[i] * st2List[i]);
		}
		similarity /= (Math.sqrt(st1Denom) * Math.sqrt(st2Denom));
		return similarity;
	}
}
