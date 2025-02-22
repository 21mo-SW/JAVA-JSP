package sms;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
public class ExampleSend {
	public ExampleSend(String tel, String msg) {
    String api_key = "NCSTFTVLLMIF8KXY";
    String api_secret = "DSQRPQQVBOLVLLKZG4W13M1ZTSOYKHS1";
    Message coolsms = new Message(api_key, api_secret);

    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", tel);
    params.put("from", "01083443909");
    params.put("type", "SMS");
    params.put("text", msg);
    params.put("app_version", "test app 1.2"); // application name and version

    try {
      JSONObject obj = (JSONObject) coolsms.send(params); //obj는 데이터를 잘받앗는지 응답해주는것을 담은 변수
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}