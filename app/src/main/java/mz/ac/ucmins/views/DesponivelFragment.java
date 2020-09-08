package mz.ac.ucmins.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import co.mz.ucmins.R;
import mz.ac.ucmins.Adapters.RecylerViewAdapter;
import mz.ac.ucmins.Model.AnalysisRequestList;
import mz.ac.ucmins.Model.ItemResult;
import mz.ac.ucmins.api.ApiUtils;
import mz.ac.ucmins.api.SenaiteEndpoint;
import mz.ac.ucmins.api.SenaiteService;
import mz.ac.ucmins.api.sms.SMSAPI;
import mz.ac.ucmins.api.sms.SmsEndpoint;
import mz.ac.ucmins.firebase.FirebaseClient;

import static android.content.Context.MODE_PRIVATE;


public class DesponivelFragment extends Fragment implements RecylerViewAdapter.OnSelectedListener {
    private static final String TAG = ".DesponivelFragment";
    private static final int PAGE_START = 1;
    private static int TOTAL_PAGES = 5;
    public List<ItemResult> itemResultList;
    ProgressBar progressBar;
    SenaiteEndpoint senaiteEndpoint;
    AnalysisRequestList arl2;
    View v;
    private RecyclerView recyclerView;
    RecylerViewAdapter recylerViewAdapter;
    SenaiteService senaiteService;
    int b_startp = 0;
    public int elementcount;
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;
    int limitPerPage = 5;
    //ProgressBar progressBar;
    LinearLayout errorLayout;
    Button btnRetry;
    TextView txtError;
    SwipeRefreshLayout swipeRefreshLayout;
    FloatingActionButton fab;
    SMSAPI smsapi;
    SmsEndpoint smsEndpoint;
    LinearLayoutManager linearLayoutManager;
    Runnable runnable;
    Handler newHandler;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int currentPage = PAGE_START;
    private AnalysisRequestList analysisRequestList;

    public DesponivelFragment() {
        elementcount = 0;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_desponivel, container, false);
        progressBar = v.findViewById(R.id.main_progress);
        fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyLabManager(recylerViewAdapter.getmData());
            }
        });
        fab.setVisibility(View.GONE);

        return v;
    }

    private void notifyLabManager(List<ItemResult> getmData) {

        //smsEndpoint.sendSms(null);

        List<ItemResult> contacts = new ArrayList<>();

        for (ItemResult ir : getmData) {
            if (ir.isSelected()) {
                contacts.add(ir);
            }

        }
        FirebaseClient firebaseClient = new FirebaseClient();
        firebaseClient.setDocument(contacts);

    }

    @Override
    public void onResume() {
        super.onResume();
        senaiteEndpoint = ApiUtils.getSenaiteEndpoint(this.getContext());
        senaiteService = new SenaiteService(senaiteEndpoint);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arl2 = new AnalysisRequestList();
        senaiteEndpoint = ApiUtils.getSenaiteEndpoint(this.getContext());
        senaiteService = new SenaiteService(senaiteEndpoint);
        //smsapi = SMSAPI.getSenaiteEndpoint(this.getContext());
        smsEndpoint = SMSAPI.getSenaiteEndpoint(this.getContext());
        //smsapi = new Sm

        //itemResultList= doFillResults();
//        System.out.println("size" +itemResultList.size());
        preferences = this.getContext().getSharedPreferences("LoginPref", MODE_PRIVATE);
        editor = preferences.edit();

        ((ResultsPageContainer) getActivity()).drawBadge();


    }



