package com.wwq.Controller;

import com.wwq.Entry.Student;
import com.wwq.Service.StudentServiceImp;

/**
 * @author wwq
 * @date 2021/3/29-17:38
 */
public class StudentController {
    StudentServiceImp stuImp = new StudentServiceImp();
    /**
     * 添加学生信息
     *
     * @param student 学生对象
     * @return 状态码
     */
    public void addStudent(Student student) {
        int i = stuImp.addStudent(student);
        switch (i){
            case 1:
                System.out.println("添加成功");break;
            case -1:
                System.out.println("请输入正确的学生信息");break;
            case -2:
                System.out.println("学生信息重复");break;
            default: break;
        }
    }

    /**
     * 删除学生信息
     *
     * @param classId 班级id
     * @param stuId   学号
     * @return 状态码 -1 数据不合法 -2 没有该学生 1 删除成功
     */
    public void deleteStudent(String classId, String stuId) {
        int state = stuImp.deleteStudent(classId, stuId);
        switch (state){
            case 1:
                System.out.println("删除成功！！！");break;
            case -1:
                System.out.println("数据不合法");break;
            case -2:
                System.out.println("没有该学生");break;
            default: break;
        }
    }

    /**
     * 修改学生信息
     *
     * @param student 学生对象
     * @return 状态码 1修改成功 0 修改失败
     */
    public int updateStudent(Student student,int index) {
        return stuImp.updateStudent(student,index);
    }

    /**
     * 查询学生信息
     *
     * @param classId 班级id
     * @param stuId   学生id
     * @return 返回学生对象 null 没有该学生信息
     */
    public Student queryStudent(String classId, String stuId) {
        Student stu = stuImp.queryStudent(classId,stuId);
        if (stu!=null){
            return stu;
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
        return stuImp.queryStudentIndex(classId,stuId);
    }
    /**
     * 打印全部学生信息
     */
    public void printStudent(){
        stuImp.printStu();
    }
}
