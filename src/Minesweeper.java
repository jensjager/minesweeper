import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {
        Väli väli = new Väli(10, 20);
        Scanner sc = new Scanner(System.in);
        väli.väljasta();

        while (true){
            System.out.println("Sisesta rida: ");
            int rida = Integer.parseInt(sc.nextLine());
            System.out.println("Sisesta veerg: ");
            int veerg = Integer.parseInt(sc.nextLine());
            Ruut valik = väli.getElement(rida, veerg);
            if (valik.getMiin()) break;
            valik.setNähtav(true);
            väli.väljasta();
        }
    }
}
