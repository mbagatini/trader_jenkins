-- Tabela usuário 
CREATE TABLE usuario (
 id SERIAL NOT NULL,
 nome VARCHAR(50) NOT NULL,
 email VARCHAR(50) NOT NULL,
 senha VARCHAR(50) NOT NULL,
 cpf VARCHAR(14) NOT NULL,
PRIMARY KEY(id));
 
 -- Tabela ação
CREATE TABLE acao (
 id SERIAL NOT NULL,
 nome VARCHAR(50) NOT NULL,
 preco DECIMAL(15,2) NOT NULL,
 created_at TIMESTAMP, 
 updated_at TIMESTAMP, 
PRIMARY KEY(id));

 -- Tabela transacao
CREATE TABLE transacao (
 usuario INT NOT NULL,
 acao INT NOT NULL,
 data TIMESTAMP,
 valor DECIMAL(15,2),
 quantidade INTEGER,
 total DECIMAL(15,2),
 tipo char(1),	
 
FOREIGN KEY(usuario) REFERENCES usuario(id),
FOREIGN KEY(acao) REFERENCES acao(id));

 -- Tabela carteira
CREATE TABLE carteira (
 usuario INT NOT NULL,
 acao INT NOT NULL,
 valor DECIMAL(15,2),
 quantidade INTEGER,

PRIMARY KEY(usuario, acao),
FOREIGN KEY(usuario) REFERENCES usuario(id),
FOREIGN KEY(acao) REFERENCES acao(id));
 
