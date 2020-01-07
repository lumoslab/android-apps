package fsktm.um.edu.sqlite3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    private SQLiteDatabaseHandler db;
    private List<Student> listStudent = new ArrayList<Student>();
    private RecyclerView recyclerView;
    private BookmarkAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new SQLiteDatabaseHandler(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_bookmark);

        Student student1 = new Student("1", "Ahmad", "1");
        Student student2 = new Student("2", "Bimo", "0");
        Student student3 = new Student("3", "Cici", "0");
        Student student4 = new Student("4", "Danang", "0");
        Student student5 = new Student("5", "Ella", "1");
//        db.addPlayer(student1);
//        db.addPlayer(student2);
//        db.addPlayer(student3);
//        db.addPlayer(student4);
//        db.addPlayer(student5);

        listStudent.addAll(db.allPlayers());
        adapter = new BookmarkAdapter(this, listStudent);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        recyclerView.addItemDecoration(decoration);        recyclerView.setAdapter(adapter);
    }
}
