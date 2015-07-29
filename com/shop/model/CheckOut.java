package com.shop.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.shop.model.Product;

public class CheckOut {
	
	public void applyDiscountOffer(List<Product> productList) {
		
		Map<String, Integer> myMap = new HashMap<>();
		
		myMap = countProducts(productList);
		Iterator<Entry<String, Integer>> entries = myMap.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, Integer> entry = entries.next();
			double discountedItems = entry.getValue();
			
			if (discountedItems > 1) {
				discountedItems = Math.floor(discountedItems/2);
				
			}
	    }
		
	}
	
	public Map<String, Integer> countProducts(List<Product> productList) {
		
		
		Map<String,Integer> productMap = new HashMap<>();

		    for(int i=0;i<productList.size();i++){
		         if(productMap.containsKey(productList.get(i))){
		          productMap.put(productList.get(i).getDescription(), productMap.get(productList.get(i))+1 );
		         }else{
		          productMap.put(productList.get(i).getDescription(), 1);
		         }
		    }
			return productMap;

	}
}
