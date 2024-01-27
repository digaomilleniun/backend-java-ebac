USE test_jdbc;

-- Comando para adicionar a coluna 'Qualidades' à tabela 'seller'
ALTER TABLE seller
ADD COLUMN Qualidades VARCHAR(100) NOT NULL;

-- Comando para criar a tabela department
CREATE TABLE department (
    Id int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(60) DEFAULT NULL,
    PRIMARY KEY (Id)
);

-- Comando para criar a tabela seller
CREATE TABLE seller (
    Id int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(60) NOT NULL,
    Email varchar(100) NOT NULL,
    BirthDate datetime NOT NULL,
    BaseSalary double NOT NULL,
    DepartmentId int(11) NOT NULL,
    Qualidades varchar(100) NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (DepartmentId) REFERENCES department (Id)
);

-- Comandos para inserir dados nas tabelas
INSERT INTO department (Name) VALUES 
    ('Computers'),
    ('Electronics'),
    ('Fashion'),
    ('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId, Qualidades) VALUES 
    ('Bob Brown','bob@gmail.com','1998-04-21 00:00:00',1000,1, 'É bom em eletrônica'),
    ('Maria Green','maria@gmail.com','1979-12-31 00:00:00',3500,2, 'Fala bem em público'),
    ('Alex Grey','alex@gmail.com','1988-01-15 00:00:00',2200,1, 'É um excelente administrador'),
    ('Martha Red','martha@gmail.com','1993-11-30 00:00:00',3000,4, 'Muito criativa'),
    ('Donald Blue','donald@gmail.com','2000-01-09 00:00:00',4000,3, 'Fala Japonês fluente'),
    ('Steve Vaz','Steve@gmail.com','2000-03-04 00:00:00',3000,2, 'Cientista da computação');
