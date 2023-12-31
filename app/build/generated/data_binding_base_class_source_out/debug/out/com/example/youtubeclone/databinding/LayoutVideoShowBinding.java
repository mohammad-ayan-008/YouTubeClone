// Generated by view binder compiler. Do not edit!
package com.example.youtubeclone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.youtubeclone.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutVideoShowBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView Title;

  @NonNull
  public final LinearLayout coordinator;

  @NonNull
  public final RecyclerView recycing;

  @NonNull
  public final WebView videoView;

  private LayoutVideoShowBinding(@NonNull LinearLayout rootView, @NonNull TextView Title,
      @NonNull LinearLayout coordinator, @NonNull RecyclerView recycing,
      @NonNull WebView videoView) {
    this.rootView = rootView;
    this.Title = Title;
    this.coordinator = coordinator;
    this.recycing = recycing;
    this.videoView = videoView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutVideoShowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutVideoShowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_video_show, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutVideoShowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Title;
      TextView Title = ViewBindings.findChildViewById(rootView, id);
      if (Title == null) {
        break missingId;
      }

      LinearLayout coordinator = (LinearLayout) rootView;

      id = R.id.recycing;
      RecyclerView recycing = ViewBindings.findChildViewById(rootView, id);
      if (recycing == null) {
        break missingId;
      }

      id = R.id.videoView;
      WebView videoView = ViewBindings.findChildViewById(rootView, id);
      if (videoView == null) {
        break missingId;
      }

      return new LayoutVideoShowBinding((LinearLayout) rootView, Title, coordinator, recycing,
          videoView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
