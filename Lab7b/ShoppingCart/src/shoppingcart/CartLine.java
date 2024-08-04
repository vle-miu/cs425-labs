package shoppingcart;
import products.Product;

public class CartLine {

	int quantity = 0;

	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return getQuantity() + " "
				+ getProduct().getProductNumber() + " "
				+ getProduct().getDescription() + " "
				+ getProduct().getPrice();	}
}
