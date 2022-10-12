
// Classe ApJardin - version 3.1

import java.io.*;

/**
 * Classe repr�sentant les donn�es du titulaire du jardin et les m�thodes qui lui
 * sont associ�es.
 * @author Arnaud Laforgue
 **/

public class ApJardin {
	private String nom; // le nom du propri�taire
	private String adresse; // son adresse
	private int totalarbres; // le nombre d'arbres qui composent le jardin
	private int nbcypre; // le nombre de cypr�s
	private int nbpommier; // le nombre de pommiers
	private int nbprunier; // le nombre de pruniers
	private int nbnoisetier; // le nombre de noisetiers
	private int nbfiguier; // le nombre de figuiers
	
	// Pas de variable PremierNum�roDisponible
	
	// Constructeur : on re�oit en param�tres les valeurs du nom,
	// de l'adresse et du num�ro, et on met le nombre d'arbres � 0 par d�faut
	
	ApJardin(String unNom, String uneAdresse) {
		nom = unNom;
		adresse = uneAdresse;
		totalarbres = 0;
		nbcypre = 0;
		nbpommier = 0;
		nbprunier = 0;
		nbnoisetier = 0;
		nbfiguier = 0;
	}
	
	// constructeur par d�faut, sans param�tres
	ApJardin() {
		nom = "";
		adresse = "";
		totalarbres = 0;
		nbcypre = 0;
		nbpommier = 0;
		nbprunier = 0;
		nbnoisetier = 0;
		nbfiguier = 0;
	}
	
	// Les m�thodes
	public void cr�diter(int montant) {
		totalarbres +=montant;
	}
	public void d�biter(int montant) {
		totalarbres -=montant;
	}
	public void cr�diterc(int montant) {
		nbcypre +=montant;
	}
	public void d�biterc(int montant) {
		nbcypre -=montant;
	}
	public void cr�diterpo(int montant) {
		nbpommier +=montant;
	}
	public void d�biterpo(int montant) {
		nbpommier -=montant;
	}
	public void cr�diterpr(int montant) {
		nbprunier +=montant;
	}
	public void d�biterpr(int montant) {
		nbprunier -=montant;
	}
	public void cr�ditern(int montant) {
		nbnoisetier +=montant;
	}
	public void d�bitern(int montant) {
		nbnoisetier -=montant;
	}
	public void cr�diterf(int montant) {
		nbfiguier +=montant;
	}
	public void d�biterf(int montant) {
		nbfiguier -=montant;
	}
	public void afficherDonn�es() {
		System.out.println("***************************************************************************************");
		System.out.println("Jardin de : "+nom);
		System.out.println("Adresse du jardin : "+adresse);
		System.out.println("Le jardin comporte " + totalarbres + " arbres");
		System.out.println("dont " + nbcypre + " cypr�s, "+nbpommier + " pommiers, ");
		System.out.println(nbprunier + " pruniers, " + nbnoisetier + " noisetiers, " + nbfiguier + "figuiers.");
		System.out.println("***************************************************************************************");
	}
	// Acc�s en lecture
	public String nom() {
		return this.nom;
	}
	public String adresse() {
		return this.adresse;
	}
	
	// sauvegarde de l'appartenance dans un BufferedWriter
	public void save(BufferedWriter bw) {
		Utils.saveString(bw,  nom);
		Utils.saveString(bw,  adresse);
		Utils.saveInt(bw, totalarbres);
		Utils.saveInt(bw, nbcypre);
		Utils.saveInt(bw, nbpommier);
		Utils.saveInt(bw, nbprunier);
		Utils.saveInt(bw, nbnoisetier);
		Utils.saveInt(bw, nbfiguier);
	}
	
	// chargement de l'appartenance � partir d'un BufferedReader
	public void load(BufferedReader br) {
		nom = Utils.loadString(br);
		adresse = Utils.loadString(br);
		totalarbres = Utils.loadInt(br);
		nbcypre = Utils.loadInt(br);
		nbpommier = Utils.loadInt(br);
		nbprunier = Utils.loadInt(br);
		nbnoisetier = Utils.loadInt(br);
		nbfiguier = Utils.loadInt(br);
	}
}