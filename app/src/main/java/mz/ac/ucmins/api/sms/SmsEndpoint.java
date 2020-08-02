package mz.ac.ucmins.api.sms;


import mz.ac.ucmins.Model.Analysis;
import mz.ac.ucmins.Model.LoginResponse;
import mz.ac.ucmins.Model.Patient;
import mz.ac.ucmins.Model.PatientList;
import mz.ac.ucmins.Model.sms.Contact;
import mz.ac.ucmins.Model.sms.GetContactsResponse;
import mz.ac.ucmins.Model.sms.GetSentMessageResponse;
import mz.ac.ucmins.Model.sms.Message;
import mz.ac.ucmins.Model.sms.SendSmsResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SmsEndpoint {


    @Headers({"Authorization: Token bbcb2e94fc3da9f82909caa37040aae6763cd659"})
    @POST("/api/v2/broadcasts.json")
    Call<SendSmsResponse> sendSms(@Body Message message);

    @Headers({"Authorization: Token bbcb2e94fc3da9f82909caa37040aae6763cd659"})
    @GET("/api/v2/broadcasts.json")
    Call<GetSentMessageResponse> getSentSms();

    @Headers({"Authorization: Token bbcb2e94fc3da9f82909caa37040aae6763cd659"})
    @POST("/api/v2/contacts.json")
    Call<Contact> addContact();

    @Headers({"Authorization: Token bbcb2e94fc3da9f82909caa37040aae6763cd659"})
    @GET("/api/v2/contacts.json")
    Call<GetContactsResponse> getContacts(@Body Contact c);

    Call<Analysis> getAnalysis(@Path("uid") String uid);
    @GET("doctor/{uid}")
    Call<Patient> getDoctor(@Path("uid") String uid);
    @GET("patient/{uid}")
    Call<PatientList> getPatient(@Path("uid") String uid);
    @GET("login")
    Call<LoginResponse> login (@Query("__ac_name") String username, @Query("__ac_password") String password);

}
