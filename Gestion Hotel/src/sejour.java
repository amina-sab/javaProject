import java.time.LocalDate;
import java.util.ArrayList;

public class sejour {
    int id_sejour;
    int id_client;
    LocalDate sejour_deb;
    LocalDate sejour_fin;
    ArrayList<Integer> minibar = new ArrayList<Integer>();
    int bill;

    public void addConso(int conso) {
        minibar.add(conso);
    }

    public int sumConso() {
        int c = 0;
        for (Integer achat : minibar) {
            c += achat;
        }
        return c;
    }
    public int getBill(){
        return bill;
    }

}
