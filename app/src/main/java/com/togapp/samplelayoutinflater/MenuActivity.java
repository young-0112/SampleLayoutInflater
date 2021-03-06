package com.togapp.samplelayoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // activity_menu.xml 안쪽에 리니어 레이아웃 id는 container
        container = findViewById(R.id.container);
        // activity_menu.xml container를 할당했으니 onclick 할때 변수 참조 가능
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getSystemService() 메서드로 LayoutInflater 객체를 참조
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // sub1.xml 메모리에 객체화
                // inflate() 객체를 이용해서 파라미터로 R.layout.sub1, container를 전달
                inflater.inflate(R.layout.sub1, container, true);

                // sub1.xml이 객체화 되었으니 sub1.xml의 CheckBox를 참조할수있다
                // CheckBox는 sub1에 있지만 container에 객체로 설정되어있으니 container.findViewByID로 참조할수있다.
                CheckBox checkBox = container.findViewById(R.id.checkBox);
                checkBox.setText("로딩되었습니다.");
            }
        });

    }
}