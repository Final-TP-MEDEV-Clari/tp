package com.mycompany.othello;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Clara et Larissa
 */
public class Joueur {
    private String nom;
    private boolean couleur; // True: Branco; False: Preto
    private Tableau tableau;
    private List<int[]> peutJouerPositions; // Lista de posições jogáveis

    /**
     * Constructeur par défaut Joueur
     */
    public Joueur() {
        this.nom = "";
        this.couleur = false;
        this.peutJouerPositions = new ArrayList<>();
    }

    /**
     * Getter PeutJouerPositions
     * @return Liste des positions jouables
     */
    public List<int[]> getPeutJouerPositions() {
        return peutJouerPositions;
    }

    
    public boolean isPeutJouer() {
        return peutJouer;
    }

    /**
     * Setter PeutJouer
     * @param peutJouer
     */
    public void setPeutJouer(boolean peutJouer) {
        this.peutJouer = peutJouer;
    }

    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }
    
    /**
     * Calcule si le joueur peut joueur selon les regles du jeu.
     */
    public void calculPeutJouer() {
        peutJouerPositions.clear(); // Limpa a lista antes de recalcular
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tableau.peutPlacer(this, i, j)) {
                    peutJouerPositions.add(new int[] {i, j});
                }
            }
        }
    }

    /**
     * Verifica se o jogador pode jogar (baseado na lista de posições)
     * @return true se houver pelo menos uma posição jogável, false caso contrário
     */
    public boolean peutJouer() {
        return !peutJouerPositions.isEmpty();
    }

    public void afficherPossibilites() {
        List<int[]> possibilites = this.getPeutJouerPositions();

        if (possibilites.isEmpty()) {
            System.out.println(this.getNom() + ", vous n'avez aucune possibilité de jouer.");
            return;
        }

        System.out.println(this.getNom() + ", vous pouvez jouer aux positions suivantes :");
        for (int[] position : possibilites) {
            // Converte x para letra ('a' + coluna)
            char lettre = (char) ('a' + position[0]);
            // Converte y para número (linha + 1)
            int numero = position[1] + 1;

            System.out.println(lettre + "" + numero);
        }
    }

    public boolean getPeutJouer() {
        if (peutJouerPositions.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Setter Tableau
     * @param tableau Le tableau de jeu
     */
    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }

    /**
     * Getter Nom
     * @return Le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter Nom
     * @param nom Le nom du joueur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter Couleur
     * @return La couleur du joueur
     */
    public boolean getCouleur() {
        return couleur;
    }

    /**
     * Setter Couleur
     * @param couleur La couleur du joueur
     */
    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }
}
