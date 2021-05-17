CREATE TABLE IF NOT EXISTS jogador (
     id serial PRIMARY KEY,
     nome  varchar(50) NOT NULL,
     posicao char(2) NOT NULL,
     time varchar(50) NOT NULL,
     mediadepontos int(5) NOT NULL,

);