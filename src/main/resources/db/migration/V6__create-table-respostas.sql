CREATE TABLE respotas (
	id BIGINT auto_increment NOT NULL,
	topico_id bigint,
	data datetime not null,
	autor_id bigint not null,
	solucao text not null,

	primary key(id),
	CONSTRAINT fk_resposta_topicos_id FOREIGN KEY (topico_id) REFERENCES topicos(id),
	CONSTRAINT fk_resposta_usuarios_id FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);