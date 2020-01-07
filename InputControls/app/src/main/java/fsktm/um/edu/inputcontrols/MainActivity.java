package fsktm.um.edu.inputcontrols;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.planets_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout
        .simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


    }

    public void onRadioButtonClicked(View view) {
        // is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // check which radio button was clicked
        switch(view.getId()) {
            case R.id.pirates:
                if (checked) {
                    Toast.makeText(this,"Pirates checked.", Toast.LENGTH_SHORT).show();
                    break;
                }
            case  R.id.ninjas:
                if (checked) {
                    Toast.makeText(this,"Ninjas checked.", Toast.LENGTH_SHORT).show();
                    break;
                }

        }
    }

    public void onToggleClicked(View view) {
        // is the toggle on
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {

        } else {

        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timepicker");
    }






}