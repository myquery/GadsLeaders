package com.example.gadsleaders;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaders.dummy.DummyContent;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class LearningLeader extends Fragment {

    // TODO: Customize parameter argument names
    // private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    // private int mColumnCount = 1;

    public static List<GadsLeader> gadsLeader;
    public boolean topLeaders = false;
    public boolean skillIq = false;
    private List<GadsLeader> gadsList;

    public LearningLeader() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LearningLeader newInstance(List<GadsLeader> gadsCount) {
        LearningLeader fragment = new LearningLeader();
        Bundle args = new Bundle();
        args.putParcelable("TOP_LEARNERS_LEADERS", (Parcelable) gadsCount);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//          Log.e("check-if-data-is-coming", gadsLeader+"");
//
//
//        if (getArguments() != null) {
//            //  mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
//            gadsList =  getArguments().getParcelable("TOP_LEARNERS_LEADERS");
//
//            Log.e("check-if-data-is-coming", gadsList+"");
//            System.exit(1);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_leader_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(gadsLeader, getContext()));
        }
        return view;
    }


}