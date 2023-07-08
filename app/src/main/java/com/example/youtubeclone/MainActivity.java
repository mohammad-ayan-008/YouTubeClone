package com.example.youtubeclone;

import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;
import android.view.Menu;
import android.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ModelsandRecyclerView.VideoAdapter;
import com.example.Retrofitints.ApiCall;
import com.example.Retrofitints.ApiRequest;
import com.example.Retrofitints.ITM;
import com.example.Retrofitints.Model;
import com.example.youtubeclone.databinding.ActivityMainBinding;
import com.itsaky.androidide.logsender.LogSender;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
	private ActivityMainBinding binding;
    public List<ITM> list= new ArrayList<>();
    public VideoAdapter adapter;
    private RecyclerView rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		// Remove this line if you don't want AndroidIDE to show this app's logs
		LogSender.startLogging(this);
        super.onCreate(savedInstanceState);
        // Inflate and get instance of binding
		binding = ActivityMainBinding.inflate(getLayoutInflater());
        rec =binding.Rec;
        rec.setLayoutManager(new LinearLayoutManager(this));
        // adapter = new VideoAdapter(MainActivity.this,list);
        // set content view to binding's root
        setContentView(binding.getRoot());
        API("Trending");
        
    }
     @Override 
        public boolean onCreateOptionsMenu(Menu arg0) {
            getMenuInflater().inflate(R.menu.searches,arg0);
            // TODO: Implement this metho
            SearchView  v=(SearchView) arg0.findItem(R.id.menu_item1).getActionView();
            v.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
           public boolean onQueryTextSubmit(String arg0) {
            API(arg0);
             return true;
           }
                                                                             @Override
           public boolean onQueryTextChange(String arg0) {
                    return false;
           }
                                                                             
        });
            
            return true;
        }
    @Override
        public boolean onOptionsItemSelected(MenuItem arg0) {
            // TODO: Implement this method
            return super.onOptionsItemSelected(arg0);
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
                   adapter = new VideoAdapter(MainActivity.this,list);
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
