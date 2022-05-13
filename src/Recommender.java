import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Recommender {
    private static HashMap<Integer, ArrayList<Movie>> movieBuckets = new HashMap<Integer, ArrayList<Movie>>();
    private static HashMap<Integer, ArrayList<User>> userBuckets = new HashMap<Integer, ArrayList<User>>();
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...\nReading Files...");
        //store generated info for perpetual use
        Movie[] movieScores = MovieGenerator.generate(20);
        User[] userScores = UserGenerator.generate(20);
        System.out.println("Arrays Created...\nGenerating Recommendation List...");
        //runFactorization(movieScores, userScores);
        lsHashing(movieScores, userScores);
        // System.out.println(movieBuckets.values());
        System.out.println(userBuckets.values());
        //createRecommendations();
    }

    /**
     * Use lsh created hashes to organize movies based on similarity
     */
    private static void createMovieBuckets(Movie movie) {
        //64 potential buckets 8 genres * OPTION 1 or 0
        if (movieBuckets.containsKey(movie.getHash())){
            movieBuckets.get(movie.getHash()).add(movie);
        }
        else{
            movieBuckets.put(movie.getHash(), new ArrayList<Movie>(Arrays.asList(movie)));
        }
    }

    private static void createUserBuckets(User user) {
        //64 potential buckets 8 genres * OPTION 1 or 0
        if (userBuckets.containsKey(user.getHash())){
            userBuckets.get(user.getHash()).add(user);
        }
        else{
            userBuckets.put(user.getHash(), new ArrayList<User>(Arrays.asList(user)));
        }
    }

    /**
     * Group Movies into Buckets
     * @param movieScores
     * @param userScores
     */
    private static void lsHashing(Movie[] movieScores, User[] userScores) {
        int[] pivots = {10, 20, 40, 50, 60, 70, 80, 90};
        for (int i=0; i<movieScores.length; i++) {
            Movie movie = movieScores[i];
            User user = userScores[i];
            for (int j = 0; j < pivots.length; j++){
                switch (j){
                    case 0:
                        if (movie.getActionScore() >= pivots[j]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }

                        if (user.getActionScore() >= pivots[j]){
                            user.setHash(1);
                        } else {
                            user.setHash(0);
                        }
                        break;
                    case 1:
                        if (movie.getComedyScore() >= pivots[j]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }

                        if (user.getComedyScore() >= pivots[j]){
                            user.setHash(1);
                        } else {
                            user.setHash(0);
                        }
                        break;
                    case 2:
                        if (movie.getDramaScore() >= pivots[j]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }

                        if (user.getDramaScore() >= pivots[j]){
                            user.setHash(1);
                        } else {
                            user.setHash(0);
                        }
                        break;
                    case 3:
                        if (movie.getRomanceScore() >= pivots[j]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }

                        if (user.getRomanceScore() >= pivots[j]){
                            user.setHash(1);
                        } else {
                            user.setHash(0);
                        }
                        break;
                    case 4:
                        if (movie.getMysteryScore() >= pivots[j]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }

                        if (user.getMysteryScore() >= pivots[j]){
                            user.setHash(1);
                        } else {
                            user.setHash(0);
                        }
                        break;
                    case 5:
                        if (movie.getHorrorScore() >= pivots[j]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }

                        if (user.getHorrorScore() >= pivots[j]){
                            user.setHash(1);
                        } else {
                            user.setHash(0);
                        }
                        break;
                    case 6:
                        if (movie.getSciFiScore() >= pivots[j]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }

                        if (user.getSciFiScore() >= pivots[j]){
                            user.setHash(1);
                        } else {
                            user.setHash(0);
                        }
                        break;
                    case 7:
                        if (movie.getDocScore() >= pivots[j]){
                            movie.setHash(1);
                        } else {
                            movie.setHash(0);
                        }

                        if (user.getDocScore() >= pivots[j]){
                            user.setHash(1);
                        } else {
                            user.setHash(0);
                        }
                        break;
                }
            }
            //create buckets
            createMovieBuckets(movie);
            createUserBuckets(user);
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
