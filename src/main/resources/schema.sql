-- usuario
create table IF NOT EXISTS usuario(
    id INT GENERATED BY DEFAULT AS IDENTITY,
    nome varchar(100) not null,
    senha varchar(100) not null,
    PRIMARY KEY(id)
);

-- produto
create table IF NOT EXISTS produto(
    id INT GENERATED BY DEFAULT AS IDENTITY,
    nome varchar(100) not null,
    quantidade INT,
    valor double,
    PRIMARY KEY(id)
);

-- vendas
create table IF NOT EXISTS vendas(
    id INT GENERATED BY DEFAULT AS IDENTITY,
    valor double,
    usuario_id INT,
    produto_id INT,
    PRIMARY KEY(id),
    CONSTRAINT fk_usuario
      FOREIGN KEY(usuario_id)
      REFERENCES usuario(id),
    CONSTRAINT fk_produto
      FOREIGN KEY(produto_id)
      REFERENCES produto(id)
);