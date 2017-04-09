package com.boopalan.FirebaseProjectStaff;

/**
 * Created by Boopalan on 01-Feb-2017.
 */

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boopalan.FirebaseProjectStaff.model.sendlocation;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class staffDetail3 extends Fragment {


    private static final String TAG = staffDetail3.class.getSimpleName();
    public Bitmap b;
    FirebaseDatabase database;
    DatabaseReference myRef, myRef1;
    Bitmap imageBitmap;
    private RecyclerView mBlogList, mBlogList1;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<sendlocation, staffDetail3.BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<sendlocation, staffDetail3.BlogViewHolder>(sendlocation.class, R.layout.design_row3, staffDetail3.BlogViewHolder.class, myRef1) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, sendlocation model, int position) {
                viewHolder.setAuthor(model.getAuthor());
                viewHolder.setLat(model.getLat());
                viewHolder.setLon(model.getLon());
            }
        };
        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.staff_detail, container, false);
        mBlogList = (RecyclerView) v.findViewById(R.id.blog_list);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(getContext()));
        database = FirebaseDatabase.getInstance();
        myRef1 = database.getReference("posts/location/");
        return v;
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView author, lat, lon;
        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            author = (TextView) itemView.findViewById(R.id.auth);
            lat = (TextView) itemView.findViewById(R.id.lat);
            lon = (TextView) itemView.findViewById(R.id.lon);
        }
        public void setAuthor(String author1) {
            author.setText(author1);
        }
        public void setLat(String lat1){lat.setText(lat1);}
        public void setLon(String lon1){lon.setText(lon1);}
    }
}