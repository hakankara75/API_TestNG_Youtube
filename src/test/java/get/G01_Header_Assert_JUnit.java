package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class G01_Header_Assert_JUnit {
// BU TESTTE JUNIT İLE HEADER ÜZERİNDE DOĞRULAMA YAPTIK
    @Test
    public void testName() {
         /*
        https://petstore.swagger.io/v2/pet/2 adresine git
        StatusCode 200
        Content-Type application/json
        statusLine HTTP/1.1 200 OK
        Connection keep-alive
        Time 800'den küçük
         */
    //1- End point olustur
        String endPoint="https://petstore.swagger.io/v2/pet/2";

    //2- GET request olustururuz
        given().get(endPoint);

    //3- Response olustururuz
        Response response=given().get(endPoint);

    //4- Response yazdir, icindeki datayi gorelim
    response.prettyPrint();

    //5-StatusCode'un 200 oldugunu dogrula
        int expectedStatusCode= 200;
        int actualStatusCode= response.statusCode();
        assertEquals(expectedStatusCode, actualStatusCode);

    //6- Content-Type'ın application/json oldugunu dogrula
        String expectedContentType= "application/json";
        String actualContentType= response.getContentType();
        assertEquals(expectedContentType, actualContentType);

    //7- statusLine'ın HTTP/1.1 200 OK oldugunu dogrula
        String expectedStatusLine="HTTP/1.1 200 OK";
        String actualStatusLine= response.statusLine();
        assertEquals(expectedStatusLine, actualStatusLine);

    //8- Connection'ın keep-alive oldugunu dogrula
        String expectedConnection= "keep-alive";
        String actualConnection= response.header("Connection");
        assertEquals(expectedConnection, actualConnection);

    //9-Time'ın 800'den küçük oldugunu dogrula
        int expectedTime= 800;
        int actualTime= (int) response.getTime();
        assertTrue(actualTime < expectedTime);
    }
}
