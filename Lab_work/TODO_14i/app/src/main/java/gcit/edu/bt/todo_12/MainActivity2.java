package gcit.edu.bt.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);

        Intent obj = getIntent();
        String message = obj.getStringExtra("message");
        tv1 = findViewById (R.id.textView6);
        tv1.setText (message);

        Spinner spinnerB = findViewById (R.id.spinner);
        if(spinnerB != null)
        {
            spinnerB.setOnItemSelectedListener (this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource (this,R.array.spinner,android.R.layout.simple_spinner_dropdown_item);
        if(spinnerB !=null)
        {
            spinnerB.setAdapter (adapter);
        }
    }

    public void YourOption(View view) {
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId())
        {
            case R.id.radioButton:
            {
                if(checked)
                {
                    displayToast(getString(R.string.sameDay));
                }
            }
            break;
            case R.id.radioButton2:
            {
                if(checked)
                {
                    displayToast(getString(R.string.nextDay));
                }
            }
            break;
            case R.id.radioButton3:
            {
                if(checked)
                {
                    displayToast(getString(R.string.pickUp));
                }
            }
        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show ();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLebal = parent.getItemAtPosition(position).toString ();
        displayToast (spinnerLebal);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}