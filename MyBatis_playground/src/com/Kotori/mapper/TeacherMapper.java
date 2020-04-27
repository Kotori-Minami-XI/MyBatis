package com.Kotori.mapper;

import com.Kotori.domain.Teacher;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> getAllTeacher();
    public Teacher getTeacherWithId(Integer teacher_id);

}
