package reserva;

import java.util.Date;




public class Reserva {
	
	private Long id;
	private Long idHabitacion;
	private Long idTarifa;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private String telefono;
	private String numCuenta;
	private String observacion;
	private Date fechaRealizacion;
	private Date fechaEntrada;
	private Date fechaSalida;
	
	
	
	public Reserva(Long id, Long idHabitacion, Long idTarifa,
			String nombre, String apellido1, String apellido2, String email,
			String telefono, String numCuenta, String observacion,
			Date fechaRealizacion, Date fechaEntrada, Date fechaSalida) {
		super();
		this.id = id;
		this.idHabitacion = idHabitacion;
		this.idTarifa = idTarifa;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.telefono = telefono;
		this.numCuenta = numCuenta;
		this.observacion = observacion;
		this.fechaRealizacion = fechaRealizacion;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}
	
	

	public Reserva() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public Long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}



	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}



	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	
	
	public Date getFechaSalida() {
		return fechaSalida;
	}



	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
}
