package model;

public class ExcelModel {
    
    private String id;
    private String name;
    private String address;
    private String product_id;
    private double total;

    public ExcelModel() {
    }

    public ExcelModel(String id, String name, String address, String product_id, double total) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.product_id = product_id;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ExcelModel{" + "id=" + id + ", name=" + name + ", address=" + address + ", product_id=" + product_id + ", total=" + total + '}';
    }
    
    
                
}
