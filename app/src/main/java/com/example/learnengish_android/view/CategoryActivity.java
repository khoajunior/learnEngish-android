package com.example.learnengish_android.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.learnengish_android.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{

    ListView listView;
    Button btnChoice;

    String[] arrayTopic = {"Con người","Cuộc sống","Khoa học","Động vật","Tình yêu","Văn học"};
    List<String> listChoice;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        listView = findViewById(R.id.list_view);
        btnChoice = findViewById(R.id.buttonChoice);
        btnChoice.setOnClickListener(this);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,arrayTopic);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonChoice:
                listChoice = new ArrayList<>();
                SparseBooleanArray itemChecked = listView.getCheckedItemPositions();
                for(int i=0; i< itemChecked.size();i++){
                    int key = itemChecked.keyAt(i);
                    boolean value = itemChecked.get(key);
                    if(value){
                        listChoice.add(listView.getItemAtPosition(key).toString());
                    }
                }
                if(listChoice.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Không có chủ đề nào được chọn",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Các chủ đề được chọn"+listChoice,Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
}
