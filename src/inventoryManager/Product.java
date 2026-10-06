package inventoryManager;

public class Product {
private String name=null;
private String sku=null;
private double price=0;
private int quantity = 0;
//constructor
public Product(String name, String sku, double price, int quantity) {
	this.name = name;
	this.sku = sku;
	this.price = price;
	this.quantity = quantity;
}
//getters
public double getPrice() {
	return price;
}
public String getName() {
	return name;
}
public String getSku() {
	return sku;
}
public int getQuantity() {
	return quantity;
}
//setters
public void setPrice(double newPrice) {
	price = newPrice;
}
public void setName(String newName) {
	name = newName;
}
public void setSku(String newSku) {
	sku = newSku;
}
public void setQuantity(int newQuantity) {
	quantity = newQuantity;
}



}
