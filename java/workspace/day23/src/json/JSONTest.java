package json;

import org.json.simple.JSONArray;

//import java.util.HashMap;

import org.json.simple.JSONObject;

//JSON : 데이터 교환 방식(형식)
//"{"로 시작해서 "}"로 마친다.
public class JSONTest {
   public static void main(String[] args) {
//      HashMap<String, String> userMap = new HashMap<>();
//      userMap.put("id", "hds1234");
//      userMap.put("pw", "1234");
//      userMap.put("name", "한동석");
//      
//      JSONObject jsonObj = new JSONObject(userMap);
//      
//      System.out.println(jsonObj.toJSONString());
      
      JSONObject jsonObj = new JSONObject();
      jsonObj.put("id", "hds1234");
      jsonObj.put("pw", "1234");
      jsonObj.put("name", "한동석");
      
//      JSONObject teamObj = new JSONObject();
//      
//      teamObj.put("1", jsonObj);
//      teamObj.put("2", jsonObj);
//      
//      System.out.println(jsonObj.toJSONString());
//      System.out.println(teamObj.toJSONString());

      JSONArray jsonArr = new JSONArray();
      
      jsonArr.add(jsonObj);
      jsonArr.add(jsonObj);
      
      System.out.println(jsonArr.toJSONString());
      System.out.println(((JSONObject)jsonArr.get(0)).get("name"));
   }
}






















