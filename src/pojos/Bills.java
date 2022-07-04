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
public class Bills {
    private String id;
    private String BillNumber;
    private String AccountNumber;
    private String ServicePeriod;
    private String Multiplier;
    private String Coreloss;
    private String KwhUsed;
    private String PreviousKwh;
    private String PresentKwh;
    private String DemandPreviousKwh;
    private String DemandPresentKwh;
    private String AdditionalKwh;
    private String AdditionalDemandKwh;
    private String KwhAmount;
    private String EffectiveRate;
    private String AdditionalCharges;
    private String Deductions;
    private String NetAmount;
    private String BillingDate;
    private String ServiceDateFrom;
    private String ServiceDateTo;
    private String DueDate;
    private String MeterNumber;
    private String ConsumerType;
    private String BillType;
    private String GenerationSystemCharge;
    private String TransmissionDeliveryChargeKW;
    private String TransmissionDeliveryChargeKWH;
    private String SystemLossCharge;
    private String DistributionDemandCharge;
    private String DistributionSystemCharge;
    private String SupplyRetailCustomerCharge;
    private String SupplySystemCharge;
    private String MeteringRetailCustomerCharge;
    private String MeteringSystemCharge;
    private String RFSC;
    private String LifelineRate;
    private String InterClassCrossSubsidyCharge;
    private String PPARefund;
    private String SeniorCitizenSubsidy;
    private String MissionaryElectrificationCharge;
    private String EnvironmentalCharge;
    private String StrandedContractCosts;
    private String NPCStrandedDebt;
    private String FeedInTariffAllowance;
    private String MissionaryElectrificationREDCI;
    private String GenerationVAT;
    private String TransmissionVAT;
    private String SystemLossVAT;
    private String DistributionVAT;
    private String RealPropertyTax;
    private String Notes;
    private String UserId;
    private String BilledFrom;
    private String AveragedCount;
    private String MergedToCollectible;
    private String OtherGenerationRateAdjustment;
    private String OtherTransmissionCostAdjustmentKW;
    private String OtherTransmissionCostAdjustmentKWH;
    private String OtherSystemLossCostAdjustment;
    private String OtherLifelineRateCostAdjustment;
    private String SeniorCitizenDiscountAndSubsidyAdjustment;
    private String FranchiseTax;
    private String BusinessTax;
    private String AdjustmentType;
    private String Form2307Amount;
    private String DeductedDeposit;
    private String ExcessDeposit;
    private String IsUnlockedForPayment;
    private String UnlockedBy;
    private String Evat2Percent;
    private String Evat5Percent;
    private String AdjustmentNumber;
    private String AdjustedBy;
    private String DateAdjusted;
    private String ForCancellation;
    private String CancelRequestedBy;
    private String CancelApprovedBy;

    public Bills() {
    }

