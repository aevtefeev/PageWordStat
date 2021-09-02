package ru.crmkrd.pws;

import java.util.ArrayList;

/**
 * Инициализация строки разделителей.
 */
public class SeparatorsString {
    static ArrayList<String> SeparatorsList = new ArrayList<>();

    public SeparatorsString() {
        SeparatorsList.add(" ");
        SeparatorsList.add(",");
        SeparatorsList.add(".");
        SeparatorsList.add("!");
        SeparatorsList.add("?");
        SeparatorsList.add("(");
        SeparatorsList.add(")");
        SeparatorsList.add("[");
        SeparatorsList.add("]");
        SeparatorsList.add("-");
        SeparatorsList.add(";");
        SeparatorsList.add(":");
        SeparatorsList.add("\n");
        SeparatorsList.add("\r");
        SeparatorsList.add("\t");
    }

    public String getSeparators(){
        return String.join("|\\", SeparatorsList);
    }
}
