package com.example.roomcustom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDAO {
    @Query("SELECT * FROM student")
    List<Student> getAll();

    @Query("SELECT * FROM student WHERE id IN (:userIds)")
    List<Student> loadAllByIds(int[] userIds);

//    @Query("SELECT * FROM student WHERE name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    student findByName(String first, String last);

    @Insert
    void insertAll(Student users);

    @Delete
    void delete(Student user);
}
