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
 * Тест-класс негативных тестов к задаче №3
 */
public class StudentMicroServiceNegativeTest {

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
    public void addNull() {
        Student student = null;

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new LinkedHashMap();
        map.put("student", "");
        map.put("error", "Incorrect Data");
        map.put("state", "");
        list.add(map);

        JSONObject json = new JSONObject();
        json.put("students", list);
        Mockito.when(studentMicroservice.add(null)).thenReturn(json);


        JSONObject actualJson = studentMicroservice.add(student);
        String text = "{\"students\":[{\"student\":\"\",\"error\":\"Incorrect Data\",\"state\":\"\"}]}";
        Assert.assertThat(actualJson.toJSONString(), Matchers.equalTo(text));
    }

    @Test
    public void addStudentsAndNull() {
        Student first = new Student("Barbra Streisand", "ФРТК", 1);
        Student second = null;

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new LinkedHashMap();
        map.put("student", String.valueOf(first.hashCode()));
        map.put("error", "");
        map.put("state", "ok");
        list.add(map);
        map = new LinkedHashMap();
        map.put("student", "");
        map.put("error", "Incorrect Data");
        map.put("state", "");
        list.add(map);

        JSONObject json = new JSONObject();
        json.put("students", list);
        Mockito.when(studentMicroservice.add(first, null)).thenReturn(json);


        JSONObject jsonObject = studentMicroservice.add(first, second);
        String text = "{\"students\":[{\"student\":\"" + first.hashCode() + "\",\"error\":\"\",\"state\":\"ok\"}," +
                "{\"student\":\"\",\"error\":\"Incorrect Data\",\"state\":\"\"}]}";
        Assert.assertThat(jsonObject.toJSONString(), Matchers.equalTo(text));
    }

}
