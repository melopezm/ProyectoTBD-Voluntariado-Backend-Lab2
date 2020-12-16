CREATE TABLE voluntario(
	id numeric(8,0) not null,
	rut text,
	nombre varchar(100),
	apellido varchar(100),	
	correo_electronico text,
	celular text,
	fnacimiento date,
	PRIMARY KEY (id)
); 

	
create table habilidad(
	id numeric(4,0) not null,
	descrip varchar(100),
	primary key(id)
);


CREATE TABLE institucion
(
    id numeric(4,0) NOT NULL,
    nombre character varying(100), 
    descrip character varying(400),
    PRIMARY KEY (id)
);



CREATE TABLE vol_habilidad
(
    id numeric(8,0) NOT NULL,
    id_voluntario numeric(8,0),
    id_habilidad numeric(8,0),
	PRIMARY KEY (id),
    FOREIGN KEY (id_habilidad) REFERENCES habilidad (id) ON UPDATE CASCADE ON DELETE CASCADE ,
    FOREIGN KEY (id_voluntario) REFERENCES voluntario (id) ON UPDATE CASCADE ON DELETE CASCADE 
);


CREATE TABLE estado_tarea
(
    id numeric(2,0) NOT NULL,
    descrip character varying(20),
    PRIMARY KEY (id)
);



CREATE TABLE emergencia
(
    id numeric(6,0) NOT NULL,
    nombre character varying(100),
    descrip character varying(400),
    finicio date,
    ffin date,
    id_institucion numeric(4,0),
	id_estado numeric(2,0),
    PRIMARY KEY (id),
    FOREIGN KEY (id_institucion) REFERENCES institucion (id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (id_estado) REFERENCES estado_tarea (id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE tarea
(
    id numeric(8,0) NOT NULL,
    nombre character varying(60),
    descrip character varying(300),
    cant_vol_requeridos numeric(4,0),
    cant_vol_inscritos numeric(4,0),
    id_emergencia numeric(6,0),
    finicio date,
    ffin date,
    id_estado numeric(2,0),
    PRIMARY KEY (id),
	FOREIGN KEY (id_emergencia) REFERENCES emergencia (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_estado) REFERENCES estado_tarea (id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE ranking
(
    id numeric(8,0) NOT NULL,
    id_voluntario numeric(8,0),
    id_tarea numeric(8,0),
    puntaje numeric(3,0),
    flg_invitado numeric(1,0),
    flg_participa numeric(1,0),
    PRIMARY KEY (id),
    FOREIGN KEY (id_tarea) REFERENCES tarea (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_voluntario) REFERENCES voluntario (id) ON UPDATE CASCADE ON DELETE CASCADE
);



COMMENT ON TABLE ranking
    IS 'los flgInvitado, flgParticipa 1 si la respuesta es si, 2 si la respuesta es no';



CREATE TABLE eme_habilidad
(
    id numeric(8,0) NOT NULL,
    id_emergencia numeric(6,0),
    id_habilidad numeric(4,0),
    PRIMARY KEY (id),
    FOREIGN KEY (id_emergencia) REFERENCES emergencia (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_habilidad) REFERENCES habilidad (id) ON UPDATE CASCADE ON DELETE CASCADE
);

	
CREATE TABLE tarea_habilidad
(
    id numeric(8,0) NOT NULL,
    id_emehab numeric(8,0),
    id_tarea numeric(8,0),
    PRIMARY KEY (id),
    FOREIGN KEY (id_emehab) REFERENCES eme_habilidad (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_tarea) REFERENCES tarea (id) ON UPDATE CASCADE ON DELETE CASCADE
);



