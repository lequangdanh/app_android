package com.example.btl_qlnv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PhongBanAdapter extends BaseAdapter {
    private Context context;
    private List<PhongBan> phongbanList;
    public PhongBanAdapter(Context context, List<PhongBan> list){
        this.context=context;
        this.phongbanList=list;
    }
    @Override
    public int getCount() {
        return phongbanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null)
        {
            viewHolder=new ViewHolder();

            LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_item_phongban,null);


            viewHolder.maphong=view.findViewById(R.id.maphong);
            viewHolder.tenphong=view.findViewById(R.id.tenphong);
            view.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)view.getTag();
        }
        PhongBan pb=phongbanList.get(i);
        viewHolder.maphong.setText("Mã phòng: "+pb.getId_phong());
        viewHolder.tenphong.setText("Tên Phòng: "+pb.getTenphong());



        return view;
    }
    class ViewHolder{
        TextView maphong, tenphong;
    }

}

