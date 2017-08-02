package com.example.frank.apprealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtAge;
    Button btnSave;
    Realm myRealm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRealm = Realm.getDefaultInstance();

        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText)findViewById(R.id.edtAge);
        btnSave = (Button)findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        User myUser = myRealm.createObject(User.class);
                        myUser.setUserName(edtName.getText().toString());
                        myUser.setUserAge(Integer.valueOf(edtAge.getText().toString()));
                    }
                });

            }
        });
    }
}
