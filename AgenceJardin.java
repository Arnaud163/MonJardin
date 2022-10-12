// Classe AgenceJardin - version 1.3

import java.io.*;
import java.io.File;

/**
 * Classe représentant une agence de jardin et les méthodes qui lui
 * sont associées.
 **/


public class AgenceJardin implements ListeAp {
	private ApJardin[] tabAp;		// le tableau des appartenances des jardins
	private int capacitéCourante;	// la capacité du tableau
	private int nbAp;				// le nombre effectif de jardins
	
	//Constructeur -- au moment de créer une agence, on crée un tableau
	// de capacité initiale 10, mais qui ne contient encore aucune appartenance d'un jardin
	AgenceJardin() {
		tabAp = new ApJardin[10];
		capacitéCourante = 10;
		nbAp = 0;
	}
	
	// Méthode privée utilisée pour augmenter la capacité
	private void augmenterCapacité() {
		// Incrémenter la capacité de 10
		capacitéCourante += 10;
		// Créer un nouveau tableau plus grand que l'ancien
		ApJardin[] tab = new ApJardin[capacitéCourante];
		// Recopier les appartenances existantes dans ce nouveau tableau
		for (int i = 0 ; i < nbAp ; i++) {
			tab[i] = tabAp[i];
		}
		// C'est le nouveau tableau qui devient le tableau des appartenances
		// (l'ancien sera récupéré par le ramasse-miettes)
		tabAp = tab;
	}
	// Les méthodes de l'interface
	// Ajout d'une nouvelle appartenance
	public void ajout(ApJardin a) {
		if (nbAp == capacitéCourante) { // on a atteint la capacité max
			augmenterCapacité();
		}
		// Maintenant je suis sûr que j'ai de la place
		// Ajouter la nouvelle appartenance dans la première case vide
		// qui porte le numéro nbAp !
		tabAp[nbAp] = a;
		// On prend en note qu'il y a une appartenance de plus
		nbAp++;
	}
	// Récupérer une appartenance à partir d'un nom donné
	public ApJardin trouverAp(String nom) {
		boolean trouvé = false;	// rien trouvé pour l'instant
		int indice = 0;
		for (int i = 0 ; i < nbAp ; i++) {
			if (nom.equalsIgnoreCase(tabAp[i].nom())) {
				trouvé = true;	// j'ai trouvé
				indice = i;		// mémoriser l'indice
				break;			// plus besoin de continuer la recherche
			}
		}
		if (trouvé) {
			return tabAp[indice];
		}
		else {
			return null;	// Si rien trouvé, je rend la référence nulle
		}
	}
	// Afficher les données de toutes les appartenances
	public void afficherDonnées() {
		// Il suffit d'afficher l'état de toutes les appartenances de l'agence
		for (int i = 0 ; i < nbAp ; i++) {
			tabAp[i].afficherDonnées();
		}
	}
	// Suppression d'une appartenance
	public void supprimer(ApJardin a) {
		boolean trouvé = false; // rien trouvé pour l'instant
		int indice = 0;
		for (int i = 0 ; i < nbAp ; i++)  {
			if (tabAp[i] == a) { 	// attention comparaison de références
				trouvé = true;		// j'ai trouvé
				indice = i;			//mémoriser l'indice
				break;				// plus besoin de continuer la recherche
			}
		}
		if (trouvé) {
			// Décaler le reste du tableau vers la gauche
			// On "écrase" ainsi l'appartenance à supprimer
			for (int i = indice+1 ; i < nbAp ; i++) {
				tabAp[i-1] = tabAp[i];
			}
			// Mettre à jour le nombre d'appartenances
			nbAp--;
		}
		else {
			// Message d'erreur si on n'a rien trouvé
			System.out.println("Je n'ai pas trouvé cette appartenance");
		}
	}
	// Ecriture du tableau des comptes dans le fichier
	public void sauvegarder(File f) {
		BufferedWriter bw = Utils.openWriteFile(f);
		if (bw != null) {
			Utils.saveInt(bw,  nbAp);
			// Il nous reste maintenant à parcourir le tableau en écrivant les comptes les uns après les autres.
			for (int i = 0 ; i < nbAp ; i ++) {
				tabAp[i].save(bw);
			}
			// Il nous reste à fermer le flot d'écriture et à indiquer par un message comment l'opération s'est déroulée
			try {
				bw.close();
			}
			catch (IOException ioe) {}
			System.out.println("sauvegarde effectuée");
		}
		else {
			System.out.println("Impossible de sauvegarder");
		}
	}
	// La méthode charger est symétrique . On commence par ouvrir le fichier en lecture, et on lit la première ligne qui contient le nombre de comptes à charger
	public void charger(File f) {
		BufferedReader br = Utils.openReadFile(f);
		if (br != null) {
			nbAp = Utils.loadInt(br);
			// Il faut maintenant pour chaque appartenance sauvegardée commencer par lire le nom de 
			for (int i = 0 ; i < nbAp ; i++) {
				tabAp[i] = new ApJardin("","");
				tabAp[i].load(br);
			}
			try {
			br.close();
			}
			catch (IOException ioe) {}
			System.out.println("Jardins chargés");
		}
		else {
			System.out.println("Impossible de charger la sauvegarde");
		}
	}
}