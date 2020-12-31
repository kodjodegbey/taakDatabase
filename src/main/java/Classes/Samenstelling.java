package Classes;

public class Samenstelling {
    private String naam_product;
    private int contract_id,week;

    public Samenstelling() {
    }

    public Samenstelling(String naam_product, int contract_id, int week) {
        this.naam_product = naam_product;
        this.contract_id = contract_id;
        this.week = week;
    }

    public String getNaam_product() {
        return naam_product;
    }

    public void setNaam_product(String naam_product) {
        this.naam_product = naam_product;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "Samenstelling{" +
                "naam_product='" + naam_product + '\'' +
                ", contract_id=" + contract_id +
                ", week=" + week +
                '}';
    }
}
