DELETE FROM pago;
INSERT INTO pago (id, documento, estado, monto, fecha)
VALUES (1,'104235698','Al día',850000.00,CURRENT_DATE());
INSERT INTO pago (id, documento, estado, monto, fecha)
VALUES (2,'104235699','Al día',850000.00,'2020-08-30 18:24:10');