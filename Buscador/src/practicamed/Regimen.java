/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamed;

import java.util.ArrayList;

public class Regimen {
    public Long id;
    public String nombre;
    public String condiciones;
    public ArrayList<Tarifa> tarifas;

    public void setTarifas(ArrayList<Tarifa> Tarifas) {
        this.tarifas = Tarifas;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setCondiciones(String Condiciones) {
        this.condiciones = Condiciones;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCondiciones() {
        return condiciones;
    }
    
    public void anadirTarifa(Tarifa tarifa){
        this.tarifas.add(tarifa);
    }
    
    public void eliminarTarifa(Tarifa tarifa){
        this.tarifas.remove(tarifa);
    }
}
