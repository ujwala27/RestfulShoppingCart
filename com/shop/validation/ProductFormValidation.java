package com.shop.validation;


import com.shop.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Ujwala Chintala
 * Date: 10/17/14
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductFormValidation implements Validator{

    @Override
    public boolean supports(Class<?> productClass) {
        return Product.class.equals(productClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product application = (Product) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ProductName", "Required Field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "Required Field");
    }
}
