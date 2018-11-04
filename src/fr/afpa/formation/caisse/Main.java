package fr.afpa.formation.caisse;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Produit> stock = new ArrayList<Produit>();		
		stock.add(new Produit("coca        ", "000001", 1.5));
		stock.add(new Produit("Meo Expresso", "000002", 1.0));
		stock.add(new Produit("Baguette    ", "000003", 0.8));
		stock.add(new Produit("lait        ", "000004", 1.2));
		stock.add(new Produit("get douche  ", "000005", 2.2));
		Ticket t = new Ticket();
		
	// fin stock
		
	caisse(stock, t);
		
		

	}

	public static void ajouterProduit(ArrayList<Produit> stock,Ticket ticket ){
		System.out.println("Entrez le code produit ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String code = in.nextLine();
		boolean existe = false;
		for(Produit a : stock ){ //même traitement pour chaque valeur de la liste
			if(code.equals(a.getCodeProduit())) {
				existe = true;
				if(!ticket.items.contains(a)) {
					ticket.items.add(new Produit(a));
					ticket.items.get(ticket.items.indexOf(a)).setQuantite(1);
				}else {
					ticket.items.get(ticket.items.indexOf(a)).setQuantite(1);
				}
				
				System.out.println("Produit ajouté");
				}
		}
		if(!existe) {
			System.out.println("Code invalide ou produit inexistant en stock");
		}
	}
	public static void enleverProduit(ArrayList<Produit> stock,Ticket ticket) {
		System.out.println("Entrez le code produit ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String code = in.nextLine();
		boolean existe = false;
		for(Produit a : ticket.items ){ //même traitement pour chaque valeur de la liste
			if(code.equals(a.getCodeProduit())) {
				existe = true;
				if(a.getQuantite()==1) {
					ticket.items.remove(a);
				}else {
					ticket.items.get(ticket.items.indexOf(a)).setQuantite(-1);
				}
				
				System.out.println("Produit supprimé");
				break;
				}
		}
		if(!existe) {
			System.out.println("Code invalide ou produit inexistant sur le ticket");
		}
		
	}
	public static void imprimerTicket(Ticket t) {
		t.imprimer();
	}
	
	public static void affichMenu() {
		System.out.println();
		System.out.println("Caisse automatique");
		System.out.println("--------------------- ");		
		System.out.println("A ~ Ajouter un produit");
		System.out.println("B ~ Enlever un produit");
		System.out.println("C ~ Imprimer le ticket");	
		System.out.println("Q ~ Quitter");
		
	}
	
	public static void caisse(ArrayList<Produit> stock, Ticket t) {
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);	
	String choix="";
	
	do {
		affichMenu();
		choix  = in.nextLine();
		switch (choix)
		{			
		case "A":{
			ajouterProduit(stock, t);}break;

		case "B":{
			enleverProduit(stock, t);}break;

		case "C":{
			imprimerTicket(t);}break;
		
		case "Q":{
			System.out.println("Fin encaissement.");break;
		}

		default:
		{
			System.out.println("Votre choix n'est pas valide !");
		}
		}  
	} while (choix.equalsIgnoreCase("Q")==false);

	}
}
	

