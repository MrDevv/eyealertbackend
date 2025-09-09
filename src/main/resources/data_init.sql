INSERT INTO mae_roles(descripcion) VALUES("administrador"), ("usuario");

INSERT INTO mae_respuestas(descripcion) VALUES("Sí"), ("No"), ("Masculino"), ("Femenino");

INSERT INTO mae_usuarios(nombres, apellidos, email, password, rol_id) values("Miguel Angel", "Vega Perez", "miguelvegap10@gmail.com", "$2a$10$VPSUYzkb8NIhMSaXcPVsQec88rj0drU8L/AH2Ho09PkVSyzt6LNYC", 1);

INSERT INTO config_cuestionario(dias_espera) VALUES(7);

INSERT INTO mae_preguntas(descripcion, tipo, nombre) VALUES
	("Ingresa tu edad", "abierta", "edad"),
    ("Selecciona tu genero", "cerrada", "genero"),
    ("¿Te han diagnosticado con presión intraocular (PIO) elevada?", "cerrada", "pio"),
    ("¿Tus padres (mamá o papá) fueron diagnosticados con glaucoma?", "cerrada", "historial familiar"),
    ("¿Has sido diagnosticado con diabetes mellitus?", "cerrada", "diabetes"),
    ("¿Has sido diagnosticado con hipertesión arterial?", "cerrada", "hipertension"),
    ("¿Has sido diagnosticado con catarata?", "cerrada", "catarata");
    
INSERT INTO trs_pregunta_detalle VALUES(2, 3), (2, 4),
										(3, 1), (3, 2),
                                        (4, 1), (4, 2),
                                        (5, 1), (5, 2),
                                        (6, 1), (6, 2),
                                        (7, 1), (7, 2);
							
INSERT INTO mae_datos_informativos(titulo, descripcion, fuente, fuente_multimedia) VALUES
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
    ""),
    ("Personas con alto riesgo",
    "Cualquier persona puede tener glacuoma, sin embargo algunas tienen más alto riesgo que otras. Si tiene más de 60 años, es de ascendencia africana, asiática o hispana, tiene familiares con gluacoma, tiene presión ocular alta o ha tenido una lesión ocular, está en mayor riesgo de desarrollar glaucoma.",
    "https://glaucoma.org/understanding-glaucoma",
    ""),
    ("Sintomas del glaucoma de ángulo cerrado",
    "El glaucoma de ángulo cerrado aunque es menos común, sigue siendo una emergencia médica y sus sintomas incluyen la visión borrosa, dolor severo en los ojos y cabeza, náuseas o vómitos, acompañado de dolor ocular intenso, aparición de círculos de color arco iris o perdida repentina de la vista.",
    "https://glaucoma.org/understanding-glaucoma",
    ""),
    ("Esteroides y el glaucoma",
    "El uso prolongado de esteroides, incluyendo gotas oftálmologicas que hagan uso de estos, puede aumentar la presión intraocular y elevar el riesgo de desarrollar glaucoma inducido por esteroides.",
    "https://glaucoma.org/es/articles/esteroides-y-glaucoma-cual-es-la-conexión",
    ""),
    ("Glaucoma de tensión normal",
    "Existe una forma llamada glaucoma de tensión normal, donde el daño al nervio óptico ocurre a pesar de tener una presión intraocular dentro de los rangos normales. Lo que significa que no todas las personas con glaucoma han aumentado la presión ocular.",
    "https://glaucoma.org/es/articles/glaucoma-de-tension-normal-preguntas-y-respuestas",
    ""),
    ("El glaucoma y la presión ocular",
    "La presión intraocular elevada aumenta el riesgo de daño al nervio óptico y desarrollo de glaucoma, por lo que debe ser tratada incluso si no hay sintomas presentes.",
    "https://www.nei.nih.gov/espanol/aprenda-sobre-la-salud-ocular/enfermedades-y-afecciones-de-los-ojos/glaucoma/glaucoma-and-eye-pressure",
    ""),
    ("¿Cómo tratar el glaucoma?", "Aunque no tiene cura, el glaucoma puede ser controlado con diversos tratamientos, como con medicamentos, terapia láser o cirugía para prevenir la pérdida de visión.",
    "https://glaucoma.org/es/articles/datos-y-estadisticas-sobre-el-glaucoma",
    ""),
    ("La diabetes y su relación con el glaucoma", "La diabetes puede causar daño a los vasos sanguíneos del ojo, lo que puede aumentar la presión intraocular (PIO) del ojo, siendo un factor de riesgo en el desarrollo del glaucoma.",
    "https://icoba.es/glaucoma-y-diabetes-conexion-riesgo-y-tratamiento/",
    "https://youtu.be/EjZv9qOQVzY?si=TiG5tkYwxWPu8TsL"),
    ("Glaucoma en el mundo", "El año 2021 se estimó que el glaucoma afectó a alrededor de 80 millones de habitantes, representando un 2% de los casos de ceguera global. La enfermedad tuvo un mayor efecto en personas mayores de 40 años y de edad avanzada, debido que el riesgo de desarrollar glaucoma aumenta progresivamente con la edad.",
    "https://www.gob.pe/institucion/minsa/noticias/346283-minsa-mas-del-50-de-los-pacientes-que-tiene-glaucoma-no-sabe-que-lo-padece",
    ""),
    ("Centros oftalmlógicos", "En el Perú existen centros oftalmológicos que ofrecen servicios gratuitos mediante el Seguro Integral de Salud (SIS), donde se puede tratar el glaucoma y otras patologías del ojo. El Instituto Nacional de Oftalmología (INO) y otros hospitales del Ministerio de Salud (MINSA) como Arzobispo Loayza y Daniel Alcides Carrión. Asimismo, el Instituo Regional de Oftalmología (IRO) en Trujillo es un centro especializado donde se puede tratar la enfermedad.",
    "https://www.gob.pe/14957-solicitar-servicios-de-oftalmologia-en-establecimientos-de-salud-en-el-peru",
    "");

