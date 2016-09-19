package me.yifeiyuan.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessengerService extends Service {

    private static final String TAG = "MessengerService";
    public static final int SAY_HI = 927;

    public MessengerService() {}

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {

            switch (message.what) {
                case SAY_HI:
                    Log.d(TAG, "服务端收到了来自客户端的 say hi!"+Thread.currentThread().getName());//main 线程
                    Messenger client = message.replyTo;
                    if (null == client) {
                        break;
                    }
                    try {
                        Message msg = Message.obtain();
                        client.send(msg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;

            }
            return false;
        }
    });

    private Messenger mMessenger = new Messenger(mHandler);

    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}
