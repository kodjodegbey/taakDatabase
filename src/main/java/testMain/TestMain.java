package testMain;

import Classes.Klant;
import JDBI.dBJDBI;

public class TestMain {
    private static String connectionString = "jdbc:sqlite:CSA2.db";
    public static void main(String[] args) {
        dBJDBI db = new dBJDBI(connectionString);

        var klant =new Klant("54","63","pot","jos",
                "straat0",20,20,10,false,1,"email0");
        db.voegklantToe(klant);
    }
}
