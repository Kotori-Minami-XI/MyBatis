package com.Kotori.test;

import com.Kotori.domain.Student;
import com.Kotori.domain.Teacher;
import com.Kotori.mapper.TeacherMapper;
import com.Kotori.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestTeacherMapper {
    @Test
    public void testGetAllTeacher() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> list = mapper.getAllTeacher();
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void testGetAllTeacherByStep() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherWithId(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
