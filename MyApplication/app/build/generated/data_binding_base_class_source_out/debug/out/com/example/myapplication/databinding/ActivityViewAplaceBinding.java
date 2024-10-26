// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityViewAplaceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView14;

  @NonNull
  public final TextView tvCity;

  @NonNull
  public final TextView tvDes;

  @NonNull
  public final TextView tvName;

  private ActivityViewAplaceBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull TextView textView12,
      @NonNull TextView textView14, @NonNull TextView tvCity, @NonNull TextView tvDes,
      @NonNull TextView tvName) {
    this.rootView = rootView;
    this.imageView6 = imageView6;
    this.imageView7 = imageView7;
    this.textView12 = textView12;
    this.textView14 = textView14;
    this.tvCity = tvCity;
    this.tvDes = tvDes;
    this.tvName = tvName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityViewAplaceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityViewAplaceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_view_aplace, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityViewAplaceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView6;
      ImageView imageView6 = ViewBindings.findChildViewById(rootView, id);
      if (imageView6 == null) {
        break missingId;
      }

      id = R.id.imageView7;
      ImageView imageView7 = ViewBindings.findChildViewById(rootView, id);
      if (imageView7 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView14;
      TextView textView14 = ViewBindings.findChildViewById(rootView, id);
      if (textView14 == null) {
        break missingId;
      }

      id = R.id.tvCity;
      TextView tvCity = ViewBindings.findChildViewById(rootView, id);
      if (tvCity == null) {
        break missingId;
      }

      id = R.id.tvDes;
      TextView tvDes = ViewBindings.findChildViewById(rootView, id);
      if (tvDes == null) {
        break missingId;
      }

      id = R.id.tvName;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      return new ActivityViewAplaceBinding((ConstraintLayout) rootView, imageView6, imageView7,
          textView12, textView14, tvCity, tvDes, tvName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}