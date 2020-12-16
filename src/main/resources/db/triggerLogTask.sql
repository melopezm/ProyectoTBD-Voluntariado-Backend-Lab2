CREATE TABLE log_tarea(
	id serial NOT NULL,
	id_tarea numeric(8,0),
	tarea text,
	estado text,
	fecha_de_creacion timestamp
);

CREATE TABLE log_emergencia(
	id serial NOT NULL,
	id_emergencia numeric(8,0),
	emergencia text,
	estado text,
	fecha_de_creacion timestamp,
	descrip text
);


ALTER TABLE log_tarea ADD COLUMN descrip text;
CREATE OR REPLACE FUNCTION insertarRegistroLogTarea() RETURNS trigger AS
$$
BEGIN
INSERT INTO log_tarea(id_tarea,tarea,descrip,estado,fecha_de_creacion) VALUES (NEW.id,NEW.nombre,New.descrip,'Creada',current_timestamp);
RETURN NEW;
END;
$$
LANGUAGE plpgsql;
--- Este Trigger se dispara después de la creación de la tarea
CREATE TRIGGER trigger_insertar_tarea
AFTER INSERT ON tarea
FOR EACH ROW
EXECUTE PROCEDURE insertarRegistroLogTarea();
---
CREATE OR REPLACE FUNCTION insertarRegistroLogTarea2() RETURNS trigger AS
$$
BEGIN
INSERT INTO log_tarea(id_tarea,tarea,descrip,estado,fecha_de_creacion) VALUES (NEW.id,NEW.nombre,New.descrip,'Creada',current_timestamp);
UPDATE log_tarea SET estado = 'Iniciada' WHERE id = (select max(id) from log_tarea) and New.id_estado = 1;
UPDATE log_tarea SET estado = 'Cancelada' WHERE id = (select max(id) from log_tarea) and New.id_estado = 2;
UPDATE log_tarea SET estado = 'Finalizada' WHERE id = (select max(id) from log_tarea) and New.id_estado = 3;
RETURN NEW;
END;
$$
LANGUAGE plpgsql;
--- Este Trigger se dispara después de actualizar el estado de la tarea
CREATE TRIGGER trigger_actualizar_tarea
AFTER UPDATE ON tarea
FOR EACH ROW
EXECUTE PROCEDURE insertarRegistroLogTarea2();
---
CREATE OR REPLACE FUNCTION insertarRegistroLogEmergencia() RETURNS trigger AS
$$
BEGIN
INSERT INTO log_emergencia(id_emergencia,emergencia,descrip,estado,fecha_de_creacion) VALUES (NEW.id,NEW.nombre,New.descrip,'Creada',current_timestamp);
RETURN NEW;
END;
$$
LANGUAGE plpgsql;
--- Este Trigger se dispara después de la creación de la emergencia
CREATE TRIGGER trigger_insertar_emergencia
AFTER INSERT ON emergencia
FOR EACH ROW
EXECUTE PROCEDURE insertarRegistroLogEmergencia();
---
CREATE OR REPLACE FUNCTION insertarRegistroLogEmergencia2() RETURNS trigger AS
$$
BEGIN
INSERT INTO log_emergencia(id_emergencia,emergencia,descrip,estado,fecha_de_creacion) VALUES (NEW.id,NEW.nombre,New.descrip,'Creada',current_timestamp);
UPDATE log_emergencia SET estado = 'Iniciada' WHERE id = (select max(id) from log_emergencia) and New.id_estado = 1;
UPDATE log_emergencia SET estado = 'Cancelada' WHERE id = (select max(id) from log_emergencia) and New.id_estado = 2;
UPDATE log_emergencia SET estado = 'Finalizada' WHERE id = (select max(id) from log_emergencia) and New.id_estado = 3;
RETURN NEW;
END;
$$
LANGUAGE plpgsql;
--- Este Trigger se dispara después de actualizar el estado de la emergencia
CREATE TRIGGER trigger_actualizar_emergencia
AFTER UPDATE ON emergencia
FOR EACH ROW
EXECUTE PROCEDURE insertarRegistroLogEmergencia2();
