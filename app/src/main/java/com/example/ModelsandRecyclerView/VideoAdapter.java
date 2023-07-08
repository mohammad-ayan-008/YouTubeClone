package com.example.ModelsandRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.ModelsandRecyclerView.VideoAdapter;
import com.example.Retrofitints.ITM;
import com.example.youtubeclone.databinding.VideoViewBinding;
import com.example.youtubeclone.playvideo;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.Holder> {
    public Context context;
    public List<ITM> list;

    public VideoAdapter(Context context, List<ITM> list) {
        this.context = context;
        this.list = list;
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        VideoViewBinding binding;

        Holder(VideoViewBinding bind) {
            super(bind.getRoot());
            binding = bind;
            bind.coordinator.setOnClickListener(this);
        }

        @Override
        public void onClick(View arg0) {
            Intent move = new Intent(context, playvideo.class);
            move.putExtra("ID", list.get(getAdapterPosition()).getId().getVideoId());
            move.putExtra("Title", list.get(getAdapterPosition()).getSnippet().getTitle());
            move.putExtra("Desc", list.get(getAdapterPosition()).getSnippet().getDescription());

            context.startActivity(move);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup arg0, int arg1) {
        return new VideoAdapter.Holder(
                VideoViewBinding.inflate(LayoutInflater.from(context), arg0, false));
    }

    @Override
    public void onBindViewHolder(Holder arg0, int arg1) {
        ITM m = list.get(arg1);
        arg0.binding.Desc.setText(m.getSnippet().description);
        arg0.binding.Title.setText(m.getSnippet().getTitle());
        Glide.with(context)
                .load(m.getSnippet().getThumbnails().getEfault().getUrl())
                .into(arg0.binding.ImageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<ITM> getList() {
        return this.list;
    }

    public void setList(List<ITM> list) {
        this.list = list;
    }
}
