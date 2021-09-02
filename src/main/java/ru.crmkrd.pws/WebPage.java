package ru.crmkrd.pws;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Загрузка страницы и выдача её в виде строки
 */

public class WebPage {
    public String loadPage(){
        // Получаем адрес
        System.out.println("Введите URL");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = "";
        Document page = null;
        try {
            url = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace(); // Добавить вывод ошибки в лог файл
        }
        // Парсим страницу в строку
        try {
            page = Jsoup.parse(new URL(url), 3000);
        } catch (IOException e) {
            e.printStackTrace(); // Добавить вывод ошибки в лог файл
        }

        if (page == null) {
            throw new AssertionError();
        }
        return  page.text();
    }
}
