package com.builderjstudio.firebasetest1;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnGo =findViewById(R.id.btnGo);
        EditText txtNickName=findViewById(R.id.txtNickname);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db =FirebaseDatabase.getInstance().getReference("Messages");
                Log.v("print",db.getParent().toString());

                db.child("test1").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Log.v("print", snapshot.getValue(String.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

    }
}


//Toast.makeText(MainActivity.this,root.child("janith").getKey() , Toast.LENGTH_SHORT).show();


//                if (!nickname.isEmpty()){
//
//                    Log.v("firebase","ds");
//                    root.setValue(nickname).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            Toast.makeText(MainActivity.this, "Created a Acount", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }else{
//                    Toast.makeText(MainActivity.this, "Please Input a Name!", Toast.LENGTH_SHORT).show();
//                }