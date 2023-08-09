
package com.mycompany.entrenamientocanino.Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_cliente;
    private String nombre;
    private String raza;
    private String color;
    private String alergico;
    private String atencionEsp;
    private String observaciones;
    //Cuando la relacion es 1 a 1 se hace mediante un objeto, y habra que ver de que lado tiene mas sentido que vaya el objeto. Como la mascota es la clase ppal lo pondre aqui.
    @OneToOne
    private Duenio unDuenio;

    
    public Mascota() {
    }

    public Mascota(int num_cliente, String nombre, String raza, String color,
            String alergico, String atencionEsp, String observaciones,
            Duenio unDuenio) {
        this.num_cliente = num_cliente;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencionEsp = atencionEsp;
        this.observaciones = observaciones;
        this.unDuenio = unDuenio;
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencionEsp() {
        return atencionEsp;
    }

    public void setAtencionEsp(String atencionEsp) {
        this.atencionEsp = atencionEsp;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenio getUnDuenio() {
        return unDuenio;
    }

    public void setUnDuenio(Duenio unDueño) {
        this.unDuenio = unDueño;
    }
    
    
}
