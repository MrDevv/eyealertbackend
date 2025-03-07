CREATE DATABASE eyealert;

use eyealert;

CREATE TABLE usuarios(
	usuario_id INT AUTO_INCREMENT,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(50) NOT NULL,
    primary key(usuario_id)
)