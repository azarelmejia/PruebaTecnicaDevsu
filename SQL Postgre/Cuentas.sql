

-- Tabla: TipoCuentas (Tipos de Cuenta)
CREATE TABLE TipoCuentas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255)
);

-- Tabla: EstadoTransacciones (Estados de Transacción)
CREATE TABLE EstadoTransacciones (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255)
);


CREATE SEQUENCE seq_cuenta_tipo1 START WITH 100001 INCREMENT BY 1;
CREATE SEQUENCE seq_cuenta_tipo2 START WITH 200001 INCREMENT BY 1;
CREATE SEQUENCE seq_cuenta_tipo3 START WITH 300001 INCREMENT BY 1;

-- Tabla: Cuentas (Accounts)
CREATE TABLE Cuentas (
    numerocuenta BIGINT PRIMARY KEY,
    idcliente INT NOT NULL REFERENCES cliente(idcliente),  -- FK al cliente
    idtipocuenta INT NOT NULL REFERENCES TipoCuentas(id),  -- FK al tipo de cuenta
    saldoinicial DECIMAL(15,2) DEFAULT 0.00,
    saldodisponible DECIMAL(15,2) DEFAULT 0.00,
    estado VARCHAR(20) DEFAULT 'Activo',
    creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT unq_cliente_tipocuenta UNIQUE (idcliente, idtipocuenta)
);


-- Tabla: Transacciones (Movimientos o Transacciones)
CREATE TABLE Transacciones (
    id SERIAL PRIMARY KEY,
    numerocuenta INT NOT NULL REFERENCES Cuentas(numerocuenta) ON DELETE CASCADE,
    tipotransaccion VARCHAR(50) NOT NULL,  -- Ej: 'Débito' o 'Crédito'
    monto DECIMAL(15,2) NOT NULL,
    saldo DECIMAL(15,2) NOT NULL,
    idestadotransaccion INT NOT NULL REFERENCES EstadoTransacciones(id),
	fecha DATE DEFAULT CURRENT_DATE,
    creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE Transacciones
ADD COLUMN descripciontrx VARCHAR(500);



-- Insertar tipos de cuenta
INSERT INTO TipoCuentas (nombre, descripcion) VALUES 
('Ahorro', 'Cuenta de ahorro tradicional'),
('Corriente', 'Cuenta corriente para operaciones diarias');

-- Insertar estados de transacción
INSERT INTO EstadoTransacciones (nombre, descripcion) VALUES 
('Completado', 'Transacción completada exitosamente'),
('Rechazado', 'Transacción rechazada por falta de fondos'),
('Pignorado', 'Transacción pignorada por debito/credito pendiente');

-- Insertar cuenta para cliente 1
INSERT INTO Cuentas (numerocuenta, idcliente, idtipocuenta, saldoinicial, saldodisponible, estado)
VALUES (nextval('seq_cuenta_tipo1'), 2, 1, 2000.00, 2000.00, 'Activo');

-- Nota: El valor de numerocuenta se genera automáticamente por SERIAL, así que necesitamos saber su valor si queremos referenciarlo después.
-- Supongamos que numerocuenta generado fue 1

-- Insertar transacciones para la cuenta 1
INSERT INTO Transacciones (numerocuenta, tipotransaccion, monto, saldo, idestadotransaccion, fecha, creado)
VALUES 
(100003, 'Retiro', 1000, 5000, 1, CURRENT_DATE, CURRENT_TIMESTAMP);   -- Saldo sube a 1500


drop table cuentas

SELECT * FROM tipocuentas
SELECT * FROM estadotransacciones c
SELECT * FROM cuentas c
SELECT * FROM transacciones ORDER BY ID DESC

UPDATE cuentas SET saldodisponible = 36001.00 WHERE numerocuenta = 100003
UPDATE transacciones SET fecha = '2025-07-04' WHERE id = 2

SELECT t.id, t.numerocuenta, 
t.monto, t.saldo, et.nombre trxcompleted, t.tipoTransaccion, t.fecha, t.creado
FROM transacciones t
JOIN cuentas c on t.numerocuenta = c.numerocuenta
JOIN estadotransacciones et on t.idestadotransaccion = et.id
JOIN tipocuentas ON tipocuentas.id = c.idtipocuenta
WHERE  c.idCliente = 2
AND t.fecha BETWEEN '2025/07/04' AND '2025/07/06' 
order by id desc

