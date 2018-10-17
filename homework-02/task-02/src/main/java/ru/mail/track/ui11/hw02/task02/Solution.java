package ru.mail.track.ui11.hw02.task02;

/**
 * Задача №2 - Слова и их цензура
 *
 * Есть 2 файла:
 * Первый с текстом (небольшой по объему)
 * Второй со словами исключениями - exception.txt, лежит в resources
 *
 * Необходимо прочитать из первого файла слова в соответствии
 * со следующими входными параметрами программы:
 * -n - количество слов, которые необходимо прочитать в тексте
 * -start - номер слова, с какого слова в тексте необходимо читать
 * -size - минимальный размер длины слова, который должен быть прочитан
 *
 * Если длина слова меньше, чем указано значение в параметре -size, то необходимо
 * это слово заменить строкой "размер меньше чем <указать значение параметра -size>"
 *
 * Если прочитанное слово является исключением, то необходимо его заменить словом "цензура"
 *
 * Пример запуска: java -jar wordsCensore.jar -n 5 -start 7 -size 3
 * Программа прочитает подряд 5 слов из текста, начиная с 7 слова, заменив
 * подстрокой "размер меньше чем 3" все слова, у которых длина меньше 3 символов,
 * или словом "цензура" если слово содержится в файле exception.txt
 */
public class Solution {

}