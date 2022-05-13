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
    
    public Movie(String[] info){
        this.title = info[0];
        this.actionScore = Integer.parseInt(info[1]);
        this.comedyScore = Integer.parseInt(info[2]);
        this.dramaScore = Integer.parseInt(info[3]);
        this.romanceScore = Integer.parseInt(info[4]);
        this.mysteryScore = Integer.parseInt(info[5]);
        this.horrorScore = Integer.parseInt(info[6]);
        this.sciFiScore = Integer.parseInt(info[7]);
        this.docScore = Integer.parseInt(info[8]);
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

