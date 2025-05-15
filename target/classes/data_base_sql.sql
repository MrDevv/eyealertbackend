
CREATE TABLE mae_roles(
	rol_id int not null auto_increment,
    descripcion varchar(20) not null,
    primary key(rol_id)
);

create table mae_usuarios (
	usuario_id int not null auto_increment,
    nombres varchar(100) not null,
    apellidos varchar(100) not null,
    email varchar(255) not null unique,
    password varchar(50) not null,
    cuestionario_conocimientos_completado tinyint(1) not null default 0,
    rol_id int not null,
	fecha datetime not null default current_timestamp,
    primary key (usuario_id),
    foreign key (rol_id) references mae_roles(rol_id)
);

create table trs_evaluaciones(
	evaluacion_id int not null auto_increment,
    fecha datetime not null default current_timestamp,
    tiempo_prediccion decimal(9,2) not null,
    resultado tinyint(1) not null,
    resultado_acertado tinyint(1),
    usuario_id int not null,
    primary key(evaluacion_id),
    foreign key(usuario_id) references mae_usuarios(usuario_id)
);

create table mae_preguntas(
	pregunta_id int not null auto_increment,
    descripcion varchar(255) not null,
    estado tinyint(1) not null default 1,
    primary key(pregunta_id)
);

create table mae_respuestas(
	respuesta_id int not null auto_increment,
    descripcion varchar(20) not null unique,
    primary key(respuesta_id)
);

create table trs_pregunta_detalle(
    pregunta_id int not null,
    respuesta_id int not null,
    primary key(pregunta_id, respuesta_id),
    foreign key(pregunta_id) references mae_preguntas(pregunta_id),
    foreign key(respuesta_id) references mae_respuestas(respuesta_id)
);

create table trd_detalle_evaluacion(
	detalle_evaluacion_id int not null auto_increment,
	evaluacion_id int not null,
    pregunta_id int not null,
    respuesta_id int null,
    respuesta_texto varchar(3),
    primary key(detalle_evaluacion_id),
    foreign key(evaluacion_id) references trs_evaluaciones(evaluacion_id),
    foreign key(pregunta_id) references mae_preguntas(pregunta_id),
    foreign key(respuesta_id) references mae_respuestas(respuesta_id)
);

create table mae_datos_informativos(
	dato_informativo_id int not null auto_increment,
    titulo varchar(100) not null,
    descripcion varchar(255) not null,
    fuente longtext not null,
    fuente_multimedia longtext,
    primary key(dato_informativo_id)
);

create table cuestionario_conocimientos(
	cuestionario_conocimientos_id int not null auto_increment,
	fecha datetime not null default current_timestamp,
	usuario_id int not null,
    puntaje_obtenido int not null,
    primary key(cuestionario_conocimientos_id),
    foreign key(usuario_id) references mae_usuarios(usuario_id)
);

create table respuesta_cuestionario_conocimientos(
	respuesta_cuestionario_conocimientos_id int not null auto_increment,
    cuestionario_conocimientos_id int not null,
    pregunta longtext not null,
    respuesta varchar(1) not null,
    puntaje_pregunta tinyint(1) not null,
    primary key(respuesta_cuestionario_conocimientos_id),
    foreign key(cuestionario_conocimientos_id) references cuestionario_conocimientos(cuestionario_conocimientos_id)
);

create table config_cuestionario(
	config_cuestionario_id int not null auto_increment,
    dias_espera int not null,
    primary key(config_cuestionario_id)
);
