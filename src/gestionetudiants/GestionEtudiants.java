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
public class GestionEtudiants { /*On crée la classe qui gérera les Etudiants*/
    private static List<Promotion> listPromtions =new ArrayList<Promotion>();
    private static List<Etudiant> listEtudiants= new ArrayList<Etudiant>();
    

    
    	public static void nouvelEtudiant(){
		
		Etudiant et = new Etudiant();
		int note;
		Scanner add = new Scanner(System.in);
		System.out.println(" Choix 1:");
		System.out.println(" vous avez choisi d'ajouter un nouveau etudiant ,veuillez entrer les informations suivantes");
		System.out.println("Nom de l etudiant ");
                et.setNom(add.nextLine());
		System.out.println("Prenom de l'etudiant ");
		et.setPrenom(add.nextLine());
		System.out.println("Age de l'etudiant ");
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
		System.out.println("Vous avez ajouté l etudiant : "+et.toString());
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
        
        public static void afficherPromotion(){
            Scanner sc=new Scanner(System.in);
            System.out.println("vous avez choisi d'afficher une promotion");

            if(listPromtions.size()>0){

                    System.out.println("Choisissez une promotion : ");

                    for(int i=0;i<listPromtions.size();i++)
                    {
                            Promotion nomPromo = listPromtions.get(i);
                            System.out.print(i+1+" " );
                            System.out.println(nomPromo.getAnnee());
                    }
            }
            int numPromo = sc.nextInt();
            Promotion bonnePromo = listPromtions.get(numPromo-1);
            System.out.println("Liste des etudiants : \n" + bonnePromo.getListEtud());           
            
        }
        
        
        public static void meilleurEtudiant(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Vous souhaitez connaitre le meilleur étudiant d'une promotion : ");

            if(listPromtions.size()>0){

                    System.out.println("Choisissez une promotion : ");

                    for(int i=0;i<listPromtions.size();i++)
                    {
                            Promotion nomPromo = listPromtions.get(i);
                            System.out.print(i+1+" " );
                            System.out.println(nomPromo.getAnnee());
                    }
            }
            int numPromo = sc.nextInt();
            Promotion bonnePromo = listPromtions.get(numPromo-1);
            bonnePromo.getListOrder(); 
            System.out.println("Le meilleur etudiant de la promotion " + bonnePromo.getAnnee() + " est :  \n " + bonnePromo.getBestEtud()  );
               
        }
        
        
        public static void triPromotion(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Vous souhaitez connaitre le meilleur étudiant d'une promotion : ");

            if(listPromtions.size()>0){

                    System.out.println("Choisissez une promotion : ");

                    for(int i=0;i<listPromtions.size();i++)
                    {
                            Promotion nomPromo = listPromtions.get(i);
                            System.out.print(i+1+" " );
                            System.out.println(nomPromo.getAnnee());
                    }
            }
            int numPromo = sc.nextInt();
            Promotion bonnePromo = listPromtions.get(numPromo-1);
            bonnePromo.getListOrder();
            System.out.println("Promotion" + bonnePromo.getAnnee() + "rangée par ordre de moyenne décroissant :  \n");
            for (Etudiant p : bonnePromo.getListEtud()) {
                System.out.println("Ordre : " + p.toString());
            }        
        }
        
        public static void ajoutNoteEtudiant(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Vous souhaitez ajouter une note à un étudiant,");
            System.out.println("Entrez son nom :");
            String etudNom = sc.nextLine();
            boolean trouve = false;
            Etudiant bonEtudiant = null;
            for(int i=0;i<listEtudiants.size();i++){
                Etudiant chercheEtudiant = listEtudiants.get(i);
                if ((chercheEtudiant.getNom()).equals(etudNom)){                    
                    trouve = true;
                    bonEtudiant = chercheEtudiant;        
                }                
            }            
            if (trouve == false){
                System.out.println("Etudiant inconnu , veuillez réessayer :");
            }else{
                System.out.println("Entrer les notes de l'etudiant (-1 pour terminer) :");
		int i=1;
		System.out.println("Note "+i);
		int note=sc.nextInt();
		
		while(-1!=note){			
			bonEtudiant.ajouterNote(note);
			i++;
			System.out.println("Note "+i);
			note=sc.nextInt();			
		}
            }
           System.out.println("Récapitulatif étudiant :"+bonEtudiant.toString());
        }
        
        
        public static void fusionPromotion(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Vous avez choisi de fusionner 2 promotions :");
            System.out.print("Voici les promotions disponibles : ");
            if(listPromtions.size()>0){
                    System.out.println("Choississez une promotion : ");
                    for(int i=0;i<listPromtions.size();i++)
                    {
                            Promotion nomPromo = listPromtions.get(i);
                            System.out.print(i+1+" " );
                            System.out.println(nomPromo.getAnnee());
                    }
            }
            System.out.print("Choix de la premiere promotion : ");
            int fusion_1 = sc.nextInt();
            Promotion promo_1 = listPromtions.get(fusion_1-1);
            sc.nextLine();
            System.out.print("Choix de la deuxieme promotion : ");
            int fusion_2 = sc.nextInt();
            Promotion promo_2 = listPromtions.get(fusion_2-1);
            sc.nextLine();
            System.out.print("Choix du nom de la promotion : ");
            String nom_fusion = sc.nextLine();
            /*A finir : fusionner 2 objet dans un nouvel objet Promotion*/
            System.out.print("Nous n'avons pas trouvé comment faire cette opération! ");
            
        }
        
        public static void mauvaisEtudiant(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Vous souhaitez connaitre le meilleur étudiant d'une promotion : ");

            if(listPromtions.size()>0){

                    System.out.println("Choississez une promotion : ");

                    for(int i=0;i<listPromtions.size();i++)
                    {
                            Promotion nomPromo = listPromtions.get(i);
                            System.out.print(i+1+" " );
                            System.out.println(nomPromo.getAnnee());
                    }
            }
            int numPromo = sc.nextInt();
            Promotion bonnePromo = listPromtions.get(numPromo-1);
            bonnePromo.getListOrder(); 
            System.out.println("Le meilleur etudiant de la promotion " + bonnePromo.getAnnee() + " est :  \n " + bonnePromo.getBadEtud()  );
               
        }
        
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int saisie = 0;
        while (saisie != -1){
            System.out.println("Menu principal ");
            System.out.println("1: Creer un nouvel etudiant :");
            System.out.println("2: Creer une nouvelle promotion:");
            System.out.println("3: Afficher les etudiants d'une promotion:");
            System.out.println("4: Afficher le meilleur etudiant par promotion ");
            System.out.println("5: Ajouter des notes a un etudiant");
            System.out.println("6: Fusionner deux promotions");
            System.out.println("7: Trier les etudiants d'une promotion ");
            System.out.println("8: Afficher le plus mauvais etudiant d'une promotion ");
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
                            afficherPromotion();
                        break;
                        
                        case 4:
                            meilleurEtudiant();
                        break;
                        
                        case 5:
                            ajoutNoteEtudiant();
                        break;
                        
                        case 6:
                            fusionPromotion();
                        break;                        
                       
                        case 7:
                            triPromotion();
                        break;
                        case 8:
                            mauvaisEtudiant();
                        break;
                        default:
                            System.out.println("Veuillez choisir un nombre entre 1 et 8 ! ");

                    }
            sc.nextLine();
        
        }
        
    }
}
