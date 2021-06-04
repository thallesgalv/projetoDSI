CREATE TABLE IF NOT EXISTS funcionario (
	cdFuncionario serial PRIMARY KEY,
	nmFuncionario varchar(50),
	nmCargo varchar(50),
	ftFuncionario varchar(500)
);

CREATE TABLE IF NOT EXISTS projeto (
 	cdProjeto serial PRIMARY KEY,
	cdFuncionario serial,
	nmProjeto varchar(50),
	dsProjeto varchar(200)
);

CREATE TABLE IF NOT EXISTS curso (
 	cdCurso serial PRIMARY KEY,
	cdFuncionario serial,
	nmCurso varchar(50),
	dsCurso varchar(200)
);
