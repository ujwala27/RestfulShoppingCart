package com.shop.model;

public class NoSuchProductExist extends Exception {
	
	private String productId;
	
	public NoSuchProductExist() {
        super();
    }

    public NoSuchProductExist(String message, String productId) {
        super(message);
        this.productId = productId;
    }

    public NoSuchProductExist(String message, String productId, Throwable cause) {
        super(message, cause);
        this.productId = productId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " for productId :" + productId;
    }

    public String getProductId() {
        return productId;
    }

}
