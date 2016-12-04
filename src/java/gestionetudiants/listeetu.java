/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiants;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aurelie pc neuf
 */
public class listeetu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String choixetu = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet listeetu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ajout de notes pour l'étudiant : </h1>");
            ArrayList<Etudiant> listEtudiants = (ArrayList<Etudiant>)getServletContext().getAttribute("listEtudiants");
            Etudiant bonEtudiant = null;
            
            if(choixetu == null){
                String etudNom = request.getParameter("choixetu");
                boolean trouve = false;
                for(int i=0;i<listEtudiants.size();i++){
                    Etudiant chercheEtudiant = listEtudiants.get(i);
                    if ((chercheEtudiant.getNom()).equals(etudNom)){                    
                        trouve = true;
                        bonEtudiant = chercheEtudiant;
                        choixetu = bonEtudiant.getNom();
                    }                
                }            
                if (trouve == false){
                    out.println("Etudiant inconnu , veuillez réessayer :");
                }
                
            }else{
                for(int i=0;i<listEtudiants.size();i++){
                Etudiant chercheEtudiant = listEtudiants.get(i);
                    if ((chercheEtudiant.getNom()).equals(choixetu)){                  

                        bonEtudiant = chercheEtudiant;        
                    }                
                }
                out.println("Etudiant actuellement choisi : " + choixetu);
                           
            }
            out.println("<form method='get' action='listeetu'>");
            out.println("<input type='number' name='note' max='20'/>");
            out.println("<input type='submit'/>");
            out.println("</form>");
            
            int note = (Integer.parseInt(request.getParameter("note")));
					
			bonEtudiant.ajouterNote(note);
					
		
          
          out.println("Récapitulatif étudiant :"+bonEtudiant.toString());
            out.println("<br><a href=\"index.html\">Retour au menu</a>");
            out.println("<br><a href=\"listingetudiant\">Changer d'étudiant</a>"); 
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
