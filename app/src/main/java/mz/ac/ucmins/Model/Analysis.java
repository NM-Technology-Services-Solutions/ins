package mz.ac.ucmins.Model;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Analysis implements Serializable
{

    @SerializedName("Category")
    @Expose
    private Category category;
    @SerializedName("Uncertainties")
    @Expose
    private Object uncertainties;
    @SerializedName("SortKey")
    @Expose
    private Object sortKey;
    @SerializedName("expirationDate")
    @Expose
    private Object expirationDate;
    @SerializedName("Department")
    @Expose
    private Department department;
    @SerializedName("RetestOf")
    @Expose
    private RetestOf retestOf;
    @SerializedName("exclude_from_nav")
    @Expose
    private Object excludeFromNav;
    @SerializedName("Analyst")
    @Expose
    private Object analyst;
    @SerializedName("effectiveDate")
    @Expose
    private Object effectiveDate;
    @SerializedName("OriginalReflexedAnalysis")
    @Expose
    private OriginalReflexedAnalysis originalReflexedAnalysis;
    @SerializedName("ShortTitle")
    @Expose
    private Object shortTitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ProtocolID")
    @Expose
    private Object protocolID;
    @SerializedName("ReflexRuleLocalID")
    @Expose
    private Object reflexRuleLocalID;
    @SerializedName("Precision")
    @Expose
    private Object precision;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("ResultsRange")
    @Expose
    private Object resultsRange;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("parent_url")
    @Expose
    private String parentUrl;
    @SerializedName("Keyword")
    @Expose
    private String keyword;
    @SerializedName("getDoctorUID")
    @Expose
    private Object getDoctorUID;
    @SerializedName("UpperDetectionLimit")
    @Expose
    private String upperDetectionLimit;
    @SerializedName("HiddenManually")
    @Expose
    private boolean hiddenManually;
    @SerializedName("ResultOptions")
    @Expose
    private Object resultOptions;
    @SerializedName("NumberOfRequiredVerifications")
    @Expose
    private int numberOfRequiredVerifications;
    @SerializedName("portal_type")
    @Expose
    private String portalType;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("Accredited")
    @Expose
    private Object accredited;
    @SerializedName("CommercialID")
    @Expose
    private Object commercialID;
    @SerializedName("DetectionLimitOperand")
    @Expose
    private Object detectionLimitOperand;
    @SerializedName("parent_uid")
    @Expose
    private String parentUid;
    @SerializedName("VAT")
    @Expose
    private String vat;
    @SerializedName("parent_path")
    @Expose
    private String parentPath;
    @SerializedName("ReflexRuleActionsTriggered")
    @Expose
    private Object reflexRuleActionsTriggered;
    @SerializedName("rights")
    @Expose
    private Object rights;
    @SerializedName("Calculation")
    @Expose
    private Object calculation;
    @SerializedName("IsReflexAnalysis")
    @Expose
    private Object isReflexAnalysis;
    @SerializedName("AnalysisService")
    @Expose
    private AnalysisService analysisService;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("InterimFields")
    @Expose
    private Object interimFields;
    @SerializedName("getDoctorID")
    @Expose
    private Object getDoctorID;
    @SerializedName("allowDiscussion")
    @Expose
    private Object allowDiscussion;
    @SerializedName("StringResult")
    @Expose
    private Object stringResult;
    @SerializedName("Unit")
    @Expose
    private String unit;
    @SerializedName("Attachment")
    @Expose
    private Attachment attachment;
    @SerializedName("DuplicateVariation")
    @Expose
    private String duplicateVariation;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("contributors")
    @Expose
    private Object contributors;
    @SerializedName("BulkPrice")
    @Expose
    private String bulkPrice;
    @SerializedName("ExponentialFormatPrecision")
    @Expose
    private int exponentialFormatPrecision;
    @SerializedName("creation_date")
    @Expose
    private String creationDate;
    @SerializedName("Instrument")
    @Expose
    private Instrument instrument;
    @SerializedName("ScientificName")
    @Expose
    private Object scientificName;
    @SerializedName("Hidden")
    @Expose
    private Object hidden;
    @SerializedName("PointOfCapture")
    @Expose
    private String pointOfCapture;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subject")
    @Expose
    private Object subject;
    @SerializedName("ResultCaptureDate")
    @Expose
    private String resultCaptureDate;
    @SerializedName("end")
    @Expose
    private Object end;
    @SerializedName("api_url")
    @Expose
    private String apiUrl;
    @SerializedName("analysisRequestTemplates")
    @Expose
    private Object analysisRequestTemplates;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("is_folderish")
    @Expose
    private Object isFolderish;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("Method")
    @Expose
    private Method method;
    @SerializedName("Remarks")
    @Expose
    private Object remarks;
    @SerializedName("getClientID")
    @Expose
    private Object getClientID;
    @SerializedName("review_state")
    @Expose
    private Object reviewState;
    @SerializedName("ReflexAnalysisOf")
    @Expose
    private ReflexAnalysisOf reflexAnalysisOf;
    @SerializedName("PrecisionFromUncertainty")
    @Expose
    private Object precisionFromUncertainty;
    @SerializedName("start")
    @Expose
    private Object start;
    @SerializedName("AllowManualDetectionLimit")
    @Expose
    private Object allowManualDetectionLimit;
    @SerializedName("Uncertainty")
    @Expose
    private Object uncertainty;
    @SerializedName("AttachmentOption")
    @Expose
    private String attachmentOption;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("expires")
    @Expose
    private String expires;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("LowerDetectionLimit")
    @Expose
    private String lowerDetectionLimit;
    @SerializedName("MaxTimeAllowed")
    @Expose
    private MaxTimeAllowed maxTimeAllowed;
    @SerializedName("InstrumentEntryOfResults")
    @Expose
    private Object instrumentEntryOfResults;
    @SerializedName("ReflexRuleAction")
    @Expose
    private Object reflexRuleAction;
    @SerializedName("modification_date")
    @Expose
    private String modificationDate;
    @SerializedName("effective")
    @Expose
    private String effective;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("ManualEntryOfResults")
    @Expose
    private boolean manualEntryOfResults;
    @SerializedName("DetectionLimitSelector")
    @Expose
    private Object detectionLimitSelector;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("creators")
    @Expose
    private List<String> creators = null;
    @SerializedName("AllowManualUncertainty")
    @Expose
    private Object allowManualUncertainty;
    @SerializedName("SelfVerification")
    @Expose
    private int selfVerification;
    private final static long serialVersionUID = 8354475055667218992L;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Object getUncertainties() {
        return uncertainties;
    }

    public void setUncertainties(Object uncertainties) {
        this.uncertainties = uncertainties;
    }

    public Object getSortKey() {
        return sortKey;
    }

    public void setSortKey(Object sortKey) {
        this.sortKey = sortKey;
    }

    public Object getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Object expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public RetestOf getRetestOf() {
        return retestOf;
    }

    public void setRetestOf(RetestOf retestOf) {
        this.retestOf = retestOf;
    }

    public Object getExcludeFromNav() {
        return excludeFromNav;
    }

    public void setExcludeFromNav(Object excludeFromNav) {
        this.excludeFromNav = excludeFromNav;
    }

    public Object getAnalyst() {
        return analyst;
    }

    public void setAnalyst(Object analyst) {
        this.analyst = analyst;
    }

    public Object getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Object effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public OriginalReflexedAnalysis getOriginalReflexedAnalysis() {
        return originalReflexedAnalysis;
    }

    public void setOriginalReflexedAnalysis(OriginalReflexedAnalysis originalReflexedAnalysis) {
        this.originalReflexedAnalysis = originalReflexedAnalysis;
    }

    public Object getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(Object shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getProtocolID() {
        return protocolID;
    }

    public void setProtocolID(Object protocolID) {
        this.protocolID = protocolID;
    }

    public Object getReflexRuleLocalID() {
        return reflexRuleLocalID;
    }

    public void setReflexRuleLocalID(Object reflexRuleLocalID) {
        this.reflexRuleLocalID = reflexRuleLocalID;
    }

    public Object getPrecision() {
        return precision;
    }

    public void setPrecision(Object precision) {
        this.precision = precision;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Object getResultsRange() {
        return resultsRange;
    }

    public void setResultsRange(Object resultsRange) {
        this.resultsRange = resultsRange;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Object getGetDoctorUID() {
        return getDoctorUID;
    }

    public void setGetDoctorUID(Object getDoctorUID) {
        this.getDoctorUID = getDoctorUID;
    }

    public String getUpperDetectionLimit() {
        return upperDetectionLimit;
    }

    public void setUpperDetectionLimit(String upperDetectionLimit) {
        this.upperDetectionLimit = upperDetectionLimit;
    }

    public boolean isHiddenManually() {
        return hiddenManually;
    }

    public void setHiddenManually(boolean hiddenManually) {
        this.hiddenManually = hiddenManually;
    }

    public Object getResultOptions() {
        return resultOptions;
    }

    public void setResultOptions(Object resultOptions) {
        this.resultOptions = resultOptions;
    }

    public int getNumberOfRequiredVerifications() {
        return numberOfRequiredVerifications;
    }

    public void setNumberOfRequiredVerifications(int numberOfRequiredVerifications) {
        this.numberOfRequiredVerifications = numberOfRequiredVerifications;
    }

    public String getPortalType() {
        return portalType;
    }

    public void setPortalType(String portalType) {
        this.portalType = portalType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getAccredited() {
        return accredited;
    }

    public void setAccredited(Object accredited) {
        this.accredited = accredited;
    }

    public Object getCommercialID() {
        return commercialID;
    }

    public void setCommercialID(Object commercialID) {
        this.commercialID = commercialID;
    }

    public Object getDetectionLimitOperand() {
        return detectionLimitOperand;
    }

    public void setDetectionLimitOperand(Object detectionLimitOperand) {
        this.detectionLimitOperand = detectionLimitOperand;
    }

    public String getParentUid() {
        return parentUid;
    }

    public void setParentUid(String parentUid) {
        this.parentUid = parentUid;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public Object getReflexRuleActionsTriggered() {
        return reflexRuleActionsTriggered;
    }

    public void setReflexRuleActionsTriggered(Object reflexRuleActionsTriggered) {
        this.reflexRuleActionsTriggered = reflexRuleActionsTriggered;
    }

    public Object getRights() {
        return rights;
    }

    public void setRights(Object rights) {
        this.rights = rights;
    }

    public Object getCalculation() {
        return calculation;
    }

    public void setCalculation(Object calculation) {
        this.calculation = calculation;
    }

    public Object getIsReflexAnalysis() {
        return isReflexAnalysis;
    }

    public void setIsReflexAnalysis(Object isReflexAnalysis) {
        this.isReflexAnalysis = isReflexAnalysis;
    }

    public AnalysisService getAnalysisService() {
        return analysisService;
    }

    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Object getInterimFields() {
        return interimFields;
    }

    public void setInterimFields(Object interimFields) {
        this.interimFields = interimFields;
    }

    public Object getGetDoctorID() {
        return getDoctorID;
    }

    public void setGetDoctorID(Object getDoctorID) {
        this.getDoctorID = getDoctorID;
    }

    public Object getAllowDiscussion() {
        return allowDiscussion;
    }

    public void setAllowDiscussion(Object allowDiscussion) {
        this.allowDiscussion = allowDiscussion;
    }

    public Object getStringResult() {
        return stringResult;
    }

    public void setStringResult(Object stringResult) {
        this.stringResult = stringResult;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getDuplicateVariation() {
        return duplicateVariation;
    }

    public void setDuplicateVariation(String duplicateVariation) {
        this.duplicateVariation = duplicateVariation;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Object getContributors() {
        return contributors;
    }

    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    public String getBulkPrice() {
        return bulkPrice;
    }

    public void setBulkPrice(String bulkPrice) {
        this.bulkPrice = bulkPrice;
    }

    public int getExponentialFormatPrecision() {
        return exponentialFormatPrecision;
    }

    public void setExponentialFormatPrecision(int exponentialFormatPrecision) {
        this.exponentialFormatPrecision = exponentialFormatPrecision;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Object getScientificName() {
        return scientificName;
    }

    public void setScientificName(Object scientificName) {
        this.scientificName = scientificName;
    }

    public Object getHidden() {
        return hidden;
    }

    public void setHidden(Object hidden) {
        this.hidden = hidden;
    }

    public String getPointOfCapture() {
        return pointOfCapture;
    }

    public void setPointOfCapture(String pointOfCapture) {
        this.pointOfCapture = pointOfCapture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getSubject() {
        return subject;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }

    public String getResultCaptureDate() {
        return resultCaptureDate;
    }

    public void setResultCaptureDate(String resultCaptureDate) {
        this.resultCaptureDate = resultCaptureDate;
    }

    public Object getEnd() {
        return end;
    }

    public void setEnd(Object end) {
        this.end = end;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Object getAnalysisRequestTemplates() {
        return analysisRequestTemplates;
    }

    public void setAnalysisRequestTemplates(Object analysisRequestTemplates) {
        this.analysisRequestTemplates = analysisRequestTemplates;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getIsFolderish() {
        return isFolderish;
    }

    public void setIsFolderish(Object isFolderish) {
        this.isFolderish = isFolderish;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getRemarks() {
        return remarks;
    }

    public void setRemarks(Object remarks) {
        this.remarks = remarks;
    }

    public Object getGetClientID() {
        return getClientID;
    }

    public void setGetClientID(Object getClientID) {
        this.getClientID = getClientID;
    }

    public Object getReviewState() {
        return reviewState;
    }

    public void setReviewState(Object reviewState) {
        this.reviewState = reviewState;
    }

    public ReflexAnalysisOf getReflexAnalysisOf() {
        return reflexAnalysisOf;
    }

    public void setReflexAnalysisOf(ReflexAnalysisOf reflexAnalysisOf) {
        this.reflexAnalysisOf = reflexAnalysisOf;
    }

    public Object getPrecisionFromUncertainty() {
        return precisionFromUncertainty;
    }

    public void setPrecisionFromUncertainty(Object precisionFromUncertainty) {
        this.precisionFromUncertainty = precisionFromUncertainty;
    }

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }

    public Object getAllowManualDetectionLimit() {
        return allowManualDetectionLimit;
    }

    public void setAllowManualDetectionLimit(Object allowManualDetectionLimit) {
        this.allowManualDetectionLimit = allowManualDetectionLimit;
    }

    public Object getUncertainty() {
        return uncertainty;
    }

    public void setUncertainty(Object uncertainty) {
        this.uncertainty = uncertainty;
    }

    public String getAttachmentOption() {
        return attachmentOption;
    }

    public void setAttachmentOption(String attachmentOption) {
        this.attachmentOption = attachmentOption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLowerDetectionLimit() {
        return lowerDetectionLimit;
    }

    public void setLowerDetectionLimit(String lowerDetectionLimit) {
        this.lowerDetectionLimit = lowerDetectionLimit;
    }

    public MaxTimeAllowed getMaxTimeAllowed() {
        return maxTimeAllowed;
    }

    public void setMaxTimeAllowed(MaxTimeAllowed maxTimeAllowed) {
        this.maxTimeAllowed = maxTimeAllowed;
    }

    public Object getInstrumentEntryOfResults() {
        return instrumentEntryOfResults;
    }

    public void setInstrumentEntryOfResults(Object instrumentEntryOfResults) {
        this.instrumentEntryOfResults = instrumentEntryOfResults;
    }

    public Object getReflexRuleAction() {
        return reflexRuleAction;
    }

    public void setReflexRuleAction(Object reflexRuleAction) {
        this.reflexRuleAction = reflexRuleAction;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isManualEntryOfResults() {
        return manualEntryOfResults;
    }

    public void setManualEntryOfResults(boolean manualEntryOfResults) {
        this.manualEntryOfResults = manualEntryOfResults;
    }

    public Object getDetectionLimitSelector() {
        return detectionLimitSelector;
    }

    public void setDetectionLimitSelector(Object detectionLimitSelector) {
        this.detectionLimitSelector = detectionLimitSelector;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String> getCreators() {
        return creators;
    }

    public void setCreators(List<String> creators) {
        this.creators = creators;
    }

    public Object getAllowManualUncertainty() {
        return allowManualUncertainty;
    }

    public void setAllowManualUncertainty(Object allowManualUncertainty) {
        this.allowManualUncertainty = allowManualUncertainty;
    }

    public int getSelfVerification() {
        return selfVerification;
    }

    public void setSelfVerification(int selfVerification) {
        this.selfVerification = selfVerification;
    }

}
