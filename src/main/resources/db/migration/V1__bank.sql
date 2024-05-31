-- drop table destinatario;
-- drop table transaccion;
-- drop table compras;
-- drop table cuenta_tarjeta
-- drop table cuenta_ahorros;
-- DROP TABLE usuario;


CREATE TABLE cuenta_tarjeta (
    id_cuenta_tarjeta SERIAL PRIMARY KEY,
    num_tarjeta VARCHAR(255) UNIQUE NOT NULL,
    cvv VARCHAR(255) NOT NULL,
    saldo DOUBLE PRECISION NOT NULL
);

-- Insertar datos en cuenta_tarjeta
INSERT INTO cuenta_tarjeta (num_tarjeta, cvv, saldo)
VALUES ('1234567890123456', '123', 1500.50);

INSERT INTO cuenta_tarjeta (num_tarjeta, cvv, saldo)
VALUES ('2345678901234567', '234', 2500.75);

INSERT INTO cuenta_tarjeta (num_tarjeta, cvv, saldo)
VALUES ('3456789012345678', '345', 3500.25);

INSERT INTO cuenta_tarjeta (num_tarjeta, cvv, saldo)
VALUES ('4567890123456789', '456', 4500.00);

INSERT INTO cuenta_tarjeta (num_tarjeta, cvv, saldo)
VALUES ('5678901234567890', '567', 5500.80);



CREATE TABLE compras (
    id SERIAL PRIMARY KEY,
    fecha DATE,
    resumen VARCHAR(255),
    tipo VARCHAR(255),
    status VARCHAR(255),
    cantidad DOUBLE PRECISION,
    cantidad_disponible NUMERIC,
    cuenta_tarjeta_id BIGINT,
    CONSTRAINT fk_cuenta_tarjeta FOREIGN KEY (cuenta_tarjeta_id) REFERENCES cuenta_tarjeta(id_cuenta_tarjeta)
);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-01-01', 'Compra de oficina', 'oficina', 'completado', 150.00, 100.00, 1);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-02-15', 'Compra de suministros', 'suministros', 'pendiente', 200.00, 150.00, 2);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-03-10', 'Compra de equipo', 'equipo', 'completado', 1200.00, 800.00, 3);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-04-05', 'Compra de software', 'software', 'cancelado', 300.00, 300.00, 4);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-05-20', 'Compra de muebles', 'muebles', 'completado', 450.00, 450.00, 5);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-06-30', 'Compra de servicios', 'servicios', 'pendiente', 600.00, 500.00, 1);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-07-25', 'Compra de materiales', 'materiales', 'completado', 250.00, 200.00, 2);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-08-15', 'Compra de licencias', 'licencias', 'pendiente', 700.00, 600.00, 3);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-09-10', 'Compra de hardware', 'hardware', 'completado', 1100.00, 1000.00, 4);

INSERT INTO compras (fecha, resumen, tipo, status, cantidad, cantidad_disponible, cuenta_tarjeta_id)
VALUES ('2024-10-05', 'Compra de alimentos', 'alimentos', 'pendiente', 350.00, 300.00, 5);



CREATE TABLE cuenta_ahorros (
    id_cuenta_ahorros SERIAL PRIMARY KEY,
    num_cuenta VARCHAR(255),
    balance NUMERIC NOT NULL
);


INSERT INTO cuenta_ahorros (num_cuenta, balance)
VALUES ('1234567890', 1500.75);

INSERT INTO cuenta_ahorros (num_cuenta, balance)
VALUES ('2345678901', 2500.50);

INSERT INTO cuenta_ahorros (num_cuenta, balance)
VALUES ('3456789012', 3500.25);

INSERT INTO cuenta_ahorros (num_cuenta, balance)
VALUES ('4567890123', 4500.00);

INSERT INTO cuenta_ahorros (num_cuenta, balance)
VALUES ('5678901234', 5500.80);




CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    password VARCHAR(255),
    contacto VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    rol VARCHAR(255),
    cuenta_tarjeta_id BIGINT,
    cuenta_ahorros_id BIGINT,
    CONSTRAINT fk_cuenta_tarjeta FOREIGN KEY (cuenta_tarjeta_id) REFERENCES cuenta_tarjeta(id_cuenta_tarjeta),
    CONSTRAINT fk_cuenta_ahorros FOREIGN KEY (cuenta_ahorros_id) REFERENCES cuenta_ahorros(id_cuenta_ahorros)
);



