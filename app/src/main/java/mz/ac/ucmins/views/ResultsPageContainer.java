package mz.ac.ucmins.views;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import mz.ac.ucmins.Adapters.ResultPageAdapter;
import co.mz.ucmins.R;

public class ResultsPageContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page_container);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new ResultPageAdapter(this));
        TabLayout tabLayout = findViewById(R.id.tablayout);
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
}