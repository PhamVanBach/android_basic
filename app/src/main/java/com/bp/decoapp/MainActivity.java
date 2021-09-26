package com.bp.decoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bp.decoapp.adapter.BanAdapter;
import com.bp.decoapp.model.BanGhe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String filterText = "";
    Spinner spinnerFilter;
    List<String> listFilter;
    ArrayAdapter<String> adapter;

    GridView _gridView;
    BanAdapter banAdapter;
    ArrayList<BanGhe> dsBan = new ArrayList<>();
    ImageButton btnSearch;
    Spinner productFiller;

    MultiAutoCompleteTextView multiAutoCompleteTextView;
    String[] _arrProduct;
    ArrayAdapter<String> adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
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
                filterText  =  listFilter.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, multiAutoCompleteTextView.getText().toString() + filterText, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void searchProduct() {
//        Toast.makeText(this, multiAutoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        //search
        btnSearch = findViewById(R.id.ibtnSearch);
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteSearch);

        //fillter
        spinnerFilter = findViewById(R.id.spinnerFilter);

        //grid view
        _gridView = findViewById(R.id.grid_view);

        //search
         _arrProduct= getResources().getStringArray(R.array.arrProduct);
        adapterProduct = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, _arrProduct);
        multiAutoCompleteTextView.setAdapter(adapterProduct);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
         //grid view
        dsBan.add(new BanGhe("Ban so 1", R.drawable.table));
        dsBan.add(new BanGhe("Ban so 2", R.drawable.table));
        dsBan.add(new BanGhe("Ban so 3", R.drawable.table));
        dsBan.add(new BanGhe("Ban so 4", R.drawable.table));
        dsBan.add(new BanGhe("Ban so 5", R.drawable.table));
        dsBan.add(new BanGhe("Ban so 6", R.drawable.table));

        banAdapter = new BanAdapter(
                MainActivity.this, R.layout.item_ban, dsBan
        );
        _gridView.setAdapter(banAdapter);
    }
}