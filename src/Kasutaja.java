import java.util.Scanner;

public class Kasutaja {

    // Isendiväli
    private boolean elu;
    private Scanner sc = new Scanner(System.in);

    // Meetodid
    public boolean isElu() {
        return elu;
    }

    public void setElu(boolean elu) {
        this.elu = elu;
    }

    public void algusTekst() {
        System.out.println("Minesweeper");
        System.out.println("Mängijale on ette antud varjatud väli, kus osad ruudud on miinid.");
        System.out.println("Mängu eesmärgiks on nähtavaks muuta kõik tühjad ruudud,");
        System.out.println("kasutades ära fakti, et tühjad ruudud näitavad mitut miini nad puudutavad.");
        System.out.println("Mängija võidab mängu, kui kõik tühjad ruudud on nähtavad.\n");
    }

    // Meetod küsib kasutajalt sisendit
    public int küsiArv(String sõne, int minSuurus, int maxSuurus) {
        System.out.println(sõne);
        int arv = Integer.parseInt(sc.nextLine());

        // Kui tegemist on vigase sisendiga, väljastatakse teade
        // ning küsitakse uuesti
        if (minSuurus <= arv && arv <= maxSuurus) return arv;
        System.out.println("Vigane sisend!");
        return küsiArv(sõne, minSuurus, maxSuurus);
    }

    // Meetod küsib kasutajalt sisendit
    public char küsiChar(String sõne) {
        System.out.println(sõne);
        String sõna = sc.nextLine();

        // Kui tegemist on vigase sisendiga, väljastatakse teade
        // ning küsitakse uuesti
        if (sõna.length() == 1 && (sõna.charAt(0) == 'y' || sõna.charAt(0) == 'n')) return sõna.charAt(0);
        System.out.println("Vigane sisend!");
        return küsiChar(sõne);
    }
}
