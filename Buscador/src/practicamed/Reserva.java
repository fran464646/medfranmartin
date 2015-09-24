/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamed;

import java.util.Date;

public class Reserva {
    public Long id;
    public String nombre;
    public String apellido1;
    public String apellido2;
    public String email;
    public String telefono;
    public String numCuenta;
    public String observacion;
    public Date fechaRealizacion;
    public Date fechaEntrada;
    public Date fechaSalida;
    public Long idHabitacion;
    public Long idTarifa;
    public Long idHotel;

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setApellido1(String Apellido1) {
        this.apellido1 = Apellido1;
    }

    public void setApellido2(String Apellido2) {
        this.apellido2 = Apellido2;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    public void setNumCuenta(String NumCuenta) {
        this.numCuenta = NumCuenta;
    }

    public void setObservacion(String Observacion) {
        this.observacion = Observacion;
    }

    public void setFechaRealizacion(Date FechaRealizacion) {
        this.fechaRealizacion = FechaRealizacion;
    }

    public void setFechaEntrada(Date FechaEntrada) {
        this.fechaEntrada = FechaEntrada;
    }

    public void setFechaSalida(Date FechaSalida) {
        this.fechaSalida = FechaSalida;
    }

    public void setIdHabitacion(Long Id_habitacion) {
        this.idHabitacion = Id_habitacion;
    }

    public void setIdTarifa(Long Id_tarifa) {
        this.idTarifa = Id_tarifa;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public String getObservacion() {
        return observacion;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public Long getIdTarifa() {
        return idTarifa;
    }
}