INSERT INTO mae_preguntas_quizz (pregunta, categoria) VALUES
('¿Qué es el glaucoma?', 'Conceptos básicos'),
('¿Qué parte del ojo se daña en el glaucoma?', 'Conceptos básicos'),
('¿El glaucoma siempre causa dolor al inicio?', 'Conceptos básicos'),
('¿El glaucoma puede llevar a ceguera si no se trata?', 'Conceptos básicos'),
('¿El glaucoma se cura completamente con tratamiento?', 'Conceptos básicos'),
('¿Qué visión se afecta primero en el glaucoma?', 'Conceptos básicos'),
('¿Qué significa presión intraocular elevada?', 'Conceptos básicos'),
('¿Todos los pacientes con presión intraocular alta desarrollan glaucoma?', 'Conceptos básicos'),
('¿Cómo se detecta el glaucoma?', 'Conceptos básicos'),
('¿El glaucoma es una enfermedad prevenible al 100%?', 'Conceptos básicos'),
('¿El daño visual causado por el glaucoma es reversible?', 'General'),
('¿Qué prueba de imagen puede ayudar en el diagnóstico del glaucoma?', 'Diagnóstico'),
('¿Qué personas deben hacerse chequeos regulares de glaucoma?', 'Prevención'),
('¿Qué estilo de vida puede ayudar a controlar el glaucoma?', 'Prevención'),
('¿El glaucoma siempre produce dolor?', 'Síntomas'),
('¿Cuál es el principal objetivo del control en pacientes con glaucoma?', 'Tratamiento'),
('¿El glaucoma puede presentarse en niños?', 'General'),
('¿Cuál es un síntoma del glaucoma de ángulo cerrado agudo?', 'Síntomas'),
('¿Qué especialidad médica trata el glaucoma?', 'General'),
('¿En qué rango se encuentra una presión intraocular normal en adultos?', 'Diagnóstico'),
('¿Qué raza tiene mayor predisposición al glaucoma?', 'Factores de riesgo'),
('¿Cuál es una medida preventiva contra el glaucoma?', 'Prevención'),
('¿Qué tipo de glaucoma aparece desde el nacimiento o en la infancia temprana?', 'Clínica');


