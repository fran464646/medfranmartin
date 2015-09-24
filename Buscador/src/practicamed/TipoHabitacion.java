/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamed;

import java.util.ArrayList;

public class TipoHabitacion {
    public Long id;
    public String nombre;
    public Integer capacidad;
    public Integer tamaño;
    public String tipoCama;
    public ArrayList<Regimen> regimenes;
    public ArrayList<Habitacion> habitaciones;
    public ArrayList<Servicio> servicios;
    public Long idHotel;
    public Boolean oferta;

    public void setOferta(Boolean oferta) {
        this.oferta = oferta;
    }

    public Boolean getOferta() {
        return oferta;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setRegimenes(ArrayList<Regimen> Regimenes) {
        this.regimenes = Regimenes;
    }

    public void setHabitaciones(ArrayList<Habitacion> Habitaciones) {
        this.habitaciones = Habitaciones;
    }

    public void setServicios(ArrayList<Servicio> Servicios) {
        this.servicios = Servicios;
    }

    public ArrayList<Regimen> getRegimenes() {
        return regimenes;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
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

    public void setCapacidad(Integer Capacidad) {
        this.capacidad = Capacidad;
    }

    public void setTamaño(Integer Tamaño) {
        this.tamaño = Tamaño;
    }

    public void setTipoCama(String TipoCama) {
        this.tipoCama = TipoCama;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getTamaño() {
        return tamaño;
    }

    public String getTipoCama() {
        return tipoCama;
    }
    
    public void anadirServicio(Servicio servicio){
        this.servicios.add(servicio);
    }
    
    public void eliminarServicio(Servicio servicio){
        this.servicios.remove(servicio);
    }
    
    public void anadirRegimen(Regimen regimen){
        this.regimenes.add(regimen);
    }
    
    public void eliminarRegimen(Regimen regimen){
        this.regimenes.remove(regimen);
    }
    
    public void anadirHabitacion(Habitacion habitacion){
        this.habitaciones.add(habitacion);
    }
    
    public void eliminarHabitacion(Habitacion habitacion){
        this.habitaciones.remove(habitacion);
    }
    
    public void setOferta(){
        this.oferta=true;
    }
    
    public void setNoOferta(){
        this.oferta=false;
    }
}
