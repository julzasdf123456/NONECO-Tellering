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
public class PaidBills {
    private String id;
    private String BillNumber;
    private String AccountNumber;
    private String ServicePeriod;
    private String ORNumber;
    private String ORDate;
    private String DCRNumber;
    private String KwhUsed;
    private String Teller;
    private String OfficeTransacted;
    private String PostingDate;
    private String PostingTime;
    private String Surcharge;
    private String Form2307TwoPercent;
    private String Form2307FivePercent;
    private String AdditionalCharges;
    private String Deductions;
    private String NetAmount;
    private String Source;
    private String ObjectSourceId;
    private String UserId;
    private String Status;
    private String FiledBy;
    private String ApprovedBy;
    private String AuditedBy;
    private String Notes;
    private String CheckNo;
    private String Bank;
    private String CheckExpiration;
    private String PaymentUsed;
    private String created_at;
    private String updated_at;

    public PaidBills() {
    }

    public PaidBills(String id, String BillNumber, String AccountNumber, String ServicePeriod, String ORNumber, String ORDate, String DCRNumber, String KwhUsed, String Teller, String OfficeTransacted, String PostingDate, String PostingTime, String Surcharge, String Form2307TwoPercent, String Form2307FivePercent, String AdditionalCharges, String Deductions, String NetAmount, String Source, String ObjectSourceId, String UserId, String created_at, String updated_at, String Status, String FiledBy, String ApprovedBy, String AuditedBy, String Notes, String CheckNo, String Bank, String CheckExpiration, String PaymentUsed) {
        this.id = id;
        this.BillNumber = BillNumber;
        this.AccountNumber = AccountNumber;
        this.ServicePeriod = ServicePeriod;
        this.ORNumber = ORNumber;
        this.ORDate = ORDate;
        this.DCRNumber = DCRNumber;
        this.KwhUsed = KwhUsed;
        this.Teller = Teller;
        this.OfficeTransacted = OfficeTransacted;
        this.PostingDate = PostingDate;
        this.PostingTime = PostingTime;
        this.Surcharge = Surcharge;
        this.Form2307TwoPercent = Form2307TwoPercent;
        this.Form2307FivePercent = Form2307FivePercent;
        this.AdditionalCharges = AdditionalCharges;
        this.Deductions = Deductions;
        this.NetAmount = NetAmount;
        this.Source = Source;
        this.ObjectSourceId = ObjectSourceId;
        this.UserId = UserId;
        this.Status = Status;
        this.FiledBy = FiledBy;
        this.ApprovedBy = ApprovedBy;
        this.AuditedBy = AuditedBy;
        this.Notes = Notes;
        this.CheckNo = CheckNo;
        this.Bank = Bank;
        this.CheckExpiration = CheckExpiration;
        this.PaymentUsed = PaymentUsed;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillNumber() {
        return BillNumber;
    }

    public void setBillNumber(String BillNumber) {
        this.BillNumber = BillNumber;
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

    public String getORNumber() {
        return ORNumber;
    }

    public void setORNumber(String ORNumber) {
        this.ORNumber = ORNumber;
    }

    public String getORDate() {
        return ORDate;
    }

    public void setORDate(String ORDate) {
        this.ORDate = ORDate;
    }

    public String getDCRNumber() {
        return DCRNumber;
    }

    public void setDCRNumber(String DCRNumber) {
        this.DCRNumber = DCRNumber;
    }

    public String getKwhUsed() {
        return KwhUsed;
    }

    public void setKwhUsed(String KwhUsed) {
        this.KwhUsed = KwhUsed;
    }

    public String getTeller() {
        return Teller;
    }

    public void setTeller(String Teller) {
        this.Teller = Teller;
    }

    public String getOfficeTransacted() {
        return OfficeTransacted;
    }

    public void setOfficeTransacted(String OfficeTransacted) {
        this.OfficeTransacted = OfficeTransacted;
    }

    public String getPostingDate() {
        return PostingDate;
    }

    public void setPostingDate(String PostingDate) {
        this.PostingDate = PostingDate;
    }

    public String getPostingTime() {
        return PostingTime;
    }

    public void setPostingTime(String PostingTime) {
        this.PostingTime = PostingTime;
    }

    public String getSurcharge() {
        return Surcharge;
    }

    public void setSurcharge(String Surcharge) {
        this.Surcharge = Surcharge;
    }

    public String getForm2307TwoPercent() {
        return Form2307TwoPercent;
    }

    public void setForm2307TwoPercent(String Form2307TwoPercent) {
        this.Form2307TwoPercent = Form2307TwoPercent;
    }

    public String getForm2307FivePercent() {
        return Form2307FivePercent;
    }

    public void setForm2307FivePercent(String Form2307FivePercent) {
        this.Form2307FivePercent = Form2307FivePercent;
    }

    public String getAdditionalCharges() {
        return AdditionalCharges;
    }

    public void setAdditionalCharges(String AdditionalCharges) {
        this.AdditionalCharges = AdditionalCharges;
    }

    public String getDeductions() {
        return Deductions;
    }

    public void setDeductions(String Deductions) {
        this.Deductions = Deductions;
    }

    public String getNetAmount() {
        return NetAmount;
    }

    public void setNetAmount(String NetAmount) {
        this.NetAmount = NetAmount;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getObjectSourceId() {
        return ObjectSourceId;
    }

    public void setObjectSourceId(String ObjectSourceId) {
        this.ObjectSourceId = ObjectSourceId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getFiledBy() {
        return FiledBy;
    }

    public void setFiledBy(String FiledBy) {
        this.FiledBy = FiledBy;
    }

    public String getApprovedBy() {
        return ApprovedBy;
    }

    public void setApprovedBy(String ApprovedBy) {
        this.ApprovedBy = ApprovedBy;
    }

    public String getAuditedBy() {
        return AuditedBy;
    }

    public void setAuditedBy(String AuditedBy) {
        this.AuditedBy = AuditedBy;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
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

    public String getPaymentUsed() {
        return PaymentUsed;
    }

    public void setPaymentUsed(String PaymentUsed) {
        this.PaymentUsed = PaymentUsed;
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
