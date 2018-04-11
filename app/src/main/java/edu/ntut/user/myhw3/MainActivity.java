package edu.ntut.user.myhw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {


    private TextView txtSex;
    private RadioGroup rgSex;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private Spinner spAge;
    private List<CheckBox> checkBoxList = new ArrayList<>();
    private Button btnOK;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        txtSex = (TextView) findViewById(R.id.txtSex);
        rgSex = findViewById(R.id.rg_sex);
        rgSex.setOnCheckedChangeListener(this);
        rbMale = (RadioButton) findViewById(R.id.rb_male);
        rbFemale = (RadioButton) findViewById(R.id.rb_female);
        spAge = (Spinner) findViewById(R.id.sp_age);

        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_music));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_sing));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_dance));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_travel));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_read));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_write));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_climb));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_swim));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_eat));
        checkBoxList.add((AppCompatCheckBox) findViewById(R.id.cb_draw));

        btnOK = (Button) findViewById(R.id.btnOK);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnOK.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOK:
                StringBuilder hobbies = new StringBuilder();
                for (CheckBox checkBoxHobby : checkBoxList) {
                    if (checkBoxHobby.isChecked()) {
                        hobbies.append(checkBoxHobby.getText().toString()).append(" ");
                    }
                }
                tvResult.setText(hobbies);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        ArrayAdapter<String> adapter;
        String[] entries;
        switch (i) {
            case R.id.rb_male:
                entries = getResources().getStringArray(R.array.male_age_list);
                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, entries);
                spAge.setAdapter(adapter);
                break;
            case R.id.rb_female:
                entries = getResources().getStringArray(R.array.female_age_list);
                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, entries);
                spAge.setAdapter(adapter);
                break;
        }
    }
}
