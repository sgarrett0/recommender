public class MovieGenerator {
    public static void main(String[] args) {
        System.out.println(generate(100));
    }

    public static Movie[] generate(int n) {
        Movie[] movies = new Movie[n];

        for (int i = 0; i < n; i++) {
            String title = "Movie " + i;
            int action = (int) (Math.random() * 99);
            int comedy = (int) (Math.random() * 99);
            int drama = (int) (Math.random() * 99);
            int romance = (int) (Math.random() * 99);
            int mystery = (int) (Math.random() * 99);
            int horror = (int) (Math.random() * 99);
            int sciFi = (int) (Math.random() * 99);
            int doc = (int) (Math.random() * 99);
            movies[i] = new Movie(title, action, comedy, drama, romance, mystery, horror, sciFi, doc);
        }
        return movies;
    }
}