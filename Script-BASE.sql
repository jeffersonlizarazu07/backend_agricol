USE agricol;
INSERT INTO unidadescomercio (id, nombre) 
VALUES (1, 'Kg');

INSERT INTO unidadescomercio (id, nombre) 
VALUES (2, 'Bulto');

INSERT INTO roles (idrol, nombre_rol)
VALUES 
(1, 0), -- COMPRADOR
(2, 1), -- VENDEDOR
(3, 2), -- COMPRADORVENDEDOR
(4, 3); -- ADMIN

INSERT INTO usuarios (idusuario, nombre, apellido, direccion, email, contrasena, rol_id)
VALUES ('U001', 'Juan', 'Pérez', 'Calle 123, Med', 'juan.perez@example.com', 'contraseñaSegura123', 2);

INSERT INTO usuarios (idusuario, nombre, apellido, direccion, email, contrasena, rol_id)
VALUES ('U002', 'Andrea', 'Maldonado', 'Calle 3, Med', 'andrea.nmaldonado@example.com', 'contraseñaSecure', 3);

INSERT INTO productos (nombre_poducto, clasificacion, cantida_disponible, localizacion, precio, imagen_url, vendedor_id, unidadcomercializacion_id)
VALUES ('Mazorca de Maíz', 'Vegetales', 150, 'Granja Los Pinos, Municipio Verde', 2400, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTifvhZwvSnOF5uBtolwf-nVUIoJQBz7ULMdw&s', 'U001', 1);

INSERT INTO productos (nombre_poducto, clasificacion, cantida_disponible, localizacion, precio, imagen_url, vendedor_id, unidadcomercializacion_id)
VALUES ('Manzana Roja', 'Frutas', 100, 'Finca El Paraíso, Municipio Verde', 1500, 'https://img.freepik.com/fotos-premium/manzana-roja-sobre-mesa-madera-frente-campo_890372-3.jpg', 'U001', 2);

INSERT INTO productos (nombre_poducto, clasificacion, cantida_disponible, localizacion, precio, imagen_url, vendedor_id, unidadcomercializacion_id)
VALUES ('Saco de Papa', 'Vegetales', 200, 'Granja Los Nogales, Municipio Azul', 16000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdDXFg0v9G_Tdm8Bd5IPnpLLk_Cfn2XIwzig&s', 'U002', 2); -- Bulto

INSERT INTO productos (nombre_poducto, clasificacion, cantida_disponible, localizacion, precio, imagen_url, vendedor_id, unidadcomercializacion_id)
VALUES ('Naranja', 'Frutas', 120, 'Huerto La Vida, Municipio Rojo', 1500, 'https://www.tropicanafm.com/wp-content/uploads/2024/03/Bulto-de-naranja.jpg', 'U001', 1);

INSERT INTO productos (nombre_poducto, clasificacion, cantida_disponible, localizacion, precio, imagen_url, vendedor_id, unidadcomercializacion_id)
VALUES ('Saco de Zanahorias', 'Vegetales', 180, 'Finca El Valle, Municipio Verde', 15200, 'https://hortalistas.cl/wp-content/uploads/2020/03/zanahoria.jpg', 'U002', 2); -- Bulto

INSERT INTO productos (nombre_poducto, clasificacion, cantida_disponible, localizacion, precio, imagen_url, vendedor_id, unidadcomercializacion_id)
VALUES ('Pera', 'Frutas', 90, 'Granja La Esperanza, Municipio Amarillo', 1350, 'https://live.staticflickr.com/8243/8653059337_0e3a4a8774_z.jpg', 'U001', 1);

SELECT * from productos p ;
