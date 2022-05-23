import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Recommender {
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...");
        Movie[] movieArr = createMovieList();
        User[] userArr = createUserList();
        ArrayList<ArrayList<Rating>> watchedRatings = createRatingList();

        userArr = dotProduct(movieArr, userArr);
        recommendMovies(watchedRatings, userArr, movieArr);
    }

    /**
     * CONDITIONS: 
     *      There are X movies in the txt file...
     *      There are Y attributes per movie...
     * Read info from movies.txt to make a movie object to be stored in an array. 
     * @return an array of movie objects.
     */
    public static Movie[] createMovieList(){
        
        int movieNum = 10;
        int movieGenres = 9;
        Movie[] movieArr = new Movie[movieNum];
        String[][] allMovies = new String[movieNum][movieGenres];
        File movies = new File("./lib/movies.txt");
        try {
            try (Scanner readGenres = new Scanner(movies)) {
                for(int i = 0; i < movieNum; i++){
                    for(int j = 0; j < movieGenres; j++){
                       allMovies[i][j] =  readGenres.nextLine();
                       //System.out.println(allMovies[i][j]);
                    }
                    Movie nextMovie = new Movie(allMovies[i]);
                    movieArr[i] = nextMovie;

                }
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
        
        int userNum = 10;
        int userGenreRatings = 9;
        User[] userArr = new User[userNum];
        String[][] allUsers = new String[userNum][userGenreRatings];
        File users = new File("./lib/users.txt");
        try {
            try (Scanner readRatings = new Scanner(users)) {
                for(int x = 0; x < userNum; x++){
                    for(int y = 0; y < userGenreRatings; y++){
                    allUsers[x][y] = readRatings.nextLine();
                        //System.out.println(allUsers[x][y]);
                    }
                    User nextUser = new User(allUsers[x]);
                    userArr[x] = nextUser;
                }
            }
        
        } catch (FileNotFoundException e) {
           System.out.print("Error with users file");
            e.printStackTrace();
        }
        return userArr;
    }
    //fix normalization: some score greater than 10.
    public static User[] dotProduct(Movie[] m, User[] u){
        for (int i = 0; i < u.length; i++){
            for (int j = 0; j < m.length; j++){
                double movieScore = u[i].getActionScore() * m[j].getActionScore() + u[i].getComedyScore() * m[j].getComedyScore() + u[i].getDramaScore() * m[j].getDramaScore() + u[i].getRomanceScore() * m[j].getRomanceScore() + u[i].getMysteryScore() * m[j].getMysteryScore() + u[i].getHorrorScore() * m[j].getHorrorScore() + u[i].getSciFiScore() * m[j].getSciFiScore() + u[i].getDocScore() * m[j].getDocScore();
                movieScore /= 10;
                Rating r = new Rating(m[j].getTitle(), movieScore);
                u[i].setRatingArray(r);
                //System.out.println(u[i].getName() + "'s score for " + m[j].getTitle() + " is " + movieScore);
            }
            //System.out.println(u[i].getRatingArray());
        }
        return u;
    }
    public static ArrayList<ArrayList<Rating>> createRatingList(){
        // int userNum = 5;
        // int userRatings = 3;
        ArrayList<ArrayList<Rating>> ratingArr = new ArrayList<ArrayList<Rating>>();
        // String[][] allRatings = new String[userNum][userRatings];
        // File ratings = new File("./lib/userRatings.txt");
        // try {
        //     try (Scanner readScores = new Scanner(ratings)) {
        //         for(int a = 0; a < userNum; a++){
        //             for(int b = 0; b < userRatings; b++){
        //                 allRatings[a][b] = readScores.nextLine();
        //                 //System.out.println(allRatings[a][b]);
        //             }
        //             Rating nextRating = new Rating(allRatings[a]);
        //             ratingArr.get(a).add(nextRating);
        //             userRatings += 2;
        //         }
        //     }
        // } catch (FileNotFoundException e) {
        //     System.out.print("Error with ratings file");
        //     e.printStackTrace();
        // }
        return ratingArr;
    }
    // if the user hasn't seen the movie and it's above the rating threshold 
    //output: prints each user as follows: "UserName's recommended movies are " + the top three movies
    //TODO: fix output, add check for movies they've already seen
    public static void recommendMovies(ArrayList<ArrayList<Rating>> wM, User[] u, Movie[] m){
        for (User currentUser : u){
            int l = currentUser.getRatingArray().size()-1;
            for (int i = 0; i < l; i++){
                for (int j = 0; j < l-i; j = 0){
                    if(currentUser.getRatingArray().get(i).getScore() > currentUser.getRatingArray().get(i+1).getScore()){
                        Rating temp = currentUser.getRatingArray().get(i);
                        currentUser.getRatingArray().set(i, currentUser.getRatingArray().get(i+1));
                        currentUser.getRatingArray().set(i+1, temp);
                    }
                }
            }
            System.out.println(currentUser.getName() + "'s top 3 recommended movies are: " + currentUser.getRatingArray().get(0).getTitle() + currentUser.getRatingArray().get(0).getScore() + ", " + currentUser.getRatingArray().get(1).getTitle() + currentUser.getRatingArray().get(1).getScore() + ", " + currentUser.getRatingArray().get(2).getTitle() + currentUser.getRatingArray().get(2).getScore());
        }
        System.out.println("finished recommendMovies");
    }
}
