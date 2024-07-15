CREATE TABLE topicos (
	id BIGINT auto_increment NOT NULL,
	titulo varchar(100) NOT NULL unique,
	mensagem text not null,
	data datetime not null,
	status varchar(20) NOT NULL,
	curso_id bigint not null,
	autor_id bigint not null,

	primary key(id),
	CONSTRAINT fk_topicos_cursos_id FOREIGN KEY (curso_id) REFERENCES cursos(id),
	CONSTRAINT fk_topicos_usuarios_id FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);