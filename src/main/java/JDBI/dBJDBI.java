package JDBI;

import Classes.*;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;

public class dBJDBI {

    private final String connectionString;
    private final Jdbi jdbi;
    public dBJDBI( String connectionString) {
        this.connectionString = connectionString;
        jdbi =Jdbi.create(connectionString);
    }

    public List<Klant> getKlanten(){
            ArrayList<Klant> klanten ;
    klanten = (ArrayList<Klant>) jdbi.withHandle(handle -> {

        return handle.createQuery("SELECT * from Klant ")
                .mapToBean(Klant.class)
                .list();
            });
    return klanten;
}
//todo fix de eamil
    public List<Boerderij> getBoerderijen(){
        ArrayList<Boerderij> boerderijen ;
        boerderijen = (ArrayList<Boerderij>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * from Boerderij order by Boerderij.boerderij_id")
                    .mapToBean(Boerderij.class)
                    .list();
        });
        return boerderijen;
    }

    public void voegBoerderijToe(Boerderij boerderij){
        String sql = "insert into Boerderij(naam,straat,nummer,postcode,email)" +
                "VALUES ('" + boerderij.getNaam() + "', '" + boerderij.getStraat() + "', " + boerderij.getNummer() + ", " +
                boerderij.getPostcode() + ",'"+  boerderij.getEmails() +   "')";
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
    }

    public void upDate_boerdrij(Boerderij boerderij){
        String sql = "update Boerderij set naam = '" +boerderij.getNaam()+ "',straat = '" + boerderij.getStraat() +
                "',nummer =" + boerderij.getNummer() +",postcode = "+boerderij.getNummer() +
                ",email = '" +boerderij.getEmails()+"' where boerderij_id = "+ boerderij.getBoerderij_id();
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
    }
    public void verwijder_boerderij(Boerderij boerderij){

    }

    public List<Product> getProducten(){
        ArrayList<Product> boerderijen ;
        boerderijen = (ArrayList<Product>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * from Product")
                    .mapToBean(Product.class)
                    .list();
        });
        return boerderijen;
    }

    public List<Pakket> getPakketen(){
        ArrayList<Pakket> boerderijen ;
        boerderijen = (ArrayList<Pakket>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * from Pakket")
                    .mapToBean(Pakket.class)
                    .list();
        });
        return boerderijen;
    }

    public List<Inschrijving> getInshrijvin(){
        ArrayList<Inschrijving> boerderijen ;
        boerderijen = (ArrayList<Inschrijving>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT Pakket.grootte,Pakket.kinderen,Pakket.volwassenen,Boerderij.naam,rijksregister,Biedt_aan.prijs \n" +
                    "from Pakket,Boerderij,Klant,Biedt_aan\n" +
                    "where (Pakket.pakket_id = Biedt_aan.pakket_id  AND klant.contract_id = Biedt_aan.contract_id)\n" +
                    "and Boerderij.boerderij_id = Biedt_aan.boerderij_id ")
                    .mapToBean(Inschrijving.class)
                    .list();
        });
        return boerderijen;
    }

    public List<BoerderijAanbod> getBoerderijAanbod(){
        ArrayList<BoerderijAanbod> boerderijen ;
        boerderijen = (ArrayList<BoerderijAanbod>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT Pakket.pakket_id,Pakket.grootte,Pakket.kinderen,Pakket.volwassenen,Boerderij.naam,Biedt_aan.prijs \n" +
                    "from Pakket,Boerderij,Biedt_aan\n" +
                    "where Pakket.pakket_id = Biedt_aan.pakket_id \n" +
                    "and Boerderij.boerderij_id = Biedt_aan.boerderij_id \n" +
                    "order by Biedt_aan.prijs ")
                    .mapToBean(BoerderijAanbod.class)
                    .list();
        });
        return boerderijen;
    }




//todo weet ik nog niet hoe ik dit moet oplossen maar
    public List<Tip> getTips(){
        ArrayList<Tip> boerderijen ;
        boerderijen = (ArrayList<Tip>) jdbi.withHandle(handle -> {
            return handle.createQuery("select * from Tip")
                    .mapToBean(Tip.class)
                    .list();
        });
        return boerderijen;
    }














}
