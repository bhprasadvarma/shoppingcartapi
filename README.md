# shoppingcartapi
Shopping Cart API using Spring Boot Microservices

1.update DB properties in src\main\resources\application.properties according to your Database
(currently using PostgreSQL and changed server port 8899)

2.change Content-Type : application/json  in Header (used **POSTMAN** for testing these API Endpoints)

3.**End Point(s) for API**
  A.Cart related EndPoints
      1.Retrieve Carts          ::: **http://localhost:8899/cartapi/carts**             | GET  Method  <Br/>
      2.Retrieve Specific Cart  ::: **http://localhost:8899/cartapi/carts /{cartId}**   | GET  Method
      3.Add New Cart            ::: **http://localhost:8899/cartapi/carts**             | POST Method
      4.Update Cart             ::: **http://localhost:8899/cartapi/carts /{cartId}**   | PUT Method
      5.Delete Cart             ::: **http://localhost:8899/cartapi/carts /{cartId}**   | DELETE Method
  
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
]
 
 B.Products in the Cart EndPoints
      1.Retrive All Products in Cart            ::: **http://localhost:8899/cartapi/carts/{cartId}/products**                 | GET  Method
      2.Retrieve Specific Product from Cart     ::: **http://localhost:8899/cartapi/carts/{cartId}/products/{productId}**     | GET  Method
      3.Add New Product to Cart                 ::: **http://localhost:8899/cartapi/carts/{cartId}/products**                 | POST Method
      4.Update Product in Cart                  ::: **http://localhost:8899/cartapi/carts/{cartId}/products/{productId}**     | PUT Method
      5.Remove Product from Cart                ::: **http://localhost:8899/cartapi/carts/{cartId}/products/{productId}**     | DELETE Method
 
      
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
}

 C.Product related EndPoints
      1.Retrieve Carts          ::: **http://localhost:8899/cartapi/products**             	| GET  Method
      2.Retrieve Specific Cart  ::: **http://localhost:8899/cartapi/products /{productId}**   	| GET  Method
      3.Add New Cart            ::: **http://localhost:8899/cartapi/products**             	| POST Method
      4.Update Cart             ::: **http://localhost:8899/cartapi/products /{productId}**   	| PUT Method
      5.Delete Cart             ::: **http://localhost:8899/cartapi/products /{productId}**   	| DELETE Method
 
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
 ]

**Sample INSERT DB Scripts**
INSERT INTO public.cart(id, country_code, created, currency, updated) 	VALUES (1, 'IN', '2021-06-16', 'INR', null);  
INSERT INTO public.cart(id, country_code, created, currency, updated) 	VALUES (2, 'SK', '2021-06-16', 'SEK', null);	 

INSERT INTO public.product(id, category, created, description, price, updated) 	VALUES (1,'A', '2021-06-16', '333', 1000, null); 
INSERT INTO public.product(id, category, created, description, price, updated) 	VALUES (2,'B', '2021-06-16', '777', 1200, null);   

INSERT INTO public.cart_product( 	cart_id, product_id) 	VALUES (1, 1); 
INSERT INTO public.cart_product( 	cart_id, product_id) 	VALUES (1, 2); 
INSERT INTO public.cart_product( 	cart_id, product_id) 	VALUES (2, 1); 
INSERT INTO public.cart_product( 	cart_id, product_id) 	VALUES (2, 2); 

COMMIT;
