package com.wwq;

import com.wwq.Controller.StudentController;
import com.wwq.Entry.Student;

import java.util.Scanner;

/**
 * @author wwq
 * @date 2021/3/29-19:31
 */
public class StudentManageSystem {


    public static void main(String[] args) {
        scanStudent();
    }

    /**
     * 学生信息管理系统启动入口
     */
    public static void scanStudent(){
        Scanner scan = new Scanner(System.in);
        StudentController stuCon = new StudentController();
        boolean flag = true;
        while (flag) {
            System.out.println("欢迎进入学生信息管理系统，1---添加学生信息，2---删除，3---查询，4---修改，5---打印所以学生信息，886---退出学生信息系统");
            int instructions = scan.nextInt();
            switch (instructions){
                case 1:
                    addStudent(scan,stuCon);break;
                case 2:
                    System.out.println("请输入班级号和学号");
                    String classId = scan.next();String stuId = scan.next();
                    deleteStudent(classId,stuId,stuCon);break;
                case 3:
                    System.out.println("请输入班级号和学号");
                     classId = scan.next(); stuId = scan.next();
                     queryStudent(classId,stuId,stuCon);break;
                case 4:
                    updateStudent(scan, stuCon);
                    break;
                case 5:
                     stuCon.printStudent(); break;
                default:
                    flag = !flag;break;
            }
        }
        scan.close();
    }

    /**
     * 通过输入学号和班级号，修改学生姓名、年龄
     * @param scan 输入流
     * @param stuCon 控制器
     */
    private static void updateStudent(Scanner scan, StudentController stuCon) {
        String classId;
        String stuId;
        System.out.println("请输入班级号和学号");
        classId = scan.next();
        stuId = scan.next();
        Student student = stuCon.queryStudent(classId,stuId);
        if (student!=null){
            int index = stuCon.queryStudentIndex(classId,stuId);
            System.out.println("请输入需要姓名和年龄");
            String name = scan.next();
            int age = scan.nextInt();
            Student stu = new Student(name,student.getSex(),age,student.getClassId(),student.getStuId());
            int state = stuCon.updateStudent(stu, index);
            if (state==1){
                System.out.println("修改成功！！！");
            }else {
                System.out.println("修改失败");
            }
        }
    }

    /**
     * 输入学生信息进行添加操作
     * @param scan
     */
    private static void addStudent(Scanner scan,StudentController stuCon) {
        System.out.println("请输入学生信息");
        System.out.print("请输入学生姓名：");
        String name = scan.next();
        System.out.print("请输入学生性别：");
        char sex = scan.next().toCharArray()[0];
        System.out.print("请输入学生年龄：");
        int age = scan.nextInt();
        System.out.print("请输入学生班级号：");
        String classId = scan.next();
        System.out.print("请输入学生学号：");
        String stuId = scan.next();
        Student student = new Student(name, sex, age, classId, stuId);
        stuCon.addStudent(student);

    }

    /**
     * 通过班级号和学号删除对应的学生
     * @param classID 班级号
     * @param stuId 学号
     * @param stuCon   操作控制器
     */
    public static void deleteStudent(String classID,String stuId,StudentController stuCon){
        stuCon.deleteStudent(classID,stuId);
    }

    /**
     * 通过班级号和学号查询对应的学生
     * @param classID 班级号
     * @param stuId 学号
     * @param stuCon   操作控制器
     */
    public static void queryStudent(String classID,String stuId,StudentController stuCon){
        Student stu = stuCon.queryStudent(classID,stuId);
        if (stu!=null){
            System.out.println(stu.toString());
        }else {
            System.out.println("没有该学生信息");
        }
    }
}
