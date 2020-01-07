package fsktm.um.edu.my.multipleactivitiesandlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GridLayout extends AppCompatActivity {

    String input = "";
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gl);
    }

    public void BtnBackClicked(View view)
    {
        Intent MainAct = new Intent (this, MainActivity.class);
        startActivity(MainAct);
    }

    public void onClick(View view)
    {
        TextView TVCal = (TextView)findViewById(R.id.TVCalculator);
        TextView TVResult = (TextView)findViewById(R.id.TVResult);
        Button b = (Button)view;

        switch (view.getId())
        {
            case R.id.BTNC:
                input = "";
                result = 0;
                TVResult.setText("0");
                break;
            case R.id.BTNDel:
                if (input != null && input.length() > 0)
                {
                    input = input.substring(0, input.length() - 1);
                    if (!isSymbol())
                    {
                        calculate();
                    }
                    TVResult.setText(String.valueOf(result));
                }
                break;
            case R.id.BTNPlu:
            case R.id.BTNSub:
            case R.id.BTNMul:
            case R.id.BTNDiv:
                removeSymbol();
                BtnSymbolClicked(b.getText().toString());
                break;
            case R.id.BTNEqu:
                removeSymbol();
                calculate();
                input = String.valueOf(result);
                TVResult.setText("0");
                break;

            default:
                input = input + b.getText().toString();
                calculate();
                TVResult.setText(String.valueOf(result));
        }
        TVCal.setText(input);
    }


    public void BtnSymbolClicked(String symbol)
    {
        if (input != null && input.length() > 0 )
        {
            input = input + symbol;
        }
    }

    public void calculate()
    {
        LinkedList<Double> digits = extractDigit(input);
        LinkedList<String> symbols = extractSymbol(input);

        while (symbols.size()>=1)
        {
            String symbol = symbols.remove();
            double num1 = digits.removeFirst();
            double num2 = digits.removeFirst();
            double value = 0.0;
            switch(symbol)
            {
                case "+":
                case "-":
                    value = num1 + num2;
                    break;
                case "×":
                    value = num1 * num2;
                    break;
                case "÷":
                    value = num1 / num2;
                    break;
            }
            digits.addFirst(value);
        }

        result = digits.remove();
    }


    public boolean isSymbol()
    {
        if (input != null && input.length() > 0 )
        {
            if (input.charAt(input.length() - 1) == '+' ||
                    input.charAt(input.length() - 1) == '-' ||
                    input.charAt(input.length() - 1) == '÷' ||
                    input.charAt(input.length() - 1) == '×')
            {
                return true;
            }
        }
        return false;
    }


    public void removeSymbol()
    {
        if (isSymbol())
        {
            input = input.substring(0, input.length() - 1);
        }
    }

    public static LinkedList<Double> extractDigit(String str)
    {
        Pattern p = Pattern.compile("([+-]?\\d+(\\.\\d+)?)");
        Matcher m = p.matcher(str);

        LinkedList<Double> digits = new LinkedList<>();
        while(m.find()) {
            digits.add(Double.parseDouble(m.group()));
        }
        return digits;
    }

    public LinkedList<String> extractSymbol(String str)
    {
        Pattern p = Pattern.compile("[+,\\-,÷,×]");
        Matcher m = p.matcher(str);

        LinkedList<String> symbols = new LinkedList<>();
        while(m.find()) {
            symbols.add(m.group());
        }
        return symbols;
    }
}
