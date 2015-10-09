package hotel;

import java.util.ArrayList;

import tipoHabitacion.TipoHabitacion;

public class Hotel {

	private Long id;
	private String nombre;
	private String calle;
	private String ciudad;
	private String descripcion;
	private int categoria;
	private String telefono;
	private String correoElectronico;
	private ArrayList<TipoHabitacion> tipoHabitacion;
	
	public Hotel(Long id, String nombre, String calle, String ciudad,
			String descripcion, int categoria, String telefono,
			String correoElectronico, ArrayList<TipoHabitacion> tipoHabitacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.tipoHabitacion = tipoHabitacion;
	}

	public ArrayList<TipoHabitacion> getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(ArrayList<TipoHabitacion> tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	public Hotel(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
}
