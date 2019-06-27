package RadioRecommender;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	private Song[] songs;
	private Station[] stations;
	private int[][] log;
	private File songLog;
	private int numStations;
	private int numSongs;
	private int line; // length of file + 1
	
	public Parser(File songFile, File stationFile) throws FileNotFoundException {
		
		Scanner read = new Scanner(stationFile);
		read.useDelimiter(";");
		String name;
		int id;
		int index = 0;
		numStations = Integer.parseInt(read.nextLine());
		this.stations = new Station[numStations];
		log = new int[numStations * 4][];
		int stationIndex = 0;
		
		while (read.hasNext()) {
			name = read.next().trim();
			id = Integer.parseInt(read.nextLine().substring(1));
			
			log[stationIndex] = new int[] {id}; //add stations to log array
			stationIndex += 4;
			
			Station station = new Station(name, id);
			stations[index] = station; //sort array?
			index++;
		}
		read.close();
		
		
		read = new Scanner(songFile);
		read.useDelimiter(";");
		String songName;
		String artist;
		int songId;
		index = 0;
		numSongs = Integer.parseInt(read.nextLine());
		
		
		int[] songIdList = new int[numSongs];
		
		this.songs = new Song[numSongs];
		while (read.hasNext()) {
			songName = read.next().trim();
			artist = read.next().trim();
			songId = Integer.parseInt(read.nextLine().substring(1));
			songIdList[index] = songId; //add song ids to array
			Song song = new Song(songName, artist, songId);
			songs[index] = song; //sort array?
			index++;
		}
		
		
		for (int i = 1; i < log.length; i += 4) {
			log[i] = songIdList; //add song id list to array behind every station
		}
		read.close();
		
	}
	
	/**
	 * Returns an array of songs that is played by the specified station
	 * @param stationId - the station to return its songs playlist
	 * @return
	 * @throws FileNotFoundException 
	 */
	public int[][] processSongLog(File songlog) throws FileNotFoundException {
		// create empty arrays in log
		for (int i = 2; i < log.length; i += 4) {
			log[i] = new int[numSongs];
			log[i + 1] = new int[numSongs];
		}
		
		
		Scanner read = new Scanner(songLog);
		read.useDelimiter(";");
		int stationId = 0;
		int songId = 0;
		line = 1;
		// # times each song played on station
		// time step song was last played on this station (null if none)
		while (read.hasNext()) {
			stationId = Integer.parseInt(read.next());
			songId = Integer.parseInt(read.nextLine().substring(1));
			
			//find station in log and update # times song played
			for (int i = 0; i < log.length; i += 4) {
				if (log[i][0] == stationId) {
					System.out.println(log[1].length);
					for (int j = 0; j < log[1].length; j++) { // look for song in array
						if (log[i + 1][j] == songId) {
							log[i + 2][j] += 1; // update # times song played
							log[i + 3][j] = line;
							break; // if song updated, then break;
						}
					}
				break; // if station found, then break;
				}
			}
			line++;
		}
		read.close();
		this.updateSongs();
		this.updateStations();
		return log;
	}
	
	public void updateSongs() {
		for (Song s : songs) {
			s.setStationPlays(log);
			s.setPlaylog(log);
			s.setStatistics(log);
		}
	}
	
	public void updateStations() {
		for (Station s : stations) {
			s.setPlaylog(log);
			s.setLength();
			s.setPlaylist();
		}
		
	}
	
	public int getLogLength() {
		return line - 1;
	}
	
	public Song[] getSongs() {
		return songs;
	}
	
	public Station[] getStations() {
		return stations;
	}
	
	public int[][] getLog() {
		return log;
	}
	
}
