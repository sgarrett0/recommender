import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Recommender {
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...");
        Movie[] movieArr = createMovieList();
        User[] userArr = createUserList();

        System.out.println("Running dotProduct");
        dotProduct(movieArr, userArr);
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
        int userRatings = 9;
        User[] userArr = new User[userNum];
        String[][] allUsers = new String[userNum][userRatings];
        File users = new File("./lib/users.txt");
        try {
            Scanner readRatings = new Scanner(users);
            for(int x = 0; x < userNum; x++){
                for(int y = 0; y < userRatings; y++){
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
            for (int j = 0; j < m.length; j++){
                double movieScore = u[i].getActionScore() * m[j].getActionScore() + u[i].getComedyScore() * m[j].getComedyScore() + u[i].getDramaScore() * m[j].getDramaScore() + u[i].getRomanceScore() * m[j].getRomanceScore() + u[i].getMysteryScore() * m[j].getMysteryScore() + u[i].getHorrorScore() * m[j].getHorrorScore() + u[i].getSciFiScore() * m[j].getSciFiScore() + u[i].getDocScore() * m[j].getDocScore();
                movieScore /= 10;
                System.out.println(u[i].getName() + "'s score for " + m[j].getTitle() + " is " + movieScore);
            }
        }
    }
}
