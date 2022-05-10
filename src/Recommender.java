public class Recommender {
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...\nReading Files...");
        Movie[][] movieScores = createMovieList();
        User[][] userScores = createUserList();
        System.out.println("Arrays Created...\nGenerating Recommendation List...");
        runFactorization(movieScores, userScores);
        createRecommendations();
    }

    /**
     * Create dot product of user and movie genre ratings
     */
    private static void runFactorization(Movie[][] movieScores, User[][] userScores) {
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
