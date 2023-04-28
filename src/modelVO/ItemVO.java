package modelVO;

public class ItemVO {
    private String name;
    private String model;
    private int quantity;
    private float iva;
    private float neto;
    private float brute;

    public ItemVO() {

    }

    public ItemVO(String name, String model, int quantity, float iva, float neto, float brute) {
        this.name = name;
        this.model = model;
        this.quantity = quantity;
        this.iva = iva;
        this.neto = neto;
        this.brute = brute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getNeto() {
        return neto;
    }

    public void setNeto(float neto) {
        this.neto = neto;
    }

    public float getBrute() {
        return brute;
    }

    public void setBrute(float brute) {
        this.brute = brute;
    }
    
}
