package tarifa;

public class Tarifa {
	private Long id;
	private Long idTipoHabitacion;
	private Long idRegimen;
	private String nombre;
	private String descripcion;
	private String precio;
	
	public Tarifa(){
		
	}
	
	public Tarifa(Long id, Long idTipoHabitacion, Long idRegimen,
			String nombre, String descripcion, String precio) {
		super();
		this.id = id;
		this.idTipoHabitacion = idTipoHabitacion;
		this.idRegimen = idRegimen;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
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
	public Long getIdRegimen() {
		return idRegimen;
	}
	public void setIdRegimen(Long idRegimen) {
		this.idRegimen = idRegimen;
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
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
}
