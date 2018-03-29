package com.hongseung.colorrgb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mColorRedEditText;
    private EditText mColorGreenEditText;
    private EditText mColorBlueEditText;
    private Button mColorButton11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText
        mColorRedEditText = findViewById(R.id.color_red_edit_text);
        mColorGreenEditText = findViewById(R.id.color_green_edit_text);
        mColorBlueEditText = findViewById(R.id.color_blue_edit_text);

         Button
        mColorButton11 = findViewById(R.id.color_button_11);

    }


    // 버튼클릭이벤트
    public void ButtonClicked(View view) {
        ColorPrint(view.getId());
    }


    // 버튼클릭시 진행되는 메소드
    public void ColorPrint(int view) {
        Button button = findViewById(view);

        String stringR = mColorRedEditText.getText().toString();
        String stringG = mColorGreenEditText.getText().toString();
        String stringB = mColorBlueEditText.getText().toString();

        int intR = Integer.parseInt(stringR);
        int intG = Integer.parseInt(stringG);
        int intB = Integer.parseInt(stringB);

        button.setBackgroundColor(Color.rgb(intR,intG,intB));
    }
}
