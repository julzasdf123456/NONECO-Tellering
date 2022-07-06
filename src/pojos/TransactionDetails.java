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
public class TransactionDetails {
    private String id;
    private String TransactionIndexId;
    private String Particular;
    private String Amount;
    private String VAT;
    private String Total;
    private String AccountCode;
    private String created_at;
    private String updated_at;

    public TransactionDetails() {
    }

    public TransactionDetails(String id, String TransactionIndexId, String Particular, String Amount, String VAT, String Total, String AccountCode, String created_at, String updated_at) {
        this.id = id;
        this.TransactionIndexId = TransactionIndexId;
        this.Particular = Particular;
        this.Amount = Amount;
        this.VAT = VAT;
        this.Total = Total;
        this.AccountCode = AccountCode;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getAccountCode() {
        return AccountCode;
    }

    public void setAccountCode(String AccountCode) {
        this.AccountCode = AccountCode;
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
