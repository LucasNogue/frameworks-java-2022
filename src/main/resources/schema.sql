CREATE TABLE carro (
   placa VARCHAR(8) PRIMARY KEY,
   marca VARCHAR(20) NOT NULL,
   modelo VARCHAR(20) NOT NULL,
   cor VARCHAR(20) NOT NULL,
   ano INT NOT NULL,
   quilometragem INT NOT NULL,
   diaria FLOAT NOT NULL
);

CREATE TABLE cliente (
    cliente_key INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf BIGINT NOT NULL,
    email VARCHAR(50) NOT NULL,
    celular BIGINT NOT NULL
);

CREATE TABLE endereco (
    endereco_key INT PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(50) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(50),
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cliente_key INT NOT NULL,
    foreign key (cliente_key) references cliente(cliente_key) on delete cascade
);

CREATE TABLE vendedor (
  vendedor_key INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cpf BIGINT NOT NULL,
  data_admissao DATE NOT NULL
);

CREATE TABLE conta_corrente (
  conta_corrente_key INT PRIMARY KEY AUTO_INCREMENT,
  banco VARCHAR(50) not null,
  agencia INT NOT NULL,
  conta_corrente INT NOT NULL,
  vendedor_key INT NOT NULL,
  foreign key (vendedor_key) references vendedor(vendedor_key) on delete cascade
);

CREATE TABLE aluguel(
    aluguel_key INT PRIMARY KEY AUTO_INCREMENT,
    dias INT not null,
    valor FLOAT not null,
    data_aluguel DATE not null,
    vendedor_key INT,
    foreign key (vendedor_key) references vendedor(vendedor_key),
    cliente_key INT not null,
    foreign key (cliente_key) references cliente(cliente_key),
    placa VARCHAR(8),
    foreign key (placa) references carro(placa)
);