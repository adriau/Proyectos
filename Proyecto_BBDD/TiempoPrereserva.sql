delimiter //

DROP PROCEDURE IF EXISTS timerT1//
CREATE PROCEDURE timerT1()
BEGIN
    DECLARE idCompra int;
    DECLARE dniCliente VARCHAR(9);
    DECLARE idEvento int;
    DECLARE idRecinto int;
    DECLARE idGrada int;
    DECLARE idLocalidad int;
    DECLARE fechaCompra TIMESTAMP;
    DECLARE comprada INT;
    DECLARE TimePrereserva int;
    DECLARE current TIMESTAMP;
    DECLARE minute int;
    DECLARE cursorTimer CURSOR FOR SELECT Ventas.* , Evento.TimePrereserva FROM Ventas 
     INNER JOIN Evento on Ventas.idEvento = Evento.idEvento WHERE Ventas.comprada = 0;

    open cursorTimer;

    BEGIN  

        DECLARE done BOOLEAN DEFAULT FALSE;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
        bucleTimer: LOOP
            FETCH cursorTimer into idCompra, dniCliente, idEvento, idRecinto, idGrada, idLocalidad, fechaCompra, comprada, TimePrereserva;
            IF done THEN
                LEAVE bucleTimer;
            ELSE
                SET current  = now();
                SET @TimePrereserva = TimePrereserva;
                SET minute = TIMESTAMPDIFF(MINUTE, fechaCompra, current);
                SET @minute = minute;
                
                IF (minute > TimePrereserva) THEN
                    SET @borrar = concat("DELETE FROM Ventas WHERE Ventas.idEvento = ", idEvento," and Ventas.idRecinto = ", idRecinto," and Ventas.idGrada = ",idGrada," and Ventas.idLocalidad = ",idLocalidad," and Ventas.dniCliente = '",dniCliente,"' ;");
                    PREPARE stmt_borrar FROM @borrar;
                    EXECUTE stmt_borrar;
                END IF;
            END IF;
        END LOOP;
    END;
    close cursorTimer;
END//

DROP EVENT IF EXISTS eventT1//
CREATE EVENT eventT1 
	ON SCHEDULE EVERY 20 SECOND STARTS now() 
	ON COMPLETION PRESERVE
DO 
BEGIN
  CALL timerT1();
END//
delimiter ;
