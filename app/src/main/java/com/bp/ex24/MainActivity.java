package com.bp.ex24;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_date;
    TextView txtDate;
    Calendar calendar = Calendar.getInstance();

    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener callbackDate = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int M, int d) {
                        calendar.set(Calendar.YEAR, y);
                        calendar.set(Calendar.MONTH, M);
                        calendar.set(Calendar.DATE, d);

                        txtDate.setText(sdfD.format(calendar.getTime()));
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        callbackDate,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE)
                );
                datePickerDialog.show();
            }
        });
    }

    private void addControls() {
        btn_date = findViewById(R.id.ibtnCalen);
        txtDate = findViewById(R.id.txtNgayNhan);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1= tabHost.newTabSpec("t1");
        tab1.setIndicator(getResources().getString(R.string.product));
        tab1.setContent(R.id.tabProduct);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2= tabHost.newTabSpec("t2");
        tab2.setIndicator(getResources().getString(R.string.cart));
        tab2.setContent(R.id.tabCart);
        tabHost.addTab(tab2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Giỏ hàng của bạn");
        return super.onCreateOptionsMenu(menu);
    }

}