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
public class OCLMonthly {
    private String id;
    private String AccountNumber;
    private String ServicePeriod;
    private String Amount;
    private String IsBilled;
    private String IsPaid;
    private String LinkedBillNumber;
    private String Notes;
    private String created_at;
    private String updated_at;

    public OCLMonthly() {
    }

    public OCLMonthly(String id, String AccountNumber, String ServicePeriod, String Amount, String IsBilled, String IsPaid, String LinkedBillNumber, String Notes, String created_at, String updated_at) {
        this.id = id;
        this.AccountNumber = AccountNumber;
        this.ServicePeriod = ServicePeriod;
        this.Amount = Amount;
        this.IsBilled = IsBilled;
        this.IsPaid = IsPaid;
        this.LinkedBillNumber = LinkedBillNumber;
        this.Notes = Notes;
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

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getIsBilled() {
        return IsBilled;
    }

    public void setIsBilled(String IsBilled) {
        this.IsBilled = IsBilled;
    }

    public String getIsPaid() {
        return IsPaid;
    }

    public void setIsPaid(String IsPaid) {
        this.IsPaid = IsPaid;
    }

    public String getLinkedBillNumber() {
        return LinkedBillNumber;
    }

    public void setLinkedBillNumber(String LinkedBillNumber) {
        this.LinkedBillNumber = LinkedBillNumber;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
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
