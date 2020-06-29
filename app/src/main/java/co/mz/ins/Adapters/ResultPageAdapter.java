package co.mz.ins.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import co.mz.ins.DesponivelFragment;
import co.mz.ins.PendenteFragment;

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
