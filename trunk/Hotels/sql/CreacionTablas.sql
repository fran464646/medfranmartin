-- Indexes for primary keys have been explicitly created.


-- Drop tables if exists --
DROP TABLE IF EXISTS Tarifa;
DROP TABLE IF EXISTS Regimen;
DROP TABLE IF EXISTS TipoHabitacion;
DROP TABLE IF EXISTS Hotel;








-- ---------- Table for validation queries from the connection pool. ----------

CREATE TABLE PingTable (foo CHAR(1));

-- ------------------------------ UserProfile ----------------------------------

CREATE TABLE Hotel (
    id BIGINT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    calle VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    categoria INT NOT NULL, 
    telefono VARCHAR(9) NOT NULL,
    correoElectronico VARCHAR(30) NOT NULL,
    enTemporada BIT NOT NULL,
    PRIMARY KEY (id));
    
CREATE TABLE TipoHabitacion(
    id BIGINT NOT NULL,
    idHotel BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL, 
    capacidad INT NOT NULL,
    tamano INT NOT NULL,
    tipoCama VARCHAR(50) NOT NULL,
    oferta BIT NOT NULL,
    CONSTRAINT TipoHabitacion_PK PRIMARY KEY (id),
    CONSTRAINT IdHotel_FK FOREIGN KEY (idHotel) REFERENCES Hotel(id)
    ); 
    
 CREATE TABLE Regimen(
    id BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    condiciones VARCHAR(50) NOT NULL,
    idTipoHabitacion BIGINT NOT NULL,
    CONSTRAINT Regimen_PK PRIMARY KEY (id),
    CONSTRAINT IdTipoHabitacion_FK FOREIGN KEY (idTipoHabitacion) REFERENCES TipoHabitacion(id)
    );
    
create table Tarifa (id BIGINT,
				idTipoHabitacion BIGINT,
				idRegimen BIGINT,
				nombre VARCHAR(30),
				descripcion VARCHAR(100),
				precio DOUBLE,
				PRIMARY KEY (id),
				FOREIGN KEY (idTipoHabitacion) 
						REFERENCES TipoHabitacion(id),
				FOREIGN KEY (idRegimen)
						REFERENCES Regimen(id));


create table Habitacion (numero BIGINT,
				idTipoHabitacion BIGINT NOT NULL,
				PRIMARY KEY (numero),
				FOREIGN KEY (idTipoHabitacion)
						REFERENCES TipoHabitacion(id));
						
create table Reserva (id BIGINT,
				idHabitacion BIGINT NOT NULL,
				idTarifa BIGINT NOT NULL,
				nombre VARCHAR(30) NOT NULL,
				apellido1 VARCHAR(30) NOT NULL,
				apellido2 VARCHAR(30) NOT NULL,
				email VARCHAR(50) NOT NULL,
				telefono VARCHAR(9) NOT NULL,
				numCuenta VARCHAR(20) NOT NULL,
				observacion VARCHAR(100),
				fechaRealizacion Date NOT NULL,
				fechaEntrada Date NOT NULL,
				fechaSalida Date NOT NULL,
				PRIMARY KEY (id),
				FOREIGN KEY (idTarifa) 
						REFERENCES Tarifa(id),
				FOREIGN KEY (idHabitacion)
						REFERENCES Habitacion(numero));
						
create table Objeto (id BIGINT,
				numeroHabitacion BIGINT NOT NULL,
				nombre VARCHAR(30) NOT NULL,
				PRIMARY KEY (id),
				FOREIGN KEY (numeroHabitacion)
						REFERENCES Habitacion(numero));


create table Servicio (id BIGINT,
				idTipoHabitacion BIGINT ,
				idHotel BIGINT ,
				nombre VARCHAR(30) NOT NULL,
				descripcion VARCHAR(30) NOT NULL,
				precio DOUBLE NOT NULL,
				PRIMARY KEY (id),
				FOREIGN KEY (idHotel)
						REFERENCES Hotel(id),
				FOREIGN KEY (idTipoHabitacion)
						REFERENCES TipoHabitacion(id));
						