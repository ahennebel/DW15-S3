/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiants;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aurelie pc neuf
 */
public class ajoutetudiant extends HttpServlet {
    public void init(ServletConfig c) throws ServletException {
        super.init(c);
        getServletContext().setAttribute("listEtudiants", new ArrayList<Etudiant>());
                
    }
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ajoutetudiant</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Création d'un étudiant :</h1>");
            Etudiant et = new Etudiant();
            et.setNom(request.getParameter("nom"));
            et.setPrenom(request.getParameter("prenom"));
            et.setAge(Integer.parseInt(request.getParameter("age")));
            ArrayList<Etudiant> listEtudiants = (ArrayList<Etudiant>)getServletContext().getAttribute("listEtudiants");
            listEtudiants.add(et);
            et.ajouterNote(Integer.parseInt(request.getParameter("note1")));
            et.ajouterNote(Integer.parseInt(request.getParameter("note2")));
            et.ajouterNote(Integer.parseInt(request.getParameter("note3")));
            out.println("Vous avez ajouté l etudiant : <br>"+et.toString());
            out.println("<br><a href=\"index.html\">Retour au menu</a>");
            out.println("<br><a href=\"ajoutetudiant.html\">Ajouter un nouvel étudiant</a>");
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
