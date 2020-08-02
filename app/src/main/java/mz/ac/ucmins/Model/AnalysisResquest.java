package mz.ac.ucmins.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AnalysisResquest implements Serializable {

    @SerializedName("SampleTypeTitle")
    @Expose
    private String sampleTypeTitle;
    @SerializedName("RejectionReasons")
    @Expose
    private Object rejectionReasons;
    @SerializedName("ResultsInterpretation")
    @Expose
    private Object resultsInterpretation;
    @SerializedName("Template")
    @Expose
    private Object template;
    @SerializedName("ContactUID")
    @Expose
    private String contactUID;
    @SerializedName("exclude_from_nav")
    @Expose
    private Object excludeFromNav;
    @SerializedName("ClientSampleID")
    @Expose
    private Object clientSampleID;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("MemberDiscount")
    @Expose
    private String memberDiscount;
    @SerializedName("ContactUsername")
    @Expose
    private Object contactUsername;
    @SerializedName("DatePublished")
    @Expose
    private Object datePublished;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("DatePreserved")
    @Expose
    private Object datePreserved;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("parent_url")
    @Expose
    private String parentUrl;
    @SerializedName("TemplateURL")
    @Expose
    private Object templateURL;
    @SerializedName("getDoctorUID")
    @Expose
    private Object getDoctorUID;
    @SerializedName("SubGroup")
    @Expose
    private Object subGroup;
    @SerializedName("SampleType")
    @Expose
    private SampleType sampleType;
    @SerializedName("Batch")
    @Expose
    private Object batch;
    @SerializedName("TemplateTitle")
    @Expose
    private Object templateTitle;
    @SerializedName("parent_uid")
    @Expose
    private String parentUid;
    @SerializedName("SamplingDeviation")
    @Expose
    private SamplingDeviation samplingDeviation;
    @SerializedName("DateReceived")
    @Expose
    private String dateReceived;
    @SerializedName("allowDiscussion")
    @Expose
    private Object allowDiscussion;
    @SerializedName("Attachment")
    @Expose
    private Object attachment;
    @SerializedName("SamplePoint")
    @Expose
    private SamplePoint samplePoint;
    @SerializedName("Specification")
    @Expose
    private Object specification;
    @SerializedName("creation_date")
    @Expose
    private String creationDate;
    @SerializedName("Priority")
    @Expose
    private String priority;
    @SerializedName("InternalUse")
    @Expose
    private Object internalUse;
    @SerializedName("Invalidated")
    @Expose
    private Object invalidated;
    @SerializedName("subject")
    @Expose
    private Object subject;
    @SerializedName("ProfilesUID")
    @Expose
    private Object profilesUID;
    @SerializedName("Patient")
    @Expose
    private Patient patient;
    @SerializedName("analysisRequestTemplates")
    @Expose
    private Object analysisRequestTemplates;
    @SerializedName("DateSampled")
    @Expose
    private String dateSampled;
    @SerializedName("Printed")
    @Expose
    private Object printed;
    @SerializedName("getClientID")
    @Expose
    private Object getClientID;
    @SerializedName("review_state")
    @Expose
    private Object reviewState;
    @SerializedName("SamplePointUID")
    @Expose
    private Object samplePointUID;
    @SerializedName("ResultsRange")
    @Expose
    private Object resultsRange;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("Profiles")
    @Expose
    private Object profiles;
    @SerializedName("SamplingDate")
    @Expose
    private Object samplingDate;
    @SerializedName("AnalysisServicesSettings")
    @Expose
    private Object analysisServicesSettings;
    @SerializedName("Contact")
    @Expose
    private Contact contact;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("CreatorFullName")
    @Expose
    private String creatorFullName;
    @SerializedName("EnvironmentalConditions")
    @Expose
    private Object environmentalConditions;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("Retest")
    @Expose
    private Object retest;
    @SerializedName("CCEmails")
    @Expose
    private Object cCEmails;
    @SerializedName("CCContact")
    @Expose
    private Object cCContact;
    @SerializedName("Invoiced")
    @Expose
    private Object invoiced;
    @SerializedName("Preserver")
    @Expose
    private Object preserver;
    @SerializedName("Doctor")
    @Expose
    private Object doctor;
    @SerializedName("PublicationSpecification")
    @Expose
    private Object publicationSpecification;
    @SerializedName("StorageLocationUID")
    @Expose
    private Object storageLocationUID;
    @SerializedName("expirationDate")
    @Expose
    private Object expirationDate;
    @SerializedName("Sampler")
    @Expose
    private Object sampler;
    @SerializedName("BatchURL")
    @Expose
    private Object batchURL;
    @SerializedName("StorageLocation")
    @Expose
    private StorageLocation storageLocation;
    @SerializedName("ContactFullName")
    @Expose
    private String contactFullName;
    @SerializedName("ScheduledSamplingSampler")
    @Expose
    private Object scheduledSamplingSampler;
    @SerializedName("TemplateUID")
    @Expose
    private Object templateUID;
    @SerializedName("parent_path")
    @Expose
    private String parentPath;
    @SerializedName("Composite")
    @Expose
    private Object composite;
    @SerializedName("SamplerFullName")
    @Expose
    private Object samplerFullName;
    @SerializedName("ContactEmail")
    @Expose
    private Object contactEmail;
    @SerializedName("start")
    @Expose
    private Object start;
    @SerializedName("CreatorEmail")
    @Expose
    private String creatorEmail;
    @SerializedName("Analyses")
    @Expose
    private List<Analysis> analyses = null;
    @SerializedName("getDoctorID")
    @Expose
    private Object getDoctorID;
    @SerializedName("ClientOrderNumber")
    @Expose
    private Object clientOrderNumber;
    @SerializedName("SamplerEmail")
    @Expose
    private String samplerEmail;
    @SerializedName("portal_type")
    @Expose
    private String portalType;
    @SerializedName("ReceivedBy")
    @Expose
    private String receivedBy;
    @SerializedName("Client")
    @Expose
    private Client client;
    @SerializedName("InvoiceExclude")
    @Expose
    private Object invoiceExclude;
    @SerializedName("SamplePointTitle")
    @Expose
    private Object samplePointTitle;
    @SerializedName("rights")
    @Expose
    private Object rights;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("Preservation")
    @Expose
    private Preservation preservation;
    @SerializedName("Analyst")
    @Expose
    private Object analyst;
    @SerializedName("ClientPatientID")
    @Expose
    private Object clientPatientID;
    @SerializedName("Invoice")
    @Expose
    private Object invoice;
    @SerializedName("ProfilesTitle")
    @Expose
    private Object profilesTitle;
    @SerializedName("Container")
    @Expose
    private Container container;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("contributors")
    @Expose
    private Object contributors;
    @SerializedName("ClientReference")
    @Expose
    private Object clientReference;
    @SerializedName("ProfilesURL")
    @Expose
    private Object profilesURL;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Profile")
    @Expose
    private Object profile;
    @SerializedName("end")
    @Expose
    private Object end;
    @SerializedName("api_url")
    @Expose
    private String apiUrl;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("_ARAttachment")
    @Expose
    private Object aRAttachment;
    @SerializedName("is_folderish")
    @Expose
    private Object isFolderish;
    @SerializedName("RetentionPeriod")
    @Expose
    private Object retentionPeriod;
    @SerializedName("SampleTypeUID")
    @Expose
    private String sampleTypeUID;
    @SerializedName("BatchID")
    @Expose
    private Object batchID;
    @SerializedName("SampleCondition")
    @Expose
    private SampleCondition sampleCondition;
    @SerializedName("Remarks")
    @Expose
    private Object remarks;
    @SerializedName("PanicEmailAlertSent")
    @Expose
    private Object panicEmailAlertSent;
    @SerializedName("ParentAnalysisRequest")
    @Expose
    private Object parentAnalysisRequest;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("expires")
    @Expose
    private String expires;
    @SerializedName("DefaultContainerType")
    @Expose
    private Object defaultContainerType;
    @SerializedName("ProfilesTitleStr")
    @Expose
    private Object profilesTitleStr;
    @SerializedName("ResultsInterpretationDepts")
    @Expose
    private Object resultsInterpretationDepts;
    @SerializedName("modification_date")
    @Expose
    private String modificationDate;
    @SerializedName("PrimaryAnalysisRequest")
    @Expose
    private Object primaryAnalysisRequest;
    @SerializedName("effectiveDate")
    @Expose
    private Object effectiveDate;
    @SerializedName("effective")
    @Expose
    private String effective;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("DetachedFrom")
    @Expose
    private Object detachedFrom;
    @SerializedName("creators")
    @Expose
    private List<String> creators = null;

    public String getSampleTypeTitle() {
        return sampleTypeTitle;
    }

    public void setSampleTypeTitle(String sampleTypeTitle) {
        this.sampleTypeTitle = sampleTypeTitle;
    }

    public Object getRejectionReasons() {
        return rejectionReasons;
    }

    public void setRejectionReasons(Object rejectionReasons) {
        this.rejectionReasons = rejectionReasons;
    }

    public Object getResultsInterpretation() {
        return resultsInterpretation;
    }

    public void setResultsInterpretation(Object resultsInterpretation) {
        this.resultsInterpretation = resultsInterpretation;
    }

    public Object getTemplate() {
        return template;
    }

    public void setTemplate(Object template) {
        this.template = template;
    }

    public String getContactUID() {
        return contactUID;
    }

    public void setContactUID(String contactUID) {
        this.contactUID = contactUID;
    }

    public Object getExcludeFromNav() {
        return excludeFromNav;
    }

    public void setExcludeFromNav(Object excludeFromNav) {
        this.excludeFromNav = excludeFromNav;
    }

    public Object getClientSampleID() {
        return clientSampleID;
    }

    public void setClientSampleID(Object clientSampleID) {
        this.clientSampleID = clientSampleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(String memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public Object getContactUsername() {
        return contactUsername;
    }

    public void setContactUsername(Object contactUsername) {
        this.contactUsername = contactUsername;
    }

    public Object getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Object datePublished) {
        this.datePublished = datePublished;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Object getDatePreserved() {
        return datePreserved;
    }

    public void setDatePreserved(Object datePreserved) {
        this.datePreserved = datePreserved;
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

    public Object getTemplateURL() {
        return templateURL;
    }

    public void setTemplateURL(Object templateURL) {
        this.templateURL = templateURL;
    }

    public Object getGetDoctorUID() {
        return getDoctorUID;
    }

    public void setGetDoctorUID(Object getDoctorUID) {
        this.getDoctorUID = getDoctorUID;
    }

    public Object getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(Object subGroup) {
        this.subGroup = subGroup;
    }

    public SampleType getSampleType() {
        return sampleType;
    }

    public void setSampleType(SampleType sampleType) {
        this.sampleType = sampleType;
    }

    public Object getBatch() {
        return batch;
    }

    public void setBatch(Object batch) {
        this.batch = batch;
    }

    public Object getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(Object templateTitle) {
        this.templateTitle = templateTitle;
    }

    public String getParentUid() {
        return parentUid;
    }

    public void setParentUid(String parentUid) {
        this.parentUid = parentUid;
    }

    public SamplingDeviation getSamplingDeviation() {
        return samplingDeviation;
    }

    public void setSamplingDeviation(SamplingDeviation samplingDeviation) {
        this.samplingDeviation = samplingDeviation;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Object getAllowDiscussion() {
        return allowDiscussion;
    }

    public void setAllowDiscussion(Object allowDiscussion) {
        this.allowDiscussion = allowDiscussion;
    }

    public Object getAttachment() {
        return attachment;
    }

    public void setAttachment(Object attachment) {
        this.attachment = attachment;
    }

    public SamplePoint getSamplePoint() {
        return samplePoint;
    }

    public void setSamplePoint(SamplePoint samplePoint) {
        this.samplePoint = samplePoint;
    }

    public Object getSpecification() {
        return specification;
    }

    public void setSpecification(Object specification) {
        this.specification = specification;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Object getInternalUse() {
        return internalUse;
    }

    public void setInternalUse(Object internalUse) {
        this.internalUse = internalUse;
    }

    public Object getInvalidated() {
        return invalidated;
    }

    public void setInvalidated(Object invalidated) {
        this.invalidated = invalidated;
    }

    public Object getSubject() {
        return subject;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }

    public Object getProfilesUID() {
        return profilesUID;
    }

    public void setProfilesUID(Object profilesUID) {
        this.profilesUID = profilesUID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Object getAnalysisRequestTemplates() {
        return analysisRequestTemplates;
    }

    public void setAnalysisRequestTemplates(Object analysisRequestTemplates) {
        this.analysisRequestTemplates = analysisRequestTemplates;
    }

    public String getDateSampled() {
        return dateSampled;
    }

    public void setDateSampled(String dateSampled) {
        this.dateSampled = dateSampled;
    }

    public Object getPrinted() {
        return printed;
    }

    public void setPrinted(Object printed) {
        this.printed = printed;
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

    public Object getSamplePointUID() {
        return samplePointUID;
    }

    public void setSamplePointUID(Object samplePointUID) {
        this.samplePointUID = samplePointUID;
    }

    public Object getResultsRange() {
        return resultsRange;
    }

    public void setResultsRange(Object resultsRange) {
        this.resultsRange = resultsRange;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Object getProfiles() {
        return profiles;
    }

    public void setProfiles(Object profiles) {
        this.profiles = profiles;
    }

    public Object getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(Object samplingDate) {
        this.samplingDate = samplingDate;
    }

    public Object getAnalysisServicesSettings() {
        return analysisServicesSettings;
    }

    public void setAnalysisServicesSettings(Object analysisServicesSettings) {
        this.analysisServicesSettings = analysisServicesSettings;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreatorFullName() {
        return creatorFullName;
    }

    public void setCreatorFullName(String creatorFullName) {
        this.creatorFullName = creatorFullName;
    }

    public Object getEnvironmentalConditions() {
        return environmentalConditions;
    }

    public void setEnvironmentalConditions(Object environmentalConditions) {
        this.environmentalConditions = environmentalConditions;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Object getRetest() {
        return retest;
    }

    public void setRetest(Object retest) {
        this.retest = retest;
    }

    public Object getCCEmails() {
        return cCEmails;
    }

    public void setCCEmails(Object cCEmails) {
        this.cCEmails = cCEmails;
    }

    public Object getCCContact() {
        return cCContact;
    }

    public void setCCContact(Object cCContact) {
        this.cCContact = cCContact;
    }

    public Object getInvoiced() {
        return invoiced;
    }

    public void setInvoiced(Object invoiced) {
        this.invoiced = invoiced;
    }

    public Object getPreserver() {
        return preserver;
    }

    public void setPreserver(Object preserver) {
        this.preserver = preserver;
    }

    public Object getDoctor() {
        return doctor;
    }

    public void setDoctor(Object doctor) {
        this.doctor = doctor;
    }

    public Object getPublicationSpecification() {
        return publicationSpecification;
    }

    public void setPublicationSpecification(Object publicationSpecification) {
        this.publicationSpecification = publicationSpecification;
    }

    public Object getStorageLocationUID() {
        return storageLocationUID;
    }

    public void setStorageLocationUID(Object storageLocationUID) {
        this.storageLocationUID = storageLocationUID;
    }

    public Object getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Object expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Object getSampler() {
        return sampler;
    }

    public void setSampler(Object sampler) {
        this.sampler = sampler;
    }

    public Object getBatchURL() {
        return batchURL;
    }

    public void setBatchURL(Object batchURL) {
        this.batchURL = batchURL;
    }

    public StorageLocation getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(StorageLocation storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getContactFullName() {
        return contactFullName;
    }

    public void setContactFullName(String contactFullName) {
        this.contactFullName = contactFullName;
    }

    public Object getScheduledSamplingSampler() {
        return scheduledSamplingSampler;
    }

    public void setScheduledSamplingSampler(Object scheduledSamplingSampler) {
        this.scheduledSamplingSampler = scheduledSamplingSampler;
    }

    public Object getTemplateUID() {
        return templateUID;
    }

    public void setTemplateUID(Object templateUID) {
        this.templateUID = templateUID;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public Object getComposite() {
        return composite;
    }

    public void setComposite(Object composite) {
        this.composite = composite;
    }

    public Object getSamplerFullName() {
        return samplerFullName;
    }

    public void setSamplerFullName(Object samplerFullName) {
        this.samplerFullName = samplerFullName;
    }

    public Object getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(Object contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public List<Analysis> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<Analysis> analyses) {
        this.analyses = analyses;
    }

    public Object getGetDoctorID() {
        return getDoctorID;
    }

    public void setGetDoctorID(Object getDoctorID) {
        this.getDoctorID = getDoctorID;
    }

    public Object getClientOrderNumber() {
        return clientOrderNumber;
    }

    public void setClientOrderNumber(Object clientOrderNumber) {
        this.clientOrderNumber = clientOrderNumber;
    }

    public String getSamplerEmail() {
        return samplerEmail;
    }

    public void setSamplerEmail(String samplerEmail) {
        this.samplerEmail = samplerEmail;
    }

    public String getPortalType() {
        return portalType;
    }

    public void setPortalType(String portalType) {
        this.portalType = portalType;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Object getInvoiceExclude() {
        return invoiceExclude;
    }

    public void setInvoiceExclude(Object invoiceExclude) {
        this.invoiceExclude = invoiceExclude;
    }

    public Object getSamplePointTitle() {
        return samplePointTitle;
    }

    public void setSamplePointTitle(Object samplePointTitle) {
        this.samplePointTitle = samplePointTitle;
    }

    public Object getRights() {
        return rights;
    }

    public void setRights(Object rights) {
        this.rights = rights;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Preservation getPreservation() {
        return preservation;
    }

    public void setPreservation(Preservation preservation) {
        this.preservation = preservation;
    }

    public Object getAnalyst() {
        return analyst;
    }

    public void setAnalyst(Object analyst) {
        this.analyst = analyst;
    }

    public Object getClientPatientID() {
        return clientPatientID;
    }

    public void setClientPatientID(Object clientPatientID) {
        this.clientPatientID = clientPatientID;
    }

    public Object getInvoice() {
        return invoice;
    }

    public void setInvoice(Object invoice) {
        this.invoice = invoice;
    }

    public Object getProfilesTitle() {
        return profilesTitle;
    }

    public void setProfilesTitle(Object profilesTitle) {
        this.profilesTitle = profilesTitle;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
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

    public Object getClientReference() {
        return clientReference;
    }

    public void setClientReference(Object clientReference) {
        this.clientReference = clientReference;
    }

    public Object getProfilesURL() {
        return profilesURL;
    }

    public void setProfilesURL(Object profilesURL) {
        this.profilesURL = profilesURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getProfile() {
        return profile;
    }

    public void setProfile(Object profile) {
        this.profile = profile;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getARAttachment() {
        return aRAttachment;
    }

    public void setARAttachment(Object aRAttachment) {
        this.aRAttachment = aRAttachment;
    }

    public Object getIsFolderish() {
        return isFolderish;
    }

    public void setIsFolderish(Object isFolderish) {
        this.isFolderish = isFolderish;
    }

    public Object getRetentionPeriod() {
        return retentionPeriod;
    }

    public void setRetentionPeriod(Object retentionPeriod) {
        this.retentionPeriod = retentionPeriod;
    }

    public String getSampleTypeUID() {
        return sampleTypeUID;
    }

    public void setSampleTypeUID(String sampleTypeUID) {
        this.sampleTypeUID = sampleTypeUID;
    }

    public Object getBatchID() {
        return batchID;
    }

    public void setBatchID(Object batchID) {
        this.batchID = batchID;
    }

    public SampleCondition getSampleCondition() {
        return sampleCondition;
    }

    public void setSampleCondition(SampleCondition sampleCondition) {
        this.sampleCondition = sampleCondition;
    }

    public Object getRemarks() {
        return remarks;
    }

    public void setRemarks(Object remarks) {
        this.remarks = remarks;
    }

    public Object getPanicEmailAlertSent() {
        return panicEmailAlertSent;
    }

    public void setPanicEmailAlertSent(Object panicEmailAlertSent) {
        this.panicEmailAlertSent = panicEmailAlertSent;
    }

    public Object getParentAnalysisRequest() {
        return parentAnalysisRequest;
    }

    public void setParentAnalysisRequest(Object parentAnalysisRequest) {
        this.parentAnalysisRequest = parentAnalysisRequest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public Object getDefaultContainerType() {
        return defaultContainerType;
    }

    public void setDefaultContainerType(Object defaultContainerType) {
        this.defaultContainerType = defaultContainerType;
    }

    public Object getProfilesTitleStr() {
        return profilesTitleStr;
    }

    public void setProfilesTitleStr(Object profilesTitleStr) {
        this.profilesTitleStr = profilesTitleStr;
    }

    public Object getResultsInterpretationDepts() {
        return resultsInterpretationDepts;
    }

    public void setResultsInterpretationDepts(Object resultsInterpretationDepts) {
        this.resultsInterpretationDepts = resultsInterpretationDepts;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Object getPrimaryAnalysisRequest() {
        return primaryAnalysisRequest;
    }

    public void setPrimaryAnalysisRequest(Object primaryAnalysisRequest) {
        this.primaryAnalysisRequest = primaryAnalysisRequest;
    }

    public Object getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Object effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getDetachedFrom() {
        return detachedFrom;
    }

    public void setDetachedFrom(Object detachedFrom) {
        this.detachedFrom = detachedFrom;
    }

    public List<String> getCreators() {
        return creators;
    }

    public void setCreators(List<String> creators) {
        this.creators = creators;
    }


   public class Patient implements Serializable {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("uid")
        @Expose
        private String uid;
        @SerializedName("api_url")
        @Expose
        private String apiUrl;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getApiUrl() {
            return apiUrl;
        }

        public void setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
        }

    }



}


