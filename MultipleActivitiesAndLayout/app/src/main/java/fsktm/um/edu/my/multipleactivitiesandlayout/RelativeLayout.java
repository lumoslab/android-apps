package fsktm.um.edu.my.multipleactivitiesandlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RelativeLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rl);
    }

    public void RLBtnBackClicked(View view)
    {
        EditText ETName = (EditText)findViewById(R.id.ETName);
        Intent RLBackIntent = new Intent();
        RLBackIntent.putExtra("Name", ETName.getText().toString());
        setResult(RESULT_OK, RLBackIntent);
        finish();
    }
}
