package api;

// Ctrl + Shift + o : 자동 import하기
import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SMS {
	public static void main(String[] args) {
//		api_key
		String api_key = "NCSHUXHNNINOL8AT";
//	    api_secret
		String api_secret = "IMDMEXAZSWQWO7OR993KMVDEXCOK0ZDV";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", "01088580291");
	    params.put("from", "01012345678");
	    params.put("type", "SMS");
	    params.put("text", "택배 문앞에 놓고 갑니다.");
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
}
