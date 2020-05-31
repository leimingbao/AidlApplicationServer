package com.example.aidlapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyAidlService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }


    private val connection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            Log.e("service", "onServiceConnected: success")
        }

        override fun onServiceDisconnected(name: ComponentName) {
            Log.e("service", "onServiceDisconnected: success")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }

}
