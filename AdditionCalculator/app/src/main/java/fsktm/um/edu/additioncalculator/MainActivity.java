package fsktm.um.edu.additioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ETNum1 = (EditText)findViewById(R.id.ETFirst);
                EditText ETNum2 = (EditText)findViewById(R.id.ETSecond);
                int Result = Integer.parseInt(ETNum1.getText().toString()) + Integer.parseInt(ETNum2.getText().toString());
                TextView TVResult = (TextView)findViewById(R.id.TVResult);
                TVResult.setText(Integer.toString(Result));
            }
        });
    }



}
