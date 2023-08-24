package com.simplepayment.dtos;

public class TransferReqBodyDTO {
    private Long sender_id;
    private double amount;
    private Long receiver_id;

    public TransferReqBodyDTO() {
    }

    public TransferReqBodyDTO(Long sender_id, double amount, Long receiver_id) {
        this.sender_id = sender_id;
        this.amount = amount;
        this.receiver_id = receiver_id;
    }

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Long receiver_id) {
        this.receiver_id = receiver_id;
    }
}
