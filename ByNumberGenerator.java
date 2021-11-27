import java.util.*;

public class ByNumberGenerator implements WatchListGenerator{
    @Override
    public WatchList generate(Library lib, String number) {
        int num = Integer.valueOf(number);
        WatchList wl = new WatchList("generated watchlist");
        ArrayList<Episode> shuffled = new ArrayList<>(lib.aEpisodes);
        Collections.shuffle(shuffled);

        for(int i=0; i<num ;i++) {
            wl.addEpisode(shuffled.get(i));
        }
        return wl;
    }
}
