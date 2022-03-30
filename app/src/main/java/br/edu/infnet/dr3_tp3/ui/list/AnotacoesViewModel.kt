package br.edu.infnet.dr3_tp3.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.dr3_tp3.database.dao.AnotacaoDao
import br.edu.infnet.dr3_tp3.model.Anotacao

class AnotacoesViewModel() : ViewModel() {
    private val _anotacoes = MutableLiveData<List<Anotacao>>()
    val anotacoes: LiveData<List<Anotacao>> = _anotacoes
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg


    fun updateList(userId: String) {
        AnotacaoDao
            .listUserDocs(userId)
            .addOnSuccessListener {
                _anotacoes.value = it.toObjects(Anotacao::class.java)
            }
            .addOnFailureListener {
                _msg.value = it.message
            }
    }

    fun deleteItem(index: Int, userId: String) {
        try {
            val anotacao = _anotacoes.value?.get(index)
            AnotacaoDao.delete(anotacao)
            updateList(userId)
        } catch (e: Exception) {
            Log.d("Firestore Error", e.message.toString())
        }
    }
}