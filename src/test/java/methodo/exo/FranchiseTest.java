package methodo.exo;


import static org.junit.Assert.*;

import org.junit.Test;

public class FranchiseTest {
    // Pour 2 restaurants, il peut y avoir 0, 1, 2, ou 1000 serveurs, donc 4 cas possibles à tester.
    int nbCas = 4;
    // prix de la commande pour ce scope de test
    double commande = 7.5;
    // nombre de serveurs, est modifié dans les différents cas
    int nbServeurs = 0;
    
    @Test
    public void ZeroRestaurants() {
        int nbRestaurants = 0;

        // ETANT DONNE une franchise ayant 0 restaurants et 0 serveurs
        Franchise mcDonnalds = new Franchise(nbRestaurants);
        
        // QUAND tous les restaurants prennent Y commande d'un montant
        for (int i = 0; i < nbCas; i++) 
        {
            // Gestion d'erreur car pas de restaurants
            switch (i) {
                // Cas 0 serveurs
                case 0 :
                nbServeurs = 0;
                try {
                    mcDonnalds.FranchiseCommander(nbServeurs, commande);
                } catch (Exception e) {
                    // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                    assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                }
                break;
    
                // Cas 1 serveur
                case 1 :
                nbServeurs = 1;
                try {
                    mcDonnalds.FranchiseCommander(nbServeurs, commande);
                } catch (Exception e) {
                    // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                    assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                }
                break;
    
                // Cas 2 serveurs
                case 2 :
                nbServeurs = 2;
                try {
                    mcDonnalds.FranchiseCommander(nbServeurs, commande);
                } catch (Exception e) {
                    // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                    assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                }
                break;
    
                // Cas 1000 serveurs
                case 3 :
                nbServeurs = 1000;
                try {
                    mcDonnalds.FranchiseCommander(nbServeurs, commande);
                } catch (Exception e) {
                    // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                    assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                }
                break;
            }
        }
    }

    @Test
    public void UnRestaurant() {
        int nbRestaurants = 1;

        // ETANT DONNE une franchise ayant 1 restaurants et 0 serveurs
        Franchise mcDonnalds = new Franchise(nbRestaurants);
        
        // QUAND tous les restaurants prennent Y commande d'un montant
        for (int i = 0; i < nbCas; i++) 
        {
            // Gestion d'erreur car pas de restaurants
            switch (i) {
                // Cas 0 serveurs
                case 0 :
                nbServeurs = 0;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);

                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 1 serveur
                case 1 :
                nbServeurs = 1;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);

                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 2 serveurs
                case 2 :
                nbServeurs = 2;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);
                
                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 1000 serveurs
                case 3 :
                nbServeurs = 1000;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);
                
                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
            }
        }
    }

    @Test
    public void DeuxRestaurants() {
        int nbRestaurants = 2;

        // ETANT DONNE une franchise ayant 1 restaurants et 0 serveurs
        Franchise mcDonnalds = new Franchise(nbRestaurants);
        
        // QUAND tous les restaurants prennent Y commande d'un montant
        for (int i = 0; i < nbCas; i++) 
        {
            // Gestion d'erreur car pas de restaurants
            switch (i) {
                // Cas 0 serveurs
                case 0 :
                nbServeurs = 0;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);

                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 1 serveur
                case 1 :
                nbServeurs = 1;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);

                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 2 serveurs
                case 2 :
                nbServeurs = 2;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);
                
                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 1000 serveurs
                case 3 :
                nbServeurs = 1000;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);
                
                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
            }
        }
    }

    @Test
    public void MilleRestaurants() {
        int nbRestaurants = 1000;

        // ETANT DONNE une franchise ayant 1 restaurants et 0 serveurs
        Franchise mcDonnalds = new Franchise(nbRestaurants);
        
        // QUAND tous les restaurants prennent Y commande d'un montant
        for (int i = 0; i < nbCas; i++) 
        {
            // Gestion d'erreur car pas de restaurants
            switch (i) {
                // Cas 0 serveurs
                case 0 :
                nbServeurs = 0;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);

                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 1 serveur
                case 1 :
                nbServeurs = 1;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);

                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 2 serveurs
                case 2 :
                nbServeurs = 2;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);
                
                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
    
                // Cas 1000 serveurs
                case 3 :
                nbServeurs = 1000;
                mcDonnalds.FranchiseCommander(nbServeurs, commande);
                
                // ALORS le chiffre d'affaires du restaurant est X * Y * Z
                assertEquals("is C.A == X*Y*Z ?", commande * nbRestaurants * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
                break;
            }
        }
    }
}
