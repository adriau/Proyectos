USE taquillavirtual;

INSERT INTO Cliente VALUES ('48750849L','Pablo','Ausín Román','contraseña1','ES5401623597842104015032');
INSERT INTO Cliente VALUES ('65349827P','Tamara','Estévez Bouzada','contraseña2','ES456654851239650402325');
INSERT INTO Cliente VALUES ('68342179A','Adrián','Álvarez Castro','contraseña3','ES7821653046985214630554');
INSERT INTO Cliente VALUES ('75394658Q','Jose','Martinez Gomez','contraseña4','ES5356957862569420650005');

INSERT INTO Espectaculo VALUES (null,'Fútbol','RC Celta de Vigo - Deportivo',''); /*1*/
INSERT INTO Espectaculo VALUES (null,'Baloncesto','Golden State Warriors - Bulls','Game 7 Finales de la NBA');/*2*/
INSERT INTO Espectaculo VALUES (null,'Concierto','Alejandro Sanz','');/*3*/
INSERT INTO Espectaculo VALUES (null,'Cine','Shin Chan','Género:Comedia-Animación');/*4*/
INSERT INTO Espectaculo VALUES (null,'Teatro','Cats','');/*5*/
INSERT INTO Espectaculo VALUES (null,'Concierto','David Guetta','');/*6*/
INSERT INTO Espectaculo VALUES (null,'Fútbol','Real Madrid - Atlético De Madrid','Final UEFA Champions League');/*7*/
INSERT INTO Espectaculo VALUES (null,'Cine','Operación Camarón','Género:Comedia');/*8*/
INSERT INTO Espectaculo VALUES (null,'Tenis','Rafa-Nadal/Roger-Federer','Final del M1000 Madrid');/*9*/
INSERT INTO Espectaculo VALUES (null,'Padel','Navarro/Lebrón-Bela/Lima','Cuartos del Open de Vigo');/*10*/
INSERT INTO Espectaculo VALUES (null,'Comedia','La-Resistencia','');/*11*/

INSERT INTO Evento VALUES (null,1,'Abierto','2020-05-8','09:10:00',5,60,15);/*1*/
INSERT INTO Evento VALUES (null,2,'Abierto','2020-05-8','09:15:00',5,15,13);/*2*/
INSERT INTO Evento VALUES (null,3,'Abierto','2020-05-8','09:20:00',5,60,10);/*3*/
INSERT INTO Evento VALUES (null,4,'Abierto','2020-05-8','09:25:00',5,60,10);/*4*/
INSERT INTO Evento VALUES (null,4,'Abierto','2020-05-6','21:45:00',5,60,10);/*5*/
INSERT INTO Evento VALUES (null,5,'Abierto','2020-05-6','22:00:00',5,60,10);/*6*/
INSERT INTO Evento VALUES (null,5,'Abierto','2020-05-6','22:15:00',5,60,10);/*7*/
INSERT INTO Evento VALUES (null,6,'Abierto','2020-05-6','22:30:00',5,60,20);/*8*/
INSERT INTO Evento VALUES (null,7,'Abierto','2020-05-10','18:30:00',5,60,15);/*9*/
INSERT INTO Evento VALUES (null,8,'Abierto','2020-05-3','21:45:00',5,60,10);/*10*/
INSERT INTO Evento VALUES (null,8,'Abierto','2020-05-3','16:30:00',5,60,10);/*11*/
INSERT INTO Evento VALUES (null,9,'Abierto','2020-05-5','12:00:00',5,60,10);/*12*/
INSERT INTO Evento VALUES (null,10,'Abierto','2020-05-12','11:00:00',5,60,10);/*13*/
INSERT INTO Evento VALUES (null,11,'Abierto','2020-05-9','17:45:00',5,60,10);/*14*/

INSERT INTO Participantes VALUES (1,'RC Celta de Vigo');
INSERT INTO Participantes VALUES (1,'Deportivo');
INSERT INTO Participantes VALUES (2,'GoldenState Warriors');
INSERT INTO Participantes VALUES (2,'Chicago Bulls');
INSERT INTO Participantes VALUES (3,'Alejandro Sanz');
INSERT INTO Participantes VALUES (6,'David Guetta');
INSERT INTO Participantes VALUES (7,'Real Madrid');
INSERT INTO Participantes VALUES (7,'Atlético-de-Madrid');
INSERT INTO Participantes VALUES (9,'Rafa-Nadal');
INSERT INTO Participantes VALUES (9,'Roger-Federer');
INSERT INTO Participantes VALUES (10,'Paquito-Navarro');
INSERT INTO Participantes VALUES (10,'Juan-Lebrón');
INSERT INTO Participantes VALUES (10,'Belasteguin');
INSERT INTO Participantes VALUES (10,'Pablo-Lima');
INSERT INTO Participantes VALUES (11,'David-Broncano');

