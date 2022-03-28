package methodo.exo;

import static org.junit.Assert.*;

import org.junit.Test;

public class DebutServiceTest {
    
    @Test
    public void AffecterTablesAuMaitreTest() {

        // ETANT DONNE un restaurant ayant 3 tables
        int nbTables = 3;
        Restaurant kfc = new Restaurant();
        kfc.SetTables(nbTables);
        kfc.AssigneTableMaitre();

        // QUAND le service commence
        kfc.DebutService(true);
        
        // ALORS elles sont toutes affectées au maitre d'hotel
        assertEquals(nbTables, kfc.GetMaitre().GetNbTables());
    }

    @Test
    public void AffecterUneTableServeur() {

        // ETANT DONNE un restaurant ayant 3 tables dont une affectées à un serveur
        int nbTables = 3;
        int nbServeurs = 1;
        Restaurant mcDonnalds = new Restaurant(nbServeurs);
        mcDonnalds.SetTables(nbTables);
        // assigne au serveur id=0 la table id=0
        mcDonnalds.AssigneTableServeur(0, 0);
        mcDonnalds.AssigneTableMaitre();
        
        // QUAND le service débute
        mcDonnalds.DebutService(true);

        // ALORS cette table est toujours affecée au serveur et les deux autres au maître d'hotel
        assertEquals(1, mcDonnalds.GetServeurs().get(0).GetTables().size());
        assertEquals(2, mcDonnalds.GetMaitre().GetNbTables());
    }

    @Test
    public void ModificationPendantService() {
        // ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un serveur
        int nbTables = 3;
        int nbServeurs = 2;
        Restaurant mcDonnalds = new Restaurant(nbServeurs);
        mcDonnalds.SetTables(nbTables);
        // assigne au serveur id=0 la table id=0
        mcDonnalds.AssigneTableServeur(0, 0);

        // QUAND le service débute
        mcDonnalds.DebutService(true);

        // ALORS il n'est pas possible de modifier le serveur affecté aux tables
        try {
            mcDonnalds.AssigneTableServeur(1, 0);
        } catch (Exception e) {
            assertEquals(0, mcDonnalds.GetServeurs().get(1).GetTables().size());
        }
    }

    @Test
    public void ModificationFinService() {
        // ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un premier serveur
        int nbTables = 3;
        int nbServeurs = 2;
        Restaurant burgerKing = new Restaurant(nbServeurs);

        burgerKing.SetTables(nbTables);
        burgerKing.AssigneTableServeur(0, 0);
        burgerKing.AssigneTableMaitre();

        // ET ayant débuté son service
        burgerKing.DebutService(true);

        // QUAND le service se termine
        burgerKing.FinService();

        // ET que cette table est assignée a un second serveur
        burgerKing.AssigneTableServeur(1, 0);
        burgerKing.AssigneTableMaitre();

        // ALORS la table est affectée au serveur et les deux autres au maître d'hôtel
        // est-ce que l'id de la table du serveur 1 est bien 1 ?
        assertEquals(0, burgerKing.GetServeurs().get(1).GetTables().get(0).GetId());
    }
}
