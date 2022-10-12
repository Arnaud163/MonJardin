// Classe Jardin - version 4.3

import java.io.*;
import java.io.File;

/* Classe permettant de recenser et de modifier les nombres d'arbres présents dans
 * mon jardin
 * @ see ListeAp, ApJardin, Utils
 */

public class Jardin {
	public static void main(String[] args) {
		ListeAp monAgence = new AgenceJardin();
		File fich = new File("aps.txt");
		// On commence par charger le fichier de sauvegarde éventuel
		monAgence.charger(fich);
		
		while (true) { // boucle infinie dont on sort par un break
			String monNom = Utils.lireChaine("Donnez le nom du propriétaire du jardin (rien=exit) : ");
		if (monNom.equals("")) {
			break; // si on ne donne aucun nom on quitte la boucle
		}
		else {
			// Vérifier si le jardin existe
			ApJardin monAp = monAgence.trouverAp(monNom);
			if (monAp == null) {
				// rien trouvé, on le crée
				System.out.println("Ce jardin n'existe pas, nous allons le créer");
				String monAdresse = Utils.lireChaine("Adresse = ");
			
				// Créer le compte
				monAp = new ApJardin(monNom, monAdresse);
			
			// L'ajouter aux appartenances de l'agence
			monAgence.ajout(monAp);
			}

		String choix = 
				Utils.lireChaine("Souhaitez-vous [Supp]rimer le jardin ou"
						+ "\n" + "[A]jouter ou [E]nlever des arbres ?");
		boolean supprimer = false; // pour savoir si on a supprimé
		
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
						Utils.lireChaine("Précisez l'espèce d'arbre dont vous voulez augmenter le nombre :"
								+ "\n" + "[C]ypré, [Po]mmier, [Pr]unier, [N]oisetier, [F]iguier ?");
				if (choixarbre == "") {
					break;
				}
				char monChoixArbre = choixarbre.charAt(0);
				switch (monChoixArbre) {
				case 'C' :
				case 'c' :
					int montantc =
						Utils.lireEntier("Combien de cyprés souhaitez-vous ajouter à votre jardin ?");
					monAp.créditerc(montantc);
					monAp.créditer(montantc);
					break;
				case 'P' :
				case 'p' :
					if (choixarbre.equalsIgnoreCase("po")) {
						int montantpo =
								Utils.lireEntier("Combien de pommiers souhaitez-vous ajouter à votre jardin ?");
								monAp.créditerpo(montantpo);
								monAp.créditer(montantpo);
					}
					else if (choixarbre.equalsIgnoreCase("pr")) {
						int montantpr =
								Utils.lireEntier("Combien de pruniers souhaitez-vous ajouter à votre jardin ?");
								monAp.créditerpr(montantpr);
								monAp.créditer(montantpr);	
					}
					else {
						System.out.println("Choix invalide");
					}
					break;
				case 'N' :
				case 'n' :
					int montantn =
						Utils.lireEntier("Combien de noisetiers souhaitez-vous ajouter à votre jardin ?");
					monAp.créditern(montantn);
					monAp.créditer(montantn);
					break;
				case 'F' :
				case 'f' :
					int montantf =
						Utils.lireEntier("Combien de figuiers souhaitez-vous ajouter à votre jardin ?");
					monAp.créditerf(montantf);
					monAp.créditer(montantf);
					break;
				default :
					System.out.println("choix invalide");
				}
			}
			else if (monChoix == 'e' || monChoix == 'E') {
				String choixarbre = 
						Utils.lireChaine("Précisez l'espèce d'arbre dont vous voulez diminuer le nombre :"
								+ "\n" + "[C]ypré, [Po]mmier, [Pr]unier, [N]oisetier, [F]iguier ?");
				if (choixarbre == "") {
					break;
				}
				char monChoixArbre = choixarbre.charAt(0);
				switch (monChoixArbre) {
				case 'C' :
				case 'c' :
					int montantc =
						Utils.lireEntier("Combien de cyprés souhaitez-vous enlever de votre jardin ?");
					monAp.débiterc(montantc);
					monAp.débiter(montantc);
					break;
				case 'P' :
				case 'p' :
					if (choixarbre.equalsIgnoreCase("po")) {
						int montantpo =
								Utils.lireEntier("Combien de pommiers souhaitez-vous enlever de votre jardin ?");
								monAp.débiterpo(montantpo);
								monAp.débiter(montantpo);
					}
					else if (choixarbre.equalsIgnoreCase("pr")) {
						int montantpr =
								Utils.lireEntier("Combien de pruniers souhaitez-vous enlever de votre jardin ?");
								monAp.débiterpr(montantpr);
								monAp.débiter(montantpr);	
					}
					else {
						System.out.println("Choix invalide");
					}
					break;
				case 'N' :
				case 'n' :
					int montantn =
						Utils.lireEntier("Combien de noisetiers souhaitez-vous enlever de votre jardin ?");
					monAp.débitern(montantn);
					monAp.débiter(montantn);
					break;
				case 'F' :
				case 'f' :
					int montantf =
						Utils.lireEntier("Combien de figuiers souhaitez-vous enlever de votre jardin ?");
					monAp.débiterf(montantf);
					monAp.débiter(montantf);
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
			// Si on n'a pas supprimé, afficher les données de l'appartenance
			monAp.afficherDonnées();
		}
		else {
			// Sinon afficher l'état global de l'agence
			System.out.println("Nouvel état des jardins de l'agence");
			monAgence.afficherDonnées();
		}
		}
		}
		// Quand on sort de la boucle, afficher l'état global de l'agence
		System.out.println("***************************************************************************************");
		System.out.println("Voici le nouvel état des jardins de l'agence");
		monAgence.afficherDonnées();
		
		// Et on termine par une sauvegarde
		try {
			fich = new File("aps.txt");
				// si le fichier n'existe pas, le créer
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
