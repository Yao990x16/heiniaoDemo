package com.example.heiniaodemo.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heiniaodemo.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QiyouquanActivity extends AppCompatActivity {
    private Qiyou[] friends = {new Qiyou(R.mipmap.ic_launcher),new Qiyou(R.mipmap.ic_launcher),new Qiyou(R.mipmap.ic_launcher)};
    private List<Qiyou> friendList = new ArrayList<>();
    private QiyouquanAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qiyouquan_layout);
        initQiyouquan();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new QiyouquanAdapter(friendList);
        recyclerView.setAdapter(adapter);
    }
    private void initQiyouquan() {
        friendList.clear();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int index = random.nextInt(friends.length);
            friendList.add(friends[index]);
        }
    }
    static class QiyouquanAdapter extends RecyclerView.Adapter<QiyouquanAdapter.ViewHolder> {
        private Context mContext;
        private List<Qiyou> mQiyouList;
        static class ViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            ImageView image1;
            ImageView image2;
            ImageView image3;
            public ViewHolder(View view) {
                super(view);
                cardView = (CardView) view;
                image1 = (ImageView) view.findViewById(R.id.qiyou_image);
                image2 = (ImageView) view.findViewById(R.id.qiyou_imag);
                image3 = (ImageView) view.findViewById(R.id.qiyou_ima);
            }
        }
        public QiyouquanAdapter(List<Qiyou> friendList) {
            mQiyouList = friendList;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (mContext == null) {
                mContext = parent.getContext();
            }
            View view = LayoutInflater.from(mContext).inflate(R.layout.qiyouquanrecycleview_item,parent,false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder,int position) {
            getRandomLength();
            holder.image2.setVisibility(View.GONE);
            holder.image3.setVisibility(View.GONE);
            if (getRandomLength() == 1) {
                holder.image1.setVisibility(View.VISIBLE);
            } else if (getRandomLength() == 2) {
                holder.image1.setVisibility(View.VISIBLE);
                holder.image2.setVisibility(View.VISIBLE);
            } else if (getRandomLength() == 3) {
                holder.image1.setVisibility(View.VISIBLE);
                holder.image2.setVisibility(View.VISIBLE);
                holder.image3.setVisibility(View.VISIBLE);
            }
        }
        @Override
        public int getItemCount() {
            return mQiyouList.size();
        }
        private int getRandomLength() {
            Random random = new Random();
            int length = random.nextInt(3) + 1;
            return length;
        }
    }
}


