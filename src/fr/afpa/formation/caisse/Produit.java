package fr.afpa.formation.caisse;

public class Produit {

	private String libelProduit;
	private String codeProduit; // 6 char
	private double prix;
	private int quantite;
	
	public Produit(String libelProduit, String codeProduit, double prix) {
		super();
		this.libelProduit = libelProduit;
		this.codeProduit = codeProduit;
		this.prix = prix;
		this.quantite= 0;
	}
	public Produit(Produit p) {
		super();
		this.libelProduit = p.getLibelProduit();
		this.codeProduit = p.getCodeProduit();
		this.prix = p.getPrix();
		this.quantite = 0;
		
	}

	
	
	public String getLibelProduit() {
		return libelProduit;
	}

	public void setLibelProduit(String libelProduit) {
		this.libelProduit = libelProduit;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = this.quantite + quantite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeProduit == null) ? 0 : codeProduit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (codeProduit == null) {
			if (other.codeProduit != null)
				return false;
		} else if (!codeProduit.equals(other.codeProduit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return " " +libelProduit + "	  " + quantite + "		" + (prix);
	}

	
	
	
	
	
	
}
