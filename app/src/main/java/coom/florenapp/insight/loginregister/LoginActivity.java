package coom.florenapp.insight.loginregister;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
public class LoginActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername=(EditText)findViewById(R.id.etUsername);
        final EditText etPassword=(EditText)findViewById(R.id.etPassword);
        final Button bLogin=(Button)findViewById(R.id.bLogin);
        final TextView tvRegisterHere=(TextView)findViewById(R.id.tvRegisterHere);
        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),registerActivity.class);


                startActivity(new Intent(LoginActivity.this, registerActivity.class));


            }
        });
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username=etUsername.getText().toString();
                final  String password=etPassword.getText().toString();
                Response.Listener<String> responselistener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonresponse=new JSONObject(response);
                            boolean success=jsonresponse.getBoolean("success");
                            if (success){
                                String name=jsonresponse.getString("name");
                                String username=jsonresponse.getString("username");
                                int  age=jsonresponse.getInt("age");
                                Intent intent=new Intent(LoginActivity.this,UserAreaActivity.class);
                                intent.putExtra("name",name);
                                intent.putExtra("username",username);
                                intent.putExtra("age",age + "");
                                
                                startActivity(intent);
//




                            }else
                            {
                                AlertDialog.Builder bulder=new AlertDialog.Builder(LoginActivity.this);
                                bulder.setMessage("Invalid Username or Password !")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                                                }

                    }
                };
                LoginRequest loginrequest =new LoginRequest(username,password,responselistener);
                RequestQueue queue= Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginrequest);
            }
        });
    }
}
