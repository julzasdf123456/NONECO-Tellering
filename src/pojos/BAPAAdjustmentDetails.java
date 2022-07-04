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
public class BAPAAdjustmentDetails {
    private String id;
    private String AccountNumber;
    private String OldAccountNo;
    private String ServiceAccountName;
    private String AccountStatus;
    private String BillNumber;
    private String NetAmount;
    private String KwhUsed;
    private String BillId;
    private String DiscountPercentage;
    private String DiscountAmount;
    private String BAPAName;
    private String ServicePeriod;
    private String created_at;
    private String updated_at;

    public BAPAAdjustmentDetails() {
    }

    public BAPAAdjustmentDetails(String id, String AccountNumber, String OldAccountNo, String ServiceAccountName, String AccountStatus, String BillNumber, String NetAmount, String KwhUsed, String BillId, String DiscountPercentage, String DiscountAmount, String BAPAName, String ServicePeriod, String created_at, String updated_at) {
        this.id = id;
        this.AccountNumber = AccountNumber;
        this.OldAccountNo = OldAccountNo;
        this.ServiceAccountName = ServiceAccountName;
        this.AccountStatus = AccountStatus;
        this.BillNumber = BillNumber;
        this.NetAmount = NetAmount;
        this.KwhUsed = KwhUsed;
        this.BillId = BillId;
        this.DiscountPercentage = DiscountPercentage;
        this.DiscountAmount = DiscountAmount;
        this.BAPAName = BAPAName;
        this.ServicePeriod = ServicePeriod;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getKwhUsed() {
        return KwhUsed;
    }

    public void setKwhUsed(String KwhUsed) {
        this.KwhUsed = KwhUsed;
    }

    

    public String getOldAccountNo() {
        return OldAccountNo;
    }

    public void setOldAccountNo(String OldAccountNo) {
        this.OldAccountNo = OldAccountNo;
    }

    public String getServiceAccountName() {
        return ServiceAccountName;
    }

    public void setServiceAccountName(String ServiceAccountName) {
        this.ServiceAccountName = ServiceAccountName;
    }

    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String AccountStatus) {
        this.AccountStatus = AccountStatus;
    }

    public String getBillNumber() {
        return BillNumber;
    }

    public void setBillNumber(String BillNumber) {
        this.BillNumber = BillNumber;
    }

    public String getNetAmount() {
        return NetAmount;
    }

    public void setNetAmount(String NetAmount) {
        this.NetAmount = NetAmount;
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

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String BillId) {
        this.BillId = BillId;
    }

    public String getDiscountPercentage() {
        return DiscountPercentage;
    }

    public void setDiscountPercentage(String DiscountPercentage) {
        this.DiscountPercentage = DiscountPercentage;
    }

    public String getDiscountAmount() {
        return DiscountAmount;
    }

    public void setDiscountAmount(String DiscountAmount) {
        this.DiscountAmount = DiscountAmount;
    }

    public String getBAPAName() {
        return BAPAName;
    }

    public void setBAPAName(String BAPAName) {
        this.BAPAName = BAPAName;
    }

    public String getServicePeriod() {
        return ServicePeriod;
    }

    public void setServicePeriod(String ServicePeriod) {
        this.ServicePeriod = ServicePeriod;
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
