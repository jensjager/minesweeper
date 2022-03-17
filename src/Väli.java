import java.util.Arrays;

public class Väli {

    private Ruut[][] väli;

    public Väli(int suurus, int protsent) {
        if (suurus < 1) throw new RuntimeException("Väli ei saa olla väiksem kui 1");
        väli = new Ruut[suurus][suurus];
        looVäli(protsent);
        getMitu();
    }

    public void looVäli(int protsent) {
        for (int i = 0; i < väli.length; i++) {
            for (int j = 0; j < väli[i].length; j++) {
                if ((int) (Math.random()*100) < protsent) {
                    väli[i][j] = new Ruut(true);
                }
                else {
                    väli[i][j] = new Ruut(false);
                }
            }
        }
    }

    public void väljasta() {
        for (Ruut[] ruut : väli) {
            System.out.println(Arrays.toString(ruut));
        }
    }
    // Ajutine!!
    public void kõikNähtav() {
        for (Ruut[] ruut : väli) {
            for (int j = 0; j < väli.length; j++) {
                ruut[j].setNähtav(true);
            }
        }
    }

    public void getMitu() {
        for (int i = 0; i < väli.length; i++) {
            for (int j = 0; j < väli[i].length; j++) {
                if (väli[i][j].getMiin()) continue;
                int kokku = 0;
                for (int k = i - 1; k < i + 2 && k < väli.length; k++) {
                    for (int l = j - 1; l < j + 2 && l < väli[i].length; l++) {
                        if (k < 0) k = 0;
                        if (l < 0) l = 0;
                        if (k == i && l == j) continue;
                        if (väli[k][l].getMiin()) kokku++;
                    }
                }
                väli[i][j].setMitu(kokku);
            }
        }
    }

    public Ruut getElement(int rida, int veerg){
        return väli[rida][veerg];
    }
}
