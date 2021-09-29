package com.bp.mykara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.bp.mykara.adapter.Adapter_Songs;
import com.bp.mykara.model.Songs;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;

    ListView list_view;
    Adapter_Songs adapter_songs;
    Adapter_Songs adapter_songs2;
    ArrayList<Songs> listSongs;
    ArrayList<Songs> listSongs2;
    ListView list_view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void createTab() {
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Songs");
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Favorite");
        tabHost.addTab(tabSpec2);
    }

    private void addEvents() {

        tabHost = findViewById(R.id.tabHostKara);
        tabHost.setup();
        createTab();

    }

    private void addControls() {

        list_view = findViewById(R.id.list_view);
        list_view2 = findViewById(R.id.list_view_2);

        listSongs = new ArrayList<>();
        listSongs.add(new Songs(R.drawable.ic_unlike, "00001" , "Con duong mua", "Ho Quang Hieu", false));
        listSongs.add(new Songs(R.drawable.ic_unlike, "00002" , "Con duong mua 1", "Ho Quang Hieu", false));
        listSongs.add(new Songs(R.drawable.ic_unlike, "00003" , "Con duong mua 2", "Ho Quang Hieu", false));
        listSongs.add(new Songs(R.drawable.ic_unlike, "00004" , "Con duong mua 3", "Ho Quang Hieu", false));
        listSongs.add(new Songs(R.drawable.ic_unlike, "00005" , "Con duong mua 4", "Ho Quang Hieu", false));
        listSongs.add(new Songs(R.drawable.ic_unlike, "00006" , "Con duong mua 5", "Ho Quang Hieu", false));

        adapter_songs = new Adapter_Songs(
                MainActivity.this, R.layout.song, listSongs
        );
        list_view.setAdapter(adapter_songs);

        listSongs2 = new ArrayList<>();
        Songs song = new Songs(R.drawable.ic_unlike, "00001" , "Con duong mua", "Ho Quang Hieu", true);
        listSongs2.add(song);
        adapter_songs2 = new Adapter_Songs(
                MainActivity.this, R.layout.song, listSongs2
        );
        if(listSongs.get(0).getIsClicked() == true) {
            list_view2.setAdapter(adapter_songs2);
        }
    }


}