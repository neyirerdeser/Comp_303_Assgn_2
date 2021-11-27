public class ByLanguageGenerator implements WatchListGenerator{

    @Override
    public WatchList generate(Library lib, String language) {
        WatchList wl = new WatchList("generated watchlist");
        for(Movie m : lib.aMovies) {
            if(m.getLanguage().equals(language)) {
                wl.addMovie(m);
            }
        }
        return wl;

    }
}
