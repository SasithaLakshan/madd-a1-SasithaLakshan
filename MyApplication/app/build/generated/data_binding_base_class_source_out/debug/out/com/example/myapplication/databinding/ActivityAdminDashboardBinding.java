// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityAdminDashboardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnEvents;

  @NonNull
  public final Button btnHotels;

  @NonNull
  public final Button btnLogout;

  @NonNull
  public final Button btnPlaces;

  @NonNull
  public final ImageView imageView10;

  @NonNull
  public final ImageView imageView9;

  @NonNull
  public final TextView textView29;

  private ActivityAdminDashboardBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnEvents, @NonNull Button btnHotels, @NonNull Button btnLogout,
      @NonNull Button btnPlaces, @NonNull ImageView imageView10, @NonNull ImageView imageView9,
      @NonNull TextView textView29) {
    this.rootView = rootView;
    this.btnEvents = btnEvents;
    this.btnHotels = btnHotels;
    this.btnLogout = btnLogout;
    this.btnPlaces = btnPlaces;
    this.imageView10 = imageView10;
    this.imageView9 = imageView9;
    this.textView29 = textView29;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnEvents;
      Button btnEvents = ViewBindings.findChildViewById(rootView, id);
      if (btnEvents == null) {
        break missingId;
      }

      id = R.id.btnHotels;
      Button btnHotels = ViewBindings.findChildViewById(rootView, id);
      if (btnHotels == null) {
        break missingId;
      }

      id = R.id.btnLogout;
      Button btnLogout = ViewBindings.findChildViewById(rootView, id);
      if (btnLogout == null) {
        break missingId;
      }

      id = R.id.btnPlaces;
      Button btnPlaces = ViewBindings.findChildViewById(rootView, id);
      if (btnPlaces == null) {
        break missingId;
      }

      id = R.id.imageView10;
      ImageView imageView10 = ViewBindings.findChildViewById(rootView, id);
      if (imageView10 == null) {
        break missingId;
      }

      id = R.id.imageView9;
      ImageView imageView9 = ViewBindings.findChildViewById(rootView, id);
      if (imageView9 == null) {
        break missingId;
      }

      id = R.id.textView29;
      TextView textView29 = ViewBindings.findChildViewById(rootView, id);
      if (textView29 == null) {
        break missingId;
      }

      return new ActivityAdminDashboardBinding((ConstraintLayout) rootView, btnEvents, btnHotels,
          btnLogout, btnPlaces, imageView10, imageView9, textView29);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
