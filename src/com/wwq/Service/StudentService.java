package com.wwq.Service;

import com.wwq.Entry.Student;

/**
 * 学生管理系统功能接口
 * @author wwq
 * @date 2021/3/29-17:22
 */
public interface StudentService {

    /**
     * 添加学生信息
     * @param student 学生对象
     * @return 状态码 1-成功 -1 学生对象为空 -2 学生已存在
     */
    int addStudent(Student student);

    /**
     *删除学生信息
     * @param classId 班级id
     * @param stuId 学号
     * @return 状态码
     */
    int deleteStudent(String classId,String stuId);

    /**
     * 修改学生信息
     * @param student 学生对象
     * @param index 数据库需要修改的下标
     * @return 状态码
     */
    int updateStudent(Student student,int index);

    /**
     * 查询学生信息
     * @param classId 班级id
     * @param stuId 学生id
     * @return 返回学生对象
     */
    Student queryStudent(String classId,String stuId);
}
