import Classes.*;
import JDBI.dBJDBI;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestJDBI {
    private String connectionString = "jdbc:sqlite:CSA2.db";
    protected dBJDBI db = new dBJDBI(connectionString);

    @Test
    public void test_getAanbod() {
        ArrayList<BoerderijAanbod> boerderijen = (ArrayList<BoerderijAanbod>) db.getBoerderijAanbod();
        Assert.assertTrue("der is geen aanbod", boerderijen.size() != 0);
        for (BoerderijAanbod b : boerderijen) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void test_getKlanten(){
        ArrayList<Klant> klanten = (ArrayList<Klant>) db.getKlanten();
        Assert.assertTrue("der zijn geen klanten", klanten.size() != 0);
        for (Klant b : klanten) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void test_get_all_boerderij(){
        ArrayList<Boerderij> Boerderijen = (ArrayList<Boerderij>) db.getBoerderijen();
        Assert.assertTrue("der zijn geen klanten", Boerderijen.size() != 0);
        for (Boerderij b : Boerderijen) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void test_get_Producten(){
        ArrayList<Product> Producten = (ArrayList<Product>) db.getProducten();
        Assert.assertTrue("der zijn geen producten", Producten.size() != 0);
        for (Product b : Producten) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void test_getPaketten(){
        ArrayList<Pakket> Pakketen = (ArrayList<Pakket>) db.getPakketen();
        Assert.assertTrue("der zijn geen producten", Pakketen.size() != 0);
        for (Pakket b : Pakketen) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void test_Inschrijvingen(){
        ArrayList<Inschrijving> Inschrijvingen = (ArrayList<Inschrijving>) db.getInshrijvin();
        Assert.assertTrue("der zijn geen producten", Inschrijvingen.size() == 0);
        for (Inschrijving b : Inschrijvingen) {
            System.out.println(b.toString());
        }
    }




}

