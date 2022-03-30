import java.time.LocalDate;

public class reservation {
    int id_reserv;
    int num_ch;
    int id_client;
    LocalDate d_debut;
    LocalDate d_fin;

    public reservation(int ch, int cl, LocalDate deb, LocalDate fin) {
        num_ch = ch;
        id_client = cl;
        d_debut = deb;
        d_fin = fin; 
    }

    public void modifi_reserv(LocalDate deb, LocalDate fin) {
        if (deb == null) {
            d_fin = fin;
        } else if (fin == null) {
            d_debut = deb;
        } else {
            d_debut = deb;
            d_fin = fin;
        }

    }
}
