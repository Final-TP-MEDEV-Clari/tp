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

    /**
     * Verifica se a entrada está no formato correto (letra de 'a' a 'h' e número de '1' a '8').
     * 
     * @param input A entrada do jogador.
     * @return true se a entrada for válida, false caso contrário.
     */
    public static boolean isValidEntry(String input) {
        return input != null && input.matches("^[a-h][1-8]$");
    }
    
    
    /**
     * Main class
     * @param args 
     */
   
    public static void main(String[] args) {
        
        //Debut du jeu
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid;
        
        //Creation du tableau du jeu et des joueurs
        Tableau tableau = new Tableau();
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();

        joueur1.setNom("Lari");
        joueur1.setCouleur(false); //false == noir
        
        joueur2.setNom("Clara");
        joueur2.setCouleur(true); //true == blanc

        //Debut du jeu
        tableau.init();
        
        while(!tableau.isFull()){
            tableau.affiche();
            
            //Noir joue en premier
            if(joueur1.getPeutJouer()){
                //joueur noir choissis leur prochain peon
                do {
                    System.out.print("Entrée de 'a1' a 'h8': ");
                    input = scanner.nextLine().trim(); // Sort les spaces
                    isValid = isValidEntry(input);
                    
                    if (!isValid) {
                        System.out.println("Entrada inválida. Tente novamente.");
                    }
                } while (!isValid);
                tableau.addPeon(joueur1, input);
                }
            
            if(joueur2.getPeutJouer()){
                //joueur blanc joue
                do {
                    System.out.print("Entrée de 'a1' a 'h8': ");
                    input = scanner.nextLine().trim(); // Sort les spaces
                    isValid = isValidEntry(input);

                    if (!isValid) {
                        System.out.println("Entrada inválida. Tente novamente.");
                    }
                } while (!isValid);
                tableau.addPeon(joueur2, input);
                }
            }

            scanner.close();

        }

}
