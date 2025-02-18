package castro.cristina.popcornfactory_castrocristina

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val btnGetMeIn: Button = findViewById(R.id.btn_get_me_in)
        val intent = Intent(this, MainActivity::class.java)

        btnGetMeIn.setOnClickListener {
            startActivity(intent)
        }
    }
}
