package com.example.heiniaodemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.viewpager2.widget.ViewPager2;

import com.example.heiniaodemo.utils.ImageText;
import com.example.heiniaodemo.utils.QiyouquanActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HeiNiaoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyRecAdapter myRecAdapter;
    private ImageText Qiyouquan;
    List<Integer> pics = new ArrayList<>();
    private List<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heiniao_activity);
        Qiyouquan = findViewById(R.id.qiyouquan);
        data = new ArrayList<>();
        for (int i=0;i<10;i++){
            data.add("这是第"+i+"个测试");
        }
        mRecyclerView = findViewById(R.id.recycler_view);
        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        myRecAdapter = new MyRecAdapter(this);
        mRecyclerView.setAdapter(myRecAdapter);
        myRecAdapter.setDataSource(data);
        pics.add(R.mipmap.ic_launcher);
        pics.add(android.R.drawable.sym_action_email);
        Qiyouquan.setOnClickListener(v -> {
            Intent intent = new Intent(HeiNiaoActivity.this , QiyouquanActivity.class);
            startActivity(intent);
        });
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
            @NonNull
            @NotNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(HeiNiaoActivity.this).inflate(R.layout.viewpager_item,parent,false);
                return new ViewHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
                ViewHolder h = (ViewHolder) holder;
                h.container.setBackgroundResource(pics.get(position));
            }

            @Override
            public int getItemCount() {
                return pics.size();
            }
        };
        ViewPager2 pagers = findViewById(R.id.pagers);
        pagers.setAdapter(adapter);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
        }
    }

    public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.MyViewHolder>{
        private List<String> dataSource;
        private Context context;

        public void setDataSource(List<String> dataSource) {
            this.dataSource = dataSource;
            notifyDataSetChanged();
        }

        public MyRecAdapter(Context context) {
            this.context = context;
            this.dataSource = new ArrayList<>();
        }

        @NonNull
        @NotNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
            holder.myImageView.setImageResource(getIcon(position));
            holder.myTextView.setText(dataSource.get(position));
        }

        public int getIcon(int position){
            switch (position % 2){
                case 0:
                    return R.mipmap.ic_launcher;
                case 1:
                    return R.mipmap.ic_launcher_round;
            }
            return 0;
        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView myImageView;
            TextView myTextView;
            public MyViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);
                myImageView = itemView.findViewById(R.id.shangpin);
                myTextView = itemView.findViewById(R.id.miaoshu);
            }
        }
    }
}
