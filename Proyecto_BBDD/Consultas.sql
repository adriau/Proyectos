USE taquillavirtual;
SELECT g.Nombre,e.usuario,e.precio FROM Evento_Grada e
	INNER JOIN Grada g on g.idGrada=e.idGrada and g.idRecinto=e.idRecinto
	WHERE e.idEvento=3;
    
SELECT e.NombreEspectaculo, ev.fecha from Espectaculo e 
	INNER JOIN Evento ev on e.idEspectaculo=ev.idEspectaculo 
	WHERE estado='abierto';
    
SELECT ev.idEvento, e.NombreEspectaculo from Espectaculo e
	INNER JOIN Evento ev on ev.idEspectaculo = e.idEspectaculo
	WHERE estado='abierto';
    
SELECT l.idLocalidad FROM Evento_Grada e 
	INNER JOIN Localidad l ON l.idRecinto=e.idRecinto AND l.idGrada=e.idGrada
	WHERE e.idEvento='1' AND l.Estado='Libre' AND l.idGrada='1' AND l.idRecinto='1';
    
SELECT DISTINCT r.Nombre FROM Evento_Grada e 
	INNER JOIN Recinto r ON r.idRecinto=e.idRecinto
	WHERE e.idEvento='1';
    
