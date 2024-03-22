package users;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class BaseClass {

     public static Map<String, Object> dataFromJsonFile;
    static {
              String env = System.getProperty("env") == null ? "qa_Staging" : System.getProperty("env");
            try {
                dataFromJsonFile = JsonUtils.getJsonDataAsMap("qa_Staging/usersApiData.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println(System.getProperty("env") + "Environment Variable");
     /*   String env=System.getProperty("env")==null ? "qa_Staging" : System.getProperty("env");
         try {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("qa_Staging/usersApiData.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String env="qa_Staging";
        String endPoint= (String) dataFromJsonFile.get("createUserEndpoint");*/
    }
}
