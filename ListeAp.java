// Interface ListeAp - version 1.1


import java.io.File;

/**
 * * Interface r�pr�sentant une liste d'appartenance et les op�rations
 * que l'on souhaite effectuer sur cette liste
 **/

public interface ListeAp {
	// R�cup�rer une appartenance � partir d'un nom donn�
	public ApJardin trouverAp(String nom);
	// Ajout d'un nouveau compte
	public void ajout(ApJardin a);
	// Suppression d'un compte
	public void supprimer(ApJardin a);
	// Afficher l'�tat de toutes les appartenances
	public void afficherDonn�es();
	// Sauvegarder dans un fichier
	public void sauvegarder(File f);
	// Charger � partir d'un fichier
	public void charger(File f);
}
