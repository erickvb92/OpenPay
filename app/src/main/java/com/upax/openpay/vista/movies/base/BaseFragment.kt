package com.upax.openpay.vista.movies.base
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.upax.openpay.R

open class BaseFragment: Fragment() {

    /**
     * Extension function to simplify setting an afterTextChanged action to EditText components.
     */
    fun AppCompatEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    private val dialogLoading by lazy {
        val dialogAlertDialog = AlertDialog.Builder(requireContext())
        dialogAlertDialog.setView(R.layout.loading)
        dialogAlertDialog.setMessage("loading")
        dialogAlertDialog.setCancelable(false)
        dialogAlertDialog.create()
    }
    fun showLoading(isShowing: Boolean){
        if (isShowing)
            dialogLoading.show()
        else
            if (dialogLoading.isShowing)
                dialogLoading.dismiss()
    }

}