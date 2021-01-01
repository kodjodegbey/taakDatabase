package testMain;

import Classes.Boerderij;

public class TestMain {
    private static String connectionString = "jdbc:sqlite:CSA2.db";
    public static void main(String[] args) {
//        dBJDBI db = new dBJDBI(connectionString);
//        ArrayList<BoerderijAanbod> boerderijen =(ArrayList<BoerderijAanbod>) db.getBoerderijAanbod();
//        for(BoerderijAanbod b : boerderijen){
//            System.out.println(b.toString());
//        }
        Boerderij boerderij = new Boerderij(2,"boer6","staat6",6,6,"email6");
        String sql = "update Boerderij set naam = '" +boerderij.getNaam()+ "',straat = '" + boerderij.getStraat() +
                "',nummer =" + boerderij.getNummer() +",postcode = "+boerderij.getNummer() +
                ",email = '" +boerderij.getEmails()+"' where boerderij_id = "+ boerderij.getBoerderij_id();
        System.out.println(sql);
    }
}
