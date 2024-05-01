import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.stepbystep.FoodsMenuAdapter
import com.example.stepbystep.R
import com.example.stepbystep.RecipeInformationActivity
import com.example.stepbystep.databinding.ActivityFoodsMenuBinding
import com.example.stepbystep.ui.menu.FoodsMenuViewModel

class FoodsMenuActivity : AppCompatActivity() {
    private lateinit var viewModel: FoodsMenuViewModel
    private lateinit var adapter: FoodsMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFoodsMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el ViewModel
        viewModel = ViewModelProvider(this).get(FoodsMenuViewModel::class.java)

        // Establecer el ViewModel en el binding
        binding.viewmodel = viewModel

        // Establecer el lifecycleOwner para el binding
        binding.lifecycleOwner = this

        // Observar los cambios en los datos del ViewModel
        viewModel.foodsMenu.observe(this, { foods ->
            // Convertir la lista observada en un ArrayList
            val foodsArrayList = ArrayList(foods)
            // Crear y establecer el adaptador
            adapter = FoodsMenuAdapter(this, R.layout.activity_foodsmenu_list, foodsArrayList)
            binding.listfood.adapter = adapter
        })

        // Manejar el clic en un elemento de la lista
        binding.listfood.setOnItemClickListener { parent, view, position, id ->
            // Crear un intent para iniciar la actividad RecipeInformationActivity
            val i = Intent(this, RecipeInformationActivity::class.java)
            // Agregar la información de la receta como extra al intent
            i.putExtra("RECIPE_INFORMATION", viewModel.foodsMenu.value?.get(position))
            // Iniciar la actividad RecipeInformationActivity
            startActivity(i)
        }
    }
}
