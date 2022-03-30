package br.edu.infnet.dr3_tp3.ui.add

import androidx.lifecycle.ViewModel
import br.edu.infnet.dr3_tp3.database.dao.AnotacaoDao
import br.edu.infnet.dr3_tp3.model.Anotacao

class AdicionarAnotacaoViewModel : ViewModel() {

    fun adicionar(userId: String, titulo: String, corpo: String) {
        AnotacaoDao.insert(Anotacao(userId, titulo, corpo))
    }


}