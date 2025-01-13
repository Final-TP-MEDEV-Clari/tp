/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.othello;

import java.util.ArrayList;
import java.util.List;

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
     * Getter tableau
     * @param tableau
     */
    public Peon[][] getTableau() {
        return tableau;
    }
    
    /**
    * Vérifie si le joueur peut placer un pion dans la position donnée
    * @param joueur Le joueur qui joue
    * @param x La position x 
    * @param y La position y
    * @return true si le joueur peut placer un pion, false sinon
    */
    public boolean peutPlacer(Joueur joueur, int x, int y) {
        // Vérifie si la position est dans les limites et vide
        if (x < 0 || x >= height || y < 0 || y >= width || tableau[x][y] != null) {
            return false;
        }

        // Directions possibles : horizontal, vertical, diagonal
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0},  {1, 1}
        };

        boolean peutPlacer = false;
        for (int[] dir : directions) {
            int dx = dir[0], dy = dir[1];
            if (peutCapturerDansDirection(joueur, x, y, dx, dy)) {
                peutPlacer = true;
                break;
            }
        }
        return peutPlacer;
        
    }

    /**
    * Vérifie si des pions peuvent être capturés dans une direction donnée
    * @param joueur Le joueur qui joue
    * @param x La position x de départ
    * @param y La position y de départ
    * @param dx Direction en x
    * @param dy Direction en y
    * @return true si des pions peuvent être capturés, false sinon
    */
    private boolean peutCapturerDansDirection(Joueur joueur, int x, int y, int dx, int dy) {
        boolean trouvéAdversaire = false;
        int i = x + dx;
        int j = y + dy;

        // Parcourt dans la direction donnée
        while (i >= 0 && i < height && j >= 0 && j < width) {
            Peon actuel = tableau[i][j];

            if (actuel == null) {
                return false; // Aucun pion dans cette direction
            }

            if (actuel.getCouleur() != joueur.getCouleur()) {
                trouvéAdversaire = true; // Trouvé un pion adverse
            } else {
                // Si un pion du joueur est trouvé après des pions adverses
                return trouvéAdversaire;
            }

            i += dx;
            j += dy;
        }

        return false; // Aucun pion du joueur trouvé pour capturer
    }

    
        /**
     * Ajoute un nouveau peon au tableau et capture les peons adverses.
     * @param joueur1 Propriétaire du peon
     * @param pos String avec la position d'ajout (par ex. "d3")
     */
    public void addPeon(Joueur joueur1, String pos) {
        // Convertir la position en coordonnées
        int x = pos.charAt(1) - '1'; // Ligne
        int y = pos.charAt(0) - 'a'; // Colonne

        // Vérifier si la position est valide
        if (tableau[x][y] != null) {
            System.out.println("Position déjà occupée. Veuillez choisir une autre position.");
            return;
        }

        // Ajouter le peon du joueur
        tableau[x][y] = new Peon(joueur1.getCouleur(), x, y);

        // Capturer les peons adverses dans toutes les directions
        int[][] directions = {
            {-1, 0}, {1, 0}, // Vertical
            {0, -1}, {0, 1}, // Horizontal
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonales
        };

        for (int[] direction : directions) {
            capturerPeons(joueur1, x, y, direction[0], direction[1]);
        }

        System.out.println("Peon ajouté en " + pos + " et les peons adverses capturés.");
    }

    /**
     * Capture les peons adverses dans une direction donnée.
     * @param joueur1 Le joueur qui joue
     * @param x Position initiale (ligne)
     * @param y Position initiale (colonne)
     * @param dx Direction de la ligne
     * @param dy Direction de la colonne
     */
    private void capturerPeons(Joueur joueur1, int x, int y, int dx, int dy) {
        boolean couleurJoueur = joueur1.getCouleur();
        List<int[]> peonsACapturer = new ArrayList<>();
        int i = x + dx;
        int j = y + dy;

        // Parcourir dans la direction donnée
        while (i >= 0 && i < height && j >= 0 && j < width) {
            Peon peon = tableau[i][j];
            if (peon == null) {
                // Arrête si case vide
                break;
            } else if (peon.getCouleur() != couleurJoueur) {
                // Ajouter les peons adverses à capturer
                peonsACapturer.add(new int[]{i, j});
            } else {
                // Même couleur trouvée, capturer les peons
                for (int[] pos : peonsACapturer) {
                    tableau[pos[0]][pos[1]].setCouleur(couleurJoueur);
                }
                return;
            }

            i += dx;
            j += dy;
        }
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
