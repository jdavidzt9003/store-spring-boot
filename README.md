# store-spring-boot
Oracle - PL/SQL / Store Procedures

#### Create table products

```sh
CREATE TABLE products (
    id            NUMBER(10) NOT NULL,
    name          VARCHAR2(50),
    price         NUMBER(6, 2),
    quantity      NUMBER(10),
    description   VARCHAR2(50),
    photo         VARCHAR2(50),
    featured      NUMBER(1, 0),
    CONSTRAINT products_pk PRIMARY KEY ( id )
)
```
#### Insert some data
```sh

insert into products (id, name, description) values (1, 'Lenovo Idepad', ' Notebook Review');
insert into products (id, name, description) values (2, 'Mouse', ' Mouse Review');
insert into products (id, name, description) values (3, 'KeyBoard', 'KeyBoard Review');
insert into products (id, name, description) values (4, 'Monitor', ' Monitor Review');

```
#### Create package  products_pkg and store procedure get_product

```sh
CREATE OR REPLACE PACKAGE products_pkg AS
    PROCEDURE   get_product (
        id            IN    products.id%TYPE,
        out_name          OUT   products.name%TYPE,
        out_description   OUT   products.description%TYPE
    );

END;
``` 
##### Create package body
```sh
CREATE OR REPLACE PACKAGE BODY products_pkg AS

    PROCEDURE get_product (
        id            IN    products.id%TYPE,
        out_name          OUT   products.name%TYPE,
        out_description   OUT   products.description%TYPE
    ) IS
    
    v_id products.id%type := id;
    BEGIN
        SELECT
            name,
            description
        INTO
            out_name,
            out_description
        FROM
            products
        WHERE
            id =  v_id;

    END get_product;

END;
```

##### Test store procedure

```sh

DECLARE
    v_name          products.name%TYPE;
    v_description   products.description%TYPE;
BEGIN
    products_pkg.get_product(1, v_name, v_description);
    dbms_output.put_line('NAME: ' || v_name);
    dbms_output.put_line('DESCRIPTION: ' || v_description);
END;
```

#### Spring boot config
##### src -> main -> resources -> application.properties
```sh
#Spring Boot Config for Oracle
oracle.url= jdbc:oracle:thin:@//localhost:1521/ORCL
oracle.username=store
oracle.password=test
```