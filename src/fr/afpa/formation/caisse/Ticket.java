package fr.afpa.formation.caisse;

import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;


public class Ticket {
	
	protected ArrayList<Produit>items = new ArrayList<Produit>();
	
	
	public ArrayList<Produit> getItems() {
		return items;
	}

	public void setItems(ArrayList<Produit> items) {
		this.items = items;
	}

	public void affichItems() {
		for(Produit a : items ){
			System.out.println(a);
	}
		
	}
	
	public double totalTicket() {
		double total = 0;
		for(Produit a : items) {
			total = (a.getPrix() * a.getQuantite()) + total; 			
		}
		return total;
	}
	
	public void affichTotal( double total) {		
		System.out.println(" Total 	         	        "+total+" euros"  );
		System.out.println("-----------------------------------------------------------");
	}
	public int nbArticles() {
		int nb =0;
		for(Produit a : items) {
			nb = a.getQuantite() + nb; 			
		}
		
		return nb;
	}
	
	private String dateTicket() {
		Date aujourdhui = new Date();		
		DateFormat date = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
		
		return date.format(aujourdhui);
		
	}

	private double affichTVA()
	{
		double nombre = totalTicket()*0.2;
		
		return(double)((int)(nombre * Math.pow(10,2) + .5)) / Math.pow(10,2);
	}
	
// commentaire check git


	public void imprimer() {
		System.out.println(		"						AFPA								"	);
		System.out.println(		"				www.IDP-FullStack.com						"	);
		System.out.println(		"					03 00 00 00 00							"	);
		System.out.println(		"															"	);
		System.out.println(		" Article	 Quantité	Prix								"	);
		affichItems();
		System.out.println(		"-----------------------------------------------------------"	);		
		affichTotal(totalTicket());
		System.out.println(		"															"	);
		System.out.println(		" 20%-TVA			"+ affichTVA() +" euros								"	);
		System.out.println(		"-----------------------------------------------------------"	);
		System.out.println(		"                  "+nbArticles()+" Articles										"	);
		System.out.println(		"-----------------------------------------------------------"	);
		System.out.println(		"Date : "+  dateTicket() );
	}
}
