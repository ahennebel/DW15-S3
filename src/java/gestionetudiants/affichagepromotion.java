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
public class affichagepromotion extends HttpServlet {
    String choixpromo = null; //On determine si une promotion a déjà été choisie plus loin
    public void init(ServletConfig c) throws ServletException {
        super.init(c);
        getServletContext().setAttribute("listPromtions", new ArrayList<Promotion>());
                
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
            out.println("<title>Servlet affichagepromotion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ajout de la promotion</h1>");
            
            ArrayList<Promotion> listPromtions = (ArrayList<Promotion>)getServletContext().getAttribute("listPromtions");
            ArrayList<Etudiant> listEtudiants = (ArrayList<Etudiant>)getServletContext().getAttribute("listEtudiants");
            Promotion pr = null;
            if(choixpromo == null){
                /** Ajout de la promotion - creation de la promotion **/
                pr = new Promotion();                       
                String nompromo = request.getParameter("nompromo");               
                pr.setAnnee(nompromo);     
                listPromtions.add(pr);
                out.println("Vous avez ajouté la promotion : <br>" + pr.toString() + "<br>");
                choixpromo = pr.getAnnee();
            }else{                
                for(int i=0;i<listPromtions.size();i++){
                Promotion cherchePromo = listPromtions.get(i);
                    if ((cherchePromo.getAnnee()).equals(choixpromo)){                  

                        pr = cherchePromo;        
                    }                
                }
                out.println("promotion actuellement choisie : " + choixpromo);
            }
            
            out.println("<form method='get' action='affichagepromotion'");
            out.println("<label>Indiquez le numéro de l'étudiant à ajouter : <input type='text' name='choixetudiant'/></label>");
            out.println("<input type='submit'/>");
            out.println("</form>"); 
            out.println("Voici les étudiants disponibles : <br>");
            for(int i=0;i<listEtudiants.size();i++)
			{                            
                            out.println("<p>  "+(i+1) +" -- " + listEtudiants.get(i)  +"</p>");
			}

            // Traitement lors du rechargement de la page
            int num = (Integer.parseInt(request.getParameter("choixetudiant")));
            Etudiant et = listEtudiants.get(num-1);       
            pr.ajouterEtud(et); 
            out.println("Etudiant : "+ et.toString() + "ajouté à la promotion : " + choixpromo + ": <br>");
                      
            
            
            out.println("<br><a href=\"index.html\">Retour au menu</a>");
            out.println("<br><a href=\"ajoutpromotion.html\">Créer une autre promotion</a>");            
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
