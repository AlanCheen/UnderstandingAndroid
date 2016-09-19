package me.yifeiyuan.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

/**
 * @see IStudentManager
 *
 */
public class StudentService extends Service {

    private IBinder mIBinder = new IStudentManager.Stub(){
        @Override
        public boolean addStudent(Student student) throws RemoteException {
            return false;
        }

        @Override
        public boolean removeStudent(Student student) throws RemoteException {
            return false;
        }

        @Override
        public List<Student> getAllStudents() throws RemoteException {
            List<Student> students = new ArrayList<>();
            students.add(new Student("yifeiyuan", 1L));
            return students;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }
}
