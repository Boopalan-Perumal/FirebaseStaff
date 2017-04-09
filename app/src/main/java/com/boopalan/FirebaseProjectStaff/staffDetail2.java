package com.boopalan.FirebaseProjectStaff;

/**
 * Created by Boopalan on 01-Feb-2017.
 */

import android.content.Context;
import android.content.Intent;
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

import com.boopalan.FirebaseProjectStaff.activity.Form;
import com.boopalan.FirebaseProjectStaff.model.Url;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

public class staffDetail2 extends Fragment {


    private static final String TAG = staffDetail2.class.getSimpleName();
    private RecyclerView mBlogList,mBlogList1;
    FirebaseDatabase database;
    DatabaseReference myRef,myRef1;
    public Bitmap b;
    Bitmap imageBitmap;

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Url,staffDetail2.BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Url, staffDetail2.BlogViewHolder>(Url.class,R.layout.design_row2,staffDetail2.BlogViewHolder.class,myRef1
        ) {


            @Override
            protected void populateViewHolder(final BlogViewHolder viewHolder, Url model, int position) {

                viewHolder.setAuthor(model.getAuthor());
                viewHolder.setUrl(model.getUrl());
                viewHolder.url.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = viewHolder.url.getText().toString();

                            Intent intent = new Intent(getActivity(),Form.class);
                            intent.putExtra("message", url);
                            getActivity().startActivity(intent);

                    }
                });
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
//        myRef = database.getReference("posts/students");
        myRef1 = database.getReference("posts/url");
        return v;
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView author,url;



        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            author = (TextView)itemView.findViewById(R.id.auth);
            url = (TextView)itemView.findViewById(R.id.url1);


        }
        public void setAuthor(String author1){
            author.setText(author1);
        }
        public void setUrl(String url1){
            url.setText(url1);
        }

        public void setImage(Context ctx, Bitmap image){
//            Picasso.with(ctx).load(String.valueOf(image)).into(imageView);
        }


    }
}