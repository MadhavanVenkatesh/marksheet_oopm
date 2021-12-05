package com.example.demo;

public class Student {
    private String Name;
    private String Roll;
    private String Div;
    private String Branch;
    private Integer Year;
    private String Mail;
    private Integer Phone;

    public Student(String name, String roll, String div, String branch, Integer year, String mail, Integer phone) {
        Name = name;
        Roll = roll;
        Div = div;
        Branch = branch;
        Year = year;
        Mail = mail;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getDiv() {
        return Div;
    }

    public void setDiv(String div) {
        Div = div;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }
}
