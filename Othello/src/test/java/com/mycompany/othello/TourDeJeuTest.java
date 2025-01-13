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

/**
 *
 * @author Clara
 */
public class TourDeJeuTest {
    
    private TourDeJeu tourDeJeu;

    @BeforeEach
    public void setUp() {
        // Initialisation d'un tableau de jeu fictif
        tourDeJeu = new TourDeJeu();
    }
    
    @Test
    void testInvalidInputsLetters() {
        // Testa entradas com letras fora do intervalo 'a' a 'h'
        assertFalse(tourDeJeu.isValidEntry("i1"));
        assertFalse(tourDeJeu.isValidEntry("z3"));
        assertFalse(tourDeJeu.isValidEntry("A4")); // Maiúscula não permitida
    }

    @Test
    void testInvalidInputsNumbers() {
        // Testa entradas com números fora do intervalo '1' a '8'
        assertFalse(tourDeJeu.isValidEntry("a0"));
        assertFalse(tourDeJeu.isValidEntry("h9"));
        assertFalse(tourDeJeu.isValidEntry("b10"));
    }

    @Test
    void testInvalidInputsFormat() {
        // Testa entradas com formatos incorretos
        assertFalse(tourDeJeu.isValidEntry("11"));    // Sem letra
        assertFalse(tourDeJeu.isValidEntry("aa"));    // Sem número
        assertFalse(tourDeJeu.isValidEntry("a"));     // Apenas uma letra
        assertFalse(tourDeJeu.isValidEntry("3"));     // Apenas um número
        assertFalse(tourDeJeu.isValidEntry("a 1"));   // Espaço no meio
        assertFalse(tourDeJeu.isValidEntry(""));      // Entrada vazia
        assertFalse(tourDeJeu.isValidEntry(null));    // Entrada nula
    }
    
}
