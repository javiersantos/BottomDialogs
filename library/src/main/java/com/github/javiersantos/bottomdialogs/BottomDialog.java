package com.github.javiersantos.bottomdialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.res.ResourcesCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomDialog {
    private Activity activity;
    private Context context;
    private boolean isCancelable;
    private CharSequence title, content;
    private Drawable icon;
    private CharSequence btn_negative, btn_positive;
    private ButtonCallback btn_negative_callback, btn_positive_callback;

    public BottomDialog(Context context) {
        this.activity = (Activity) context;
        this.context = context;
        this.isCancelable = true;
    }

    public BottomDialog setTitle(@StringRes int titleRes) {
        setTitle(this.context.getString(titleRes));
        return this;
    }

    public BottomDialog setTitle(@NonNull CharSequence title) {
        this.title = title;
        return this;
    }

    public BottomDialog setContent(@StringRes int contentRes) {
        setContent(this.context.getString(contentRes));
        return this;
    }

    public BottomDialog setContent(@NonNull CharSequence content) {
        this.content = content;
        return this;
    }

    public BottomDialog setIcon(@NonNull Drawable icon) {
        this.icon = icon;
        return this;
    }

    public BottomDialog setIcon(@DrawableRes int iconRes) {
        this.icon = ResourcesCompat.getDrawable(context.getResources(), iconRes, null);
        return this;
    }

    public BottomDialog setPositiveText(@StringRes int buttonTextRes) {
        setPositiveText(this.context.getString(buttonTextRes));
        return this;
    }

    public BottomDialog setPositiveText(@NonNull CharSequence buttonText) {
        this.btn_positive = buttonText;
        return this;
    }

    public BottomDialog onPositive(@NonNull ButtonCallback buttonCallback) {
        this.btn_positive_callback = buttonCallback;
        return this;
    }

    public BottomDialog setNegativeText(@StringRes int buttonTextRes) {
        setPositiveText(this.context.getString(buttonTextRes));
        return this;
    }

    public BottomDialog setNegativeText(@NonNull CharSequence buttonText) {
        this.btn_positive = buttonText;
        return this;
    }

    public BottomDialog onNegative(@NonNull ButtonCallback buttonCallback) {
        this.btn_negative_callback = buttonCallback;
        return this;
    }

    public BottomDialog setCancelable(boolean cancelable) {
        this.isCancelable = cancelable;
        return this;
    }

    public void show() {
        initStyle().show();
    }

    private Dialog initStyle() {
        final Dialog bottomDialog = new Dialog(activity, R.style.BottomDialogs);
        View view = activity.getLayoutInflater().inflate(R.layout.bottom_dialog, null);

        ImageView vIcon = (ImageView) view.findViewById(R.id.bottomDialog_icon);
        TextView vTitle = (TextView) view.findViewById(R.id.bottomDialog_title);
        TextView vContent = (TextView) view.findViewById(R.id.bottomDialog_content);
        Button vNegative = (Button) view.findViewById(R.id.bottomDialog_cancel);
        Button vPositive = (Button) view.findViewById(R.id.bottomDialog_ok);

        if (icon != null) {
            vIcon.setVisibility(View.VISIBLE);
            vIcon.setImageDrawable(icon);
        }

        if (title != null) {
            vTitle.setText(title);
        }

        if (content != null) {
            vContent.setText(content);
        }

        if (btn_positive != null) {
            vPositive.setVisibility(View.VISIBLE);
            vPositive.setText(btn_positive);
            vPositive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (btn_positive_callback != null)
                        btn_positive_callback.onClick(BottomDialog.this);
                    bottomDialog.dismiss();
                }
            });
        }

        if (btn_negative != null) {
            vNegative.setVisibility(View.VISIBLE);
            vNegative.setText(btn_negative);
            vNegative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (btn_negative_callback != null)
                        btn_negative_callback.onClick(BottomDialog.this);
                    bottomDialog.dismiss();
                }
            });
        }

        bottomDialog.setContentView(view);
        bottomDialog.setCancelable(isCancelable);
        bottomDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);

        return bottomDialog;
    }

    public interface ButtonCallback {

        void onClick(@NonNull BottomDialog dialog);
    }

}
