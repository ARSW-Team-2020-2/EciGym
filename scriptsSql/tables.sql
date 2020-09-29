Tablas:

CREATE TABLE IF NOT EXISTS Usuario(id SERIAL PRIMARY KEY, email VARCHAR(50) NOT NULL, password VARCHAR(20) NOT NULL, nombre VARCHAR(50) NOT NULL, documento VARCHAR(50) NOT NULL, tipodedocumento VARCHAR(20) NOT NULL, telefono VARCHAR(50) NOT NULL);

CREATE TABLE IF NOT EXISTS Subasta (id SERIAL PRIMARY KEY, fechainicio TIMESTAMP, fechafin TIMESTAMP NOT NULL, vendedor INTEGER REFERENCES Usuario(id));

CREATE TABLE IF NOT EXISTS Participaciones (idusuario INTEGER REFERENCES Usuario(id), idsubasta INTEGER REFERENCES Subasta(id));

ALTER TABLE Participaciones ADD CONSTRAINT PK_PARTICIPACIONES PRIMARY KEY (idusuario, idsubasta);

CREATE TABLE IF NOT EXISTS Puja(id SERIAL PRIMARY KEY, monto INTEGER NOT NULL, fecha TIMESTAMP, usuario INTEGER REFERENCES Usuario(id), subasta INTEGER REFERENCES Subasta(id));

CREATE TABLE IF NOT EXISTS Categoria (id SERIAL PRIMARY KEY, nombre VARCHAR(60) NOT NULL);

CREATE TABLE IF NOT EXISTS Articulo (id SERIAL PRIMARY KEY, nombre VARCHAR(50) NOT NULL, estadodeuso VARCHAR(5) NOT NULL, descripcion VARCHAR(600), preciominimo NUMERIC NOT NULL, dimensiones VARCHAR(20), ubicacion VARCHAR(30) NOT NULL, imagen VARCHAR(20) NOT NULL, subasta INTEGER REFERENCES Subasta(id), categoria INTEGER REFERENCES Categoria(id));

CREATE TABLE IF NOT EXISTS Favoritos  (idusuario INTEGER REFERENCES Usuario(id), idarticulo INTEGER REFERENCES Articulo(id));

ALTER TABLE Favoritos ADD CONSTRAINT PK_FAVORITOS PRIMARY KEY (idusuario, idarticulo);



Únicas:

ALTER TABLE Usuario ADD CONSTRAINT telefono_unico UNIQUE(telefono);

ALTER TABLE Categoria ADD CONSTRAINT categoria_unica UNIQUE(nombre);


Consultas:

SELECT * FROM Usuario;
SELECT * FROM Puja;
SELECT * FROM Subasta;
SELECT * FROM Categoria;
SELECT * FROM Articulo;


Integridad:

ALTER TABLE Usuario ADD CONSTRAINT CK_Usuario_Clave CHECK (LENGTH(clave) > 8);

ALTER TABLE Articulo ADD CONSTRAINT CK_Articulo_Uso CHECK (uso IN ('Usado', 'Nuevo'));

Poblar:

insert into Categoria(nombre) values('Instrumentos musicales');
insert into Categoria(nombre) values('Deportes musicales');
insert into Categoria(nombre) values('Tecnología');
insert into Categoria(nombre) values('Libros');
insert into Categoria(nombre) values('Ropa');
insert into Categoria(nombre) values('Bebes');
insert into Categoria(nombre) values('Electrodomesticos');
insert into Categoria(nombre) values('Juegos');
insert into Categoria(nombre) values('Muebles');
insert into Categoria(nombre) values('Accesorios');
insert into Categoria(nombre) values('Juguetes');
insert into Categoria(nombre) values('Mascotas');
insert into Categoria(nombre) values('Jardineria');
insert into Categoria(nombre) values('Carros');
insert into Categoria(nombre) values('Motos');
insert into Categoria(nombre) values('Hobbies y Coleccionables');
insert into Categoria(nombre) values('Salud y Belleza');
insert into Categoria(nombre) values('Hogar y Cocina');
insert into Categoria(nombre) values('Bebidas y Licores'); 


insert into articulo(nombre, estadodeuso, descripcion, preciominimo, dimensiones, ubicacion, imagen, categoria) values('prueba', 'Usado', 'algoooo', 999, '340*360', 'bogota', 'url', 1); 


Disparadores:

CREATE OR REPLACE FUNCTION funcionFechaInicio() RETURNS trigger AS
$$
BEGIN
	NEW.fechainicio:= current_date;
	RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER tb_fecha_inicio
BEFORE INSERT ON public.subasta 
FOR EACH ROW
EXECUTE PROCEDURE funcionFechaInicio();


CREATE OR REPLACE FUNCTION funcionFechaPuja() RETURNS trigger AS
$$
BEGIN
	NEW.fecha:= current_date;
	RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER tb_fecha_puja
BEFORE INSERT ON public.puja
FOR EACH ROW
EXECUTE PROCEDURE funcionFechaPuja();



BORRAR TODO:
DROP TABLE Articulo CASCADE;
DROP TABLE Categoria CASCADE;
DROP TABLE Subasta CASCADE;
DROP TABLE Puja CASCADE;
DROP TABLE Usuario CASCADE;
DROP TABLE Participaciones CASCADE;
DROP TABLE Favoritos CASCADE;

DROP TABLE categoria_articles CASCADE;
DROP TABLE subasta_bids CASCADE;
DROP TABLE subasta_usuarios CASCADE;
DROP TABLE usuario_auctions CASCADE;
DROP TABLE usuario_favorites CASCADE;
