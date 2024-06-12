

DROP TABLE IF EXISTS op_a;
DROP TABLE IF EXISTS op_b;
DROP TABLE IF EXISTS tarjeta;
DROP TABLE IF EXISTS ahorros;

DROP TABLE IF EXISTS cita;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS rol;
DROP TABLE IF EXISTS destinatario;
DROP TABLE IF EXISTS usuario;


CREATE TABLE tarjeta(
    tarjeta_id BIGSERIAL NOT NULL,
    balance DECIMAL(19, 2) DEFAULT NULL,
    num_cuenta  INT NOT NULL,
    PRIMARY KEY (tarjeta_id)
);

INSERT INTO tarjeta (tarjeta_id, balance, num_cuenta) VALUES (11, 1000.50, 123456789);
INSERT INTO tarjeta (tarjeta_id, balance, num_cuenta) VALUES (12, 500.75, 987654321);
INSERT INTO tarjeta (tarjeta_id, balance, num_cuenta) VALUES (13, 200.00, 456789123);
INSERT INTO tarjeta (tarjeta_id, balance, num_cuenta) VALUES (14, 750.25, 321654987);
INSERT INTO tarjeta (tarjeta_id, balance, num_cuenta) VALUES (15, 1200.00, 654321789);


CREATE TABLE ahorros (
     ahorros_id BIGSERIAL NOT NULL,
     balance NUMERIC(19, 2) DEFAULT NULL,
     num_cuenta INTEGER NOT NULL,
     PRIMARY KEY (ahorros_id)
);

INSERT INTO ahorros (ahorros_id, balance, num_cuenta) VALUES (11, 1500.75, 223344556);
INSERT INTO ahorros (ahorros_id, balance, num_cuenta) VALUES (12, 300.50, 998877665);
INSERT INTO ahorros (ahorros_id, balance, num_cuenta) VALUES (13, 950.00, 556677889);
INSERT INTO ahorros (ahorros_id, balance, num_cuenta) VALUES (14, 450.25, 667788990);
INSERT INTO ahorros (ahorros_id, balance, num_cuenta) VALUES (15, 2000.00, 334455667);


CREATE TABLE usuario (
    usuario_id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    disponible BOOLEAN NOT NULL,
    nombre VARCHAR(255) DEFAULT NULL,
    apellidos VARCHAR(255) DEFAULT NULL,
    password VARCHAR(255) DEFAULT NULL,
    contacto VARCHAR(255) DEFAULT NULL,
    nombre_usuario VARCHAR(255) DEFAULT NULL,
    id_tarjeta BIGINT DEFAULT NULL,
    id_ahorros BIGINT DEFAULT NULL,
    CONSTRAINT fk_usuario_tarjeta FOREIGN KEY (id_tarjeta) REFERENCES tarjeta (tarjeta_id),
    CONSTRAINT fk_usuario_ahorros FOREIGN KEY (id_ahorros) REFERENCES ahorros (ahorros_id)
);

INSERT INTO usuario (email, disponible, nombre, apellidos, password, contacto, nombre_usuario, id_tarjeta, id_ahorros)
VALUES ('johny.doe@example.com', TRUE, 'John', 'Doe', 'password123', '123-456-7890', 'johndoe', 11, 11);

INSERT INTO usuario (email, disponible, nombre, apellidos, password, contacto, nombre_usuario, id_tarjeta, id_ahorros)
VALUES ('janey.smith@example.com', FALSE, 'Jane', 'Smith', 'password456', '234-567-8901', 'janesmith', 12, 12);

INSERT INTO usuario (email, disponible, nombre, apellidos, password, contacto, nombre_usuario, id_tarjeta, id_ahorros)
VALUES ('alexy.jones@example.com', TRUE, 'Alex', 'Jones', 'password789', '345-678-9012', 'alexjones', 13, 13);

INSERT INTO usuario (email, disponible, nombre, apellidos, password, contacto, nombre_usuario, id_tarjeta, id_ahorros)
VALUES ('chrisy.brown@example.com', TRUE, 'Chris', 'Brown', 'password101', '456-789-0123', 'chrisbrown', 14, 14);

INSERT INTO usuario (email, disponible, nombre, apellidos, password, contacto, nombre_usuario, id_tarjeta, id_ahorros)
VALUES ('paty.taylor@example.com', FALSE, 'Pat', 'Taylor', 'password202', '567-890-1234', 'pattaylor', 15, 15);



