package gson.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

public class SerialisationExample {

    /* {
     *       "firstname":"Malini",
     *       "lastname":"Thakur",
     *       "gender":"F",
     *       "age":21,
     *       "salary":50000,
     *       "married":false
     * }
     * */
    //Serialisation-> object conversion to json string
    @Test
    public void test(){
        Employee employeeObject = new Employee();
        employeeObject.setFirstname("Rish");
        employeeObject.setLastname("Thakur");
        employeeObject.setGender("M");
        employeeObject.setAge(26);
        employeeObject.setSalary(70000);
        employeeObject.setMarried(false);

        //gson object
        Gson gson= new Gson();
        String jsonEmployee = gson.toJson(employeeObject);
        System.out.println(jsonEmployee); //Successfully converted object into json

        Gson gsonBuilder=new GsonBuilder().setPrettyPrinting().create();
        String employeePrettyPrint = gsonBuilder.toJson(employeeObject);
        System.out.println("Pretty Print in json format:");
        System.out.println(employeePrettyPrint);

    }
}