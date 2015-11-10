package regimen;

public class Regimen {
	private Long id;
	private String nombre;
	private String condiciones;
	private Long idTipoHabitacion;
	
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
	public String getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	public Long getIdTipoHabitacion() {
		return idTipoHabitacion;
	}
	public void setIdTipoHabitacion(Long idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}
	public Regimen(Long id, String nombre, String condiciones,
			Long idTipoHabitacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.condiciones = condiciones;
		this.idTipoHabitacion = idTipoHabitacion;
	}
	
	public Regimen(){
		
	}
}
