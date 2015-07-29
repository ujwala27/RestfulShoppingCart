package com.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<Product> products;

	public ShoppingCart(){
		this.products=new ArrayList<Product>();
	}

	public void addproduct(Product product) throws NoSuchProductExist{
		if (product.getId()==null) {
			throw new NoSuchProductExist("Invalid Product", product.getId());
		}
		
		try {
			this.products.add(product);
		}
		catch (Exception e) {
			
		}
	}

	public void removeproduct(Product product){
		this.products.remove(product);
	}
	
	public int calculateTotal(){
		int sum = 0;
		int prodCount = 0;
		for(Product product : products){
			sum += product.getPrice();
			if (("orange").equalsIgnoreCase(product.getDescription())) {
				product.setProductCount(prodCount+1);
			}
		}
		return sum;
	}
	
	public int getTotalItems(){
		return this.products.size();
	}

	public void getproduct(Product product) {
		this.products.get(product);
		
	}
	
}