INSERT INTO Recinto VALUES (null,'Balaidos',8);/*1*/
INSERT INTO Recinto VALUES (null,'Cines-Gran-Via',500);/*2*/
INSERT INTO Recinto VALUES (null,'Wanda Metropolitano',90000);/*3*/
INSERT INTO Recinto VALUES (null,'Coliseum',2000);/*4*/
INSERT INTO Recinto VALUES (null,'Caja-Mágica-Madrid',15000);/*5*/
INSERT INTO Recinto VALUES (null,'Auditorio-Mar-De-Vigo',300);/*6*/
INSERT INTO Recinto VALUES (null,'IFEVI',500);/*7*/
INSERT INTO Recinto VALUES (null,'Teatro-Arlequín',70);/*8*/
INSERT INTO Recinto VALUES (null,'Oracle-Arena',19000);/*9*/

INSERT INTO Grada VALUES (1,1,'Tribuna Alta',3,2);
INSERT INTO Grada VALUES (1,2,'Tribuna Baja',3,2);
INSERT INTO Grada VALUES (1,3,'Gol',1,0);
INSERT INTO Grada VALUES (1,4,'Lateral',1,0);
INSERT INTO Grada VALUES (2,1,'Sala 1',100,10);
INSERT INTO Grada VALUES (2,2,'Sala 2',100,10);
INSERT INTO Grada VALUES (2,3,'Sala 3',100,10);
INSERT INTO Grada VALUES (2,4,'Sala 4',100,10);
INSERT INTO Grada VALUES (3,1,'Tribuna ',5000,5);
INSERT INTO Grada VALUES (3,2,'Rio Alto',10000,10);
INSERT INTO Grada VALUES (3,3,'Rio Bajo',10000,10);
INSERT INTO Grada VALUES (3,4,'Gol',5000,15);
INSERT INTO Grada VALUES (4,1,'Grada Superior',1500,10);
INSERT INTO Grada VALUES (4,2,'Grada Inferior',500,5);
INSERT INTO Grada VALUES (5,1,'Lateral Este',5000,5);
INSERT INTO Grada VALUES (5,2,'Lateral Oeste',5000,5);
INSERT INTO Grada VALUES (5,3,'Fondo Sur',2500,10);
INSERT INTO Grada VALUES (6,1,'Grada Principal',300,5);
INSERT INTO Grada VALUES (7,1,'Grada 1',250,5);
INSERT INTO Grada VALUES (7,2,'Grada 2',250,5);
INSERT INTO Grada VALUES (8,1,'Grada Única',70,2);
INSERT INTO Grada VALUES (9,1,'Court',500,5);
INSERT INTO Grada VALUES (9,2,'Upper Level',10500,15);

INSERT INTO Evento_Grada VALUES (1,1,1,'adulto',120,15);
INSERT INTO Evento_Grada VALUES (1,1,1,'parado',100,15);
INSERT INTO Evento_Grada VALUES (1,1,1,'jubilado',90,15);
INSERT INTO Evento_Grada VALUES (1,1,1,'infantil',80,15);
INSERT INTO Evento_Grada VALUES (1,1,1,'bebé',20,5);
INSERT INTO Evento_Grada VALUES (1,1,2,'adulto',110,15);
INSERT INTO Evento_Grada VALUES (1,1,2,'parado',95,15);
INSERT INTO Evento_Grada VALUES (1,1,2,'jubilado',80,15);
INSERT INTO Evento_Grada VALUES (1,1,2,'infantil',70,15);
INSERT INTO Evento_Grada VALUES (1,1,2,'bebé',10,5);
INSERT INTO Evento_Grada VALUES (1,1,3,'adulto',90,15);
INSERT INTO Evento_Grada VALUES (1,1,3,'parado',70,15);
INSERT INTO Evento_Grada VALUES (1,1,3,'jubilado',60,15);
INSERT INTO Evento_Grada VALUES (1,1,3,'infantil',50,15);
INSERT INTO Evento_Grada VALUES (1,1,3,'bebé',5,10);
INSERT INTO Evento_Grada VALUES (1,1,4,'adulto',85,15);
INSERT INTO Evento_Grada VALUES (1,1,4,'parado',65,15);
INSERT INTO Evento_Grada VALUES (1,1,4,'jubilado',55,15);
INSERT INTO Evento_Grada VALUES (1,1,4,'infantil',45,15);
INSERT INTO Evento_Grada VALUES (1,1,4,'bebé',5,10);

INSERT INTO Evento_Grada VALUES (2,9,1,'adulto',200,20);
INSERT INTO Evento_Grada VALUES (2,9,1,'parado',180,20);
INSERT INTO Evento_Grada VALUES (2,9,1,'jubilado',160,15);
INSERT INTO Evento_Grada VALUES (2,9,1,'infantil',150,15);
INSERT INTO Evento_Grada VALUES (2,9,1,'bebé',0,0);
INSERT INTO Evento_Grada VALUES (2,9,2,'adulto',150,25);
INSERT INTO Evento_Grada VALUES (2,9,2,'parado',130,25);
INSERT INTO Evento_Grada VALUES (2,9,2,'jubilado',90,25);
INSERT INTO Evento_Grada VALUES (2,9,2,'infantil',80,25);
INSERT INTO Evento_Grada VALUES (2,9,2,'bebé',20,10);

