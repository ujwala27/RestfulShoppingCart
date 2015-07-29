package com.shop.model;

public class Product {
	
	       private String id;
	       private String description;
	       private Double price;
	       private int productCount;
	       
	       public enum Desc {
	    	   ORANGE(1), APPLE(2), BREAD(3), MILK(4);
	    	   private int value;
	       		private Desc(int value){
	       			this.value=value;
	       			}
	       		}
	       
	       public Product() {
	       }

	       public Product(String id) {
	              this.id = id;
	       }
	       public String getId() {
	              return id;
	       }
	       public void setId(String id) {
	              this.id = id;
	       }     
	       public String getDescription() {
	    	      
	              return description;
	       }
	       public void setDescription(String description) {
	    	   	String myId = id;
	    	      switch (myId) {
	              case "1":
	            	  this.description = Desc.ORANGE.toString();
	              case "2":
	            	  this.description = Desc.APPLE.toString();
	              case "3":
	            	  this.description = Desc.BREAD.toString();
	              case "4":
	            	  this.description = Desc.MILK.toString();
	    	      }  
	       }

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public int getProductCount() {
			return productCount;
		}

		public void setProductCount(int productCount) {
			this.productCount = productCount;
		}
	
}
