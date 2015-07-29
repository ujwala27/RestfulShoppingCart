package com.shop.restService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Product;
import com.shop.model.ShoppingCart;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public Product addProduct(@PathVariable String id)  {
		return new Product(id);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void removeProduct(@PathVariable String id)  {
		ShoppingCart sCart = new ShoppingCart();
		sCart.removeproduct(new Product(id));
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable String id)  {
		ShoppingCart sCart = new ShoppingCart();
		sCart.removeproduct(new Product(id));
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public void getProduct(@PathVariable String id)  {
		ShoppingCart sCart = new ShoppingCart();
		sCart.getproduct(new Product(id));
	}
	

}