INSERT INTO Evento_Grada VALUES (3,4,1,'adulto',40,40);
INSERT INTO Evento_Grada VALUES (3,4,1,'parado',35,30);
INSERT INTO Evento_Grada VALUES (3,4,1,'jubilado',0,0);
INSERT INTO Evento_Grada VALUES (3,4,1,'infantil',25,20);
INSERT INTO Evento_Grada VALUES (3,4,1,'bebe',0,0);
INSERT INTO Evento_Grada VALUES (3,4,2,'adulto',30,40);
INSERT INTO Evento_Grada VALUES (3,4,2,'parado',25,35);
INSERT INTO Evento_Grada VALUES (3,4,2,'jubilado',0,0);
INSERT INTO Evento_Grada VALUES (3,4,2,'infantil',15,25);
INSERT INTO Evento_Grada VALUES (3,4,2,'bebe',0,0);

INSERT INTO Evento_Grada VALUES (4,2,1,'adulto',10,40);
INSERT INTO Evento_Grada VALUES (4,2,1,'parado',8,40);
INSERT INTO Evento_Grada VALUES (4,2,1,'jubilado',7,20);
INSERT INTO Evento_Grada VALUES (4,2,1,'infantil',0,0);
INSERT INTO Evento_Grada VALUES (4,2,1,'bebe',0,0);

INSERT INTO Evento_Grada VALUES (5,2,3,'adulto',10,40);
INSERT INTO Evento_Grada VALUES (5,2,3,'parado',8,40);
INSERT INTO Evento_Grada VALUES (5,2,3,'jubilado',7,20);
INSERT INTO Evento_Grada VALUES (5,2,3,'infantil',0,0);
INSERT INTO Evento_Grada VALUES (5,2,3,'bebe',0,0);

INSERT INTO Evento_Grada VALUES (6,6,1,'adulto',10,25);
INSERT INTO Evento_Grada VALUES (6,6,1,'parado',8,25);
INSERT INTO Evento_Grada VALUES (6,6,1,'jubilado',7,25);
INSERT INTO Evento_Grada VALUES (6,6,1,'infantil',5,35);
INSERT INTO Evento_Grada VALUES (6,6,1,'bebe',3,35);

INSERT INTO Evento_Grada VALUES (7,8,1,'adulto',10,10);
INSERT INTO Evento_Grada VALUES (7,8,1,'parado',8,10);
INSERT INTO Evento_Grada VALUES (7,8,1,'jubilado',7,20);
INSERT INTO Evento_Grada VALUES (7,8,1,'infantil',0,20);
INSERT INTO Evento_Grada VALUES (7,8,1,'bebe',0,10);

INSERT INTO Evento_Grada VALUES (8,4,1,'adulto',100,35);
INSERT INTO Evento_Grada VALUES (8,4,1,'parado',80,35);
INSERT INTO Evento_Grada VALUES (8,4,1,'jubilado',0,0);
INSERT INTO Evento_Grada VALUES (8,4,1,'infantil',75,50);
INSERT INTO Evento_Grada VALUES (8,4,1,'bebe',0,0);
INSERT INTO Evento_Grada VALUES (8,4,2,'adulto',75,30);
INSERT INTO Evento_Grada VALUES (8,4,2,'parado',65,30);
INSERT INTO Evento_Grada VALUES (8,4,2,'jubilado',0,0);
INSERT INTO Evento_Grada VALUES (8,4,2,'infantil',40,50);
INSERT INTO Evento_Grada VALUES (8,4,2,'bebe',0,0);

INSERT INTO Evento_Grada VALUES (9,3,1,'adulto',80,15);
INSERT INTO Evento_Grada VALUES (9,3,1,'parado',70,15);
INSERT INTO Evento_Grada VALUES (9,3,1,'jubilado',60,15);
INSERT INTO Evento_Grada VALUES (9,3,1,'infantil',55,15);
INSERT INTO Evento_Grada VALUES (9,3,1,'bebé',10,5);
INSERT INTO Evento_Grada VALUES (9,3,2,'adulto',70,15);
INSERT INTO Evento_Grada VALUES (9,3,2,'parado',65,15);
INSERT INTO Evento_Grada VALUES (9,3,2,'jubilado',50,15);
INSERT INTO Evento_Grada VALUES (9,3,2,'infantil',40,15);
INSERT INTO Evento_Grada VALUES (9,3,2,'bebé',5,5);
INSERT INTO Evento_Grada VALUES (9,3,3,'adulto',60,15);
INSERT INTO Evento_Grada VALUES (9,3,3,'parado',55,15);
INSERT INTO Evento_Grada VALUES (9,3,3,'jubilado',50,15);
INSERT INTO Evento_Grada VALUES (9,3,3,'infantil',35,15);
INSERT INTO Evento_Grada VALUES (9,3,3,'bebé',5,10);
INSERT INTO Evento_Grada VALUES (9,3,4,'adulto',50,15);
INSERT INTO Evento_Grada VALUES (9,3,4,'parado',45,15);
INSERT INTO Evento_Grada VALUES (9,3,4,'jubilado',35,15);
INSERT INTO Evento_Grada VALUES (9,3,4,'infantil',25,15);
INSERT INTO Evento_Grada VALUES (9,3,4,'bebé',5,10);

