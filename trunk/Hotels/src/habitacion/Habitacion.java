package habitacion;

public class Habitacion {
	private Long numero;
	private Long idTipoHabitacion;
	


	public Habitacion() {
	}

	public Habitacion(Long numero, Long idTipoHabitacion) {
		super();
		this.numero = numero;
		this.idTipoHabitacion = idTipoHabitacion;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	public void setIdTipoHabitacion(Long idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}
	
	
}
