import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SimpleViewModelFactory(
    private val argsOfConstructor: Array<Class<*>>,
    private val valuesToArgs: Array<*>
) : ViewModelProvider.Factory {


    constructor(argOfConstructor: Class<*>, valueToArg: Any) : this(
        arrayOf(argOfConstructor),
        arrayOf(valueToArg)
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        if (valuesToArgs.size > 1) {
            modelClass.getConstructor(*argsOfConstructor).newInstance(valuesToArgs)
        } else {
            modelClass.getConstructor(*argsOfConstructor).newInstance(valuesToArgs[0])
        }
}