public class MovieGenerator {
    public static void main(String[] args) {

    }

    public Movie[] generate(int n) {
        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            String title = "Movie " + i;
            int actionScore = (int) (Math.random() * 99);
            int comedyScore = (int) (Math.random() * 99);
            int dramaScore = (int) (Math.random() * 99);
            int romanceScore = (int) (Math.random() * 99);
            int mysteryScore = (int) (Math.random() * 99);
            int horrorScore = (int) (Math.random() * 99);
            int sciFiScore = (int) (Math.random() * 99);
            int docScore = (int) (Math.random() * 99);
            movies[i] = new Movie(title, actionScore, comedyScore, dramaScore, romanceScore, mysteryScore, horrorScore, sciFiScore, docScore);
        }
        return movies;
    }

}