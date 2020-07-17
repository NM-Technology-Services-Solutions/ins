package co.mz.ins.api;

import java.util.List;

import co.mz.ins.Model.Analysis;
import co.mz.ins.Model.AnalysisRequestList;
import co.mz.ins.Model.AnalysisResquest;
import co.mz.ins.Model.LoginResponse;
import co.mz.ins.Model.Patient;
import co.mz.ins.Model.PatientList;
import co.mz.ins.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SenaiteEndpoint {

    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);


    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("users/new")
    Call<User> createUser(@Body User user);

   // @GET("analysisrequest/")
  //  Call<AnalysisResquest> getAnalysisServices();


    @GET("analysisrequest/{analysisrequest}")
    Call<AnalysisResquest> getAnalysisRequest(@Path("analysisrequest") String analysisresquest);

    @GET("analysisrequest")
    Call<AnalysisRequestList> getAnalysisRequestList();

    //@GET("analysisservice/{analysisrequest}")
   // Call<AnalysisService> getAnalysisRequest(@Path("analysisservice") String analysisservice);
    @GET("analysis/{uid}")
    Call<Analysis> getAnalysis(@Path("uid") String uid);
    @GET("doctor/{uid}")
    Call<Patient> getDoctor(@Path("uid") String uid);
    @GET("patient/{uid}")
    Call<PatientList> getPatient(@Path("uid") String uid);
    @GET("login")
    Call<LoginResponse> login (@Query("__ac_name") String username, @Query("__ac_password") String password);

}
