public class WortImpl implements Wort {
    private final String wort;

    public WortImpl(String s) {
        this.wort = s;
    }

    @Override
    public char position(int k) {
        return wort.charAt(k);
    }

    @Override
    public int laenge() {
        return wort.length();
    }

    @Override
    public Wort concat(Wort w) {
        return new WortImpl(wort.concat(w.toString()));
    }

    @Override
    public int anzahl(char c) {
        int count = 0;
        for (int i = 0; i < wort.length(); i++) {
            if (wort.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }

    @Override
    public Wort tausche(char c1, char c2) {
        return null;
    }

    @Override
    public int istTeilwortVon(Wort w) {
        return 0;
    }

    @Override
    public Wort teilwort(int start, int laenge) {
        return null;
    }

    @Override
    public Wort ersetze(Wort w1, Wort w2) {
        return null;
    }
}


