package mz.ac.ucmins.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import co.mz.ucmins.R;
import mz.ac.ucmins.Model.Analysis;
import mz.ac.ucmins.Model.AnalysisList;
import mz.ac.ucmins.Model.ItemResult;

public class ResultsDetailsAdapter extends RecyclerView.Adapter<ResultsDetailsAdapter.ViewHolder> {

    private List<Analysis> localDataSet;

    public void addAll(List<Analysis> analysisList) {
        for (Analysis itemResult : analysisList) {
            add(itemResult);
        }
    }


    public void add(Analysis r) {
        localDataSet.add(r);
        notifyItemInserted(localDataSet.size() - 1);

    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private EditText enterValue;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.nomeanalysis);
            enterValue = view.findViewById(R.id.resultado_analise);
        }

        public TextView getTextView() {
            return textView;
        }
        public EditText getEnterValue() {
            return enterValue;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ResultsDetailsAdapter(List<Analysis> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.content_detail, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet.get(position).getTitle());
        viewHolder.getEnterValue().setText(localDataSet.get(position).getResult());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

