package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText;

    float op1,op2;

    boolean add , sub , mul ,div;

    TextView history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonEqual = findViewById(R.id.myBtn);
        Button button   = findViewById(R.id.button);
        Button button2  = findViewById(R.id.button2);
        Button button3  = findViewById(R.id.button3);
        Button button4  = findViewById(R.id.button4);
        Button button5  = findViewById(R.id.button5);
        Button button6  = findViewById(R.id.button6);
        Button button7  = findViewById(R.id.button7);
        Button button8  = findViewById(R.id.button8);
        Button button9  = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMulti = findViewById(R.id.buttonMulti);
        Button buttonDiv = findViewById(R.id.buttonDiv);
        editText        = findViewById(R.id.editText);
        history         = findViewById(R.id.history);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String oldValue = editText.getText().toString();
                String newValue = oldValue +"1";

                editText.setText(newValue);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"9");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+".");
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"0");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                history.setText("");
            }
        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText.getText() == null || editText.getText().toString().isEmpty())
                {
                    return;
                }

                op1 = Float.parseFloat(editText.getText().toString()); //parseFloat k andr emoty string ja rhi hai, ab emtty hua to isme ayega hi nai
                add = true;
                addHistory(op1+"","+");
                editText.setText(null);

            }
        });


        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText.getText() == null || editText.getText().toString().isEmpty())
                {
                    return;
                }

                op1 = Float.parseFloat(editText.getText().toString());
                sub = true;
                addHistory(op1+"", "-");
                editText.setText(null);
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText.getText() == null || editText.getText().toString().isEmpty())
                {
                    return;
                }

                op1 = Float.parseFloat(editText.getText().toString());
                mul = true;
                addHistory(op1+"", "*");
                editText.setText(null);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText.getText() == null || editText.getText().toString().isEmpty())
                {
                    return;
                }

                op1 = Float.parseFloat(editText.getText().toString());
                div = true;
                addHistory(op1+"", "/");
                editText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(add){
                   op2 = Float.parseFloat(editText.getText().toString());
                   String result =  op1+op2+"";
                   editText.setText(result);

                    addHistory(op1+"+"+op2,"=");

                }

                if(sub)
                {
                    op2 = Float.parseFloat(editText.getText().toString());
                    String result1 = op1-op2+"";
                    editText.setText(result1);

                    addHistory(op1+"+"+op2, "=");
                }

                if(mul)
                {
                    op2 = Float.parseFloat(editText.getText().toString());
                    String result2 = op1*op2+"";
                    editText.setText(result2);

                    addHistory(op1+"+"+op2, "=");
                }

                if(div)
                {
                    op2 = Float.parseFloat(editText.getText().toString());
                    String result3 = op1/op2+"";
                    editText.setText(result3);

                    addHistory(op1+"+"+op2, "=");
                }

                ///Reset all flags to their initial values
                op1 = 0;
                op2 = 0;
                add = sub = mul = div = false;
            }
        });


    }

    public void addHistory(String num1,String operation){
        String historyText = num1+operation;
        history.setText(historyText);
    }


}
