package ru.crmkrd.pws;

/**
 * Реализуем интерфейс Comparable для класса Word
 * необходим на накопления колличества вхождений слова
 */

public class Word implements Comparable<Word>{
    String word;
    int count;

    @Override
    public int compareTo(Word w) {
        return w.count-count;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return word.equals(((Word)obj).word);
    }
}
