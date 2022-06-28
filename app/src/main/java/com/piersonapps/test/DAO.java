package com.piersonapps.test;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAO {

    private DatabaseReference databaseReference;
    private String myKey;
    private FirebaseAuth auth;

    public DAO(FirebaseAuth auth){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        this.auth = auth;
        databaseReference = db.getReference(TestList.class.getSimpleName());

    }

    public DatabaseReference getDatabaseReference(){
        return databaseReference;
    }

    public Task<Void> addRow(TestList row){

        myKey = databaseReference.child(auth.getUid()).child(row.getName()).push().getKey();
         row.setMyKey(myKey);

        return databaseReference.child(auth.getUid()).child(row.getName()).child(myKey).setValue(row);
    }

}
