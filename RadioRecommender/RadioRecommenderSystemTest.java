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
		File playlog = new File("/Users/pamelatao/Desktop/playlogTest.txt");
		Parser p = new Parser(songs, stations);
		RadioRecommenderSystem r = new RadioRecommenderSystem(p);
		Station st203 = new Station("60s Pop Radio", 203);
		Station st81 = new Station("Psychedelic Rock Radio", 81);
		assertEquals(0.431, r.stationSimilarity(st203, st81));
	}

}
