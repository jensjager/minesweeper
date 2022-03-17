import java.util.Scanner;

public class Kasutaja {

    // Isendiväli
    private boolean elus;
    private String sõne;
    private Scanner sc = new Scanner(System.in);

    // Konstruktor
    public Kasutaja() {
        this.elus = true;
    }

    // Meetodid
    public boolean isElus() {
        return elus;
    }

    public void setElus(boolean elus) {
        this.elus = elus;
    }

    // Meetod küsib kasutajalt sisendit
    public int küsi(String sõne) {
        System.out.println(sõne);
        return Integer.parseInt(sc.nextLine());
    }
}
