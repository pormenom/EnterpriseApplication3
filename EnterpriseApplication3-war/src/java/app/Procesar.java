/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Button;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.SessionLocal;

/**
 *
 * @author Administrador
 */
public class Procesar extends HttpServlet {

    @EJB
    private SessionLocal session;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("txtUser");
            String texto = request.getParameter("txtTexto");
            String boton = request.getParameter("action");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Procesar</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            out.println("<form action='Procesar' method='post'>");
            if(user == null || (boton.equals("Liberar") && user.equals(session.mostrarU()))|| user.equals(""))
            out.println("Usuario: <input type='text' name='txtUser' /></br>");
            else
            out.println("Usuario: <input type='text' value="+user+" name='txtUser' /></br>");
            
            if(texto == null || !user.equals(session.mostrarU()))
            out.println("Texto: </br> <textarea name='txtTexto'>"+session.Mostrar()+"</textarea></br>");
            else 
            out.println("Texto: </br> <textarea name='txtTexto'>"+texto+"</textarea></br>");
            
            
            
            
            out.println("<input type='submit' name='action' value='Usar' /></br>");
            out.println("<input type='submit' name='action' value='Liberar' /></br>");
            out.println("<input type='submit' name='action' value='Guardar' /></br>");
            out.println("</form>");
            if(!session.userG().equals("")){
            out.println("Ultima vez modificado por: "+session.userG()+" </br>");}
            else if(boton.equals("Guardar") && user.equals(session.mostrarU())){
            out.println("Ultima vez modificado por: "+user+" </br>");}
            else{
                
            }
            
            if(user.trim().equals("")){
                out.println("<p>Tiene que ingresar un usuario</p>");
            }
            else{
            if(boton.equals("Usar")){
                if(session.Usar(user)){
                    out.println("<p>No se puede usar, alguien más lo esta usando</p>");
                }
                else{
                    out.println("<p>Ahora lo estas usando</p>");
                }
            }
                
            else if(boton.equals("Liberar")){
                if(session.Liberar(user)){
                    out.println("<p>No se puede liberar, alguien más lo esta usando</p>");
                }
                else{
                    out.println("<p>Se ha liberado el texto</p>");
                }
            }
                
            else if(boton.equals("Guardar")){
                if(session.guardar(user, texto)){
                    out.println("<p>Lo tienes que estar usando usando para guardar</p>");
                    
                    
                }
                else{
                    out.println("<p>Se guardo correctamente</p>");
                }
            }
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
