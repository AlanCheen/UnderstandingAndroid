package me.yifeiyuan.ipc;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

public class IpcActivity extends AppCompatActivity {

    private static final String TAG = "IpcActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ipc_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // avoid leaked ServiceConnection
        unbindService(mMessengerConnection);
        unbindService(mAidlConnection);
        unbindService(mStudentConnection);
    }

    //===================================Messenger===================================

    private Messenger mRemoteMessenger;
    private ServiceConnection mMessengerConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//            mMessenger = iBinder.
            mRemoteMessenger = new Messenger(iBinder);
            Message msg = new Message();
            msg.what = MessengerService.SAY_HI;
            try {
                mRemoteMessenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected() called with: " + "componentName = [" + componentName + "]");
        }
    };

    public void onBindMessengerService(View view) {
        Intent intent = new Intent(this, MessengerService.class);
        bindService(intent, mMessengerConnection,BIND_AUTO_CREATE);
    }


    //不同进程下 iBInder 为 BinderProxy@3984 asInterface返回的也是 IBookManager$Stub$Proxy@3993
    //===================================Aidl===================================
    IBookManager mAidlBookManger;
    private ServiceConnection mAidlConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) { //在同一个进程下 iBinder 为 me.yifeiyuan.ipc.AidlService$1@4075
            mAidlBookManger = IBookManager.Stub.asInterface(iBinder);//同一个进程下 返回的就直接是 me.yifeiyuan.ipc.AidlService$1@4075
            try {
                mAidlBookManger.addBook(new Book("深入理解 Android",44));
                List<Book> remoteBooks = mAidlBookManger.getBooks();
                Log.d(TAG, "onServiceConnected aidl book size:"+remoteBooks.size());
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            Log.d(TAG, "onServiceConnected: "+Thread.currentThread().getName());//主线程
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected() called with: " + "componentName = [" + componentName + "]");
        }
    };

    public void onBindAidlService(View view) {
        Intent intent = new Intent(this, AidlService.class);
        bindService(intent, mAidlConnection,BIND_AUTO_CREATE);
    }


    private ServiceConnection mStudentConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IStudentManager manager = IStudentManager.Stub.asInterface(iBinder);

            try {
                List<Student> students = manager.getAllStudents();
                Log.d(TAG, "onServiceConnected: student size:"+students.size());
            } catch (RemoteException e) {
                e.printStackTrace();

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public void onBindStudentService(View view) {
        Intent intent = new Intent(this, StudentService.class);
        bindService(intent, mStudentConnection,BIND_AUTO_CREATE);
    }
}
