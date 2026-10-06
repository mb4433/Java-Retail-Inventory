package inventoryManager;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		boolean cont = true;
		System.out.println("Welcome to the Inventory Manager, please make you selection below!");
		Scanner in = new Scanner(System.in);
		//creates iv object of InventoryManager Class
		InventoryManager iv = new InventoryManager();
		int choice = 0;
		//loop to continue until user cancels
		while(cont) {
			System.out.println("1. Add new product\n"
					+ "\n"
					+ "2. Ring up a sale (reduce stock)\n"
					+ "\n"
					+ "3. Check inventory levels\n"
					+ "\n"
					+ "4. Exit");
			while(cont) {
				//catch not valid entries
				try {
					choice = in.nextInt();
					in.nextLine();
					break;
				} catch(Exception e){
					System.out.println("Please only input a number!");
					in.nextLine();
				}
			}
			//reads the users choice
			switch(choice) {
			case 1:
				//add a product to the arraylist
				System.out.println("Please input the name, the sku, the price, and the amount in stock. Enter in that order!");
				String name = null;
				String sku = null;
				double price = 0.0;
				int stock = 0;
				while(cont) {
					//catch not valid entries
					try {
						name = in.nextLine();
						sku = in.nextLine();
						price = in.nextDouble();
						stock = in.nextInt();
						in.nextLine();
						break;
					} catch(Exception e){
						System.out.println("One of your inputs was of the wrong type!");
						in.nextLine();
					}
				}
				iv.addProduct(new Product(name, sku, price, stock));
				break;
			case 2:
				//sell one of the product
				System.out.println("Which item are you selling/ringing out? Enter the name.");
				String item = in.nextLine();
				for(Product p:iv.productList) {
					if(p.getName().equals(item)) {
						//removes one from the quantity
						p.setQuantity(p.getQuantity()-1);
					}
				}
				break;
			case 3:
				iv.displayAllItems();
				break;
			case 4:
				cont = false;
				break;
			}
		}
	}

}
