/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.othello;

/**
 *
 * @author Clara
 */
public class Tableau {
    public static int width = 8;
    public static int height = 8;

    private Peon[][] tableau;

    public Tableau() {
        this.tableau = new Peon[width][height];
    }
    
    public void init() {
        this.tableau[3][3] = new Peon(true, 3, 3);
        this.tableau[4][4] = new Peon(true, 4, 4);
        
        this.tableau[3][4] = new Peon(false, 3, 4);
        this.tableau[4][3] = new Peon(false, 4, 3);
    }
    
    public Peon[][] getTableau() {
        return tableau;
    }

    public void setTableau(Peon[][] tableau) {
        this.tableau = tableau;
    }
    
    public boolean peutPlacer(Joueur joueur, String pos){
        char letter = pos.charAt(0);
        int number = (int)(pos.charAt(1));
     
    return false;

    }
    
    /**
     * Ajout un nouveau peon au tableau
     * @param joueur Joueur proprietaire du peon
     * @param pos String avec la position du peon
     */
    public void addPeon(Joueur joueur, String pos){
        System.out.println("Peon ajouté");
    }
    
    /**
     * Verifie s'il y a encore des places sur le tableau pour la definition de la fin du jeu
     * @return 
     */
    public boolean existePlace(){
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
