package methodo.exo;

import java.util.ArrayList;
import java.util.List;

public class MaitreHotel {
    private List<Table> _tables;

    public void PrendreTables(List<Table> tables) {
        this._tables = tables;
    }

    public int GetNbTables() {
        return this._tables.size();
    }

    public List<Table> GetTables() {
        return this._tables;
    }

    // ctor
    public MaitreHotel() {
        this._tables = new ArrayList<Table>();
    }
}
