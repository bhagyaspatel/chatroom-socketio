package com.bhagyapatel.chat_socketio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bhagyapatel.chat_socketio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            enterChatRoom()
        }
    }

    private fun enterChatRoom() {
        val username = binding.userName.text.toString()
        val roomname = binding.roomname.text.toString()

        val list = ArrayList<String>()
        list.add(username)
        list.add(roomname)
        if(!roomname.isNullOrBlank() && !username.isNullOrBlank()){
            val intent = Intent (this, ChatRoomActivity::class.java)
            intent.putStringArrayListExtra("roomuser", list)
        }else{
            Toast.makeText(this,"Nickname and Roomname should be filled!", Toast.LENGTH_SHORT)
        }
    }
}