INSERT INTO mae_respuestas_quizz (respuesta, es_correcta, pregunta_quizz_id, explicacion) VALUES
-- Pregunta 1
('Una enfermedad que daña el nervio óptico', 1, 1, 'El glaucoma es una enfermedad progresiva que daña el nervio óptico.'),
('Una inflamación de la retina', 0, 1, NULL),
('Una infección bacteriana del ojo', 0, 1, NULL),
('Un trastorno exclusivo de niños', 0, 1, NULL),

-- Pregunta 2
('El nervio óptico', 1, 2, 'El glaucoma afecta principalmente al nervio óptico.'),
('La córnea', 0, 2, NULL),
('El cristalino', 0, 2, NULL),
('El iris', 0, 2, NULL),

-- Pregunta 3
('No, puede no causar síntomas al inicio', 1, 3, 'El glaucoma de ángulo abierto puede ser asintomático en etapas tempranas.'),
('Sí, siempre produce dolor intenso', 0, 3, NULL),
('Siempre hay visión borrosa desde el inicio', 0, 3, NULL),
('Siempre hay enrojecimiento ocular', 0, 3, NULL),

-- Pregunta 4
('Sí, puede llevar a ceguera irreversible', 1, 4, 'Sin tratamiento, el glaucoma puede avanzar hasta causar ceguera.'),
('No, nunca causa pérdida total de visión', 0, 4, NULL),
('Solo afecta la visión nocturna', 0, 4, NULL),
('Es reversible con vitaminas', 0, 4, NULL),

-- Pregunta 5
('No, el tratamiento solo controla la enfermedad', 1, 5, 'El glaucoma no se cura, solo se controla para frenar su progresión.'),
('Sí, se cura con gotas', 0, 5, NULL),
('Sí, se cura con cirugía', 0, 5, NULL),
('Sí, se cura con dieta', 0, 5, NULL),

-- Pregunta 6
('La visión periférica', 1, 6, 'El glaucoma suele afectar primero la visión periférica.'),
('La visión central', 0, 6, NULL),
('La percepción de colores', 0, 6, NULL),
('La agudeza visual cercana', 0, 6, NULL),

-- Pregunta 7
('Presión dentro del ojo mayor a lo normal', 1, 7, 'La presión intraocular elevada es un factor de riesgo clave para glaucoma.'),
('Presión arterial alta', 0, 7, NULL),
('Presión en la cabeza', 0, 7, NULL),
('Presión muscular', 0, 7, NULL),

-- Pregunta 8
('No, algunos nunca lo desarrollan', 1, 8, 'La hipertensión ocular no siempre progresa a glaucoma.'),
('Sí, todos lo desarrollan', 0, 8, NULL),
('Sí, pero solo los jóvenes', 0, 8, NULL),
('Sí, pero solo las mujeres', 0, 8, NULL),

-- Pregunta 9
('Con un examen oftalmológico completo', 1, 9, 'El glaucoma se detecta con tonometría, examen de nervio óptico y campo visual.'),
('Con análisis de sangre', 0, 9, NULL),
('Con radiografías', 0, 9, NULL),
('Con prueba de reflejos', 0, 9, NULL),

-- Pregunta 10
('No, pero puede reducirse el riesgo', 1, 10, 'El glaucoma no siempre se puede prevenir, pero un diagnóstico precoz ayuda a controlarlo.'),
('Sí, con buena alimentación', 0, 10, NULL),
('Sí, con vitaminas', 0, 10, NULL),
('Sí, con ejercicio', 0, 10, NULL),

-- Pregunta 11
('No, es irreversible', 1, 11, 'El daño glaucomatoso al nervio óptico no puede revertirse.'),
('Sí, con vitaminas específicas', 0, 11, NULL),
('Sí, con cirugía láser', 0, 11, NULL),
('Sí, con trasplante de nervio óptico', 0, 11, NULL),

-- Pregunta 12
('Tomografía de coherencia óptica (OCT)', 1, 12, 'La OCT permite visualizar la capa de fibras nerviosas de la retina y detectar daño glaucomatoso.'),
('Radiografía simple', 0, 12, NULL),
('Electrocardiograma', 0, 12, NULL),
('Resonancia de rodilla', 0, 12, NULL),

