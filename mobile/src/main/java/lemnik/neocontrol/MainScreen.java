package lemnik.neocontrol;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fabPlus = (FloatingActionButton) findViewById(R.id.fabPlus);
        fabPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar pbBlaas = (ProgressBar) findViewById(R.id.pbBlaas) ;
                pbBlaas.incrementProgressBy(20);
            }
        });
        FloatingActionButton fabMinus = (FloatingActionButton) findViewById(R.id.fabMinus);
        fabMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar pbBlaas = (ProgressBar) findViewById(R.id.pbBlaas) ;
                pbBlaas.incrementProgressBy(-50);
            }
        });
        new CountDownTimer(8000000, 1000) {

            public void onTick(long millisUntilFinished) {
                TextView tvRemaining = (TextView) findViewById(R.id.tvRemaining);
                long iHour = millisUntilFinished / 3600000;
                long iMinute = (millisUntilFinished - iHour * 3600000) / 60000;
                long iSecond = (millisUntilFinished - (iHour * 3600000 + iMinute * 60000)) / 1000;

                tvRemaining.setText(String.format("%02d:%02d:%02d", iHour, iMinute, iSecond));
            }

            public void onFinish() {
                TextView tvRemaining = (TextView) findViewById(R.id.tvRemaining);
                tvRemaining.setText("Leeg Blaas!");
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
