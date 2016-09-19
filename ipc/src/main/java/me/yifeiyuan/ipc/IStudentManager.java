/*
 * Copyright (C) 2016, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.yifeiyuan.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.util.List;

/**
 * Created by 程序亦非猿 on 16/9/18.
 *
 * todo  完成手动写 Binder。
 *
 */
public interface IStudentManager extends IInterface{

    boolean addStudent(Student student)throws android.os.RemoteException;

    boolean removeStudent(Student student)throws android.os.RemoteException;

    List<Student> getAllStudents()throws android.os.RemoteException;

    abstract class Stub extends Binder implements IStudentManager{

        private static final String TAG = "IStudentManager.Stub";

        private static final String DESCRIPTOR = "me.yifeiyuan.ipc.IStudentManager";

        static final int TRANSACT_getAllStudents = IBinder.FIRST_CALL_TRANSACTION+1;
        static final int TRANSACT_addStudent = IBinder.FIRST_CALL_TRANSACTION+2;
        static final int TRANSACT_removeStudent = IBinder.FIRST_CALL_TRANSACTION+3;

        public static IStudentManager asInterface(IBinder iBinder) {
            if (null == iBinder) {
                return null;
            }
            //去查询本地
            IInterface ii = iBinder.queryLocalInterface(DESCRIPTOR);
            if (null != ii && ii instanceof IStudentManager) {
                 return (IStudentManager)ii;
            }
            return new Proxy(iBinder);
        }

        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {

            switch (code) {
                case TRANSACT_getAllStudents:
                    data.enforceInterface(DESCRIPTOR);
                    List<Student> students = getAllStudents();
                    reply.writeNoException();
                    reply.writeTypedList(students);
                    return true;
            }
            Log.d(TAG, "onTransact: "+code);
            return super.onTransact(code, data, reply, flags);
        }

        @Override
        public void attachInterface(IInterface owner, String descriptor) {
            super.attachInterface(owner, descriptor);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IStudentManager{

            private IBinder mRemote;

            public Proxy(IBinder remote) {
                mRemote = remote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

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

                List<Student> students;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try{
                    data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACT_getAllStudents, data, reply, 0);
                    reply.readException();
                    students = reply.createTypedArrayList(Student.CREATOR);
                }finally {
                    data.recycle();
                    reply.recycle();
                }
                return students;
            }

            @Override
            public IBinder asBinder() {
                return mRemote;
            }
        }
    }
}
