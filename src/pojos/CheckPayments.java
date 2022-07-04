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
public class CheckPayments {
    private String id;
    private String AccountNumber;
    private String ServicePeriod;
    private String BillId;
    private String ORNumber;
    private String Amount;
    private String PaymentUsed;
    private String CheckNo;
    private String Bank;
    private String CheckExpiration;
    private String UserId;
    private String created_at;
    private String updated_at;

    public CheckPayments() {
    }

    public CheckPayments(String id, String AccountNumber, String ServicePeriod, String BillId, String ORNumber, String Amount, String PaymentUsed, String CheckNo, String Bank, String CheckExpiration, String UserId, String created_at, String updated_at) {
        this.id = id;
        this.AccountNumber = AccountNumber;
        this.ServicePeriod = ServicePeriod;
        this.BillId = BillId;
        this.ORNumber = ORNumber;
        this.Amount = Amount;
        this.PaymentUsed = PaymentUsed;
        this.CheckNo = CheckNo;
        this.Bank = Bank;
        this.CheckExpiration = CheckExpiration;
        this.UserId = UserId;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getServicePeriod() {
        return ServicePeriod;
    }

    public void setServicePeriod(String ServicePeriod) {
        this.ServicePeriod = ServicePeriod;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String BillId) {
        this.BillId = BillId;
    }

    public String getORNumber() {
        return ORNumber;
    }

    public void setORNumber(String ORNumber) {
        this.ORNumber = ORNumber;
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

    public String getCheckNo() {
        return CheckNo;
    }

    public void setCheckNo(String CheckNo) {
        this.CheckNo = CheckNo;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String Bank) {
        this.Bank = Bank;
    }

    public String getCheckExpiration() {
        return CheckExpiration;
    }

    public void setCheckExpiration(String CheckExpiration) {
        this.CheckExpiration = CheckExpiration;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
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
