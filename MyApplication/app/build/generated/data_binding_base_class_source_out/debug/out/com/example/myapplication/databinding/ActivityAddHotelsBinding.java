// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivityAddHotelsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnAdd;

  @NonNull
  public final EditText etDescription;

  @NonNull
  public final EditText etLocation;

  @NonNull
  public final EditText etName;

  @NonNull
  public final ImageView imageView8;

  @NonNull
  public final TextView textView30;

  @NonNull
  public final TextView textView32;

  @NonNull
  public final TextView textView36;

  @NonNull
  public final TextView textView37;

  private ActivityAddHotelsBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnAdd,
      @NonNull EditText etDescription, @NonNull EditText etLocation, @NonNull EditText etName,
      @NonNull ImageView imageView8, @NonNull TextView textView30, @NonNull TextView textView32,
      @NonNull TextView textView36, @NonNull TextView textView37) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.etDescription = etDescription;
    this.etLocation = etLocation;
    this.etName = etName;
    this.imageView8 = imageView8;
    this.textView30 = textView30;
    this.textView32 = textView32;
    this.textView36 = textView36;
    this.textView37 = textView37;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddHotelsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddHotelsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_hotels, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddHotelsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAdd;
      Button btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.etDescription;
      EditText etDescription = ViewBindings.findChildViewById(rootView, id);
      if (etDescription == null) {
        break missingId;
      }

      id = R.id.etLocation;
      EditText etLocation = ViewBindings.findChildViewById(rootView, id);
      if (etLocation == null) {
        break missingId;
      }

      id = R.id.etName;
      EditText etName = ViewBindings.findChildViewById(rootView, id);
      if (etName == null) {
        break missingId;
      }

      id = R.id.imageView8;
      ImageView imageView8 = ViewBindings.findChildViewById(rootView, id);
      if (imageView8 == null) {
        break missingId;
      }

      id = R.id.textView30;
      TextView textView30 = ViewBindings.findChildViewById(rootView, id);
      if (textView30 == null) {
        break missingId;
      }

      id = R.id.textView32;
      TextView textView32 = ViewBindings.findChildViewById(rootView, id);
      if (textView32 == null) {
        break missingId;
      }

      id = R.id.textView36;
      TextView textView36 = ViewBindings.findChildViewById(rootView, id);
      if (textView36 == null) {
        break missingId;
      }

      id = R.id.textView37;
      TextView textView37 = ViewBindings.findChildViewById(rootView, id);
      if (textView37 == null) {
        break missingId;
      }

      return new ActivityAddHotelsBinding((ConstraintLayout) rootView, btnAdd, etDescription,
          etLocation, etName, imageView8, textView30, textView32, textView36, textView37);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}