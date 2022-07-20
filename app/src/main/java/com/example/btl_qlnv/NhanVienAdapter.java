package com.example.btl_qlnv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {

    private Context context;
    private List<Nhanvien> nhanvienList;
    public NhanVienAdapter(Context context, List<Nhanvien> list){
        this.context=context;
        this.nhanvienList=list;
    }
    @Override
    public int getCount() {
        return nhanvienList.size();
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
        NhanVienAdapter.ViewHolder viewHolder;
        if(view==null)
        {
            viewHolder=new NhanVienAdapter.ViewHolder();

            LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_item_nv,null);


            viewHolder.tv_manv=view.findViewById(R.id.tv_manv);
            viewHolder.tv_hoten=view.findViewById(R.id.tv_hoten);
            viewHolder.tv_ngaysinh=view.findViewById(R.id.tv_ngaysinh);
            viewHolder.tv_diachi=view.findViewById(R.id.tv_diachi);
            viewHolder.tv_chucvu=view.findViewById(R.id.tv_chucvu);
            viewHolder.tv_sdt=view.findViewById(R.id.tv_sdt);
            viewHolder.tv_email=view.findViewById(R.id.tv_email);
            viewHolder.iv_gioitinh=view.findViewById(R.id.iv_gioitinh);
            viewHolder.tv_phongban=view.findViewById(R.id.tv_phongban);
            viewHolder.tv_luong=view.findViewById(R.id.tv_luong);
            view.setTag(viewHolder);


        }
        else{
            viewHolder=(NhanVienAdapter.ViewHolder)view.getTag();
        }
        Nhanvien nv=nhanvienList.get(i);
        viewHolder.tv_manv.setText("Mã Nhân Viên:" + nv.getManhanvien());
        viewHolder.tv_hoten.setText("Tên Nhân Viên:" + nv.getTennhanvien());
        viewHolder.tv_ngaysinh.setText("Ngày Sinh:" + nv.getNgaysinh());
        viewHolder.tv_diachi.setText("Địa Chỉ:" + nv.getDiachi());
        viewHolder.tv_chucvu.setText("Chức Vụ:" + nv.getChucvu());
        viewHolder.tv_sdt.setText("Số Điện Thoại:" + nv.getSdt());
        viewHolder.tv_email.setText("Email:"+ nv.getEmail());
        viewHolder.tv_phongban.setText("Phòng Ban:" + nv.getMaphong());
        viewHolder.tv_luong.setText("Lương:" + nv.getLuong());
        if(nv.getGioitinh()==0){
            viewHolder.iv_gioitinh.setImageResource(R.drawable.nu);

        }else {
            viewHolder.iv_gioitinh.setImageResource(R.drawable.nam);
        }



        return view;
    }
    class ViewHolder{
        TextView tv_manv, tv_hoten,tv_ngaysinh,tv_diachi,tv_chucvu,tv_phongban,tv_luong,tv_sdt,tv_email;
        ImageView iv_gioitinh;
    }
}
