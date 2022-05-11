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
            switch (i){
                case 0:
                    
                case 1:

                case 2:  
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
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
