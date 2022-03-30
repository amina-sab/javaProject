
public class chambre {
    int num_ch;
    int etage;
    char type;
    String etat; // soit panne, nettoyage ou

    public chambre(int n, int e, char t) {
        num_ch = n;
        etage = e;
        type = t;
    }

    // afficher le prix de la chambre selon le type
    public int getPrice() {
        int p;
        switch (type) {
            case 'D':
                p = 150;
                break;
            case 'S':
                p = 60;
                break;
            case 'N':
                p = 230;
                break;
            case 'P':
                p = 360;
                break;
            default:
                p = 0;
        }

        return p;
    }

    //

    public String showRoom() {
        return ("numero de chambre: " + num_ch + " , " + " etage: " + etage + " , " + " type: " + type);
    }

}
