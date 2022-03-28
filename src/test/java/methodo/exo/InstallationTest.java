package methodo.exo;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstallationTest {
    

    @Test
    public void Installation() {

        // ETANT DONNE une table dans un restaurant ayant débuté son service
        Restaurant resto = new Restaurant();
        int indexTable = 0;
        resto.SetTables(1);
        resto.DebutService(false);

        // QUAND un client est affecté à une table
        resto.SetTableOccupee(indexTable);

        // ALORS cette table n'est plus sur la liste des tables libres du restaurant
        assertEquals(0, resto.getTables().size());

        // ÉTANT DONNE une table occupée par un client
	    // QUAND la table est libérée
        resto.LibereTable(indexTable);

	    // ALORS cette table appraît sur la liste des tables libres du restaurant
        assertEquals(1, resto.getTables().size());
    }

    

}
