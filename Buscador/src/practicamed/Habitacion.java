/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamed;

import java.util.ArrayList;


public class Habitacion {
    public Integer numero;
    public ArrayList<Objeto> objetos;
    public Long idTipoHabitacion;

    public void setIdTipoHabitacion(Long idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public Long getIdTipoHabitacion() {
        return idTipoHabitacion;
    }
    
    public void anadirObjeto(Objeto objeto){
        this.objetos.add(objeto);
    }
    
    public void eliminarObjeto(Objeto objeto){
        this.objetos.add(objeto);
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setObjetos(ArrayList<Objeto> objetos) {
        this.objetos = objetos;
    }

    public Integer getNumero() {
        return numero;
    }

    public ArrayList<Objeto> getObjetos() {
        return objetos;
    }
    
}
