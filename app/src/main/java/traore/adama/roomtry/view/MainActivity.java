package traore.adama.roomtry.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import traore.adama.roomtry.MyApplication;
import traore.adama.roomtry.R;
import traore.adama.roomtry.database.model.Game;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edtUsername) EditText edtUsername;
    @BindView(R.id.btnSave) Button btnPlay;
    @BindView(R.id.btnScores) Button btnScores;
    @BindView(R.id.lblScore) TextView lblScore;
    private int score;

    public static void Launch(Context context){
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        lblScore.setText(String.format(Locale.getDefault(), "%d", score));
    }

    @OnClick(R.id.btnSave) public void onBtnClicked(){
        final String name = edtUsername.getText().toString();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "ENTER A NAME", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                ((MyApplication)getApplication()).getDb().gameDao().insert(new Game(name, score));
                score = 0;
                edtUsername.setText("");
            }
        }).start();
    }

    @OnClick(R.id.btnScores)public void onBtnScoreClicked(){
        ScoreActivity.Launch(this);
    }

    public void onPressClick(View view){
        score++;
        lblScore.setText(String.format(Locale.getDefault(), "%d", score));
    }
}
