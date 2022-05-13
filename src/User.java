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
