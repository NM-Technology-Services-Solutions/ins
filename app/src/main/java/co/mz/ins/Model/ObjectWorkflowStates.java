package co.mz.ins.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectWorkflowStates {

    @SerializedName("review_state")
    @Expose
    private String reviewState;

    public String getReviewState() {
        return reviewState;
    }

    public void setReviewState(String reviewState) {
        this.reviewState = reviewState;
    }

}