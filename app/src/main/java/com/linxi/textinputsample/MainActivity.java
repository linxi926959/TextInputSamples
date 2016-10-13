package com.linxi.textinputsample;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText mNameEdittx;
    private TextInputEditText mPhoneEdittx;
    private TextInputEditText mEmailEdittx;
    private TextInputEditText mPasswordEdittx;
    private TextInputEditText mFeedbackEdittx;

    private String mContentName;
    private String mContentPhone;
    private String mContentEmail;
    private String mContentPassword;
    private String mContentFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mNameEdittx= (TextInputEditText) findViewById(R.id.edit_name);
        mPhoneEdittx= (TextInputEditText) findViewById(R.id.edit_phone);
        mEmailEdittx= (TextInputEditText) findViewById(R.id.edit_email);
        mPasswordEdittx= (TextInputEditText) findViewById(R.id.edit_pwd);
        mFeedbackEdittx= (TextInputEditText) findViewById(R.id.edit_feedback);
        Button submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               controAction(); 
            }
        });
    }

    private void controAction() {
        getContent();
        if (mContentName.length()==0){
            showToast("姓名不能为空!");
        } else if (mContentPhone.length() != 11) {
            showToast("请正确填写11位手机号码!");
        } else if (mContentEmail.length() == 0 || !android.util.Patterns.EMAIL_ADDRESS.matcher(mContentEmail).matches()) {
            showToast("请正确填写邮箱地址!");
        } else if (mContentPassword.length() == 0) {
            showToast("密码不能为空");
        } else if (mContentFeedback.length() == 0) {
            showToast("反馈意见不能为空!");
        } else if (mContentFeedback.length() > 10) {
            showToast("反馈意见长度字数不能大于10!");
        } else {
            doSubmission();
        }
    }

    private void doSubmission() {
        showToast("登录成功");
    }

    private void getContent() {
        mContentName=mNameEdittx.getText().toString();
        mContentPhone=mPhoneEdittx.getText().toString();
        mContentEmail=mEmailEdittx.getText().toString();
        mContentPassword=mPasswordEdittx.getText().toString();
        mContentFeedback=mFeedbackEdittx.getText().toString();
    }
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
