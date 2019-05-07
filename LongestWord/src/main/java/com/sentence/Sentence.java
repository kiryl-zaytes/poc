package com.sentence;

import com.sun.media.sound.InvalidFormatException;

import java.util.HashSet;

/**
 * Class to work with sentences, split, count, etc.
 */
public class Sentence {

    String sentence;
    HashSet<Character> punctuation;

    int max = 0;
    String word;

    /*
        Default constructor
        @str - sentence to work with
     */
    public Sentence(String str) throws InvalidFormatException {
        if (str == null || str.length() == 0)
            throw new InvalidFormatException();
        this.sentence = str;
    }

    /*
        Extended constructor
        @str - sentence to work tiwh
        @HashSet - set of punctuation and char to split string on.
     */
    public Sentence(String str, HashSet<Character> punctuation) throws
            InvalidFormatException {
        if (str == null || str.length() == 0)
            throw new InvalidFormatException();
        this.sentence = str;
        this.punctuation = punctuation;
    }


    // if there will be any other methods and we want to avoid sharing data
    // Simplest method as requested, not sure if method like split could be
    // used. Could be extended to choose from the words with same length.

    public Pair getLongest() {
        String[] res = this.sentence.split("\\W+");
        for (String s : res)
            if (s.length() > max) {
                max = s.length();
                word = s;
            }
        return new Pair(max, word);
    }

    // default implementation with no regexp usage.
    public Pair getLongestDefault() {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        String res = "";
        for (int i = 0; i < sentence.length(); i++) {
            if (i == sentence.length() - 1 || punctuation.contains(sentence
                    .charAt(i))) {

                sb.append(sentence, start, i);
                if (sb.length() > max) {
                    max = sb.length();
                    res = sb.toString();
                }
                sb.setLength(0);
                start = i + 1;
            }
        }

        return new Pair(res.length(), res);
    }
}
