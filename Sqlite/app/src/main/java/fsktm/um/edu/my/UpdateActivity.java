package fsktm.um.edu.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    private EditText editTextPhone, editTextName, editTextEmail;
    private String oriName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        oriName = name;

        editTextPhone = (EditText)findViewById(R.id.editTextPhone);
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);

        editTextPhone.setText(phone);
        editTextName.setText(name);
        editTextName.setSelection(name.length());
        editTextEmail.setText(email);
    }

    public void updateRecord(View v) {
        String phone, name, email;

        phone = editTextPhone.getText().toString();
        if(phone.isEmpty()){
            editTextPhone.setError(getString(R.string.error_phone));
            return;
        }
        name = editTextName.getText().toString();
        if(name.isEmpty()){
            editTextName.setError(getString(R.string.error_name));
            return;
        }
        email= editTextEmail.getText().toString();
        if(email.isEmpty()){
            editTextEmail.setError(getString(R.string.error_email));
            return;
        }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError(getString(R.string.error_invalid_email));
            return;
        }
        // save into userRecord
        UserRecord userRecord = new UserRecord();
        userRecord.setPhone(phone);
        userRecord.setName(name);
        userRecord.setEmail(email);

        UserSQLHelper userDataSource = new UserSQLHelper(this);
        userDataSource.updateUser(userRecord, oriName);

        this.finish(); //Terminate this Activity
    }

    public void deleteRecord(View v) {
        UserSQLHelper userDataSource = new UserSQLHelper(this);
        userDataSource.deleteUser(oriName);

        this.finish(); //Terminate this Activity
    }
}
