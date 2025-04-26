package com.example.cryptocapapp.views

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cryptocapapp.navigation.BottomNavigationItem
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@Composable
fun Settings(navController: NavHostController) {

    val context = LocalContext.current
    val auth = Firebase.auth

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Text(text = "Iniciar Sesion")
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Email")},
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text("Password")},
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                signIn(auth, email,password,context, navController )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}


private fun createAccount(auth: FirebaseAuth, email: String, password: String, context: Context){
    if (email.isNotBlank() && password.isNotBlank()){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful){
                    Log.d("SettingsView","createUserWithEmail:success")
                    Toast.makeText(context,"Cuenta creada con exito",Toast.LENGTH_SHORT).show()
                }else{
                    Log.w("SettingsView","createUserWithEmail:failure",task.exception)
                    Toast.makeText(context, "Creacion de Cuenta fallida: ${task.exception?.localizedMessage}",
                    Toast.LENGTH_SHORT).show()

                }
            }
    }else{
        Toast.makeText(context, "Llene todos los campos",Toast.LENGTH_SHORT).show()
    }
}

private fun signIn(auth: FirebaseAuth, email: String, password: String, context: Context, navController: NavHostController){
    if(email.isNotBlank() && password.isNotBlank()){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{task ->
                if(task.isSuccessful){
                    Log.d("SettingsView", "signInWithEmail:success")
                    Toast.makeText(context, "Login exitoso", Toast.LENGTH_SHORT).show()

                    navController.navigate(BottomNavigationItem.Home.route){
                        popUpTo(0)
                        launchSingleTop = true
                    }
                }else{
                    Log.w("SettingsView","SignInWithEmail:failure",task.exception)
                    Toast.makeText(context,"Login Fallido ${task.exception?.localizedMessage}",Toast.LENGTH_SHORT).show()
                }
            }
    }else{
        Toast.makeText(context,"Llene todos los campos",Toast.LENGTH_SHORT).show()
    }
}