/*
    private List<ItemResult> doFillResults() {
        Call<AnalysisRequestList> call = resultsAvailableService.getAnalysisRequestList();
        //System.out.println("Token: "+ token);
        itemResultList = new ArrayList<>();
        call.enqueue(new Callback<AnalysisRequestList>() {
            @Override
            public void onResponse(Call<AnalysisRequestList> call, Response<AnalysisRequestList> response) {
                int statusCode = response.code();
                System.out.println(statusCode);

                AnalysisRequestList arl = response.body();
                System.out.println(itemResultList.size());
                for(AnalysisResquest ar: arl.getItems()){
                    System.out.println(ar.getGetClientID());
                    itemResultList.add(new ItemResult(ar.getAuthor(),ar.getGetClientID().toString(), R.drawable.logotipo, false));
                    recylerViewAdapter.notifyDataSetChanged();

                }
                System.out.println("sizeeee "+itemResultList.size());
                String x= new Gson().toJson(response.body());
                String y= new Gson().toJson(response.headers());
                editor.putInt("resultados_disponiveis", itemResultList.size());
                editor.commit();

                System.out.println("here"+preferences.getAll());
                System.out.println(y);
                //res = ar.getItems();


            }
            @Override
            public void onFailure(Call<AnalysisRequestList> call, Throwable t) {
                t.printStackTrace();
            }

        });
        System.out.println("Result List Size"+itemResultList.size());
        return itemResultList;
    }
*/

    private void loadFirstPage() throws IOException {


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //Your code goes here
                    Log.d(TAG, "loadingFirstPage: ");


                    currentPage = 1;

                    progressBar.setVisibility(View.GONE);
                    AnalysisRequestList analysisRequestList = senaiteService.getResults(5, 0);
                    TOTAL_PAGES = analysisRequestList.getPages();
                    currentPage = analysisRequestList.getPage();
                    itemResultList = senaiteService.getSamplesAndPatients(analysisRequestList.getItems());
                    Log.d(TAG, "loadingFirstPage from: " + TOTAL_PAGES);
                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            // To ensure list is visible when retry button in error view is clicked
                            hideErrorView();

                            // Stuff that updates the UI

                            recylerViewAdapter.addAll(itemResultList);


                            if (currentPage <= TOTAL_PAGES) {
                                Log.d(TAG, "currentPage less or equal that total pages");
                                recylerViewAdapter.addLoadingFooter();
                            } else
                                isLastPage = true;

                        }
                    });


                } catch (final Exception e) {
                    e.printStackTrace();
                    //Add Show Connection Error

                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            // Stuff that updates the UI
                            showErrorView(e);

                        }
                    });


                }
            }
        });

        thread.start();


    }

    /**
     * @param throwable required for {@link #fetchErrorMessage(Throwable)}
     * @return
     */
    private void showErrorView(Throwable throwable) {

        if (errorLayout.getVisibility() == View.GONE) {
            errorLayout.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);

            txtError.setText(fetchErrorMessage(throwable));
        }
    }

    /**
     * @param throwable to identify the type of error
     * @return appropriate error message
     */
    private String fetchErrorMessage(Throwable throwable) {
        String errorMsg = getResources().getString(R.string.error_msg_unknown);

        if (!isNetworkConnected()) {
            errorMsg = getResources().getString(R.string.error_msg_unknown);
        } else if (throwable instanceof TimeoutException) {
            errorMsg = getResources().getString(R.string.error_msg_timeout);
        }

        return errorMsg;
    }

    /**
     * Remember to add android.permission.ACCESS_NETWORK_STATE permission.
     *
     * @return
     */
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private void hideErrorView() {
        if (errorLayout.getVisibility() == View.VISIBLE) {
            errorLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
    }


    private void loadNextPage() throws IOException {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Log.d(TAG, "loadingNextPage:" + currentPage);
                    recylerViewAdapter.removeLoadingFooter();
                    isLastPage = false;
                    b_startp = b_startp + limitPerPage;

                    analysisRequestList = senaiteService.getResults(limitPerPage, b_startp);
                    TOTAL_PAGES = analysisRequestList.getPages();
                    currentPage = analysisRequestList.getPage();
                    itemResultList = senaiteService.getSamplesAndPatients(analysisRequestList.getItems());

                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            // Stuff that updates the UI
                            recylerViewAdapter.addAll(itemResultList);


                            if (currentPage <= TOTAL_PAGES) recylerViewAdapter.addLoadingFooter();
                            else isLastPage = true;

                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();


    }

    /**
     * Triggers the actual background refresh via the {@link SwipeRefreshLayout}
     */
    private void doRefresh() throws IOException {
        progressBar.setVisibility(View.VISIBLE);
        if (senaiteEndpoint.getAnalysisRequestList().isExecuted())
            senaiteEndpoint.getAnalysisRequestList().cancel();

        // TODO: Check if data is stale.
        //  Execute network request if cache is expired; otherwise do not update data.
        recylerViewAdapter.getmData().clear();
        recylerViewAdapter.notifyDataSetChanged();
        loadFirstPage();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = v.findViewById(R.id.disponivel);


        registerForContextMenu(recyclerView);

        //AsyncApiCall = new AsyncApiCall();

        recylerViewAdapter = new RecylerViewAdapter(getContext(), (RecylerViewAdapter.OnSelectedListener) this);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recylerViewAdapter);
        progressBar = v.findViewById(R.id.main_progress);
        errorLayout = v.findViewById(R.id.error_layout);
        btnRetry = v.findViewById(R.id.error_btn_retry);
        txtError = v.findViewById(R.id.error_txt_cause);
        swipeRefreshLayout = v.findViewById(R.id.main_swiperefresh);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    loadFirstPage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    doRefresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        recyclerView.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() throws IOException {
                isLoading = true;
                currentPage += 1;

                loadNextPage();
            }

            @Override
            public int getTotalPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
        try {
            loadFirstPage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSelected(boolean selection) {
        toggleFab();
    }

    private void toggleFab() {
        Log.d(TAG, "Listening to selections" + recylerViewAdapter.getSelectedCount() + " items");
        if (recylerViewAdapter.getSelectedCount() > 0) {
            fab.setVisibility(View.VISIBLE);
        } else {
            fab.setVisibility(View.GONE);
        }

    }
}