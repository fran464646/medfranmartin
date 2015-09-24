/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamed;

public class Servicio {
    public Long id;
    public String nombre;
    public String descripcion;
    public Double precio;
    public String condiciones;
    public Long idHotel;

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public void setPrecio(Double Precio) {
        this.precio = Precio;
    }

    public void setCondiciones(String Condiciones) {
        this.condiciones = Condiciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    
}
