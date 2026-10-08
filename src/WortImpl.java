public class WortImpl implements Wort {
    private final String wort;

    public WortImpl(String s) {
        this.wort = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Wort other) {
            return this.wort.equals(other.toString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return wort.hashCode();
    }

    @Override
    public String toString() {
        return wort;
    }

    @Override
    public char position(int k) {
        int index = k - 1;
        return wort.charAt(index);
    }

    @Override
    public int laenge() {
        return wort.length();
    }

    @Override
    public Wort concat(Wort w) {
        return new WortImpl(wort + w);
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
        String result = "";

        for (int i = 0; i < wort.length(); i++) {
            if (c1 == wort.charAt(i)) {
                result += c2;
            } else {
                result += wort.charAt(i);
            }
        }
        return new WortImpl(result);
    }

    @Override
    public int istTeilwortVon(Wort w) {
        String strW = w.toString();
        return wort.indexOf(strW) + 1;
    }

    @Override
    public Wort teilwort(int start, int laenge) {
        if (start < 1 || laenge < 0) {
            return null;
        }

        int startIdx = start - 1;

        int endIdx = startIdx + laenge;
        if (endIdx > wort.length()) {
            return null;
        }
        return new WortImpl(wort.substring(startIdx, endIdx));
    }

    @Override
    public Wort ersetze(Wort w1, Wort w2) {
        String strWort1 = w1.toString();
        String strWort2 = w2.toString();
        int charactersToReplaceIndex = wort.indexOf(strWort1);
        int charactersToSkip = charactersToReplaceIndex + strWort1.length();
        if (charactersToReplaceIndex > -1) {
            return new WortImpl(wort.substring(0, charactersToReplaceIndex) + strWort2 + wort.substring(charactersToSkip));
        }

        return new WortImpl(wort);
    }
}


