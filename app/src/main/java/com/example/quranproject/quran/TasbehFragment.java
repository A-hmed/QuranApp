package com.example.quranproject.quran;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quranproject.Base.BaseFragment;
import com.example.quranproject.R;
import com.example.quranproject.quran.API.Model.AzkarItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class TasbehFragment extends BaseFragment implements AdapterView.OnItemSelectedListener {
    ImageView tasbihImage;
    Button refreshButton;
    TextView totalTasbehNumber;
    TextView tasbehNumber;
    Spinner spinner;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Integer normalTasbehCounter = 0;
    Integer totalTasbehCounter = 0;
    String docId = "";

    public TasbehFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasbeh, container, false);
        tasbihImage = view.findViewById(R.id.tasbih);
        refreshButton = view.findViewById(R.id.btn_refresh);
        totalTasbehNumber = view.findViewById(R.id.totalTasbehNumber);
        tasbehNumber = view.findViewById(R.id.tasbehNumber);
        spinner = view.findViewById(R.id.tasbehSpinner);
        spinner.setOnItemSelectedListener(this);
        fetchTotalTasbehListner();
        tasbihImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalTasbehCounter++;
                totalTasbehCounter++;
                tasbehNumber.setText(normalTasbehCounter.toString());
                totalTasbehNumber.setText(totalTasbehCounter.toString());
                saveCounter();
            }
        });


        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalTasbehCounter = 0;
                totalTasbehCounter = 0;
                tasbehNumber.setText(normalTasbehCounter.toString());
                totalTasbehNumber.setText(totalTasbehCounter.toString());
                saveCounter();
            }
        });


        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        saveCounter();
        Log.e("e", "fe el onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        saveCounter();
        Log.e("e", "fe el onDestroy");
    }

    public void saveCounter() {
        DocumentReference washingtonRef = db.collection("Tasbeh").document(docId);

        washingtonRef
                .update("totalTasbeh", totalTasbehCounter)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.e("e", "DocumentSnapshot successfully updated!");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("e", "Error updating document", e);
                    }
                });
    }

    public void fetchTotalTasbehListner() {
        db.collection("Tasbeh")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.e("success", document.getId() + " => " + document.getData());
                                String email = document.getData().values().toArray()[1].toString();
                                Log.e("e", "el email is " + email);
                                Log.e("e", "el user is " + DataHolder.userName);
                                if (DataHolder.userName.equals(email)) {
                                    Log.e("e", "da5l fe el if bta3t el set");
                                    totalTasbehCounter = Integer.parseInt(document.getData().values().toArray()[0].toString());
                                    docId = document.getId();
                                    totalTasbehNumber.setText(totalTasbehCounter.toString());
                                }
                                Log.e("e", "totalTasbehCounter is " + totalTasbehCounter);
                                //Log.e("e","title is "+ title);

                            }
                        } else {
                            Log.e("fail", "Error getting documents.", task.getException());
                        }
                        hideProgressBar();
                    }
                });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        normalTasbehCounter = 0;
        tasbehNumber.setText(normalTasbehCounter.toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
