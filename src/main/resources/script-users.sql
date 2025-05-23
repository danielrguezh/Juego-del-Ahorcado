DROP TABLE IF EXISTS usuarios;

DROP INDEX IF EXISTS idx_email;

CREATE TABLE usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    name TEXT NOT NULL,
    password TEXT NOT NULL,
    puntos INTEGER DEFAULT 0,
    victorias INTEGER DEFAULT 0,
    id_nivel INTEGER NOT NULL,  
    FOREIGN KEY (id_nivel) REFERENCES niveles(id)  
);

CREATE INDEX idx_email ON usuarios (email);

INSERT INTO usuarios (user, email, name, password, id_nivel) VALUES 
    ('Usuario-1', 'email1@example.com', 'Nombre1', 'contraseña123', 1),
    ('Usuario-2', 'email2@example.com', 'Nombre2', 'abc456', 1),
    ('Usuario-3', 'email3@example.com', 'Nombre3', 'xyz789', 1);

CREATE TABLE niveles (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nivel TEXT NOT NULL
);

INSERT INTO niveles (nivel) VALUES
('facil'),
('medio'),
('dificil');

CREATE TABLE palabras (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    palabra TEXT NOT NULL,
    id_nivel INTEGER NOT NULL,
    FOREIGN KEY (id_nivel) REFERENCES niveles(id)
);

-- Insertar palabras de nivel 'facil'
INSERT INTO palabras (palabra, id_nivel) VALUES
('guerra', 1),
('perro', 1),
('pesca', 1),
('relieve', 1),
('pintura', 1),
('planta', 1),
('viento', 1),
('raton', 1),
('flore', 1);

-- Insertar palabras de nivel 'medio'
INSERT INTO palabras (palabra, id_nivel) VALUES
('murcielago', 2),
('ciudad', 2),
('camino', 2),
('repollo', 2),
('corredor', 2),
('blanco', 2),
('granja', 2),
('huerta', 2),
('parque', 2);

-- Insertar palabras de nivel 'dificil'
INSERT INTO palabras (palabra, id_nivel) VALUES
('anticonstitucionalmente', 3),
('claustrofobia', 3),
('yuxtaposicion', 3),
('antropologia', 3),
('quimioterapia', 3),
('desoxirribonucleico', 3),
('transatlantico', 3),
('electromagnetico', 3),
('inconstitucionalidad', 3),
('historiografia', 3);