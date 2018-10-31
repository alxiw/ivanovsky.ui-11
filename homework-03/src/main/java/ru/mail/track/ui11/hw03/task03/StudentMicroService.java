package ru.mail.track.ui11.hw03.task03;

import org.json.simple.JSONObject;

/**
 * Задача №3 - Микросервис каталога студентов
 *
 * Дан микросервис задача которого записывать данные о студентах в БД
 * Если студент успешно записан в БД, то микросервис возвращает json вида:
 * {
 * 	"students": [{
 * 		"student": "1234567867970",
 * 		"error": "",
 * 		"state": "ok"
 *  }]
 * }
 *
 * students - массив информации о состоянии записи студентов в БД
 *
 * student - содержит hashcode объекта студента
 * error - текст ошибки, в случае ошибки записи
 * state - ok, если запись успешна
 *
 */
public class StudentMicroService {

    public JSONObject add(Student... students) {
        //some code
        return null;
    }
}
