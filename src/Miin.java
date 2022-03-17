public class Miin implements Miinid {

    // Isendiväljad
    private boolean miin;
    private boolean nähtav;

    // Konstruktor
    public Miin() {
        miin = true;
        nähtav = false;
    }

    // Meetodid
    @Override
    public boolean isNähtav() {
        return nähtav;
    }

    @Override
    public void setNähtav(boolean nähtav) {
        this.nähtav = nähtav;
    }

    @Override
    public boolean isMiin() {
        return miin;
    }

    @Override
    public void setMitu(int mitu) {
    }

    @Override
    public int getMitu() {
        return 0;
    }

    @Override
    public String toString() {
        if (nähtav) return "M";
        return "?";
    }
}
