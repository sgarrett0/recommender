import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Recommender {
    private static HashMap<Integer, ArrayList<Movie>> movieBuckets = new HashMap<Integer, ArrayList<Movie>>();
    private static HashMap<Integer, ArrayList<User>> userBuckets = new HashMap<Integer, ArrayList<User>>();
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...\nReading Files...");
        //store generated info for perpetual use
        Movie[] movieScores = MovieGenerator.generate(200);
        User[] userScores = UserGenerator.generate(200);
        System.out.println("Arrays Created...\nGenerating Recommendation List...");
        //runFactorization(movieScores, userScores);
        lsHashing(movieScores, userScores);
        // System.out.println(userBuckets.values());
        // System.out.println(movieBuckets.values());
        createRecommendations(userBuckets, movieBuckets);
        for(User user : userScores) {
            System.out.print(user.getName() + ": ");
            dotProduct(user);
            System.out.println("");
            user.printRecommended();
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        }
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

    //for Factorization and LSH
    private static void createRecommendations(HashMap<Integer, ArrayList<User>> users, HashMap<Integer, ArrayList<Movie>> movies){
        List<Integer> movieKeys = new ArrayList<Integer>(movies.keySet());
        for (int i = 0; i < movieKeys.size(); i++ ) {
            if (users.containsKey(movieKeys.get(i))) {
                ArrayList<User> userList = users.get(movieKeys.get(i));
                for (int j=0; j<userList.size(); j++) {
                    User user = userList.get(j);
                    user.addToRecommended(movies.get(movieKeys.get(i)));
                }
            }
        }
    }

    /**
     * CONDITIONS: 
     *      There are X movies in the txt file...
     *      There are Y attributes per movie...
     * Read info from movies.txt to make a movie object to be stored in an array. 
     * @return an array of movie objects.
     */
    public static Movie[] createMovieList(){
        
        int movieNum = 5;
        int movieGenres = 9;
        Movie[] movieArr = new Movie[movieNum];
        String[][] allMovies = new String[movieNum][movieGenres];
        File movies = new File("./lib/movies.txt");
        try {
            Scanner readGenres = new Scanner(movies);
            for(int i = 0; i < movieNum; i++){
                for(int j = 0; j < movieGenres; j++){
                   allMovies[i][j] =  readGenres.nextLine();
                   System.out.println(allMovies[i][j]);
                }
                Movie nextMovie = new Movie(allMovies[i]);
                movieArr[i] = nextMovie;

            }
        } catch (FileNotFoundException e) {
           System.out.print("Error with movies file");
            e.printStackTrace();
        }
        
        return movieArr;
    }


    /**
     * CONDITIONS: 
     *      There are N users in the txt file...
     *      There are Y attributes per user...
     * Read info from users.txt file to create N user objects. 
     * @return an array of user objects.
     */
    public static User[] createUserList(){
        
        int userNum = 5;
        int userGenreRatings = 9;
        User[] userArr = new User[userNum];
        String[][] allUsers = new String[userNum][userGenreRatings];
        File users = new File("./lib/users.txt");
        try {
            Scanner readRatings = new Scanner(users);
            for(int x = 0; x < userNum; x++){
                for(int y = 0; y < userGenreRatings; y++){
                allUsers[x][y] = readRatings.nextLine();
                    System.out.println(allUsers[x][y]);
                }
                User nextUser = new User(allUsers[x]);
                userArr[x] = nextUser;
            }
        
        } catch (FileNotFoundException e) {
           System.out.print("Error with users file");
            e.printStackTrace();
        }
        return userArr;
    }

    public static void dotProduct(Movie[] m, User[] u){
        //takes userArr and movieArr, does
        for (int i = 0; i < u.length; i++){
            double movieScore = u[i].getActionScore() * m[i].getActionScore() + u[i].getComedyScore() * m[i].getComedyScore() + u[i].getDramaScore() * m[i].getDramaScore() + u[i].getRomanceScore() * m[i].getRomanceScore() + u[i].getMysteryScore() * m[i].getMysteryScore() + u[i].getHorrorScore() * m[i].getHorrorScore() + u[i].getSciFiScore() * m[i].getSciFiScore() + u[i].getDocScore() * m[i].getDocScore();
            movieScore /= 10;
            System.out.println(u[i].getName() + "'s score for " + m[i].getTitle() + " is " + movieScore);
        }
    }

    public static void dotProduct(User user) {
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        for (int i=0; i<user.getRecommended().size(); i++) {
            movieList.add(user.getRecommended().get(i));
        }
        user.clearRecommended();
        HashMap<Double, Movie> movieMap = new HashMap<Double, Movie>();
        for (int i=0; i<movieList.size(); i++) {
            Movie movie = movieList.get(i);
            double movieScore = user.getActionScore() * movie.getActionScore() + user.getComedyScore() * movie.getComedyScore() + user.getDramaScore() * movie.getDramaScore() + user.getRomanceScore() * movie.getRomanceScore() + user.getMysteryScore() * movie.getMysteryScore() + user.getHorrorScore() * movie.getHorrorScore() + user.getSciFiScore() * movie.getSciFiScore() + user.getDocScore() * movie.getDocScore();
            movieScore /= 10;
            movieMap.put(movieScore, movie);
        }
        ArrayList<Double> sortedScores = bubbleSort(new ArrayList<Double>(movieMap.keySet()));
        for (int i=0; i<5 && i<sortedScores.size(); i++) {
            user.addToRecommended(movieMap.get(sortedScores.get(i)));
        }
    }

    public static ArrayList<Double> bubbleSort(ArrayList<Double> movies) {
        int n = movies.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (movies.get(j) > movies.get(j+1))
                {
                    double temp = movies.get(j);
                    movies.set(j, movies.get(j+1));
                    movies.set(j+1, temp);
                }
        return movies;
    }

    public static Rating[] createRatingList(){
        int userNum = 5;
        int userRatings = 15;
        Rating[] ratingArr = new Rating[userNum];
        String[][] allRatings = new String[userNum][userRatings];
        File ratings = new File("./lib/userRatings.txt");
        try {
            Scanner readScores = new Scanner(ratings);
            for(int a = 0; a < userNum; a++){
                for(int b = 0; b < userRatings; b++){
                    allRatings[a][b] = readScores.nextLine();
                    System.out.println(allRatings[a][b]);
                }
                Rating nextRating = new Rating(allRatings[a]);
                ratingArr[a] = nextRating;
            }
        } catch (FileNotFoundException e) {
            System.out.print("Error with ratings file");
            e.printStackTrace();
        }
        return ratingArr;
    }
}
