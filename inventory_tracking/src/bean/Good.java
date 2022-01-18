package bean;

public class Good {
    private String goodId;
    private String goodName;
    private String type;
    private String supplier;
    private int count;
    private float price;

    public Good(){}
    public Good(String goodId, String goodName, String type, String supplier, int count, float price) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.type = type;
        this.supplier = supplier;
        this.count = count;
        this.price = price;
    }

    public String getGoodId() {
        return goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public String getType() {
        return type;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getCount() {
        return count;
    }

    public float getPrice() {
        return price;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
