package shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import products.Product;

public class ShoppingCart {
	ArrayList<CartLine> list = new ArrayList<CartLine>();

	public void action(Product product, String action) {
		switch (action) {
			case "add":
				addProductCartLine(product);
				break;
			case "remove":
				removeProductCartLine(product);
				break;
			default:
				printCartLineList();
				break;
		}
	}

	private void printCartLineList() {
		System.out.println("Content of the shopping cart: ");
		list.forEach(System.out::println);
		System.out.println("Total price = " + getT());
	}

	private void removeProductCartLine(Product product) {
		Iterator<CartLine> iter = list.iterator();
		while (iter.hasNext()) {
			CartLine cline = iter.next();
			if (cline.getProduct().getProductNumber().equals(product.getProductNumber())) {
				if (cline.getQuantity() > 1) {
					cline.setQuantity(cline.getQuantity() - 1);
				} else {
					iter.remove();
				}
			}
		}
	}

	private void addProductCartLine(Product product) {
		for (CartLine cline : list) {
			if (cline.getProduct().getProductNumber().equals(product.getProductNumber())) {
				cline.setQuantity(cline.getQuantity() + 1);
				return;
			}
		}
		CartLine cline = new CartLine();
		cline.setProduct(product);
		cline.setQuantity(1);
		list.add(cline);
	}

	public double getT(){
		double totalPrice = 0.0;
		for (CartLine c : list) {
			totalPrice += (c.getProduct().getPrice() * c.getQuantity());
		}
		return totalPrice;
	}
}
