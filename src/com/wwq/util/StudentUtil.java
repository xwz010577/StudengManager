package com.wwq.util;

import com.sun.xml.internal.ws.api.pipe.Tube;
import com.wwq.Entry.Student;

/**
 * 验证学生信息的合法性
 * @author wwq
 * @date 2021/3/30-10:18
 */
public class StudentUtil {
    /**
     * 验证学生全部信息的合法性
     * @param student 学生对象
     * @return
     */
    public static boolean student(Student student){
        int len = student.getClassId().length();
        if (stuName(student.getName()) && stuSex(student.getStuId()) && stuAge(student.getAge()) && stuClassId(student.getClassId()) && stuId(student.getStuId())){
            return true;
        }
        return false;
    }

    /**
     * 验证班级号和学号的合法性
     * @param classID 班级号
     * @param stuId 学号
     * @return
     */
    public static boolean stuClassIdAndId(String classID,String stuId){
        if (stuClassId(classID) && stuId(stuId)){
            return true;
        }
        return false;
    }
    /**
     * 验证姓名
     * @param name 姓名
     * @return
     */
    public static boolean stuName(String name){
        int len = name.length();
        if (len>3 && 12 > len){
            return true;
        }
        return false;
    }

    /**
     * 验证性别
     * @param sex 性别
     * @return
     */
    public static boolean stuSex(String sex){
        int len = sex.length();
        if (len == 1 && sex.equals("男") || sex.equals("女")){
            return true ;
        }
        return false;
    }

    /**
     * 验证年龄
     * @param age 年龄
     * @return
     */
    public static boolean stuAge(int age){
        if (age>12 && age <120){
            return true;
        }
        return false;
    }

    /**
     * 验证班级号的合法性
     * @param classId 班级号
     * @return
     */
    public static boolean stuClassId(String classId){
        int len = classId.length();
        if (len == 4){
            return true;
        }
        return false;
    }

    /**
     * 验证学号的合法性
     * @param stuId
     * @return
     */
    public static boolean stuId(String stuId){
        int len = stuId.length();
        if (len == 3){
            return true;
        }
        return false;
    }
}
