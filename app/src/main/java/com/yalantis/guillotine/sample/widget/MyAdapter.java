package com.yalantis.guillotine.sample.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.yalantis.guillotine.sample.R;
import com.yalantis.guillotine.sample.activity.EventDetails;

import java.util.ArrayList;

/**
 * Created by my hp on 3/13/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {
    private ArrayList<String> mDataset;
Context context;


    @Override
    public void onClick(View v) {


    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public RelativeLayout rl;
        public ViewHolder(View v, MyAdapter myAdapter) {
            super(v);
            v.setOnClickListener(myAdapter);
            mTextView= (TextView) v.findViewById(R.id.text_recyle_list_item);
            rl=(RelativeLayout)v.findViewById(R.id.relative_recycleviewer);


        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myDataset, Context context) {
        mDataset = myDataset;
this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclevieweritem, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v,this);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));
holder.rl.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent in=new Intent(context, EventDetails.class);
        Bundle b=new Bundle();
        b.putInt("pos",position);
        in.putExtras(b);
        context.startActivity(in);
    }
});
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}