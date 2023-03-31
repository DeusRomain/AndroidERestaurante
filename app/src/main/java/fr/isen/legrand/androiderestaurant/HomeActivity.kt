// Importation des classes nécessaires pour le fonctionnement de l'activity
package fr.isen.legrand.androiderestaurant

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.legrand.androiderestaurant.databinding.ActivityHomeBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


// Définition de la classe "HomeActivity" qui étend la classe "AppCompatActivity"
class HomeActivity : AppCompatActivity() {

    // Initialisation de la variable de liaison
    private lateinit var binding: ActivityHomeBinding

    // Cette méthode est appelée lorsque l'activity est créée
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Liaison de l'activity à son layout correspondant
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Définition des actions à effectuer lorsqu'on clique sur chaque bouton de catégorie
        binding.entrees.setOnClickListener {
            val intent = Intent(this, Entrees::class.java)
            intent.putExtra("categorie", Entrees.CATEGORY_ENTREES)
            startActivity(intent)
            val entreesButton: Button = findViewById(R.id.entrees)
            entreesButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                    val url = "http://test.api.catering.bluecodegames.com/menu"
                    val params = JSONObject()
                    try {
                        params.put("id_shop", "1")
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                }

                private fun makeRequest(url: String, params: JSONObject, listener: Response.Listener<String?>, errorListener: Response.ErrorListener) {

                }
            })
        }

        binding.plats.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("categorie", CategoryActivity.CATEGORY_PLATS)
            startActivity(intent)
        }

        binding.desserts.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("categorie", CategoryActivity.CATEGORY_DESSERTS)
            startActivity(intent)
        }
    }

}

private fun JSONArray.map(function: () -> Unit): Any {
    TODO("Not yet implemented")
}
