package inventoryManager;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class InventoryManager {
	//array declaration
ArrayList<Product> productList = new ArrayList<Product>();
//add new product to the list
public void addProduct(Product p) {
	productList.add(p);
}
//updates stock amount of product object
public void updateStock(String sku, int amount) {
	for(int i = 0; i < productList.size(); i++) {
		if(sku.equals(productList.get(i).getSku())) {
			productList.get(i).setQuantity(amount);
		}
	}
}
public void displayAllItems() {
	System.out.println(productList.toString());
	}

public void saveInventory() {
	try {
		FileWriter file = new FileWriter("inventory.txt");
		for(Product p:productList) {
			file.write(","+p.getName()+","+p.getSku()+","+p.getPrice()+","+p.getQuantity());
		}	
		file.close();
		System.out.println("Inventory Saved!");
	}catch(Exception e){
		System.out.println("Error occured: "+ e);
	}
	}

public void loadInventory() {
	try {
	File file = new File("inventory.txt");
	if(file.exists()) {
		return;
	}
	Scanner line = new Scanner(file);
	while (line.hasNextLine()) {
	String currentLine = line.nextLine();
	String[] splits = currentLine.split(",");
	if(splits.length == 4) {
		String name = splits[1];
		String sku = splits[2];
		double price = Double.parseDouble(splits[3]);
		int stock = Integer.parseInt(splits[4]);
		productList.add(new Product(name, sku, price, stock));
	}
	}
	}catch(Exception e) {
		System.out.println("Error: "+e);
	}
}
}
