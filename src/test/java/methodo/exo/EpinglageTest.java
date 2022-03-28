package methodo.exo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EpinglageTest {
    @Test 
    public void Epinglage() {
        // ETANT DONNE un serveur ayant pris une commande
        int indexCommande = 0;
        Restaurant resto = new Restaurant(1);
        Serveur jean = resto.GetServeurs().get(0);
        jean.PrendreCommande();

        // QUAND il la déclare comme non payée
        jean.SetCommandeNonPayee(indexCommande);

        // ALORS cette commande est marquée comme épinglée
        assertEquals(true, jean.GetCommandes().get(indexCommande).isEpinglee());

        // ETANT DONNE un serveur ayant  épinglé une commande
        // QUAND elle date d'il y a au moins 15 jours
        jean.GetCommandes().get(indexCommande).SetJourImpayee(17);

        // ALORS cette commande est marquée comme à transmettre a la gendarmerie
        assertEquals(true, jean.GetCommandes().get(indexCommande).EstATransmettre());

        // ETANT DONNE une commande a transmettre a la gendarmerie
        // QUAND on consulte la liste a transmettre du restaurant
        // ALORS elle y figure
        assertEquals(jean.GetCommandes().get(indexCommande), resto.GetCommandesATransmettre().get(indexCommande));

        // ÉTANT DONNE une commande à transmettre gendarmerie
	    // QUAND elle est marquée comme transmise à la gendarmerie
        resto.TransmettreCommande(indexCommande);
	    // ALORS elle ne figure plus dans la liste des commandes à transmettre du restaurant
        assertEquals(0, resto.GetCommandesATransmettre().size());
    }
}
