package traore.adama.roomtry.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import traore.adama.roomtry.MyApplication;
import traore.adama.roomtry.R;
import traore.adama.roomtry.adapter.GamesAdapter;

public class ScoreActivity extends AppCompatActivity {
    @BindView(R.id.rcvMain)
    RecyclerView rcvMain;
    private GamesAdapter adapter;



    public static void Launch(Context context){
        context.startActivity(new Intent(context, ScoreActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ButterKnife.bind(this);

        adapter = new GamesAdapter(this);
        rcvMain.setLayoutManager(new LinearLayoutManager(this));
        rcvMain.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Thread(new Runnable() {
            @Override
            public void run() {
                adapter.resetData(((MyApplication)getApplication()).getDb().gameDao().getAll());
            }
        }).start();
    }
}
