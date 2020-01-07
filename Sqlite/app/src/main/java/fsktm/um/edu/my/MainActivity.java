package fsktm.um.edu.my;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listViewRecords;
    UserSQLHelper userSQLHelper;
    List<UserRecord> values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewRecords = (ListView)findViewById(R.id.listViewRecords);
        listViewRecords.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Setting: ", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
        Intent updateAct = new Intent(this, UpdateActivity.class);

        UserRecord user = values.get(position);
        updateAct.putExtra("name", user.getName());
        updateAct.putExtra("email", user.getEmail());
        updateAct.putExtra("phone", user.getPhone());
        startActivity(updateAct);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
        updateList();
    }

    private void updateList() {
        userSQLHelper = new UserSQLHelper(this);

        values = userSQLHelper.getAllUsers();
        if(values.isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.no_record_message), Toast.LENGTH_SHORT).show();
        }
        UserRecordAdapter adapter = new UserRecordAdapter(this, R.layout.user_record, values);
        //Link adapter to ListView
        listViewRecords.setAdapter(adapter);
    }
}
