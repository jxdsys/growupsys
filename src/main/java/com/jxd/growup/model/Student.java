package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("student")
public class Student {
    //学生id
    @TableId(type = IdType.AUTO)
    private int stuid;
    //学生姓名
    private String stuname;
    //学生性别
    private String sex;
    //民族
    private String people;
    //出生日期
    private String birthday;
    //籍贯
    private String natives;
    //是否结婚
    private String marry;
    //联系电话
    private String tel;
    //身份证号
    private String cardid;
    //毕业学校
    private String school;
    //专业
    private String profession;
    //备注
    private String content;
    //图片地址
    private String pictureAdd;
    //班期，外键
    private int termid;
    //部门id，未毕业部门id为0
    private int deptno;
    //入职日期
    private String hiredate;

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNatives() {
        return natives;
    }

    public void setNatives(String natives) {
        this.natives = natives;
    }

    public String getMarry() {
        return marry;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }





    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictureAdd() {
        return pictureAdd;
    }

    public void setPictureAdd(String pictureAdd) {
        this.pictureAdd = pictureAdd;
    }


    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public int getTermid() {
        return termid;
    }

    public void setTermid(int termid) {
        this.termid = termid;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * 无参构造方法
     */
    public Student() {
    }



    /**
     * 新增
     * @param stuname
     * @param sex
     * @param termId
     */
    public Student(String stuname, String sex, int termId) {
        this.stuname = stuname;
        this.sex = sex;
        this.termid = termId;
    }

    /**
     * 管理员修改
     * @param stuid
     * @param stuname
     * @param sex
     * @param termId
     */
    public Student(int stuid, String stuname, String sex, int termId) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.sex = sex;
        this.termid = termId;
    }
}
