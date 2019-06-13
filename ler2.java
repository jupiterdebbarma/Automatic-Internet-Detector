package bwkha.jupiter.retailkart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class ler2 extends AppCompatActivity {
    Connection_Detector connection_detector;
    ProgressBar pb;
    int counter= 0;

private int SLEEP_TIMER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ler2);
        connection_detector=new Connection_Detector(this);

        if(connection_detector.isConnected())
        {
            Toast.makeText(this,"Welcome To The Retailkart World", Toast.LENGTH_LONG).show();
        } else
        {
            Toast.makeText(this,"Please Connect To The Internet!", Toast.LENGTH_LONG).show();
        }
       getActionBar();
        LogoLauncher logoLauncher = new LogoLauncher();
      logoLauncher.start();
        prog();

    }
    private class LogoLauncher extends Thread{
        public void run(){
            try {
                sleep(1000 * SLEEP_TIMER);
            }catch(InterruptedException e){
                e.printStackTrace();

            }
            Intent intent = new Intent(ler2.this,MainActivity.class);
            startActivity(intent);
            ler2.this.finish();
        }



    }
    public void prog()
    {
        pb=(ProgressBar)findViewById(R.id.pb);
       final Timer t = new Timer();
        TimerTask tt= new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);

                if(counter==100)
                    t.cancel();

            }
        };
        t.schedule(tt,0,100);

    }

}
