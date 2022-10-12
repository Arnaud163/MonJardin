// Classe AgenceJardin - version 1.3

import java.io.*;
import java.io.File;

/**
 * Classe repr�sentant une agence de jardin et les m�thodes qui lui
 * sont associ�es.
 **/


public class AgenceJardin implements ListeAp {
	private ApJardin[] tabAp;		// le tableau des appartenances des jardins
	private int capacit�Courante;	// la capacit� du tableau
	private int nbAp;				// le nombre effectif de jardins
	
	//Constructeur -- au moment de cr�er une agence, on cr�e un tableau
	// de capacit� initiale 10, mais qui ne contient encore aucune appartenance d'un jardin
	AgenceJardin() {
		tabAp = new ApJardin[10];
		capacit�Courante = 10;
		nbAp = 0;
	}
	
	// M�thode priv�e utilis�e pour augmenter la capacit�
	private void augmenterCapacit�() {
		// Incr�menter la capacit� de 10
		capacit�Courante += 10;
		// Cr�er un nouveau tableau plus grand que l'ancien
		ApJardin[] tab = new ApJardin[capacit�Courante];
		// Recopier les appartenances existantes dans ce nouveau tableau
		for (int i = 0 ; i < nbAp ; i++) {
			tab[i] = tabAp[i];
		}
		// C'est le nouveau tableau qui devient le tableau des appartenances
		// (l'ancien sera r�cup�r� par le ramasse-miettes)
		tabAp = tab;
	}
	// Les m�thodes de l'interface
	// Ajout d'une nouvelle appartenance
	public void ajout(ApJardin a) {
		if (nbAp == capacit�Courante) { // on a atteint la capacit� max
			augmenterCapacit�();
		}
		// Maintenant je suis s�r que j'ai de la place
		// Ajouter la nouvelle appartenance dans la premi�re case vide
		// qui porte le num�ro nbAp !
		tabAp[nbAp] = a;
		// On prend en note qu'il y a une appartenance de plus
		nbAp++;
	}
	// R�cup�rer une appartenance � partir d'un nom donn�
	public ApJardin trouverAp(String nom) {
		boolean trouv� = false;	// rien trouv� pour l'instant
		int indice = 0;
		for (int i = 0 ; i < nbAp ; i++) {
			if (nom.equalsIgnoreCase(tabAp[i].nom())) {
				trouv� = true;	// j'ai trouv�
				indice = i;		// m�moriser l'indice
				break;			// plus besoin de continuer la recherche
			}
		}
		if (trouv�) {
			return tabAp[indice];
		}
		else {
			return null;	// Si rien trouv�, je rend la r�f�rence nulle
		}
	}
	// Afficher les donn�es de toutes les appartenances
	public void afficherDonn�es() {
		// Il suffit d'afficher l'�tat de toutes les appartenances de l'agence
		for (int i = 0 ; i < nbAp ; i++) {
			tabAp[i].afficherDonn�es();
		}
	}
	// Suppression d'une appartenance
	public void supprimer(ApJardin a) {
		boolean trouv� = false; // rien trouv� pour l'instant
		int indice = 0;
		for (int i = 0 ; i < nbAp ; i++)  {
			if (tabAp[i] == a) { 	// attention comparaison de r�f�rences
				trouv� = true;		// j'ai trouv�
				indice = i;			//m�moriser l'indice
				break;				// plus besoin de continuer la recherche
			}
		}
		if (trouv�) {
			// D�caler le reste du tableau vers la gauche
			// On "�crase" ainsi l'appartenance � supprimer
			for (int i = indice+1 ; i < nbAp ; i++) {
				tabAp[i-1] = tabAp[i];
			}
			// Mettre � jour le nombre d'appartenances
			nbAp--;
		}
		else {
			// Message d'erreur si on n'a rien trouv�
			System.out.println("Je n'ai pas trouv� cette appartenance");
		}
	}
	// Ecriture du tableau des comptes dans le fichier
	public void sauvegarder(File f) {
		BufferedWriter bw = Utils.openWriteFile(f);
		if (bw != null) {
			Utils.saveInt(bw,  nbAp);
			// Il nous reste maintenant � parcourir le tableau en �crivant les comptes les uns apr�s les autres.
			for (int i = 0 ; i < nbAp ; i ++) {
				tabAp[i].save(bw);
			}
			// Il nous reste � fermer le flot d'�criture et � indiquer par un message comment l'op�ration s'est d�roul�e
			try {
				bw.close();
			}
			catch (IOException ioe) {}
			System.out.println("sauvegarde effectu�e");
		}
		else {
			System.out.println("Impossible de sauvegarder");
		}
	}
	// La m�thode charger est sym�trique . On commence par ouvrir le fichier en lecture, et on lit la premi�re ligne qui contient le nombre de comptes � charger
	public void charger(File f) {
		BufferedReader br = Utils.openReadFile(f);
		if (br != null) {
			nbAp = Utils.loadInt(br);
			// Il faut maintenant pour chaque appartenance sauvegard�e commencer par lire le nom de 
			for (int i = 0 ; i < nbAp ; i++) {
				tabAp[i] = new ApJardin("","");
				tabAp[i].load(br);
			}
			try {
			br.close();
			}
			catch (IOException ioe) {}
			System.out.println("Jardins charg�s");
		}
		else {
			System.out.println("Impossible de charger la sauvegarde");
		}
	}
}