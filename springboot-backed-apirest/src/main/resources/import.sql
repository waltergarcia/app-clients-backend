INSERT INTO regions (id, name) VALUES (1, 'El Salvador');
INSERT INTO regions (id, name) VALUES (2, 'Guatemala');
INSERT INTO regions (id, name) VALUES (3, 'Belice');
INSERT INTO regions (id, name) VALUES (4, 'Nicaragua');
INSERT INTO regions (id, name) VALUES (5, 'Costa Rica');
INSERT INTO regions (id, name) VALUES (6, 'PanamÃ¡');
INSERT INTO regions (id, name) VALUES (7, 'México');
INSERT INTO regions (id, name) VALUES (8, 'Estados Unidos');
INSERT INTO regions (id, name) VALUES (9, 'Canadá');
INSERT INTO regions (id, name) VALUES (10, 'Alemania');

INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (1, 'John', 'Doe', 'jdoe@mail.com', '2020-01-01');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (2, 'Will', 'Smith', 'wsmith@mail.com', '2020-02-02');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (3, 'Juan', 'Perez', 'jperez@mail.com', '2020-03-03');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (4, 'Juana', 'de Perez', 'jdeperez@mail.com', '2020-04-04');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (5, 'Marí­a', 'Doe', 'mdoe@mail.com', '2020-01-01');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (6, 'Antonia', 'Smith', 'asmith@mail.com', '2020-02-02');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (7, 'Patricia', 'Perez', 'pperez@mail.com', '2020-03-03');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (8, 'Mayra', 'LÃ³pez', 'mdeperez@mail.com', '2020-04-04');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (9, 'Pedro', 'Doe', 'pdoe@mail.com', '2020-01-01');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (10, 'Mario', 'Smith', 'msmith@mail.com', '2020-02-02');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (9, 'Alejandro', 'Perez', 'aperez@mail.com', '2020-03-03');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (8, 'Alexander', 'Fernandez', 'afernandez@mail.com', '2020-04-04');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (7, 'Alberto', 'Batrez', 'abatrez@mail.com', '2020-01-01');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (6, 'Amanda', 'Torres', 'atorres@mail.com', '2020-02-02');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (5, 'Toby', 'Moby', 'tmoby@mail.com', '2020-03-03');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (4, 'Maritza', 'Melgar', 'mmelgar@mail.com', '2020-04-04');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (3, 'Moisés', 'McKley', 'murbina@mail.com', '2020-03-03');
INSERT INTO client (region_id, name, last_name, email, create_at) VALUES (2, 'Margarita', 'Figueroa', 'mfigueroa@mail.com', '2020-04-04');


INSERT INTO users (username, password, enabled, name, last_name, email) VALUES ('walter', '$2a$10$/LavVrFZEh1j9iBl.B42iuQECLUF.gWY5vQVN2szlrRXcWl/9Z.IW', 1, 'Walter', 'Garcia', 'wgarcia@gmail.com');
INSERT INTO users (username, password, enabled, name, last_name, email) VALUES ('admin', '$2a$10$eHVx0xX0ZmzeoZCH74D/geXSYQ.nqk30ZAIXB01I1sOm5cSPyIGP2', 1, 'John', 'Doe', 'jdoe@gmail.com');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);

INSERT INTO products (name, price, create_at) VALUES('MacBook Pro 13 inch 2019', 1299, now());
INSERT INTO products (name, price, create_at) VALUES('Laptop Samsung', 659, now());
INSERT INTO products (name, price, create_at) VALUES('Monitor 35 inch', 250, now());
INSERT INTO products (name, price, create_at) VALUES('UPS Forza', 75, now());
INSERT INTO products (name, price, create_at) VALUES('Lapop Sony', 500, now());
INSERT INTO products (name, price, create_at) VALUES('Silla gamer', 890, now());
INSERT INTO products (name, price, create_at) VALUES('Monitor LCD LG', 789, now());
INSERT INTO products (name, price, create_at) VALUES('Laptop Leonovo', 925, now());
INSERT INTO products (name, price, create_at) VALUES('Monitor HP', 250, now());


INSERT INTO bills (description, observation, client_id, create_at) VALUES ('Factura equipos de oficina', null, 1, now());
INSERT INTO bill_details(quantity, bill_id, product_id) VALUES(1, 1, 1);
INSERT INTO bill_details(quantity, bill_id, product_id) VALUES(2, 1, 2);
INSERT INTO bill_details(quantity, bill_id, product_id) VALUES(3, 1, 3);
INSERT INTO bill_details(quantity, bill_id, product_id) VALUES(4, 1, 4);
