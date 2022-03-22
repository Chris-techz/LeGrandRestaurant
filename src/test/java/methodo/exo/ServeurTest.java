package methodo.exo;

import static org.junit.Assert.*;

import org.junit.Test;

// C.A == Chiffre d'Affaire

public class ServeurTest 
{
    @Test
    public void ChiffreAffaire()
    {      
        // ETANT DONNE un nouveau serveur michel
        Serveur michel = new Serveur();

        // QUAND on recupère son C.A, ALORS il est a 0
        assertEquals("is CA == 0 ?", 0, michel.GetChiffreAffaire(), 0);
    }

    @Test 
    public void Commande() 
    {
        // ETANT DONNE un nouveau serveur jean
        Serveur jean = new Serveur(); 

        // QUAND il prend nouvelle commande
        jean.PrendreCommande(12.5);

        // ALORS son C.A est le montant de celle ci
        assertEquals("is CA == commande ?", 12.5, jean.GetChiffreAffaire(), 0);

        // ETANT DONNE un serveur ayant déjà pris une commande, jean

        // QUAND il prend une nouvelle commande
        jean.PrendreCommande(5.5);

        // ALORS son C.A vaut la somme des deux commande
        assertEquals("is CA == somme ?", 12.5 + 5.5, jean.GetChiffreAffaire(), 0);
    }
}
