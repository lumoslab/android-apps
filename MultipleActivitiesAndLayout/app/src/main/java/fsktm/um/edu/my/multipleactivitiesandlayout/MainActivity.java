package fsktm.um.edu.my.multipleactivitiesandlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BtnRLClicked(View view) {
        Intent RLAct = new Intent (this, RelativeLayout.class);
        startActivityForResult(RLAct, 1);
    }

    public void BtnCLClicked(View view) {
        Intent CLAct = new Intent (this, ConstraintLayout.class);
        startActivity(CLAct);
    }

    public void BtnGLClicked(View view) {
        Intent GLAct = new Intent (this, GridLayout.class);
        startActivity(GLAct);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                String strName = data.getStringExtra("Name");
                Toast.makeText(getApplicationContext(), "Welcome back, " + strName + "!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
