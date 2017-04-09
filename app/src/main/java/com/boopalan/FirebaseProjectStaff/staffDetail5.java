package com.boopalan.FirebaseProjectStaff;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Boopalan on 04-Apr-2017.
 */

public class staffDetail5 extends Fragment implements View.OnClickListener {

    RelativeLayout r1,r2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.latdummy, container, false);
        r1 = (RelativeLayout)v.findViewById(R.id.r1);
        r2 = (RelativeLayout)v.findViewById(R.id.r2);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view1) {
        switch (view1.getId()){
            case R.id.r1:
                String coordinates = String.format("geo:0,0?q=10.729700,78.310549");
                Intent intentMap = new Intent( Intent.ACTION_VIEW, Uri.parse(coordinates) );
                startActivity( intentMap );
                break;
            case R.id.r2:
                String coordinates1 = String.format("geo:0,0?q=13.0381863,80.2736837");
                Intent intentMap1 = new Intent( Intent.ACTION_VIEW, Uri.parse(coordinates1) );
                startActivity( intentMap1 );
                break;

        }
    }
}
