package com.whiterose.springboot.dao;

import com.whiterose.springboot.dao.impl.GradeDaoImpl;
import com.whiterose.springboot.entities.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
public class GradeDao {
    private static Map<Integer, Grade> grade = null;
    private static Integer initId=1006;

    public void save(Grade grade){
        if(grade.getId()==null){
            grade.setId(initId++);
        }

        IGradeDao gradeDao = new GradeDaoImpl();
        gradeDao.deleteGradeByID(grade.getId());
        gradeDao.addGrade(grade);
    }

    public Collection<Grade> getAll(){return grade.values();}

    public Grade get(Integer id){ return grade.get(id);}

    public void delete(Integer id){grade.remove(id);}
}
