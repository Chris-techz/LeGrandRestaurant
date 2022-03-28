package methodo.exo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandeTest {
    @Test
    public void CommandeCuisineNourriture() {
        // 	ÉTANT DONNE un serveur dans un restaurant
        int indexNourriture = 0;
        Restaurant resto = new Restaurant(1);
        Serveur jean = resto.GetServeurs().get(0);

        // 	QUAND il prend une commande de nourriture
        Commande kebab = new Commande(jean);
        jean.PrendreCommandeNourriture(kebab);

        // ALORS cette commande apparaît dans la liste de tâches de la cuisine de ce restaurant
        assertEquals(kebab, resto.GetCuisine().GetCommandes().get(indexNourriture));
    }

    @Test
    public void CommandeCuisineBoisson() {
        // 	ÉTANT DONNE un serveur dans un restaurant
        Restaurant resto = new Restaurant(1);
        Serveur jc = resto.GetServeurs().get(0);

        // 	QUAND il prend une commande de nourriture
        Commande doublePastis = new Commande(jc);
        jc.PrendreCommandeBoisson(doublePastis);

        // ALORS cette commande apparaît dans la liste de tâches de la cuisine de ce restaurant
        assertEquals(0, resto.GetCuisine().GetCommandes().size());
    }


}
