Tablas:

CREATE TABLE IF NOT EXISTS Usuario(email VARCHAR(50) PRIMARY KEY, password VARCHAR(20) NOT NULL, numerodecuenta INTEGER NOT NULL, nombre VARCHAR(50) NOT NULL, documento VARCHAR(50) NOT NULL, tipodedocumento VARCHAR(20) NOT NULL, telefono VARCHAR(50) NOT NULL);

CREATE TABLE IF NOT EXISTS Subasta (id SERIAL PRIMARY KEY, fechainicio TIMESTAMP, fechafin TIMESTAMP NOT NULL, vendedor VARCHAR(50) REFERENCES Usuario(email));

CREATE TABLE IF NOT EXISTS Participaciones (emailusuario VARCHAR(50) REFERENCES Usuario(email), idsubasta INTEGER REFERENCES Subasta(id));

ALTER TABLE Participaciones ADD CONSTRAINT PK_PARTICIPACIONES PRIMARY KEY (emailusuario, idsubasta);

CREATE TABLE IF NOT EXISTS Puja(id SERIAL PRIMARY KEY, monto INTEGER NOT NULL, fecha TIMESTAMP, usuario VARCHAR(50) REFERENCES Usuario(email), subasta INTEGER REFERENCES Subasta(id));

CREATE TABLE IF NOT EXISTS Categoria (id SERIAL PRIMARY KEY, nombre VARCHAR(60) NOT NULL);

CREATE TABLE IF NOT EXISTS Articulo (id SERIAL PRIMARY KEY, nombre VARCHAR(50) NOT NULL, estadodeuso VARCHAR(5) NOT NULL, descripcion VARCHAR(600), preciominimo DOUBLE NOT NULL, dimensiones VARCHAR(20), ubicacion VARCHAR(30) NOT NULL, imagen VARCHAR(20) NOT NULL, usuario VARCHAR(50) REFERENCES Usuario(email), subasta INTEGER REFERENCES Subasta(id), categoria INTEGER REFERENCES Categoria(id));



Únicas:

ALTER TABLE Usuario ADD CONSTRAINT telefono_unico UNIQUE(phone);
ALTER TABLE Categoria ADD CONSTRAINT categoria_unica UNIQUE(nombre);

Poblar:


Consultas:

SELECT * FROM Usuario;
SELECT * FROM Puja;
SELECT * FROM Subasta;
SELECT * FROM Categoria;
SELECT * FROM Articulo;


Integridad:

ALTER TABLE Usuario ADD CONSTRAINT CK_Usuario_Clave CHECK (LENGTH(clave) > 8);

ALTER TABLE Articulo ADD CONSTRAINT CK_Articulo_Uso CHECK (uso IN ('Usado', 'Nuevo'));


Posibles categorias:
'Instrumentos musicales', 'Deportes', 'Tecnología', 'Libros', 'Ropa', 'Electrodomesticos', 'Juegos', 
'Muebles', 'Juguetes', 'Hobbies y Coleccionables', 'Salud y Belleza', 'Hogar y Cocina', 'Accesorios', 
'Mascotas', 'Bebes', 'Carros', 'Motos', 'Jardineria';   


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
DROP TABLE categoria_articles CASCADE;
DROP TABLE subasta_bids CASCADE;
DROP TABLE subasta_usuarios CASCADE;
DROP TABLE usuario_auctions CASCADE;
DROP TABLE usuario_favorites CASCADE;
