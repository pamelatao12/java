package RadioRecommender;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class RadioRecommenderSystemTest {

	@Test
	void testStationSimilarity() throws FileNotFoundException {
		File songs = new File("/Users/pamelatao/Desktop/songsTest.txt");
		File stations = new File("/Users/pamelatao/Desktop/stationsTest.txt");
//		File playlog = new File("/Users/pamelatao/Desktop/playlogTest.txt");
		Parser p = new Parser(songs, stations);
		RadioRecommenderSystem r = new RadioRecommenderSystem(p);
		assertEquals(0.431, r.stationSimilarity(p.getStations()[0], p.getStations()[1]));
	}

}
