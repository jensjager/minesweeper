public class TühiMiin implements Miinid {

    // Isendiväljad
    private boolean miin;
    private boolean nähtav;
    private int mitu;

    // Konstruktor
    public TühiMiin() {
        miin = false;
        nähtav = false;
        mitu = 0;
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
    public int getMitu() {
        return mitu;
    }

    @Override
    public void setMitu(int mitu) {
        this.mitu = mitu;
    }

    @Override
    public String toString() {
        if (nähtav) {
            if (mitu > 0) return Integer.toString(mitu);
            else return " ";
        }
        return "?";
    }
}
