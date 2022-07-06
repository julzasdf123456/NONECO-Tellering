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
public class TransactionIndex {
    private String id;
    private String TransactionNumber;
    private String PaymentTitle;
    private String PaymentDetails;
    private String ORNumber;
    private String ORDate;
    private String SubTotal;
    private String VAT;
    private String Total;
    private String Notes;
    private String UserId;
    private String ServiceConnectionId;
    private String TicketId;
    private String ObjectId;
    private String Source;
    private String PaymentUsed;
    private String Status;
    private String FiledBy;
    private String ApprovedBy;
    private String AuditedBy;
    private String CancellationNotes;
    private String PayeeName;
    private String CheckNo;
    private String Bank;
    private String CheckExpiration;
    private String AccountNumber;
    private String created_at;
    private String updated_at;

    public TransactionIndex() {
    }

    public TransactionIndex(String id, String TransactionNumber, String PaymentTitle, String PaymentDetails, String ORNumber, String ORDate, String SubTotal, String VAT, String Total, String Notes, String UserId, String ServiceConnectionId, String TicketId, String ObjectId, String Source, String PaymentUsed, String Status, String FiledBy, String ApprovedBy, String AuditedBy, String CancellationNotes, String PayeeName, String CheckNo, String Bank, String CheckExpiration, String AccountNumber, String created_at, String updated_at) {
        this.id = id;
        this.TransactionNumber = TransactionNumber;
        this.PaymentTitle = PaymentTitle;
        this.PaymentDetails = PaymentDetails;
        this.ORNumber = ORNumber;
        this.ORDate = ORDate;
        this.SubTotal = SubTotal;
        this.VAT = VAT;
        this.Total = Total;
        this.Notes = Notes;
        this.UserId = UserId;
        this.ServiceConnectionId = ServiceConnectionId;
        this.TicketId = TicketId;
        this.ObjectId = ObjectId;
        this.Source = Source;
        this.PaymentUsed = PaymentUsed;
        this.Status = Status;
        this.FiledBy = FiledBy;
        this.ApprovedBy = ApprovedBy;
        this.AuditedBy = AuditedBy;
        this.CancellationNotes = CancellationNotes;
        this.PayeeName = PayeeName;
        this.CheckNo = CheckNo;
        this.Bank = Bank;
        this.CheckExpiration = CheckExpiration;
        this.AccountNumber = AccountNumber;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionNumber() {
        return TransactionNumber;
    }

    public void setTransactionNumber(String TransactionNumber) {
        this.TransactionNumber = TransactionNumber;
    }

    public String getPaymentTitle() {
        return PaymentTitle;
    }

    public void setPaymentTitle(String PaymentTitle) {
        this.PaymentTitle = PaymentTitle;
    }

    public String getPaymentDetails() {
        return PaymentDetails;
    }

    public void setPaymentDetails(String PaymentDetails) {
        this.PaymentDetails = PaymentDetails;
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

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getServiceConnectionId() {
        return ServiceConnectionId;
    }

    public void setServiceConnectionId(String ServiceConnectionId) {
        this.ServiceConnectionId = ServiceConnectionId;
    }

    public String getTicketId() {
        return TicketId;
    }

    public void setTicketId(String TicketId) {
        this.TicketId = TicketId;
    }

    public String getObjectId() {
        return ObjectId;
    }

    public void setObjectId(String ObjectId) {
        this.ObjectId = ObjectId;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getPaymentUsed() {
        return PaymentUsed;
    }

    public void setPaymentUsed(String PaymentUsed) {
        this.PaymentUsed = PaymentUsed;
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

    public String getCancellationNotes() {
        return CancellationNotes;
    }

    public void setCancellationNotes(String CancellationNotes) {
        this.CancellationNotes = CancellationNotes;
    }

    public String getPayeeName() {
        return PayeeName;
    }

    public void setPayeeName(String PayeeName) {
        this.PayeeName = PayeeName;
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

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
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
