import java.util.Arrays;

public class Väli {

    // Isendiväli
    private Miinid[][] väli;
    private int suurus;

    // Konstruktor
    public Väli(int suurus, int protsent) {
        if (suurus < 1) throw new RuntimeException("Väli ei saa olla väiksem kui 1");
        this.suurus = suurus;
        väli = new Miinid[suurus][suurus];
        looVäli(protsent);
        väärtustaTühjad();
    }

    // Meetodid
    public Miinid getElement(int rida, int veerg){
        return väli[rida][veerg];
    }

    // Meetod loob väljale Miinid
    public void looVäli(int protsent) {
        for (int i = 0; i < suurus; i++) {
            for (int j = 0; j < suurus; j++) {
                if ((int) (Math.random()*100) < protsent)
                    väli[i][j] = new Miin();
                else
                    väli[i][j] = new TühiMiin();
            }
        }
    }

    // Meetod väärtustab mittemiinid arvuga, mis näitab, mitu miini nende kõrval asub
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

    // Meetod väljastab hetkeline välja käsureale
    public void väljasta() {
        for (Miinid[] element : väli) {
            System.out.println(Arrays.toString(element));
        }
    }

    // Ajutine!!
    // Meetod muudab kõik välja elemendid nähtavaks
    public void kõikNähtav() {
        for (Miinid[] element : väli) {
            for (int j = 0; j < suurus; j++) {
                element[j].setNähtav(true);
            }
        }
    }

    // Meetod kontrollib, et leiduks veel nähtamatuid liikmeid
    public boolean eiLeiduNähtav() {
        for (int i = 0; i < suurus; i++) {
            for (int j = 0; j < suurus; j++) {
                if (!väli[i][j].isNähtav() && !väli[i][j].isMiin()) return true;
            }
        }
        return false;
    }
}
