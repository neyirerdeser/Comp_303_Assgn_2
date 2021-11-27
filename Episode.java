import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Episode implements Sequential<Episode>, Watchable<Episode>{

    private final File aPath;
    private final int aSequentialNo;
    private String aTitle;

    private Map<String, String> aTags = new HashMap<>();

    private Episode aNext = null;
    private Episode aPrevious = null;

    /**
     * Creates a movie from the file path. Callers must also provide required metadata about the movie.
     *
     * @param pPath
     *            location of the movie on the file system.
     * @param pTitle
     *            official title of the movie in its original language
     * @throws IllegalArgumentException
     *             if the path doesn't point to a file (e.g., it denotes a directory)
     */
    public Episode(File pPath, String pTitle, int pSequentialNo) {
        if (pPath.exists() && !pPath.isFile()) {
            throw new IllegalArgumentException("The path should point to a file.");
        }
        aPath = pPath; // ok because File is immutable.
        aTitle = pTitle;
        aSequentialNo = pSequentialNo;
    }

    /**
     * Indicates whether this Movie object represents a valid movie that can be played.
     *
     * @return true if the underlying video file exists and is a file (not a directory)
     */

    public String getTitle() {
        return aTitle;
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

    public void addNext(Episode pEpisode) {
        if(this.aNext !=null) {
            Episode tempNext = this.aNext;
            tempNext.aPrevious = pEpisode;
            pEpisode.aNext = tempNext;
        }
        this.aNext = pEpisode;
        pEpisode.aPrevious = this;
    }

    @Override
    public Episode getNext() {
        return this.aNext;
    }

    @Override
    public Episode getPrev() {
        return this.aPrevious;
    }
}
