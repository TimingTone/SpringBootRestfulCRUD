package com.whiterose.springboot.dao;

import com.whiterose.springboot.entities.Faculty;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FacultyDao {

    private static Map<Integer, Faculty> faculties = null;

    static{
        faculties = new HashMap<Integer, Faculty>();

        faculties.put(101, new Faculty(101, "计算机系"));
        faculties.put(102, new Faculty(102, "数学系"));
        faculties.put(103, new Faculty(103, "外语系"));
        faculties.put(104, new Faculty(104, "经管系"));
        faculties.put(105, new Faculty(105, "航天系"));
    }

    public Collection<Faculty> getFaculties(){
        return faculties.values();
    }

    public static Faculty getFaculty(Integer id){
        return faculties.get(id);
    }
}
