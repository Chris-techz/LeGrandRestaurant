package methodo.exo;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestaurantTest {
    double commande = 5.5;

    @Test
    public void ZeroServeurs() {
        // ETANT DONNE un restaurant ayant 0 serveurs
        int nbServeurs = 0;
        Restaurant mcDonnalds = new Restaurant(nbServeurs);

        // QUAND tous les serveurs prennent une commande d'un montant Y
        // gestion d'erreur, car accès a un serveur qui n'existe pas
        try {
            mcDonnalds.GetServeur(0).PrendreCommande(commande);
        } catch (Exception e) {
            // ALORS le chiffre d'affaires du restaurant est X * Y
            assertEquals("is C.A == X*Y ?", commande * nbServeurs, mcDonnalds.GetChiffreAffaire(), 0);
        }
    }

    @Test
    public void UnServeur() {
        // ETANT DONNE un restaurant ayant 1 serveurs
        Restaurant kfc = new Restaurant(1);
        
        // QUAND tous les serveurs prennent une commande d'un montant Y
        kfc.TousLesServeursPrennentCommande(commande);

        // ALORS le chiffre d'affaires du restaurant est X * Y
        assertEquals("is C.A == X*Y ?", kfc.GetNbServeurs()*commande, kfc.GetChiffreAffaire(), 0);

    }

    @Test 
    public void DeuxServeurs() {
        // ETANT DONNE un restaurant ayant 2 serveurs
        Restaurant quick = new Restaurant(2);
        
        // QUAND tous les serveurs prennent une commande d'un montant Y
        quick.TousLesServeursPrennentCommande(commande);

        // ALORS le chiffre d'affaires du restaurant est X * Y
        assertEquals("is C.A == X*Y ?", quick.GetNbServeurs()*commande, quick.GetChiffreAffaire(), 0);

    }

    @Test 
    public void CentServeurs() {
        // ETANT DONNE un restaurant ayant 100 serveurs
        Restaurant quick = new Restaurant(100);
        
        // QUAND tous les serveurs prennent une commande d'un montant Y
        quick.TousLesServeursPrennentCommande(commande);

        // ALORS le chiffre d'affaires du restaurant est X * Y
        assertEquals("is C.A == X*Y ?", quick.GetNbServeurs()*commande, quick.GetChiffreAffaire(), 0);

    }

}