    public Bills(String id, String BillNumber, String AccountNumber, String ServicePeriod, String Multiplier, String Coreloss, String KwhUsed, String PreviousKwh, String PresentKwh, String DemandPreviousKwh, String DemandPresentKwh, String AdditionalKwh, String AdditionalDemandKwh, String KwhAmount, String EffectiveRate, String AdditionalCharges, String Deductions, String NetAmount, String BillingDate, String ServiceDateFrom, String ServiceDateTo, String DueDate, String MeterNumber, String ConsumerType, String BillType, String GenerationSystemCharge, String TransmissionDeliveryChargeKW, String TransmissionDeliveryChargeKWH, String SystemLossCharge, String DistributionDemandCharge, String DistributionSystemCharge, String SupplyRetailCustomerCharge, String SupplySystemCharge, String MeteringRetailCustomerCharge, String MeteringSystemCharge, String RFSC, String LifelineRate, String InterClassCrossSubsidyCharge, String PPARefund, String SeniorCitizenSubsidy, String MissionaryElectrificationCharge, String EnvironmentalCharge, String StrandedContractCosts, String NPCStrandedDebt, String FeedInTariffAllowance, String MissionaryElectrificationREDCI, String GenerationVAT, String TransmissionVAT, String SystemLossVAT, String DistributionVAT, String RealPropertyTax, String Notes, String UserId, String BilledFrom, String AveragedCount, String MergedToCollectible, String OtherGenerationRateAdjustment, String OtherTransmissionCostAdjustmentKW, String OtherTransmissionCostAdjustmentKWH, String OtherSystemLossCostAdjustment, String OtherLifelineRateCostAdjustment, String SeniorCitizenDiscountAndSubsidyAdjustment, String FranchiseTax, String BusinessTax, String AdjustmentType, String Form2307Amount, String DeductedDeposit, String ExcessDeposit, String IsUnlockedForPayment, String UnlockedBy, String Evat2Percent, String Evat5Percent, String AdjustmentNumber, String AdjustedBy, String DateAdjusted, String ForCancellation, String CancelRequestedBy, String CancelApprovedBy) {
        this.id = id;
        this.BillNumber = BillNumber;
        this.AccountNumber = AccountNumber;
        this.ServicePeriod = ServicePeriod;
        this.Multiplier = Multiplier;
        this.Coreloss = Coreloss;
        this.KwhUsed = KwhUsed;
        this.PreviousKwh = PreviousKwh;
        this.PresentKwh = PresentKwh;
        this.DemandPreviousKwh = DemandPreviousKwh;
        this.DemandPresentKwh = DemandPresentKwh;
        this.AdditionalKwh = AdditionalKwh;
        this.AdditionalDemandKwh = AdditionalDemandKwh;
        this.KwhAmount = KwhAmount;
        this.EffectiveRate = EffectiveRate;
        this.AdditionalCharges = AdditionalCharges;
        this.Deductions = Deductions;
        this.NetAmount = NetAmount;
        this.BillingDate = BillingDate;
        this.ServiceDateFrom = ServiceDateFrom;
        this.ServiceDateTo = ServiceDateTo;
        this.DueDate = DueDate;
        this.MeterNumber = MeterNumber;
        this.ConsumerType = ConsumerType;
        this.BillType = BillType;
        this.GenerationSystemCharge = GenerationSystemCharge;
        this.TransmissionDeliveryChargeKW = TransmissionDeliveryChargeKW;
        this.TransmissionDeliveryChargeKWH = TransmissionDeliveryChargeKWH;
        this.SystemLossCharge = SystemLossCharge;
        this.DistributionDemandCharge = DistributionDemandCharge;
        this.DistributionSystemCharge = DistributionSystemCharge;
        this.SupplyRetailCustomerCharge = SupplyRetailCustomerCharge;
        this.SupplySystemCharge = SupplySystemCharge;
        this.MeteringRetailCustomerCharge = MeteringRetailCustomerCharge;
        this.MeteringSystemCharge = MeteringSystemCharge;
        this.RFSC = RFSC;
        this.LifelineRate = LifelineRate;
        this.InterClassCrossSubsidyCharge = InterClassCrossSubsidyCharge;
        this.PPARefund = PPARefund;
        this.SeniorCitizenSubsidy = SeniorCitizenSubsidy;
        this.MissionaryElectrificationCharge = MissionaryElectrificationCharge;
        this.EnvironmentalCharge = EnvironmentalCharge;
        this.StrandedContractCosts = StrandedContractCosts;
        this.NPCStrandedDebt = NPCStrandedDebt;
        this.FeedInTariffAllowance = FeedInTariffAllowance;
        this.MissionaryElectrificationREDCI = MissionaryElectrificationREDCI;
        this.GenerationVAT = GenerationVAT;
        this.TransmissionVAT = TransmissionVAT;
        this.SystemLossVAT = SystemLossVAT;
        this.DistributionVAT = DistributionVAT;
        this.RealPropertyTax = RealPropertyTax;
        this.Notes = Notes;
        this.UserId = UserId;
        this.BilledFrom = BilledFrom;
        this.AveragedCount = AveragedCount;
        this.MergedToCollectible = MergedToCollectible;
        this.OtherGenerationRateAdjustment = OtherGenerationRateAdjustment;
        this.OtherTransmissionCostAdjustmentKW = OtherTransmissionCostAdjustmentKW;
        this.OtherTransmissionCostAdjustmentKWH = OtherTransmissionCostAdjustmentKWH;
        this.OtherSystemLossCostAdjustment = OtherSystemLossCostAdjustment;
        this.OtherLifelineRateCostAdjustment = OtherLifelineRateCostAdjustment;
        this.SeniorCitizenDiscountAndSubsidyAdjustment = SeniorCitizenDiscountAndSubsidyAdjustment;
        this.FranchiseTax = FranchiseTax;
        this.BusinessTax = BusinessTax;
        this.AdjustmentType = AdjustmentType;
        this.Form2307Amount = Form2307Amount;
        this.DeductedDeposit = DeductedDeposit;
        this.ExcessDeposit = ExcessDeposit;
        this.IsUnlockedForPayment = IsUnlockedForPayment;
        this.UnlockedBy = UnlockedBy;
        this.Evat2Percent = Evat2Percent;
        this.Evat5Percent = Evat5Percent;
        this.AdjustmentNumber = AdjustmentNumber;
        this.AdjustedBy = AdjustedBy;
        this.DateAdjusted = DateAdjusted;
        this.ForCancellation = ForCancellation;
        this.CancelRequestedBy = CancelRequestedBy;
        this.CancelApprovedBy = CancelApprovedBy;
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

    public String getMultiplier() {
        return Multiplier;
    }

    public void setMultiplier(String Multiplier) {
        this.Multiplier = Multiplier;
    }

    public String getCoreloss() {
        return Coreloss;
    }

    public void setCoreloss(String Coreloss) {
        this.Coreloss = Coreloss;
    }

    public String getKwhUsed() {
        return KwhUsed;
    }

    public void setKwhUsed(String KwhUsed) {
        this.KwhUsed = KwhUsed;
    }

    public String getPreviousKwh() {
        return PreviousKwh;
    }

    public void setPreviousKwh(String PreviousKwh) {
        this.PreviousKwh = PreviousKwh;
    }

    public String getPresentKwh() {
        return PresentKwh;
    }

    public void setPresentKwh(String PresentKwh) {
        this.PresentKwh = PresentKwh;
    }

    public String getDemandPreviousKwh() {
        return DemandPreviousKwh;
    }

    public void setDemandPreviousKwh(String DemandPreviousKwh) {
        this.DemandPreviousKwh = DemandPreviousKwh;
    }

    public String getDemandPresentKwh() {
        return DemandPresentKwh;
    }

    public void setDemandPresentKwh(String DemandPresentKwh) {
        this.DemandPresentKwh = DemandPresentKwh;
    }

    public String getAdditionalKwh() {
        return AdditionalKwh;
    }

    public void setAdditionalKwh(String AdditionalKwh) {
        this.AdditionalKwh = AdditionalKwh;
    }

    public String getAdditionalDemandKwh() {
        return AdditionalDemandKwh;
    }

    public void setAdditionalDemandKwh(String AdditionalDemandKwh) {
        this.AdditionalDemandKwh = AdditionalDemandKwh;
    }

    public String getKwhAmount() {
        return KwhAmount;
    }

    public void setKwhAmount(String KwhAmount) {
        this.KwhAmount = KwhAmount;
    }

    public String getEffectiveRate() {
        return EffectiveRate;
    }

    public void setEffectiveRate(String EffectiveRate) {
        this.EffectiveRate = EffectiveRate;
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

    public String getBillingDate() {
        return BillingDate;
    }

    public void setBillingDate(String BillingDate) {
        this.BillingDate = BillingDate;
    }

    public String getServiceDateFrom() {
        return ServiceDateFrom;
    }

    public void setServiceDateFrom(String ServiceDateFrom) {
        this.ServiceDateFrom = ServiceDateFrom;
    }

    public String getServiceDateTo() {
        return ServiceDateTo;
    }

    public void setServiceDateTo(String ServiceDateTo) {
        this.ServiceDateTo = ServiceDateTo;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }

    public String getMeterNumber() {
        return MeterNumber;
    }

    public void setMeterNumber(String MeterNumber) {
        this.MeterNumber = MeterNumber;
    }

    public String getConsumerType() {
        return ConsumerType;
    }

    public void setConsumerType(String ConsumerType) {
        this.ConsumerType = ConsumerType;
    }

    public String getBillType() {
        return BillType;
    }

    public void setBillType(String BillType) {
        this.BillType = BillType;
    }

    public String getGenerationSystemCharge() {
        return GenerationSystemCharge;
    }

    public void setGenerationSystemCharge(String GenerationSystemCharge) {
        this.GenerationSystemCharge = GenerationSystemCharge;
    }

    public String getTransmissionDeliveryChargeKW() {
        return TransmissionDeliveryChargeKW;
    }

    public void setTransmissionDeliveryChargeKW(String TransmissionDeliveryChargeKW) {
        this.TransmissionDeliveryChargeKW = TransmissionDeliveryChargeKW;
    }

    public String getTransmissionDeliveryChargeKWH() {
        return TransmissionDeliveryChargeKWH;
    }

    public void setTransmissionDeliveryChargeKWH(String TransmissionDeliveryChargeKWH) {
        this.TransmissionDeliveryChargeKWH = TransmissionDeliveryChargeKWH;
    }

    public String getSystemLossCharge() {
        return SystemLossCharge;
    }

    public void setSystemLossCharge(String SystemLossCharge) {
        this.SystemLossCharge = SystemLossCharge;
    }

    public String getDistributionDemandCharge() {
        return DistributionDemandCharge;
    }

    public void setDistributionDemandCharge(String DistributionDemandCharge) {
        this.DistributionDemandCharge = DistributionDemandCharge;
    }

    public String getDistributionSystemCharge() {
        return DistributionSystemCharge;
    }

    public void setDistributionSystemCharge(String DistributionSystemCharge) {
        this.DistributionSystemCharge = DistributionSystemCharge;
    }

    public String getSupplyRetailCustomerCharge() {
        return SupplyRetailCustomerCharge;
    }

    public void setSupplyRetailCustomerCharge(String SupplyRetailCustomerCharge) {
        this.SupplyRetailCustomerCharge = SupplyRetailCustomerCharge;
    }

    public String getSupplySystemCharge() {
        return SupplySystemCharge;
    }

    public void setSupplySystemCharge(String SupplySystemCharge) {
        this.SupplySystemCharge = SupplySystemCharge;
    }

    public String getMeteringRetailCustomerCharge() {
        return MeteringRetailCustomerCharge;
    }

    public void setMeteringRetailCustomerCharge(String MeteringRetailCustomerCharge) {
        this.MeteringRetailCustomerCharge = MeteringRetailCustomerCharge;
    }

    public String getMeteringSystemCharge() {
        return MeteringSystemCharge;
    }

    public void setMeteringSystemCharge(String MeteringSystemCharge) {
        this.MeteringSystemCharge = MeteringSystemCharge;
    }

    public String getRFSC() {
        return RFSC;
    }

    public void setRFSC(String RFSC) {
        this.RFSC = RFSC;
    }

    public String getLifelineRate() {
        return LifelineRate;
    }

    public void setLifelineRate(String LifelineRate) {
        this.LifelineRate = LifelineRate;
    }

    public String getInterClassCrossSubsidyCharge() {
        return InterClassCrossSubsidyCharge;
    }

    public void setInterClassCrossSubsidyCharge(String InterClassCrossSubsidyCharge) {
        this.InterClassCrossSubsidyCharge = InterClassCrossSubsidyCharge;
    }

    public String getPPARefund() {
        return PPARefund;
    }

    public void setPPARefund(String PPARefund) {
        this.PPARefund = PPARefund;
    }

    public String getSeniorCitizenSubsidy() {
        return SeniorCitizenSubsidy;
    }

    public void setSeniorCitizenSubsidy(String SeniorCitizenSubsidy) {
        this.SeniorCitizenSubsidy = SeniorCitizenSubsidy;
    }

    public String getMissionaryElectrificationCharge() {
        return MissionaryElectrificationCharge;
    }

    public void setMissionaryElectrificationCharge(String MissionaryElectrificationCharge) {
        this.MissionaryElectrificationCharge = MissionaryElectrificationCharge;
    }

    public String getEnvironmentalCharge() {
        return EnvironmentalCharge;
    }

    public void setEnvironmentalCharge(String EnvironmentalCharge) {
        this.EnvironmentalCharge = EnvironmentalCharge;
    }

    public String getStrandedContractCosts() {
        return StrandedContractCosts;
    }

    public void setStrandedContractCosts(String StrandedContractCosts) {
        this.StrandedContractCosts = StrandedContractCosts;
    }

    public String getNPCStrandedDebt() {
        return NPCStrandedDebt;
    }

    public void setNPCStrandedDebt(String NPCStrandedDebt) {
        this.NPCStrandedDebt = NPCStrandedDebt;
    }

    public String getFeedInTariffAllowance() {
        return FeedInTariffAllowance;
    }

    public void setFeedInTariffAllowance(String FeedInTariffAllowance) {
        this.FeedInTariffAllowance = FeedInTariffAllowance;
    }

    public String getMissionaryElectrificationREDCI() {
        return MissionaryElectrificationREDCI;
    }

    public void setMissionaryElectrificationREDCI(String MissionaryElectrificationREDCI) {
        this.MissionaryElectrificationREDCI = MissionaryElectrificationREDCI;
    }

    public String getGenerationVAT() {
        return GenerationVAT;
    }

    public void setGenerationVAT(String GenerationVAT) {
        this.GenerationVAT = GenerationVAT;
    }

    public String getTransmissionVAT() {
        return TransmissionVAT;
    }

    public void setTransmissionVAT(String TransmissionVAT) {
        this.TransmissionVAT = TransmissionVAT;
    }

    public String getSystemLossVAT() {
        return SystemLossVAT;
    }

    public void setSystemLossVAT(String SystemLossVAT) {
        this.SystemLossVAT = SystemLossVAT;
    }

    public String getDistributionVAT() {
        return DistributionVAT;
    }

    public void setDistributionVAT(String DistributionVAT) {
        this.DistributionVAT = DistributionVAT;
    }

    public String getRealPropertyTax() {
        return RealPropertyTax;
    }

    public void setRealPropertyTax(String RealPropertyTax) {
        this.RealPropertyTax = RealPropertyTax;
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

    public String getBilledFrom() {
        return BilledFrom;
    }

    public void setBilledFrom(String BilledFrom) {
        this.BilledFrom = BilledFrom;
    }

    public String getAveragedCount() {
        return AveragedCount;
    }

    public void setAveragedCount(String AveragedCount) {
        this.AveragedCount = AveragedCount;
    }

    public String getMergedToCollectible() {
        return MergedToCollectible;
    }

    public void setMergedToCollectible(String MergedToCollectible) {
        this.MergedToCollectible = MergedToCollectible;
    }

    public String getOtherGenerationRateAdjustment() {
        return OtherGenerationRateAdjustment;
    }

    public void setOtherGenerationRateAdjustment(String OtherGenerationRateAdjustment) {
        this.OtherGenerationRateAdjustment = OtherGenerationRateAdjustment;
    }

    public String getOtherTransmissionCostAdjustmentKW() {
        return OtherTransmissionCostAdjustmentKW;
    }

    public void setOtherTransmissionCostAdjustmentKW(String OtherTransmissionCostAdjustmentKW) {
        this.OtherTransmissionCostAdjustmentKW = OtherTransmissionCostAdjustmentKW;
    }

    public String getOtherTransmissionCostAdjustmentKWH() {
        return OtherTransmissionCostAdjustmentKWH;
    }

    public void setOtherTransmissionCostAdjustmentKWH(String OtherTransmissionCostAdjustmentKWH) {
        this.OtherTransmissionCostAdjustmentKWH = OtherTransmissionCostAdjustmentKWH;
    }

    public String getOtherSystemLossCostAdjustment() {
        return OtherSystemLossCostAdjustment;
    }

    public void setOtherSystemLossCostAdjustment(String OtherSystemLossCostAdjustment) {
        this.OtherSystemLossCostAdjustment = OtherSystemLossCostAdjustment;
    }

    public String getOtherLifelineRateCostAdjustment() {
        return OtherLifelineRateCostAdjustment;
    }

    public void setOtherLifelineRateCostAdjustment(String OtherLifelineRateCostAdjustment) {
        this.OtherLifelineRateCostAdjustment = OtherLifelineRateCostAdjustment;
    }

    public String getSeniorCitizenDiscountAndSubsidyAdjustment() {
        return SeniorCitizenDiscountAndSubsidyAdjustment;
    }

    public void setSeniorCitizenDiscountAndSubsidyAdjustment(String SeniorCitizenDiscountAndSubsidyAdjustment) {
        this.SeniorCitizenDiscountAndSubsidyAdjustment = SeniorCitizenDiscountAndSubsidyAdjustment;
    }

    public String getFranchiseTax() {
        return FranchiseTax;
    }

    public void setFranchiseTax(String FranchiseTax) {
        this.FranchiseTax = FranchiseTax;
    }

    public String getBusinessTax() {
        return BusinessTax;
    }

    public void setBusinessTax(String BusinessTax) {
        this.BusinessTax = BusinessTax;
    }

    public String getAdjustmentType() {
        return AdjustmentType;
    }

    public void setAdjustmentType(String AdjustmentType) {
        this.AdjustmentType = AdjustmentType;
    }

    public String getForm2307Amount() {
        return Form2307Amount;
    }

    public void setForm2307Amount(String Form2307Amount) {
        this.Form2307Amount = Form2307Amount;
    }

    public String getDeductedDeposit() {
        return DeductedDeposit;
    }

    public void setDeductedDeposit(String DeductedDeposit) {
        this.DeductedDeposit = DeductedDeposit;
    }

    public String getExcessDeposit() {
        return ExcessDeposit;
    }

    public void setExcessDeposit(String ExcessDeposit) {
        this.ExcessDeposit = ExcessDeposit;
    }

    public String getIsUnlockedForPayment() {
        return IsUnlockedForPayment;
    }

    public void setIsUnlockedForPayment(String IsUnlockedForPayment) {
        this.IsUnlockedForPayment = IsUnlockedForPayment;
    }

    public String getUnlockedBy() {
        return UnlockedBy;
    }

    public void setUnlockedBy(String UnlockedBy) {
        this.UnlockedBy = UnlockedBy;
    }

    public String getEvat2Percent() {
        return Evat2Percent;
    }

    public void setEvat2Percent(String Evat2Percent) {
        this.Evat2Percent = Evat2Percent;
    }

    public String getEvat5Percent() {
        return Evat5Percent;
    }

    public void setEvat5Percent(String Evat5Percent) {
        this.Evat5Percent = Evat5Percent;
    }

    public String getAdjustmentNumber() {
        return AdjustmentNumber;
    }

    public void setAdjustmentNumber(String AdjustmentNumber) {
        this.AdjustmentNumber = AdjustmentNumber;
    }

    public String getAdjustedBy() {
        return AdjustedBy;
    }

    public void setAdjustedBy(String AdjustedBy) {
        this.AdjustedBy = AdjustedBy;
    }

    public String getDateAdjusted() {
        return DateAdjusted;
    }

    public void setDateAdjusted(String DateAdjusted) {
        this.DateAdjusted = DateAdjusted;
    }

    public String getForCancellation() {
        return ForCancellation;
    }

    public void setForCancellation(String ForCancellation) {
        this.ForCancellation = ForCancellation;
    }

    public String getCancelRequestedBy() {
        return CancelRequestedBy;
    }

    public void setCancelRequestedBy(String CancelRequestedBy) {
        this.CancelRequestedBy = CancelRequestedBy;
    }

    public String getCancelApprovedBy() {
        return CancelApprovedBy;
    }

    public void setCancelApprovedBy(String CancelApprovedBy) {
        this.CancelApprovedBy = CancelApprovedBy;
    }
    
   
}
