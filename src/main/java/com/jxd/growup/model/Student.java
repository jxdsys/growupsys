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
    private String stuName;
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
    private String cardId;
    //毕业学校
    private String school;
    //专业
    private String profession;
    //备注
    private String content;
    //图片地址
    private String pictureAdd;
    //班期，外键
    private int termId;
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

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
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
     * 学生自己修改信息和展示学生信息时调用的构造方法
     * @param stuid
     * @param stuName
     * @param sex
     * @param people
     * @param birthday
     * @param natives
     * @param marry
     * @param tel
     * @param cardId
     * @param school
     * @param profession
     * @param content
     * @param pictureAdd
     * @param termId
     * @param deptno
     * @param hiredate
     */
    public Student(int stuid, String stuName, String sex, String people, String birthday, String natives, String marry, String tel, String cardId, String school, String profession, String content, String pictureAdd, int termId, int deptno, String hiredate) {
        this.stuid = stuid;
        this.stuName = stuName;
        this.sex = sex;
        this.people = people;
        this.birthday = birthday;
        this.natives = natives;
        this.marry = marry;
        this.tel = tel;
        this.cardId = cardId;
        this.school = school;
        this.profession = profession;
        this.content = content;
        this.pictureAdd = pictureAdd;
        this.termId = termId;
        this.deptno = deptno;
        this.hiredate = hiredate;
    }

    /**
     * 管理员新增学生时调用的构造方法
     * @param stuid
     * @param termId
     */
    public Student(int stuid, int termId) {
        this.stuid = stuid;
        this.termId = termId;
    }
}
