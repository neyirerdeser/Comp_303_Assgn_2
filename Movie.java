//package comp303.assignment2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single movie, with at least a title, language, and publishing studio. Each movie is identified by its
 * path on the file system.
 */
public class Movie implements Watchable<Movie>, Sequential<Movie> {

	private final File aPath;

	private String aTitle;
	private String aLanguage;
	private String aStudio;

	private Map<String, String> aTags = new HashMap<>();

	private Movie aSequel = null;
	private Movie aPrequel = null;

	/**
	 * Creates a movie from the file path. Callers must also provide required metadata about the movie.
	 *
	 * @param pPath
	 *            location of the movie on the file system.
	 * @param pTitle
	 *            official title of the movie in its original language
	 * @param pLanguage
	 *            language of the movie, in full text (e.g., "English")
	 * @param pStudio
	 *            studio which originally published the movie
	 * @throws IllegalArgumentException
	 *             if the path doesn't point to a file (e.g., it denotes a directory)
	 */
	public Movie(File pPath, String pTitle, String pLanguage, String pStudio) {
		if (pPath.exists() && !pPath.isFile()) {
			throw new IllegalArgumentException("The path should point to a file.");
		}
		aPath = pPath; // ok because File is immutable.
		aTitle = pTitle;
		aLanguage = pLanguage;
		aStudio = pStudio;
	}

	/**
	 * Indicates whether this Movie object represents a valid movie that can be played.
	 * 
	 * @return true if the underlying video file exists and is a file (not a directory)
	 */
	public boolean isValid() {
		return aPath.isFile();
	}

	public String getTitle() {
		return aTitle;
	}

	public String getLanguage() {
		return aLanguage;
	}

	public String getStudio() {
		return aStudio;
	}

	/**
	 * Sets the value of a custom tag.
	 *
	 * @param pKey
	 *            the key used to retrieve the tag.
	 * @param pValue
	 *            the value of the tag to insert. Use null to remove the key.
	 */
	public void setTag(String pKey, String pValue) {
		if (pValue == null) {
			aTags.remove(pKey);
		}
		else {
			aTags.put(pKey, pValue);
		}
	}

	/**
	 * Retrieves the value of a custom tag.
	 *
	 * @param pKey
	 *            the tag key, as it was inserted
	 * @return the associated value
	 */
	public String getTag(String pKey) {
		return aTags.get(pKey);
	}

	public void addSequel(Movie pMovie) {
		if(this.aSequel !=null) {
			Movie tempNext = this.aSequel;
			tempNext.aPrequel = pMovie;
			pMovie.aSequel = tempNext;
		}
		this.aSequel = pMovie;
		pMovie.aPrequel = this;
	}

	@Override
	public Movie getNext() {
		return this.aSequel;
	}

	@Override
	public Movie getPrev() {
		return this.aPrequel;
	}
}
