package com.example.aidlapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAidlService extends Service {

    private ArrayList<Person> persons;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        persons = new ArrayList<>();
        return iBinder;
    }

    private IBinder iBinder = new IAldl.Stub() {

        @Override
        public void addPerson(com.example.aidlapplication.Person person) throws RemoteException {
            Log.e("TAG","收到了来自客户端的请求" + person.getName());
            persons.add(person);
        }

        @Override
        public List<com.example.aidlapplication.Person> getPersonList() throws RemoteException {
            return persons;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("myAidlService","on create success");
    }
}
