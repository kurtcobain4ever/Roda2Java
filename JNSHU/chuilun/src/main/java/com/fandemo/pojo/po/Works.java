package com.fandemo.pojo.po;

public class Works {
    private int id;
    private String works_name;
    private int title_id;
    private int status;
    private String loc;
    private int editor_id;
    private long create_at;
    private long update_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorks_name() {
        return works_name;
    }

    public void setWorks_name(String works_name) {
        this.works_name = works_name;
    }

    public int getTitle_id() {
        return title_id;
    }

    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(int editor_id) {
        this.editor_id = editor_id;
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
}
