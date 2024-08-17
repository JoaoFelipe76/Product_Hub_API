CREATE TABLE product (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    price INTEGER NOT NULL,
    active BOOLEAN
);


INSERT INTO product (id, name, price, active) VALUES ('p001', 'Smartphone', 299, TRUE);
INSERT INTO product (id, name, price, active) VALUES ('p002', 'Laptop', 999, TRUE);
INSERT INTO product (id, name, price, active) VALUES ('p003', 'Tablet', 499, TRUE);
