

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