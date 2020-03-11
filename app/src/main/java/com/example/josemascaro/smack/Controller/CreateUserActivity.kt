package com.example.josemascaro.smack.Controller

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.josemascaro.smack.R
import com.example.josemascaro.smack.Services.AuthService
import com.example.josemascaro.smack.Services.UserDataService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"

    var avatarColor = "[0.5,0.5,0.5,1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateUserAvatar(view: View){
        val random = Random()
        val color = Random().nextInt(2)
        val avatar = Random().nextInt(28)

        if(color == 0){
            userAvatar = "light$avatar"
        }else{
            userAvatar = "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvatar,"drawable",packageName)
        createAvatarImageView.setImageResource(resourceId)

    }

    fun createUserClicked(view: View){

        val userName = createUserNameTxt.text.toString()
        val email = createEmailTxt.text.toString()
        val password = createPasswordTxt.text.toString()

        AuthService.registerUser(this, email,password){ registerSuccess ->
            if (registerSuccess){
                AuthService.loginUser(this,email,password){ loginSuccess ->
                    if(loginSuccess){
                        AuthService.createUser(this,userName,email,userAvatar,avatarColor){ createSuccess ->

                            if(createSuccess){
                                println(">>>Success")
                                println(UserDataService.avatarName)
                                println(UserDataService.avatarColor)
                                println(UserDataService.name)
                                finish()
                            }

                        }
                    }
                }
            }
        }

    }

    fun generateColorClicked(view : View){

        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble()/255
        val savedG = g.toDouble()/255
        val savedB = b.toDouble()/255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"
        println(avatarColor)
    }


}
