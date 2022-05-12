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
    
    public Movie(String name){
        this.title = name;
        this.actionScore = 0;
        this.comedyScore = 0;
        this.dramaScore = 0;
        this.romanceScore = 0;
        this.horrorScore = 0;
        this.sciFiScore = 0;
        this.docScore = 0;
    }
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
}

