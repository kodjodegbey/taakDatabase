package testMain;

import Classes.BoerderijAanbod;
import JDBI.dBJDBI;

import java.util.ArrayList;

public class TestMain {
    private static String connectionString = "jdbc:sqlite:CSA2.db";
    public static void main(String[] args) {
        dBJDBI db = new dBJDBI(connectionString);
        ArrayList<BoerderijAanbod> boerderijen =(ArrayList<BoerderijAanbod>) db.getBoerderijAanbod();
        for(BoerderijAanbod b : boerderijen){
            System.out.println(b.toString());
        }

    }
}
