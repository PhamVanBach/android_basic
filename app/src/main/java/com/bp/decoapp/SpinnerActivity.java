package com.bp.decoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner spinnerFilter;

    List<String> listFilter;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        buildEvents();
    }

    private void buildEvents() {
        listFilter = new ArrayList<>();
        String[] arrFilter = getResources().getStringArray(R.array.arrFilterProductName);

        for (String item : arrFilter) {
            listFilter.add(item);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, listFilter);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerFilter.setAdapter(adapter);
        spinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerActivity.this, listFilter.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void initWidgets() {
        spinnerFilter = findViewById(R.id.spinnerFilter);
    }
}
