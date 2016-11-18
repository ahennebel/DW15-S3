/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiants;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Aurelie pc neuf
 */
public class GestionEtudiants { /*On crée la classe qui gerera les Etudiants*/
    private static List<Promotion> listPromtions =new ArrayList<Promotion>();
    private static List<Etudiant> listEtudiants= new ArrayList<Etudiant>();
    

    
    	public static void nouvelEtudiant(){
		
		Etudiant et = new Etudiant();
		int note;
		Scanner add = new Scanner(System.in);
		System.out.println(" Choix 1:");
		System.out.println(" vous avez choisi d'ajoute un nouveau etudiant ,veuillez entre les informations suivantes");
		System.out.println("Nom de l etudiant ");
                et.setNom(add.nextLine());
		System.out.println("Prenom de l etudiant ");
		et.setPrenom(add.nextLine());
		System.out.println("Age de l etudiant ");
		et.setAge(add.nextInt());
		System.out.println("enter les notes (-1 pour terminer) :");
		int i=1;
		System.out.println("Note "+i);
		note=add.nextInt();
		
		while(-1!=note){
			
			et.ajouterNote(note);
			i++;
			System.out.println("Note "+i);
			note=add.nextInt();			
		}
		
		listEtudiants.add(et);
		System.out.println("Vous avez ajouté l etudaint :"+et.toString());
		add.nextLine();
		System.out.println("    ");
	}
    
        
        public static void nouvellePromotion()
	{
		Promotion pr=new Promotion();
		Scanner sc=new Scanner(System.in);
		System.out.println("vous avez choisi d'ajoute une promotion");
		System.out.println("nom de la promotion :");
                pr.setAnnee(sc.nextLine());
	 
		if(listEtudiants.size()>0){
			
			System.out.println("Selectionne parmis les etudiants disponibles:");
	    
			for(int i=0;i<listEtudiants.size();i++)
			{
				System.out.print(i+1);
				System.out.println(listEtudiants.get(i));
			}
	    
	    	System.out.println("Saisir un numéro(-1 pour terminer)");
	    	int i=1;
		    System.out.println("Ajouter l'etudiant "+i);
		    int num = sc.nextInt();
		    
			while(-1!=num)
			{
				Etudiant et=listEtudiants.get(num-1);
				pr.ajouterEtud(et);
				i++;
				System.out.println("Ajouter l'etudiant "+i);
				num = sc.nextInt();
			}
	    	
	    } 
		  listPromtions.add(pr);
		  System.out.println("vous avez ajoute "+pr.toString());
		  sc.nextLine();
	}
        
        
        
        
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int saisie = 0;
        while (saisie >-1){
            System.out.println("Menu principale ");
            System.out.println("1: creer un nouvel etudaint :");
            System.out.println("2: creer une nouvelle promotion:");
            System.out.println("3: Affiche les etudiants d'une promotion:");
            System.out.println("4: Affiche le meilleur etudaint par promotion ");
            System.out.println("5: Ajouter des notes a un etudiant");
            System.out.println("6: Fusionner deux promotions");
            System.out.println("7: trier les etudaints d'une promotion ");
            System.out.println("8:...................................");
            System.out.println("Veuillez choisir une fonctionnalité : ");
            saisie = sc.nextInt();
            switch (saisie)
                    {
                        case 1: 
                            nouvelEtudiant();
                        break;                                                 
                                                      
                                               
                        case 2:
                            nouvellePromotion();
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
