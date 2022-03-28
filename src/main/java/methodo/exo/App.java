package methodo.exo;

// used to debug
public class App
{
    public static void main( String[] args )
    {
        int nbTables = 3;
        int nbServeurs = 2;
        Restaurant burgerKing = new Restaurant(nbServeurs);

        burgerKing.SetTables(nbTables);
        burgerKing.AssigneTableServeur(0, 0);

        // ET ayant débuté son service
        burgerKing.DebutService();

        // QUAND le service se termine
        burgerKing.FinService();

        // ET que cette table est assignée a un second serveur
        burgerKing.AssigneTableServeur(1, 0);
    }
}
