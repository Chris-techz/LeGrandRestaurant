package methodo.exo;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int _nbTables;
    private double _chiffreAffaireRestaurant;
    private List <Table> _tables;
    private List <Table> _tablesOccupees;
    private MaitreHotel _maitreHotel;
    private List <Serveur>_serveurs;
    private List <Commande>_commandesATransmettre;
    private Franchise _franchise;
    private List<Plat> _menu;
    private Cuisine _cuisine;

    public void DebutService(boolean aDesEmployees) {
        if (aDesEmployees)
            this._tables = null;
    }

    public void FinService() {
        this._tables = new ArrayList<Table>();
        List<Table> tablesDesordre = new ArrayList<Table>();
        // Récupère chaque table de chaque serveur
        for (Serveur serveur : _serveurs) {
            for (Table table : serveur.GetTables()) {
                tablesDesordre.add(table);
            }
        }
        // Récupère chaque table du maitre d'hotel
        for (Table table : this._maitreHotel.GetTables()) {
            tablesDesordre.add(table);
        }

        // Range les tables dans l'odre dans la liste du restaurant
        int index = 0;
        int id = 0;
        try {
            while (this._tables.size() != this._nbTables) {
                if (tablesDesordre.get(index).GetId() == id) {
                    this._tables.add(tablesDesordre.get(index));
                    id++;
                    index = 0;
                }
                else {
                    index++;
                }
            }
        } catch (Exception e) {
            System.err.print("Index out of bounds !");
        }
    }

    public List<Serveur> GetServeurs() {
        return this._serveurs;
    }

    public void AssigneTableServeur(int idServeur, int idTable) {
        this._serveurs.get(idServeur).PrendreTable(this._tables.get(idTable));
        this._tables.remove(idTable);
    }

    public void AssigneTableMaitre() {
        this._maitreHotel.PrendreTables(this._tables);
    }

    public void TousLesServeursPrennentCommande(double commande) {
        for (Serveur serveur : _serveurs) {
            serveur.PrendreCommande(commande);
        }
    }

    public void SetServeurs(int nbServeurs) {
        _serveurs.clear();
        for (int i = 0; i < nbServeurs; i++) {
            this._serveurs.add(new Serveur(this));
        }
    }
    
    public MaitreHotel GetMaitre() {
        return this._maitreHotel;
    }

    public List<Table> getTables() {
        return this._tables;
    }

    public void SetTables(int nbTables) {
        this._nbTables = nbTables;
        this._tables.clear();

        for (int i = 0; i < nbTables; i++) {
            this._tables.add(new Table(i));
        }
    }

    public void SetTableOccupee(int indexTable) {
        this._tablesOccupees.add(this._tables.get(indexTable));
        this._tables.remove(indexTable);
    }

    public void LibereTable(int indexTable) {
        this._tables.add(this._tablesOccupees.get(indexTable));
        this._tablesOccupees.remove(indexTable);
    }

    public double GetChiffreAffaire() {
        for (int i = 0; i < GetServeurs().size(); i++) {
            this._chiffreAffaireRestaurant += GetServeurs().get(i).GetChiffreAffaire();
        }
        return this._chiffreAffaireRestaurant;
    }

    // ctor quand un restaurant ouvre avec un nombre donné de serveurs
    public Restaurant(int nbServeurs) {
        this._nbTables = 0;
        this._chiffreAffaireRestaurant = 0;
        this._tables = new ArrayList<Table>();
        this._tablesOccupees = new ArrayList<Table>();
        this._maitreHotel = new MaitreHotel();
        this._serveurs = new ArrayList<Serveur>();
        this._commandesATransmettre = new ArrayList<Commande>();
        this._menu = new ArrayList<Plat>();
        this._cuisine = new Cuisine();

        // Ajout d'un nombre donné de serveurs
        for (int i = 0; i < nbServeurs; i++) {
            this._serveurs.add(new Serveur(this));
        }
    }

    // ctor quand un restaurant ouvre sans serveur
    public Restaurant() {
        this._chiffreAffaireRestaurant = 0;
        this._tables = new ArrayList<Table>();
        this._tablesOccupees = new ArrayList<Table>();
        this._maitreHotel = new MaitreHotel();
        this._serveurs = new ArrayList<Serveur>();
        this._commandesATransmettre = new ArrayList<Commande>();
        this._menu = new ArrayList<Plat>();
        this._cuisine = new Cuisine();
    }

    // ctor bricolage
    public Restaurant(Franchise franchise) {
        this._chiffreAffaireRestaurant = 0;
        this._tables = new ArrayList<Table>();
        this._tablesOccupees = new ArrayList<Table>();
        this._maitreHotel = new MaitreHotel();
        this._serveurs = new ArrayList<Serveur>();
        this._commandesATransmettre = new ArrayList<Commande>();
        this._franchise = franchise;
        this._menu = new ArrayList<Plat>();
        this._cuisine = new Cuisine();
    }

    public void ResetCA() {
        this._chiffreAffaireRestaurant = 0;
    }

    public List<Commande> GetCommandesATransmettre() {
        return this._commandesATransmettre;
    }
    
    public void AddCommandeATranmettre(Commande commande) {
        this._commandesATransmettre.add(commande);
    }

    public void TransmettreCommande(int indexCommande) {
        this._commandesATransmettre.get(indexCommande).SetTransmise();
        this._commandesATransmettre.remove(_commandesATransmettre.get(indexCommande));
    }

    public List<Plat> GetMenu() {
        List<Plat> menuComplet = new ArrayList<Plat>();
        menuComplet.addAll(this._menu);
        menuComplet.addAll(this._franchise.GetMenu());
        return menuComplet;
    }

    public void AddPlat(Plat platToAdd) {
        Plat plat = new Plat(platToAdd.getId(), platToAdd.getPrix());
        this._menu.add(plat);
    }

    public Cuisine GetCuisine() {
        return this._cuisine;
    }
}