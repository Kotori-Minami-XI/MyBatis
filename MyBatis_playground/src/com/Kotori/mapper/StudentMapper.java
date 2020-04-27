package com.Kotori.mapper;

import com.Kotori.domain.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> getStudentByTeacherId(Integer teacher_id);

}
