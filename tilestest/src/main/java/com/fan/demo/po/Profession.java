package com.fan.demo.po;

public class Profession {
    private int id;
    private String img;
    private String development;
    private String job_name;
    private String description;
    private int gate;
    private int difficulty;
    private int lifecycle;
    private int stage_one;
    private int stage_two;
    private int company_need;
    private String salary_one;
    private String salary_two;
    private String salary_three;
    private int learnings;
    private String tips;
    private long create_at;

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

    private long update_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDevelopment() {
        return development;
    }

    public void setDevelopment(String development) {
        this.development = development;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(int lifecycle) {
        this.lifecycle = lifecycle;
    }

    public int getStage_one() {
        return stage_one;
    }

    public void setStage_one(int stage_one) {
        this.stage_one = stage_one;
    }

    public int getStage_two() {
        return stage_two;
    }

    public void setStage_two(int stage_two) {
        this.stage_two = stage_two;
    }

    public int getCompany_need() {
        return company_need;
    }

    public void setCompany_need(int company_need) {
        this.company_need = company_need;
    }

    public String getSalary_one() {
        return salary_one;
    }

    public void setSalary_one(String salary_one) {
        this.salary_one = salary_one;
    }

    public String getSalary_two() {
        return salary_two;
    }

    public void setSalary_two(String salary_two) {
        this.salary_two = salary_two;
    }

    public String getSalary_three() {
        return salary_three;
    }

    public void setSalary_three(String salary_three) {
        this.salary_three = salary_three;
    }

    public int getLearnings() {
        return learnings;
    }

    public void setLearnings(int learnings) {
        this.learnings = learnings;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
