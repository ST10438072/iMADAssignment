package vcmsa.ci.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    var time : TextView? = null
    var result : TextView? = null
    var value : EditText? = null
    var course : Button? = null
    var reset : Button? = null
    var back: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        time = findViewById<View>(R.id.textView2) as TextView
        result = findViewById<View>(R.id.textView3) as TextView
        value = findViewById<View>(R.id.editTextText) as EditText
        course = findViewById<View>(R.id.courseButton) as Button
        reset = findViewById<View>(R.id.resetButton) as Button
        back = findViewById<View>(R.id.backButton) as Button

        course!!.setOnClickListener(){

            val value = value!!.text.toString()
            val meal:String

            if (value.lowercase()=="morning"){
                meal = "Pancakes with syrup, Eggs, Toast, Orange juice"
            }

            else if( value.lowercase()=="mid-morning"){
                meal = "A fruit smoothie, Yogurt with granola, Nuts"
            }

            else if(value.lowercase()=="afternoon"){
                meal = "Grilled chicken with salad, Sandwich, Rice and beans"
            }

            else if(value.lowercase()=="afternoon-snack"){
                meal = "Potato chips,  "
            }

            else if(value.lowercase()=="dinner"){
               meal = "Pasta with garlic bread, Steak with mashed potatoes, Soup"
            }

            else if(value.lowercase()=="dessert"){
                meal = "Custard, Biscuits, Ice-Cream, Brownies"
            }

            else{
                meal = "Invalid input. Please enter a valid meal time."
            }
            result!!.text="$meal"
        }

        reset!!.setOnClickListener {
            value!!.setText("")
            result!!.text = ""
        }


        back!!.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}