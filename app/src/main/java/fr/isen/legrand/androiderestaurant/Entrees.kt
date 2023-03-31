// Importation des classes nécessaires pour le fonctionnement de l'activité

/////        MenuActivity
package fr.isen.legrand.androiderestaurant

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

import android.content.Intent
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley



@SuppressLint("ParcelCreator")
class Entrees : AppCompatActivity() {



    // Cette méthode est appelée lorsque l'activité est créée
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Définition du layout de l'activité
        setContentView(R.layout.menu_activity)

        // Définition du titre de l'activité en fonction de la catégorie choisie
        when (intent.getStringExtra("categorie")) {
            CATEGORY_ENTREES -> setTitle(getString(R.string.entrees))
            CATEGORY_PLATS -> setTitle(getString(R.string.plats))
            CATEGORY_DESSERTS -> setTitle(getString(R.string.desserts))
        }

        // Initialisation de la vue du RecyclerView
        setupRecyclerView()
    }

    // Cette méthode retourne une liste de chaînes de caractères qui représentent les éléments du menu en fonction de la catégorie choisie
    private fun getMenuList(): List<String> {
        return when (intent.getStringExtra("categorie")) {
            CATEGORY_ENTREES -> resources.getStringArray(R.array.entrees).toList()
            CATEGORY_PLATS -> resources.getStringArray(R.array.plats).toList()
            CATEGORY_DESSERTS -> resources.getStringArray(R.array.desserts).toList()
            else -> emptyList() // Si la catégorie est inconnue, retourner une liste vide
        }
    }

    // Cette méthode initialise la vue du RecyclerView
    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.menu_recycler_view)

        // Définition du layoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Définition de l'adapter avec l'instance de la classe "MenuAdapter"
        recyclerView.adapter = MenuAdapter(this, getMenuList())
    }

    // Constantes pour les différentes catégories possibles
    companion object {
        const val CATEGORY_ENTREES = "entrees"
        const val CATEGORY_PLATS = "plats"
        const val CATEGORY_DESSERTS = "desserts"
    }


    private fun fromServer(category : String) {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val obj = JSONObject()
        obj.put("id_shop", "1")
        val queue = Volley.newRequestQueue(this@Entrees)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, obj,
            { response ->

                Log.d("Response", "$response")
                Log.d("MenuActivity", "Api call succes")
             //   val menu = JSONObject().fromJson(response.toString(), ContactsContract.Contacts.Data::class.java)

          //      val items = menu.data.firstOrNull{ it.name_fr == category }?.items ?: arrayListOf() // "?."  propage le null et "?:" si c'est null, Si il n'a pas trouvé d'élement par rapport à la catégorie,il renvoie null

       //         binding.loaderIcon.visibility = View.GONE
         //       binding.ListCategory.adapter = adapter

            },
            { error ->
                Log.d("MenuActivity", "La requête à échoué")
            }
        )
        queue.add(jsonObjectRequest)
    }




}

private fun Any.putExtra(categoryEntrees: String, items: Any) {

}





