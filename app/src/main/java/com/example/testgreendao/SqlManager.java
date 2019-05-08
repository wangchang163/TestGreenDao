package com.example.testgreendao;

import java.util.List;

public class SqlManager {

    public static void insertStudent(Student student){
        MyApplication.getDaoSession().getStudentDao().insert(student);
    }

    public static void deleteStudent(long id){
        MyApplication.getDaoSession().getStudentDao().deleteByKey(id);
    }

    public static void updateStudent(Student student){
        MyApplication.getDaoSession().getStudentDao().update(student);
    }

    public static List<Student> queryStudent(){
        return MyApplication.getDaoSession().getStudentDao().loadAll();
    }
}
