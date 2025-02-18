package castro.cristina.popcornfactory_castrocristina

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class DetallePeliculaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)

        var peliculaImagen: ImageView = findViewById(R.id.iv_pelicula_imagen)
        var nombrePelicula: TextView = findViewById(R.id.tv_nombre_pelicula)
        var peliculaDesc: TextView = findViewById(R.id.tv_pelicula_desc)
        var asientosSobrantes: TextView = findViewById(R.id.tv_seatsLeft)
        var comparAsientos: Button = findViewById(R.id.btnBuyTickets)

        val bundle = intent.extras
        var numberSeats = 0
        var id = -1
        var titulo = ""

        if(bundle != null){
            titulo = bundle.getString("titulo")!!
            numberSeats = bundle.getInt("numbersSeats")
            peliculaImagen.setImageResource(bundle.getInt("header"))
            nombrePelicula.text = bundle.getString("titulo")
            peliculaDesc.text = bundle.getString("sinopsis")
            asientosSobrantes.text = "$numberSeats seats available"
            id = bundle.getInt("pos")
        }

        if (numberSeats == 0){
            comparAsientos.isEnabled = false
        } else{
            comparAsientos.setOnClickListener {
                val intent = Intent(this, SeatsSelectionActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("name", titulo)
                startActivity(intent)
            }
        }
    }
}