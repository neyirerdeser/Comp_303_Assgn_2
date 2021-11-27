//package comp303.assignment2;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Represents a sequence of movies to watch in FIFO order.
 */
public class WatchList implements Bingeable<Movie> {
	
	private final List<Movie> aMovieList = new LinkedList<>();
	private String aName;
	private final List<Episode> aEpisodeList = new LinkedList<>();
	
	/**
	 * Creates a new empty watchlist.
	 * 
	 * @param pName
	 *            the name of the list
	 */
	public WatchList(String pName) {
		aName = pName;
	}
	
	public String getName() {
		return aName;
	}
	
	/**
	 * Changes the name of this watchlist.
	 * 
	 * @param pName
	 *            the new name
	 */
	public void setName(String pName) {
		aName = pName;
	}
	
	/**
	 * Adds a movie at the end of this watchlist.
	 * 
	 * @param pMovie
	 *            the movie to add
	 */
	public void addMovie(Movie pMovie) {
		aMovieList.add(pMovie);
	}

	/**
	 * Adds an episode at the end of this watchlist.
	 *
	 * @param pEpisode
	 *            the episode to add
	 */
	public void addEpisode(Episode pEpisode) {
		aEpisodeList.add(pEpisode);
	}

	/**
	 * Retrieves and removes the next movie to watch from this watchlist. Movies are retrieved in FIFO order.
	 */
	public Movie removeNext() {
		return aMovieList.remove(0);
	}
	
	/**
	 * Retrieves the list of movies (valid and invalid) in this watchlist.
	 * 
	 * @return an unmodifiable list of movies, backed by this watchlist
	 */
	@Override
	public List<Movie> getElements() {
		return Collections.unmodifiableList(aMovieList);
	}
	
	/**
	 * Counts and returns the number of valid movies in this watchlist.
	 * 
	 * @return the number of valid movies
	 */
	public int getNumberMovies() {
		int count = 0;
		for (Movie movie : aMovieList) {
			if (movie.isValid()) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Retrieves the list of all publishing studios, without duplicates, but including studios of invalid movies.
	 * 
	 * @return a set of studios
	 */
	public Set<String> getStudios() {
		Set<String> studios = new HashSet<>();
		for (Movie movie : aMovieList) {
			studios.add(movie.getStudio());
		}
		return studios;
	}
	
	/**
	 * Retrieves the list of all languages, without duplicates, but including languages of invalid movies.
	 * 
	 * @return a set of languages
	 */
	public Set<String> getLanguages() {
		Set<String> languages = new HashSet<>();
		for (Movie movie : aMovieList) {
			languages.add(movie.getLanguage());
		}
		return languages;
	}

}
