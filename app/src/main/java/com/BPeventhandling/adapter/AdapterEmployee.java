package com.BPeventhandling.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.BPeventhandling.MainActivity;
import com.BPeventhandling.R;
import com.BPeventhandling.model.Employee;

import java.util.List;

public class AdapterEmployee extends ArrayAdapter<Employee> {
    //Màn hình sủ dụng this layout
    Activity context;
    // Layout cho từng dòng muốn hiển thị
    int resource;
    // Danh sách nguồn dữ liệu muốn hiển thị trên màn hình
    @NonNull List<Employee> objects;
    public AdapterEmployee(@NonNull Activity context, int resource, @NonNull List<Employee> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        // Lớp build layout bình thường thành code java mà android có thể sử dụng  đc
        // load file xml vào hệ thống và build thành code để chương trình có thể sử dụng
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        // đối số this.resource  chính là item.xml ta truyền vào khi gọi AdapterNhanVien
        row = layoutInflater.inflate(this.resource, null);

//        ImageView _img = row.findViewById(R.id.imageView);
        ImageView _img = row.findViewById(R.id.imageView);
        TextView _profile = row.findViewById(R.id.txtEmployee);
        CheckBox _cbDelete = row.findViewById(R.id.btnDelete);

        Employee employee = this.objects.get(position);

        if(employee.getGender() == true)  {
            _img.setImageResource(R.drawable.male);
        }else {
            _img.setImageResource(R.drawable.woman);
        }

        _profile.setText(employee.get_firstName() + " " + employee.get_LastName());
        // khi nhấn checkbox sẽ luuw vị trí sang Array "vị trí bên class main"
        _cbDelete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(_cbDelete.isChecked()) {
                    MainActivity._position.add(position);
                }else {
                    for(int x:MainActivity._position) {
                        if(x == position) {
                            MainActivity._position.remove(x);
                        }
                    }
                }
            }
        });
        return row;
    }
}
