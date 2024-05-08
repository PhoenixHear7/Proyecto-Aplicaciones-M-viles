import com.google.gson.annotations.SerializedName


class RecipeResult(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
)

class RecipesResponse(
    val results: List<RecipeResult>,
    val offset: Int,
    val number: Int,
    val totalResults: Int
)

class RecipeInformation(
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val image: String,
    val imageType: String,
    val summary: String,
    val cuisines: List<String>,
    val dishTypes: List<String>,
    val instructions: String,
    val extendedIngredients: List<ExtendedIngredient>

) {
}

class ExtendedIngredient(
    val aisle: String,
    val amount: Double,
    val name: String,
    @SerializedName("unitLong")
    val unit: String
)