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



public class PeonTest {

    private static Peon peon;

    @BeforeEach
    public static void setUp() {
        // Cria um peão com cor 'blanc' (true), e posições (1, 2)
        peon = new Peon(true, 1, 2);
    }

    @Test
    public void testPeonConstructor() {
        // Verifica se o construtor funciona corretamente
        assertEquals(1, peon.getX());
        assertEquals(2, peon.getY());
        assertTrue(peon.getCouleur()); // Deve ser 'blanc'
    }

    @Test
    public void testGetX() {
        // Verifica se o método getX() retorna o valor correto
        assertEquals(1, peon.getX());
    }

    @Test
    public void testSetX() {
        // Verifica se o método setX() funciona corretamente
        peon.setX(3);
        assertEquals(3, peon.getX());
    }

    @Test
    public void testGetY() {
        // Verifica se o método getY() retorna o valor correto
        assertEquals(2, peon.getY());
    }

    @Test
    public void testSetY() {
        // Verifica se o método setY() funciona corretamente
        peon.setY(4);
        assertEquals(4, peon.getY());
    }

    @Test
    public void testGetCouleur() {
        // Verifica se o método getCouleur() retorna o valor correto
        assertTrue(peon.getCouleur()); // Deve ser 'blanc'
    }

    @Test
    public void testSetCouleur() {
        // Verifica se o método setCouleur() funciona corretamente
        peon.setCouleur(false); // muda para 'noir'
        assertFalse(peon.getCouleur()); // Deve ser 'noir'
    }
}