CREATE TABLE cita (
      cita_id BIGSERIAL PRIMARY KEY,
      confirmado BOOLEAN NOT NULL,
      fecha TIMESTAMP DEFAULT NULL,
      motivo VARCHAR(255),
      lugar VARCHAR(255),
      usuario_id BIGINT,
      CONSTRAINT fk_usuario_cita FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO cita (confirmado, fecha, motivo, lugar, usuario_id)
VALUES (TRUE, '2024-06-15 10:00:00', 'Consulta general', 'Oficina central', 7);

INSERT INTO cita (confirmado, fecha, motivo, lugar, usuario_id)
VALUES (FALSE, '2024-06-16 14:00:00', 'Revisión de cuenta', 'Sucursal norte', 7);

INSERT INTO cita (confirmado, fecha, motivo, lugar, usuario_id)
VALUES (TRUE, '2024-06-17 09:30:00', 'Asesoría financiera', 'Oficina central', 7);

INSERT INTO cita (confirmado, fecha, motivo, lugar, usuario_id)
VALUES (FALSE, '2024-06-18 11:00:00', 'Solicitud de préstamo', 'Sucursal este', 8);

INSERT INTO cita (confirmado, fecha, motivo, lugar, usuario_id)
VALUES (TRUE, '2024-06-19 15:00:00', 'Actualización de datos', 'Sucursal sur', 8);


CREATE TABLE op_a (
     op_a_id BIGSERIAL PRIMARY KEY,
     cantidad DOUBLE PRECISION NOT NULL,
     balance DECIMAL(19, 2),
     fecha TIMESTAMP,
     motivo VARCHAR(255),
     estado VARCHAR(255),
     tipo VARCHAR(255),
     id_tarjeta BIGINT,
     CONSTRAINT fk_tarjeta_op_a FOREIGN KEY (id_tarjeta) REFERENCES tarjeta (tarjeta_id)
);

INSERT INTO op_a (cantidad, balance, fecha, motivo, estado, tipo, id_tarjeta)
VALUES (1500.75, 1200.50, '2024-06-10 10:30:00', 'Pago de servicios', 'Completado', 'Débito', 11);

INSERT INTO op_a (cantidad, balance, fecha, motivo, estado, tipo, id_tarjeta)
VALUES (2000.00, 1800.75, '2024-06-11 12:45:00', 'Transferencia bancaria', 'Pendiente', 'Crédito', 12);

INSERT INTO op_a (cantidad, balance, fecha, motivo, estado, tipo, id_tarjeta)
VALUES (500.50, 950.25, '2024-06-12 15:00:00', 'Compra en tienda', 'Fallido', 'Débito', 12);

INSERT INTO op_a (cantidad, balance, fecha, motivo, estado, tipo, id_tarjeta)
VALUES (250.00, 700.00, '2024-06-13 09:20:00', 'Retiro de efectivo', 'Completado', 'Débito', 11);

INSERT INTO op_a (cantidad, balance, fecha, motivo, estado, tipo, id_tarjeta)
VALUES (3000.00, 3500.50, '2024-06-14 18:30:00', 'Depósito', 'Completado', 'Crédito', 11);


CREATE TABLE destinatario (
    destinatario_id BIGSERIAL PRIMARY KEY,
    num_cuenta VARCHAR(255),
    resumen VARCHAR(255),
    email VARCHAR(255),
    nombre VARCHAR(255),
    contacto VARCHAR(255),
    usuario_id BIGINT,
    CONSTRAINT fk_usuario_destinatario FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id)
);

INSERT INTO destinatario (num_cuenta, resumen, email, nombre, contacto, usuario_id)
VALUES ('1234567890', 'Pago de alquiler', 'alquiler@example.com', 'John Doe', '555-1234', 7);

INSERT INTO destinatario (num_cuenta, resumen, email, nombre, contacto, usuario_id)
VALUES ('0987654321', 'Pago de gimnasio', 'gym@example.com', 'Jane Smith', '555-5678', 7);

INSERT INTO destinatario (num_cuenta, resumen, email, nombre, contacto, usuario_id)
VALUES ('1122334455', 'Pago de impuestos', 'taxes@example.com', 'Tax Office', '555-9876', 7);

INSERT INTO destinatario (num_cuenta, resumen, email, nombre, contacto, usuario_id)
VALUES ('5566778899', 'Pago de electricidad', 'electricidad@example.com', 'Electric Company', '555-4321', 8);

INSERT INTO destinatario (num_cuenta, resumen, email, nombre, contacto, usuario_id)
VALUES ('6677889900', 'Pago de agua', 'agua@example.com', 'Water Company', '555-8765', 8);

CREATE TABLE rol (
    rol_id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) DEFAULT NULL
);

INSERT INTO rol (rol_id, nombre)
VALUES (0, 'USUARIO'),
       (1, 'ADMINISTRADOR');

CREATE TABLE op_b (
    op_b_id BIGSERIAL PRIMARY KEY,
    cantidad DOUBLE PRECISION NOT NULL,
    balance DECIMAL(19, 2),
    fecha TIMESTAMP,
    motivo VARCHAR(255),
    estado VARCHAR(255),
    tipo VARCHAR(255),
    id_ahorros BIGINT,
    CONSTRAINT fk_tarjeta_op_b FOREIGN KEY (id_ahorros) REFERENCES ahorros (ahorros_id)
);

INSERT INTO op_b (cantidad, balance, fecha, motivo, estado, tipo, id_ahorros)
VALUES (100.50, 1500.75, '2023-01-15 10:30:00', 'Depósito mensual', 'Completado', 'Depósito', 11);

INSERT INTO op_b (cantidad, balance, fecha, motivo, estado, tipo, id_ahorros)
VALUES (200.00, 1300.50, '2023-02-10 12:00:00', 'Transferencia', 'Pendiente', 'Transferencia', 12);

INSERT INTO op_b (cantidad, balance, fecha, motivo, estado, tipo, id_ahorros)
VALUES (50.75, 1550.25, '2023-03-20 09:00:00', 'Retiro de efectivo', 'Completado', 'Retiro', 13);

INSERT INTO op_b (cantidad, balance, fecha, motivo, estado, tipo, id_ahorros)
VALUES (75.00, 1600.00, '2023-04-05 14:45:00', 'Pago de servicios', 'Fallido', 'Pago', 11);

INSERT INTO op_b (cantidad, balance, fecha, motivo, estado, tipo, id_ahorros)
VALUES (150.25, 1450.75, '2023-05-18 11:30:00', 'Intereses', 'Completado', 'Intereses', 11);


CREATE TABLE rol_usuarios (
      roles_id SERIAL PRIMARY KEY,
      id_rol INT DEFAULT NULL,
      id_usuario BIGINT DEFAULT NULL,
      CONSTRAINT fk_id_rol FOREIGN KEY (id_rol) REFERENCES rol (rol_id),
      CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (usuario_id)
);

INSERT INTO rol_usuarios (id_rol, id_usuario)
VALUES (0, 7),
       (1, 8),
       (1, 9),
       (1, 10),
       (1, 11);













