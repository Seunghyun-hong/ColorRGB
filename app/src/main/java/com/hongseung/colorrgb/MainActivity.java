package com.hongseung.colorrgb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private EditText mColorRedEditText;
    private EditText mColorGreenEditText;
    private EditText mColorBlueEditText;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText
        mColorRedEditText = findViewById(R.id.color_red_edit_text);
        mColorGreenEditText = findViewById(R.id.color_green_edit_text);
        mColorBlueEditText = findViewById(R.id.color_blue_edit_text);


        //광고
        mAdView = (AdView) findViewById(R.id.adView);  //우리는 아직 아이디 안줬으니까 레이아웃에 가서 아이디로 adView라고 정함
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

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
            mColorRedEditText.setText(stringR);
            Toast.makeText(this, R.string.valueNullChecked, Toast.LENGTH_SHORT).show();
        } else {
            stringR = mColorRedEditText.getText().toString();
        }

        //G 널체크
        if (mColorGreenEditText.getText().length() == 0) {
            stringG = "0";
            mColorGreenEditText.setText(stringG);
            Toast.makeText(this, R.string.valueNullChecked, Toast.LENGTH_SHORT).show();
        } else {
            stringG = mColorGreenEditText.getText().toString();
        }

        //B 널체크
        if (mColorBlueEditText.getText().length() == 0) {
            stringB = "0";
            mColorBlueEditText.setText(stringB);
            Toast.makeText(this, R.string.valueNullChecked, Toast.LENGTH_SHORT).show();
        } else {
            stringB = mColorBlueEditText.getText().toString();
        }


        int intR = Integer.parseInt(stringR);
        int intG = Integer.parseInt(stringG);
        int intB = Integer.parseInt(stringB);

        // 255 한계체크
        if (intR > 255) {
            intR = 255;
            mColorRedEditText.setText("" + intR);
            Toast.makeText(this, R.string.valueMaxReadjust, Toast.LENGTH_SHORT).show();
        } else {
            intR = Integer.parseInt(stringR);
        }

        if (intG > 255) {
            intG = 255;
            mColorGreenEditText.setText("" + intG);
            Toast.makeText(this, R.string.valueMaxReadjust, Toast.LENGTH_SHORT).show();

        } else {
            intG = Integer.parseInt(stringG);
        }

        if (intB > 255) {
            intB = 255;
            mColorBlueEditText.setText("" + intB);
            Toast.makeText(this, R.string.valueMaxReadjust, Toast.LENGTH_SHORT).show();

        } else {
            intB = Integer.parseInt(stringB);
        }

        // 어두운 바탕일때 아닐때 구분해서 글자 색 지정
        int intRGB = intR + intG + intB;
        if (intRGB < 328) {
            button.setTextColor(Color.rgb(255, 255, 255));
        } else if (intRGB > 328) {
            button.setTextColor(Color.rgb(0, 0, 0));
        }


        // 배경색 바꾸기
        int intColor = Color.rgb(intR, intG, intB);
        button.setBackgroundColor(intColor); // 배경색을 바꿈
//        button.setText(""+intColor);

        // 버튼 글자로 색상코드를 넣을꺼다.
        // 컬러 int 값을 16진수로 변환하고, 포멧도 바꿔줌
        String hexColor = String.format("#%06X", (0xFFFFFF & intColor)); // 어디서 보고 가져온거라 뜻은 잘 모름.
        button.setText(hexColor);
    }
}
