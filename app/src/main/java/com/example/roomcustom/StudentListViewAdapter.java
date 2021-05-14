package com.example.roomcustom;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentListViewAdapter extends BaseAdapter {
    ArrayList<Student> listProduct;

    StudentListViewAdapter(ArrayList<Student> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        //có chỉ số position trong listProduct
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return listProduct.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        //Nếu null cần tạo mới

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.item_name, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        Student product = (Student) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.tvName)).setText(String.format("%s", product.getName()));

        return viewProduct;
    }
}
