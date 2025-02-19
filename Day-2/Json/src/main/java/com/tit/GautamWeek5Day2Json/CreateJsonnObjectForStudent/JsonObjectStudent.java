package com.tit.GautamWeek5Day2Json.CreateJsonnObjectForStudent;
import org.json.JSONArray;
import org.json.JSONObject;
public class JsonObjectStudent {
    public static void main(String[] args) {
       JSONObject jsonObjectStudent = new JSONObject();
        jsonObjectStudent.put("Name", "Gautam");
        jsonObjectStudent.put("Age", 22);
        JSONArray subjects = new JSONArray();
        jsonObjectStudent.put("Subjects", subjects);
        subjects.put("English");
        subjects.put("Hindi");
        subjects.put("Math");

        System.out.println(jsonObjectStudent.toString());
    }
}
