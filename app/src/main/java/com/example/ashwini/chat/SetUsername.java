package com.example.ashwini.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import static com.example.ashwini.chat.R.styleable.View;
/**
 * Created by Ashwini on 31-03-2017.
 */

public class SetUsername extends AppCompatActivity {

    public String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_username);

        EditText Text= (EditText) findViewById(R.id.editText);
        Text.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textview ,int i, KeyEvent keyevent){
                boolean handled = false;
                if (i == EditorInfo.IME_ACTION_DONE) {
                    final String inputText = textview.getText().toString();
                    key=inputText;
                    Toast.makeText(SetUsername.this, "Your Username is: " + inputText, Toast.LENGTH_SHORT).show();
                }
                return handled;
            }
        });

        final Button back = (Button) findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //add your code here..
                Intent myIntent = new Intent(SetUsername.this, WiFiServiceDiscoveryActivity.class);
                myIntent.putExtra("key", key); //Optional parameters
                SetUsername.this.startActivity(myIntent);

                //WindowManager.LayoutParams params = getWindow().getAttributes();
                //params.screenBrightness = 0;
                //getWindow().setAttributes(params);
               // Toast.makeText(.getContext(),"Button Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}
