/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Singleton;

/**
 *
 * @author Administrador
 */
@Singleton
public class Session implements SessionLocal {

    
    String user = "";
    String texto = "";
    String user2 = "";
    @Override
    public String Mostrar() {
        return texto;
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Boolean guardar(String user, String texto) {
        Boolean chk = false;
        
        if(this.user.equals(user)){
        this.texto = texto;
        user2 = user;
        }
        else{
           chk = true;
        }
        return chk;
    }

    @Override
    public Boolean Usar(String user) {
        boolean enUso = false;
        if(this.user.equals("")){
            this.user = user;
            
        }
        else{
            enUso = true;
        }
        return enUso;
    }

    @Override
    public Boolean Liberar(String user) {
        boolean uso = false;
        if(this.user.equals(user)){
            this.user = "";
            
        }
        else{
            uso = true;
        }
        return uso;
    }

    @Override
    public String mostrarU() {
        return user;
    }

    @Override
    public String userG() {
        return user2;
    }

    
    
    
}
