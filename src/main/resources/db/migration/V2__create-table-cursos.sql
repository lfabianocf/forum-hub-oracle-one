create table cursos (
    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    categoria varchar(40) not null,

    primary key(id)
   );