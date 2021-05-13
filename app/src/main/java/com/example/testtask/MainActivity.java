package com.example.testtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /** text output field */
    private TextView resultView;
    /**text input field for number*/
    private EditText editText;
    /** button to calculate fibonacci numbers by for loop*/
    private Button firstButton;
    /** button to calculate fibonacci numbers by while loop*/
    private Button secondButton;
    /** button to calculate fibonacci numbers by do/while loop*/
    private Button thirdButton;

    /**initialize activity of application*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = (TextView) findViewById(R.id.result);
        editText = (EditText) findViewById(R.id.enterOfNumber);
        firstButton = (Button) findViewById(R.id.firstFormulaButton);
        secondButton = (Button) findViewById(R.id.secondFormulaButton);
        thirdButton = (Button) findViewById(R.id.thirdFormulaButton);
        /** make resultView scrollable*/
        resultView.setMovementMethod(new ScrollingMovementMethod());

        /**
         *listens for a button press
         * this press of button calculate by first variant
         */
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText(firstFormula(Integer.parseInt(editText.getText().toString())));
            }
        });

        /**
         *listens for a button press
         * this press of button calculate by second variant
         */
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText(secondFormula(Integer.parseInt(editText.getText().toString())));
            }
        });

        /**
         *listens for a button press
         * this press of button calculate by third variant
         */
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText(thirdFormula(Integer.parseInt(editText.getText().toString())));
            }
        });
    }


    /**
     * calculating fibonacci numbers by for loop
     * @return returns fibonacci numbers in string
     */
    public String firstFormula(int number) {
        List<BigInteger> elements = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        BigInteger firstElement = new BigInteger("0");
        BigInteger secondElement = new BigInteger("1");

        elements.add(firstElement);
        elements.add(secondElement);

         for(int index = 1; index < number; index++){
             elements.add(elements.get(index).add(elements.get(index - 1)));
         }


        for(int index = 1; index < number; index++){
            stringBuilder.append("Число Фибоначчи циклом for №")
                    .append(index)
                    .append(" ==> ")
                    .append(elements.get(index))
                    .append(System.lineSeparator());
        }
        return  stringBuilder.toString();
    }


    /**
     * calculating fibonacci numbers by while loop
     * @return returns fibonacci numbers in string
     */
    public String secondFormula(int number) {
        List<BigInteger> elements = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        BigInteger firstElement = new BigInteger("0");
        BigInteger secondElement = new BigInteger("1");

        elements.add(firstElement);
        elements.add(secondElement);

        int index = 1;

        while( index < number){
            elements.add(elements.get(index).add(elements.get(index - 1)));
            index++;
        }

        for( index = 1; index < number; index++){
            stringBuilder.append("Число Фибоначчи циклом while №")
                    .append(index)
                    .append(" ==> ")
                    .append(elements.get(index))
                    .append(System.lineSeparator());
        }
        return  stringBuilder.toString();
    }


    /**
     * calculating fibonacci numbers by do/while loop
     * @return returns fibonacci numbers in string
     */
    public String thirdFormula(int number) {
        List<BigInteger> elements = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        BigInteger firstElement = new BigInteger("0");
        BigInteger secondElement = new BigInteger("1");

        elements.add(firstElement);
        elements.add(secondElement);

        int index = 1;

        do{
            elements.add(elements.get(index).add(elements.get(index - 1)));
            index++;
        } while (index < number);


        for( index = 1; index < number; index++){
            stringBuilder.append("Число Фибоначчи циклом do/while №")
                    .append(index)
                    .append(" ==> ")
                    .append(elements.get(index))
                    .append(System.lineSeparator());
        }
        return  stringBuilder.toString();
    }
}