INSERT INTO Evento_Grada VALUES (10,2,2,'adulto',10,20);
INSERT INTO Evento_Grada VALUES (10,2,2,'parado',8,20);
INSERT INTO Evento_Grada VALUES (10,2,2,'jubilado',7,20);
INSERT INTO Evento_Grada VALUES (10,2,2,'infantil',6,20);
INSERT INTO Evento_Grada VALUES (10,2,2,'bebe',5,20);

INSERT INTO Evento_Grada VALUES (11,2,4,'adulto',10,20);
INSERT INTO Evento_Grada VALUES (11,2,4,'parado',8,20);
INSERT INTO Evento_Grada VALUES (11,2,4,'jubilado',7,20);
INSERT INTO Evento_Grada VALUES (11,2,4,'infantil',6,20);
INSERT INTO Evento_Grada VALUES (11,2,4,'bebe',5,20);

INSERT INTO Evento_Grada VALUES (12,5,1,'adulto',100,20);
INSERT INTO Evento_Grada VALUES (12,5,1,'parado',80,20);
INSERT INTO Evento_Grada VALUES (12,5,1,'jubilado',60,15);
INSERT INTO Evento_Grada VALUES (12,5,1,'infantil',50,15);
INSERT INTO Evento_Grada VALUES (12,5,1,'bebé',0,0);
INSERT INTO Evento_Grada VALUES (12,5,2,'adulto',90,25);
INSERT INTO Evento_Grada VALUES (12,5,2,'parado',70,25);
INSERT INTO Evento_Grada VALUES (12,5,2,'jubilado',50,25);
INSERT INTO Evento_Grada VALUES (12,5,2,'infantil',30,25);
INSERT INTO Evento_Grada VALUES (12,5,2,'bebé',10,10);
INSERT INTO Evento_Grada VALUES (12,5,3,'adulto',60,25);
INSERT INTO Evento_Grada VALUES (12,5,3,'parado',50,25);
INSERT INTO Evento_Grada VALUES (12,5,3,'jubilado',30,25);
INSERT INTO Evento_Grada VALUES (12,5,3,'infantil',25,25);
INSERT INTO Evento_Grada VALUES (12,5,3,'bebé',5,10);

INSERT INTO Evento_Grada VALUES (13,7,1,'adulto',30,30);
INSERT INTO Evento_Grada VALUES (13,7,1,'parado',25,30);
INSERT INTO Evento_Grada VALUES (13,7,1,'jubilado',20,30);
INSERT INTO Evento_Grada VALUES (13,7,1,'infantil',15,30);
INSERT INTO Evento_Grada VALUES (13,7,1,'bebe',10,10);
INSERT INTO Evento_Grada VALUES (13,7,2,'adulto',30,30);
INSERT INTO Evento_Grada VALUES (13,7,2,'parado',25,30);
INSERT INTO Evento_Grada VALUES (13,7,2,'jubilado',20,30);
INSERT INTO Evento_Grada VALUES (13,7,2,'infantil',15,30);
INSERT INTO Evento_Grada VALUES (13,7,2,'bebe',10,10);

INSERT INTO Evento_Grada VALUES (14,8,1,'adulto',10,20);
INSERT INTO Evento_Grada VALUES (14,8,1,'parado',5,20);
INSERT INTO Evento_Grada VALUES (14,8,1,'jubilado',5,20);
INSERT INTO Evento_Grada VALUES (14,8,1,'infantil',0,0);
INSERT INTO Evento_Grada VALUES (14,8,1,'bebe',0,0);

