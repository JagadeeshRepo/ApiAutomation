package users;

import java.util.HashMap;
import java.util.Map;

public class PayLoads {

    public static String getCreateActivitiesPayLoadFromString( String id, String username,String password){
        String requestPayLoad="{\n" +
                "  \"id\": "+id+",\n" +
                "  \"userName\": \" "+username+"\",\n" +
                "  \"password\": \" "+password+"\",\n"+
                "}";
        return requestPayLoad;
    }

    public static Map<String, Object> getCreateActivitiesPayLoad(String id, String username,String password){

        Map<String,Object> requestPayLoad =new HashMap<>();

        requestPayLoad.put("id",id);
        requestPayLoad.put("username",username);
        requestPayLoad.put("password",password);
        return requestPayLoad;
    }
}
