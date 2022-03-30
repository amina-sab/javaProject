import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class reservation {
    int id_reserv;
    int num_ch;
    chambre ch;
    int id_client;
    LocalDate reserv_debut;
    LocalDate reserv_fin;

    public reservation(int ch, int cl, LocalDate deb, LocalDate fin) {
        num_ch = ch;
        id_client = cl;
        reserv_debut = deb;
        reserv_fin = fin;
    }

    public void setDateReserv(LocalDate deb, LocalDate fin) {
        if (deb == null) {
            reserv_fin = fin;
        } else if (fin == null) {
            reserv_debut = deb;
        } else {
            reserv_debut = deb;
            reserv_fin = fin;
        }

    }

    public long getDays() {
        return ChronoUnit.DAYS.between(reserv_debut, reserv_fin);
    }

    public int getCout() {

        return ch.getPrice() * (int) getDays();
    }

}