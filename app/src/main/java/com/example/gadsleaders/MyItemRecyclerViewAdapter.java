package com.example.gadsleaders;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gadsleaders.dummy.DummyContent.DummyItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<GadsLeader> mValues;
    private Context mContext;

    public MyItemRecyclerViewAdapter(List<GadsLeader> items, Context context) {

        mValues = items;
        mContext = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_learning_leader, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Picasso.with(mContext).load(mValues.get(position).getBadgeUrl()).into(holder.mLearnerImg);
        holder.mItem = mValues.get(position);
        holder.name.setText(mValues.get(position).getName());
        holder.content.setText(mValues.get(position).getHours() + " Learning Hours " + mValues.get(position).getCountry());
        Picasso.with(mContext).load(mValues.get(position).getBadgeUrl()).into(holder.mLearnerImg);

    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public final View mView;
        public final TextView name;
        public final TextView content;
        public final ImageView mLearnerImg;
        public GadsLeader mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = view.findViewById(R.id.name);
            content = view.findViewById(R.id.content);
            mLearnerImg = view.findViewById(R.id.learner_img);
            //Picasso.with(mContext).load(imageUri).into(ivBasicImage);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + name.getText() + "'";
        }
    }
}