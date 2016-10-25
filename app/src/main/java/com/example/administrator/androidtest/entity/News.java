package com.example.administrator.androidtest.entity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/25.
 */

public class News {
    String message;
    String status;
    ArrayList<Data> data;

    public News(String message, String status, ArrayList<Data> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    @Override
    public String toString() {
        return "News{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    static class Data {

        String summary;
        String icon;
        String stamp;
        String title;
        int nid;
        String link;
        int type;


        public void setSummary(String summary) {
            this.summary = summary;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setStamp(String stamp) {
            this.stamp = stamp;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setNid(int nid) {
            this.nid = nid;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getSummary() {
            return summary;
        }

        public String getIcon() {
            return icon;
        }

        public String getStamp() {
            return stamp;
        }

        public String getTitle() {
            return title;
        }

        public int getNid() {
            return nid;
        }

        public String getLink() {
            return link;
        }

        public int getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "summary='" + summary + '\'' +
                    ", icon='" + icon + '\'' +
                    ", stamp='" + stamp + '\'' +
                    ", title='" + title + '\'' +
                    ", nid=" + nid +
                    ", link='" + link + '\'' +
                    ", type=" + type +
                    '}';
        }

        public Data(String summary, String icon, String stamp, String title, int nid, String link, int type) {
            this.summary = summary;
            this.icon = icon;
            this.stamp = stamp;
            this.title = title;
            this.nid = nid;
            this.link = link;
            this.type = type;
        }
    }

}
