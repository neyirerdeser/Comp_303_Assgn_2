//package comp303.assignment2;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a movie library, with individual movie titles and watch lists.
 */
public class Library{
	
	protected Set<Movie> aMovies = new HashSet<>();
	private Set<WatchList> aWatchLists = new HashSet<>();
	protected Set<Episode> aEpisodes = new HashSet<>();
	private Set<TVShow> aTVShows = new HashSet<>();
	private WatchListGenerator aWLG;



	// Optional
	/**
	 * Adds a movie to the library. Duplicate movies aren't added twice.
	 * 
	 * @param pMovie
	 *            the movie to add
	 */
	public void addMovie(Movie pMovie) {
		aMovies.add(pMovie);
	}

	/**
	 * Adds an episode to the library. Duplicate episodes aren't added twice.
	 *
	 * @param pEpisode
	 *            the episode to add
	 */
	public void addEpisode(Episode pEpisode) {
		aEpisodes.add(pEpisode);
	}
	
	// Optional
	/**
	 * Adds a watchlist to the library. All movies from the list are also added as individual movies to the library.
	 * 
	 * @param pList
	 *            the watchlist to add
	 */
	public void addWatchList(WatchList pList) {
		aWatchLists.add(pList);
		for (Movie movie : pList.getElements()) {
			addMovie(movie);
		}
	}

	/**
	 * Adds a tv show to the library. All episodes from the list are also added as individual episodes to the library.
	 *
	 * @param pShow
	 *            the tv show to add
	 */
	public void addTVShow(TVShow pShow) {
		aTVShows.add(pShow);
		for (Episode episode : pShow.getElements()) {
			addEpisode(episode);
		}
	}

	public void setStrategy(WatchListGenerator pWLG) {
		aWLG =  pWLG;
	}

	public WatchList generateWatchlist(String input) {
		return aWLG.generate(this, input);
	}

}
