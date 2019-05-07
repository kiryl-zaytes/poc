package com.sentence;

/**
 * Created by kiryl_zayets on 5/7/19.
 */
public class Pair {
    String word;
    int len;
    public Pair(int l, String word){
        this.word = word;
        this.len = l;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (len != pair.len) return false;
        return !(word != null ? !word.equals(pair.word) : pair.word != null);

    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + len;
        return result;
    }
}
