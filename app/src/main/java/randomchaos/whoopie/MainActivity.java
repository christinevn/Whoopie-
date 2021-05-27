package randomchaos.whoopie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.WidgetContainer;

import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import randomchaos.whoopie.R;

public class MainActivity extends AppCompatActivity {
    private SoundPool fartButtons;
    private  int airy_fart, cartoon_fart, cartoon_fart2, raspberry_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fartButtons = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);

        airy_fart = fartButtons.load(this, R.raw.airy_fart, 1);
        cartoon_fart = fartButtons.load(this, R.raw.cartoon_fart, 1);
        cartoon_fart2 = fartButtons.load(this, R.raw.cartoon_fart2, 1);
        raspberry_5 = fartButtons.load(this, R.raw.raspberry_5, 1);

    }
    boolean timerBtn = false;

    public void pickYourPoison(View view) {
        Toast.makeText(this, "Pick your sound and run!", Toast.LENGTH_SHORT).show();
        EditText vis = (EditText)findViewById(R.id.countdown);
        //vis.setVisibility(View.VISIBLE);
        timerBtn = true;
    }

    public void playSound(int soundID) {
        fartButtons.play(soundID, 1, 1, 0, 0, 1);
    }

    public void playSound(View view) throws InterruptedException {
        if (timerBtn) {
            switch (view.getId()) {
                case R.id.airy_fart:
                    Thread.sleep(20000);
                    playSound(airy_fart);
                    break;
                case R.id.cartoon_fart:
                    Thread.sleep(20000);
                    playSound(cartoon_fart);
                    break;
                case R.id.cartoon_fart2:
                    Thread.sleep(20000);
                    playSound(cartoon_fart2);
                    break;
                case R.id.raspberry_5:
                    Thread.sleep(20000);
                    playSound(raspberry_5);
                    break;
            }
        } else {
            switch (view.getId()) {
                case R.id.airy_fart:
                    playSound(airy_fart);
                    break;
                case R.id.cartoon_fart:
                    playSound(cartoon_fart);
                    break;
                case R.id.cartoon_fart2:
                    playSound(cartoon_fart2);
                    break;
                case R.id.raspberry_5:
                    playSound(raspberry_5);
                    break;
            }
        }
        timerBtn = false;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fartButtons.release();
        fartButtons = null;

    }

}