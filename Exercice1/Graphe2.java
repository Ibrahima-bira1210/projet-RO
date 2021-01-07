/**
 * Graphe représenté par matrice d'adjacence
 */
public class Graphe2 {
	private boolean adjMatrice[][];
	private int nombreSommet;
	
	public Graphe2 (int nombre) {
		this.nombreSommet = nombre;
		adjMatrice = new boolean[nombreSommet][nombreSommet];
	}
	
	public void ajouterArete(int sommet1, int sommet2) {
		adjMatrice[sommet1][sommet2] = true;
		adjMatrice[sommet2][sommet1] = true;
	}
	
	public void supprimerArete(int sommet1, int sommet2) {
		adjMatrice[sommet1][sommet2] = false;
		adjMatrice[sommet2][sommet1] = false;
	}
	
	
	public void afficherGraphe() {
		for (int i = 0; i<nombreSommet;i++) {
			System.out.print("Sommet " + i + ": ");
			for (int j = 0; j<nombreSommet; j++) {
				if (adjMatrice[i][j]) {
					System.out.print(j + ", ");
				}
			}
			System.out.println();
		}
	}
	
}
