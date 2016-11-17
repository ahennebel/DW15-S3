/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiants;
import java.util.ArrayList;
/**
 *
 * @author Aurelie pc neuf
 */
public class Promotion {
    private ArrayList<Etudiant> listeEtud = new ArrayList<Etudiant>();
    private int annee;
    
    public Promotion(int _annee){
        annee = _annee;
    }
    
    public void ajouterEtud(Etudiant e) {
        listeEtud.add(e);
    }
    private double moyenne(){
        double somme = 0;
        if (listeEtud.size() == 0) return 0.0;
        for (Etudiant e:listeEtud)
            somme += e.moyenne();
        return somme/listeEtud.size();
    }
    public String toString(){
        String s = new String();
        s += "Promotion " + this.annee + "\n";
        for (Etudiant e:listeEtud)
            s += e + "\n";
        s += "moyenne generale " + this.moyenne();
        return s;
    }
    
    /*public static void main(String args[]) {
        Promotion p2016 = new Promotion(2016);
        Etudiant et1 = new Etudiant("Roger", "Rabbit", 22);
        Etudiant et2 = new Etudiant("Mickey", "Mouse", 30);
        Etudiant et3 = new Etudiant("Bibi", "Phoque", 20); 
        p2016.ajouterEtud(et1);
        p2016.ajouterEtud(et2);
        p2016.ajouterEtud(et3);
        et1.ajouterNote(14);
        et1.ajouterNote(11);
        et2.ajouterNote(15);
        et3.ajouterNote(15);
        et3.ajouterNote(12);
        System.out.println(p2016);
    }*/
    
}
