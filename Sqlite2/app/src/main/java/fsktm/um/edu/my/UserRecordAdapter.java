package fsktm.um.edu.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserRecordAdapter extends RecyclerView.Adapter<UserRecordAdapter.UserRecordViewHolder> {

    private Context context;
    private List<UserRecord> userRecords;

    // constructor
    public UserRecordAdapter(Context context, List<UserRecord> userRecords) {
        this.context = context;
        this.userRecords = userRecords;
    }

    // reference to the views for each data item
    public static class UserRecordViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewPhone;
        public TextView textViewName;
//        public TextView textViewEmail;
//        public ImageButton imageButtonEdit;
//        public ImageButton imageButtonDelete;

        public UserRecordViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPhone = (TextView) itemView.findViewById(R.id.editTextPhone);
            textViewName = (TextView) itemView.findViewById(R.id.editTextName);
//            textViewEmail = (TextView) itemView.findViewById(R.id.editTextEmail);
//            imageButtonEdit = (ImageButton) itemView.findViewById(R.id.imageButtonEdit);
//            imageButtonDelete = (ImageButton) itemView.findViewById(R.id.imageButtonDelete);
        }
    }


    // create new views
    @NonNull
    @Override
    public UserRecordAdapter.UserRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_record, parent, false);
        return new UserRecordViewHolder(view);
    }

    // replace contents
    @Override
    public void onBindViewHolder(@NonNull UserRecordViewHolder holder, int position) {
        UserRecord userRecord = userRecords.get(position);

        holder.textViewPhone.setText("Phone : " + userRecord.getPhone());
        holder.textViewName.setText("Name : " + userRecord.getName());
//        holder.textViewEmail.setText("Email : " + userRecord.getEmail());
//        holder.imageButtonEdit.setImageResource(R.drawable.ic_edit_black_24dp);
//        holder.imageButtonDelete.setImageResource(R.drawable.ic_delete_black_24dp);
//        holder.imageButtonDelete.setVisibility(View.VISIBLE);
//        holder.imageButtonEdit.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return userRecords.size();
    }
}
