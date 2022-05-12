public class Recommender {
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...\nReading Files...");

        Movie[] movieScores = MovieGenerator.generate(20);
        User[] userScores = UserGenerator.generate(20);
        System.out.println("Arrays Created...\nGenerating Recommendation List...");
        //runFactorization(movieScores, userScores);
        lsHashing(movieScores, userScores);
        
        createRecommendations();
    }

    /**
     * Group Movies into Buckets
     * @param movieScores
     * @param userScores
     */
    private static void lsHashing(Movie[] movieScores, User[] userScores) {
        int[] pivots = {10, 20, 40, 50, 70, 80, 90};
        for (int i = 0; i < pivots.length; i++){
            for (Movie movie : movieScores) {
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
