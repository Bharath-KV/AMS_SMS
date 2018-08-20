package com.example.svbk0.ams_sms;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
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
import java.util.Locale;

public class SendSMS extends AppCompatActivity {

    InputFields inputFields = new InputFields();

    private EditText dateInput, teachersCount,
            class1Count, class2Count, class3Count, class4Count, class5Count,
            class6Count, class7Count, class8Count, class9Count, class10Count;
    
    private TextView message, totalCount;

    private Button back, sendSMS;

    private static final int REQUEST_SMS = 0;

    PendingIntent sentPI;
    BroadcastReceiver smsSentReceiver;
    String SENT = "SMS_SENT";

    private static boolean isEmpty = true;
    
    private Calendar myCalendar = Calendar.getInstance();

    private String trim1, trim2, trim3, trim4, trim5, trim6,
            trim7, trim8, trim9, trim10, trim11, trim12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        SendSMS.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        back = findViewById(R.id.smsBackBtn);
        dateInput = findViewById(R.id.dateInput);
        teachersCount = findViewById(R.id.teacherInput);
        class1Count = findViewById(R.id.class1Input);
        class2Count = findViewById(R.id.class2Input);
        class3Count = findViewById(R.id.class3Input);
        class4Count = findViewById(R.id.class4Input);
        class5Count = findViewById(R.id.class5Input);
        class6Count = findViewById(R.id.class6Input);
        class7Count = findViewById(R.id.class7Input);
        class8Count = findViewById(R.id.class8Input);
        class9Count = findViewById(R.id.class9Input);
        class10Count = findViewById(R.id.class10Input);
        totalCount = findViewById(R.id.total);
        message = findViewById(R.id.send_message_text);
        sendSMS = findViewById(R.id.sendSMS);

        teachersCount.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(teachersCount, InputMethodManager.SHOW_IMPLICIT);

        /********************Setting current date into date edit text and message text**********************/
        dateInput.setText(inputFields.getCurDate());
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
                teachersCount.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(teachersCount, InputMethodManager.SHOW_IMPLICIT);
            }
        };

        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(SendSMS.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        teachersCount.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });

        class1Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class2Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class3Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class4Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class5Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class6Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class7Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class8Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class9Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });
        this.class10Count.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    SendSMS.this.prepareSMSString();
                }
                return false;
            }
        });

        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty) {

                    checkIfEmpty(v);

                } else if (!isEmpty){

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        int hasSMSPermission = checkSelfPermission(Manifest.permission.SEND_SMS);
                        if (hasSMSPermission != PackageManager.PERMISSION_GRANTED) {
                            if (!shouldShowRequestPermissionRationale(Manifest.permission.SEND_SMS)) {
                                showMessageOKCancel("You need to allow access to Send SMS",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{Manifest.permission.SEND_SMS},
                                                            REQUEST_SMS);
                                                }
                                            }
                                        });
                                return;
                            }
                            requestPermissions(new String[]{Manifest.permission.SEND_SMS},
                                    REQUEST_SMS);
                            return;
                        }
                        sendSMS.setClickable(false);
                        isEmpty = true;
                        sendMySMS();
                    }

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

    protected void onResume() {
        super.onResume();
        this.smsSentReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int con = getResultCode();
                if (context != null) {
                    switch (con) {
                        case 1:
                            Toast.makeText(SendSMS.this, "Please maintain a minimum balance of 1 Rupee in your main account balance.!", Toast.LENGTH_SHORT).show();
                            return;
                        case 2:
                            Toast.makeText(SendSMS.this, "Radio Off!", Toast.LENGTH_SHORT).show();
                            return;
                        case 3:
                            Toast.makeText(SendSMS.this, "null PDU!", Toast.LENGTH_SHORT).show();
                            return;
                        case 4:
                            Toast.makeText(SendSMS.this, "No Network Service available, Please try later.!", Toast.LENGTH_SHORT).show();
                            return;
                        default:
                            sendSuccess();
                            return;
                    }
                }
            }
        };
        registerReceiver(this.smsSentReceiver, new IntentFilter(this.SENT));
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.smsSentReceiver);
    }

    private void updateLabel() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dateInput.setText(sdf.format(myCalendar.getTime()));
        prepareSMSString();

    }

    private void prepareSMSString() {

        trim1 = this.dateInput.getText().toString().trim();
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

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(SendSMS.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    public void sendMySMS() {

        String phone = "7022262856";

        this.sentPI = PendingIntent.getBroadcast(this, 0, new Intent(this.SENT), 0);
        SmsManager.getDefault().sendTextMessage(phone, null, message.getText().toString(), this.sentPI, null);

    }

    public void sendSuccess() {
        new AlertDialog.Builder(SendSMS.this)
                .setMessage("SMS sent successfully!!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .create()
                .show();
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
