/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamed;

import java.util.ArrayList;

public class Tarifa {
    public Long id;
    public Long idTipoHabitacion;
    public Long idRegimen;
    public String nombre;
    public String descripcion;
    public Double precio;
    public ArrayList<Servicio> servicios;

    public void setIdRegimen(Long idRegimen) {
        this.idRegimen = idRegimen;
    }

    public Long getIdRegimen() {
        return idRegimen;
    }

    public void setIdTipoHabitacion(Long IdTipoHabitacion) {
        this.idTipoHabitacion = IdTipoHabitacion;
    }

    public void setServicios(ArrayList<Servicio> Servicios) {
        this.servicios = Servicios;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public void setPrecio(Double Precio) {
        this.precio = Precio;
    }


    public Long getId() {
        return id;
    }

    public Long getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }
    
    public void anadirServicio(Servicio servicio){
        this.servicios.add(servicio);
    }
    
    public void eliminarServicio(Servicio servicio){
        this.servicios.remove(servicio);
    }
}
