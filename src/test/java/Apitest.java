import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
public class Apitest {

    private static final Logger LOGGER = Logger.getLogger(Apitest.class.getName());
    Links obj = new Links();
    ArrayList<String> links =  obj.AddUrls();

    public Apitest() throws IOException, CsvValidationException {
    }


    @Test
    public void verifyServers(){

        SoftAssert softAssert = new SoftAssert();
        for(String urls : links) {
            int code= given().relaxedHTTPSValidation() .get(urls).getStatusCode();

            if (code== 200){
                LOGGER.info(urls);
                LOGGER.info("Response code : "  +code );

            }
            else
            {
                LOGGER.info(urls);
                LOGGER.info("Server not working !!!!! with response code : "  +code );
            }

            softAssert.assertEquals(code,200,"Invalid Response code !");

        }


    }



}
