package fsktm.um.edu.fragmentorientation;


import android.os.Bundle;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitlesFragment extends ListFragment {

    boolean mDualPane;
    int mCurCheckPosition = 0;


    public TitlesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Populate list with titles
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Shakespeare.TITLES));

        //Check availability of frame to embed the details fragment
        View detailsFrame = getActivity().findViewById(R.id.details);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            //restore last state for checked position
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (mDualPane) {
            //in dual pane mode the list view highlights the selected item
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            //make sure our UI is in correct state
            showDetails(mCurCheckPosition);
        }


    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }


//    Helper function

    void showDetails(int index) {
        mCurCheckPosition = index;
        if (mDualPane) {

            getListView().setItemChecked(index, true);
            DetailsFragment details = (DetailsFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.details);

            if (details == null || details.getShownIndex() != index) {
                //make new fragment to show this selection
                details = DetailsFragment.newInstance(index);

                //execute a transaction, replacign any existing fragment
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                if (index == 0) {
                    ft.add(R.id.details, details);
                } else {
                    ft.replace(R.id.details, details);
                }
                ft.setTransition((FragmentTransaction.TRANSIT_FRAGMENT_FADE));
                ft.commit();
            }
        } else {
            //else we need to launch new activity to display
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}