package com.piersonapps.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddToDatabase extends AppCompatActivity {

    Button add_button;
    Button read_button;

    TextView database_input;

    private DatabaseReference databaseReference;
    private String myKey;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_database);

        DAO dao = new DAO(FirebaseAuth.getInstance());




        add_button = findViewById(R.id.Add);
        read_button = findViewById(R.id.read);
        database_input = findViewById(R.id.firebase_input);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               TestList row = new TestList("list","column");
                dao.addRow(row);
            }
        });


      read_button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              // grab current database list
              dao.getDatabaseReference().get().addOnCompleteListener(task -> {

               String readInput = "";

                  task.getResult().getChildren().iterator();
                  for(DataSnapshot child: task.getResult().child(FirebaseAuth.getInstance().getUid()).getChildren()){
                      readInput = task.getResult().toString();

                  }



                  database_input.setText(readInput);

              });
          }
      });



    }
}