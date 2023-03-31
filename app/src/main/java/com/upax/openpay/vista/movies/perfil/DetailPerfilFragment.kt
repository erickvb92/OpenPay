package com.upax.openpay.vista.movies.perfil
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.upax.openpay.R
import com.upax.openpay.model.Results
import com.upax.openpay.vista.movies.base.BaseFragment
import com.upax.openpay.vista.movies.movie_list.MovieFragment
import kotlinx.android.synthetic.main.perfil_details.*
import java.lang.reflect.Type
import java.util.ArrayList


class DetailPerfilFragment : BaseFragment() {
    companion object {
        fun newInstance() = DetailPerfilFragment()
    }
    private lateinit var viewModel: DetailPerfilViewModel
    private lateinit var viewFragment: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewFragment = inflater.inflate(R.layout.perfil_details, container, false)


        return viewFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this)[DetailPerfilViewModel::class.java]
        viewModel.getPerfil()
        setObservers()
    }

    private fun setObservers(){
        viewModel._loading.observe(viewLifecycleOwner, Observer {
            val isLoading = it ?: return@Observer
            super.showLoading(isLoading)
        })
        viewModel._perfil.observe(viewLifecycleOwner, Observer {
            val mess = it ?: return@Observer
            if(mess!=null){
                //Glide.with(this@DetailPerfilFragment).load(mess.authorDetails?.avatarPath).into(imagen_author)
                title_author.text = mess.mediaTitle.toString()
                author_details_name.text = "Name: "+mess.authorDetails?.name.toString()
                author_details_username.text = "Username: "+mess.authorDetails?.username.toString()
                author_details_rated.text = "Rating: "+mess.authorDetails?.rating.toString()
                created_at.text = "Fecha: "+mess.createdAt.toString()
                content.text = "Review: "+mess.content.toString()

            }else{
              //modo offline
            }
            //  Toast.makeText(activity, ""+mess.get(1), Toast.LENGTH_LONG).show()
        })

    }

}
