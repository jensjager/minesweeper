import java.util.Arrays;

public class Väli {

    // Isendiväli
    private Ruudud[][] väli;
    private int suurus;

    // Konstruktor
    public Väli(int suurus, int protsent) {
        this.suurus = suurus;
        väli = new Ruudud[suurus][suurus];
        looVäli(protsent);
        väärtustaTühjad();
    }

    // Meetodid
    public Ruudud getRuut(int i, int j) {
        return väli[i][j];
    }

    // Meetod loob väljale Miinid
    public void looVäli(int protsent) {
        for (int i = 0; i < suurus; i++) {
            for (int j = 0; j < suurus; j++) {
                if ((int) (Math.random() * 100) < protsent)
                    väli[i][j] = new Miin();
                else
                    väli[i][j] = new TühiRuut();
            }
        }
    }

    // Meetod väärtustab tühjad ruudud arvuga, mis näitab, mitu miinist naabrit neil on
    public void väärtustaTühjad() {
        for (int i = 0; i < suurus; i++) {
            for (int j = 0; j < suurus; j++) {
                if (väli[i][j].isMiin()) continue;
                väli[i][j].setMitu(leiaVäärtus(i, j));
            }
        }
    }

    // Meetod leiab indeksitel i ja j asuva elemendi kõrvutiste miinide arvu
    public int leiaVäärtus(int i, int j) {
        int kokku = 0;
        for (int k = i - 1; k < i + 2 && k < suurus; k++) {
            for (int l = j - 1; l < j + 2 && l < suurus; l++) {
                if (k < 0) k = 0;
                if (l < 0) l = 0;
                if (k == i && l == j) continue;
                if (väli[k][l].isMiin()) kokku++;
            }
        }
        return kokku;
    }

    // Meetod väljastab hetkelise välja ekraanile
    public void väljasta() {
        if (suurus > 10)
            System.out.print("      ");
        else
            System.out.print("     ");
        for (int i = 0; i < suurus; i++) {
            if (suurus > 10 && i > 8)
                System.out.print(i + " ");
            else System.out.print(i + "  ");
        }
        System.out.print("\n");

        for (int i = 0; i < suurus; i++) {
            if (suurus > 10 && i < 10) System.out.println(i + " -  " + Arrays.toString(väli[i]));
            else System.out.println(i + " - " + Arrays.toString(väli[i]));
        }
    }

    // Meetod muudab kõik ruudud nähtavaks
    public void kõikNähtav() {
        for (int i = 0; i < suurus; i++) {
            for (int j = 0; j < suurus; j++) {
                väli[i][j].setNähtav();
            }
        }
    }

    // Meetod kontrollib varjatud tühjade ruutude olemasolu
    public boolean eiLeiduNähtav() {
        for (int i = 0; i < suurus; i++) {
            for (int j = 0; j < suurus; j++) {
                if (!väli[i][j].isNähtav() && !väli[i][j].isMiin()) return true;
            }
        }
        return false;
    }

    // Meetod avaldab varjatud ruudu
    public void avaldaTühjad(int rida, int veerg) {
        Ruudud ruut = väli[rida][veerg];
        if (!ruut.isNähtav()) {
            ruut.setNähtav();
        }

        // Kui tühi ruut ei puuduta ühtegi miini, siis avaldatakse ka tema naaberruudud
        if (ruut.getMitu() == 0) {
            for (int i = rida - 1; i < rida + 2 && i < väli.length; i++) {
                if (i < 0) i = 0;
                for (int j = veerg - 1; j < veerg + 2 && j < väli.length; j++) {
                    if (j < 0) j = 0;
                    if (i == rida && j == veerg) continue;
                    if (!väli[i][j].isNähtav()) avaldaTühjad(i, j);
                }
            }
        }
    }
}
