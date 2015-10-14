package objeto;

public class Objeto {
	private Long id;
	private Long numeroHabitacion;
	private String nombre;
	
	public Objeto(Long id, Long numeroHabitacion, String nombre) {
		super();
		this.id = id;
		this.numeroHabitacion = numeroHabitacion;
		this.nombre = nombre;
	}
	
	public Objeto(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(Long numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
