package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.activity.FenLeiShangpinActivity;
import com.example.administrator.jingdong.bean.Classify2Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class MyClassify2Adapter extends RecyclerView.Adapter<MyClassify2Adapter.ViewHolder> {

    private Context context;
    private List<Classify2Bean.DataBean> list;

    public MyClassify2Adapter(Context context) {
        this.context = context;

    }

    public void setList(List<Classify2Bean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.classifyitem2,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv.setText(list.get(position).getName());
        final List<Classify2Bean.DataBean.ListBean> list = this.list.get(position).getList();
        final MyClassify3Adapter myClassify3Adapter = new MyClassify3Adapter(context);
        holder.mrv.setLayoutManager(new GridLayoutManager(context,3, GridLayoutManager.VERTICAL,false));

        myClassify3Adapter.setList(list);
        holder.mrv.setAdapter(myClassify3Adapter);
        myClassify3Adapter.setOnItemClickListener(new MyClassifyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int pscid = list.get(position).getPscid();

                Intent intent = new Intent(context, FenLeiShangpinActivity.class);
               intent.putExtra("pscid",pscid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final RecyclerView mrv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.classifytv2);
            mrv = itemView.findViewById(R.id.rv3);
        }

    }
}
