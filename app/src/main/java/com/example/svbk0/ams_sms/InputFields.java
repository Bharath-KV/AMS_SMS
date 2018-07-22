package com.example.svbk0.ams_sms;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InputFields {

    private String curDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

    public String getCurDate() {
        return curDate;
    }

    public void showEmpty(View v, String field){
        Snackbar snackbar = Snackbar
                .make(v, field, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.RED);
        TextView snackTextView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        snackTextView.setTextColor(Color.YELLOW);
        snackTextView.setTextSize(20);
        snackbar.show();
    }

    public void focusOnRequest(EditText editText, Context context){
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

}

