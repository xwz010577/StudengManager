package com.wwq.Service;

import com.wwq.Entry.Student;
import com.wwq.util.StudentUtil;

import java.util.ArrayList;

/**
 * @author wwq
 * @date 2021/3/29-17:37
 */
public class StudentServiceImp implements StudentService{
    /**
     * 数据信息（数据库）
     */
    private static ArrayList<Student> stu = new ArrayList<>();

    /**
     * 初始化数据库
     */
    public StudentServiceImp() {
        stu.add(new Student("王武强",'男',18,"2103","001"));
        stu.add(new Student("王二",'女',18,"2103","002"));
        stu.add(new Student("张三",'男',18,"2103","003"));
        stu.add(new Student("李四",'女',18,"2103","004"));
        stu.add(new Student("王五",'女',18,"2104","001"));
        stu.add(new Student("李六",'男',18,"2104","002"));
        stu.add(new Student("侯",'男',18,"2104","003"));
    }

    /**
     * 添加学生信息
     * @param student 学生对象
     * @return 状态码 1-成功 -1 学生对象不合法 -2 学生已存在
     */
    @Override
    public int addStudent(Student student) {
        if (!StudentUtil.student(student) || student == null){
            return -1;
        }
        if (queryStudent(student.getClassId(),student.getStuId()) == null) {
            stu.add(student);
            return 1;
        }else {
            return -2;
        }
    }

    /**
     * 删除学生信息
     *
     * @param classId 班级id
     * @param stuId   学号
     * @return 状态码 -1 数据不合法 -2 没有该学生 1 删除成功
     */
    @Override
    public int deleteStudent(String classId, String stuId) {
        if (!StudentUtil.stuClassIdAndId(classId,stuId)){
            return -1;
        }
        Student student = queryStudent(classId,stuId);
        if (student!=null) {
            stu.remove(student);
            return 1;
        }
        return -2;
    }

    /**
     * 修改学生信息
     *
     * @param student 学生对象
     * @return 状态码 1 修改成功 0修改失败
     */
    @Override
    public int updateStudent(Student student,int index) {
        Student stu = StudentServiceImp.stu.set(index, student);
        if (stu!=null){
            return 1;
        }
        return 0;
    }

    /**
     * 查询学生信息
     *
     * @param classId 班级id
     * @param stuId   学生id
     * @return 返回学生对象 null 没有该学生信息
     */
    @Override
    public Student queryStudent(String classId, String stuId) {
        if (!StudentUtil.stuClassIdAndId(classId,stuId)){
            return null;
        }
        if (!stu.isEmpty()){
            for (Student str :stu) {
                if (str.getClassId().equals(classId) && str.getStuId().equals(stuId)){
                    return str;
                }
            }
        }
        return null;
    }
    /**
     * 查询学生信息并返回学生下标
     * @param classId 班级id
     * @param stuId   学生id
     * @return 返回学生对象的下标 -1 没有该学生
     */
    public int queryStudentIndex(String classId, String stuId) {
        Student stu1 = new Student(classId, stuId);
        if (!stu.isEmpty()){
            for (int i = 0; i < stu.size(); i++) {
                if (stu.get(i).equals(stu1)){
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    /**
     * 打印全部学生信息
     */
    public void printStu(){
        for (Student student : stu) {
            System.out.println(student.toString());
        }
    }
}
