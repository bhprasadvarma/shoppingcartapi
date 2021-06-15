/**
 * 
 */
package com.varma.main.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.varma.main.entity.Product;

/**
 * @author Varma
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{  
	  @Query(value="SELECT count(*) from public.cart_product where cart_id=:cartId AND product_id=:productId",nativeQuery = true)
	  int countProductsFromCart(@Param("cartId") String cartId,@Param("productId") String productId);
	  
	  @Modifying
	  @Query(value="INSERT into  public.cart_product(cart_id, product_id) VALUES (:cartId, :productId)", nativeQuery = true)
	  @Transactional
	  void saveProductToCart(@Param("cartId") String cartId,@Param("productId") String productId);
	
	  @Modifying
	  @Query(value="DELETE from public.cart_product where cart_id=:cartId AND product_id=:productId",nativeQuery = true)
	  @Transactional
	  int deleteFromCart(@Param("cartId") String cartId,@Param("productId") String productId);

}
