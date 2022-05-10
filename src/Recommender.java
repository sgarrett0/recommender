import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Recommender {
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...");
        createMovieList();
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
        
        return null;
    }


    /**
     * CONDITIONS: 
     *      There are N users in the txt file...
     *      There are Y attributes per user...
     * Read info from users.txt file to create N user objects. 
     * @return an array of user objects.
     */
    public User[] createUserList(){
        User[][] userArr;
        return null;
    }
}
