package fsktm.um.edu.additioncalculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.effect.Effect;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addition (View view)
    {
        EditText ETNum1 = (EditText)findViewById(R.id.ETFirst);
        EditText ETNum2 = (EditText)findViewById(R.id.ETSecond);
        int Result = Integer.parseInt(ETNum1.getText().toString()) + Integer.parseInt(ETNum2.getText().toString());
        TextView TVResult = (TextView)findViewById(R.id.TVResult);
        TVResult.setText(Integer.toString(Result));
    }
}
