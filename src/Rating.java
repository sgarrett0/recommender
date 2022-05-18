public class Rating {
    private String title;
    private int score;

    public Rating(String title, int score){
        this.title = title;
        this.score = score;
    }
    public Rating(String[] strings) {
    }
    public String getTitle(){
        return this.title;
    }
    public int getScore(){
        return score;
    }
}
