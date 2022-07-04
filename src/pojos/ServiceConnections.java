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
public class ServiceConnections {
    private String id;
    private String MemberConsumerId;
    private String DateOfApplication;
    private String ServiceAccountName;
    private String AccountCount;
    private String Sitio;
    private String Barangay;
    private String Town;
    private String ContactNumber;
    private String EmailAddress;
    private String AccountType;
    private String AccountOrganization;
    private String OrganizationAccountNumber;
    private String IsNIHE;
    private String AccountApplicationType;
    private String ConnectionApplicationType;
    private String BuildingType;
    private String Status;
    private String Notes;
    private String Trash;
    private String ORNumber;
    private String ORDate;
    private String DateTimeLinemenArrived;
    private String DateTimeOfEnergization;
    private String EnergizationOrderIssued;
    private String DateTimeOfEnergizationIssue;
    private String StationCrewAssigned;
    private String LoadCategory;
    private String TemporaryDurationInMonths;
    private String LongSpan;
    private String Office;
    private String TypeOfOccupancy;
    private String ResidenceNumber;
    private String AccountNumber;
    private String BarangayId;
    private String TownId;
    private String created_at;
    private String updated_at;

    public ServiceConnections() {
    }

    public ServiceConnections(String id, String MemberConsumerId, String DateOfApplication, String ServiceAccountName, String AccountCount, String Sitio, String Barangay, String Town, String ContactNumber, String EmailAddress, String AccountType, String AccountOrganization, String OrganizationAccountNumber, String IsNIHE, String AccountApplicationType, String ConnectionApplicationType, String BuildingType, String Status, String Notes, String Trash, String ORNumber, String ORDate, String DateTimeLinemenArrived, String DateTimeOfEnergization, String EnergizationOrderIssued, String DateTimeOfEnergizationIssue, String StationCrewAssigned, String LoadCategory, String TemporaryDurationInMonths, String LongSpan, String Office, String TypeOfOccupancy, String ResidenceNumber, String AccountNumber, String BarangayId, String TownId, String created_at, String updated_at) {
        this.id = id;
        this.MemberConsumerId = MemberConsumerId;
        this.DateOfApplication = DateOfApplication;
        this.ServiceAccountName = ServiceAccountName;
        this.AccountCount = AccountCount;
        this.Sitio = Sitio;
        this.Barangay = Barangay;
        this.Town = Town;
        this.ContactNumber = ContactNumber;
        this.EmailAddress = EmailAddress;
        this.AccountType = AccountType;
        this.AccountOrganization = AccountOrganization;
        this.OrganizationAccountNumber = OrganizationAccountNumber;
        this.IsNIHE = IsNIHE;
        this.AccountApplicationType = AccountApplicationType;
        this.ConnectionApplicationType = ConnectionApplicationType;
        this.BuildingType = BuildingType;
        this.Status = Status;
        this.Notes = Notes;
        this.Trash = Trash;
        this.ORNumber = ORNumber;
        this.ORDate = ORDate;
        this.DateTimeLinemenArrived = DateTimeLinemenArrived;
        this.DateTimeOfEnergization = DateTimeOfEnergization;
        this.EnergizationOrderIssued = EnergizationOrderIssued;
        this.DateTimeOfEnergizationIssue = DateTimeOfEnergizationIssue;
        this.StationCrewAssigned = StationCrewAssigned;
        this.LoadCategory = LoadCategory;
        this.TemporaryDurationInMonths = TemporaryDurationInMonths;
        this.LongSpan = LongSpan;
        this.Office = Office;
        this.TypeOfOccupancy = TypeOfOccupancy;
        this.ResidenceNumber = ResidenceNumber;
        this.AccountNumber = AccountNumber;
        this.BarangayId = BarangayId;
        this.TownId = TownId;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberConsumerId() {
        return MemberConsumerId;
    }

    public void setMemberConsumerId(String MemberConsumerId) {
        this.MemberConsumerId = MemberConsumerId;
    }

    public String getDateOfApplication() {
        return DateOfApplication;
    }

    public void setDateOfApplication(String DateOfApplication) {
        this.DateOfApplication = DateOfApplication;
    }

    public String getServiceAccountName() {
        return ServiceAccountName;
    }

    public void setServiceAccountName(String ServiceAccountName) {
        this.ServiceAccountName = ServiceAccountName;
    }

    public String getAccountCount() {
        return AccountCount;
    }

    public void setAccountCount(String AccountCount) {
        this.AccountCount = AccountCount;
    }

    public String getSitio() {
        return Sitio;
    }

    public void setSitio(String Sitio) {
        this.Sitio = Sitio;
    }

    public String getBarangay() {
        return Barangay;
    }

    public void setBarangay(String Barangay) {
        this.Barangay = Barangay;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String Town) {
        this.Town = Town;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    public String getAccountOrganization() {
        return AccountOrganization;
    }

    public void setAccountOrganization(String AccountOrganization) {
        this.AccountOrganization = AccountOrganization;
    }

    public String getOrganizationAccountNumber() {
        return OrganizationAccountNumber;
    }

    public void setOrganizationAccountNumber(String OrganizationAccountNumber) {
        this.OrganizationAccountNumber = OrganizationAccountNumber;
    }

    public String getIsNIHE() {
        return IsNIHE;
    }

    public void setIsNIHE(String IsNIHE) {
        this.IsNIHE = IsNIHE;
    }

    public String getAccountApplicationType() {
        return AccountApplicationType;
    }

    public void setAccountApplicationType(String AccountApplicationType) {
        this.AccountApplicationType = AccountApplicationType;
    }

    public String getConnectionApplicationType() {
        return ConnectionApplicationType;
    }

    public void setConnectionApplicationType(String ConnectionApplicationType) {
        this.ConnectionApplicationType = ConnectionApplicationType;
    }

    public String getBuildingType() {
        return BuildingType;
    }

    public void setBuildingType(String BuildingType) {
        this.BuildingType = BuildingType;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getTrash() {
        return Trash;
    }

    public void setTrash(String Trash) {
        this.Trash = Trash;
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

    public String getDateTimeLinemenArrived() {
        return DateTimeLinemenArrived;
    }

    public void setDateTimeLinemenArrived(String DateTimeLinemenArrived) {
        this.DateTimeLinemenArrived = DateTimeLinemenArrived;
    }

    public String getDateTimeOfEnergization() {
        return DateTimeOfEnergization;
    }

    public void setDateTimeOfEnergization(String DateTimeOfEnergization) {
        this.DateTimeOfEnergization = DateTimeOfEnergization;
    }

    public String getEnergizationOrderIssued() {
        return EnergizationOrderIssued;
    }

    public void setEnergizationOrderIssued(String EnergizationOrderIssued) {
        this.EnergizationOrderIssued = EnergizationOrderIssued;
    }

    public String getDateTimeOfEnergizationIssue() {
        return DateTimeOfEnergizationIssue;
    }

    public void setDateTimeOfEnergizationIssue(String DateTimeOfEnergizationIssue) {
        this.DateTimeOfEnergizationIssue = DateTimeOfEnergizationIssue;
    }

    public String getStationCrewAssigned() {
        return StationCrewAssigned;
    }

    public void setStationCrewAssigned(String StationCrewAssigned) {
        this.StationCrewAssigned = StationCrewAssigned;
    }

    public String getLoadCategory() {
        return LoadCategory;
    }

    public void setLoadCategory(String LoadCategory) {
        this.LoadCategory = LoadCategory;
    }

    public String getTemporaryDurationInMonths() {
        return TemporaryDurationInMonths;
    }

    public void setTemporaryDurationInMonths(String TemporaryDurationInMonths) {
        this.TemporaryDurationInMonths = TemporaryDurationInMonths;
    }

    public String getLongSpan() {
        return LongSpan;
    }

    public void setLongSpan(String LongSpan) {
        this.LongSpan = LongSpan;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String Office) {
        this.Office = Office;
    }

    public String getTypeOfOccupancy() {
        return TypeOfOccupancy;
    }

    public void setTypeOfOccupancy(String TypeOfOccupancy) {
        this.TypeOfOccupancy = TypeOfOccupancy;
    }

    public String getResidenceNumber() {
        return ResidenceNumber;
    }

    public void setResidenceNumber(String ResidenceNumber) {
        this.ResidenceNumber = ResidenceNumber;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getBarangayId() {
        return BarangayId;
    }

    public void setBarangayId(String BarangayId) {
        this.BarangayId = BarangayId;
    }

    public String getTownId() {
        return TownId;
    }

    public void setTownId(String TownId) {
        this.TownId = TownId;
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
