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

import com.varma.main.entity.Cart;
import com.varma.main.service.CartService;
import com.varma.main.service.ErrorResponseService;

/**
 * @author Varma
 *
 */
@RestController
@RequestMapping("/cartapi")
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	ErrorResponseService errorResponseService;
	
	@RequestMapping("/carts")
	public List<Cart> getAllCarts(){
		List<Cart> cartList = cartService.getAllCarts();
		if(cartList == null || cartList.isEmpty()) {
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Cart is Empty"));
		}						
		return cartService.getAllCarts();
	}
	
	@RequestMapping("/carts/{cartId}")
	public Cart getCart(@PathVariable("cartId") String cartId) {
		Cart cart = new Cart();
		if(StringUtils.isEmpty(cartId)) {
			throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request CardId must not be empty"));
		}
		try{
			cart = cartService.getCart(cartId);
			if(cart  == null) {		
				throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Cart "+cartId+"details not avialable"));
			}
		}catch(Exception Exception){
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Cart "+cartId+"details not avialable"));
		}
		return cart;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/carts")
	public void addCart(@RequestBody Cart cart) {
		try {
			cartService.addCart(cart);
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getFoundErrorRespone(302,"Cart already exists or unable to create"));
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/carts/{cartId}")
	public void updateCart(@RequestBody Cart cart,@PathVariable("cartId") String cartId) {
		try {
			if(StringUtils.isEmpty(cartId)) {
				throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request CardId must not be empty"));
			}
			cart.setUpdated(new java.util.Date());
			cartService.updateCart(cart,cartId);
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getFoundErrorRespone(304,"Cart "+cartId+" is unmodified"));
		}
	
	}
		
	@RequestMapping(method=RequestMethod.DELETE, value="/carts/{cartId}")
	public void deleteCart(@PathVariable("cartId") String cartId) {
		try {
			if(StringUtils.isEmpty(cartId)) {
				throw new WebApplicationException(errorResponseService.getBadRequestErrorRespone(400,"Bad Request CardId must not be empty"));
			}
			cartService.deleteCart(cartId);
		}catch(Exception exception) {
			throw new WebApplicationException(errorResponseService.getNotFoundErrorRespone(404,"Unable to delete Cart "+cartId));
		}
	}
}
