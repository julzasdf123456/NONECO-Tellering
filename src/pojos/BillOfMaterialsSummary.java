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
public class BillOfMaterialsSummary {
    private String id;
    private String ServiceConnectionId;
    private String ExcludeTransformerLaborCost;
    private String TransformerChangedPrice;
    private String MonthDuration;
    private String TransformerLaborCostPercentage;
    private String MaterialLaborCostPercentage;
    private String HandlingCostPercentage;
    private String SubTotal;
    private String LaborCost;
    private String HandlingCost;
    private String Total;
    private String TotalVAT;
    private String TransformerLaborCost;
    private String MaterialLaborCost;
    private String TransformerTotal;
    private String IsPaid;
    private String ORNumber;
    private String ORDate;
    private String created_at;
    private String updated_at;

    public BillOfMaterialsSummary() {
    }

    public BillOfMaterialsSummary(String id, String ServiceConnectionId, String ExcludeTransformerLaborCost, String TransformerChangedPrice, String MonthDuration, String TransformerLaborCostPercentage, String MaterialLaborCostPercentage, String HandlingCostPercentage, String SubTotal, String LaborCost, String HandlingCost, String Total, String TotalVAT, String TransformerLaborCost, String MaterialLaborCost, String TransformerTotal, String IsPaid, String ORNumber, String ORDate, String created_at, String updated_at) {
        this.id = id;
        this.ServiceConnectionId = ServiceConnectionId;
        this.ExcludeTransformerLaborCost = ExcludeTransformerLaborCost;
        this.TransformerChangedPrice = TransformerChangedPrice;
        this.MonthDuration = MonthDuration;
        this.TransformerLaborCostPercentage = TransformerLaborCostPercentage;
        this.MaterialLaborCostPercentage = MaterialLaborCostPercentage;
        this.HandlingCostPercentage = HandlingCostPercentage;
        this.SubTotal = SubTotal;
        this.LaborCost = LaborCost;
        this.HandlingCost = HandlingCost;
        this.Total = Total;
        this.TotalVAT = TotalVAT;
        this.TransformerLaborCost = TransformerLaborCost;
        this.MaterialLaborCost = MaterialLaborCost;
        this.TransformerTotal = TransformerTotal;
        this.IsPaid = IsPaid;
        this.ORNumber = ORNumber;
        this.ORDate = ORDate;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public String getExcludeTransformerLaborCost() {
        return ExcludeTransformerLaborCost;
    }

    public void setExcludeTransformerLaborCost(String ExcludeTransformerLaborCost) {
        this.ExcludeTransformerLaborCost = ExcludeTransformerLaborCost;
    }

    public String getTransformerChangedPrice() {
        return TransformerChangedPrice;
    }

    public void setTransformerChangedPrice(String TransformerChangedPrice) {
        this.TransformerChangedPrice = TransformerChangedPrice;
    }

    public String getMonthDuration() {
        return MonthDuration;
    }

    public void setMonthDuration(String MonthDuration) {
        this.MonthDuration = MonthDuration;
    }

    public String getTransformerLaborCostPercentage() {
        return TransformerLaborCostPercentage;
    }

    public void setTransformerLaborCostPercentage(String TransformerLaborCostPercentage) {
        this.TransformerLaborCostPercentage = TransformerLaborCostPercentage;
    }

    public String getMaterialLaborCostPercentage() {
        return MaterialLaborCostPercentage;
    }

    public void setMaterialLaborCostPercentage(String MaterialLaborCostPercentage) {
        this.MaterialLaborCostPercentage = MaterialLaborCostPercentage;
    }

    public String getHandlingCostPercentage() {
        return HandlingCostPercentage;
    }

    public void setHandlingCostPercentage(String HandlingCostPercentage) {
        this.HandlingCostPercentage = HandlingCostPercentage;
    }

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getLaborCost() {
        return LaborCost;
    }

    public void setLaborCost(String LaborCost) {
        this.LaborCost = LaborCost;
    }

    public String getHandlingCost() {
        return HandlingCost;
    }

    public void setHandlingCost(String HandlingCost) {
        this.HandlingCost = HandlingCost;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getTotalVAT() {
        return TotalVAT;
    }

    public void setTotalVAT(String TotalVAT) {
        this.TotalVAT = TotalVAT;
    }

    public String getTransformerLaborCost() {
        return TransformerLaborCost;
    }

    public void setTransformerLaborCost(String TransformerLaborCost) {
        this.TransformerLaborCost = TransformerLaborCost;
    }

    public String getMaterialLaborCost() {
        return MaterialLaborCost;
    }

    public void setMaterialLaborCost(String MaterialLaborCost) {
        this.MaterialLaborCost = MaterialLaborCost;
    }

    public String getTransformerTotal() {
        return TransformerTotal;
    }

    public void setTransformerTotal(String TransformerTotal) {
        this.TransformerTotal = TransformerTotal;
    }

    public String getIsPaid() {
        return IsPaid;
    }

    public void setIsPaid(String IsPaid) {
        this.IsPaid = IsPaid;
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
