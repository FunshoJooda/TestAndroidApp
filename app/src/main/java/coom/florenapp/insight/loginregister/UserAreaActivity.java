package coom.florenapp.insight.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        final EditText etUsername=(EditText)findViewById(R.id.etUsername);
        final EditText etAge=(EditText)findViewById(R.id.etAge);
        final TextView welComeMsg=(TextView)findViewById(R.id.tvWelcomeMsg);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name").toString();
        String username=intent.getStringExtra("username").toString();
        int age= intent.getIntExtra("age",-1);
        String welcome=name + "Welcome to your User Area";
        welComeMsg.setText(welcome);
        etUsername.setText(username);
        etAge.setText(age+"");
    }
}