/*Camp Nou*/
INSERT INTO Localidad VALUES (1,1,1,'Deteriorado');
INSERT INTO Localidad VALUES (1,1,2,'Libre');
INSERT INTO Localidad VALUES (1,1,3,'Libre');
INSERT INTO Localidad VALUES (1,1,4,'Libre');
INSERT INTO Localidad VALUES (1,1,5,'Libre');
INSERT INTO Localidad VALUES (1,1,6,'Libre');
INSERT INTO Localidad VALUES (1,1,7,'Libre');
INSERT INTO Localidad VALUES (1,1,8,'Libre');
INSERT INTO Localidad VALUES (1,1,9,'Libre');
INSERT INTO Localidad VALUES (1,1,10,'Libre');
INSERT INTO Localidad VALUES (1,1,11,'Libre');
INSERT INTO Localidad VALUES (1,1,12,'Libre');
INSERT INTO Localidad VALUES (1,1,13,'Libre');
INSERT INTO Localidad VALUES (1,1,14,'Libre');
INSERT INTO Localidad VALUES (1,1,15,'Libre');
INSERT INTO Localidad VALUES (1,1,16,'Libre');
INSERT INTO Localidad VALUES (1,1,17,'Libre');
INSERT INTO Localidad VALUES (1,1,18,'Libre');
INSERT INTO Localidad VALUES (1,1,19,'Libre');
INSERT INTO Localidad VALUES (1,1,20,'Libre');
INSERT INTO Localidad VALUES (1,2,1,'Libre');
INSERT INTO Localidad VALUES (1,2,2,'Libre');
INSERT INTO Localidad VALUES (1,2,3,'Libre');
INSERT INTO Localidad VALUES (1,2,4,'Libre');
INSERT INTO Localidad VALUES (1,2,5,'Libre');
INSERT INTO Localidad VALUES (1,2,6,'Libre');
INSERT INTO Localidad VALUES (1,2,7,'Libre');
INSERT INTO Localidad VALUES (1,2,8,'Libre');
INSERT INTO Localidad VALUES (1,2,9,'Libre');
INSERT INTO Localidad VALUES (1,2,10,'Libre');
INSERT INTO Localidad VALUES (1,2,11,'Libre');
INSERT INTO Localidad VALUES (1,2,12,'Libre');
INSERT INTO Localidad VALUES (1,2,13,'Libre');
INSERT INTO Localidad VALUES (1,2,14,'Libre');
INSERT INTO Localidad VALUES (1,2,15,'Libre');
INSERT INTO Localidad VALUES (1,2,16,'Libre');
INSERT INTO Localidad VALUES (1,2,17,'Libre');
INSERT INTO Localidad VALUES (1,2,18,'Libre');
INSERT INTO Localidad VALUES (1,2,19,'Libre');
INSERT INTO Localidad VALUES (1,2,20,'Libre');
INSERT INTO Localidad VALUES (1,3,1,'Libre');
INSERT INTO Localidad VALUES (1,3,2,'Libre');
INSERT INTO Localidad VALUES (1,3,3,'Libre');
INSERT INTO Localidad VALUES (1,3,4,'Libre');
INSERT INTO Localidad VALUES (1,3,5,'Libre');
INSERT INTO Localidad VALUES (1,3,6,'Libre');
INSERT INTO Localidad VALUES (1,3,7,'Libre');
INSERT INTO Localidad VALUES (1,3,8,'Libre');
INSERT INTO Localidad VALUES (1,3,9,'Libre');
INSERT INTO Localidad VALUES (1,3,10,'Libre');
INSERT INTO Localidad VALUES (1,3,11,'Libre');
INSERT INTO Localidad VALUES (1,3,12,'Libre');
INSERT INTO Localidad VALUES (1,3,13,'Libre');
INSERT INTO Localidad VALUES (1,3,14,'Libre');
INSERT INTO Localidad VALUES (1,3,15,'Libre');
INSERT INTO Localidad VALUES (1,3,16,'Libre');
INSERT INTO Localidad VALUES (1,3,17,'Libre');
INSERT INTO Localidad VALUES (1,3,18,'Libre');
INSERT INTO Localidad VALUES (1,3,19,'Libre');
INSERT INTO Localidad VALUES (1,3,20,'Libre');
INSERT INTO Localidad VALUES (1,4,1,'Libre');
INSERT INTO Localidad VALUES (1,4,2,'Libre');
INSERT INTO Localidad VALUES (1,4,3,'Libre');
INSERT INTO Localidad VALUES (1,4,4,'Libre');
INSERT INTO Localidad VALUES (1,4,5,'Libre');
INSERT INTO Localidad VALUES (1,4,6,'Libre');
INSERT INTO Localidad VALUES (1,4,7,'Libre');
INSERT INTO Localidad VALUES (1,4,8,'Libre');
INSERT INTO Localidad VALUES (1,4,9,'Libre');
INSERT INTO Localidad VALUES (1,4,10,'Libre');
INSERT INTO Localidad VALUES (1,4,11,'Libre');
INSERT INTO Localidad VALUES (1,4,12,'Libre');
INSERT INTO Localidad VALUES (1,4,13,'Libre');
INSERT INTO Localidad VALUES (1,4,14,'Libre');
INSERT INTO Localidad VALUES (1,4,15,'Libre');
INSERT INTO Localidad VALUES (1,4,16,'Libre');
INSERT INTO Localidad VALUES (1,4,17,'Libre');
INSERT INTO Localidad VALUES (1,4,18,'Libre');
INSERT INTO Localidad VALUES (1,4,19,'Libre');
INSERT INTO Localidad VALUES (1,4,20,'Libre');
/*Cines Gran Via*/
INSERT INTO Localidad VALUES (2,1,1,'Libre');
INSERT INTO Localidad VALUES (2,1,2,'Libre');
INSERT INTO Localidad VALUES (2,1,3,'Libre');
INSERT INTO Localidad VALUES (2,1,4,'Libre');
INSERT INTO Localidad VALUES (2,1,5,'Libre');
INSERT INTO Localidad VALUES (2,1,6,'Libre');
INSERT INTO Localidad VALUES (2,1,7,'Libre');
INSERT INTO Localidad VALUES (2,1,8,'Libre');
INSERT INTO Localidad VALUES (2,1,9,'Libre');
INSERT INTO Localidad VALUES (2,1,10,'Libre');
INSERT INTO Localidad VALUES (2,2,1,'Libre');
INSERT INTO Localidad VALUES (2,2,2,'Libre');
INSERT INTO Localidad VALUES (2,2,3,'Libre');
INSERT INTO Localidad VALUES (2,2,4,'Libre');
INSERT INTO Localidad VALUES (2,2,5,'Libre');
INSERT INTO Localidad VALUES (2,2,6,'Libre');
INSERT INTO Localidad VALUES (2,2,7,'Libre');
INSERT INTO Localidad VALUES (2,2,8,'Libre');
INSERT INTO Localidad VALUES (2,2,9,'Libre');
INSERT INTO Localidad VALUES (2,2,10,'Libre');
INSERT INTO Localidad VALUES (2,3,1,'Libre');
INSERT INTO Localidad VALUES (2,3,2,'Libre');
INSERT INTO Localidad VALUES (2,3,3,'Libre');
INSERT INTO Localidad VALUES (2,3,4,'Libre');
INSERT INTO Localidad VALUES (2,3,5,'Libre');
INSERT INTO Localidad VALUES (2,3,6,'Libre');
INSERT INTO Localidad VALUES (2,3,7,'Libre');
INSERT INTO Localidad VALUES (2,3,8,'Libre');
INSERT INTO Localidad VALUES (2,3,9,'Libre');
INSERT INTO Localidad VALUES (2,3,10,'Libre');
INSERT INTO Localidad VALUES (2,4,1,'Libre');
INSERT INTO Localidad VALUES (2,4,2,'Libre');
INSERT INTO Localidad VALUES (2,4,3,'Libre');
INSERT INTO Localidad VALUES (2,4,4,'Libre');
INSERT INTO Localidad VALUES (2,4,5,'Libre');
INSERT INTO Localidad VALUES (2,4,6,'Libre');
INSERT INTO Localidad VALUES (2,4,7,'Libre');
INSERT INTO Localidad VALUES (2,4,8,'Libre');
INSERT INTO Localidad VALUES (2,4,9,'Libre');
INSERT INTO Localidad VALUES (2,4,10,'Libre');

