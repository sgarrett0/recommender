public class User {
private String name;
private int userActionScore;
private int userComedyScore;
private int userDramaScore;
private int userRomanceScore;
private int userMysteryScore;
private int userHorrorScore;
private int userSciFiScore;
private int userDocScore;

    public User(String[] info){
        this.name = info[0];
        this.userActionScore = Integer.parseInt(info[1]);
        this.userComedyScore = Integer.parseInt(info[2]);
        this.userDramaScore = Integer.parseInt(info[3]);
        this.userRomanceScore = Integer.parseInt(info[4]);
        this.userMysteryScore = Integer.parseInt(info[5]);
        this.userHorrorScore = Integer.parseInt(info[6]);
        this.userSciFiScore = Integer.parseInt(info[7]);
        this.userDocScore = Integer.parseInt(info[8]);
    }
    public String getName(){
        return this.name;
    }
 
    public int getActionScore(){
        return userActionScore;
    }
 
    public int getComedyScore(){
        return userComedyScore;
    }
 
    public int getDramaScore(){
        return userDramaScore;
    }
 
    public int getRomanceScore(){
        return userRomanceScore;
    }
 
    public int getMysteryScore(){
        return userMysteryScore;
    }
    
    public int getHorrorScore(){
        return userHorrorScore;
    }
 
    public int getSciFiScore(){
        return userSciFiScore;
    }
    public int getDocScore(){
        return userDocScore;
    }
    
}
