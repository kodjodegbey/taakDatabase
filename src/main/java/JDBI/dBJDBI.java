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
    // verwijder inschrijving
    public void verwijderKlanten(String rijksregister){
        String sql ="DELETE from klant where rijksregister = "+rijksregister;
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
    }

    public void updatKlant(Klant klant){
        int haalaf = (klant.isAfgehaal()) ? 1:0;
        String sql = "update Klant set naam = '" +klant.getNaam()+ "',straat = '" + klant.getStraat() +
                "',voornaam='"+klant.getVoornaam()+"',"+"gsm_nummer='"+klant.getGsm_nummer()+"',"+"week="+klant.getWeek()+
                ",nummer =" + klant.getNummer() +",postcode = "+klant.getPostcode() + ",afgehaald="+haalaf+
                ",email = '" +klant.getEmail()+"' where rijksregister = "+ klant.getRijksregister();
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
    }

    public void voegklantToe(Klant klant){
        int haalaf = (klant.isAfgehaal()) ? 1:0;
        var sql ="INSERT into Klant (rijksregister,gsm_nummer,naam,voornaam,nummer,postcode,straat,afgehaald,week,contract_id,email)\n" +
                "values('"+klant.getRijksregister() +"','"+klant.getGsm_nummer()+"','" + klant.getNaam() +"','"+klant.getVoornaam()+
                "'," + klant.getNummer()+","+ klant.getPostcode()+",'"+klant.getStraat()+"',"+haalaf+","+klant.getWeek()+"," +
                klant.getContract_id()+",'"+klant.getEmail()+"')";
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
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

     public void verwijderBoerderijTransaction(Boerderij boerderij){
        String verwijderSamenstelling = "delete from Samenstelling where contract_id = \n" +
                "(SELECT Biedt_aan.contract_id from Biedt_aan \n" +
                "where Biedt_aan.boerderij_id = "+ boerderij.getBoerderij_id() +")" ;
        String verwijderPakket = " delete from  Pakket where  Pakket.pakket_id =\n" +
                "(SELECT Biedt_aan.pakket_id from Biedt_aan \n" +
                "where Biedt_aan.boerderij_id= " + boerderij.getBoerderij_id()+")";
        String verwijderBiedAan = "delete from Biedt_aan where Biedt_aan.boerderij_id = "+boerderij.getBoerderij_id();
        String verwijderBoerderij = "delete from Boerderij where Boerderij.boerderij_id ="+ boerderij.getBoerderij_id();

        System.out.println(verwijderSamenstelling);
        System.out.println(verwijderPakket);
        System.out.println(verwijderBiedAan);
        System.out.println(verwijderBoerderij);

        jdbi.useTransaction(handle -> {
            handle.execute(verwijderSamenstelling);
            handle.execute(verwijderPakket);
            handle.execute(verwijderBiedAan);
            handle.execute(verwijderBoerderij);
        });

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

    public void voegProductToe(String productNaam, boolean inbegrepen){
        int in = (inbegrepen) ? 1:0 ;
        String sql = "insert into Product (naam,inbegrepen)\n" +
                "VALUES('"+ productNaam + "',"+ in + ")";
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });

    }

    public void verwijderProduct(String productNaam){
        String sql =" delete from Product where Product.naam ='" +productNaam+"'";
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
    }

    public void updateProduct(String productNaam, Boolean inbegrepen){
        int in = (inbegrepen) ? 1:0;
        String sql ="update Product set inbegrepen = "+in+
                " where Product.naam = '" + productNaam + "'";
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
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

    public void voegPakketToe(String grootte){
        int kinderen = -1 ;
        int volwassenen= -1;
       grootte = grootte.toLowerCase();
        switch (grootte){
            case "xl":
                kinderen = 5;
                volwassenen = 5 ;
                System.out.println("je heb een XL pakket");
               break;
            case"l":
                kinderen = 4;
                volwassenen = 4 ;
                System.out.println("je heb een L pakket");
                break;
            case"m":
                kinderen = 2;
                volwassenen = 3 ;
                System.out.println("je heb een M pakket");
                break;
            case "s":
                kinderen = 2;
                volwassenen = 1 ;
                System.out.println("je heb een S pakket");
                break;
            case "xs":
                kinderen = 0;
                volwassenen = 2 ;
                System.out.println("je heb een XS pakket");
                break;
            default:
                System.out.println("voer de juiste maat in");
        }

        if(kinderen > -1 && volwassenen > -1){
            grootte = grootte.toUpperCase();
            String sql ="INSERT INTO Pakket(grootte,kinderen,volwassenen)\n" +
                    "values('"+grootte+"',"+ kinderen +","+volwassenen +")";
            System.out.println(sql);
            jdbi.useHandle(handle -> {
                handle.execute(sql);
            });
        }
    }
// todo  eerst bied aan weg dan pakker weg kijken of het verbond is aan een klant
    public void verwijderPakket(int pakket_id){
        String sql =" delete from Pakket where Pakket.pakket_id =" +pakket_id;
        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
    }

    public void upDataPakket(int pakket_id,String grootte){
        int kinderen = -1 ;
        int volwassenen= -1;
        grootte = grootte.toLowerCase();
        switch (grootte){
            case "xl":
                kinderen = 5;
                volwassenen = 5 ;
                System.out.println("je heb een XL pakket");
                break;
            case"l":
                kinderen = 4;
                volwassenen = 4 ;
                System.out.println("je heb een L pakket");
                break;
            case"m":
                kinderen = 2;
                volwassenen = 3 ;
                System.out.println("je heb een M pakket");
                break;
            case "s":
                kinderen = 2;
                volwassenen = 1 ;
                System.out.println("je heb een S pakket");
                break;
            case "xs":
                kinderen = 0;
                volwassenen = 2 ;
                System.out.println("je heb een XS pakket");
                break;
            default:
                System.out.println("voer de juiste maat in");
        }

        if(kinderen > -1 && volwassenen > -1){
            grootte = grootte.toUpperCase();
            String sql ="update Pakket set grootte ='"+grootte+  "',"+"kinderen="+kinderen+ ","
                    +"volwassenen="+volwassenen+" where pakket_id ="+ pakket_id;
            System.out.println(sql);
            jdbi.useHandle(handle -> {
                handle.execute(sql);
            });
        }
    }


    public List<Inschrijving> getInshrijving(){
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

    public void updateInschrijving(String rijksregister,int contract_id ){

       String sql= "update Klant set contract_id = "+contract_id+" WHERE\n" +
               "Klant.rijksregister ='"+rijksregister+"'";

        System.out.println(sql);
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
    }

    public ArrayList<ContractEnPrijs> beschikbaarContracten(String size){
        ArrayList<Integer> listPakket_id;
        size = size.toUpperCase();
        String selectPakket = "select Pakket.pakket_id from Pakket where \n" +
                "Pakket.grootte ='"+size+"'";
        System.out.println(selectPakket);
        listPakket_id = (ArrayList<Integer>) jdbi.withHandle(handle -> {
            return handle.createQuery(selectPakket)
                    .mapTo(Integer.class)
                    .list();
        });
        List<ContractEnPrijs> listcontract = new ArrayList<>();
        for (int i =0;i<listPakket_id.size();i++) {
            System.out.println(listPakket_id.get(i));
            String selectContract = "select Biedt_aan.contract_id from Biedt_aan \n" +
                    "where Biedt_aan.pakket_id ="+listPakket_id.get(i);
            System.out.println(selectContract);
            ContractEnPrijs cp =  jdbi.withHandle(handle -> handle.createQuery(selectContract)
                    .mapToBean(ContractEnPrijs.class)
                    .first());
            if(cp.getPrijs()>-1){
                listcontract.add(cp);
            }
        }
        for(ContractEnPrijs c: listcontract){
            System.out.println(c.toString());
        }
        ArrayList<Integer> klantcontract_id ;
        String selectContractklant = "select Klant.contract_id from Klant ";
        System.out.println(selectContractklant);
        klantcontract_id = (ArrayList<Integer>) jdbi.withHandle(handle -> {
            return handle.createQuery(selectContractklant)
                    .mapTo(Integer.class)
                    .list();
        });
        for (int i =0;i<klantcontract_id.size();i++) {
            System.out.println(klantcontract_id.get(i));
        }
        for (int i = 0; i < listcontract.size() ; i++) {
            if(klantcontract_id.contains(listcontract.get(i).getContract_id())){
                listcontract.remove(listcontract.get(i));
                i--;
            }

        }

        System.out.println("die zijn de beschikbaar contracten");
        for(ContractEnPrijs c: listcontract){
            System.out.println(c.toString());
        }

        return (ArrayList<ContractEnPrijs>) listcontract;
    }

    // niewschrijvin geef groote in en zoek beschikbaar contracten maar een nieuw klant met die contract


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

    public  void maakAanbod(int pakket_id,int boederij_id,int prijs){
        String sql = "INSERT into Biedt_aan(prijs,boerderij_id,pakket_id)\n" +
                "values("+prijs+","+boederij_id+","+pakket_id+")";
        jdbi.useHandle(handle -> {
            handle.execute(sql);
        });
    }

    public ArrayList<Integer> beschikbaarPakkettenVoorAanbod(){
        String selecteerPaketId = "SELECT Pakket.pakket_id from Pakket";
        ArrayList<Integer> pakketIds ;
        pakketIds = (ArrayList<Integer>) jdbi.withHandle(handle -> {
           return handle.createQuery(selecteerPaketId)
                   .mapTo(Integer.class)
                   .list();
        });
        for (int i = 0; i < pakketIds.size(); i++) {
            System.out.println(pakketIds.get(i));
        }
        String selecteerPaketIdBiedaan = "SELECT Biedt_aan.pakket_id from Biedt_aan";
        ArrayList<Integer> pakketIdsBiedaan ;
        pakketIdsBiedaan = (ArrayList<Integer>) jdbi.withHandle(handle -> {
            return handle.createQuery(selecteerPaketIdBiedaan)
                    .mapTo(Integer.class)
                    .list();
        });
        for (int i = 0; i < pakketIdsBiedaan.size(); i++) {
            System.out.println(pakketIdsBiedaan.get(i));
        }
        for (int i = 0; i <pakketIds.size() ; i++) {
            if(pakketIdsBiedaan.contains(pakketIds.get(i))){
                pakketIds.remove(pakketIds.get(i));
                i--;
            }
        }
        System.out.println("die is de uitkomst");
        for (int i = 0; i < pakketIds.size(); i++) {
            System.out.println(pakketIds.get(i));
        }
    return pakketIds;
    }

    public void updateAanbod(int boerderij_id,int prijs,String grootte,int pakket_id){
        upDataPakket(pakket_id,grootte);
        String updateBiedAan = "UPDATE Biedt_aan set prijs ="+ prijs+ " where Biedt_aan.boerderij_id ="+boerderij_id;
        jdbi.useHandle(handle -> {
             handle.execute(updateBiedAan);
        });
    }

    public ArrayList<Integer> getPakket_id_VanBoerderij(int boerderij_id){
        ArrayList<Integer> pakketIds;
        String sql = "SELECT Biedt_aan.pakket_id from Biedt_aan where Biedt_aan.boerderij_id ="+boerderij_id;
        pakketIds= (ArrayList<Integer>) jdbi.withHandle(handle -> {
           return handle.createQuery(sql)
                    .mapTo(Integer.class)
                    .list();
        });
        for (int i = 0; i < pakketIds.size(); i++) {
            System.out.println(pakketIds.get(i));
        }
        return pakketIds;
    }
    //todo kijken of de contract id bij een klant hoort zo niet bied aan weg dan pakker weg
    public void verwijderAanbod(int boerderij_id,int pakket_id){
    verwijderPakket(pakket_id);
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











//    public void verwijderSamenstellingBoerderij(Boerderij boerderij){
//        String verwijder = "delete from Samenstelling where contract_id = \n" +
//                "(SELECT Biedt_aan.contract_id from Biedt_aan \n" +
//                "where Biedt_aan.boerderij_id = "+ boerderij.getBoerderij_id() +")" ;
//        System.out.println(verwijder);
//        jdbi.useHandle(handle -> {
//            handle.execute(verwijder);
//        });
//    }
//
//    public void verwijderPakketBoerderij(Boerderij boerderij){
//        String verwijder = " delete from  Pakket where  Pakket.pakket_id =\n" +
//                "(SELECT Biedt_aan.pakket_id from Biedt_aan \n" +
//                "where Biedt_aan.boerderij_id= " + boerderij.getBoerderij_id()+")";
//        System.out.println(verwijder);
//        jdbi.useHandle(handle -> {
//            handle.execute(verwijder);
//        });
//    }
//
//    public void verwijdervanBiedAan(Boerderij boerderij){
//        String verwijder = "delete from Biedt_aan where Biedt_aan.boerderij_id = "+boerderij.getBoerderij_id();
//        System.out.println(verwijder);
//        jdbi.useHandle(handle -> {
//            handle.execute(verwijder);
//        });
//    }


}
