package methodo.exo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenusTest {
    @Test 
    public void Menus() {
        // ETANT DONNE un restaurant ayant le status de filiale
        int indexPlat = 0;
        double oldPrix = 5.5;
        double newPrix = 7.7;
        Franchise subway = new Franchise();
        Restaurant resto = new Restaurant(subway);

        // ET une franchise définissant un menu ayant un plat
        Plat plat = new Plat(indexPlat, oldPrix);
        subway.AddPlat(plat);

        // QUAND la franchise modifie le prix de plat
        subway.ModifPrixPlat(indexPlat, newPrix);

        // ALORS le prix du plat dans le menu du restaurant est celui défini par la franchise
        assertEquals(subway.GetMenu().get(indexPlat).getPrix(), resto.GetMenu().get(indexPlat).getPrix(), 0);

    }

    @Test
    public void MenusRestaurant() {
        //	ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
        int indexPlat = 0;
        double prix = 5.5;
        Franchise mcDonnalds = new Franchise();
        Restaurant resto = new Restaurant(mcDonnalds);
        Plat pates = new Plat(indexPlat, prix );

        resto.AddPlat(pates);

        // ET une franchise définissant un menu ayant le même plat
        mcDonnalds.AddPlat(pates);

        // 	QUAND la franchise modifie le prix du plat
        double newPrix = 7.5;
        mcDonnalds.ModifPrixPlat(indexPlat, newPrix);

        // 	ALORS le prix du plat dans le menu du restaurant reste inchangé
        assertEquals(prix, resto.GetMenu().get(indexPlat).getPrix(), 0);
    }

    @Test
    public void FranchiseRestaurantMenu() {
        // ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
        int indexPlatResto = 0;
        double prixResto = 5.5;
        Franchise mcDonnalds = new Franchise();
        Restaurant resto = new Restaurant(mcDonnalds);
        Plat pates = new Plat(indexPlatResto, prixResto );

        resto.AddPlat(pates);
	    // QUAND la franchise ajoute un nouveau plat
        int indexPlatFracnhise = 1;
        double prixFranchise = 7.5;
        mcDonnalds.AddPlat(new Plat(1, prixFranchise));

        // ALORS la carte du restaurant propose le premier plat au prix du restaurant et le second au prix de la franchise
        assertEquals(prixResto, resto.GetMenu().get(indexPlatResto).getPrix(), 0);
        assertEquals(prixFranchise, resto.GetMenu().get(indexPlatFracnhise).getPrix(), 0);
    }


}
