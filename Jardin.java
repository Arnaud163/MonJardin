// Classe Jardin - version 4.3

import java.io.*;
import java.io.File;

/* Classe permettant de recenser et de modifier les nombres d'arbres pr�sents dans
 * mon jardin
 * @ see ListeAp, ApJardin, Utils
 */

public class Jardin {
	public static void main(String[] args) {
		ListeAp monAgence = new AgenceJardin();
		File fich = new File("aps.txt");
		// On commence par charger le fichier de sauvegarde �ventuel
		monAgence.charger(fich);
		
		while (true) { // boucle infinie dont on sort par un break
			String monNom = Utils.lireChaine("Donnez le nom du propri�taire du jardin (rien=exit) : ");
		if (monNom.equals("")) {
			break; // si on ne donne aucun nom on quitte la boucle
		}
		else {
			// V�rifier si le jardin existe
			ApJardin monAp = monAgence.trouverAp(monNom);
			if (monAp == null) {
				// rien trouv�, on le cr�e
				System.out.println("Ce jardin n'existe pas, nous allons le cr�er");
				String monAdresse = Utils.lireChaine("Adresse = ");
			
				// Cr�er le compte
				monAp = new ApJardin(monNom, monAdresse);
			
			// L'ajouter aux appartenances de l'agence
			monAgence.ajout(monAp);
			}

		String choix = 
				Utils.lireChaine("Souhaitez-vous [Supp]rimer le jardin ou"
						+ "\n" + "[A]jouter ou [E]nlever des arbres ?");
		boolean supprimer = false; // pour savoir si on a supprim�
		
		if (choix.equals("")) {
			break; // si on ne donne aucun choix on quitte la boucle
		}
		else {
			char monChoix = choix.charAt(0);
			if (choix.equalsIgnoreCase("supp")) {
				monAgence.supprimer(monAp);
				supprimer = true;
			}
			else if (monChoix == 'a' || monChoix == 'A') {
				String choixarbre = 
						Utils.lireChaine("Pr�cisez l'esp�ce d'arbre dont vous voulez augmenter le nombre :"
								+ "\n" + "[C]ypr�, [Po]mmier, [Pr]unier, [N]oisetier, [F]iguier ?");
				if (choixarbre == "") {
					break;
				}
				char monChoixArbre = choixarbre.charAt(0);
				switch (monChoixArbre) {
				case 'C' :
				case 'c' :
					int montantc =
						Utils.lireEntier("Combien de cypr�s souhaitez-vous ajouter � votre jardin ?");
					monAp.cr�diterc(montantc);
					monAp.cr�diter(montantc);
					break;
				case 'P' :
				case 'p' :
					if (choixarbre.equalsIgnoreCase("po")) {
						int montantpo =
								Utils.lireEntier("Combien de pommiers souhaitez-vous ajouter � votre jardin ?");
								monAp.cr�diterpo(montantpo);
								monAp.cr�diter(montantpo);
					}
					else if (choixarbre.equalsIgnoreCase("pr")) {
						int montantpr =
								Utils.lireEntier("Combien de pruniers souhaitez-vous ajouter � votre jardin ?");
								monAp.cr�diterpr(montantpr);
								monAp.cr�diter(montantpr);	
					}
					else {
						System.out.println("Choix invalide");
					}
					break;
				case 'N' :
				case 'n' :
					int montantn =
						Utils.lireEntier("Combien de noisetiers souhaitez-vous ajouter � votre jardin ?");
					monAp.cr�ditern(montantn);
					monAp.cr�diter(montantn);
					break;
				case 'F' :
				case 'f' :
					int montantf =
						Utils.lireEntier("Combien de figuiers souhaitez-vous ajouter � votre jardin ?");
					monAp.cr�diterf(montantf);
					monAp.cr�diter(montantf);
					break;
				default :
					System.out.println("choix invalide");
				}
			}
			else if (monChoix == 'e' || monChoix == 'E') {
				String choixarbre = 
						Utils.lireChaine("Pr�cisez l'esp�ce d'arbre dont vous voulez diminuer le nombre :"
								+ "\n" + "[C]ypr�, [Po]mmier, [Pr]unier, [N]oisetier, [F]iguier ?");
				if (choixarbre == "") {
					break;
				}
				char monChoixArbre = choixarbre.charAt(0);
				switch (monChoixArbre) {
				case 'C' :
				case 'c' :
					int montantc =
						Utils.lireEntier("Combien de cypr�s souhaitez-vous enlever de votre jardin ?");
					monAp.d�biterc(montantc);
					monAp.d�biter(montantc);
					break;
				case 'P' :
				case 'p' :
					if (choixarbre.equalsIgnoreCase("po")) {
						int montantpo =
								Utils.lireEntier("Combien de pommiers souhaitez-vous enlever de votre jardin ?");
								monAp.d�biterpo(montantpo);
								monAp.d�biter(montantpo);
					}
					else if (choixarbre.equalsIgnoreCase("pr")) {
						int montantpr =
								Utils.lireEntier("Combien de pruniers souhaitez-vous enlever de votre jardin ?");
								monAp.d�biterpr(montantpr);
								monAp.d�biter(montantpr);	
					}
					else {
						System.out.println("Choix invalide");
					}
					break;
				case 'N' :
				case 'n' :
					int montantn =
						Utils.lireEntier("Combien de noisetiers souhaitez-vous enlever de votre jardin ?");
					monAp.d�bitern(montantn);
					monAp.d�biter(montantn);
					break;
				case 'F' :
				case 'f' :
					int montantf =
						Utils.lireEntier("Combien de figuiers souhaitez-vous enlever de votre jardin ?");
					monAp.d�biterf(montantf);
					monAp.d�biter(montantf);
					break;
				default :
					System.out.println("choix invalide");
				}				
			}
			else {
				System.out.println("Choix invalide");
			}
		}	
		if ( !supprimer) {
			// Si on n'a pas supprim�, afficher les donn�es de l'appartenance
			monAp.afficherDonn�es();
		}
		else {
			// Sinon afficher l'�tat global de l'agence
			System.out.println("Nouvel �tat des jardins de l'agence");
			monAgence.afficherDonn�es();
		}
		}
		}
		// Quand on sort de la boucle, afficher l'�tat global de l'agence
		System.out.println("***************************************************************************************");
		System.out.println("Voici le nouvel �tat des jardins de l'agence");
		monAgence.afficherDonn�es();
		
		// Et on termine par une sauvegarde
		try {
			fich = new File("aps.txt");
				// si le fichier n'existe pas, le cr�er
				if(!fich.exists()) {
				FileOutputStream fp = new FileOutputStream("aps.txt");
				fich = new File("aps.txt");
				try {
					fp.close();
				}
				catch (IOException ioe) {}
				}
				monAgence.sauvegarder(fich);
			}
				catch (IOException ioe) {}	
	}
}
