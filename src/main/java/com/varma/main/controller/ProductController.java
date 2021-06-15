/**
 * 
 */
package com.varma.main.controller;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varma.main.entity.CartProduct;
import com.varma.main.entity.Product;
import com.varma.main.service.ErrorResponseService;
import com.varma.main.service.ProductService;

/**
 * @author Varma
 *
 */
@RestController
@RequestMapping("/cartapi")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	ErrorResponseService errorResponseService;
	
	@RequestMapping("/carts/{cartId}/products")
	public CartProduct getAllProductsFromCart(@PathVariable("cartId") String cartId) {
		CartProduct cartProduct = new CartProduct();
		if(StringUtils.isEmpty(cartId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request CardId must not be empty"));
		}
		try{
			cartProduct = productService.getAllProductsFromCart(cartId);
			if(cartProduct == null) {
				throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Products are not added in Cart "+cartId));
			}
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Products are not added in Cart "+cartId));
		}
		return cartProduct;
	}
	
	@RequestMapping("/carts/{cartId}/products/{productId}")
	public CartProduct getProductFromCart(@PathVariable("cartId") String cartId, @PathVariable("productId") String productId) {
		CartProduct cartProduct = new CartProduct();
		if(StringUtils.isEmpty(cartId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request CardId must not be empty"));
		}
		if(StringUtils.isEmpty(productId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request ProductId must not be empty"));
		}
		try {
			cartProduct = productService.getProductFromCart(cartId, productId);
			if(cartProduct == null) {
				throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Product is not added in Cart "+cartId));
			}
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Products are not added in Cart "+cartId));
		}
	
		return cartProduct;
	}

	@RequestMapping(method=RequestMethod.PUT, value="/carts/{cartId}/products")
	public void addProductsToCart(@RequestBody CartProduct cartProduct,@PathVariable("cartId") String cartId) {
		if(StringUtils.isEmpty(cartId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request CardId must not be empty"));
		}
		try {
			cartProduct.setUpdated(new java.util.Date());
			productService.addProductsToCart(cartProduct,cartId);
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getFoundErrorRespone(304,"Products in Cart "+cartId+"are unmodified"));
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/carts/{cartId}/products/{productId}")
	public void deleteProductFromCart(@PathVariable("cartId") String cartId, @PathVariable("productId") String productId) {
		if(StringUtils.isEmpty(cartId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request CardId must not be empty"));
		}
		if(StringUtils.isEmpty(productId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request ProductId must not be empty"));
		}
		try {
			productService.deleteProductFromCart(cartId, productId);
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Unable to remove Product from Cart "+cartId));
		}
	}
	
	@RequestMapping("/products")
	public List<Product> getAllProducts(){
		List<Product> productList = productService.getAllProducts();
		if(productList == null || productList.isEmpty()) {
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Products are Empty"));
		}
		return productList;
	}
	
	@RequestMapping("/products/{productId}")
	public Product getProduct(@PathVariable("productId") String productId) {
		Product product = new Product();
		if(StringUtils.isEmpty(productId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request ProductId must not be empty"));
		}
		try {
			product = productService.getProduct(productId);
			if(product == null) {
				throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Product "+productId+"details not avialable"));
			}	
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Product "+productId+"details not avialable"));
		}

		return product;
	}

	@RequestMapping(method=RequestMethod.POST, value="/products")
	public void addProduct(@RequestBody Product product) {
		try {
			productService.addProduct(product);
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getFoundErrorRespone(302,"Product already exists or unable to create"));
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{productId}")
	public void updateProduct(@RequestBody Product product, @PathVariable("productId") String productId) {
		try {
			if(StringUtils.isEmpty(productId)) {
				throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request ProductId must not be empty"));
			}
			product.setUpdated(new java.util.Date());
			productService.updateProduct(product, productId);
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getFoundErrorRespone(304,"Product "+productId+" is unmodified"));
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{productId}")
	public void deleteProduct(@PathVariable("productId") String productId) {
		if(StringUtils.isEmpty(productId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request ProductId must not be empty"));
		}
		try {
			productService.deleteProduct(productId);
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Unable to delete Product "+productId));
		}
	
	}
}
