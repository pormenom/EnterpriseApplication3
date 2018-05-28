/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface SessionLocal {

    String Mostrar();

    Boolean guardar(String user, String texto);

    Boolean Usar(String user);

    Boolean Liberar(String user);

    String mostrarU();

    String userG();

   
    
}
