DROP TABLE IF EXISTS video;

CREATE TABLE video (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO
    video(titulo, descricao, url)
VALUES
    (
        'Dropei 30 e perdi',
        'Dropando 30 boneco e perdendo a partida pq só tem noob no meu time',
        'https://www.youtube.com/watch?v=1SQKgih9fY8&ab_channel=VISKFPS'
    );


DROP TABLE IF EXISTS categoria;

CREATE TABLE categoria (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    titulo VARCHAR(100) NOT NULL,
    cor VARCHAR(50) NOT NULL
);

INSERT INTO
    categoria(titulo, cor)
VALUES
    (
        'Todas categorias',
        '#00f'
    );

ALTER TABLE video
ADD categoria_id BIGINT;

ALTER TABLE video
ADD CONSTRAINT FK_categoria_id
FOREIGN KEY (categoria_id) REFERENCES categoria(id);

UPDATE video
SET categoria_id = 1;