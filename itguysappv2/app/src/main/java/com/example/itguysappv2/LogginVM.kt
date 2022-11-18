package com.example.itguysappv2

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.itguysappv2.data.User
import com.example.itguysappv2.firebaseData.Handleliste
import com.example.itguysappv2.firebaseData.HandlelisteObject.handlelisteListe
import com.example.itguysappv2.firebaseData.VareFB
import com.example.itguysappv2.firebaseData.Varer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.Source
import com.google.firebase.storage.FirebaseStorage


class LogginVM : ViewModel() {

    private lateinit var firestore: FirebaseFirestore
    private var storageReference = FirebaseStorage.getInstance().getReference()
    var user: User? = null

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun saveUser() {
        user?.let { user ->
            val handle = firestore.collection("users").document(user.uid).set(user)
            handle.addOnSuccessListener { Log.d("Firebase", "Lagret") }
            handle.addOnFailureListener { Log.e("Firebase", "Feil med lagring") }
        }
    }

    fun listenToHandlekurv() {
        var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        firebaseUser?.let {
            firebaseUser ->
            firestore.collection("users").document(firebaseUser.uid).collection("handlekurv").addSnapshotListener {
                snapshot, e ->
                if (e!= null) {
                    Log.w("listen failed", e)
                    return@addSnapshotListener
                }
                snapshot?.let {
                    handlelisteListe.clear()
                   Handleliste()
                }
            }
        }
    }

    fun saveHandlekruv(vareID: String, tittel: String, pris: String, beskrivelse: String, bildeID: String) {
        var valgtVare = VareFB(
            vareID = vareID,
            tittel = tittel,
            pris = pris,
            beskrivelse = beskrivelse,
            bildeID = bildeID,
        )
        var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        firebaseUser?.let {
                firebaseUser ->
            val document = if (valgtVare.vareID == null || valgtVare.vareID.isEmpty()) {
                firestore.collection("users").document(firebaseUser.uid).collection("handlekurv").document()
                } else {
                    firestore.collection("users").document(firebaseUser.uid).collection("handlekurv").document(valgtVare.vareID)
                    }
            valgtVare.vareID = document.id
            val handle = document.set(valgtVare)
            handle.addOnSuccessListener {
                Log.d("Firebase", "Vare Lagret")
            }
            handle.addOnFailureListener {
                Log.e("Firebase", "Lagring feilet")
            }
        }
    }

}