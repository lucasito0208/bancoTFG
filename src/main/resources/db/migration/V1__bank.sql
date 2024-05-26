DROP TABLE transaccion;
DROP TABLE cuenta;
DROP TABLE usuario;


CREATE TABLE cuenta (
    id SERIAL PRIMARY KEY,
    num_tarjeta VARCHAR(255) NOT NULL UNIQUE,
    cvv VARCHAR(255) NOT NULL,
    saldo DOUBLE PRECISION NOT NULL,
    id_usuario BIGINT,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4929666471840368', '378', 2349.81, 3);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4485918166448400', '432', 5734.27, 7);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('5417387285485104', '879', 9235.47, 5);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4556751040407755', '765', 4196.59, 9);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4485781999142929', '129', 6823.15, 8);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4539309206011415', '533', 1274.92, 2);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4556037068004328', '984', 3045.08, 5);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4716673185406701', '643', 8592.37, 4);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4024007165986810', '275', 5721.16, 10);
INSERT INTO cuenta (num_tarjeta, cvv, saldo, id_usuario) VALUES ('4532041963485884', '847', 1221.64, 1);



CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    contacto VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

INSERT INTO usuario (nombre, password, contacto, email, rol) VALUES ('Florentino Perez', 'contraseña1', '1515151515', 'floren@gmail.com', 'ADMIN');
INSERT INTO usuario (nombre, password, contacto, email, rol) VALUES ('María López', 'contraseña2', '987654321', 'maria@example.com', 'USER');
INSERT INTO usuario (nombre, password, contacto, email, rol) VALUES ('Pedro García', 'contraseña3', '555555555', 'pedro@example.com', 'USER');
INSERT INTO usuario (nombre, password, contacto, email, rol) VALUES ('Ana Martínez', 'contraseña4', '333333333', 'ana@example.com', 'USER');
INSERT INTO usuario (nombre, password, contacto, email, rol) VALUES ('Laura Rodriguez', 'contraseña5', '111111111', 'laura@example.com', 'USER');


CREATE TABLE transaccion (
    id_transaccion SERIAL PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    cantidad DOUBLE PRECISION NOT NULL,
    motivo VARCHAR(255),
    fecha TIMESTAMP NOT NULL,
    cuenta_id BIGINT,
    CONSTRAINT fk_cuenta FOREIGN KEY (cuenta_id) REFERENCES cuenta(id)
);

INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('DEPOSITO', 1000.50, 'Depósito inicial', '2024-05-25 08:00:00', 1);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 200.75, 'Compra en supermercado', '2024-05-25 10:30:00', 1);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 150.00, 'Pago de factura', '2024-05-25 11:45:00', 2);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('DEPOSITO', 500.25, 'Depósito de salario', '2024-05-25 12:15:00', 2);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 300.00, 'Retiro de efectivo', '2024-05-25 13:30:00', 3);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 75.50, 'Pago de servicios', '2024-05-25 14:45:00', 3);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('DEPOSITO', 2000.00, 'Depósito de ahorros', '2024-05-25 15:00:00', 4);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 1500.00, 'Compra de electrodomésticos', '2024-05-25 16:30:00', 4);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 100.00, 'Pago de deuda', '2024-05-25 17:45:00', 5);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('DEPOSITO', 300.75, 'Depósito de bonificación', '2024-05-25 18:15:00', 5);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 50.00, 'Retiro en cajero automático', '2024-05-25 19:30:00', 6);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 25.25, 'Pago de factura de teléfono', '2024-05-25 20:45:00', 6);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('DEPOSITO', 800.00, 'Depósito de regalos', '2024-05-25 21:00:00', 7);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 700.00, 'Compra de ropa', '2024-05-25 22:30:00', 7);
INSERT INTO transaccion (tipo, cantidad, motivo, fecha, cuenta_id) VALUES ('RETIRO', 200.50, 'Pago de préstamo', '2024-05-25 23:45:00', 8);

