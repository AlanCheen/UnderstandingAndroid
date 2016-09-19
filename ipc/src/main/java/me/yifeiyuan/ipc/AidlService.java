package me.yifeiyuan.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AidlService extends Service {

    private static final String TAG = "AidlService";

    private CopyOnWriteArrayList<Book> mBooks = new CopyOnWriteArrayList<>();

    private IBookManager mIBookManager = new IBookManager.Stub() {
        @Override
        public List<Book> getBooks() throws RemoteException {
            Log.d(TAG, "getBooks: " + Thread.currentThread().getName());//Binder_1
            return mBooks;
        }

        @Override
        public boolean addBook(Book book) throws RemoteException {
            Log.d(TAG, "addBook: " + Thread.currentThread().getName());//Binder_2
            return mBooks.add(book);
        }

        @Override
        public Book getBookByName(String name) throws RemoteException {
            Log.d(TAG, "getBookByName: " + Thread.currentThread().getName());
            for (Book book : mBooks) {
                if (book.name.equals(name)) {
                    return book;
                }
            }
            return null;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
//        return null;
        return mIBookManager.asBinder();
    }
}
