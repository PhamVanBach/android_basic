package com.BPeventhandling;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.BPeventhandling.adapter.AdapterEmployee;
import com.BPeventhandling.model.Employee;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_employees;
    ArrayList<Employee> listEmployees = new ArrayList<>();
    AdapterEmployee adapterEmployee;

    // Tạo một list để lưu vị trí click checkbox đẻ xóa nhân viên
    public static ArrayList<Integer> _position = new ArrayList<>();

    Button _btnAdd, _btnDelete;
    EditText _txtFirstName, _txtLastName;
    RadioButton _rbMale;
    boolean gender = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Manage Employee");
        return super.onCreateOptionsMenu(menu);

    }

    private void addEvent() {
        _btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(!_position.isEmpty()) {
                    for(int k:_position) {
                        listEmployees.remove(k);
                    }
                    _position.clear();
                    adapterEmployee.notifyDataSetChanged();
                }else {
                    Toast.makeText(MainActivity.this, "You should pick employee first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(_rbMale.isChecked()){
            gender =  true;
        }else{
            gender = false;
        }

        _btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listEmployees.add(new Employee(_txtFirstName.getText().toString(), _txtLastName.getText().toString(), gender));
                _txtFirstName.setText("");
                _txtLastName.setText("");
                _rbMale.isChecked();
            }
        });
    }

    private void addControls() {

        _btnDelete = findViewById(R.id.btnDelete);
        _btnAdd = findViewById(R.id.btnAdd);
        _txtFirstName = findViewById(R.id.edtxtFirstName);
        _txtLastName = findViewById(R.id.edtxtLastName);
        _rbMale = findViewById(R.id.rbMale);

        lv_employees = findViewById(R.id.ListEmployees);
        listEmployees.add(new Employee("hehe", "hehehe", true));
        listEmployees.add(new Employee("hehe", "hehehe", false));
        listEmployees.add(new Employee("hehe", "hehehe", true));
        listEmployees.add(new Employee("hehe", "hehehe", true));
        adapterEmployee = new AdapterEmployee(
                MainActivity.this,
                R.layout.item_viewemployee,
                listEmployees
        );
        lv_employees.setAdapter(adapterEmployee);
    }
}