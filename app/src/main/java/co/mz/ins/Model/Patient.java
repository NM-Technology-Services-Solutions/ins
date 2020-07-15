package co.mz.ins.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Patient {

    @SerializedName("MothersName")
    @Expose
    private Object mothersName;
    @SerializedName("PrimaryReferrerUID")
    @Expose
    private Object primaryReferrerUID;
    @SerializedName("expirationDate")
    @Expose
    private Object expirationDate;
    @SerializedName("Department")
    @Expose
    private Object department;
    @SerializedName("exclude_from_nav")
    @Expose
    private Object excludeFromNav;
    @SerializedName("Analyst")
    @Expose
    private Object analyst;
    @SerializedName("JobTitle")
    @Expose
    private Object jobTitle;
    @SerializedName("RatioOfSamplesOngoing")
    @Expose
    private int ratioOfSamplesOngoing;
    @SerializedName("ChronicConditions")
    @Expose
    private Object chronicConditions;
    @SerializedName("contributors")
    @Expose
    private Object contributors;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("Middlename")
    @Expose
    private Object middlename;
    @SerializedName("PatientAsGuarantor")
    @Expose
    private boolean patientAsGuarantor;
    @SerializedName("MobilePhone")
    @Expose
    private String mobilePhone;
    @SerializedName("Fullname")
    @Expose
    private String fullname;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("Anonymous")
    @Expose
    private Object anonymous;
    @SerializedName("Allergies")
    @Expose
    private Object allergies;
    @SerializedName("parent_url")
    @Expose
    private String parentUrl;
    @SerializedName("getDoctorUID")
    @Expose
    private Object getDoctorUID;
    @SerializedName("PhysicalAddress")
    @Expose
    private Address physicalAddress;
    @SerializedName("GuarantorBusinessPhone")
    @Expose
    private Object guarantorBusinessPhone;
    @SerializedName("PrimaryReferrer")
    @Expose
    private Object primaryReferrer;
    @SerializedName("portal_type")
    @Expose
    private String portalType;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("PostalCode")
    @Expose
    private Object postalCode;
    @SerializedName("Surname")
    @Expose
    private String surname;
    @SerializedName("GuarantorID")
    @Expose
    private Object guarantorID;
    @SerializedName("TreatmentHistory")
    @Expose
    private Object treatmentHistory;
    @SerializedName("parent_uid")
    @Expose
    private String parentUid;
    @SerializedName("Citizenship")
    @Expose
    private Object citizenship;
    @SerializedName("AgeSplitted")
    @Expose
    private List<AgeSplitted> ageSplitted = null;
    @SerializedName("BirthPlace")
    @Expose
    private Object birthPlace;
    @SerializedName("Ethnicity_Obj")
    @Expose
    private EthnicityObj ethnicityObj;
    @SerializedName("parent_path")
    @Expose
    private String parentPath;
    @SerializedName("PrimaryReferrerTitle")
    @Expose
    private Object primaryReferrerTitle;
    @SerializedName("GuarantorFirstname")
    @Expose
    private Object guarantorFirstname;
    @SerializedName("CountryState")
    @Expose
    private CountryState countryState;
    @SerializedName("PatientIdentifiersStr")
    @Expose
    private Object patientIdentifiersStr;
    @SerializedName("GuarantorHomePhone")
    @Expose
    private Object guarantorHomePhone;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("getDoctorID")
    @Expose
    private Object getDoctorID;
    @SerializedName("MenstrualStatus")
    @Expose
    private List<Menstrualstatus> menstrualStatus = null;
    @SerializedName("ClientPatientID")
    @Expose
    private String clientPatientID;
    @SerializedName("NumberOfSamples")
    @Expose
    private int numberOfSamples;
    @SerializedName("EmailAddress")
    @Expose
    private Object emailAddress;
    @SerializedName("NumberOfSamplesOngoing")
    @Expose
    private int numberOfSamplesOngoing;
    @SerializedName("GuarantorMobilePhone")
    @Expose
    private Object guarantorMobilePhone;
    @SerializedName("allowDiscussion")
    @Expose
    private Object allowDiscussion;
    @SerializedName("Ethnicity")
    @Expose
    private Object ethnicity;
    @SerializedName("PublicationAttachmentsPermitted")
    @Expose
    private Object publicationAttachmentsPermitted;
    @SerializedName("CivilStatus")
    @Expose
    private Object civilStatus;
    @SerializedName("City")
    @Expose
    private Object city;
    @SerializedName("BusinessPhone")
    @Expose
    private Object businessPhone;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("District")
    @Expose
    private Object district;
    @SerializedName("Middleinitial")
    @Expose
    private Object middleinitial;
    @SerializedName("ConsentSMS")
    @Expose
    private boolean consentSMS;
    @SerializedName("Feature")
    @Expose
    private Object feature;
    @SerializedName("Firstname")
    @Expose
    private String firstname;
    @SerializedName("creation_date")
    @Expose
    private String creationDate;
    @SerializedName("InsuranceNumber")
    @Expose
    private Object insuranceNumber;
    @SerializedName("TravelHistory")
    @Expose
    private Object travelHistory;
    @SerializedName("modification_date")
    @Expose
    private String modificationDate;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subject")
    @Expose
    private Object subject;
    @SerializedName("Username")
    @Expose
    private Object username;
    @SerializedName("DefaultResultsDistribution")
    @Expose
    private boolean defaultResultsDistribution;
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
    @SerializedName("NumberOfSamplesCancelled")
    @Expose
    private Object numberOfSamplesCancelled;
    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("BirthDateEstimated")
    @Expose
    private boolean birthDateEstimated;
    @SerializedName("InvoiceToInsuranceCompany")
    @Expose
    private Object invoiceToInsuranceCompany;
    @SerializedName("ObjectWorkflowStates")
    @Expose
    private ObjectWorkflowStates objectWorkflowStates;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Remarks")
    @Expose
    private Object remarks;
    @SerializedName("getClientID")
    @Expose
    private Object getClientID;
    @SerializedName("review_state")
    @Expose
    private Object reviewState;
    @SerializedName("BusinessFax")
    @Expose
    private Object businessFax;
    @SerializedName("start")
    @Expose
    private Object start;
    @SerializedName("PrimaryReferrerID")
    @Expose
    private Object primaryReferrerID;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("GuarantorSurname")
    @Expose
    private Object guarantorSurname;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("Age")
    @Expose
    private Object age;
    @SerializedName("expires")
    @Expose
    private String expires;
    @SerializedName("ImmunizationHistory")
    @Expose
    private Object immunizationHistory;
    @SerializedName("PatientIdentifiers")
    @Expose
    private Object patientIdentifiers;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("PostalAddress")
    @Expose
    private Address postalAddress;
    @SerializedName("AllowResultsDistribution")
    @Expose
    private Object allowResultsDistribution;
    @SerializedName("rights")
    @Expose
    private Object rights;
    @SerializedName("effectiveDate")
    @Expose
    private Object effectiveDate;
    @SerializedName("effective")
    @Expose
    private String effective;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("Photo")
    @Expose
    private Object photo;
    @SerializedName("FathersName")
    @Expose
    private Object fathersName;
    @SerializedName("PrimaryReferrerURL")
    @Expose
    private Object primaryReferrerURL;
    @SerializedName("NumberOfSamplesPublished")
    @Expose
    private Object numberOfSamplesPublished;
    @SerializedName("HomePhone")
    @Expose
    private Object homePhone;
    @SerializedName("Salutation")
    @Expose
    private Object salutation;
    @SerializedName("creators")
    @Expose
    private List<String> creators = null;
    @SerializedName("GuarantorPostalAddress")
    @Expose
    private Address guarantorPostalAddress;
    @SerializedName("InsuranceCompany")
    @Expose
    private Object insuranceCompany;
    @SerializedName("PatientID")
    @Expose
    private String patientID;

    public Object getMothersName() {
        return mothersName;
    }

    public void setMothersName(Object mothersName) {
        this.mothersName = mothersName;
    }

    public Object getPrimaryReferrerUID() {
        return primaryReferrerUID;
    }

    public void setPrimaryReferrerUID(Object primaryReferrerUID) {
        this.primaryReferrerUID = primaryReferrerUID;
    }

    public Object getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Object expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
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

    public Object getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Object jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getRatioOfSamplesOngoing() {
        return ratioOfSamplesOngoing;
    }

    public void setRatioOfSamplesOngoing(int ratioOfSamplesOngoing) {
        this.ratioOfSamplesOngoing = ratioOfSamplesOngoing;
    }

    public Object getChronicConditions() {
        return chronicConditions;
    }

    public void setChronicConditions(Object chronicConditions) {
        this.chronicConditions = chronicConditions;
    }

    public Object getContributors() {
        return contributors;
    }

    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getMiddlename() {
        return middlename;
    }

    public void setMiddlename(Object middlename) {
        this.middlename = middlename;
    }

    public boolean isPatientAsGuarantor() {
        return patientAsGuarantor;
    }

    public void setPatientAsGuarantor(boolean patientAsGuarantor) {
        this.patientAsGuarantor = patientAsGuarantor;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Object anonymous) {
        this.anonymous = anonymous;
    }

    public Object getAllergies() {
        return allergies;
    }

    public void setAllergies(Object allergies) {
        this.allergies = allergies;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public Object getGetDoctorUID() {
        return getDoctorUID;
    }

    public void setGetDoctorUID(Object getDoctorUID) {
        this.getDoctorUID = getDoctorUID;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(Address physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public Object getGuarantorBusinessPhone() {
        return guarantorBusinessPhone;
    }

    public void setGuarantorBusinessPhone(Object guarantorBusinessPhone) {
        this.guarantorBusinessPhone = guarantorBusinessPhone;
    }

    public Object getPrimaryReferrer() {
        return primaryReferrer;
    }

    public void setPrimaryReferrer(Object primaryReferrer) {
        this.primaryReferrer = primaryReferrer;
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

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Object getGuarantorID() {
        return guarantorID;
    }

    public void setGuarantorID(Object guarantorID) {
        this.guarantorID = guarantorID;
    }

    public Object getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(Object treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public String getParentUid() {
        return parentUid;
    }

    public void setParentUid(String parentUid) {
        this.parentUid = parentUid;
    }

    public Object getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Object citizenship) {
        this.citizenship = citizenship;
    }

    public List<AgeSplitted> getAgeSplitted() {
        return ageSplitted;
    }

    public void setAgeSplitted(List<AgeSplitted> ageSplitted) {
        this.ageSplitted = ageSplitted;
    }

    public Object getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Object birthPlace) {
        this.birthPlace = birthPlace;
    }

    public EthnicityObj getEthnicityObj() {
        return ethnicityObj;
    }

    public void setEthnicityObj(EthnicityObj ethnicityObj) {
        this.ethnicityObj = ethnicityObj;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public Object getPrimaryReferrerTitle() {
        return primaryReferrerTitle;
    }

    public void setPrimaryReferrerTitle(Object primaryReferrerTitle) {
        this.primaryReferrerTitle = primaryReferrerTitle;
    }

    public Object getGuarantorFirstname() {
        return guarantorFirstname;
    }

    public void setGuarantorFirstname(Object guarantorFirstname) {
        this.guarantorFirstname = guarantorFirstname;
    }

    public CountryState getCountryState() {
        return countryState;
    }

    public void setCountryState(CountryState countryState) {
        this.countryState = countryState;
    }

    public Object getPatientIdentifiersStr() {
        return patientIdentifiersStr;
    }

    public void setPatientIdentifiersStr(Object patientIdentifiersStr) {
        this.patientIdentifiersStr = patientIdentifiersStr;
    }

    public Object getGuarantorHomePhone() {
        return guarantorHomePhone;
    }

    public void setGuarantorHomePhone(Object guarantorHomePhone) {
        this.guarantorHomePhone = guarantorHomePhone;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Object getGetDoctorID() {
        return getDoctorID;
    }

    public void setGetDoctorID(Object getDoctorID) {
        this.getDoctorID = getDoctorID;
    }

    public List<Menstrualstatus> getMenstrualStatus() {
        return menstrualStatus;
    }

    public void setMenstrualStatus(List<Menstrualstatus> menstrualStatus) {
        this.menstrualStatus = menstrualStatus;
    }

    public String getClientPatientID() {
        return clientPatientID;
    }

    public void setClientPatientID(String clientPatientID) {
        this.clientPatientID = clientPatientID;
    }

    public int getNumberOfSamples() {
        return numberOfSamples;
    }

    public void setNumberOfSamples(int numberOfSamples) {
        this.numberOfSamples = numberOfSamples;
    }

    public Object getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(Object emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getNumberOfSamplesOngoing() {
        return numberOfSamplesOngoing;
    }

    public void setNumberOfSamplesOngoing(int numberOfSamplesOngoing) {
        this.numberOfSamplesOngoing = numberOfSamplesOngoing;
    }

    public Object getGuarantorMobilePhone() {
        return guarantorMobilePhone;
    }

    public void setGuarantorMobilePhone(Object guarantorMobilePhone) {
        this.guarantorMobilePhone = guarantorMobilePhone;
    }

    public Object getAllowDiscussion() {
        return allowDiscussion;
    }

    public void setAllowDiscussion(Object allowDiscussion) {
        this.allowDiscussion = allowDiscussion;
    }

    public Object getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Object ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Object getPublicationAttachmentsPermitted() {
        return publicationAttachmentsPermitted;
    }

    public void setPublicationAttachmentsPermitted(Object publicationAttachmentsPermitted) {
        this.publicationAttachmentsPermitted = publicationAttachmentsPermitted;
    }

    public Object getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(Object civilStatus) {
        this.civilStatus = civilStatus;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(Object businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Object getDistrict() {
        return district;
    }

    public void setDistrict(Object district) {
        this.district = district;
    }

    public Object getMiddleinitial() {
        return middleinitial;
    }

    public void setMiddleinitial(Object middleinitial) {
        this.middleinitial = middleinitial;
    }

    public boolean isConsentSMS() {
        return consentSMS;
    }

    public void setConsentSMS(boolean consentSMS) {
        this.consentSMS = consentSMS;
    }

    public Object getFeature() {
        return feature;
    }

    public void setFeature(Object feature) {
        this.feature = feature;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Object getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(Object insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Object getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(Object travelHistory) {
        this.travelHistory = travelHistory;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
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

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = username;
    }

    public boolean isDefaultResultsDistribution() {
        return defaultResultsDistribution;
    }

    public void setDefaultResultsDistribution(boolean defaultResultsDistribution) {
        this.defaultResultsDistribution = defaultResultsDistribution;
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

    public Object getNumberOfSamplesCancelled() {
        return numberOfSamplesCancelled;
    }

    public void setNumberOfSamplesCancelled(Object numberOfSamplesCancelled) {
        this.numberOfSamplesCancelled = numberOfSamplesCancelled;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBirthDateEstimated() {
        return birthDateEstimated;
    }

    public void setBirthDateEstimated(boolean birthDateEstimated) {
        this.birthDateEstimated = birthDateEstimated;
    }

    public Object getInvoiceToInsuranceCompany() {
        return invoiceToInsuranceCompany;
    }

    public void setInvoiceToInsuranceCompany(Object invoiceToInsuranceCompany) {
        this.invoiceToInsuranceCompany = invoiceToInsuranceCompany;
    }

    public ObjectWorkflowStates getObjectWorkflowStates() {
        return objectWorkflowStates;
    }

    public void setObjectWorkflowStates(ObjectWorkflowStates objectWorkflowStates) {
        this.objectWorkflowStates = objectWorkflowStates;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Object getBusinessFax() {
        return businessFax;
    }

    public void setBusinessFax(Object businessFax) {
        this.businessFax = businessFax;
    }

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }

    public Object getPrimaryReferrerID() {
        return primaryReferrerID;
    }

    public void setPrimaryReferrerID(Object primaryReferrerID) {
        this.primaryReferrerID = primaryReferrerID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getGuarantorSurname() {
        return guarantorSurname;
    }

    public void setGuarantorSurname(Object guarantorSurname) {
        this.guarantorSurname = guarantorSurname;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = age;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public Object getImmunizationHistory() {
        return immunizationHistory;
    }

    public void setImmunizationHistory(Object immunizationHistory) {
        this.immunizationHistory = immunizationHistory;
    }

    public Object getPatientIdentifiers() {
        return patientIdentifiers;
    }

    public void setPatientIdentifiers(Object patientIdentifiers) {
        this.patientIdentifiers = patientIdentifiers;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Object getAllowResultsDistribution() {
        return allowResultsDistribution;
    }

    public void setAllowResultsDistribution(Object allowResultsDistribution) {
        this.allowResultsDistribution = allowResultsDistribution;
    }

    public Object getRights() {
        return rights;
    }

    public void setRights(Object rights) {
        this.rights = rights;
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

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public Object getFathersName() {
        return fathersName;
    }

    public void setFathersName(Object fathersName) {
        this.fathersName = fathersName;
    }

    public Object getPrimaryReferrerURL() {
        return primaryReferrerURL;
    }

    public void setPrimaryReferrerURL(Object primaryReferrerURL) {
        this.primaryReferrerURL = primaryReferrerURL;
    }

    public Object getNumberOfSamplesPublished() {
        return numberOfSamplesPublished;
    }

    public void setNumberOfSamplesPublished(Object numberOfSamplesPublished) {
        this.numberOfSamplesPublished = numberOfSamplesPublished;
    }

    public Object getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Object homePhone) {
        this.homePhone = homePhone;
    }

    public Object getSalutation() {
        return salutation;
    }

    public void setSalutation(Object salutation) {
        this.salutation = salutation;
    }

    public List<String> getCreators() {
        return creators;
    }

    public void setCreators(List<String> creators) {
        this.creators = creators;
    }

    public Address getGuarantorPostalAddress() {
        return guarantorPostalAddress;
    }

    public void setGuarantorPostalAddress(Address guarantorPostalAddress) {
        this.guarantorPostalAddress = guarantorPostalAddress;
    }

    public Object getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(Object insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    }