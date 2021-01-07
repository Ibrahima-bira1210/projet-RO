
public class Main {

	public static void main(String[] args) {
		
		Graphe1 graphe1 = new Graphe1(false);
		
		// Création de sommets d'abord
		Sommet Dakar = new Sommet("Dakar");
		Sommet Thies = new Sommet("Thies");
		Sommet Diourbel = new Sommet("Diourbel");
		Sommet Kaolack = new Sommet("Kaolack");
		Sommet Fatick = new Sommet("Fatick");
		Sommet Louga = new Sommet("Louga");
		
		graphe1.ajouterArete(Dakar,Thies);
		graphe1.ajouterArete(Kaolack,Fatick);
		graphe1.ajouterArete(Thies,Diourbel);
		graphe1.ajouterArete(Diourbel,Kaolack);
		graphe1.ajouterArete(Louga,Dakar);
		graphe1.ajouterArete(Thies, Fatick);
		graphe1.ajouterArete(Dakar,Kaolack);

		graphe1.rechercheChemin(Dakar,Louga);
		
		/*
		 Graphe2 graphe2 = new Graphe2(4);
		
		graphe2.ajouterArete(0,1);
		graphe2.ajouterArete(2,3);
		graphe2.ajouterArete(1,3);
		
		graphe2.afficherGraphe();
		 */
		
	}
}
