package mz.ac.ucmins.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mz.ac.ucmins.Model.ItemResult;

public class FirebaseClient {

    public final FirebaseFirestore db;
    public OnCustomObjectListener onCustomObjectListener;


    private static final String TAG = "DocSnippets";
    public FirebaseClient() {
        this.db = FirebaseFirestore.getInstance();
    }

    public void setDocument(Object obj) {
        // [START set_document]
        Map<String, Object> contacts = new HashMap<>();
        contacts.put("cont", obj);

        db.collection("contacts").document("contacts")
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

       /* Map<String, Object> data = new HashMap<>();

        // [START set_with_id]
        db.collection("cities").document("new-city-id").set(data);
        // [END set_with_id]*/
    }

    public void customObjects(final OnCustomObjectListener onCustomObjectListener) {
        // [START custom_objects]
        DocumentReference docRef = db.collection("contacts").document("contacts");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Map<String, Object> itemResultList = documentSnapshot.getData();//toObject(ResultDocument.class).itemResultList;
                Log.d(TAG, "We got documents to show ");
                Log.d(TAG, "We got it: " + itemResultList.get("cont"));
                ArrayList<Map<String, Object>> arl = (ArrayList<Map<String, Object>>) documentSnapshot.get("cont");
                List<ItemResult> itemResults = new ArrayList<>();//documentSnapshot.toObject(ResultDocument.class).cont;

                for (Map<String, Object> m : arl) {
                    ItemResult iR = new ItemResult();
                    iR.setName((String) m.get("name"));
                    iR.setPhone((String) m.get("phone"));
                    itemResults.add(iR);
                }

                Log.d(TAG, "Still problems: " + arl.get(1));
                onCustomObjectListener.onCustomObject((itemResults));

            }
        });
        // [END custom_objects]

     /*   FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        CollectionReference applicationsRef = db.collection("contacts");
        DocumentReference applicationIdRef = applicationsRef.document("contacts");
        applicationIdRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    List<Map<String, Object>> users = (List<Map<String, Object>>) document.get("cont");
                }
            }
        });*/
    }


    public interface OnCustomObjectListener {
        void onCustomObject(List<ItemResult> itemResult);

    }

    class ResultDocument {
        public List<ItemResult> cont;

        public ResultDocument() {
        }
    }


}
