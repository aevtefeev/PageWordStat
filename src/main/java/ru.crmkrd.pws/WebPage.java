package ru.crmkrd.pws;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Загрузка страницы и выдача её в виде строки
 */

public class WebPage {
    public String loadPage(){
        Logger logger = LoggerFactory.getLogger(PageWordStat.class);
        // Получаем адрес
        System.out.println("Введите URL в формате http://адрес");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = "";
        Document page = null;
        try {
            url = reader.readLine();
            logger.info("URL: "+url);

        } catch (IOException e) {
            e.printStackTrace(); // Добавить вывод ошибки в лог файл
        }
        // Парсим страницу в строку
        if (url.contains("http")) {
            try {
                page = Jsoup.parse(new URL(url), 3000);
            } catch (IOException e) {
                e.printStackTrace(); // Добавить вывод ошибки в лог файл
            }

            if (page == null) {
                throw new AssertionError();
            }
            return page.text();
        } else {
            logger.error("Bad URL: "+url);
            return "";
        }
    }
}
