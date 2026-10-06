package inventoryManager;
import java.util.ArrayList;

public class InventoryManager {
	//array declaration
ArrayList<Product> productList = new ArrayList<Product>();
//add new product to the list
public void addProduct(Product p) {
	productList.add(p);
}
//updates stock amount of product object
public void updateStock(String sku, int amount) {
	for(int i = 0; i < productList.size()-1; i++) {
		if(sku == productList.get(i).getSku()) {
			productList.get(i).setQuantity(amount);
		}
	}
}
public void displayAllItems() {
	System.out.println(productList.toString());
	}
}
