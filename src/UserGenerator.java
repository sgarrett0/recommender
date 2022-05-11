public class UserGenerator {


    public static User[] generate(int n) {
        User[] users = new User[n];
        for (int i = 0; i < n; i++) {
            String title = "User " + i;
            int actionScore = (int) (Math.random() * 99);
            int comedyScore = (int) (Math.random() * 99);
            int dramaScore = (int) (Math.random() * 99);
            int romanceScore = (int) (Math.random() * 99);
            int mysteryScore = (int) (Math.random() * 99);
            int horrorScore = (int) (Math.random() * 99);
            int sciFiScore = (int) (Math.random() * 99);
            int docScore = (int) (Math.random() * 99);
            users[i] = new User(title, actionScore, comedyScore, dramaScore, romanceScore, mysteryScore, horrorScore, sciFiScore, docScore);
        }
        return users;
    }
}
