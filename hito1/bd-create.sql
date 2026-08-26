CREAR BASE DE DATOS
create database bd_epicentro_gourmet

RELLENARLA CON DATOS
USE bd_epicentro_gourmet;

-- 1. Desactivar FKs para evitar conflictos al limpiar
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE unidad_personal;
TRUNCATE TABLE unidad_plato;
TRUNCATE TABLE item_pedido;
TRUNCATE TABLE pedido;
TRUNCATE TABLE foodtruck;
TRUNCATE TABLE puestodesarmable;
TRUNCATE TABLE unidad_venta;
TRUNCATE TABLE cocinero;
TRUNCATE TABLE cajero;
TRUNCATE TABLE personal;
TRUNCATE TABLE plato;
TRUNCATE TABLE festival;

SET FOREIGN_KEY_CHECKS = 1;

-- 2. Insertar Festivales
INSERT INTO festival (idFestival, nombre, temporada, fechaInicio, fechaFin, costoPorSuperficie, costoPorMontaje, plusUsoElectricidad, sueldoBase) VALUES
(1, 'Lollapalooza 2026', 'Primavera', '2026-09-15', '2026-09-18', 1500.50, 3000.00, 500.00, 120000.00),
(2, 'Cosquín Rock 2027', 'Verano', '2027-02-10', '2027-02-12', 1200.00, 2500.00, 400.00, 100000.00);

-- 3. Insertar Personal (Tabla Padre)
INSERT INTO personal (idPersonal, nombre, apellido, dni, fechaDeNacimiento, fechaIngreso, sueldoBase) VALUES
(1, 'Gordon', 'Ramsay', 30111222, '1985-05-20', '2024-01-15', 180000.00),
(2, 'Donato', 'De Santis', 31222333, '1978-11-05', '2024-02-01', 175000.00),
(3, 'Laura', 'Gómez', 35333444, '1992-08-10', '2024-03-01', 150000.00),
(4, 'Carlos', 'Pérez', 38444555, '1995-12-01', '2024-04-10', 145000.00);

-- 4. Insertar Subclases de Personal (Hijas - Joined)
INSERT INTO cocinero (idPersonal, especialidadCulinaria, plus) VALUES
(1, 'Parrilla y Ahogados', 25000.00),
(2, 'Pastas y Minutas', 20000.00);

INSERT INTO cajero (idPersonal, turnoTrabajo) VALUES
(3, 'Noche'),
(4, 'Tarde');

-- 5. Insertar Platos
INSERT INTO plato (idPlato, nombre, precioVenta, costoProduccion) VALUES
(1, 'Burger Completa', 8500.00, 3200.00),
(2, 'Papas Rusticas con Cheddar', 4000.00, 1200.00),
(3, 'Sandwich de Bondiola', 9000.00, 3500.00),
(4, 'Gaseosa 500ml', 2500.00, 800.00);

-- 6. Insertar Unidades de Venta (Tabla Padre)
INSERT INTO unidad_venta (idUnidadVenta, nombreComercial, superficieM2, codigoUnico, idResponsable, idFestival) VALUES
(1, 'La Burgeria Truck', 25.5, 'FT-001', 1, 1),
(2, 'Stand Papas & Co', 12.0, 'PD-001', 3, 1),
(3, 'Bondiolas del Norte', 20.0, 'FT-002', 2, 2);

-- 7. Insertar Subclases de Unidad de Venta (Hijas - Joined)
INSERT INTO foodtruck (idUnidadVenta, patente, conexionElectrica) VALUES
(1, 'AB123CD', b'1'),
(3, 'CD456EF', b'1');

INSERT INTO puestodesarmable (idUnidadVenta, carpasComponen, tiempoMontaje) VALUES
(2, 2, 45);

-- 8. Relaciones N a N (Platos ofertados por Unidad de Venta)
INSERT INTO unidad_plato (idUnidadVenta, idPlato) VALUES
(1, 1), (1, 2), (1, 4), -- La Burgeria vende Burger, Papas y Gaseosa
(2, 2), (2, 4),        -- Stand Papas vende Papas y Gaseosa
(3, 3), (3, 4);        -- Bondiolas vende Bondiola y Gaseosa

-- 9. Relaciones N a N (Personal asignado a Unidad de Venta)
INSERT INTO unidad_personal (idUnidadVenta, idPersonal) VALUES
(1, 1), (1, 3), -- Gordon y Laura en La Burgeria
(2, 4),        -- Carlos en Stand Papas
(3, 2);        -- Donato en Bondiolas

-- 10. Insertar Pedidos
INSERT INTO pedido (idPedido, fechaTransaccion, idUnidadVenta) VALUES
(1, '2026-08-26', 1),
(2, '2026-08-26', 1),
(3, '2026-08-26', 2);

-- 11. Insertar Ítems de Pedido
INSERT INTO item_pedido (idItemPedido, cantidad, idPlato, idPedido) VALUES
(1, 2, 1, 1), -- Pedido 1: 2 Burgers
(2, 1, 2, 1), -- Pedido 1: 1 Papas
(3, 3, 4, 2), -- Pedido 2: 3 Gaseosas
(4, 1, 2, 3); -- Pedido 3: 1 Papas
