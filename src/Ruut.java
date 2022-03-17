public class Ruut {

    private boolean miin;
    private boolean nähtav;
    private int mitu;

    public Ruut(boolean miin) {
        this.miin = miin;
        this.nähtav = false;
    }

    public boolean getNähtav() {
        return nähtav;
    }

    public void setNähtav(boolean nähtav) {
        this.nähtav = nähtav;
    }

    public boolean getMiin() {
        return miin;
    }

    public int getMitu() {
        return mitu;
    }

    public void setMitu(int mitu) {
        this.mitu = mitu;
    }

    @Override
    public String toString() {
        if (nähtav)
            if (miin)
                return "M";
            else
                return String.valueOf(mitu);
        else
            return "?";
    }
}
