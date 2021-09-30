package com.bp.mykara.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bp.mykara.MainActivity;
import com.bp.mykara.R;
import com.bp.mykara.model.Songs;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Songs extends ArrayAdapter<Songs> {

    Activity context;
    int resource;
    List<Songs> objects;

    public Adapter_Songs(@NonNull Activity context, int resource, @NonNull List<Songs> objects) {
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

        TextView songID = row.findViewById(R.id.txtSongID);
        TextView songName = row.findViewById(R.id.txtSongName);
        TextView singer = row.findViewById(R.id.txtSinger);
        ImageButton _btnImg = row.findViewById(R.id.btnStar);

        Songs songs = this.objects.get(position);
        songID.setText(songs.getSong_id());
        songName.setText(songs.getSong_name());
        singer.setText(songs.getSinger());
        _btnImg.setImageResource(songs.getID_img());
        _btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(songs.getIsClicked() == false){

                    songs.setClicked(true);
                        _btnImg.setImageResource(R.drawable.ic_liked);
                    Boolean hehe = songs.getIsClicked();
                    Toast.makeText(getContext(),   hehe.toString(), Toast.LENGTH_SHORT).show();
                }else {
                    songs.setClicked(false);
                    _btnImg.setImageResource(R.drawable.ic_unlike);
                    Boolean hehe = songs.getIsClicked();
                    Toast.makeText(getContext(), hehe.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        return row;
    }

}
