DROP DATABASE IF EXISTS TaquillaVirtual;
CREATE DATABASE TaquillaVirtual;
USE TaquillaVirtual;

CREATE TABLE Espectaculo (
    idEspectaculo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Tipo VARCHAR (10) NOT NULL,
    NombreEspectaculo VARCHAR (40) NOT NULL,
    Descripcion VARCHAR (50)
);

CREATE TABLE Participantes (
    idEspectaculo INT NOT NULL,
    Participante VARCHAR(20) NOT NULL,
    FOREIGN KEY (idEspectaculo) REFERENCES Espectaculo (idEspectaculo),
    PRIMARY KEY (idEspectaculo,Participante)
);

CREATE TABLE Evento (
    idEvento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idEspectaculo INT NOT NULL,
    Estado VARCHAR (10) NOT NULL,
    Fecha DATE NOT NULL,
    Hora TIME NOT NULL,
    TiempoCompra INT NOT NULL,
    TimePrereserva INT NOT NULL,
    TiempoAnulacion INT NOT NULL,
    FOREIGN KEY (idEspectaculo) REFERENCES Espectaculo (idEspectaculo)
);

CREATE TABLE Recinto(
    idRecinto INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR (30) NOT NULL,
    CapacidadMax INT NOT NULL
);

CREATE TABLE Grada (
    idRecinto INT NOT NULL,
    idGrada INT NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    CapacidadMax INT NOT NULL,
    PrerreservaMax INT NOT NULL,
    FOREIGN KEY (idRecinto) REFERENCES Recinto (idRecinto),
    PRIMARY KEY(idRecinto,idGrada)
);

CREATE TABLE Localidad (
    idRecinto INT NOT NULL,
    idGrada INT NOT NULL,
    idLocalidad INT NOT NULL,
    Estado VARCHAR (11) NOT NULL,
    PRIMARY KEY (idRecinto,idGrada,idLocalidad),
    CONSTRAINT fkGrada FOREIGN KEY (idRecinto,idGrada)
    REFERENCES Grada(idRecinto, idGrada) 
);

CREATE TABLE Cliente (
    DNI VARCHAR(9) PRIMARY KEY,
    Nombre VARCHAR (10) NOT NULL,
    Apellidos VARCHAR (30) NOT NULL,
    passwd VARCHAR (20) NOT NULL,
    IBAN VARCHAR (24) NOT NULL
);

CREATE TABLE Evento_Grada (
    idEvento INT NOT NULL,
    idRecinto INT NOT NULL,
    idGrada INT NOT NULL,
    Usuario VARCHAR(10) NOT NULL,
    Precio INT NOT NULL,
    Capacidad INT NOT NULL,
    PRIMARY KEY (idEvento,idRecinto,idGrada,Usuario),
    FOREIGN KEY (idEvento) REFERENCES Evento (idEvento),
    CONSTRAINT fkRecinto FOREIGN KEY (idRecinto,idGrada)
    REFERENCES Grada (idRecinto,idGrada)
);

CREATE TABLE Ventas (
    idCompra INT NOT NULL AUTO_INCREMENT,
    dniCliente VARCHAR(9) NOT NULL,
    idEvento INT NOT NULL,
    idRecinto INT NOT NULL,
    idGrada INT NOT NULL,
    idLocalidad INT NOT NULL,
    fechaCompra TIMESTAMP NOT NULL,
    comprada INT NOT NULL,
    PRIMARY KEY (idCompra,dniCliente,idEvento,idRecinto,idGrada,idLocalidad),
    FOREIGN KEY (dniCliente) REFERENCES Cliente (DNI),
    CONSTRAINT fkLocalidad FOREIGN KEY (idRecinto,idGrada,idLocalidad)
    REFERENCES Localidad (idRecinto,idGrada,idLocalidad)
);
