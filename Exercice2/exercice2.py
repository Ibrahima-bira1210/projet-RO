from numpy import *
import sys
class ManipulateurGraph:
    """Les graphes sont sous forme de matrice et les intersections entre
    les lignes et les colonnes donnent les valuations  """
############ Toutes les initialisarions ########################
    def __init__(self,*args):
        self.graphe=a
        #Les sommets noirs
        self.som_noir=[]
        #Les sommets gris
        self.som_gris=[]
        #Les sommets blancs
        self.som_blanc=[]
        for i in range(len(a)):
            if i==0:
                    self.som_blanc.append(0)
            else:
                self.som_blanc.append(sys.maxsize)
        #Les plus courts chemins
        #Les éléments de la liste représente les valeurs des chemins
        self.chemins=[]
        for i in range(len(a)):
            if i==0:
                self.chemins.append(0)
            else:
                self.chemins.append(sys.maxsize)
        # Les prédecesseurs
        #Le premier élément sur chaque ligne représente le sommet et le deuxième le predecesseur
        #Et le troisieme est la valuation entre les deux sommets
        #Ici NaN veut dire qu'il n'y pas de prédecesseur
        self.pred=[]
        for i in range(len(a)):
            if i==0:
                self.pred.append([i,0,0])
            else:
                self.pred.append([i,NaN,0])

########### Tester l'existance d'un arc ################
    def existance_arc(self,i,j):
        if self.graphe[i][j]==0:
            return False
        else :
            return True

############ Obtenir la valuation d'un arc ##############
    
    def Valuation(self,i,j):
        return self.graphe[i][j]

########### Retirer un arc du graphe ####################
    def retirer_arc(self,i,j):
        self.graphe[i][j]=0

########## Imprimer la matrice des valuations ############
    def afficher(self):
        print(self.graphe)
######### Donner les plus courts chemins ##############
a=array([[0,4,3,0,0,0],[0,0,0,4,0,0],[0,0,0,3,2,0],[0,0,0,0,0,1],[0,0,0,0,0,10],[0,0,0,0,0,0]])
testeur=ManipulateurGraph(a)
nbr_sommets=len(testeur.graphe)
for i in range(nbr_sommets):
    val_min=testeur.som_blanc.index(min(testeur.som_blanc))
    testeur.som_gris.append(val_min)
    for j in range(len(testeur.graphe)):
        if(testeur.existance_arc(int(val_min),j)==True):
            value=testeur.Valuation(int(val_min),j)+testeur.pred[int(val_min)][2]
            if(value <= testeur.chemins[j]):
                testeur.chemins[j]=value
                testeur.som_blanc[j]=value
                testeur.pred[j]=[j,val_min,value]
""" Au lieu de supprimer l'élément sur la liste des sommets blanc j'ai remplacé sa valeur par infini parceque sinon je risque de perdre les index 
qui représente ici mes sommets"""
    testeur.som_blanc[int(val_min)]=Inf
    del testeur.som_gris[0]
    testeur.som_noir.append(val_min)
print(testeur.pred)
print(testeur.chemins)
print(testeur.som_noir)