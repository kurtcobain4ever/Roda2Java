package com.fandemo.pojo.po;

public class Comment {
    private int id;
    private int works_id;
    private String content;
    private int status;
    private int type;
    private int editor_id;
    private String visitor_ip;
    private int parent_id;
    private long create_at;
    private long update_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorks_id() {
        return works_id;
    }

    public void setWorks_id(int works_id) {
        this.works_id = works_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }



    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(int editor_id) {
        this.editor_id = editor_id;
    }

    public String getVisitor_ip() {
        return visitor_ip;
    }

    public void setVisitor_ip(String visitor_ip) {
        this.visitor_ip = visitor_ip;
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
