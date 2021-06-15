/**
 * 
 */
package com.varma.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varma.main.entity.Cart;
import com.varma.main.repository.CartRepository;
import com.varma.main.repository.ProductRepository;

/**
 * @author Varma
 *
 */
@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	
	public List<Cart> getAllCarts(){
		return cartRepository.findAll();
	}
	
	public Cart getCart(String cartId) {
		return cartRepository.findById(cartId).get();
	}
	
	public void addCart(Cart cart) {
		cartRepository.save(cart);
	}
	
	public void updateCart(Cart cart,String cartId) {
		cart.setId(cartId);
		cartRepository.save(cart);
	}
	
	public void deleteCart(String cartId) {
		cartRepository.deleteById(cartId);
	}
}
