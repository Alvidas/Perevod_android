package com.example.perevod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText  = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        textView  = (TextView) findViewById(R.id.textView);
    }


    public void ClickButton(View v)
    {

        if (TextUtils.isEmpty(editText.getText().toString())
                || TextUtils.isEmpty(editText2.getText().toString()) || TextUtils.isEmpty(editText3.getText().toString())) {
            return;
        }

        //Считаем с editText и editText2 текстовые значения
        String x = editText.getText().toString();
        String b = editText2.getText().toString();
        String y = editText3.getText().toString();

        int a = Integer.parseInt(x,10);
        int c = Integer.parseInt(y,10);

        boolean proverka = b.contains(".");

        if(proverka==true){

            String[] bParts = b.split("\\.");//Деление на дробную и целую часть.
            String m = bParts[0];
            String f = bParts[1];

            int mdes = Integer.parseInt(m, a);//Преобразование целой части.
            String mconvert = Integer.toString(mdes, c);


            String fconvert = "";
            if(a==10){
                String nul = "0.";//Преобразование дробной.
                String fw = nul + f;
                double fd = Double.parseDouble(fw);
                for(int i = 0; i<4; i++){
                    double s = fd*c;
                    int res = (int)s;
                    String fres = Integer.toString(res,c);
                    fd = s - res;
                    fconvert = fconvert + fres;
                }
            }else{
                int fe = f.length();
                char[] fChar = f.toCharArray ();
                double result = 0;
                for(int e = 0; e < fe; e++){
                    String f1 = Character.toString(fChar[e]);
                    int i1 = Integer.parseInt(f1, a);
                    double x1 = Math.pow(a, -e);
                    result = result + x1*i1;
                }
                String fcon = Double.toString(result);
                String[] fParts = fcon.split("\\.");
                String nul = "0.";//Преобразование дробной.
                String fw = nul + fParts[1];
                double fde = Double.parseDouble(fw);
                if(c!=10){
                    for(int i = 0; i<4; i++){
                        double s = fde*c;
                        System.out.println(s);
                        int res = (int)s;
                        String fres = Integer.toString(res,c);
                        fde = s - res;
                        fconvert = fconvert + fres;
                    }
                }else{
                    fconvert = fParts[1];
                }
            }
            textView.setText("Ответ: "+ mconvert + "." + fconvert);
        }else{                           //Преобразование целого числа.
            int num = Integer.parseInt(b, a);
            String convert = Integer.toString(num, c);
            textView.setText("Ответ: " + convert);
        }
    }
}