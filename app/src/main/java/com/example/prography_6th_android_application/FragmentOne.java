package com.example.prography_6th_android_application;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentOne extends Fragment {
    private View view;
    private List<movies> movie;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.frag_layout_1,container,false);


        Log.d("onResponse", "1");
        setRetrofit();

        return view;
    }
    private void setRetrofit(){

        Log.d("onResponse", "1");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Log.d("onResponse", "2");

        final RemoteService remote = retrofit.create(RemoteService.class);
        Call<List<movies>> call = remote.getMovie();

        call.enqueue(new Callback<List<movies>>() {

            @Override
            public void onResponse(Call<List<movies>> call, Response<List<movies>> response) {
                String test;

                try{
                    movie = response.body();

                        RecyclerView mRecyclerView = view.findViewById(R.id.recycler_view1);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        movielist_recyclerAdapter list_adapter = new movielist_recyclerAdapter(getContext(), movie);
                        mRecyclerView.setAdapter(list_adapter);

                }catch (Exception e){
                    Log.d("onResponse", "Error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<movies>> call, Throwable t) {

            }
        });
    }

}
