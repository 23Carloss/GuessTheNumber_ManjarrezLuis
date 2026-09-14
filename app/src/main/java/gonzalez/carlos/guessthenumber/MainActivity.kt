package gonzalez.carlos.guessthenumber

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue = 0

    var maxValue = 100

    var num: Int = 0

    var won: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)


            val guessings = findViewById<TextView>(R.id.guessings)

            val up = findViewById<Button>(R.id.up)

            val down = findViewById<Button>(R.id.down)

            val generate = findViewById<Button>(R.id.generate)

            val guessed = findViewById<Button>(R.id.guessed)



            generate.setOnClickListener { _: View ->

                num = Random.nextInt(minValue, maxValue)

                guessings.text = num.toString()

                generate.visibility = View.INVISIBLE

                guessed.visibility = View.VISIBLE

            }



            up.setOnClickListener { _: View ->

                minValue = num

                if (checkingLimits()) {

                    num = Random.nextInt(minValue, maxValue)

                    guessings.text = num.toString()

                } else {

                    guessings.text = "No puede ser :( Me ganaste"

                }

            }



            down.setOnClickListener { _: View ->

                maxValue = num

                if (checkingLimits()) {

                    num = Random.nextInt(minValue, maxValue)

                    guessings.text = num.toString()

                } else {

                    guessings.text = "No puede ser :( Me ganaste"

                }

            }



            guessed.setOnClickListener { _: View ->

                if (!won) {

                    guessings.text = "Adiviné, tu número es el " + num

                    guessed.text = "Volver a jugar"

                    won = true

                } else {

                    generate.visibility = View.VISIBLE

                    guessings.text = "Tap on generate to start"

                    guessed.visibility = View.GONE

                    resetValues()

                }

            }

        }



        fun checkingLimits(): Boolean {

            return minValue != maxValue

        }



        fun resetValues() {

            minValue = 0

            maxValue = 100

            num = 0

            won = false

        }
    }
