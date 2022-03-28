package methodo.exo;

public class Plat  {
    private int _id;
    private double _prix;

    public Plat(int id, double prix){
        this._id = id;
        this._prix = prix;
    }

    public double getPrix(){
        return _prix;
    }

    public void setPrix(double nouveauPrix) {
        this._prix = nouveauPrix;
    }

    public int getId() {
        return this._id;
    }
}