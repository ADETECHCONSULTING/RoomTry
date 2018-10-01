package traore.adama.roomtry;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edtUsername)
    EditText edtUsername;
    @BindView(R.id.btnSave)
    Button btnPlay;
    @BindView(R.id.btnScores)
    Button btnScores;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
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
            }
        }).start();

    }

    public void onPressClick(View view){
        score++;
    }
}
