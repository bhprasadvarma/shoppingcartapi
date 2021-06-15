# Shopping Cart API
  Shopping Cart API is used create a shopping cart, get the shopping cart, edit shopping cart, delete shopping cart, get a product in the shopping cart, add a product to the shopping cart, delete a product from the cart, create a product, get the product, edit product and delete product. <br/>
  
Tech Stack for this Shopping Cart API <br/>
&nbsp;&nbsp;&nbsp;1.Java 8  <br/>
&nbsp;&nbsp;&nbsp;2.Spring & **Spring Boot** <br/>
&nbsp;&nbsp;&nbsp;3.Hibernate & JPA <br/>
&nbsp;&nbsp;&nbsp;4.**Postgres** <br/>
&nbsp;&nbsp;&nbsp;5.Maven <br/>
&nbsp;&nbsp;&nbsp;6.PostMan

1.update DB properties in src\main\resources\application.properties according to your Database

2.change Content-Type : application/json  in Header (used **POSTMAN** for testing these API Endpoints)

3.**End Point(s) for API**<br/>
  A.Cart related EndPoints<br/>
      1.Retrieve Carts          ::: **http://localhost:8899/cartapi/carts**             | GET  Method  <br/>
      2.Retrieve Specific Cart  ::: **http://localhost:8899/cartapi/carts /{cartId}**   | GET  Method  <br/> 
      3.Add New Cart            ::: **http://localhost:8899/cartapi/carts**             | POST Method  <br/> 
      4.Update Cart             ::: **http://localhost:8899/cartapi/carts /{cartId}**   | PUT Method   <br/>
      5.Delete Cart             ::: **http://localhost:8899/cartapi/carts /{cartId}**   | DELETE Method <br/>
  
  **Sample Cart Payload**
  [
    {
        "id": "1",
        "countryCode": "IN",
        "currency": "INR",
        "created": "2021-06-13T18:30:00.000+00:00",
        "updated": null
    },
    {
        "id": "2",
        "countryCode": "SK",
        "currency": "SEK",
        "created": "2021-06-13T18:30:00.000+00:00",
        "updated": null
    }
] <br/>
 
 B.Products in the Cart EndPoints <br/>
      1.Retrive All Products in Cart            ::: **http://localhost:8899/cartapi/carts/{cartId}/products**                 | GET  Method <br/>
      2.Retrieve Specific Product from Cart     ::: **http://localhost:8899/cartapi/carts/{cartId}/products/{productId}**     | GET  Method <br/> 
      3.Add New Product to Cart                 ::: **http://localhost:8899/cartapi/carts/{cartId}/products**                 | POST Method <br/>
      4.Update Product in Cart                  ::: **http://localhost:8899/cartapi/carts/{cartId}/products/{productId}**     | PUT Method  <br/>
      5.Remove Product from Cart                ::: **http://localhost:8899/cartapi/carts/{cartId}/products/{productId}**     | DELETE Method <br/>
      
**Sample Products in Cart Payload**      
{
    "id": "1",
    "countryCode": "IN",
    "currency": "INR",
    "created": "2021-06-13T18:30:00.000+00:00",
    "updated": null,
    "product": [
        {
            "id": "1",
            "description": "333",
            "category": "A",
            "price": 1000.0,
            "created": "2021-06-13T18:30:00.000+00:00",
            "updated": null
        },
        {
            "id": "3",
            "description": "444",
            "category": "A",
            "price": 1000.0,
            "created": "2021-06-13T18:30:00.000+00:00",
            "updated": null
        }
    ]
} <br/>

 C.Product related EndPoints <br/>
      1.Retrieve Carts          ::: **http://localhost:8899/cartapi/products**             	    | GET  Method <br/>
      2.Retrieve Specific Cart  ::: **http://localhost:8899/cartapi/products /{productId}**   	| GET  Method <br/>
      3.Add New Cart            ::: **http://localhost:8899/cartapi/products**             	    | POST Method <br/>
      4.Update Cart             ::: **http://localhost:8899/cartapi/products /{productId}**   	| PUT Method <br/>
      5.Delete Cart             ::: **http://localhost:8899/cartapi/products /{productId}**   	| DELETE Method <br/>
 
 **Sample Product Payload**        
 [
    {
        "id": "1",
        "description": "333",
        "category": "A",
        "price": 1000.0,
        "created": "2021-06-13T18:30:00.000+00:00",
        "updated": null
    },
    {
        "id": "2",
        "description": "777",
        "category": "B",
        "price": 1200.0,
        "created": "2021-06-13T18:30:00.000+00:00",
        "updated": null
    },
    {
        "id": "3",
        "description": "444",
        "category": "A",
        "price": 1000.0,
        "created": "2021-06-13T18:30:00.000+00:00",
        "updated": null
    }
 ] <br/>

**Sample INSERT DB Scripts** <br/>
INSERT INTO public.cart(id, country_code, created, currency, updated) 	VALUES (1, 'IN', '2021-06-16', 'INR', null); <br/> 
INSERT INTO public.cart(id, country_code, created, currency, updated) 	VALUES (2, 'SK', '2021-06-16', 'SEK', null);	<br/>  

INSERT INTO public.product(id, category, created, description, price, updated) 	VALUES (1,'A', '2021-06-16', '333', 1000, null); <br/>
INSERT INTO public.product(id, category, created, description, price, updated) 	VALUES (2,'B', '2021-06-16', '777', 1200, null); <br/>  

INSERT INTO public.cart_product( 	cart_id, product_id) 	VALUES (1, 1); <br/>
INSERT INTO public.cart_product( 	cart_id, product_id) 	VALUES (1, 2); <br/>
INSERT INTO public.cart_product( 	cart_id, product_id) 	VALUES (2, 1); <br/>
INSERT INTO public.cart_product( 	cart_id, product_id) 	VALUES (2, 2); <br/>

COMMIT;<br/>
