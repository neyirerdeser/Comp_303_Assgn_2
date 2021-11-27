import java.io.File;

public class Driver {

    public static void main(String[]args) {
        Movie sw4 = new Movie(new File("s4.mov"), "A New Hope", "English", "Lucasfilm");
        Movie sw5 = new Movie(new File("s5.mov"), "The Empire Strikes Back", "English", "Lucasfilm");
        Movie sw6 = new Movie(new File("s6.mov"), "Return of the Jedi", "English", "Lucasfilm");

        sw4.addSequel(sw5);
        sw5.addSequel(sw6);

        Movie sw1 = new Movie(new File("s1.mov"), "The Phantom Menace", "French", "Lucasfilm");
        Movie sw2 = new Movie(new File("s2.mov"), "Attack of the Clones", "French", "Lucasfilm");
        Movie sw3 = new Movie(new File("s3.mov"), "Revenge of the Sith", "French", "Lucasfilm");

        sw1.addSequel(sw4);
        sw1.addSequel(sw2);
        sw2.addSequel(sw3);

        Movie temp = sw1;
        while(temp!=null){
            System.out.println(temp.getTitle());
            temp = temp.getNext();
        }

        Library lib = new Library();
        lib.addMovie(sw1);
        lib.addMovie(sw2);
        lib.addMovie(sw3);
        lib.addMovie(sw4);
        lib.addMovie(sw5);
        lib.addMovie(sw6);

        lib.setStrategy(new ByLanguageGenerator());
        WatchList wl = lib.generateWatchlist("English");

    }
}
