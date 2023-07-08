package com.example.ModelsandRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.ModelsandRecyclerView.VideoAdapter;
import com.example.Retrofitints.ITM;
import com.example.youtubeclone.databinding.LayoutScrolllsBinding;
import com.example.youtubeclone.databinding.VideoViewBinding;
import com.example.youtubeclone.playvideo;
import java.util.List;

public class RecyclerScrolls extends RecyclerView.Adapter<RecyclerScrolls.Holder> {
    public Context context;
    public List<ITM> list;
    public WebView displayYoutubeVideo;
    public TextView l;
    public RecyclerScrolls(Context context, List<ITM> list,WebView v,TextView l) {
        this.context = context;
        this.list = list;
        this.displayYoutubeVideo=v;
        this.l=l;
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LayoutScrolllsBinding binding;

        Holder(LayoutScrolllsBinding bind) {
            super(bind.getRoot());
            binding = bind;
            bind.coordinator.setOnClickListener(this);
        }

        @Override
        public void onClick(View arg0) {
            String frameVideo = "<!DOCTYPE html><html><body style='background: #121212;'><iframe  src='https://www.youtube.com/embed/"+list.get(getAdapterPosition()).getId().getVideoId()+"' ?&theme=dark&autohide=2&modestbranding=1&showinfo=0&autoplay=1\fs=0\" frameborder=\"0\" width='100%' height='200px' style='border: none;'></iframe> </body></html>";
            l.setText(list.get(getAdapterPosition()).getSnippet().getTitle());
            String url=Base64.encodeToString(frameVideo.getBytes(),Base64.NO_PADDING);
            displayYoutubeVideo.setWebChromeClient(new WebChromeClient());
            WebSettings webSetting = displayYoutubeVideo.getSettings();
            webSetting.setJavaScriptEnabled(true);
            displayYoutubeVideo.loadData(url, "text/html", "base64");
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup arg0, int arg1) {
        return new RecyclerScrolls.Holder(
                LayoutScrolllsBinding.inflate(LayoutInflater.from(context), arg0, false));
    }

    @Override
    public void onBindViewHolder(Holder arg0, int arg1) {
        ITM m = list.get(arg1);
       // arg0.binding.Desc.setText(m.getSnippet().description);
        arg0.binding.Title.setText(m.getSnippet().getTitle());
        Glide.with(context)
                .load(m.getSnippet().getThumbnails().getEfault().getUrl())
                .into(arg0.binding.ImageViewsec);
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
