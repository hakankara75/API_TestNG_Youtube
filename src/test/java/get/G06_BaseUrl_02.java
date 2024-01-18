package get;

import base_Urls.GoRest_BaseUrl;
import base_Urls.GoRest_BaseUrl02;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static base_Urls.GoRest_BaseUrl02.setupUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

public class G06_BaseUrl_02  {
    /*
https://gorest.co.in/public/v2/users
User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 200
    name contains "Bhadraksh Gupta"
    id should be 5913978, 5913979, 5913980
    gender should be male and female

 */

    @Test
    public void name() {
        //1- Set the URL
        RequestSpecification spec= setupUrl();
        spec.pathParam("first", "users");

        //2- Send the request and get the response
        Response response= given(spec).get("{first}");
        response.prettyPrint();

        //3- Do assertions
        response.then()
                .contentType("application/json")
                .statusCode(200)
                .body("name", hasItem("Anilaabh Mishra"),
                       "id", hasItems(5913902, 5913901, 5913900),
                        "gender", hasItems("male", "female"));
    }
}
