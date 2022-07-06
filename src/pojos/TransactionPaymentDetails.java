/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Julio Lopez
 */
public class TransactionPaymentDetails {
    private String id;
    private String TransactionIndexId;
    private String Amount;
    private String PaymentUsed;
    private String Bank;
    private String CheckNo;
    private String CheckExpiration;
    private String ORNumber;
    private String created_at;
    private String updated_at;

    public TransactionPaymentDetails(String id, String TransactionIndexId, String Amount, String PaymentUsed, String Bank, String CheckNo, String CheckExpiration, String ORNumber, String created_at, String updated_at) {
        this.id = id;
        this.TransactionIndexId = TransactionIndexId;
        this.Amount = Amount;
        this.PaymentUsed = PaymentUsed;
        this.Bank = Bank;
        this.CheckNo = CheckNo;
        this.CheckExpiration = CheckExpiration;
        this.ORNumber = ORNumber;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public TransactionPaymentDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionIndexId() {
        return TransactionIndexId;
    }

    public void setTransactionIndexId(String TransactionIndexId) {
        this.TransactionIndexId = TransactionIndexId;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getPaymentUsed() {
        return PaymentUsed;
    }

    public void setPaymentUsed(String PaymentUsed) {
        this.PaymentUsed = PaymentUsed;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String Bank) {
        this.Bank = Bank;
    }

    public String getCheckNo() {
        return CheckNo;
    }

    public void setCheckNo(String CheckNo) {
        this.CheckNo = CheckNo;
    }

    public String getCheckExpiration() {
        return CheckExpiration;
    }

    public void setCheckExpiration(String CheckExpiration) {
        this.CheckExpiration = CheckExpiration;
    }

    public String getORNumber() {
        return ORNumber;
    }

    public void setORNumber(String ORNumber) {
        this.ORNumber = ORNumber;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
    
}
