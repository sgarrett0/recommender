public class Movie {
    private String title;
    private int actionScore;
    private int comedyScore;
    private int dramaScore;
    private int romanceScore;
    private int mysteryScore;
    private int horrorScore;
    private int sciFiScore;
    private int docScore;
    private int hash = 1;
    
    public Movie(String name, int action, int comedy, int drama, int romance, int mystery, int horror, int sciFi, int documetary){
        this.title = name;
        this.actionScore = action;
        this.comedyScore = comedy;
        this.dramaScore = drama;
        this.romanceScore = romance;
        this.horrorScore = horror;
        this.sciFiScore = sciFi;
        this.docScore = documetary;
    }

    public Movie(String name) {
        this.title = name;
        this.actionScore = 50;
        this.comedyScore = 50;
        this.dramaScore = 50;
        this.romanceScore = 50;
        this.mysteryScore = 50;
        this.horrorScore = 50;
        this.sciFiScore = 50;
        this.docScore = 50;
    }

    public Movie(String[] info){
        this.title = info[0];
        this.actionScore = Integer.parseInt(info[1]);
        this.comedyScore = Integer.parseInt(info[2]);
        this.dramaScore = Integer.parseInt(info[3]);
        this.romanceScore = Integer.parseInt(info[4]);
        this.horrorScore = Integer.parseInt(info[5]);
        this.sciFiScore = Integer.parseInt(info[6]);
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + "; hash=" + hash + '}';
    }

   public String getTitle(){
       return this.title;
   }

    


   public int getActionScore(){
       return actionScore;
   }

   public int getComedyScore(){
       return comedyScore;
   }

   public int getDramaScore(){
       return dramaScore;
   }

   public int getRomanceScore(){
       return romanceScore;
   }

   public int getMysteryScore(){
       return mysteryScore;
   }
   
   public int getHorrorScore(){
       return horrorScore;
   }

   public int getSciFiScore(){
       return sciFiScore;
   }
   public int getDocScore(){
       return docScore;
   }

   public int getHash(){
       return this.hash;
   }

   public void setHash(int finalDigit){
       this.hash = this.hash * 10 + finalDigit;
   }
}

