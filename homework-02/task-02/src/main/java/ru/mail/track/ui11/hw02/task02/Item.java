package ru.mail.track.ui11.hw02.task02;

/**
 * Класс, описывающий сущность Item, хранящую слово, его номер
 * и символьный промежуток между ним и следующим словом
 */
public class Item {

    private int index;
    private String word;
    private String ending;

    public Item(int index, String word, String ending) {
        this.index = index;
        this.word = word;
        this.ending = ending;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getEnding() {
        return ending;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }

    @Override
    public String toString() {
        return "index: " + index + ", word: " + word + ", ending: " + ending + ";";
    }
}