package com.example.testgreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private long id = 18;
    private ListView listView;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = System.currentTimeMillis();
                SqlManager.insertStudent(new Student(id, "小王" + id));
                notifyData();
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.getDaoSession().getStudentDao().deleteAll();
                notifyData();
            }
        });
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SqlManager.updateStudent(new Student("小李"));
                notifyData();

            }
        });

    }

    private void notifyData() {
        List<Student> students = SqlManager.queryStudent();
        list.clear();
        for (Student student : students) {
            list.add(student.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);//新建并配置ArrayAapeter
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
