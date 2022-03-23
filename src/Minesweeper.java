public class Minesweeper {

    public static void main(String[] args) {
        // Luuakse mängija isend
        Kasutaja mängija = new Kasutaja();
        boolean mäng = true;
        mängija.algusTekst();

        // Antud do tsükkel laseb mänge uuesti mängida
        do {
            // Mängu algsättimine
            mängija.setElu(true);
            int suurus = mängija.küsiArv("Sisestage soovitud välja suurus (soovitatav <= 12): ", 1, 100);
            Väli väli = new Väli(suurus, 20);
            väli.väljasta();

            // Mängu tsükkel
            do {
                // Küsitakse kasutajalt rida ja veerg
                int rida = mängija.küsiArv("Sisesta rida: ", 0, suurus - 1);
                int veerg = mängija.küsiArv("Sisesta veerg: ", 0, suurus - 1);


                // Väljal tehakse valitud ruut nähtavaks
                väli.avaldaTühjad(rida, veerg);

                // Kui tegu oli miiniga, siis mäng lõpetatakse
                if (väli.getRuut(rida, veerg).isMiin()) {
                    mängija.setElu(false);
                    väli.kõikNähtav();
                }
                väli.väljasta();

              // Mäng kestab niikaua kui mängija on elus või kui kõik tühjad ruudud on avaldatud
            } while (mängija.isElu() && väli.eiLeiduNähtav());

            // Kui mängija jäi mängu lõpuks ellu, siis ta võitis
            if (mängija.isElu()) System.out.println("Võitsite!");
            else System.out.println("Kaotasite");

            // Kui kasutaja ei soovi enam mängida, siis lõpetatakse mäng
            char valik = mängija.küsiChar("Kas soovite uuesti mängida (y/n): ");
            if (valik == 'n') mäng = false;
        } while(mäng);
    }
}
