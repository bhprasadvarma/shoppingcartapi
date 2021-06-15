/**
 * 
 */
package com.varma.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varma.main.entity.Cart;

/**
 * @author Varma
 *
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, String>{

}
