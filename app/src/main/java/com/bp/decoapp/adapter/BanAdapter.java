package com.bp.decoapp.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bp.decoapp.R;
import com.bp.decoapp.model.BanGhe;

import java.util.ArrayList;
import java.util.List;

public class BanAdapter extends ArrayAdapter<BanGhe> {

    @NonNull Activity context;
    int resource;
    @NonNull List<BanGhe> objects;

    public BanAdapter(@NonNull Activity context, int resource, @NonNull List<BanGhe> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        row = layoutInflater.inflate(this.resource, null);
        TextView _soban = row.findViewById(R.id.txtSoBan);
        ImageView _img = row.findViewById(R.id.imageView);

        BanGhe ban = this.objects.get(position);
        _soban.setText(ban.get_soBan());
        _img.setImageResource(ban.get_linkAnh());
        return row;
    }

}
