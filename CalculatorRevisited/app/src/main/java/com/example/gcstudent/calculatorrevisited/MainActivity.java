package com.example.gcstudent.calculatorrevisited;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    String total="";
    double num1, num2;
    String sign="";
    double answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // take in numbers that are clicked
    public void onNumberClick(View v){
        Button button=(Button) v;
        String str=button.getText().toString();
        total += str;
        TextView edit = (TextView)findViewById(R.id.numbersView);
        edit.setText(total);

    }

    // take in action sign that is clicked
    public void onFunctionClick(View v){
        Button button=(Button) v;
        sign = button.getText().toString();
        num1 = Double.parseDouble(total);
        total="";
        TextView edit = (TextView)findViewById(R.id.numbersView);
        edit.setText(total);

    }

    // clear everything
    public void onClearClick(View v){
        TextView edit = (TextView)findViewById(R.id.numbersView);
        edit.setText("0");
        total="";
        sign="";
        num1=0;
        num2=0;
    }

    //calculate
    public void onCalculateClick(View v){
        Button button=(Button) v;
        num2 = Double.parseDouble(total);
        if(sign.equals("+")){
            answer = num1 + num2;
        }
        else if(sign.equals("-")){
            answer = num1 - num2;
        }
        else if(sign.equals("*")){
            answer = num1 * num2;
        }
        else if(sign.equals("/")){
            answer = num1 / num2;
        }
        TextView edit = (TextView)findViewById(R.id.numbersView);
        edit.setText(String.valueOf(answer));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
