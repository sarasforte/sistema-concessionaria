CREATE DATABASE concessionaria;
USE concessionaria;

CREATE TABLE cliente (
    cpf_cliente VARCHAR(14) NOT NULL,
    status_cliente VARCHAR(20) NOT NULL,
    telefone VARCHAR(20),
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
	PRIMARY KEY (cpf_cliente)
);

INSERT INTO cliente 
VALUES	("527.184.960-32","ATIVO","(84) 91234-5678","Tomé Henrique Silva","Rua das Acácias, 145 – Lagoa Nova – Natal/RN"),
		("145.982.367-18","INATIVO","(84) 98765-4321","Sara Alves Rocha","Av. Prudente de Morais, 3020 – Tirol – Natal/RN"),
		("672.058.134-90","BLOQUEADO","(84) 99876-5432","José Pedro Nogueira","Rua Praia de Ponta Negra, 88 – Ponta Negra – Natal/RN"),
		("391.746.850-49","PENDENTE","(84) 99123-4567","Jéssica Beatriz Costa","Travessa São Lucas, 510 – Alecrim – Natal/RN"),
		("804.219.573-66","ATIVO","(84) 99345-6789","Gustavo Matheus Pereira","Rua Antônio Basílio, 920 – Lagoa Seca – Natal/RN"),
		("111.444.777-22","ATIVO","(84) 99654-1234","Paulo Ricardo Alves","Rua Jaguarari, 300 – Candelária – Natal/RN"),
		("222.555.888-33","ATIVO","(84) 99789-4561","Renata Lima Torres","Rua Apodi, 85 – Petrópolis – Natal/RN"),
		("333.666.999-44","INATIVO","(84) 99812-3344","Marcos Vinícius Rocha","Rua Mossoró, 140 – Tirol – Natal/RN"),
		("444.777.000-55","ATIVO","(84) 99987-6655","Larissa Farias","Rua dos Caicós, 210 – Alecrim – Natal/RN"),
		("555.888.111-66","PENDENTE","(84) 99111-2233","Daniel Nogueira","Av. Alexandrino de Alencar, 500 – Lagoa Seca – Natal/RN");
        
CREATE TABLE marca (
    id_marca INT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_marca)
);

INSERT INTO marca (nome)
VALUES ('Chevrolet'); 

CREATE TABLE automovel (
    id_automovel INT AUTO_INCREMENT,
    id_marca INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    ano INT NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    cor VARCHAR(30) NOT NULL,
    status_automovel VARCHAR(20) NOT NULL,
    data_cadastro DATE NOT NULL,
    hora_cadastro TIME NOT NULL,
	PRIMARY KEY (id_automovel),
    FOREIGN KEY (id_marca) REFERENCES marca(id_marca)
);

INSERT INTO automovel (id_marca,preco,ano,modelo,status_automovel,data_cadastro,hora_cadastro,cor)
VALUES	(1,125000.00,2020,"S10","Indisponível","2026-01-10","10:00:00","Preta"),
		(1,68000.00,2021,"Onix","Disponível","2026-01-10","10:34:00","Prata"),
		(1,115000.00,2022,"Tracker","Disponível","2026-01-10","11:29:00","Branco"),
		(1,98000.00,2020,"Corolla","Disponível","2026-01-11","09:20:00","Cinza"),
		(1,72000.00,2019,"Civic","Disponível","2026-01-11","10:15:00","Preto"),
		(1,65000.00,2021,"HB20","Disponível","2026-01-12","11:40:00","Branco"),
		(1,83000.00,2022,"Virtus","Disponível","2026-01-12","14:10:00","Azul"),
		(1,55000.00,2018,"Argo","Disponível","2026-01-13","15:00:00","Vermelho"),
		(1,90000.00,2020,"Ranger","Disponível","2026-01-14","16:30:00","Prata"),
		(1,135000.00,2023,"Compass","Disponível","2026-01-15","09:50:00","Branco");

SELECT * FROM automovel;
SELECT * FROM automovel WHERE id_automovel = 11;


CREATE TABLE vendedor (
    cpf_vendedor VARCHAR(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    comissao DECIMAL(5,2) NOT NULL,
    data_cadastro DATE NOT NULL,
    hora_cadastro TIME NOT NULL,
    PRIMARY KEY (cpf_vendedor)
);

INSERT INTO vendedor 
VALUES	("123.456.789-01","João Carlos Silva","(84) 99123-4567","5","2026-01-01","08:07"),
		("987.654.321-00","Maria Fernanda Souza","(84) 98876-5432","5","2026-01-01","09:54"),
		("111.222.333-44","Carlos Eduardo Lima","(84) 98765-1111","5","2026-01-02","10:15"),
		("222.333.444-55","Ana Paula Ribeiro","(84) 91234-2222","5","2026-01-03","11:20"),
		("333.444.555-66","Rafael Costa","(84) 99876-3333","5","2026-01-04","09:40"),
		("444.555.666-77","Fernanda Melo","(84) 99111-4444","5","2026-01-05","14:30"),
		("555.666.777-88","Lucas Andrade","(84) 99222-5555","5","2026-01-06","16:10"),
		("666.777.888-99","Patrícia Gomes","(84) 99333-6666","5","2026-01-07","13:50"),
		("777.888.999-00","Bruno Henrique","(84) 99444-7777","5","2026-01-08","15:25"),
		("888.999.000-11","Juliana Azevedo","(84) 99555-8888","5","2026-01-09","10:05");
        
CREATE TABLE venda (
    id_venda INT AUTO_INCREMENT,
    cpf_cliente VARCHAR(14) NOT NULL,
    id_automovel INT,
	cpf_vendedor VARCHAR(14) NOT NULL,
    data_venda DATE NOT NULL,
    hora_venda TIME NOT NULL,
    preco_venda DECIMAL(10,2) NOT NULL,
    forma_pagamento VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_venda),
    FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf_cliente),
    FOREIGN KEY (id_automovel) REFERENCES automovel(id_automovel),
    FOREIGN KEY (cpf_vendedor) REFERENCES vendedor(cpf_vendedor)
);

INSERT INTO venda (cpf_cliente, id_automovel, cpf_vendedor, data_venda, hora_venda, preco_venda, forma_pagamento)
VALUES	("145.982.367-18",1,"123.456.789-01","2026-01-20","14:08:00",115000.00,"À vista"),
		("222.555.888-33",2,"987.654.321-00","2026-01-23","10:54:00",68000.00,"Financiamento"),
		("391.746.850-49",3,"111.222.333-44","2026-01-24","11:20:00",120000.00,"À vista"),
		("444.777.000-55",4,"222.333.444-55","2026-01-25","15:30:00",98000.00,"Cartão"),
		("527.184.960-32",5,"333.444.555-66","2026-01-26","16:40:00",72000.00,"Financiamento"),
		("111.444.777-22",6,"444.555.666-77","2026-01-27","09:10:00",65000.00,"À vista"),
		("672.058.134-90",7,"555.666.777-88","2026-01-28","13:55:00",83000.00,"Cartão"),
		("333.666.999-44",8,"666.777.888-99","2026-01-29","10:25:00",55000.00,"À vista"),
		("804.219.573-66",9,"777.888.999-00","2026-01-30","14:45:00",90000.00,"Financiamento"),
		("555.888.111-66",10,"888.999.000-11","2026-01-31","16:00:00",135000.00,"À vista");