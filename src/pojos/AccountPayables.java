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
public class AccountPayables {
    private String id;
    private String AccountCode;
    private String AccountTitle;
    private String AccountDescription;
    private String DefaultAmount;
    private String VATPercentage;
    private String Notes;
    private String created_at;
    private String updated_at;

    public AccountPayables() {
    }

    public AccountPayables(String id, String AccountCode, String AccountTitle, String AccountDescription, String DefaultAmount, String VATPercentage, String Notes, String created_at, String updated_at) {
        this.id = id;
        this.AccountCode = AccountCode;
        this.AccountTitle = AccountTitle;
        this.AccountDescription = AccountDescription;
        this.DefaultAmount = DefaultAmount;
        this.VATPercentage = VATPercentage;
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

    public String getAccountCode() {
        return AccountCode;
    }

    public void setAccountCode(String AccountCode) {
        this.AccountCode = AccountCode;
    }

    public String getAccountTitle() {
        return AccountTitle;
    }

    public void setAccountTitle(String AccountTitle) {
        this.AccountTitle = AccountTitle;
    }

    public String getAccountDescription() {
        return AccountDescription;
    }

    public void setAccountDescription(String AccountDescription) {
        this.AccountDescription = AccountDescription;
    }

    public String getDefaultAmount() {
        return DefaultAmount;
    }

    public void setDefaultAmount(String DefaultAmount) {
        this.DefaultAmount = DefaultAmount;
    }

    public String getVATPercentage() {
        return VATPercentage;
    }

    public void setVATPercentage(String VATPercentage) {
        this.VATPercentage = VATPercentage;
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
