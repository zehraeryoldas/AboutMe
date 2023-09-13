package com.exapmle.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.exapmle.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Öncelikle bindingi aktifleştirdik
    //bu sayfaya full binding üzerinden erişim sağladık
    //findviewByid kullanmayacağız
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName=MyName(name = "Zehra ery")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName=myName

       // findViewById<Button>(R.id.done_button).setOnClickListener {
         //   addNickname(it)
        //}
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }
    private fun addNickName(view:View){
        //??????????????????????????????????????????????
        //bunları şimdi ibnding ile çağıracağız
       // val editText=findViewById<EditText>(R.id.nickname_edit)
       // val nicknameTextView=findViewById<TextView>(R.id.nickname_text)
       // nicknameTextView.text=editText.text
       // editText.visibility=View.GONE
       // view.visibility=View.GONE
       // nicknameTextView.visibility=View.VISIBLE
        //bunları şu şekilde çağıracağız şimdi
        //öncelikle kodun okunurluğunu daha da kolaylaştırmak için kotlinin bu eklentisini kullanacağız
        binding.apply {
          //  tüm bağlama ifadelerini geçersiz kılmamız ve böylece bunların doğru verilerle yeniden oluşturulmasını sağlamamız gerekir. invalidateAll()
           // nicknameText.text=binding.nicknameEdit.text
            myName?.nickname=nicknameEdit.text.toString()
            invalidateAll()
//veri girildiğinde alt da tekrar yazılmasını gizle
            nicknameEdit.visibility=View.GONE
            //veri girildiğinde buton kapansın
            doneButton.visibility=View.GONE
//veri girildiğinde veri ekranda gösterilsin
            nicknameText.visibility=View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}