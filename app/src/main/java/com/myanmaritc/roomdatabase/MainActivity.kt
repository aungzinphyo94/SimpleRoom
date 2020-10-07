package com.myanmaritc.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.myanmaritc.roomdatabase.database.BookDatabase
import com.myanmaritc.roomdatabase.model.Book
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = Room.databaseBuilder(
            applicationContext,
            BookDatabase::class.java,
            "BookDB"
        ).build()

        Thread {

            var book = Book(1, "Kotlin")
            db.bookDao().saveBooks(book)
            db.bookDao().getAllBooks().forEach {
                txtName.text = it.bookName
                Log.d("Database>>>>>>", "id: ${it.bookID}")
                Log.d("Database>>>>>>", "Name: ${it.bookName}")
            }

        }.start()
    }
}