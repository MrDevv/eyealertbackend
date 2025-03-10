INSERT INTO MAE_RESPUESTAS(descripcion) VALUES("Sí"), ("No"), ("Masculino"), ("Femenino");

INSERT INTO MAE_PREGUNTAS(descripcion) VALUES
	("Ingresa tu edad"),
    ("Selecciona tu genero"),
    ("¿Te han diagnoticado con presión intraocular (PIO) elevada?"),
    ("¿Tus padres (mamá y/o papá) fueron diagnosticados con glaucoma?"),
    ("¿Has sido diagnosticado con diabetes mellitus?"),
    ("¿Has sido diagnosticado con hipertesión arterial?"),
    ("¿Has sido diagnosticado con catarata?");
    
INSERT INTO TRS_PREGUNTA_DETALLE VALUES(2, 3), (2, 4),
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
    "Los principales tipos de glaucoma son el glaucoma de ángulo abierto y el glaucomaa de ángulo cerrado, cada tipo de glaucoma es diferente. Sin embargo, la mayoría no presenta síntomas tempranos, por lo que es importante hacerse exámenes con regularidad.",
    "https://www.nei.nih.gov/espanol/aprenda-sobre-la-salud-ocular/enfermedades-y-afecciones-de-los-ojos/glaucoma/tipos-de-glaucoma",
    ""),
    ("El glaucoma de ángulo abierto es el tipo más común.",
    "El glaucoma de ángulo abierto es el tipo más común, muchas personas no presentan síntomas hasta que empiezan a perder la visión.",
    "https://www.nei.nih.gov/espanol/aprenda-sobre-la-salud-ocular/enfermedades-y-afecciones-de-los-ojos/glaucoma/tipos-de-glaucoma",
    "")
									