package ru.mail.track.ui11.hw01.task11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.io.*;

/**
 * Тест-класс для Задачи №11 - канал передачи прочитанных из txt-файла
 * сообщений с их обработкой и сохранением в txt-файл
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

    private File source;
    private File output;

    private String text = "<span><b><span>Turanga 100500 Leela</span></b></span>" + RN +
                          "<span>Happy New Year 2018</span>" + RN +
                          "<span>WELCOME 9000</span>" + RN +
                          "<span>super 1000000 good</span>";

    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysOut();

        source = new File("source.txt");
        output = new File("result.txt");

        FileWriter fw = new FileWriter(source);
        fw.write(text);
        fw.close();
    }

    @After
    public void tearDown() {
        resetOut();
        source.delete();
        output.delete();
    }

    @Test
    public void main() throws IOException, InterruptedException {
        Solution.sendMessageThroughPipeFromFileToFile(source, output);

        BufferedReader fin = new BufferedReader(new FileReader(output));
        String line;
        while ((line = fin.readLine()) != null) System.out.println(line);

        fin.close();

        String result = "<span><b><span>Turanga XXXXXX Leela</span></b></span>" + RN +
                        "<span>Happy New Year XXXX</span>" + RN +
                        "<span>WELCOME XXXX</span>" + RN +
                        "<span>super XXXXXXX good</span>";

        assertSysOutEquals(result + RN);
    }

}