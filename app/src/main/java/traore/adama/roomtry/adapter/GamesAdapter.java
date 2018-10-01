package traore.adama.roomtry.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import traore.adama.roomtry.database.model.Game;
import traore.adama.roomtry.R;
import traore.adama.roomtry.view.ScoreActivity;

public class GamesAdapter extends RecyclerView.Adapter {
    private List<Game> games;
    private ScoreActivity activity;

    public GamesAdapter(ScoreActivity activity) {
        this.activity = activity;
    }

    public void resetData(List<Game> items){
        this.games = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_game, parent, false);
        return new GamesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Game game = games.get(position);
        GamesHolder gHolder = (GamesHolder)holder;

        gHolder.lblName.setText(game.getUserName());
        gHolder.lblScore.setText(String.format(Locale.getDefault(), "%d", game.getScore()));
    }

    @Override
    public int getItemCount() {
        return games != null ? games.size() : 0;
    }

    class GamesHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.lblName) TextView lblName;
        @BindView(R.id.lblScore) TextView lblScore;

        public GamesHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