-- Pregunta 13
('Personas mayores de 40 años o con antecedentes familiares', 1, 13, 'El riesgo aumenta con la edad y los antecedentes familiares.'),
('Solo niños en edad escolar', 0, 13, NULL),
('Personas que usan lentes de contacto', 0, 13, NULL),
('Todos los que tienen ojos claros', 0, 13, NULL),

-- Pregunta 14
('Hábitos saludables y seguimiento médico', 1, 14, 'El ejercicio moderado, dieta equilibrada y control médico ayudan al manejo del glaucoma.'),
('Dormir menos de 4 horas al día', 0, 14, NULL),
('Evitar completamente el consumo de agua', 0, 14, NULL),
('Uso excesivo de pantallas', 0, 14, NULL),

-- Pregunta 15
('No, en la mayoría de los casos es indoloro', 1, 15, 'El glaucoma de ángulo abierto suele ser asintomático y no causa dolor.'),
('Sí, siempre es muy doloroso', 0, 15, NULL),
('Solo produce dolor en niños', 0, 15, NULL),
('Sí, pero solo en las noches', 0, 15, NULL),

-- Pregunta 16
('Prevenir la progresión de la pérdida visual', 1, 16, 'El tratamiento busca preservar la visión funcional y evitar el avance del daño al nervio óptico.'),
('Eliminar la necesidad de gafas', 0, 16, NULL),
('Mejorar la agudeza visual más allá de lo normal', 0, 16, NULL),
('Aumentar la presión intraocular', 0, 16, NULL),

-- Pregunta 17
('Sí, en forma congénita', 1, 17, 'Aunque es raro, existe el glaucoma congénito que aparece en los primeros años de vida.'),
('No, solo en adultos mayores', 0, 17, NULL),
('No, únicamente en adolescentes', 0, 17, NULL),
('Sí, pero solo en casos de traumatismo', 0, 17, NULL),

-- Pregunta 18
('Dolor ocular intenso y visión borrosa', 1, 18, 'El glaucoma agudo de ángulo cerrado provoca dolor ocular, halos de colores y visión borrosa repentina.'),
('Cansancio ocular leve', 0, 18, NULL),
('Picazón constante', 0, 18, NULL),
('Pequeñas manchas flotantes', 0, 18, NULL),

-- Pregunta 19
('Oftalmología', 1, 19, 'El glaucoma es diagnosticado y tratado por médicos oftalmólogos.'),
('Neurología', 0, 19, NULL),
('Otorrinolaringología', 0, 19, NULL),
('Dermatología', 0, 19, NULL),

-- Pregunta 20
('Entre 10 y 21 mmHg', 1, 20, 'La presión ocular normal oscila entre 10 y 21 mmHg; valores mayores aumentan el riesgo de glaucoma.'),
('Entre 0 y 5 mmHg', 0, 20, NULL),
('Entre 30 y 50 mmHg', 0, 20, NULL),
('Más de 60 mmHg', 0, 20, NULL),

-- Pregunta 21
('Personas de ascendencia africana', 1, 21, 'Los individuos de ascendencia africana tienen mayor riesgo y suelen presentar glaucoma a edades más tempranas.'),
('Personas de piel clara', 0, 21, NULL),
('Personas asiáticas', 0, 21, NULL),
('Europeos del norte', 0, 21, NULL),

-- Pregunta 22
('Revisiones oftalmológicas periódicas', 1, 22, 'Los chequeos regulares son la mejor forma de detectar el glaucoma de forma temprana.'),
('Tomar suplementos vitamínicos diariamente', 0, 22, NULL),
('Usar gafas oscuras en interiores', 0, 22, NULL),
('Evitar leer de noche', 0, 22, NULL),

-- Pregunta 23
('Glaucoma congénito', 1, 23, 'El glaucoma congénito es raro pero grave, y se presenta en recién nacidos o niños pequeños'),
('Glaucoma juvenil', 0, 23, NULL),
('Glaucoma pseudoexfoliativo', 0, 23, NULL);



-- evento para eliminar tokens vencidos
CREATE EVENT IF NOT EXISTS eliminar_tokens_vencidos
ON SCHEDULE EVERY 1 DAY
DO
    select * FROM password_reset_token where now() >= fecha_expiracion