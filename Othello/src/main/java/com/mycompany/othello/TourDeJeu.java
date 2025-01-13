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
        joueur1.setTableau(tableau);
        
        joueur2.setNom("Clara");
        joueur2.setCouleur(true); //true == blanc
        joueur2.setTableau(tableau);
        
        //Debut du jeu
        tableau.init();
        
        while(!tableau.isFull() && joueur1.getPeutJouer() && joueur2.getPeutJouer()){
            tableau.affiche();
            
            //Noir joue en premier
            if(joueur1.getPeutJouer()){
                //joueur noir choissis leur prochain peon
 
                do {
                    joueur1.afficherPossibilites();
                    System.out.print("Entrée de 'a1' à 'h8': ");
                    input = scanner.nextLine().trim(); // Remove espaços em branco
                    isValid = isValidEntry(input);

                    if (!isValid) {
                        System.out.println("Entrée invalide. À nouveau, s'il vous plaît.");
                        continue;
                    }

                    // Converte a entrada 'a1' em coordenadas [x, y]
                    int y = input.charAt(1) - '1'; // Linha (número - 1)
                    int x = input.charAt(0) - 'a'; // Coluna (letra -> índice)

                    // Verifica se a posição está nas possibilidades do jogador
                    boolean isInPossibleMoves = joueur1.getPeutJouerPositions().stream()
                        .anyMatch(pos -> pos[0] == x && pos[1] == y);

                    if (!isInPossibleMoves) {
                        System.out.println("Position non valide. Choisissez parmi les positions disponibles.");
                        isValid = false;
                    }
                } while (!isValid);
                
                tableau.addPeon(joueur1, input);
                joueur2.calculPeutJouer();
                
            }
            
            if(joueur2.getPeutJouer()){
                 tableau.affiche();
                //joueur blanc joue

                do {
                    System.out.print("Entrée de 'a1' a 'h8': ");
                    input = scanner.nextLine().trim(); // Sort les spaces
                    isValid = isValidEntry(input);

                    if (!isValid) {
                        System.out.println("Entree invalide. à nouveau svp.");
                    }
                } while (!isValid);
                tableau.addPeon(joueur2, input);
                joueur1.calculPeutJouer();
            }
        }
            scanner.close();

    }

}
