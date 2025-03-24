import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val digitepeso = findViewById<EditText>(R.id.digitepeso)
        val digitealtura = findViewById<EditText>(R.id.digitealtura)
        val botaocalcular = findViewById<Button>(R.id.botaocalcular)
        val resultado = findViewById<TextView>(R.id.resultado)

        botaocalcular.setOnClickListener {
            calcularIMC(digitepeso, digitealtura, resultado)
        }
    }

    private fun calcularIMC(peso: EditText, altura: EditText, resultado: TextView) {
        val peso = peso.text.toString().toFloatOrNull()
        val altura = altura.text.toString().toFloatOrNull()

        if (peso != null && altura != null && altura > 0) {
            val imc = peso / (altura * altura)

            // Classificação do IMC
            val classificacao = when {
                imc < 18.5 -> "Abaixo do peso"
                imc in 18.5..24.9 -> "Peso normal"
                imc in 25.0..29.9 -> "Sobrepeso"
                imc in 30.0..34.9 -> "Obesidade grau 1"
                imc in 35.0..39.9 -> "Obesidade grau 2"
                else -> "Obesidade grau 3 (obesidade mórbida)"
            }

            resultado.text = "IMC: %.2f\n$classificacao".format(imc)
        } else {
            resultado.text = "Insira somente valores válidos!"
        }
    }
}
