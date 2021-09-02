package ru.crmkrd.pws;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class PageWordStat {
    public static void main(String[] args) {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PageWordStat.class);

         // Инициализируем страницу и получаем из неё текст
        WebPage page = new WebPage();
        String sPage = page.loadPage();
        logger.info("text: "+sPage);
        if (sPage.equals("")) {
            System.out.println("Вы ввели неверный адрес");
            System.exit(-1);
        }
        // Инициализируем разделители и получаем их в виде строки
        SeparatorsString separators = new SeparatorsString();
        String sSeparators = separators.getSeparators();
        logger.info("separators: "+sSeparators);

        Map<String, Word> countMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sPage.getBytes(StandardCharsets.UTF_8))));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                // разбиваем полученную строку на слова используя разделители
                String[] words = line.split(sSeparators);
                // Считаем колличесво вхождений слов
                for (String word : words) {
                    if ("".equals(word)) {
                        continue;
                    }

                    Word wordObj = countMap.get(word);
                    if (wordObj == null) {
                        wordObj = new Word();
                        wordObj.word = word;
                        wordObj.count = 0;
                        countMap.put(word, wordObj);
                    }

                    wordObj.count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // выводим статистику слов
        SortedSet<Word> sortedWords = new TreeSet<>(countMap.values());
        for (Word word : sortedWords) {
            System.out.println(word.count + "\t" + word.word);
        }
    }
}
