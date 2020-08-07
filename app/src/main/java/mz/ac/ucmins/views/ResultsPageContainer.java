package mz.ac.ucmins.views;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import mz.ac.ucmins.Adapters.ResultPageAdapter;
import co.mz.ucmins.R;

public class ResultsPageContainer extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    TabLayout tabLayout;
    private SharedPreferences preferences;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page_container);
        preferences = getApplicationContext().getSharedPreferences("LoginPref", MODE_PRIVATE);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new ResultPageAdapter(this));
        tabLayout = findViewById(R.id.tablayout);
        //useful to draw badges
        /*handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawBadge();
            }
        }, 6000);*/




        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

               switch (position){
                   case 0: {
                       tab.setText("Desponiveis");
                       tab.setIcon(R.drawable.ic_confirmed);
                       BadgeDrawable badgeDrawable= tab.getOrCreateBadge();
                       badgeDrawable.setBackgroundColor(ContextCompat.getColor(
                               getApplicationContext(), R.color.dark_blue
                       ));
                       badgeDrawable.setVisible(true);
                       badgeDrawable.setNumber(45);
                       break;
                   }
                   case 1: {
                       tab.setText("Pendentes");
                       tab.setIcon(R.drawable.ic_pending);
                       BadgeDrawable badgeDrawable= tab.getOrCreateBadge();
                       badgeDrawable.setBackgroundColor(ContextCompat.getColor(
                               getApplicationContext(), R.color.dark_blue
                       ));
                       badgeDrawable.setVisible(true);
                       badgeDrawable.setNumber(5);
                       break;
                   }

               }
            }

        });
        tabLayoutMediator.attach();


    }

    public void drawBadge() {
        int val1 = preferences.getInt("resultados_disponiveis",0);
        int val2 = preferences.getInt("resultados_pendentes",0);


        BadgeDrawable badgeDrawable= tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setBackgroundColor(ContextCompat.getColor(
                getApplicationContext(), R.color.dark_blue
        ));
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(val1);
        BadgeDrawable badgeDrawable1= tabLayout.getTabAt(1).getOrCreateBadge();
        badgeDrawable1.setBackgroundColor(ContextCompat.getColor(
                getApplicationContext(), R.color.dark_blue
        ));
        badgeDrawable1.setVisible(true);
        badgeDrawable1.setNumber(val2);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        int val=0;
        System.out.println("here 2"+preferences.getAll());
        if(s.equals("resultados_disponiveis")){

             val = sharedPreferences.getInt(s,0);

        }
        else if (s.equals("resultados_pendentes")){
            val=sharedPreferences.getInt(s,0);
        }
        BadgeDrawable badgeDrawable= tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getOrCreateBadge();
        badgeDrawable.setBackgroundColor(ContextCompat.getColor(
                getApplicationContext(), R.color.dark_blue
        ));
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(Integer.parseInt(s));

    }
}