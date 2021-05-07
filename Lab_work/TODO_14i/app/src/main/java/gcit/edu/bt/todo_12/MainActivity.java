package gcit.edu.bt.todo_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    String phone = "111-111-1111";
    TextView donut, kitkat, cake;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        donut = findViewById (R.id.tv2);
        kitkat = findViewById (R.id.tv3);
        cake = findViewById (R.id.tv4);
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message,
           Toast.LENGTH_SHORT).show();
    }
    public void donut(View view) {
        message=getString(R.string.message);
        displayToast(getString(R.string.message));
        donut.setVisibility(view.VISIBLE);
    }

    public void kitkat(View view) {
        message=getString(R.string.message2);
        displayToast(getString(R.string.message2));
        kitkat.setVisibility(view.VISIBLE);
    }

    public void cake(View view) {
        message=getString(R.string.message3);
        displayToast(getString(R.string.message3));
        cake.setVisibility(view.VISIBLE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater ().inflate (R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.order:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra (message, message);
                startActivity(intent);
                return true;
            case R.id.favorite:
                displayToast ("You have selected Fav");
                return true;
            case R.id.contact:
                displayToast ("You have selected cont");
                return true;
            case R.id.status:
                displayToast ("you have selected stat");
                return true;
            case R.id.info:
                displayToast ("What information do you want?");
                return true;
            case R.id.fav:
                displayToast ("What do you want to buy?");
                return true;
        }
        return false;
    }

    public void next(View view) {
        Intent obj=new Intent (this, MainActivity2.class);
        obj.putExtra ("message",message);
        startActivity (obj);
    }
}