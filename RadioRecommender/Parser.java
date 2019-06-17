package RadioRecommender;
import java.io.File;
import java.util.Scanner;

public class Parser {
	private Song[] songs;
	private Station[] stations;
	private File songLog;
	
	public Parser(File songFile, File stationFile, File songLog) {
		this.songLog = songLog;
		
		Scanner read = new Scanner(stationFile);
		read.useDelimiter(";");
		String name;
		int id;
		int index = 0;
		this.stations = new Station[read.nextInt()];
		while (read.hasNext()) {
			name = read.next().trim();
			id = read.nextInt();
			Station station = new Station(name, id);
			stations[index] = station; //sort array?
			index++;
		}
		
		read = new Scanner(songFile);
		read.useDelimiter(";");
		String songName;
		String artist;
		int songId;
		index = 0;
		this.songs = new Song[read.nextInt()];
		while (read.hasNext()) {
			songName = read.next().trim();
			artist = read.next().trim();
			songId = read.nextInt();
			Song song = new Song(songName, artist, songId);
			songs[index] = song; //sort array?
			index++;
		}
		
	}
	
	/**
	 * Returns an array of songs that is played by the specified station
	 * @param stationId - the station to return its songs playlist
	 * @return
	 */
	public int[] processSongLog(int stationId) {
		Scanner read = new Scanner(songLog);
		
		
	}
}
