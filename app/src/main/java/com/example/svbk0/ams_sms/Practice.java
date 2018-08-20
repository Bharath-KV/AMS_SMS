package com.example.svbk0.ams_sms;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.TtsSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Practice extends AppCompatActivity {

    InputFields inputFields = new InputFields();

    private Button back, send;

    private static boolean isEmpty = true;

    private EditText datePInput, teachersCount,
            class1Count, class2Count, class3Count, class4Count, class5Count,
            class6Count, class7Count, class8Count, class9Count, class10Count;

    private TextView message, totalCount;

    private String trim1, trim2, trim3, trim4, trim5, trim6,
            trim7, trim8, trim9, trim10, trim11, trim12;

    private Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        Practice.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        back = findViewById(R.id.practiceBackBtn);
        datePInput = findViewById(R.id.datePInput);
        teachersCount = findViewById(R.id.teacherPInput);
        class1Count = findViewById(R.id.class1PInput);
        class2Count = findViewById(R.id.class2PInput);
        class3Count = findViewById(R.id.class3PInput);
        class4Count = findViewById(R.id.class4PInput);
        class5Count = findViewById(R.id.class5PInput);
        class6Count = findViewById(R.id.class6PInput);
        class7Count = findViewById(R.id.class7PInput);
        class8Count = findViewById(R.id.class8PInput);
        class9Count = findViewById(R.id.class9PInput);
        class10Count = findViewById(R.id.class10PInput);
        totalCount = findViewById(R.id.totalP);
        message = findViewById(R.id.practice_message_text);
        send = findViewById(R.id.sendP);

        inputFields.focusOnRequest(teachersCount, getApplicationContext());

        /********************Setting current date into date edit text and message text**********************/
        datePInput.setText(inputFields.getCurDate());
        message.setText("KARMDM "+inputFields.getCurDate()+",0,0,0,0,0,0,0,0,0,0,0");
        /**************************************************************************************************/

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
                inputFields.focusOnRequest(teachersCount, getApplicationContext());
            }
        };

        datePInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Practice.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        teachersCount.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });

        class1Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class2Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class3Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class4Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class5Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class6Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class7Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class8Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class9Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class10Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    Practice.this.prepareSMSString();
                }
                return false;
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isEmpty){

                    checkIfEmpty(v);

                } else if (!isEmpty){

                    AlertDialog.Builder builder = new AlertDialog.Builder(Practice.this);
                    builder.setMessage("SMS sent successfully!!")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    isEmpty = true;
                                    finish();
                                }
                            }).create();
                    builder.show();

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void updateLabel() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        datePInput.setText(sdf.format(myCalendar.getTime()));
        prepareSMSString();

    }

    private void prepareSMSString() {

        trim1 = this.datePInput.getText().toString().trim();
        trim2 = this.teachersCount.getText().toString().trim();
        trim3 = this.class1Count.getText().toString().trim();
        trim4 = this.class2Count.getText().toString().trim();
        trim5 = this.class3Count.getText().toString().trim();
        trim6 = this.class4Count.getText().toString().trim();
        trim7 = this.class5Count.getText().toString().trim();
        trim8 = this.class6Count.getText().toString().trim();
        trim9 = this.class7Count.getText().toString().trim();
        trim10 = this.class8Count.getText().toString().trim();
        trim11 = this.class9Count.getText().toString().trim();
        trim12 = this.class10Count.getText().toString().trim();

        checkSMSString();

    }

    private void checkSMSString(){

        if (trim2.isEmpty()) {
            trim2 = "0";
        }
        if (trim3.isEmpty()) {
            trim3 = "0";
        }
        if (trim4.isEmpty()) {
            trim4 = "0";
        }
        if (trim5.isEmpty()) {
            trim5 = "0";
        }
        if (trim6.isEmpty()) {
            trim6 = "0";
        }
        if (trim7.isEmpty()) {
            trim7 = "0";
        }
        if (trim8.isEmpty()) {
            trim8 = "0";
        }
        if (trim9.isEmpty()) {
            trim9 = "0";
        }
        if (trim10.isEmpty()) {
            trim10 = "0";
        }
        if (trim11.isEmpty()) {
            trim11 = "0";
        }
        if (trim12.isEmpty()) {
            trim12 = "0";
        }

        buildSMSString();

    }

    private void buildSMSString(){

        this.totalCount.setText(Integer.toString(((((((((
                Integer.parseInt(trim4) + Integer.parseInt(trim3))
                + Integer.parseInt(trim5)) + Integer.parseInt(trim6))
                + Integer.parseInt(trim7)) + Integer.parseInt(trim8))
                + Integer.parseInt(trim9)) + Integer.parseInt(trim10))
                + Integer.parseInt(trim11)) + Integer.parseInt(trim12)));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KARMDM ");
        stringBuilder.append(trim1);
        stringBuilder.append(",");
        stringBuilder.append(trim2);
        stringBuilder.append(",");
        stringBuilder.append(trim3);
        stringBuilder.append(",");
        stringBuilder.append(trim4);
        stringBuilder.append(",");
        stringBuilder.append(trim5);
        stringBuilder.append(",");
        stringBuilder.append(trim6);
        stringBuilder.append(",");
        stringBuilder.append(trim7);
        stringBuilder.append(",");
        stringBuilder.append(trim8);
        stringBuilder.append(",");
        stringBuilder.append(trim9);
        stringBuilder.append(",");
        stringBuilder.append(trim10);
        stringBuilder.append(",");
        stringBuilder.append(trim11);
        stringBuilder.append(",");
        stringBuilder.append(trim12);
        this.message.setText(stringBuilder.toString());

    }

    private void checkIfEmpty(View v){

        if (teachersCount.getText().toString().isEmpty()|| teachersCount.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter number of teachers...");
            inputFields.focusOnRequest(teachersCount, getApplicationContext());

        } else if (class1Count.getText().toString().isEmpty()|| class1Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-1 strength...");
            inputFields.focusOnRequest(class1Count, getApplicationContext());

        } else if (class2Count.getText().toString().isEmpty()|| class2Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-2 strength...");
            inputFields.focusOnRequest(class2Count, getApplicationContext());

        } else if (class3Count.getText().toString().isEmpty()|| class3Count.getText().toString() =="" ){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-3 strength...");
            inputFields.focusOnRequest(class3Count, getApplicationContext());

        } else if (class4Count.getText().toString().isEmpty()|| class4Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-4 strength...");
            inputFields.focusOnRequest(class4Count, getApplicationContext());

        } else if (class5Count.getText().toString().isEmpty()|| class5Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-5 strength...");
            inputFields.focusOnRequest(class5Count, getApplicationContext());

        } else if (class6Count.getText().toString().isEmpty()|| class6Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-6 strength...");
            inputFields.focusOnRequest(class6Count, getApplicationContext());

        } else if (class7Count.getText().toString().isEmpty()|| class7Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-7 strength...");
            inputFields.focusOnRequest(class7Count, getApplicationContext());

        } else if (class8Count.getText().toString().isEmpty()|| class8Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-8 strength...");
            inputFields.focusOnRequest(class8Count, getApplicationContext());

        } else if (class9Count.getText().toString().isEmpty()|| class9Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-9 strength...");
            inputFields.focusOnRequest(class9Count, getApplicationContext());

        } else if (class10Count.getText().toString().isEmpty()|| class10Count.getText().toString() ==""){

            isEmpty = true;
            inputFields.showEmpty(v, "Please enter Class-10 strength...");
            inputFields.focusOnRequest(class10Count, getApplicationContext());

        } else {
            isEmpty = false;
        }
    }

}