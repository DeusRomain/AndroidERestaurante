// Importation des classes nécessaires pour le fonctionnement de l'activité

/////     CategoryAdapter


@file:Suppress("UNREACHABLE_CODE")

package fr.isen.legrand.androiderestaurant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.isen.legrand.androiderestaurant.R.layout.menu_activity


// Définition de la classe "entrees" qui étend la classe "AppCompatActivity"
class CategoryActivity : AppCompatActivity() {

    // Cette méthode est appelée lorsque l'activité est créée
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Définition du layout de l'activité
        setContentView(menu_activity)

        // Définition du titre de l'activité en fonction de la catégorie choisie
        when (intent.getStringExtra("categorie")) {
            CATEGORY_ENTREES -> this.title = getString(R.string.entrees)
            CATEGORY_PLATS -> title = getString(R.string.plats)
            CATEGORY_DESSERTS -> title = getString(R.string.desserts)
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
            else -> emptyList() // Si la     catégorie est inconnue, retourner une liste vide

        }
        // Afficher la liste des entrées dans le terminal
        println("Liste des entrées:")
        println(this.makeRequest())

    }

    private fun makeRequest() {
        TODO("Not yet implemented")
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

    // TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST



}