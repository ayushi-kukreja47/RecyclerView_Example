package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContacts= new ArrayList<>();
RecyclerView recyclerView;
FloatingActionButton btnOpenDialog;
RecyclerContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerContact);
        btnOpenDialog=findViewById(R.id.btnOpenDialog);


        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName=dialog.findViewById(R.id.edtName);
                EditText edtNumber=dialog.findViewById(R.id.edtNumber);
                Button btnAction=dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",number="";
                        if(!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        }else{
                            Toast.makeText(MainActivity.this, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }

                        if(!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        }else{
                            Toast.makeText(MainActivity.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new ContactModel(name, number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.boy1,"A","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy2,"B","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.girl1,"C","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.girl2,"D","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy2,"E","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"F","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"G","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy2,"H","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.girl2,"I","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.girl1,"J","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"K","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"L","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"M","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"N","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"O","2146793492"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"P","2146793492"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        
        adapter= new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);

    }
}