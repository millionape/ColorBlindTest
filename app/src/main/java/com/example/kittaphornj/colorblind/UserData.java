package com.example.kittaphornj.colorblind;

public class UserData {
    String age;
    String date;
    String firstTest;
    String name;
    String resultText;
    String score0;
    String score1;
    String score2;
    String score3;

    public  UserData(){

    }
    public UserData(String age, String date, String firstTest, String name, String resultText, String score0, String score1, String score2, String score3) {
        this.age = age;
        this.date = date;
        this.firstTest = firstTest;
        this.name = name;
        this.resultText = resultText;
        this.score0 = score0;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstTest() {
        return firstTest;
    }

    public void setFirstTest(String firstTest) {
        this.firstTest = firstTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getScore0() {
        return score0;
    }

    public void setScore0(String score0) {
        this.score0 = score0;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getScore3() {
        return score3;
    }

    public void setScore3(String score3) {
        this.score3 = score3;
    }
}
