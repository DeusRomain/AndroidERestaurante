
package fr.isen.legrand.androiderestaurant
//import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(
    val data : List<Menu>
): Serializable
data class Menu (
    @SerializedName("name_fr")
    val name_fr: String,
    @SerializedName("name_en")
    val name_en : String,
    @SerializedName("items")
    val items : List<Items>
): Serializable {
    annotation class SerializedName(val value: String)
}

data class Items (
    @Menu.SerializedName("name_fr")
    val name_fr : String,
    @Menu.SerializedName("images")
    val images : List<String>,
    @Menu.SerializedName("ingredients")
    val ingredients : List<Ingredients>,
    @Menu.SerializedName("prices")
    val prices : ArrayList<Prices>
) : Serializable

data class Prices(
    @Menu.SerializedName("price")
    val price: String
) : Serializable

data class Ingredients(
    @Menu.SerializedName("name_fr")
    val name_fr: String
) : Serializable