ALTER TABLE usuario ADD COLUMN rol_temp smallint;

UPDATE usuario
SET rol_temp = CASE
    WHEN rol = 'ADMIN' THEN 1
    WHEN rol = 'USER' THEN 2
    ELSE NULL
END;

ALTER TABLE usuario DROP COLUMN rol;

ALTER TABLE usuario RENAME COLUMN rol_temp TO rol;

