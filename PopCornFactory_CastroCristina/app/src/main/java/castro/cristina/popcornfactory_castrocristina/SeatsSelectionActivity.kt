package castro.cristina.popcornfactory_castrocristina

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeatsSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seats_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val title: TextView = findViewById(R.id.tv_tittleSeats)
        val bundle = intent.extras
        var posMovie = -1

        if (bundle != null){
            title.text = bundle.getString("name")
            posMovie = bundle.getInt("id")

        }

        val confirm : Button = findViewById(R.id.btnConfirm)

        confirm.setOnClickListener{
            //añadir logica para reservar lugar seleccionado
            //hacer una nueva actividad donde se vea el resumen de la compra donde se vea el nombre y el asiento del cliente
            Toast.makeText(this, "Enjoy the movie!", Toast.LENGTH_LONG).show()
        }

        val row1 : RadioGroup = findViewById(R.id.rg_row1)
        val row2 : RadioGroup = findViewById(R.id.rg_row2)
        val row3 : RadioGroup = findViewById(R.id.rg_row3)
        val row4 : RadioGroup = findViewById(R.id.rg_row4)

        row1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId >-1 ){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId >-1 ){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId >-1 ){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId >-1 ){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkedId)
            }
        }
    }
}