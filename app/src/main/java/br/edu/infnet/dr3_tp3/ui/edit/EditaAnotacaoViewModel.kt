package br.edu.infnet.dr3_tp3.ui.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.dr3_tp3.database.dao.AnotacaoDao
import br.edu.infnet.dr3_tp3.model.Anotacao

class EditaAnotacaoViewModel : ViewModel() {
    private val _anotacao = MutableLiveData<Anotacao>()
    val anotacao: LiveData<Anotacao> = _anotacao

    fun getAnotacao(docId: String) {
        val snapshot = AnotacaoDao.read(docId)
        snapshot.addOnSuccessListener {
            _anotacao.value = it.toObject(Anotacao::class.java)
        }
    }

    fun salvar(titulo: String, corpo: String) {
        _anotacao.value?.titulo = titulo
        _anotacao.value?.corpo = corpo
        AnotacaoDao.update(_anotacao.value!!)
    }
}