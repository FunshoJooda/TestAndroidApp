package coom.florenapp.insight.loginregister;

import com.android.volley.toolbox.StringRequest;
import  com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Funsho on 09/09/2016.
 */
public class RegisterRequest extends StringRequest {
    private  static final  String REGISTER_REQUEST_URL="http://populationassociationng.org/AndroidApp/register.php";
    private Map<String,String> params;
    public  RegisterRequest(String name,String username,int age,String password,Response.Listener<String> listener)
    {
      super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("age",age + "");
        params.put("password",password);
    }
    public  Map<String,String> getParams(){
        return params;
    }


}
