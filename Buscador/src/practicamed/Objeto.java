/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamed;

public class Objeto {
    public Long id;
    public String nombre;
    public Long numeroHabitacion;

    public void setNumeroHabitacion(Long numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Long getNumeroHabitacion() {
        return numeroHabitacion;
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
