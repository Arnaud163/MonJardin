// Interface ListeAp - version 1.1


import java.io.File;

/**
 * * Interface réprésentant une liste d'appartenance et les opérations
 * que l'on souhaite effectuer sur cette liste
 **/

public interface ListeAp {
	// Récupérer une appartenance à partir d'un nom donné
	public ApJardin trouverAp(String nom);
	// Ajout d'un nouveau compte
	public void ajout(ApJardin a);
	// Suppression d'un compte
	public void supprimer(ApJardin a);
	// Afficher l'état de toutes les appartenances
	public void afficherDonnées();
	// Sauvegarder dans un fichier
	public void sauvegarder(File f);
	// Charger à partir d'un fichier
	public void charger(File f);
}
