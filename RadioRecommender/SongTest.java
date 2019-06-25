package RadioRecommender;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SongTest {

	@Test
	void testStationPlays() throws FileNotFoundException {
		File songs = new File("/Users/pamelatao/Desktop/songsTest.txt");
		File stations = new File("/Users/pamelatao/Desktop/stationsTest.txt");
		File playlog = new File("/Users/pamelatao/Desktop/playlogTest.txt");
		Parser p = new Parser(songs, stations, playlog);
		Song s1 = new Song("Come Together", "The Beatles", 101, p);
		Song s2 = new Song("Get Back", "The Beatles", 19, p);
		System.out.println(Arrays.toString(s1.stationPlays()));
		System.out.println(Arrays.toString(s2.stationPlays()));
	}
	
	@Test
	void testGetLastPlayed() throws FileNotFoundException {
		File songs = new File("/Users/pamelatao/Desktop/songsTest.txt");
		File stations = new File("/Users/pamelatao/Desktop/stationsTest.txt");
		File playlog = new File("/Users/pamelatao/Desktop/playlogTest.txt");
		Parser p = new Parser(songs, stations, playlog);
		Song s1 = new Song("Come Together", "The Beatles", 101, p);
		Song s2 = new Song("Get Back", "The Beatles", 19, p);
		assertEquals(4, s1.getLastPlayed(203));
		assertEquals(10, s2.getLastPlayed(203));
	}
	
	@Test
	void testStatistics() throws FileNotFoundException {
		File songs = new File("/Users/pamelatao/Desktop/songsTest.txt");
		File stations = new File("/Users/pamelatao/Desktop/stationsTest.txt");
		File playlog = new File("/Users/pamelatao/Desktop/playlogTest.txt");
		Parser p = new Parser(songs, stations, playlog);
		Song s1 = new Song("Come Together", "The Beatles", 101, p);
		Song s2 = new Song("Get Back", "The Beatles", 19, p);
		assertEquals("[1, 2, 241, 1, 283, 0]", Arrays.toString(s1.getStatistics()));
		assertEquals("[2, 4, 203, 3, 283, 0]", Arrays.toString(s2.getStatistics()));
	}

}
