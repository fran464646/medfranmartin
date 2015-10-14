package servicio;

public class Servicio {

	private Long id;
	private Long idTipoHabitacion;
	private Long idHotel;
	private String nombre;
	private String descripcion;
	private Double precio;
	
	public Servicio(Long id, Long idTipoHabitacion, Long idHotel,
			String nombre, String descripcion, Double precio) {
		super();
		this.id = id;
		this.idTipoHabitacion = idTipoHabitacion;
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public Servicio(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	public void setIdTipoHabitacion(Long idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
