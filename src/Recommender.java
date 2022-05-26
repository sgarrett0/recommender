import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Recommender {
    private static HashMap<Integer, ArrayList<Movie>> movieBuckets = new HashMap<Integer, ArrayList<Movie>>();
    private static HashMap<Integer, ArrayList<User>> userBuckets = new HashMap<Integer, ArrayList<User>>();
    public static void main(String[] args) throws Exception {
        Movie[] movieArr = createMovieList();
        User[] userArr = createUserList();

        userArr = dotProduct(movieArr, userArr);
        recommendMovies(userArr, movieArr);
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
        int movieGenres = 7; //was 9
        Movie[] movieArr = new Movie[movieNum];
        String[][] allMovies = new String[movieNum][movieGenres];
        File movies = new File("./lib/movies.txt");
        try (Scanner readGenres = new Scanner(movies)) {
            for(int i = 0; i < movieNum; i++){
                for(int j = 0; j < movieGenres; j++){
                    allMovies[i][j] =  readGenres.nextLine();
                    //System.out.println(allMovies[i][j]);
                }
                Movie nextMovie = new Movie(allMovies[i]);
                movieArr[i] = nextMovie;
            }
        }catch (FileNotFoundException e) {
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
        int userGenreRatings = 7;
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
    public static User[] dotProduct(Movie[] m, User[] u){
        for (int i = 0; i < u.length; i++){
            for (int j = 0; j < m.length; j++){
                double movieScore = u[i].getActionScore() * m[j].getActionScore() + u[i].getComedyScore() * m[j].getComedyScore() + u[i].getDramaScore() * m[j].getDramaScore() + u[i].getRomanceScore() * m[j].getRomanceScore() + u[i].getMysteryScore() * m[j].getMysteryScore() + u[i].getHorrorScore() * m[j].getHorrorScore() + u[i].getSciFiScore() * m[j].getSciFiScore() + u[i].getDocScore() * m[j].getDocScore();
                movieScore /= 10;
                Rating r = new Rating(m[j].getTitle(), movieScore);
                u[i].setRatingArray(r);
            }
        }
        return u;
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
    //Output: prints each user as follows: "UserName's recommended movies are " + the top three movies
    //TODO: fix output, add check for movies they've already seen
    public static void recommendMovies(User[] u, Movie[] m){
        for (User currentUser : u){
            
            for (Rating r : currentUser.getRatingArray()){
                if (currentUser.getWatchHistory().contains(r.getTitle())){
                    currentUser.getRatingArray().remove(r);
                }
            }
            int l = currentUser.getRatingArray().size();
            for (int i = 0; i < l; i++){
                int maxIndex = i;
                for (int j = 0; j < l; j++){
                    if(currentUser.getRatingArray().get(j).getScore() < currentUser.getRatingArray().get(maxIndex).getScore()){
                        maxIndex = j;
                    }
                    Rating temp = currentUser.getRatingArray().get(maxIndex);
                    currentUser.getRatingArray().set(maxIndex, currentUser.getRatingArray().get(i));
                    currentUser.getRatingArray().set(i, temp);
                }
            }
            System.out.println(currentUser.getName() + "'s top 3 recommended movies are: " + currentUser.getRatingArray().get(0).getTitle() + currentUser.getRatingArray().get(0).getScore() + ", " + currentUser.getRatingArray().get(1).getTitle() + currentUser.getRatingArray().get(1).getScore() + ", " + currentUser.getRatingArray().get(2).getTitle() + currentUser.getRatingArray().get(2).getScore());
        }

    }
}
