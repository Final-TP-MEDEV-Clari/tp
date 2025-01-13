/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.othello;

/**
 *
 * @author Larissa et Clara
 */
public class Tableau {
    public static int width = 8;
    public static int height = 8;

    private Peon[][] tableau;

    /**
    * Constructeur de la classe Tableau
    */
    public Tableau() {
        this.tableau = new Peon[width][height];
    }
    
    /**
    * Inicialisation du tableau
    */
    public void init() {
        this.tableau[3][3] = new Peon(true, 3, 3);
        this.tableau[4][4] = new Peon(true, 4, 4);
        
        this.tableau[3][4] = new Peon(false, 3, 4);
        this.tableau[4][3] = new Peon(false, 4, 3);
    }
    
    /**
     * Setter tableau
     * @param tableau
     */
    public Peon[][] getTableau() {
        return tableau;
    }

    
    /**
    * Verifie si le joueur peut placer le peon dans la position
    * @param joueur Le joueur à joueur
    * @param x La position x
    * @param y La position y
    * @return true si le joueur pet placer et false sinon.
    */
    public boolean peutPlacer(Joueur joueur, int x, int y){
        
     
        return false;

    }
    
    /**

     * Ajout un nouveau peon au tableau
     */
    public void addPeon(){
        System.out.println("Peon ajouté");
    }
    
    /**
     * Verifie s'il y a encore des places sur le tableau pour la definition de la fin du jeu
     * @return 
     */
    public boolean existePlace(){
        return true;
    }
    
    /*
    * Verifie si le tableau est plein
    * @return true si oui et false sinon.
    */
    public boolean isFull() {
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if (tableau[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }
   /**
    * Affiche le tableau pour l'utilisateur
    */
    public void affiche() {
        System.out.print("  "); 
        for (char c = 'a'; c <= 'h'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        
        for (int i = 0; i < height; i++) {
            System.out.print((i + 1) + " ");

            for (int j = 0; j < width; j++) {
                Peon peon = this.tableau[i][j];
                if (peon == null) {
                    System.out.print(". ");
                } else {
                    System.out.print((peon.getCouleur() ? "B" : "N") + " ");
                }
            }
            System.out.println((i + 1));
        }

        System.out.print("  ");
        for (char c = 'a'; c <= 'h'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

}
