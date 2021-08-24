package kr.hs.emirim.w2033.ex14_1_4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {
    MediaPlayer mp;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"onCreate() 호출됨",Toast.LENGTH_SHORT).show();
        Log.i("서비스 테스트::","onCreate() 호출됨");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"onStartCommand() 호출됨",Toast.LENGTH_SHORT).show();
        Log.i("서비스 테스트::","onStartCommand() 호출됨");
        mp = MediaPlayer.create(this,R.raw.dumbdumb);
        mp.setLooping(true);
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(),"onDestory() 호출됨",Toast.LENGTH_SHORT).show();
        //Log.i("서비스 테스트::","onDestroy() 호출됨");
        mp.stop();
        super.onDestroy();
    }
}