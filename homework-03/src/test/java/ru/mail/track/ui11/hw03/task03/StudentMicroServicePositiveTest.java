package ru.mail.track.ui11.hw03.task03;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

/**
 * Тест-класс позитивных тестов к задаче №3
 */
public class StudentMicroServicePositiveTest {

    private StudentMicroService studentMicroservice;

    @Before
    public void init() {
        studentMicroservice = Mockito.mock(StudentMicroService.class);
    }

    @After
    public void clear() {
        studentMicroservice = null;
    }

    @Test
    public void addStudent() {
        Student student = new Student("Hans Weber", "ФРТК", 5);

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new LinkedHashMap();
        map.put("student", String.valueOf(student.hashCode()));
        map.put("error", "");
        map.put("state", "ok");
        list.add(map);

        JSONObject json = new JSONObject();
        json.put("students", list);
        Mockito.when(studentMicroservice.add(student)).thenReturn(json);

        JSONObject jsonObject = studentMicroservice.add(student);
        String text = "{\"students\":[{\"student\":\"" + student.hashCode() + "\",\"error\":\"\",\"state\":\"ok\"}]}";
        Assert.assertThat(jsonObject.toJSONString(), Matchers.equalTo(text));
    }

    @Test
    public void addTwoStudents() {
        Student first = new Student("Hans Zimmer", "ФРТК", 5);
        Student second = new Student("Monica Bellucci", "ФИВТ", 5);

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new LinkedHashMap();
        map.put("student", String.valueOf(first.hashCode()));
        map.put("error", "");
        map.put("state", "ok");
        list.add(map);
        map = new LinkedHashMap();
        map.put("student", String.valueOf(second.hashCode()));
        map.put("error", "");
        map.put("state", "ok");
        list.add(map);

        JSONObject json = new JSONObject();
        json.put("students", list);
        Mockito.when(studentMicroservice.add(first, second)).thenReturn(json);


        JSONObject actualJson = studentMicroservice.add(first, second);
        String text = "{\"students\":[{\"student\":\"" + first.hashCode() + "\",\"error\":\"\",\"state\":\"ok\"}," +
                "{\"student\":\"" + second.hashCode() + "\",\"error\":\"\",\"state\":\"ok\"}]}";
        Assert.assertThat(actualJson.toJSONString(), Matchers.equalTo(text));
    }

}