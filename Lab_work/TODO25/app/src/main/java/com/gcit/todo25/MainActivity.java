package com.gcit.todo25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText EditTextName,EditTextSurName,EditTextMarks,EditTexttstdid;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditTextName=findViewById(R.id.editTextUsername);
        EditTextSurName=findViewById(R.id.editTextSurname);
        EditTextMarks=findViewById(R.id.editTextMarks);
        EditTexttstdid=findViewById(R.id.editTextTextStdid);
        button=findViewById(R.id.buttonAdd);
        myDb = new DatabaseHelper(this);

        //button.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {


            //}
        //});

    //}

}

    public void add(View view) {
        boolean isInserted =myDb.insertData(EditTexttstdid.getText().toString(),
                EditTextName.getText().toString(),
                EditTextSurName.getText().toString(),
                EditTextMarks.getText().toString());
        if(isInserted==true){
            Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
        }
    }

    public void View(View view) {
        Cursor res= myDb.getAllData();
        if(res.getCount()==0){
            showMessage("Error","nothing is found");
            return;
        }
        StringBuffer buffer =new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Student Id:"+res.getString(0)+"\n");
            buffer.append("First Name:"+res.getString(1)+"\n");
            buffer.append("Last  Name:"+res.getString(2)+"\n");
            buffer.append("ITW2 marks:"+res.getString(3)+"\n");
        }
        showMessage("List of Students",buffer.toString());

    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void Update(View view) {
        boolean isUpdate =myDb.updateData(EditTexttstdid.getText().toString(),
                EditTextName.getText().toString(),
                EditTextSurName.getText().toString(),
                EditTextMarks.getText().toString());
        if(isUpdate==true){
            Toast.makeText(MainActivity.this,"Data is update",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Data not updateds",Toast.LENGTH_LONG).show();
        }

    }

    public void Delete(View view) {
        Integer isdelete =myDb.deleteData(EditTexttstdid.getText().toString(),
                EditTextName.getText().toString(),
                EditTextSurName.getText().toString(),
                EditTextMarks.getText().toString());
        if(isdelete > 0){
            Toast.makeText(MainActivity.this,"Data is Deleted",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
        }


    }
}
