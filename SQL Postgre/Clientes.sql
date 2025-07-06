-- Eliminar la tabla si ya existe
DROP TABLE persona;

-- Crear tabla persona con todos los campos de una vez
CREATE TABLE persona (
    identificacion VARCHAR(20) UNIQUE,
    idcliente SERIAL PRIMARY KEY, -- Autoincremental
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    edad INTEGER NOT NULL,
    direccion VARCHAR(500) NOT NULL,
    telefono VARCHAR(100) NOT NULL,
    estado VARCHAR(20) DEFAULT 'activo', -- Por ejemplo: activo, inactivo
    estado_civil VARCHAR(20) DEFAULT 'soltero', -- Por ejemplo: soltero, casado, divorciado
    fecharegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Fecha y hora actual
);


-- Crear tabla Cliente
CREATE TABLE cliente (
    idcliente INTEGER,
    identificacion VARCHAR(20) NOT NULL UNIQUE,
	users VARCHAR(50) NOT NULL,
	pass VARCHAR(50) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_cliente VARCHAR(50) DEFAULT 'regular', -- Ejemplo adicional, puedes quitarlo si no lo usas
	estado VARCHAR(50) DEFAULT 'activo'
    --FOREIGN KEY (identificacion) REFERENCES persona(identificacion) ON DELETE CASCADE
);

ALTER TABLE cliente DROP CONSTRAINT cliente_identificacion_fkey;
ALTER TABLE cliente ADD CONSTRAINT unique_identificacion UNIQUE (identificacion);
TRUNCATE TABLE cliente

SELECT * FROM cliente;
SELECT * FROM persona;

GRANT ALL PRIVILEGES ON DATABASE clientdb TO postgres;

ALTER USER postgres WITH PASSWORD 'Postgres0026';


