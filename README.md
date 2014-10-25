DS
=========

Simple REST Service for interacting with product data.


Version
-

1.0-SNAPSHOT

Setup
-
clone this repository and cd into the new directory

```sh
git clone https://github.com/kellyp/ds.git
cd ds
```

startup locally using the maven jetty plugin 

```sh
mvn jetty:run
```


Usage
-

To get a list of all the products use GET with the index action 

```sh
curl http://localhost:8080/ds/json/products/index
```

To create a new product in the service use POST with 

```sh
curl -X POST -d "{\"id\":\"\",\"sizeList\":[{\"name\":\"XL\",\"quantity\":23}]}" http://localhost:8080/ds/json/products/create --header "Content-Type:application/json"
```

To update an existing product use PUT with the update action

```sh
curl -X PUT -d "{\"id\":\"1\",\"sizeList\":[{\"name\":\"XL\",\"quantity\":23},{\"name\":\"XXL\",\"quantity\":24}]}" http://localhost:8080/ds/json/products/update/1 --header "Content-Type:application/json"
```

To delete an existing product use DELETE with the delete action

```sh
curl -X DELETE  http://localhost:8080/ds/json/products/delete/1
```

To get an existing product use GET with the get action

```sh
curl -X GET http://localhost:8080/ds/json/products/get/1
```

