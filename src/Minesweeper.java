public class Minesweeper {

    public static void main(String[] args) {
        Kasutaja p = new Kasutaja();
        int suurus = p.küsi("Sisestage soovitud välja suurus: ");
        Väli väli = new Väli(suurus, 20);
        väli.väljasta();

        do {
            // Küsitakse kasutajalt rida ja veerg
            int rida = p.küsi("Sisesta rida: ");
            int veerg = p.küsi("Sisesta veerg: ");

            // Valitakse väljalt element ja kontrollitakse millega tegu on
            Miinid valik = väli.getElement(rida, veerg);
            valik.setNähtav(true);
            väli.väljasta();
            if (valik.isMiin()) p.setElus(false);
        } while (p.isElus() && väli.eiLeiduNähtav());

        if (p.isElus()) System.out.println("Võitsite!");
        else System.out.println("Kaotasite");
    }
}
