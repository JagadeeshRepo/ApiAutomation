package users;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsersTests extends UserAPIs{

    @Test
            public void createActivitiesBasic() {
        String endPoint="https://fakerestapi.azurewebsites.net//api/v1/Users";
        String requestPayLoad ="{\n" +
                "  \"id\": 0,\n" +
                "  \"userName\": \"Jackal\",\n" +
                "  \"password\": \"test@123\"\n" +
                "}";
                Response response = RestUtils.performPost(endPoint,requestPayLoad,new HashMap<>());
       // Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createActivitiesFromString() {
        String endPoint="https://fakerestapi.azurewebsites.net//api/v1/Users";
        String requestPayLoad =PayLoads.getCreateActivitiesPayLoadFromString("7", "Tetest stJack","password@123");
        Response response = RestUtils.performPost(endPoint,requestPayLoad,new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);
    }


    @Test(alwaysRun = true)
    public void createUsersFromMap() throws IOException {
                Map<String, Object> requestPayLoad=PayLoads.getCreateActivitiesPayLoad("1", "tested","test@1234");
        Response response = createUser(requestPayLoad);
        Assert.assertEquals(response.statusCode(),200);

    }
}
