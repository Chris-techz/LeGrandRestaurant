package methodo.exo;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestaurantTest {
    double prixCommande = 1.0;

    @Test
    public void ZeroServeurs() {
        // ETANT DONNE un restaurant ayant 0 serveurs
        Restaurant mcDonnalds = new Restaurant(0);

        // QUAND tous les serveurs prennent une commande d'un montant Y
        double commande = 5.5;
        // gestion d'erreur, car accès a un serveur qui n'existe pas
        try {
            mcDonnalds.GetServeur(0).PrendreCommande(commande);
        } catch (Exception e) {
            System.err.println("Il n'y a aucun serveur dans ce restaurant !");
        }

        // ALORS le chiffre d'affaires du restaurant est X * Y
        assertEquals("is C.A == X*Y ?", 0, mcDonnalds.GetChiffreAffaire(), 0);
    }

    @Test
    public void UnServeur() {
        // ETANT DONNE un restaurant ayant 1 serveurs
        Restaurant kfc = new Restaurant(1);
        
        // QUAND tous les serveurs prennent une commande d'un montant Y
        double commande = 5.5;
        kfc.TousLesServeursPrennentCommande(commande);

        // ALORS le chiffre d'affaires du restaurant est X * Y
        assertEquals("is C.A == X*Y ?", kfc.GetNbServeurs()*commande, kfc.GetChiffreAffaire(), 0);

    }

    @Test 
    public void DeuxServeurs() {
        // ETANT DONNE un restaurant ayant 2 serveurs
        Restaurant quick = new Restaurant(2);
        
        // QUAND tous les serveurs prennent une commande d'un montant Y
        double commande = 5.5;
        quick.TousLesServeursPrennentCommande(commande);

        // ALORS le chiffre d'affaires du restaurant est X * Y
        assertEquals("is C.A == X*Y ?", quick.GetNbServeurs()*commande, quick.GetChiffreAffaire(), 0);

    }

    @Test 
    public void CentServeurs() {
        // ETANT DONNE un restaurant ayant 100 serveurs
        Restaurant quick = new Restaurant(100);
        
        // QUAND tous les serveurs prennent une commande d'un montant Y
        double commande = 5.5;
        quick.TousLesServeursPrennentCommande(commande);

        // ALORS le chiffre d'affaires du restaurant est X * Y
        assertEquals("is C.A == X*Y ?", quick.GetNbServeurs()*commande, quick.GetChiffreAffaire(), 0);

    }

}
