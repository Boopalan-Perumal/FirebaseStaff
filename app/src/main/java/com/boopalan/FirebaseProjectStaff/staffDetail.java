package com.boopalan.FirebaseProjectStaff;

/**
 * Created by Boopalan on 01-Feb-2017.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boopalan.FirebaseProjectStaff.model.Post;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

public class staffDetail extends Fragment {


    private static final String TAG = staffDetail.class.getSimpleName();
    private RecyclerView mBlogList,mBlogList1;
    FirebaseDatabase database;
    DatabaseReference myRef,myRef1;
    public Bitmap b;
    Bitmap imageBitmap;

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Post,staffDetail.BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Post, staffDetail.BlogViewHolder>(Post.class,R.layout.design_row,staffDetail.BlogViewHolder.class,myRef
        ) {


            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Post post, int position) {
                viewHolder.setAuthor(post.getAuthor());
                viewHolder.setTtile(post.getEvent1());
                viewHolder.setDate(post.getDate1());
                viewHolder.setVenue(post.getVenue1());
                viewHolder.setTime(post.getTime1());
            }



        };
        mBlogList.setAdapter(firebaseRecyclerAdapter);

    }
    public static Bitmap decodeFromFirebaseBase64(String image) throws IOException {
        byte[] decodedByteArray = Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.staff_detail, container, false);
        mBlogList = (RecyclerView)v.findViewById(R.id.blog_list);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(getContext()));



        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("posts/students");
        myRef1 = database.getReference("posts/photo");
        return v;
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;
        //        ImageView imageView;
        TextView event,time,venue,date,author;



        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            event = (TextView)itemView.findViewById(R.id.event1);
            time = (TextView)itemView.findViewById(R.id.time1);
            venue = (TextView)itemView.findViewById(R.id.venue1);
            date = (TextView)itemView.findViewById(R.id.date1);
            author = (TextView)itemView.findViewById(R.id.auth);


//            imageView = (ImageView)itemView.findViewById(R.id.imageViewv);


        }

        public void setTtile(String event1){
            event.setText(event1);
        }
        public void setTime(String time1){
            time.setText(time1);
        }
        public void setDate(String date1){
            date.setText(date1);
        }
        public void setVenue(String venue1){
            venue.setText(venue1);
        }
        public void setAuthor(String author1){
            author.setText(author1);
        }
        public void setImage(Context ctx, Bitmap image){
//            Picasso.with(ctx).load(String.valueOf(image)).into(imageView);
        }


    }
}