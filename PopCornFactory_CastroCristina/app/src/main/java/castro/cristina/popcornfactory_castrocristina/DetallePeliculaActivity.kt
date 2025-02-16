package castro.cristina.popcornfactory_castrocristina

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePeliculaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)

        var peliculaImagen: ImageView = findViewById(R.id.iv_pelicula_imagen)
        var nombrePelicula: TextView = findViewById(R.id.tv_nombre_pelicula)
        var peliculaDesc: TextView = findViewById(R.id.tv_pelicula_desc)

        val bundle = intent.extras

        if(bundle != null){
            peliculaImagen.setImageResource(bundle.getInt("header"))
            nombrePelicula.setText(bundle.getString("titulo"))
            peliculaDesc.setText(bundle.getString("sinopsis"))
        }
    }
}