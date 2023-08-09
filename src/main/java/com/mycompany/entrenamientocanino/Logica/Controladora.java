
package com.mycompany.entrenamientocanino.Logica;

import com.mycompany.entrenamientocanino.Persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color,
            String observaciones, String alergico, String atenEsp, String nomDuenio, String celular) {
        Duenio duenio = new Duenio();
        duenio.setNombre(nomDuenio);
        duenio.setCelular(celular);
        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencionEsp(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, masco);
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.eliminarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza,
            String color, String observaciones, String nomDuenio, String celular,
            String alergico, String atenEsp) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setAlergico(alergico);
        masco.setAtencionEsp(atenEsp);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        //modifico mascota
        controlPersis.modificarMascota(masco);
        
        //seteo nuevos valores de duenio
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelular(celular);
        dueno.setNombre(nomDuenio);
        //modifico duenio:
        this.modificarDuenio(dueno);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }
    
    
}
