public class Miin extends Ruudud {

    // Konstruktor
    public Miin() {
        super(true);
    }

    // Ülekate
    @Override
    public String toString() {
        if (isNähtav()) return "\u001B[31m" + "X" + "\u001B[0m";
        return super.toString();
    }
}
