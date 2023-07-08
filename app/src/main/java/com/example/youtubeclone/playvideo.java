package com.example.youtubeclone;

import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ModelsandRecyclerView.RecyclerScrolls;
import com.example.Retrofitints.ApiCall;
import com.example.Retrofitints.ITM;
import com.example.Retrofitints.Model;
import com.example.youtubeclone.databinding.LayoutVideoShowBinding;
import com.example.youtubeclone.playvideo;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class playvideo extends AppCompatActivity {
    public String videoId = "S0Q4gqBUs7c";
    private static  String link ="https://www.youtube.com/watch?v=";
    LayoutVideoShowBinding binding;
    public String Title,Desc="";
    public List<ITM> list= new ArrayList<>();
    public RecyclerView rec;
    public WebView displayYoutubeVideo;;
    public RecyclerScrolls adapter;
    @Override
        protected void onCreate(Bundle arg0) {
            super.onCreate(arg0);
            // TODO: Implement this method
            videoId=getIntent().getExtras().getString("ID");
            Title=getIntent().getExtras().getString("Title");
            Desc=getIntent().getExtras().getString("Desc");
            link = link+videoId;
            
            binding= LayoutVideoShowBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            binding.Title.setText(Title);
            rec =binding.recycing;
            rec.setLayoutManager(new LinearLayoutManager(this));
          
            String lin="http://www.youtube.com/v/"+videoId+"?version=3&amp;hl=pt_BR&amp;rel=0>";
            String frameVideo = "<!DOCTYPE html><html><body style='background: #121212;'><iframe  src='https://www.youtube.com/embed/"+videoId+"' ?&theme=dark&autohide=2&modestbranding=1&showinfo=0&autoplay=1\fs=0\" frameborder=\"0\" width='100%' height='200px' style='border: none;'></iframe> </body></html>";
            String url=Base64.encodeToString(frameVideo.getBytes(),Base64.NO_PADDING);
            displayYoutubeVideo = binding.videoView;
            displayYoutubeVideo.setWebChromeClient(new WebChromeClient());
            WebSettings webSetting = displayYoutubeVideo.getSettings();
            webSetting.setJavaScriptEnabled(true);
        //  displayYoutubeVideo.loadData(url,"text/html; charset=utf-8","base64");
            displayYoutubeVideo.loadData(url, "text/html", "base64");
            API(Title);
        }
    
    
   
       public String getHTML(String videoId) {
           String html = "<html><body><br><iframe class=\"youtube-player\" " + "style=\"border: 0; width: 100%; height: 96%;"
                         + "padding:0px; margin:0px\" " + "id=\"ytplayer\" type=\"text/html\" "
                         + "src=\"http://www.youtube.com/embed/" + videoId
                         + "?&theme=dark&autohide=2&modestbranding=1&showinfo=0&autoplay=1\fs=0\" frameborder=\"0\" "
                         + "allowfullscreen autobuffer " + "controls onclick=\"this.play()\">\n" + "</iframe>\n</body></html>";
           return html;
       }
    public void API(String Title){
         ApiCall.getInstance().getResponse("snippet",50,Title,"video","AIzaSyAbswan4jGXWuts9Sxfq10Yxr-0k5O3OvQ").enqueue(new Callback<Model>(){
            @Override
            public void onResponse(Call<Model> arg0, Response<Model> arg1) {
                if(arg1.body()!=null){
                   Model im=arg1.body();
                   if(list.size()>0) {
                       list.clear();
                   }   
                   list.addAll (im.getItems());
                   adapter = new RecyclerScrolls(playvideo.this,list,displayYoutubeVideo,binding.Title); 
                        
                   rec.setAdapter(adapter);
                   adapter.notifyDataSetChanged();                   
                   if(im.getItems()==null){
                       Toast.makeText(getApplicationContext(),"Null",0).show();
                            
                   }else{
                       
                       Toast.makeText(getApplicationContext(),"Done",0).show(); 
                   }
                 }
               }

           @Override
            public void onFailure(Call<Model> arg0, Throwable arg1) {
                    Toast.makeText(getApplicationContext(),arg1.getMessage().toString(),0).show();
            }
       });
    }
        
}
