package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner mySpinner;
    EditText ecran;
    final List<String> options = new ArrayList<>();
    double a, b, resultat;
    String Op = "+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner = findViewById(R.id.sp);
        ecran =  findViewById(R.id.ecran);
        options.add("Standard");
        options.add("Scientifique");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, options ) ;
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, options.get(i), Toast.LENGTH_SHORT).show();
        //--------- Si l'utilisateur choisie calculatrice standard -----------
        if(i == 0)
        {
            Button button26 = (Button) findViewById(R.id.button26);
            Button button27 = (Button) findViewById(R.id.button27);
            Button button28 = (Button) findViewById(R.id.button28);
            Button button34 = (Button) findViewById(R.id.button34);
            Button button35 = (Button) findViewById(R.id.button35);
            Button button36 = (Button) findViewById(R.id.button36);
            Button button37 = (Button) findViewById(R.id.button37);
            Button button29 = (Button) findViewById(R.id.button29);
            Button button30 = (Button) findViewById(R.id.button30);
            Button button32 = (Button) findViewById(R.id.button32);
            Button button31 = (Button) findViewById(R.id.button31);

            button26.setVisibility(View.GONE);
            button27.setVisibility(View.GONE);
            button28.setVisibility(View.GONE);
            button34.setVisibility(View.GONE);
            button35.setVisibility(View.GONE);
            button36.setVisibility(View.GONE);
            button37.setVisibility(View.GONE);
            button29.setVisibility(View.GONE);
            button30.setVisibility(View.GONE);
            button32.setVisibility(View.GONE);
            button31.setVisibility(View.GONE);
        }
        //--------- Si l'utilisateur choisie calculatrice scientifique -----------
        if(i == 1)
        {
            Button button26 = (Button) findViewById(R.id.button26);
            Button button27 = (Button) findViewById(R.id.button27);
            Button button28 = (Button) findViewById(R.id.button28);
            Button button34 = (Button) findViewById(R.id.button34);
            Button button35 = (Button) findViewById(R.id.button35);
            Button button36 = (Button) findViewById(R.id.button36);
            Button button37 = (Button) findViewById(R.id.button37);
            Button button29 = (Button) findViewById(R.id.button29);
            Button button30 = (Button) findViewById(R.id.button30);
            Button button32 = (Button) findViewById(R.id.button32);
            Button button31 = (Button) findViewById(R.id.button31);

            button26.setVisibility(View.VISIBLE);
            button27.setVisibility(View.VISIBLE);
            button28.setVisibility(View.VISIBLE);
            button34.setVisibility(View.VISIBLE);
            button35.setVisibility(View.VISIBLE);
            button36.setVisibility(View.VISIBLE);
            button37.setVisibility(View.VISIBLE);
            button29.setVisibility(View.VISIBLE);
            button30.setVisibility(View.VISIBLE);
            button32.setVisibility(View.VISIBLE);
            button31.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void chiffre(View view) {
        String chf = view.getTag().toString();
        String ecranTxt = ecran.getText().toString();
        if(ecranTxt.equals("NaN") ||ecranTxt.equals("0") || ecranTxt.equals(".")  )
            ecranTxt="";
        ecranTxt += chf;
        ecran.setText(ecranTxt);
    }

    public void operation(View view) {
        Button btn = (Button) view;
        String ecranTxt = ecran.getText().toString();
        try {
                a = Double.valueOf(ecranTxt);
        }
        catch (NumberFormatException e) {
            ecran.setText(e.getMessage());
        }
        ecran.setText("");
        Op = btn.getText().toString();
    }


    public void egal(View view) {
        String ecranTxt = ecran.getText().toString();
    try {
        if(!ecranTxt.isEmpty()) {
            b = Double.valueOf(ecranTxt);
        }
        else {
           ecran.setText(" ");
        }

        Log.i("test", "OP = "+ Op);
        switch (Op)
        {
            case "+" :
                resultat = a + b;
                break;
            case "-" :
                resultat = a - b;
                break;
            case "÷" :
                resultat = b==0? Double.NaN : a / b;
                break;
            case "X" :
                resultat =  a * b;
                break;
            case "Xⁿ":
                resultat = Math.pow(a, b);
                break;
            case "log":
                resultat = Math.log10(b);
                break;
            case "ln":
                resultat = Math.log(b);
                break;

            case "√":
                resultat = Math.sqrt(b);
                break;
            case "!":
                int i = (int)a  - 1;
                while (i > 0)
                {
                    a = a * i;
                    i--;
                }
                resultat = a ;
                break;
            case "sin":
                resultat = Math.sin(b);
                break;
            case "cos":
                resultat = Math.cos(b);
                break;
            case "tan":
                resultat = Math.tan(b);
                break;
            case "%" :
                resultat = a / 100;
                break;
            case "Rad" :
                resultat = Math.toRadians(b);
                break;
            case "e" :
                resultat = Math.exp(b);
                break;
        }
        ecran.setText(Double.toString(resultat));
    }
        catch (NumberFormatException e) {
            ecran.setText(e.getMessage());
        }
    }
    //----- effacer le dernier chiffre de l'ecran ------------
    public void delete(View view) {
        ecran.setText(ecran.getText().subSequence(0, ecran.getText().length() - 1));
    }
    //------- pour la virgule ------------
    public void point(View view) {
        String ecranTxt = ecran.getText().toString();
        if(ecranTxt.equals("NaN") || ecranTxt.equals(".")  || ecranTxt.contains(".") )
            ecranTxt="";
        ecranTxt += ".";
        ecran.setText(ecranTxt);
    }
    //------ vider l'ecran -----------
    public void effacer(View view) {
        ecran.setText("");
    }
}