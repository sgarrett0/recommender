import java.util.ArrayList;
import java.util.HashMap;

public class Recommender {
    private static HashMap<Integer, ArrayList<Movie>> buckets = new HashMap<Integer, ArrayList<Movie>>();
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...\nReading Files...");
        //store generated info for perpetual use
        Movie[] movieScores = MovieGenerator.generate(20);
        User[] userScores = UserGenerator.generate(20);
        System.out.println("Arrays Created...\nGenerating Recommendation List...");
        //runFactorization(movieScores, userScores);
        lsHashing(movieScores, userScores);
        System.out.println(buckets.values());
        //createRecommendations();
    }

    /**
     * Use lsh created hashes to organize movies based on similarity
     */
    private static void createBuckets(Movie movie) {
        //64 potential buckets 8 genres * OPTION 1 or 0
        if (buckets.containsKey(movie.getHash())){
            buckets.get(movie.getHash()).add(movie);
        }
        else{
            ArrayList<Movie> temp = new ArrayList<Movie>();
            temp.add(movie);
            buckets.put(movie.getHash(), temp);
        }
    }

    /**
     * Group Movies into Buckets
     * @param movieScores
     * @param userScores
     */
    private static void lsHashing(Movie[] movieScores, User[] userScores) {
        int[] pivots = {10, 20, 40, 50, 60, 70, 80, 90};
        for (Movie movie : movieScores) {
            for (int i = 0; i < pivots.length; i++){
                switch (i){
                    case 0:
                        if (movie.getActionScore() >= pivots[i]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }
                        break;
                    case 1:
                        if (movie.getComedyScore() >= pivots[i]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }
                        break;
                    case 2:
                        if (movie.getDramaScore() >= pivots[i]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }
                        break;
                    case 3:
                        if (movie.getRomanceScore() >= pivots[i]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }
                        break;
                    case 4:
                        if (movie.getMysteryScore() >= pivots[i]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }
                        break;
                    case 5:
                        if (movie.getHorrorScore() >= pivots[i]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }
                        break;
                    case 6:
                        if (movie.getSciFiScore() >= pivots[i]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }
                        break;
                    case 7:
                        if (movie.getDocScore() >= pivots[i]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }
                        break;
                }
            }
            //create buckets
            createBuckets(movie);
        }
    }

    /**
     * Create dot product of user and movie genre ratings
     */
    private static void runFactorization(Movie[] movieScores, User[] userScores) {

    }


    private static void createRecommendations() {
    }

    /**
     * CONDITIONS: 
     *      There are X movies in the txt file...
     *      There are Y attributes per movie...
     * Read info from movies.txt to make a movie object to be stored in an array. 
     * @return an array of movie objects.
     */
    private static Movie[][] createMovieList(){
        Movie[][] movieArr;
        return null;
    }


    /**
     * CONDITIONS: 
     *      There are N users in the txt file...
     *      There are Y attributes per user...
     * Read info from users.txt file to create N user objects. 
     * @return an array of user objects.
     */
    private static User[][] createUserList(){
        User[][] userArr;
        return null;
    }


}
