package com.br.viewmodelbuilder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren

/**
    https://kt.academy/article/cc-constructing-scope
    A classe abaixo nao construida baseada no link acima, foi baseada numa ideia
    de um amigo, Renato Ribeiro. Esse link foi encontrado posteriormente e explica coisas
    interessantes sobre a ideia da classe abaixo.

    Segue um resumo para melhor entendimento no futuro

    - Define-se o contexto da CoroutineSCope como Dispatchers.Main dado que muitas funcoes  no Android
    sao chamadas na MainThread.

    - Sobreescrevemos o metodo onCleared para tornar a nossa CoroutineScope cancelavel, para que quando o escopo
    for cancelado, por exemplo quando o usuário sair da tela e o framework chamar o metodo onDestroy,
    todos os processos nao finalizados sao canceladors.

    - Para fazer o escopo ser cancelavel precisamos criar uma instancia de Job.
        - a funcao CoroutineScope vincula um Job ao contexto passado para funcao como argumento caso nenhum Job esteja
        vinculado

         * If the given [context] does not contain a [Job] element, then a default `Job()` is created.
         * This way, cancellation or failure of any child coroutine in this scope cancels all the other children,
         * just like inside [coroutineScope] block.


    ------------------------------------------------------------------------------------------
    viewModelScope and lifecycleScope (https://kt.academy/article/cc-constructing-scope)

    Nesse projeto, testo implementacoes de observers com livedata e flow. Ambos as ViewModels
    criadas para testar esses 2 observers utilizam o escopo de viewModelScope.

    ViewModelScope e LifecyclerScope funcionam de forma bem similar da forma que a BaseViewModel
    foi construida, com Dispatchers.Main e SupervisorJob

   * @see androidx.lifecycle.viewModelScope
   * @see androidx.lifecycle.lifecycleScope

    ViewModelScope e LifeCycleScope e recomendado se nao precisamos de nenhum contexto
 especial como parte do nosso escopo, como CoroutineExceptionHandler
 */

abstract class BaseViewModel : ViewModel(), CoroutineScope {
    private val viewModelSupervisorJob = SupervisorJob()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + viewModelSupervisorJob

    override fun onCleared() {
        super.onCleared()
        viewModelSupervisorJob.cancelChildren()
    }
}

abstract class BaseViewModelSample(private val onError: ((Throwable) -> Unit)? = null) : ViewModel() {

    /*
        Uma outra forma de observar as excecoes que podem ser lançadas por uma coroutine é o uso de um Observable
        como por exemplo o LiveData do Android.
        Esse
     */
    private val mutableObserverCoroutineException = MutableLiveData<Throwable>()

    val observerCoroutineException: LiveData<Throwable> = mutableObserverCoroutineException

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError?.invoke(throwable)
        mutableObserverCoroutineException.value = throwable
    }

    private val scope = CoroutineScope(Dispatchers.Main + Job() + exceptionHandler)

    /*
        Outra forma de criar escopo.

        Dessa forma podemos criar diferentes coroutines que iniciam seus escopos de forma independente.
        Se usarmos Job(), se qualquer uma coroutine filha for cancelada devido a um erro, a coroutine
        pai e todos os seus fillhos sao cancelados.

        Para adquirir independencia devemos usar SupervisorJob()
     */
    private val scopeWithSupervisedJob = CoroutineScope(Dispatchers.Main + SupervisorJob() + exceptionHandler)

    override fun onCleared() {
        super.onCleared()

        scope.cancel()

        /*
            Eh preferivel nao cancelar o escopo inteiro mas somente seus filhos. Dessa forma, enquanto a viewmodel
            estiver ativa, uma ncva coroutine pode ser iniciada em seu proprio escopo
         */
        scopeWithSupervisedJob.coroutineContext.cancelChildren()
    }
}