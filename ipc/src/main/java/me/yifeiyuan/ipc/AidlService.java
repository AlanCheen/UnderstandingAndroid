package me.yifeiyuan.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AidlService extends Service {
    public AidlService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
