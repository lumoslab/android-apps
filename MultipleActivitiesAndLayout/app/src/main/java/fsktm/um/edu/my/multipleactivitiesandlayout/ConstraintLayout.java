package fsktm.um.edu.my.multipleactivitiesandlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConstraintLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl);
    }

    public void BtnBackClicked(View view)
    {
        Intent MainAct = new Intent (this, MainActivity.class);
        startActivity(MainAct);
    }
}