/*Balaidos*/
INSERT INTO Localidad VALUES (3,1,1,'Libre');
INSERT INTO Localidad VALUES (3,1,2,'Libre');
INSERT INTO Localidad VALUES (3,1,3,'Libre');
INSERT INTO Localidad VALUES (3,1,4,'Libre');
INSERT INTO Localidad VALUES (3,1,5,'Libre');
INSERT INTO Localidad VALUES (3,1,6,'Libre');
INSERT INTO Localidad VALUES (3,1,7,'Libre');
INSERT INTO Localidad VALUES (3,1,8,'Libre');
INSERT INTO Localidad VALUES (3,1,9,'Libre');
INSERT INTO Localidad VALUES (3,1,10,'Libre');
INSERT INTO Localidad VALUES (3,1,11,'Libre');
INSERT INTO Localidad VALUES (3,1,12,'Libre');
INSERT INTO Localidad VALUES (3,1,13,'Libre');
INSERT INTO Localidad VALUES (3,1,14,'Libre');
INSERT INTO Localidad VALUES (3,1,15,'Libre');
INSERT INTO Localidad VALUES (3,1,16,'Libre');
INSERT INTO Localidad VALUES (3,1,17,'Libre');
INSERT INTO Localidad VALUES (3,1,18,'Libre');
INSERT INTO Localidad VALUES (3,1,19,'Libre');
INSERT INTO Localidad VALUES (3,1,20,'Libre');
INSERT INTO Localidad VALUES (3,2,1,'Libre');
INSERT INTO Localidad VALUES (3,2,2,'Libre');
INSERT INTO Localidad VALUES (3,2,3,'Libre');
INSERT INTO Localidad VALUES (3,2,4,'Libre');
INSERT INTO Localidad VALUES (3,2,5,'Libre');
INSERT INTO Localidad VALUES (3,2,6,'Libre');
INSERT INTO Localidad VALUES (3,2,7,'Libre');
INSERT INTO Localidad VALUES (3,2,8,'Libre');
INSERT INTO Localidad VALUES (3,2,9,'Libre');
INSERT INTO Localidad VALUES (3,2,10,'Libre');
INSERT INTO Localidad VALUES (3,2,11,'Libre');
INSERT INTO Localidad VALUES (3,2,12,'Libre');
INSERT INTO Localidad VALUES (3,2,13,'Libre');
INSERT INTO Localidad VALUES (3,2,14,'Libre');
INSERT INTO Localidad VALUES (3,2,15,'Libre');
INSERT INTO Localidad VALUES (3,2,16,'Libre');
INSERT INTO Localidad VALUES (3,2,17,'Libre');
INSERT INTO Localidad VALUES (3,2,18,'Libre');
INSERT INTO Localidad VALUES (3,2,19,'Libre');
INSERT INTO Localidad VALUES (3,2,20,'Libre');
INSERT INTO Localidad VALUES (3,3,1,'Libre');
INSERT INTO Localidad VALUES (3,3,2,'Libre');
INSERT INTO Localidad VALUES (3,3,3,'Libre');
INSERT INTO Localidad VALUES (3,3,4,'Libre');
INSERT INTO Localidad VALUES (3,3,5,'Libre');
INSERT INTO Localidad VALUES (3,3,6,'Libre');
INSERT INTO Localidad VALUES (3,3,7,'Libre');
INSERT INTO Localidad VALUES (3,3,8,'Libre');
INSERT INTO Localidad VALUES (3,3,9,'Libre');
INSERT INTO Localidad VALUES (3,3,10,'Libre');
INSERT INTO Localidad VALUES (3,3,11,'Libre');
INSERT INTO Localidad VALUES (3,3,12,'Libre');
INSERT INTO Localidad VALUES (3,3,13,'Libre');
INSERT INTO Localidad VALUES (3,3,14,'Libre');
INSERT INTO Localidad VALUES (3,3,15,'Libre');
INSERT INTO Localidad VALUES (3,3,16,'Libre');
INSERT INTO Localidad VALUES (3,3,17,'Libre');
INSERT INTO Localidad VALUES (3,3,18,'Libre');
INSERT INTO Localidad VALUES (3,3,19,'Libre');
INSERT INTO Localidad VALUES (3,3,20,'Libre');
INSERT INTO Localidad VALUES (3,4,1,'Libre');
INSERT INTO Localidad VALUES (3,4,2,'Libre');
INSERT INTO Localidad VALUES (3,4,3,'Libre');
INSERT INTO Localidad VALUES (3,4,4,'Libre');
INSERT INTO Localidad VALUES (3,4,5,'Libre');
INSERT INTO Localidad VALUES (3,4,6,'Libre');
INSERT INTO Localidad VALUES (3,4,7,'Libre');
INSERT INTO Localidad VALUES (3,4,8,'Libre');
INSERT INTO Localidad VALUES (3,4,9,'Libre');
INSERT INTO Localidad VALUES (3,4,10,'Libre');
INSERT INTO Localidad VALUES (3,4,11,'Libre');
INSERT INTO Localidad VALUES (3,4,12,'Libre');
INSERT INTO Localidad VALUES (3,4,13,'Libre');
INSERT INTO Localidad VALUES (3,4,14,'Libre');
INSERT INTO Localidad VALUES (3,4,15,'Libre');
INSERT INTO Localidad VALUES (3,4,16,'Libre');
INSERT INTO Localidad VALUES (3,4,17,'Libre');
INSERT INTO Localidad VALUES (3,4,18,'Libre');
INSERT INTO Localidad VALUES (3,4,19,'Libre');
INSERT INTO Localidad VALUES (3,4,20,'Libre');
/*Coliseum*/
INSERT INTO Localidad VALUES (4,1,1,'Libre');
INSERT INTO Localidad VALUES (4,1,2,'Libre');
INSERT INTO Localidad VALUES (4,1,3,'Libre');
INSERT INTO Localidad VALUES (4,1,4,'Libre');
INSERT INTO Localidad VALUES (4,1,5,'Libre');
INSERT INTO Localidad VALUES (4,1,6,'Libre');
INSERT INTO Localidad VALUES (4,1,7,'Libre');
INSERT INTO Localidad VALUES (4,1,8,'Libre');
INSERT INTO Localidad VALUES (4,1,9,'Libre');
INSERT INTO Localidad VALUES (4,1,10,'Libre');
INSERT INTO Localidad VALUES (4,2,1,'Libre');
INSERT INTO Localidad VALUES (4,2,2,'Libre');
INSERT INTO Localidad VALUES (4,2,3,'Libre');
INSERT INTO Localidad VALUES (4,2,4,'Libre');
INSERT INTO Localidad VALUES (4,2,5,'Libre');
INSERT INTO Localidad VALUES (4,2,6,'Libre');
INSERT INTO Localidad VALUES (4,2,7,'Libre');
INSERT INTO Localidad VALUES (4,2,8,'Libre');
INSERT INTO Localidad VALUES (4,2,9,'Libre');
INSERT INTO Localidad VALUES (4,2,10,'Libre');
/*Caja Mágica*/
INSERT INTO Localidad VALUES (5,1,1,'Libre');
INSERT INTO Localidad VALUES (5,1,2,'Libre');
INSERT INTO Localidad VALUES (5,1,3,'Libre');
INSERT INTO Localidad VALUES (5,1,4,'Libre');
INSERT INTO Localidad VALUES (5,1,5,'Libre');
INSERT INTO Localidad VALUES (5,1,6,'Libre');
INSERT INTO Localidad VALUES (5,1,7,'Libre');
INSERT INTO Localidad VALUES (5,1,8,'Libre');
INSERT INTO Localidad VALUES (5,1,9,'Libre');
INSERT INTO Localidad VALUES (5,1,10,'Libre');
INSERT INTO Localidad VALUES (5,2,1,'Libre');
INSERT INTO Localidad VALUES (5,2,2,'Libre');
INSERT INTO Localidad VALUES (5,2,3,'Libre');
INSERT INTO Localidad VALUES (5,2,4,'Libre');
INSERT INTO Localidad VALUES (5,2,5,'Libre');
INSERT INTO Localidad VALUES (5,2,6,'Libre');
INSERT INTO Localidad VALUES (5,2,7,'Libre');
INSERT INTO Localidad VALUES (5,2,8,'Libre');
INSERT INTO Localidad VALUES (5,2,9,'Libre');
INSERT INTO Localidad VALUES (5,2,10,'Libre');
INSERT INTO Localidad VALUES (5,3,1,'Libre');
INSERT INTO Localidad VALUES (5,3,2,'Libre');
INSERT INTO Localidad VALUES (5,3,3,'Libre');
INSERT INTO Localidad VALUES (5,3,4,'Libre');
INSERT INTO Localidad VALUES (5,3,5,'Libre');
INSERT INTO Localidad VALUES (5,3,6,'Libre');
INSERT INTO Localidad VALUES (5,3,7,'Libre');
INSERT INTO Localidad VALUES (5,3,8,'Libre');
INSERT INTO Localidad VALUES (5,3,9,'Libre');

