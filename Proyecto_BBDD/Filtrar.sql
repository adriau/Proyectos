DELIMITER //
DROP PROCEDURE IF EXISTS filtrar//
CREATE PROCEDURE filtrar(IN parametro varchar(20), IN dato varchar(20))
BEGIN
    DROP TABLE IF EXISTS Resultado;
    CREATE TABLE Resultado(  
        idEvento int 
    ); 
    
    IF(parametro='Titulo') THEN
        SET @select=CONCAT("INSERT INTO Resultado SELECT DISTINCT Evento.idEvento FROM Evento NATURAL JOIN Espectaculo WHERE Espectaculo.NombreEspectaculo='",dato,"';");
    END IF;

    IF(parametro='Participante') THEN
        SET @select=CONCAT("INSERT INTO Resultado SELECT DISTINCT Evento.idEvento FROM Evento NATURAL JOIN Participantes WHERE Participantes.Participante='",dato,"';");
    END IF;
    IF(parametro='Tipo') THEN
        SET @select=CONCAT("INSERT INTO Resultado SELECT DISTINCT Evento.idEvento FROM Evento NATURAL JOIN Espectaculo WHERE Espectaculo.Tipo='",dato,"';");
    END IF;

    IF(parametro='Fecha') THEN
        SET @select=CONCAT("INSERT INTO Resultado SELECT DISTINCT Evento.idEvento FROM Evento WHERE Fecha='",dato,"';");
    END IF;

    IF(parametro='Recinto') THEN
        SET @select=CONCAT("INSERT INTO Resultado SELECT DISTINCT Evento_Grada.idEvento FROM Evento_Grada NATURAL JOIN Recinto WHERE Recinto.Nombre='",dato,"';");
    END IF;

    /*Peparamos la ejecucion del select*/
    PREPARE stmtselect FROM @select; 
    EXECUTE stmtselect;
END// 
DELIMITER ; 
