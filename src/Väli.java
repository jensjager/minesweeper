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
    public int getSuurus() {
        return suurus;
    }

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
        System.out.print("     ");
        for (int i = 0; i < suurus; i++) {
            System.out.print(i + "  ");
        }
        System.out.print("\n");

        for (int i = 0; i < suurus; i++) {
            System.out.println(i + " - " + Arrays.toString(väli[i]));
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

    // Meetod avab kõrvalolevad lahtrid juhul kui valitud ruudul polnud ühtegi miini kõrval
    public void avaldaTühjad(int rida, int veerg, Miinid valik){
        if (!valik.isNähtav()){
            valik.setNähtav(true);
        }
        if (valik.getMitu() == 0){
            for (int i = rida-1; i < rida+2 && i<väli.length; i++) {
                for (int j = veerg-1; j < veerg+2 && j<väli.length; j++) {
                    if (i<0) i = 0;
                    if (j<0) j = 0;
                    if (i == rida && j == veerg) continue;
                    if (!väli[i][j].isNähtav()) avaldaTühjad(i,j,väli[i][j]);
                }
            }
        }
    }
}
