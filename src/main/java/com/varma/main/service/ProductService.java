/**
 * 
 */
package com.varma.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.varma.main.entity.Cart;
import com.varma.main.entity.CartProduct;
import com.varma.main.entity.Product;
import com.varma.main.repository.ProductRepository;

/**
 * @author Varma
 *
 */
@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartService cartService;
	
	public CartProduct getAllProductsFromCart(String cartId){
		Cart cart = cartService.getCart(cartId);
		CartProduct cartProduct = new CartProduct(
				cart.getId(),
				cart.getCountryCode(),
				cart.getCurrency(),
				cart.getCreated(),
				cart.getUpdated(),
				cart.getProduct()
		);
		return cartProduct;
	}
	
	public CartProduct getProductFromCart(String cartId,String productId){
		Cart cart = cartService.getCart(cartId);
		CartProduct cartProduct = new CartProduct(
				cart.getId(),
				cart.getCountryCode(),
				cart.getCurrency(),
				cart.getCreated(),
				cart.getUpdated(),
				cart.getProduct().stream().filter(product -> product.getId().equalsIgnoreCase(productId)).collect(Collectors.toList())
		);
		return cartProduct;
	}
	
	public void addProductsToCart(CartProduct cartProduct, String cartId) {
		System.out.println("in productservice ------\n"+cartProduct);
		productRepository.saveAll(cartProduct.getProduct());
		cartProduct.getProduct().forEach(cardPrd->{
			if(productRepository.countProductsFromCart(cartId, cardPrd.getId()) == 0) {
				System.out.println(cardPrd.getId()+" is not available in cart_product");
				productRepository.saveProductToCart(cartId, cardPrd.getId());
			}else {
				System.out.println(cardPrd.getId()+" is available cart_product");
			}
		});
	}
	
	public void deleteProductFromCart(String cartId,String productId){
		System.out.println("productservice ----> deleteProductFromCart ------>"+cartId+"|"+productId);
		if(!(StringUtils.isEmpty(cartId) || StringUtils.isEmpty(productId))) {
			productRepository.deleteFromCart(cartId, productId);
		}
	}
	
	public List<Product> getAllProducts(){
		 return productRepository.findAll();
	}
	
	public Product getProduct(String productId) {
		return productRepository.findById(productId).get();
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void updateProduct(Product product,String productId) {
		product.setId(productId);
		productRepository.save(product);
	}
	
	public void deleteProduct(String productId) {
		productRepository.deleteById(productId);
	}
}
