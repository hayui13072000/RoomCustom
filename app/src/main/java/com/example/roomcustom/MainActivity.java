package com.example.roomcustom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> listStudent;
    StudentListViewAdapter lvAdapter;
    ListView lvStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        Student student=new Student();
        student.setId(1);
        student.setName("Nguyen Ngoc Ha");

        StudentDAO userDao = db.studentDAO();
        userDao.insertAll(student);
        student.setId(2);
        student.setName("Nguyen Ngoc Ha");

        List<Student> users = userDao.getAll();
        System.out.println(users);
//
//        lvAdapter=new StudentListViewAdapter((ArrayList<Student>) users);
//
//        lvStudent = findViewById(R.id.lvName);
//        lvStudent.setAdapter(lvAdapter);
    }
}