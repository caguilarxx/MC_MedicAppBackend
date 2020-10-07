INSERT INTO paciente(nombres, apellidos, direccion, dni, email, telefono)
VALUES ('Carlos Ruben', 'Aguilar Rojas', 'Lima - Chorrillos', '44497116', 'caguilarxx@gmail.com', '998326064');

INSERT INTO medico(cmp, apellidos, foto_url, nombres)
VALUES ('14698', 'Chespirito', 'https://prod.media.libero.pe/660x378/libero/imagen/2020/01/10/noticia-1578678863-doctor-chapatin-pedofilia.jpg', 'Dr. Chapatin');

INSERT INTO examen(nombre,descripcion)	VALUES ('Rayos X','Con contraste');
INSERT INTO examen(nombre,descripcion)	VALUES ('Analisis de Sangre','En Ayunas');

INSERT INTO especialidad(nombre, descripcion)	VALUES ('Medicina General', 'Medicina para enfermedades comunes');
INSERT INTO especialidad(nombre, descripcion)	VALUES ('Cardiologia', 'Medicina para el sistema cardiovascular');