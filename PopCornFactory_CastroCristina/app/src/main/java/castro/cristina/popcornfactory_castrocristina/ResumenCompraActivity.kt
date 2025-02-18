package castro.cristina.popcornfactory_castrocristina

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResumenCompraActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_resumen_compra)

    val movieTitle: TextView = findViewById(R.id.tv_nombre_pelicula)
    val seatNumber: TextView = findViewById(R.id.tv_tittleSeats)
    val confirmButton: Button = findViewById(R.id.btnConfirm)

    val bundle = intent.extras
    val title = bundle?.getString("name") ?: "Unknown Movie"
    val seat = bundle?.getInt("seat", -1) ?: -1
    val posMovie = bundle?.getInt("id", -1) ?: -1

    movieTitle.text = "Movie: $title"
    seatNumber.text = "Seat: $seat"

        confirmButton.setOnClickListener {
            if (posMovie >= 0 && posMovie < MainActivity.pelicula.size) {
                val cliente = Cliente("User", "Credit Card", seat)
                MainActivity.pelicula[posMovie].seats.add(cliente)
            }

            Toast.makeText(this, "Reservation confirmed!", Toast.LENGTH_LONG).show()
            finish()
        }

    }
}