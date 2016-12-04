

create table USUARIO(
	idUsuario int primary AUTO_INCREMENT, 
	Nombre varchar(30), 
	TipoJug varchar(30), 
	Password varchar(30), 
	nomCompleto varchar(120), 
	saldo numeric
)

create table FICHA(
	idFicha int primary key AUTO_INCREMENT, 
	valor1 numeric(1,0), 
	valor2 numeric(1,0)
)

create table TIPOMOVIMIENTO(
	idTipoMov int primary key AUTO_INCREMENT, 
	nombreTipo varchar(30),
	idFicha int, 
	lado varchar(30), 
	monto numeric,
	FOREIGN KEY (idFicha) REFERENCES FICHA(idFicha)
)

create table PARTIDA(
	idPartida int primary key AUTO_INCREMENT,  
	jug1 int, 
	jug2 int, 
	estado varchar(30) CHECK ( estado in("En Juego","Finalizado","Sin Iniciar","Esperando Jugador")),
	apuestaInicial numeric, 
	apuestaActual numeric,
	FOREIGN KEY (jug1) REFERENCES USUARIO(idUsuario),
	FOREIGN KEY (jug2) REFERENCES USUARIO(idUsuario)
)

create table MOVIMIENTO(
	idMovimiento int primary key AUTO_INCREMENT,
	FechaHora date,
	idTipoMov int, 
	idUsuario int, 
	idMano int,
	FOREIGN KEY (idMano) REFERENCES MANO(idMano)
)

create table MANO(
	idMano int primary key AUTO_INCREMENT, 
	cantFichasj1 numeric(2,0), 
	cantFichasj2 numeric(2,0), 
	canfichasMazo numeric(2,0), 
	cantFichasJugadas numeric(2,0)
	idPartida int
	FOREIGN KEY (idPartida) REFERENCES PARTIDA(idPartida)
)




USUARIO(idUsuario, Nombre, TipoJug, Password, nomCompleto, saldo)
PARTIDA( idPartida, jug1, jug2, estado, apuestaInicial, manos, turnoActual, apuestaActual)
MANO(idMano, cantFichasj1, cantFichasj2, canfichasMazo, cantFichasJugadas)
MOVIMIENTO(idMovimiento,FechaHora ,idTipoMov, idUsuario, idMano)
FICHA(idFicha, valor1, valor2)
TIPOMOVIMIENTO(idTipoMov, idFicha, lado, monto)
