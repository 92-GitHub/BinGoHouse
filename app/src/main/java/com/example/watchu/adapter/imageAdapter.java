package com.example.watchu.adapter;

import android.app.Activity;
import android.view.*;
import android.view.ViewGroup;
import android.content.*;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.*;

import java.util.ArrayList;
import java.util.List;

import com.example.watchu.R;
import com.example.watchu.domain.Image;
import com.example.watchu.util.ImageUtil;

public class imageAdapter extends RecyclerView.Adapter <imageAdapter.ViewHolder> {
    private List<Image> datas = new ArrayList<Image>();
    private final Context context;
    private final LayoutInflater inflater;

    public imageAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binData(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<Image> datas) {
        this.datas.clear();//先清楚数据
        this.datas.addAll(datas);//再添加数据

        //接下来是刷新数据，只有刷新数据之后，recyclerview才知道数据刷新了
        //下面只是其中一种刷新方法
        notifyItemRangeInserted(0, this.datas.size());
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }

        public void binData(Image image) {
            //显示图片
            ImageUtil.show((Activity) context, iv, image.getUri());
        }
    }
}

