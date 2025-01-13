/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.othello;

import java.util.Scanner;

/**
 *
 * @author Clara
 */
public class TourDeJeu {
    //Creation du tableau du jeu et des joueurs
    
    public static void main(String[] args) {
        
        //Debut du jeu
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid;
        Tableau tableau = new Tableau();
        
        //Creation du tableau du jeu et des joueurs
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();

        joueur1.setNom("Lari");
        joueur2.setNom("Clara");

        //Debut du jeu
        
        tableau.init();

 

        do {
            System.out.print("Entrée de 'a1' a 'h8': ");
            input = scanner.nextLine().trim(); // Sort les spaces
            isValid = isValidEntry(input);
            
            if (!isValid) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        } while (!isValid);

        System.out.println("Entrada válida: " + input);
        scanner.close();
    }

    /**
     * Verifica se a entrada está no formato correto (letra de 'a' a 'h' e número de '1' a '8').
     * 
     * @param input A entrada do jogador.
     * @return true se a entrada for válida, false caso contrário.
     */
    public static boolean isValidEntry(String input) {
        return input != null && input.matches("^[a-h][1-8]$");
    }
}
