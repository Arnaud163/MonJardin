
// Classe ApJardin - version 3.1

import java.io.*;

/**
 * Classe représentant les données du titulaire du jardin et les méthodes qui lui
 * sont associées.
 * @author Arnaud Laforgue
 **/

public class ApJardin {
	private String nom; // le nom du propriétaire
	private String adresse; // son adresse
	private int totalarbres; // le nombre d'arbres qui composent le jardin
	private int nbcypre; // le nombre de cyprés
	private int nbpommier; // le nombre de pommiers
	private int nbprunier; // le nombre de pruniers
	private int nbnoisetier; // le nombre de noisetiers
	private int nbfiguier; // le nombre de figuiers
	
	// Pas de variable PremierNuméroDisponible
	
	// Constructeur : on reçoit en paramètres les valeurs du nom,
	// de l'adresse et du numéro, et on met le nombre d'arbres à 0 par défaut
	
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
	
	// constructeur par défaut, sans paramètres
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
	
	// Les méthodes
	public void créditer(int montant) {
		totalarbres +=montant;
	}
	public void débiter(int montant) {
		totalarbres -=montant;
	}
	public void créditerc(int montant) {
		nbcypre +=montant;
	}
	public void débiterc(int montant) {
		nbcypre -=montant;
	}
	public void créditerpo(int montant) {
		nbpommier +=montant;
	}
	public void débiterpo(int montant) {
		nbpommier -=montant;
	}
	public void créditerpr(int montant) {
		nbprunier +=montant;
	}
	public void débiterpr(int montant) {
		nbprunier -=montant;
	}
	public void créditern(int montant) {
		nbnoisetier +=montant;
	}
	public void débitern(int montant) {
		nbnoisetier -=montant;
	}
	public void créditerf(int montant) {
		nbfiguier +=montant;
	}
	public void débiterf(int montant) {
		nbfiguier -=montant;
	}
	public void afficherDonnées() {
		System.out.println("***************************************************************************************");
		System.out.println("Jardin de : "+nom);
		System.out.println("Adresse du jardin : "+adresse);
		System.out.println("Le jardin comporte " + totalarbres + " arbres");
		System.out.println("dont " + nbcypre + " cyprés, "+nbpommier + " pommiers, ");
		System.out.println(nbprunier + " pruniers, " + nbnoisetier + " noisetiers, " + nbfiguier + "figuiers.");
		System.out.println("***************************************************************************************");
	}
	// Accés en lecture
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
	
	// chargement de l'appartenance à partir d'un BufferedReader
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