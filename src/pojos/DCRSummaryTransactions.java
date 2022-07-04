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
public class DCRSummaryTransactions {
    private String id;
    private String GLCode;
    private String NEACode;
    private String Description;
    private String Amount;
    private String Day;
    private String Time;
    private String Teller;
    private String DCRNumber;
    private String Status;
    private String ORNumber;
    private String ReportDestination;
    private String Office;
    private String AccountNumber;
    private String created_at;
    private String updated_at;

    public DCRSummaryTransactions() {
    }

    public DCRSummaryTransactions(String id, String GLCode, String NEACode, String Description, String Amount, String Day, String Time, String Teller, String DCRNumber, String Status, String created_at, String updated_at, String ORNumber, String ReportDestination, String Office, String AccountNumber) {
        this.id = id;
        this.GLCode = GLCode;
        this.NEACode = NEACode;
        this.Description = Description;
        this.Amount = Amount;
        this.Day = Day;
        this.Time = Time;
        this.Teller = Teller;
        this.DCRNumber = DCRNumber;
        this.Status = Status;
        this.ORNumber = ORNumber;
        this.ReportDestination = ReportDestination;
        this.Office = Office;
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

    public String getGLCode() {
        return GLCode;
    }

    public void setGLCode(String GLCode) {
        this.GLCode = GLCode;
    }

    public String getNEACode() {
        return NEACode;
    }

    public void setNEACode(String NEACode) {
        this.NEACode = NEACode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getTeller() {
        return Teller;
    }

    public void setTeller(String Teller) {
        this.Teller = Teller;
    }

    public String getDCRNumber() {
        return DCRNumber;
    }

    public void setDCRNumber(String DCRNumber) {
        this.DCRNumber = DCRNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getORNumber() {
        return ORNumber;
    }

    public void setORNumber(String ORNumber) {
        this.ORNumber = ORNumber;
    }

    public String getReportDestination() {
        return ReportDestination;
    }

    public void setReportDestination(String ReportDestination) {
        this.ReportDestination = ReportDestination;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String Office) {
        this.Office = Office;
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
