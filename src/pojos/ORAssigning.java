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
public class ORAssigning {

    private String id;
    private String ORNumber;
    private String UserId;
    private String DateAsigned;
    private String IsSetManuall;
    private String TimeAssigned;
    private String Office;
    private String created_at;
    private String updated_at;

    public ORAssigning() {
    }

    public ORAssigning(String id, String ORNumber, String UserId, String DateAsigned, String IsSetManuall, String TimeAssigned, String Office, String created_at, String updated_at) {
        this.id = id;
        this.ORNumber = ORNumber;
        this.UserId = UserId;
        this.DateAsigned = DateAsigned;
        this.IsSetManuall = IsSetManuall;
        this.TimeAssigned = TimeAssigned;
        this.Office = Office;
        this.created_at = created_at;
        this.updated_at = updated_at;
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
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getORumber() {
        return ORNumber;
    }

    public void setORumber(String ORumber) {
        this.ORNumber = ORumber;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getDateAsigned() {
        return DateAsigned;
    }

    public void setDateAsigned(String DateAsigned) {
        this.DateAsigned = DateAsigned;
    }

    public String getIsSetManuall() {
        return IsSetManuall;
    }

    public void setIsSetManuall(String IsSetManuall) {
        this.IsSetManuall = IsSetManuall;
    }

    public String getTimeAssigned() {
        return TimeAssigned;
    }

    public void setTimeAssigned(String TimeAssigned) {
        this.TimeAssigned = TimeAssigned;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String Office) {
        this.Office = Office;
    }

    
}
