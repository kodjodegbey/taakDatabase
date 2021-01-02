package testMain;

import Classes.Klant;
import JDBI.dBJDBI;

public class TestMain {
    private static String connectionString = "jdbc:sqlite:CSA2.db";
    public static void main(String[] args) {
        dBJDBI db = new dBJDBI(connectionString);
        db.updateAanbod(2,100,"L",1);
    }
}
