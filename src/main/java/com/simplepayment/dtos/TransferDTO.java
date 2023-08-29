package com.simplepayment.dtos;

import com.simplepayment.projections.TransferMinProjection;

public class TransferDTO {
    private String senderName;
    private double amount;
    private String receiverName;

    public TransferDTO() {
    }

    public TransferDTO(String senderName, double amount, String receiverName) {
        this.senderName = senderName;
        this.amount = amount;
        this.receiverName = receiverName;
    }

    public TransferDTO(TransferMinProjection projection) {
        this.senderName = projection.getSenderFirstName() + " " + projection.getSenderLastName();
        this.amount = projection.getAmount();
        this.receiverName = projection.getReceiverFirstName() + " " + projection.getReceiverLastName();
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}
