import java.util.ArrayList;
import java.util.List;

public class ManagerCursuri implements OperatiiManagerCursuri {
    private List<Curs> cursuri;

    public ManagerCursuri() {
        this.cursuri = new ArrayList<>();
    }

    @Override
    public void AddCurs(Curs curs) {
        cursuri.add(curs);
    }

    @Override
    public void UpdateCurs(Curs curs) {
        // Implementează actualizarea cursului în listă
    }

    @Override
    public void DeleteCurs(Curs curs) {
        cursuri.remove(curs);
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }
}