/*Mar de Vigo*/
INSERT INTO Localidad VALUES (6,1,1,'Libre');
INSERT INTO Localidad VALUES (6,1,2,'Libre');
INSERT INTO Localidad VALUES (6,1,3,'Libre');
INSERT INTO Localidad VALUES (6,1,4,'Libre');
INSERT INTO Localidad VALUES (6,1,5,'Libre');
INSERT INTO Localidad VALUES (6,1,6,'Libre');
INSERT INTO Localidad VALUES (6,1,7,'Libre');
INSERT INTO Localidad VALUES (6,1,8,'Libre');
INSERT INTO Localidad VALUES (6,1,9,'Libre');
INSERT INTO Localidad VALUES (6,1,10,'Libre');
/*IFEVI*/
INSERT INTO Localidad VALUES (7,1,1,'Libre');
INSERT INTO Localidad VALUES (7,1,2,'Libre');
INSERT INTO Localidad VALUES (7,1,3,'Libre');
INSERT INTO Localidad VALUES (7,1,4,'Libre');
INSERT INTO Localidad VALUES (7,1,5,'Libre');
INSERT INTO Localidad VALUES (7,1,6,'Libre');
INSERT INTO Localidad VALUES (7,1,7,'Libre');
INSERT INTO Localidad VALUES (7,1,8,'Libre');
INSERT INTO Localidad VALUES (7,1,9,'Libre');
INSERT INTO Localidad VALUES (7,1,10,'Libre');
INSERT INTO Localidad VALUES (7,2,1,'Libre');
INSERT INTO Localidad VALUES (7,2,2,'Libre');
INSERT INTO Localidad VALUES (7,2,3,'Libre');
INSERT INTO Localidad VALUES (7,2,4,'Libre');
INSERT INTO Localidad VALUES (7,2,5,'Libre');
INSERT INTO Localidad VALUES (7,2,6,'Libre');
INSERT INTO Localidad VALUES (7,2,7,'Libre');
INSERT INTO Localidad VALUES (7,2,8,'Libre');
INSERT INTO Localidad VALUES (7,2,9,'Libre');
INSERT INTO Localidad VALUES (7,2,10,'Libre');
/*Teatro Arlequín*/
INSERT INTO Localidad VALUES (8,1,1,'Libre');
INSERT INTO Localidad VALUES (8,1,2,'Libre');
INSERT INTO Localidad VALUES (8,1,3,'Libre');
INSERT INTO Localidad VALUES (8,1,4,'Libre');
INSERT INTO Localidad VALUES (8,1,5,'Libre');
INSERT INTO Localidad VALUES (8,1,6,'Libre');
INSERT INTO Localidad VALUES (8,1,7,'Libre');
INSERT INTO Localidad VALUES (8,1,8,'Libre');
INSERT INTO Localidad VALUES (8,1,9,'Libre');
INSERT INTO Localidad VALUES (8,1,10,'Libre');
/*Oracle Arena*/
INSERT INTO Localidad VALUES (9,1,1,'Libre');
INSERT INTO Localidad VALUES (9,1,2,'Libre');
INSERT INTO Localidad VALUES (9,1,3,'Libre');
INSERT INTO Localidad VALUES (9,1,4,'Libre');
INSERT INTO Localidad VALUES (9,1,5,'Libre');
INSERT INTO Localidad VALUES (9,1,6,'Libre');
INSERT INTO Localidad VALUES (9,1,7,'Libre');
INSERT INTO Localidad VALUES (9,1,8,'Libre');
INSERT INTO Localidad VALUES (9,1,9,'Libre');
INSERT INTO Localidad VALUES (9,1,10,'Libre');
INSERT INTO Localidad VALUES (9,2,1,'Libre');
INSERT INTO Localidad VALUES (9,2,2,'Libre');
INSERT INTO Localidad VALUES (9,2,3,'Libre');
INSERT INTO Localidad VALUES (9,2,4,'Libre');
INSERT INTO Localidad VALUES (9,2,5,'Libre');
INSERT INTO Localidad VALUES (9,2,6,'Libre');
INSERT INTO Localidad VALUES (9,2,7,'Libre');
INSERT INTO Localidad VALUES (9,2,8,'Libre');
INSERT INTO Localidad VALUES (9,2,9,'Libre');
INSERT INTO Localidad VALUES (9,2,10,'Libre');
