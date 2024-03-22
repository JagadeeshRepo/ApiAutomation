package users;

import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class UserAPIs {
    public Response createUser(Map<String, Object> createUserPayLoad){
        String endPoint=(String) BaseClass.dataFromJsonFile.get("createUserEndpoint");
        return  RestUtils.performPost(endPoint,createUserPayLoad,new HashMap<>());
    }
}
