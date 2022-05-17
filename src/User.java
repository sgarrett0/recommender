import java.util.ArrayList;

public class User {
    private String name;
    private int actionScore;
    private int comedyScore;
    private int dramaScore;
    private int romanceScore;
    private int mysteryScore;
    private int horrorScore;
    private int sciFiScore;
    private int docScore;
    private int hash = 1;
    private ArrayList<Movie> recommended;
    private ArrayList<Movie> watchHistory;

    public User(String name, int actionScore, int comedyScore, int dramaScore, int romanceScore, int mysteryScore, int horrorScore, int sciFiScore, int docScore){
        this.name = name;
        this.actionScore = actionScore;
        this.comedyScore = comedyScore;
        this.dramaScore = dramaScore;
        this.romanceScore = romanceScore;
        this.mysteryScore = mysteryScore;
        this.horrorScore = horrorScore;
        this.sciFiScore = sciFiScore;
        this.docScore = docScore;
        this.recommended = new ArrayList<Movie>();
        this.watchHistory = generateWatchHistory();
    }

    public static ArrayList<Movie> generateWatchHistory() {
        ArrayList<Movie> watchHistory = new ArrayList<Movie>();
        for (int i=0; i<200; i++) {
            watchHistory.add(new Movie("Movie " + (int) Math.random()*199));
        }
        return watchHistory;
    }

    public void addToRecommended(Movie movie){
        for (int i=0; i<watchHistory.size(); i++) {
            if (watchHistory.get(i).getTitle().equals(movie.getTitle())) {
                return;
            }
        }
        recommended.add(movie);
    }

    public void addToRecommended(ArrayList<Movie> movieList) {
        for (int i=0; i<movieList.size(); i++) {
            for (int j=0; j<recommended.size(); j++) {
                if (watchHistory.get(j).getTitle().equals(movieList.get(i).getTitle())) {
                    return;
                }
            }
            recommended.add(movieList.get(i));
        }
    }

    public void printRecommended() {
        System.out.println(recommended);
    }

    @Override
    public String toString() {
        return "User{ name=" + name +"; hash=" + hash+"}";
    }

    public String getName() {
        return name;
    }

    public int getActionScore() {
        return actionScore;
    }

    public int getComedyScore() {
        return comedyScore;
    }

    public int getDramaScore() {
        return dramaScore;
    }

    public int getRomanceScore() {
        return romanceScore;
    }

    public int getMysteryScore() {
        return mysteryScore;
    }

    public int getHorrorScore() {
        return horrorScore;
    }

    public int getSciFiScore() {
        return sciFiScore;
    }

    public int getDocScore() {
        return docScore;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int finalDigit) {
        this.hash = this.hash * 10 + finalDigit;
    }
    
    
    
}
