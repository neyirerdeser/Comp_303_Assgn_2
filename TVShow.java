import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TVShow implements Bingeable<Episode>, Watchable<TVShow>{

    private final List<Episode> aList = new LinkedList<>();
    private String aName;

    public TVShow(String pName) {
        aName = pName;
    }

    /**
     * Adds a single episode to the tv show
     *
     */
    public void addEpisode(Episode pEpisode) {
        aList.add(pEpisode);
    }

    /**
     * Retrieves the list of episodes in this tv show.
     *
     * @return an unmodifiable list of episodes, backed by this tv show
     */
    @Override
    public List<Episode> getElements() {
        return Collections.unmodifiableList(aList);
    }
}
