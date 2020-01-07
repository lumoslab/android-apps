package fsktm.um.edu.my;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    UserSQLHelper userSQLHelper;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private UserRecordAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getApplicationContext());

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
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
        updateList();
    }

    private void updateList() {
        userSQLHelper = new UserSQLHelper(this);

        final List<UserRecord> values = userSQLHelper.getAllUsers();
//        Toast.makeText(getApplicationContext(), "Update list", Toast.LENGTH_SHORT).show();
        if(values.isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.no_record_message), Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(), "Update list" + values, Toast.LENGTH_SHORT).show();

        adapter = new UserRecordAdapter(this, values);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
