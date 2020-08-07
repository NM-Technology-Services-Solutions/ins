package mz.ac.ucmins.firebase;

import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class FirebaseClient {

    public final FirebaseFirestore db;


    private static final String TAG = "DocSnippets";
    public FirebaseClient() {
        this.db = FirebaseFirestore.getInstance();
    }

    public void setDocument(Object obj) {
        // [START set_document]
        Map<String, Object> contacts = new HashMap<>();
        contacts.put("cont", obj);

        db.collection("cities").document("LA")
                .set(contacts)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
        // [END set_document]

        Map<String, Object> data = new HashMap<>();

        // [START set_with_id]
        db.collection("cities").document("new-city-id").set(data);
        // [END set_with_id]
    }




}
