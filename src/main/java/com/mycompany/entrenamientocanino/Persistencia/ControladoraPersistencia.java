
package com.mycompany.entrenamientocanino.Persistencia;

import com.mycompany.entrenamientocanino.Logica.Duenio;
import com.mycompany.entrenamientocanino.Logica.Mascota;
import com.mycompany.entrenamientocanino.Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
         duenioJpa.create(duenio);
         mascotaJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
        //Se retornara todos los campos de mascota
        return mascotaJpa.findMascotaEntities();
    }

    public void eliminarMascota(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        //como eliminamos a la mascota que esta relacionada con dueño, tmb habria que borrar al dueño de la db
        
    }

    public Mascota traerMascota(int num_cliente) {
       return mascotaJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
       return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
