package com.simplepayment.projections;

public interface TransferMinProjection {
    String getSenderFirstName();

    String getSenderLastName();

    double getAmount();

    String getReceiverFirstName();

    String getReceiverLastName();
}
