package com.fandemo.pojo.vo;

import com.fandemo.pojo.po.Title;

import java.util.List;

public class TitleVo {

        private int id;
        private String name;
        private int level;
        private String category;
        private int parent_id;
        private int status;
        private int seq;
        private int editor_id;
        private long create_at;
        private long update_at;
        private List<Title> cTitles;

        @Override
        public String toString() {
            return "Title:"+id+"NAME--"+name+"level--"+level+"CAT"+category+"status--"+status+"seq--"+seq
                    +"e_id--"+editor_id+"c_at"+create_at+"u_at"+update_at;
        }
        public List<Title> getcTitles() {
            return cTitles;
        }

        public void setcTitles(List<Title> cTitles) {
            this.cTitles = cTitles;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
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
