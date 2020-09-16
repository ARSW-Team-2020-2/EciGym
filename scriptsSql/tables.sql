Tablas:

CREATE TABLE IF NOT EXISTS Rol(tipo VARCHAR(10) PRIMARY KEY);

CREATE TABLE IF NOT EXISTS Usuario(id SERIAL, document VARCHAR(50) NOT NULL, documenttype VARCHAR(20) NOT NULL, name VARCHAR(50) NOT NULL, phone VARCHAR(50) NOT NULL, email VARCHAR(50) PRIMARY KEY, password VARCHAR(20) NOT NULL, rol VARCHAR(10) REFERENCES Rol(tipo));

ALTER TABLE Usuario ADD CONSTRAINT telefono_unico UNIQUE(phone);

CREATE TABLE IF NOT EXISTS Puja(id SERIAL PRIMARY KEY, usuario VARCHAR(50) REFERENCES Usuario(email), fecha date, amount BIGINT NOT NULL);

CREATE TABLE IF NOT EXISTS Subasta (id SERIAL PRIMARY KEY, initdate TIMESTAMP, findate TIMESTAMP NOT NULL);

CREATE TABLE IF NOT EXISTS Categoria (id SERIAL PRIMARY KEY, nombre VARCHAR(60) NOT NULL);

ALTER TABLE Categoria ADD CONSTRAINT categoria_unica UNIQUE(nombre);

CREATE TABLE IF NOT EXISTS Articulo (id SERIAL PRIMARY KEY, idauction INTEGER REFERENCES Subasta(id), name VARCHAR(50) NOT NULL, uso VARCHAR(5) NOT NULL, description VARCHAR(600), minprice BIGINT NOT NULL, dimensions VARCHAR(20), location VARCHAR(30) NOT NULL, image VARCHAR(20) NOT NULL, idcategory INTEGER REFERENCES Categoria(id));


Poblar:

INSERT INTO Rol VALUES ('VENDEDOR');
INSERT INTO Rol VALUES ('COMPRADOR');

Consultas:

SELECT * FROM Rol;
SELECT * FROM Usuario;
SELECT * FROM Puja;
SELECT * FROM Subasta;
SELECT * FROM Categoria;
SELECT * FROM Articulo;


Integridad:

ALTER TABLE Usuario ADD CONSTRAINT CK_Usuario_TipoDocumento CHECK (typeDoc IN ('CC', 'CE', 'TI'));

ALTER TABLE Usuario ADD CONSTRAINT CK_Usuario_Clave CHECK (LENGTH(clave) > 8);

ALTER TABLE Rol ADD CONSTRAINT CK_Rol_Tipo CHECK (tipo IN ('COMPRADOR', 'VENDEDOR');


Posibles categorias:
'Instrumentos musicales', 'Deportes', 'Tecnología', 'Libros', 'Ropa', 'Electrodomesticos', 'Juegos', 
'Muebles', 'Juguetes', 'Jobbies y Coleccionables', 'Salud y Belleza', 'Hogar y Cocina', 'Accesorios', 
'Mascotas', 'Bebes', 'Carros', 'Motos', 'Jardineria';   

ALTER TABLE Articulo ADD CONSTRAINT CK_Articulo_Uso CHECK (uso IN ('Usado', 'Nuevo'));

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