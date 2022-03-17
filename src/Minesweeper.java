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
            if (rida >= väli.getSuurus() || veerg >= väli.getSuurus()) {
                System.out.println("Vigane sisend");
                continue;
            }

            // Valitakse väljalt element, tehakse see nähtavaks
            // ning seejärel väljastatakse uus väli
            Miinid valik = väli.getElement(rida, veerg);
            valik.setNähtav(true);
            väli.väljasta();

            // Kui tegu oli miiniga, siis mäng lõpetatakse
            if (valik.isMiin()) p.setElus(false);
        } while (p.isElus() && väli.eiLeiduNähtav());

        if (p.isElus()) System.out.println("Võitsite!");
        else System.out.println("Kaotasite");
    }
}
