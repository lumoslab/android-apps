package fsktm.um.edu.my;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserRecordAdapter extends ArrayAdapter<UserRecord> {

    public UserRecordAdapter(@NonNull Context context, int resource, @NonNull List<UserRecord> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        UserRecord userRecord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_record, parent, false);
        }

        TextView textViewPhone, textViewName, textViewEmail;
        textViewPhone = (TextView) convertView.findViewById(R.id.textViewPhone);
        textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);

        textViewPhone.setText("Phone : " + userRecord.getPhone());
        textViewName.setText("Name : " + userRecord.getName());
        textViewEmail.setText("Email : " + userRecord.getEmail());


//        ImageButton imageButtonDelete, imageButtonEdit;
//        imageButtonDelete = (ImageButton) convertView.findViewById(R.id.imageButtonDelete);
//        imageButtonDelete.setTag(userRecord.getName());
//        imageButtonDelete.setOnClickListener(myButtonClickListener);
//        imageButtonDelete.setTag(position);

        return convertView;
    }

//    private View.OnClickListener myButtonClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            String position = (String) v.getTag();
//            Toast.makeText(getContext(), "Button " + position, Toast.LENGTH_SHORT).show();
//
//            Intent updateAct = new Intent(getContext(), UpdateActivity.class);
//            updateAct.putExtra("Name", position);
//            startActivity()
//        }
//    };


}
