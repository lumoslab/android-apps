package fsktm.um.edu.fragmentvia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                if (v == findViewById(R.id.BTNPuppy)) {
                    fragment = new FragmentPuppy();
                } else {
                    fragment = new FragmentBunny();
                }

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.FragOutput, fragment);
                transaction.commit();
            }
        };

        Button BtnPuppy = (Button)findViewById(R.id.BTNPuppy);
        BtnPuppy.setOnClickListener(listener);
        Button BtnBunny = (Button)findViewById(R.id.BTNBunny);
        BtnBunny.setOnClickListener(listener);
    }
}
