package br.edu.infnet.dr3_tp3.model

import androidx.annotation.NonNull
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import java.text.SimpleDateFormat

data class Anotacao(
    val userId: String = "",
    var titulo: String = "",
    var corpo: String = "",
    val data: Timestamp = Timestamp.now(),
    @DocumentId val id: String? = null
)
