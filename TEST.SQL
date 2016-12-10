use Domino;

create table USUARIOS(
	idUsuario int primary key, 
	nombre varchar(30) UNIQUE, 
	tipoJug varchar(30), 
	password varchar(30), 
	nomCompleto varchar(120), 
	saldo double
);

create table PARTIDAS(
	idPartida int primary key,  
	jug1 int, 
	jug2 int, 
	estado varchar(30) CHECK (estado in("En Juego","Finalizado","Sin Iniciar","Esperando Jugador")),
	apuestaInicial double, 
	apuestaActual double,
	FOREIGN KEY (jug1) REFERENCES USUARIOS(idUsuario),
	FOREIGN KEY (jug2) REFERENCES USUARIOS(idUsuario)
);

create table MANOS(
	idMano int primary key AUTO_INCREMENT, 
	cantFichasJ1 numeric(2,0), 
	cantFichasJ2 numeric(2,0), 
	cantFichasMazo numeric(2,0), 
	cantFichasJugadas numeric(2,0),
	idPartida int,
	FOREIGN KEY (idPartida) REFERENCES PARTIDAS(idPartida)
);

create table MOVIMIENTO(
	idMovimiento int primary key AUTO_INCREMENT,
	fechaHora datetime,
	tipoMov varchar(30) check (tipoMov in("Apuesta","ColocarFicha", "RecogerFicha")), 
	idUsuario int REFERENCES USUARIOS, 
	idMano int,
	FOREIGN KEY (idMano) REFERENCES MANOS(idMano)
);

create table PARAMETRO(
	nombre varchar(30) primary key,
	valor int(50)
);


insert into USUARIOS Values (1,"juan", "Jugador", "pass", "Juan Perez", 1000),
							(2,"luis", "Jugador", "pass", "Luis Rivero", 900),
							(3,"ana", "Jugador", "pass", "Ana Rodriguez", 90),
							(4,"admin", "Admin", "pass", "Marcos Gomez", -1);
insert into parametro values("oid",0),("mid",0);						


