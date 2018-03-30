package com.hongseung.colorrgb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


    }


    // 버튼클릭이벤트
    public void ButtonClicked(View view) {
        ColorPrint(view.getId());
    }


    // 버튼클릭시 진행되는 메소드
    public void ColorPrint(int view) {
        Button button = findViewById(view);

        //255 넘는 수 그리고 널체크 필요!
        String stringR;
        String stringG;
        String stringB;

        //R 널체크
        if (mColorRedEditText.getText().length() == 0) {
            stringR = "0";
            Toast.makeText(this, "빈칸은 0으로 대체되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            stringR = mColorRedEditText.getText().toString();
        }

        //G 널체크
        if (mColorGreenEditText.getText().length() == 0) {
            stringG = "0";
            Toast.makeText(this, "빈칸은 0으로 대체되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            stringG = mColorGreenEditText.getText().toString();
        }

        //B 널체크
        if (mColorBlueEditText.getText().length() == 0) {
            stringB = "0";
            Toast.makeText(this, "빈칸은 0으로 대체되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            stringB = mColorBlueEditText.getText().toString();
        }


        int intR = Integer.parseInt(stringR);
        int intG = Integer.parseInt(stringG);
        int intB = Integer.parseInt(stringB);

        // 255 한계체크
        if (intR > 255) {
            intR = 255;
            Toast.makeText(this, "255초과되는 값을 적어 255로 조정하였습니다.", Toast.LENGTH_SHORT).show();
        } else {
            intR = Integer.parseInt(stringR);
        }

        if (intG > 255) {
            intG = 255;
            Toast.makeText(this, "255초과되는 값을 적어 255로 조정하였습니다.", Toast.LENGTH_SHORT).show();

        } else {
            intG = Integer.parseInt(stringG);
        }

        if (intB > 255) {
            intB = 255;
            Toast.makeText(this, "255초과되는 값을 적어 255로 조정하였습니다.", Toast.LENGTH_SHORT).show();

        } else {
            intB = Integer.parseInt(stringB);
        }


        int intColor = Color.rgb(intR, intG, intB);

        // 컬러 int 값을 16진수로 변환하고, 포멧도 바꿔줌
        String hexColor = String.format("#%06X", (0xFFFFFF & intColor));

        button.setBackgroundColor(intColor); // 배경색을 바꿈
//        button.setText(""+intColor);

        button.setText(hexColor);
    }
}