INSERT INTO usuario (nombre, password, contacto, email, rol, cuenta_tarjeta_id, cuenta_ahorros_id)
VALUES ('Juan Perez', 'password123', '123456789', 'juan.perez@example.com', 'ADMIN', 1, 1);

INSERT INTO usuario (nombre, password, contacto, email, rol, cuenta_tarjeta_id, cuenta_ahorros_id)
VALUES ('Maria Lopez', 'password456', '987654321', 'maria.lopez@example.com', 'USER', 2, 2);

INSERT INTO usuario (nombre, password, contacto, email, rol, cuenta_tarjeta_id, cuenta_ahorros_id)
VALUES ('Carlos Sanchez', 'password789', '555666777', 'carlos.sanchez@example.com', 'USER', 3, 3);

INSERT INTO usuario (nombre, password, contacto, email, rol, cuenta_tarjeta_id, cuenta_ahorros_id)
VALUES ('Ana Martinez', 'password321', '111222333', 'ana.martinez@example.com', 'ADMIN', 4, 4);

INSERT INTO usuario (nombre, password, contacto, email, rol, cuenta_tarjeta_id, cuenta_ahorros_id)
VALUES ('Luis Gomez', 'password654', '444555666', 'luis.gomez@example.com', 'USER', 5, 5);


CREATE TABLE transaccion (
    id_transaccion SERIAL PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL,
    cantidad DOUBLE PRECISION NOT NULL,
    motivo VARCHAR(255),
    fecha TIMESTAMP NOT NULL,
    cuenta_ahorros_id BIGINT,
    CONSTRAINT fk_cuenta_ahorros FOREIGN KEY (cuenta_ahorros_id) REFERENCES cuenta_ahorros(id_cuenta_ahorros)
);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('AHORRO', 1000.00, 'Ahorros mensuales', '2024-05-01', 1);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('RETIRO', 1500.50, 'Bono de trabajo', '2024-05-03', 2);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('AHORRO', 2000.75, 'Venta de productos', '2024-05-06', 3);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('AHORRO', 2500.25, 'Ingreso extra', '2024-05-09', 4);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('RETIRO', 3000.00, 'Regalo de cumpleaños', '2024-05-12', 5);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('RETIRO', 3500.80, 'Incentivo laboral', '2024-05-15', 1);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('RETIRO', 4000.40, 'Prima de fin de año', '2024-05-18', 2);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('AHORRO', 4500.20, 'Venta de antigüedades', '2024-05-21', 2);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('AHORRO', 5000.10, 'Ingreso por alquiler', '2024-05-24', 3);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_ahorros_id)
VALUES ('AHORRO', 5500.00, 'Premio de lotería', '2024-05-27', 5);


CREATE TABLE destinatario (
    id_destinatario SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255),
    contacto VARCHAR(255),
    num_cuenta VARCHAR(255),
    resumen VARCHAR(255),
    id_usuario BIGINT,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);


INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('Juan Pérez', 'juan@example.com', '123456789', '987654321', 'Cuenta de ahorros', 1);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('María Rodríguez', 'maria@example.com', '987654321', '123456789', 'Cuenta de nómina', 2);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('Pedro Gómez', 'pedro@example.com', '456789123', '654321987', 'Cuenta de inversión', 3);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('Laura Martínez', 'laura@example.com', '987654321', '321654987', 'Cuenta de ahorros compartida', 4);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('Carlos López', 'carlos@example.com', '654987321', '123987654', 'Cuenta de emergencia', 5);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('Ana García', 'ana@example.com', '789654321', '456123789', 'Cuenta de ahorros familiar', 1);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('David Fernández', 'david@example.com', '321987654', '789456123', 'Cuenta de gastos compartidos', 2);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('Sofía Díaz', 'sofia@example.com', '987654123', '456789321', 'Cuenta de ahorros personal', 3);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('Eduardo Vargas', 'eduardo@example.com', '987321654', '987123456', 'Cuenta de inversión conjunta', 4);

INSERT INTO destinatario (nombre, email, contacto, num_cuenta, resumen, id_usuario)
VALUES ('Patricia Ruiz', 'patricia@example.com', '456123987', '321789654', 'Cuenta de ahorros de la empresa', 5);


