public class Rating{
    private String title;
    private int score;

    public Rating(String title, int score){
        this.title = title;
        this.score = score;
    }

    public String getMovie(){
        return this.title;
    }

    public int getScore(){
        return score;
    }
}
