package compinner.example.student.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5,et6,et7,et8;
    Button bt;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Registration");
        setContentView(R.layout.activity_registration);
        et1=(EditText)findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.gender);
        et3=(EditText)findViewById(R.id.blood_group);
        et4=(EditText)findViewById(R.id.age);
        et5=(EditText)findViewById(R.id.address_line_1);
        et6=(EditText)findViewById(R.id.address_line_2);
        et7=(EditText)findViewById(R.id.pincode);
        et8=(EditText)findViewById(R.id.phone);

        bt=(Button)findViewById(R.id.button2);

        db=openOrCreateDatabase("Registration Details", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS REGISTRATION(name VARCHAR,gender VARCHAR,blood_group VARCHAR,age VARCHAR,address_line_1 VARCHAR,address_line_2 VARCHAR,pin_code VARCHAR,phone VARCHAR)");


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.execSQL("INSERT INTO REGISTRATION VALUES('"+et1.getText()+"','"+et2.getText()+"','"+et3.getText()+"','"+et4.getText()+"','"+et5.getText()+"','"+et6.getText()+"','"+et7.getText()+"','"+et8.getText()+"')");

                Toast.makeText(getApplicationContext(),"SUCCESSFULLY REGISTERED", Toast.LENGTH_SHORT).show();

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);


            }
        });


    }
}