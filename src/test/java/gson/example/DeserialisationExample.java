package gson.example;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserialisationExample {
    @Test
    public void test2(){
        String jsonString="{\n" +
                "  \"firstname\": \"Rish\",\n" +
                "  \"lastname\": \"Thakur\",\n" +
                "  \"gender\": \"M\",\n" +
                "  \"age\": 26,\n" +
                "  \"salary\": 70000,\n" +
                "  \"married\": false\n" +
                "}";
        Gson gson = new Gson();
        Employee employeeObject= gson.fromJson(jsonString,Employee.class);

        String firstname= employeeObject.getFirstname();
        String lastname= employeeObject.getLastname();

        Assert.assertEquals(firstname,"Rish");

    }

}
