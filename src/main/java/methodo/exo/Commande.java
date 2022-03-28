package methodo.exo;

public class Commande {
    private Serveur _serveur;
    private boolean _estPayee;
    private boolean _estImpinglee;
    private boolean _estATransmettre;
    private boolean _estTransmise;
    private int _joursImpayee;

    public Commande(Serveur serveur) {
        this._serveur = serveur;
        this._estPayee = false;
        this._estImpinglee = false;
        this._estATransmettre = false;
        this._joursImpayee = 0;
    }

    public void SetEstPayee(boolean payee) {
        this._estPayee = payee;
    }

    public boolean EstATransmettre() {
        return this._estATransmettre;
    }

    public void SetEpinglee() {
        this._estImpinglee = true;
    }

    public boolean isEpinglee() {
        return this._estImpinglee;
    }

    public void SetJourImpayee(int nbJours) {
        this._joursImpayee = nbJours;
        if (nbJours >= 15) {
            this._estATransmettre = true;
            _serveur.PasserCommandeRestaurant(this);
        }
    }

    public int GetNbJoursImpayee() {
        return this._joursImpayee;
    } 

    public boolean IsTransmise() {
        return this._estTransmise;
    }

    public void SetTransmise() {
        this._estTransmise = true;
    }

    
}
