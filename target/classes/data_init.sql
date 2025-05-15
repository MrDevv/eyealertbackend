INSERT INTO mae_roles(descripcion) VALUES("administrador"), ("usuario");

INSERT INTO mae_respuestas(descripcion) VALUES("Sí"), ("No"), ("Masculino"), ("Femenino");

INSERT INTO mae_usuarios(nombres, apellidos, email, password, rol_id) values("Miguel Angel", "Vega Perez", "miguelvegap10@gmail.com", "1234", 1);

INSERT INTO config_cuestionario(dias_espera) VALUES(7);

INSERT INTO mae_preguntas(descripcion) VALUES
	("Ingresa tu edad"),
    ("Selecciona tu genero"),
    ("¿Te han diagnoticado con presión intraocular (PIO) elevada?"),
    ("¿Tus padres (mamá o papá) fueron diagnosticados con glaucoma?"),
    ("¿Has sido diagnosticado con diabetes mellitus?"),
    ("¿Has sido diagnosticado con hipertesión arterial?"),
    ("¿Has sido diagnosticado con catarata?");
    
INSERT INTO trs_pregunta_detalle VALUES(2, 3), (2, 4),
										(3, 1), (3, 2),
                                        (4, 1), (4, 2),
                                        (5, 1), (5, 2),
                                        (6, 1), (6, 2),
                                        (7, 1), (7, 2);
							
INSERT INTO MAE_DATOS_INFORMATIVOS(titulo, descripcion, fuente, fuente_multimedia) VALUES
	("¿Qué es el glaucoma?", 
    "El glaucoma es una enfermedad que daña el nervio óptico del ojo, lo que puede provocar pérdida de visión o ceguera irreversible.", 
    "https://www.nei.nih.gov/espanol/aprenda-sobre-la-salud-ocular/enfermedades-y-afecciones-de-los-ojos/glaucoma", 
    ""),
    ("¿Cómo se produce el glaucoma?",
    "El glaucoma se produce cuando se acumula fluido en la parte delantera del ojo, aumentando la presión y dañando el nervio óptico.",
    "https://www.aao.org/salud-ocular/enfermedades/que-es-la-glaucoma",
    "https://youtu.be/dSN_yBSelWU?si=hkmtDCoSehpcaIrO"),
    ("Tipos de glaucoma",
    "Los principales tipos de glaucoma son el glaucoma de ángulo abierto y el glaucoma de ángulo cerrado, cada tipo de glaucoma es diferente. Sin embargo, la mayoría no presenta síntomas tempranos, por lo que es importante hacerse exámenes con regularidad.",
    "https://www.nei.nih.gov/espanol/aprenda-sobre-la-salud-ocular/enfermedades-y-afecciones-de-los-ojos/glaucoma/tipos-de-glaucoma",
    ""),
    ("El glaucoma de ángulo abierto es el tipo más común.",
    "El glaucoma de ángulo abierto es el tipo más común, muchas personas no presentan síntomas hasta que empiezan a perder la visión.",
    "https://www.nei.nih.gov/espanol/aprenda-sobre-la-salud-ocular/enfermedades-y-afecciones-de-los-ojos/glaucoma/tipos-de-glaucoma",
    ""),
    ("Principal causa de ceguera  en el Perú",
    "El glaucoma es la principal causa de ceguera irreversible en el Perú y el mundo. Se estimó que más del 50% de personas no conocian su condición porque no presenta síntomas, un diagnostico y tratamiendo a tiempo puede evitar la perdida total de la visión.",
    "https://www.gob.pe/institucion/minsa/noticias/346283-minsa-mas-del-50-de-los-pacientes-que-tiene-glaucoma-no-sabe-que-lo-padece",
    ""),
	("No existe cura para el glaucoma",
    "El glaucoma es una enfermedad que no tiene cura, la perdida de visión es irreversible. Sin embargo, el tratamiento temprano puede prevenir la perdida total de la visión.",
    "https://glaucoma.org/es/articles/datos-y-estadisticas-sobre-el-glaucoma",
    ""),
    ("El glaucoma puede no presentar síntomas iniciales",
    "Muchas personas con glaucoma no experimentan síntomas tempranos, la pérdida de visión suele ser gradual y puede no notarse hasta etapas avanzadas.",
    "https://glaucoma.org/es/articles/datos-y-estadisticas-sobre-el-glaucoma",
    ""),
    ("La presión intraocular elevada es un factor de riesgo significativo",
    "Aunque no todas las personas con presión intraocular alta desarrollan glaucoma, es un factor de riesgo importante para la enfermedad.",
    "https://www.mayoclinic.org/es/diseases-conditions/glaucoma/symptoms-causes/syc-20372839",
    "")
    
									