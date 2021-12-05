package com.example.demo;

public class marks {
    String subject,marks_scored,totalmarks;
    Float a,b,c;

    public marks(String subject, String marks_scored, String totalmarks) {
        this.subject = subject;
        this.marks_scored = marks_scored;
        this.totalmarks = totalmarks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMarks_scored() {
        return marks_scored;
    }

    public void setMarks_scored(String marks_scored) {
        this.marks_scored = marks_scored;
    }

    public String getTotalmarks() {
        return totalmarks;
    }

    public void setTotalmarks(String totalmarks) {
        this.totalmarks = totalmarks;
    }

    public Float getC() {
        a=Float.parseFloat(marks_scored);
        b=Float.parseFloat(totalmarks);
        c=a/b*100;
        return c;
    }

    public void setC(Float c) {
        this.c = c;
    }
}
