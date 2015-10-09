package tipoHabitacion;

public class TipoHabitacion {
	private Long id;
	private Long idHotel;
	private String nombre;
	private Integer capacidad;
	private Integer	tamano;
	private String tipoCama;
	private Boolean oferta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public Integer getTamano() {
		return tamano;
	}
	public void setTamano(Integer tamano) {
		this.tamano = tamano;
	}
	public String getTipoCama() {
		return tipoCama;
	}
	public void setTipoCama(String tipoCama) {
		this.tipoCama = tipoCama;
	}
	public Boolean getOferta() {
		return oferta;
	}
	public void setOferta(Boolean oferta) {
		this.oferta = oferta;
	}
	public TipoHabitacion(Long id, Long idHotel, String nombre,
			Integer capacidad, Integer tamano, String tipoCama, Boolean oferta) {
		super();
		this.id = id;
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.tamano = tamano;
		this.tipoCama = tipoCama;
		this.oferta = oferta;
	}
	public TipoHabitacion(){
		
	}
}
