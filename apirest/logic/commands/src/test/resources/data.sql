
-- Generos
INSERT INTO Gender (description, status) VALUES ('masculino', 1);
INSERT INTO Gender (description, status) VALUES ('femenino', 1);
INSERT INTO Gender (description, status) VALUES ('otro', 1);

-- Paises
INSERT INTO Country (description, status) VALUES ('venezuela', 1);
INSERT INTO Country (description, status) VALUES ('colombia', 1);

-- Heroes
INSERT INTO HERO (description, status) VALUES ('Marvel', 1);
INSERT INTO HERO (description, status) VALUES ('D.C', 1);
INSERT INTO HERO (description, status) VALUES ('propio', 1);

-- Tipos de productos
INSERT INTO PRODUCTTYPE (description, status) VALUES ('ropa', 1);
INSERT INTO PRODUCTTYPE (description, status) VALUES ('accesorio', 1);
INSERT INTO PRODUCTTYPE (description, status) VALUES ('utensilio', 1);
INSERT INTO PRODUCTTYPE (description, status) VALUES ('juguete', 1);
INSERT INTO PRODUCTTYPE (description, status) VALUES ('comic', 1);

-- Marcas de productos
INSERT INTO BRAND (description, status) VALUES ('lego', 1);
INSERT INTO BRAND (description, status) VALUES ('zara', 1);
INSERT INTO BRAND (description, status) VALUES ('bongo', 1);
INSERT INTO BRAND (description, status) VALUES ('rolex', 1);
INSERT INTO BRAND (description, status) VALUES ('bormioli', 1);

-- Tallas de ropa
INSERT INTO CLOTHESSIZE (description, status) VALUES ('xs', 1);
INSERT INTO CLOTHESSIZE (description, status) VALUES ('s', 1);
INSERT INTO CLOTHESSIZE (description, status) VALUES ('m', 1);
INSERT INTO CLOTHESSIZE (description, status) VALUES ('l', 1);

-- Tipos de ropa
INSERT INTO CLOTHESTYPE (description, status) VALUES ('camiseta', 1);
INSERT INTO CLOTHESTYPE (description, status) VALUES ('pantalon', 0);
INSERT INTO CLOTHESTYPE (description, status) VALUES ('gorra', 0);

-- Tipos de materiales
INSERT INTO MATERIALTYPE (description, status) VALUES ('plastico', 1);
INSERT INTO MATERIALTYPE (description, status) VALUES ('vidrio', 1);
INSERT INTO MATERIALTYPE (description, status) VALUES ('metal', 1);

-- Tipos de juguetes
INSERT INTO TOYTYPE (description, status) VALUES ('figura', 1);
INSERT INTO TOYTYPE (description, status) VALUES ('carro', 1);

-- Tipos de utensilios
INSERT INTO UTENSILTYPE (description, status) VALUES ('vaso', 1);
INSERT INTO UTENSILTYPE (description, status) VALUES ('plato', 0);

-- Tipos de accesorios
INSERT INTO ACCESSORYTYPE (description, status) VALUES ('reloj', 1);
INSERT INTO ACCESSORYTYPE (description, status) VALUES ('lentes', 1);


INSERT INTO PRODUCT(name, code, registerdate, idHero, idProductType, idBrand, status) values ('producto', 'code', '2021-02-02', 1, 1, 1, 1);
INSERT INTO USER(name, code, registerdate, idHero, idProductType, idBrand, status) values ('producto', 'code', '2021-02-02', 1, 1, 1, 1);