/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamed;

import java.util.ArrayList;

public class Hotel {
    public Long id;
    public String nombre;
    public String direccion;
    public String descripcion;
    public Integer categoria;
    public String telefono;
    public String correoElectronico;
    public ArrayList<TipoHabitacion> tipoHabitaciones;
    public ArrayList<Servicio> servicios;
    public ArrayList<Reserva> reservas;
    
    public void setId(Long Id) {
        this.id = Id;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public void setCategoria(Integer Categoria) {
        this.categoria = Categoria;
    }

    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.correoElectronico = CorreoElectronico;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setServicios(ArrayList<Servicio> Servicios) {
        this.servicios = Servicios;
    }

    public void setReservas(ArrayList<Reserva> Reservas) {
        this.reservas = Reservas;
    }

    public void setTipoHabitaciones(ArrayList<TipoHabitacion> TipoHabitaciones) {
        this.tipoHabitaciones = TipoHabitaciones;
    }

    public ArrayList<TipoHabitacion> getTipoHabitaciones() {
        return tipoHabitaciones;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
    public void anadirTipoHabitacion(TipoHabitacion habitacion){
        this.tipoHabitaciones.add(habitacion);
    }
    
    public void eliminarTipoHabitacion(TipoHabitacion habitacion){
        this.tipoHabitaciones.remove(habitacion);
    }
    
    public void anadirServicio(Servicio servicio){
        this.servicios.add(servicio);
    }
    
    public void eliminarServicio(Servicio servicio){
        this.servicios.remove(servicio);
    }
    
    public void anadirReserva(Reserva reserva){
        this.reservas.add(reserva);
    }
    
    public void eliminarReserva(Reserva reserva){
        this.reservas.remove(reserva);
    }
}
