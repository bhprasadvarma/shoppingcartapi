/*
 * This file was automatically generated by EvoSuite
 * Tue Jun 15 17:56:53 GMT 2021
 */

package com.varma.main.controller;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Fail;
import org.junit.Test;

import com.varma.main.entity.CartProduct;
import com.varma.main.entity.Product;
import com.varma.main.service.ProductService;

public class ProductControllerTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      ProductController productController0 = new ProductController();
      // Undeclared exception!
      try { 
        productController0.getProductFromCart("Bad Request CardId must not be empty", "Product ");
      } catch(NoClassDefFoundError e) {
         //
         // org/springframework/util/StringUtils
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      ProductController productController0 = new ProductController();
      Date Date0 = new Date(4676, 0, 1856, 0, 78, 4676);
      Product product0 = new Product((String) null, (String) null, (String) null, 1.0, Date0, Date0);
      // Undeclared exception!
      try { 
        productController0.updateProduct(product0, "nlTK%\"{Kdj\"`aFH4Y2");
      
      } catch(NoClassDefFoundError e) {
         //
         // org/springframework/util/StringUtils
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      ProductController productController0 = new ProductController();
      // Undeclared exception!
      try { 
        productController0.getProduct(",+>]< ");
      
      } catch(NoClassDefFoundError e) {
         //
         // org/springframework/util/StringUtils
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      ProductController productController0 = new ProductController();
      // Undeclared exception!
      try { 
        productController0.getAllProductsFromCart("Bad Request CardId must not be empty");
     
      } catch(NoClassDefFoundError e) {
         //
         // org/springframework/util/StringUtils
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      ProductController productController0 = new ProductController();
      // Undeclared exception!
      try { 
        productController0.getAllProducts();
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      ProductController productController0 = new ProductController();
      ProductService productService0 = new ProductService();
      productController0.productService = productService0;
      // Undeclared exception!
      try { 
        productController0.getAllProducts();
      
      } catch(NoClassDefFoundError e) {
         //
         // com/varma/main/repository/ProductRepository
         //
         verifyException("com.varma.main.service.ProductService", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      ProductController productController0 = new ProductController();
      // Undeclared exception!
      try { 
        productController0.deleteProductFromCart("ISB,xKO]:rV73E:4", (String) null);
      
      } catch(NoClassDefFoundError e) {
         //
         // org/springframework/util/StringUtils
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      ProductController productController0 = new ProductController();
      // Undeclared exception!
      try { 
        productController0.deleteProduct((String) null);
      
      } catch(NoClassDefFoundError e) {
         //
         // org/springframework/util/StringUtils
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      ProductController productController0 = new ProductController();
      Date Date0 = new Date((-1071), (-1071), 404, 404, (-1071));
      CartProduct cartProduct0 = new CartProduct("", "", "zW<vf", Date0, Date0, (List<Product>) null);
      // Undeclared exception!
      try { 
        productController0.addProductsToCart(cartProduct0, "zW<vf");
      
      } catch(NoClassDefFoundError e) {
         //
         // org/springframework/util/StringUtils
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      ProductController productController0 = new ProductController();
      ProductService productService0 = new ProductService();
      productController0.productService = productService0;
      Date Date0 = new Date((-1L));
      Product product0 = new Product("", "'aImxfM%QO9", "C/Sk$G", 0.0, Date0, Date0);
      // Undeclared exception!
      try { 
        productController0.addProduct(product0);
      
      } catch(NoClassDefFoundError e) {
         //
         // com/varma/main/repository/ProductRepository
         //
         verifyException("com.varma.main.service.ProductService", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      ProductController productController0 = new ProductController();
      Product product0 = new Product();
      // Undeclared exception!
      try { 
        productController0.addProduct(product0);
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.varma.main.controller.ProductController", e);
      }
  }
  
  private void verifyException(String message, Error e) {
	// TODO Auto-generated method stub
	fail(message, e);
  }
  
  private void verifyException(String message, Exception e) {
	// TODO Auto-generated method stub
	  fail(message, e);
  }

}
