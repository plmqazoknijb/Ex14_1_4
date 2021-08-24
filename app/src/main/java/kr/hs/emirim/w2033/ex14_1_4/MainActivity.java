package kr.hs.emirim.w2033.ex14_1_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("서비스(데몬) 연습");

        intent = new Intent(this,MusicService.class);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_start:
                    startService(intent);
                    Toast.makeText(getApplicationContext(),"startService() 호출됨",Toast.LENGTH_SHORT).show();
                    Log.i("서비스 테스트::","startService() 호출됨");
                    finish();
                    break;
                case R.id.btn_stop:
                    stopService(intent);
                    Toast.makeText(getApplicationContext(),"stopService() 호출됨",Toast.LENGTH_SHORT).show();
                    Log.i("서비스 테스트::","stopService() 호출됨");
                    break;
            }
        }
    };
}