package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class G02 {
    // BU TESTTE REST ASSURED İLE DOĞRULAMA YAPTIK
    @Test
    public void testName() {
          /*
 https://restful-booker.herokuapp.com/booking/34
 HTTP Status Code'unun 200
 Content Type'ın "application/json; charset=utf-8"
 Status Line'ın "HTTP/1.1 200 OK"
 Server'ın' "Cowboy"
 Connection'ın "keep-alive"
 oldugunu dogrular
*/
//1-Set the URL
        String url= "https://restful-booker.herokuapp.com/booking/34";

//2- Send the request and get the response
    Response response= given().get(url);
    response.prettyPrint();

//3- Do assertion
response.then() // rest assure da assertionlari then ile yapariz
        .statusCode(200)
        .contentType("application/json; charset=utf-8")
        .statusLine("HTTP/1.1 200 OK")
        .header("Server","Cowboy")
        .header("Connection", "keep-alive" );


    }
}
