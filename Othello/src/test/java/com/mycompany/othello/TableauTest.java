/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.othello;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TableauTest {

    private Tableau tableau;
    private Joueur joueur1;
    private Joueur joueur2;

    @BeforeAll
    public void setUp() {
        // Initialise un tableau de jeu et deux joueurs
        tableau = new Tableau();
        tableau.init();  // Initialise le tableau avec les positions de départ
        joueur1 = new Joueur('v', true);  // Joueur avec couleur 'B'
        joueur2 = new Joueur(false); // Joueur avec couleur 'N'
    }

    @Test
    public void testPeutPlacer() {
        // Vérifie si le joueur peut placer un pion sur une position valide
        boolean peutPlacer = tableau.peutPlacer(joueur1, 2, 3);
        assertTrue(peutPlacer); // Doit être possible de jouer ici
        
        // Vérifie si le joueur ne peut pas jouer sur une position déjà occupée
        tableau.addPeon(joueur1, "d3");
        boolean peutPlacerInvalide = tableau.peutPlacer(joueur1, 2, 3);
        assertFalse(peutPlacerInvalide); // La case est déjà occupée
    }

    @Test
    public void testPeutCapturerDansDirection() {
        // Test si la méthode peutCapturerDansDirection fonctionne correctement
        tableau.addPeon(joueur1, "d3");
        tableau.addPeon(joueur2, "d4");
        
        // Vérifie qu'un pion peut être capturé dans une direction donnée
        boolean peutCapturer = tableau.peutCapturerDansDirection(joueur1, 2, 3, 1, 0); // Direction verticale
        assertTrue(peutCapturer); // Doit pouvoir capturer dans cette direction
    }

    @Test
    public void testAddPeon() {
        // Test si l'ajout d'un pion fonctionne correctement
        tableau.addPeon(joueur1, "d5");
        
        // Vérifie que le pion est bien ajouté
        Peon peon = tableau.getTableau()[4][3]; // Ligne 4, Colonne 3 correspond à d5
        assertNotNull(peon); // Le pion ne doit pas être nul
        assertTrue(peon.getCouleur()); // Le pion doit être de couleur 'B'
        
        // Vérifie que des pions adverses sont capturés après l'ajout
        tableau.addPeon(joueur1, "c4");
        Peon capturedPeon = tableau.getTableau()[3][3]; // Ligne 3, Colonne 3 correspond à c4
        assertTrue(capturedPeon.getCouleur()); // Le pion capturé doit être devenu de couleur 'B'
    }

    @Test
    public void testExistePlace() {
        // Test si la méthode existePlace() fonctionne correctement
        boolean placeExistante = tableau.existePlace();
        assertTrue(placeExistante); // Il devrait y avoir de la place pour jouer
    }

    @Test
    public void testIsFull() {
        // Test si le tableau est plein
        boolean isFull = tableau.isFull();
        assertFalse(isFull); // Le tableau ne doit pas être plein au départ

        // Remplir tout le tableau et tester à nouveau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tableau.addPeon(joueur1, "" + (char)('a' + j) + (i + 1));
            }
        }

        isFull = tableau.isFull();
        assertTrue(isFull); // Maintenant le tableau doit être plein
    }

    @Test
    public void testAffiche() {
        // Test si l'affichage du tableau fonctionne correctement
        tableau.affiche();
        // Cela imprime le tableau, on vérifie manuellement si tout est correct
    }
}
