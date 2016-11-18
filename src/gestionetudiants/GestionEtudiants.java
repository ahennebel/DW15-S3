/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiants;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Aurelie pc neuf
 */
public class GestionEtudiants { /*On crée la classe qui gerera les Etudiants*/
    private int choix;    
    private ArrayList<Etudiant> listeEtud = new ArrayList<Etudiant>();
    
    public GestionEtudiants(int _choix) { /*On lui defini des parametres*/
        choix = _choix;       
    }  
    
    public void ajouterEtud(Etudiant e) {
        listeEtud.add(e);
    }
    
    public String toString(){
        String s = new String();
        s += "Vous avez complété le choix :  " + this.choix + "\n";
        s += "Liste des étudiants \n";
        for (Etudiant e:listeEtud)
            s += e + "\n";        
        return s;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int saisie = 0;
        while (saisie >-1){
            System.out.println("Veuillez choisir une fonctionnalité : ");
            saisie = sc.nextInt();
            switch (saisie)
                    {
                        case 1: 
                            GestionEtudiants ajout = new GestionEtudiants(1);
                            Scanner add = new Scanner(System.in);
                            System.out.println("Vous avez choisi d'ajouter un etudiant veuillez entrer les informations suivantes :");
                            System.out.println("Nom de l'étudiant : ");
                            String _nom = add.nextLine();
                            System.out.println("Prénom de l'étudiant : ");
                            String _prenom = add.nextLine();                            
                            System.out.println("Age de l'étudiant : ");
                            int _age = add.nextInt();                        
                            Etudiant addEtu = new Etudiant(_nom,_prenom,_age);
                            ajout.ajouterEtud(addEtu);
                            System.out.println(ajout);
                            
                            
                            /*add.nextLine();
                            System.out.println("Notes de l'étudiant - -1 pour terminer la saisie ");
                            int _notes = 0;
                            while (_notes > -1){
                                System.out.println("Veuillez saisir une note :  ");
                                _notes = add.nextInt();
                                _notes = _notes + _notes; /*Ne marche pas les notes s'additionne il faudrait les mettre dans un tableau 
                                mais je n'arrive pas à importer le tableau dans la methode main*/
                            //}
                                                       
                                                       
                        break;
                        
                        case 2:
                            Scanner b = new Scanner(System.in);
                            System.out.println("Vous avez choisi de créer une nouvelle promotion");
                            System.out.println("Veuillez saisir le nom de la promotion :");
                            String nom_promo = b.nextLine();
                            /* A faire : Envoi de la valeur dans l'objet promotion*/
                            System.out.println("Veuillez selectionner les étudiants parmis ceux disponibles : ");
                            /*A faire : Afficher le tableau de la classe generale avec un id correspondant*/
                            int choix_etud = b.nextInt();
                            /*A faire : envoyer la ligne du tableau correspondante dans le tableau de la promotion correspondante*/
                        break;
                        
                        case 3:
                            Scanner c = new Scanner(System.in);
                            System.out.print("Vous avez choisi d'afficher les érudiants d'une promotion");
                            System.out.print("Choississez la promotion à afficher : ");
                            /*A faire : methode qui affiche une promotion depuis l'objet promotion*/
                            int choix_promo = c.nextInt();
                            /*A faire : Methode qui affiche la tableau de la promotion selon la variable choix_promo*/
                        break;
                        
                        case 4:
                            Scanner d = new Scanner(System.in);
                            System.out.print("Vous avez choisi d'afficher le meilleur étudiant par promotion");
                            System.out.print("Choississez la promotion à afficher : ");
                            /*Reprendre la methode du choix de la promotion de case 3*/
                            int choix_promo_best = d.nextInt();
                            /*A faire Methode qui affiche l'étudiant ayant la meilleure moyenne dans le tableau de promotion donné*/
                        break;
                        
                        case 5:
                            Scanner e = new Scanner(System.in);
                            System.out.print("Vous avez choisi d'ajouter une note à un étudiant");
                            System.out.print("Entrer le nom de l'étudiant :");
                            String nom_etudiant = e.nextLine();
                            System.out.print("Entrez la note à attribuer à " + nom_etudiant + " : ");
                            /* A faire : Methode qui ajoute à un etudiant une note avec comme index son nom*/
                        break;
                        
                        case 6:
                            Scanner f = new Scanner(System.in);
                            System.out.print("Vous avez choisi de fusionner 2 promotions :");
                            System.out.print("Voici les promotions disponibles : ");
                            /*Reprendre methode de la case 3*/
                            System.out.print("Choix de la premiere promotion : ");
                            int fusion_1 = f.nextInt();
                            f.nextLine();
                            System.out.print("Choix de la deuxieme promotion : ");
                            int fusion_2 = f.nextInt();
                            f.nextLine();
                            System.out.print("Choix du nom de la promotion : ");
                            String nom_fusion = f.nextLine();
                            /*A faire Methode qui crée une promotion en important 2 tableaux*/
                        break;                        
                       
                        case 7:
                            Scanner g = new Scanner(System.in);
                            System.out.print("Vous avez choisi de tier les étudiant d'une promotion :");
                            System.out.print("Voici les promotions disponibles : ");
                             /*Reprendre methode de la case 3*/
                            System.out.print("Choix de la promotion : ");
                            int promo_tri = g.nextInt();
                            /*A faire : methode qui affiche un tableau avec une entrée triée par moyenne decroissante*/
                        break;
                        default:
                            System.out.println("Veuillez choisir un nombre entre 1 et 9 ! ");

                    }
            sc.nextLine();
        
        }
        
    }
}
