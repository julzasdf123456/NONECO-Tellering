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
public class ParticularPaymentTransactions {
    private String id;
    private String ServiceConnectionId;
    private String Particular;
    private String Amount;
    private String Vat;
    private String Total;
    private String created_at;
    private String updated_at;
    private String ParticularName;
    private String AccountCode;

    public ParticularPaymentTransactions() {
    }

    public ParticularPaymentTransactions(String id, String ServiceConnectionId, String Particular, String Amount, String Vat, String Total, String created_at, String updated_at, String ParticularName, String AccountCode) {
        this.id = id;
        this.ServiceConnectionId = ServiceConnectionId;
        this.Particular = Particular;
        this.Amount = Amount;
        this.Vat = Vat;
        this.Total = Total;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.ParticularName = ParticularName;
        this.AccountCode = AccountCode;
    }

    public String getAccountCode() {
        return AccountCode;
    }

    public void setAccountCode(String AccountCode) {
        this.AccountCode = AccountCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceConnectionId() {
        return ServiceConnectionId;
    }

    public void setServiceConnectionId(String ServiceConnectionId) {
        this.ServiceConnectionId = ServiceConnectionId;
    }

    public String getParticular() {
        return Particular;
    }

    public void setParticular(String Particular) {
        this.Particular = Particular;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getVat() {
        return Vat;
    }

    public void setVat(String Vat) {
        this.Vat = Vat;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
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

    public String getParticularName() {
        return ParticularName;
    }

    public void setParticularName(String ParticularName) {
        this.ParticularName = ParticularName;
    }
    
    
}
