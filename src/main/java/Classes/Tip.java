package Classes;

public class Tip {

    private String naamProduct,text;
    private int tip_id;

    public Tip() {
    }

    public Tip(String naamProduct, String text, int tip_id) {
        this.naamProduct = naamProduct;
        this.text = text;
        this.tip_id = tip_id;
    }

    public String getNaamProduct() {
        return naamProduct;
    }

    public void setNaamProduct(String naamProduct) {
        this.naamProduct = naamProduct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "naamProduct='" + naamProduct + '\'' +
                ", text='" + text + '\'' +
                ", tip_id=" + tip_id +
                '}';
    }
}
