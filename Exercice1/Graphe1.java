import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Cette classe Graphe1 implémente la représentation 
 * d'un graphe par liste d'adjacence.
 */
public class Graphe1 {
	public HashMap<Sommet, LinkedList<Sommet>> adjList;
	public boolean oriente;
	public int degre;

	/*
	 * Pour un graphe orienté, on fera new Graphe1(true)
	 */
	public Graphe1(boolean oriente) {
		this.oriente = oriente;
		adjList = new HashMap<>();
		this.degre = 0;
	}
	
	/**
	 * Cette méthode permet d'ajouter un sommet
	 * @param nomSommet
	 */
	public void ajouterSommet(Sommet sommet) {
		adjList.putIfAbsent(sommet, new LinkedList<Sommet>());
	}
	
	/**
	 * Cette méthode permet de supprimer un sommet
	 * @param nomSommet
	 */
	public void supprimerSommet(Sommet sommet) {
		adjList.values().stream().forEach(e->e.remove(sommet));
		adjList.remove(sommet);
	}
	
	/**
	 * Cette methode permet de créer une arete entre 2 sommets du graphe 
	 * @param nomSommet1
	 * @param nomSommet2
	 */
	public void ajouterArete(Sommet sommet1, Sommet sommet2) {
		if(!adjList.keySet().contains(sommet1)) {
			ajouterSommet(sommet1);
		}
		if(!adjList.keySet().contains(sommet2)) {
			ajouterSommet(sommet2);
		}
		
		adjList.get(sommet1).add(sommet2);
		if (!oriente) {
		adjList.get(sommet2).add(sommet1);
		}
		degre++;
	}
	
	/**
	 * Cette methode permet de supprimer une arete 
	 * @param nomSommet1
	 * @param nomSommet2
	 */
	public void supprimerArete(Sommet sommet1, Sommet sommet2) {
		LinkedList<Sommet> voisinSommet1 = adjList.get(sommet1);
		LinkedList<Sommet> voisinSommet2 = adjList.get(sommet2);
		
		if (voisinSommet1 != null) {
			voisinSommet1.remove(sommet2);
		}
		if (voisinSommet2 != null) {
			voisinSommet2.remove(sommet1);
		}
	}
	
	public void afficherGraphe() {
		System.out.println("Notre graphe representé par liste d'adjacence\n");
		for (Sommet sommet : adjList.keySet()) {
			System.out.print(sommet+": ");
			if(adjList.get(sommet) != null) {
				for (Sommet voisin : adjList.get(sommet)) {
					System.out.print("-> "+ voisin + " -");
				}
				System.out.println();
			} else {
				System.out.println();
			}
			
		}
	}
	
	/*
	 * Cette méthode permet de récupérer un chemin entre 2 sommets
	 */
	public void RCUtil(Sommet sommet1,Sommet sommet2,LinkedList<Sommet> visite) {
		visite.add(sommet1);
		System.out.print(sommet1 + " ");
		
		Iterator<Sommet> i = adjList.get(sommet1).listIterator();
		while(i.hasNext()) {
			Sommet nextSommet = i.next();
			if (nextSommet == sommet2) {
				System.out.print(sommet2);
				return;
			}
			if (!visite.contains(nextSommet)) {
				visite.add(nextSommet);
				RCUtil(nextSommet,sommet2,visite);
			}
		}
	}
	public void rechercheChemin(Sommet sommet1, Sommet sommet2) {
		LinkedList<Sommet> visite = new LinkedList<Sommet>();
		
		RCUtil(sommet1,sommet2,visite);
	}
	
	public LinkedList<Sommet> ChaineUtil(Sommet sommet1, Sommet sommet2, LinkedList<Sommet> visite) {
		LinkedList<Sommet> chaine = new LinkedList<Sommet>();
		visite.add(sommet1);

		chaine.add(sommet1);

		Iterator<Sommet> i = adjList.get(sommet1).listIterator();
		while(i.hasNext()) {
			Sommet nextSommet = i.next();
			if (nextSommet == sommet2) {
				chaine.add(sommet2);
			}
			if (!visite.contains(nextSommet)) {
				visite.add(nextSommet);
				RCUtil(nextSommet,sommet2,visite);
			}
		}
		
		return chaine;
	}
	
	public void rechercheChaine(Sommet sommet1, Sommet sommet2) {
		LinkedList<Sommet> visite = new LinkedList<Sommet>();
		LinkedList<Sommet> chaine = ChaineUtil(sommet1,sommet2,visite);
		
		for(Sommet sommet: chaine) {
			System.out.println(sommet + " ");
		}
		
	}
	
	
	
	public boolean hasCycle(Sommet sommet) {
		 for(Sommet voisin: adjList.get(sommet)) {
			 if(voisin == sommet || hasCycle(voisin)) {
				 return true;
			 }
		 }
		return false;
	}
	public void RechercheCycle(Sommet sommet) {
		boolean result = hasCycle(sommet);
		if(result) {
			System.out.println("Il existe un cycle à partir du sommet "+sommet);
		} else {
			System.out.println("Il n'existe pas de cycle à du sommet "+sommet);
		}
	}
	
	/**
	 * Parcours en profondeur
	 */
	public void PeP(Sommet sommet, LinkedList<Sommet> visite){
        visite.add(sommet);
        Iterator<Sommet> i = adjList.get(sommet).iterator();
        Sommet nextSommet;
        while (i.hasNext())
        {
            nextSommet = i.next();
            if (!visite.contains(sommet))
                PeP(nextSommet,visite);
        }
    }
	
	public void RechercheCircuit() {
		LinkedList<Sommet> visite = new LinkedList<Sommet>();
		
	}
	
	
	
	/**
	 * Cette methode permet de retourner les voisins d'un sommet
	 * @param nomSommet
	 * @return
	 */
	public LinkedList<Sommet> getVoisinSommet(Sommet sommet){
		return adjList.get(sommet);
	}
}
