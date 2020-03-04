package com.example.prography_6th_android_application;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class movielist_recyclerAdapter extends RecyclerView.Adapter<movielist_recyclerAdapter.ItemViewHolder>{
    private List<movies> listData=new ArrayList<>();
    private Context context;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private ItemViewHolder holder;
    private  View view;
    private int position;

    public movielist_recyclerAdapter(Context context, List<movies> list){
        this.context = context;
        this.listData = list;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public movielist_recyclerAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        return new ItemViewHolder(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull movielist_recyclerAdapter.ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position),position);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(movies data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
}

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView0;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private movies data;
        private int position;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textView0=itemView.findViewById(R.id.num);
            textView1 = itemView.findViewById(R.id.title);
            textView2 = itemView.findViewById(R.id.director);
            textView3 = itemView.findViewById(R.id.release);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    Intent intent = new Intent(context.getApplicationContext(), movie_detail.class);
                    intent.putExtra("title",listData.get(pos).getName());
                    intent.putExtra("director",listData.get(pos).getDirector());
                    intent.putExtra("producer",listData.get(pos).getProducer());
                    intent.putExtra("release",listData.get(pos).getRelease_date());
                    intent.putExtra("rt_score",listData.get(pos).getRt_score());
                    intent.putExtra("description",listData.get(pos).getDescription());
                    Log.d("position",Integer.toString(pos));
                    context.startActivity(intent);

                }
            });
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        void onBind(final movies _data, final int position) {
            this.data = _data;
            this.position = position;
            final String title = data.getName();
            final String director = data.getDirector();
            final String release = data.getRelease_date();
            String num=Integer.toString(position+1);
            final String producer=data.getProducer();
            final String rt_score=data.getRt_score();
            final String description=data.getDescription();
            textView0.setText(num+". ");
            textView1.setText(title);
            textView2.setText("director: "+director);
            textView3.setText("release date: "+release);

        }
    }
}


