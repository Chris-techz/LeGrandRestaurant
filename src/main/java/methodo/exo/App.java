package methodo.exo;

// used to debug
public class App
{
    public static void main( String[] args )
    {
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

        resto.GetMenu().get(indexPlat).getPrix();
        
    }
}
