package me.yaoandy107.androidhw;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etSex;
    private EditText etAge;
    private Button btnCheck;
    private TextView tvSuggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        etSex = findViewById(R.id.et_sex);
        etAge = findViewById(R.id.et_age);
        btnCheck = findViewById(R.id.btn_check);
        tvSuggestion = findViewById(R.id.tv_suggestion);
        btnCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_check:
                submit();
                break;
        }
    }

    private void submit() {
        String strSex = etSex.getText().toString().trim().toLowerCase();
        if (TextUtils.isEmpty(strSex)) {
            Toast.makeText(this, "性別請勿留空", Toast.LENGTH_SHORT).show();
            return;
        }

        String strAge = etAge.getText().toString().trim();
        if (TextUtils.isEmpty(strAge)) {
            Toast.makeText(this, "年齡請勿留空", Toast.LENGTH_SHORT).show();
            return;
        }
        int age = Integer.valueOf(strAge);
        if (strSex.equals("male")) {
            if (age > 35) {
                tvSuggestion.setText(R.string.find_couple);
            } else if (age <= 35 && age >= 30) {
                tvSuggestion.setText(R.string.get_marry);
            } else {
                tvSuggestion.setText(R.string.not_hurry);
            }
        } else if (strSex.equals("female")) {
            if (age > 32) {
                tvSuggestion.setText(R.string.find_couple);
            } else if (age <= 32 && age >= 28) {
                tvSuggestion.setText(R.string.get_marry);
            } else {
                tvSuggestion.setText(R.string.not_hurry);
            }
        } else {
            Toast.makeText(this, "請輸入male或female", Toast.LENGTH_SHORT).show();
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }

    }
}
