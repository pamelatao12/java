package RadioRecommender;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ParserTest {

	@Test
	void testParser() throws FileNotFoundException {
		File songs = new File("/Users/pamelatao/Desktop/songsTest.txt");
		File stations = new File("/Users/pamelatao/Desktop/stationsTest.txt");
		File playlog = new File("/Users/pamelatao/Desktop/playlogTest.txt");
		Parser p = new Parser(songs, stations, playlog);
		p.processSongLog();
		System.out.println(Arrays.toString(p.getLog()));
	}

}
