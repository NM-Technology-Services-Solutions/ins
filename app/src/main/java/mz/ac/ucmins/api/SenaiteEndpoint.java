package mz.ac.ucmins.api;

import java.util.List;

import io.grpc.internal.JsonUtil;
import mz.ac.ucmins.Model.Analysis;
import mz.ac.ucmins.Model.AnalysisList;
import mz.ac.ucmins.Model.AnalysisRequestList;
import mz.ac.ucmins.Model.LoginResponse;
import mz.ac.ucmins.Model.Patient;
import mz.ac.ucmins.Model.PatientList;
import mz.ac.ucmins.Model.User;
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

    //limit=5&b_start=0"
    @POST("users/new")
    Call<User> createUser(@Body User user);

    // @GET("analysisrequest/")
    //  Call<AnalysisResquest> getAnalysisServices();


    @GET("analysisrequest?complete=True")
    Call<AnalysisRequestList> getAnalysisRequestList(@Query("id") String code);

    @GET("analysisrequest?complete=True")
    Call<AnalysisRequestList> getAnalysisRequestList();

    @GET("analysisrequest?complete=True")
    Call<AnalysisRequestList> getAnalysisRequestList(@Query("limit") int limit, @Query("b_start") int start);

    //@GET("analysisservice/{analysisrequest}")
    // Call<AnalysisService> getAnalysisRequest(@Path("analysisservice") String analysisservice);
    @GET("analysis/{uid}")
    Call<AnalysisList> getAnalysis(@Path("uid") String uid);

    @GET("doctor/{uid}")
    Call<Patient> getDoctor(@Path("uid") String uid);

    @GET("patient/{uid}")
    Call<PatientList> getPatient(@Path("uid") String uid);

    @GET("patient?complete=True")
    Call<PatientList> getPatients();

    @GET("login")
    Call<LoginResponse> login(@Query("__ac_name") String username, @Query("__ac_password") String password);


    @GET("users/current")
    Call<LoginResponse> getCurrentUser();

}
