public class TühiRuut extends Ruudud {

    // Konstruktor
    public TühiRuut() {
        super(false);
    }

    // Ülekate
    @Override
    public String toString() {
        if (isNähtav()) {
            if (getMitu() > 0) return "\u001B[3" + (getMitu() + 2) + "m" + getMitu() + "\u001B[0m";
            else return "-";
        }
        return super.toString();
    }
}
