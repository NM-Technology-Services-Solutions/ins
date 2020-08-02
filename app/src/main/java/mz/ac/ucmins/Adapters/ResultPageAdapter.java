package mz.ac.ucmins.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import mz.ac.ucmins.views.DesponivelFragment;
import mz.ac.ucmins.views.PendenteFragment;

public class ResultPageAdapter extends FragmentStateAdapter {

    public ResultPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return  new PendenteFragment();
            default:
                return new DesponivelFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
