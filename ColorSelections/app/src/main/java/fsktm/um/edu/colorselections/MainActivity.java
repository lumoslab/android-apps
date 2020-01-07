package fsktm.um.edu.colorselections;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String checkedStr = " checked";
    String uncheckedStr = " unchecked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox CBRed, CBGreen, CBBlue;

        CBRed = findViewById(R.id.CBRed);
        CBGreen = findViewById(R.id.CBGreen);
        CBBlue = findViewById(R.id.CBBlue);
        final Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Selected:";
                if(CBRed.isChecked()){
                    result += "\n" + CBRed.getText();
                }
                if(CBGreen.isChecked()){
                    result += "\n" + CBGreen.getText();
                }
                if(CBBlue.isChecked()){
                    result += "\n" + CBBlue.getText();
                }
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });


        CBRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CBRed.isChecked()){
                    Toast.makeText(MainActivity.this, CBRed.getText()+checkedStr, Toast.LENGTH_SHORT).show();
                    button.setBackgroundColor(getResources().getColor(R.color.colorRed));
                }
                else {
                    Toast.makeText(MainActivity.this, CBRed.getText()+uncheckedStr, Toast.LENGTH_SHORT).show();
                }
            }
        });

        CBGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CBGreen.isChecked()){
                    Toast.makeText(MainActivity.this, CBGreen.getText()+checkedStr, Toast.LENGTH_SHORT).show();
                    button.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                }
                else {
                    Toast.makeText(MainActivity.this, CBGreen.getText()+uncheckedStr, Toast.LENGTH_SHORT).show();
                }
            }
        });

        CBBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CBBlue.isChecked()){
                    Toast.makeText(MainActivity.this, CBBlue.getText()+checkedStr, Toast.LENGTH_SHORT).show();
                    button.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                }
                else {
                    Toast.makeText(MainActivity.this, CBBlue.getText()+uncheckedStr, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    public void onCheckboxClicked(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//        String str = "";
//
//        switch(view.getId()) {
//            case R.id.CBRed:
//                str = checked?"Red" + checkedStr : "Red" + uncheckedStr;
//                break;
//            case R.id.CBGreen:
//                str = checked?"Green" + checkedStr : "Green" + uncheckedStr;
//                break;
//            case R.id.CBBlue:
//                str = checked?"Blue" + checkedStr : "Blue" + uncheckedStr;
//                break;
//        }
//        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
//    }

}
