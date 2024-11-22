CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price VARCHAR(255),
    current_stock INT
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    order_no INT,
    product_id INT REFERENCES products(id)
);