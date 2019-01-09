package com.example.kittaphornj.colorblind;

public class TestImageInfo {
    public Integer image;
    public String normalAnswer;
    public String blueBlindAnswer;
    public String allBlindAnswer;
    public String redGreenAnswer;

    public TestImageInfo(){

    }
    public TestImageInfo(Integer image, String normalAnswer, String blueBlindAnswer, String allBlindAnswer, String redGreenAnswer) {
        this.image = image;
        this.normalAnswer = normalAnswer;
        this.blueBlindAnswer = blueBlindAnswer;
        this.allBlindAnswer = allBlindAnswer;
        this.redGreenAnswer = redGreenAnswer;
    }

    public Integer getImage() {
        return image;
    }

    public String getNormalAnswer() {
        return normalAnswer;
    }

    public String getBlueBlindAnswer() {
        return blueBlindAnswer;
    }

    public String getAllBlindAnswer() {
        return allBlindAnswer;
    }

    public String getRedGreenAnswer() {
        return redGreenAnswer;
    }
    //////////////////////

    public void setImage(Integer image) {
        this.image = image;
    }

    public void setNormalAnswer(String normalAnswer) {
        this.normalAnswer = normalAnswer;
    }

    public void setBlueBlindAnswer(String blueBlindAnswer) {
        this.blueBlindAnswer = blueBlindAnswer;
    }

    public void setAllBlindAnswer(String allBlindAnswer) {
        this.allBlindAnswer = allBlindAnswer;
    }

    public void setRedGreenAnswer(String redGreenAnswer) {
        this.redGreenAnswer = redGreenAnswer;
    }
}
