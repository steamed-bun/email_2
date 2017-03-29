package com.xiyou.email.entities;

public class InfoRecord {

    private Integer emailId;
    private String receiver;    //接收方
    private String activationCode; //激活码
    private Integer status = 0;    //激活状态  默认为0

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InfoRecord{" +
                "emailId=" + emailId +
                ", receiver='" + receiver + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", status=" + status +
                '}';
    }
}
