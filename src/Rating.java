public class Rating {
    private String title;
    private double score;

    public Rating(String title, double score){
        this.title = title;
        this.score = score;
    }
    public Rating(String[] strings) {
    }
    public String getTitle(){
        return this.title;
    }
    public double getScore(){
        return score;
    }
}
