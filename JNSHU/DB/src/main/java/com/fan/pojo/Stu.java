package com.fan.pojo;

public class Stu {
    private int id;
    private String name;
    private long qq;
    private String major;
    private String graduate;
    private String reportlink;
    private String wish;
    private long create_at;
    private long update_at;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getReportlink() {
        return reportlink;
    }

    public void setReportlink(String reportlink) {
        this.reportlink = reportlink;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }
    public String toString(){
        return "StudentInformation: [ID:"+id+" NAME:"+name+" QQ:"+qq+" MAJOR:"+major+" GRADUATE:"+graduate+" REPORTLINK:"+reportlink+" WISH:"+wish+"]";
    }
}
