package za.ca.iie.flashcardapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score3)

        val scoreText = findViewById<TextView>(R.id.txtScore)
        val score = intent.getIntExtra("SCORE", 0)
        scoreText.text = "Your Score is : $score"

        val feedbackText  = findViewById<TextView>(R.id.txtFeedback)
        feedbackText.text = if (score < 3){
            "Keep On Practicing" } else "Well Done!"

        val reviewText = findViewById<TextView>(R.id.txtReview)
        val reviewButton = findViewById<Button>(R.id.btnReview)
        reviewButton.setOnClickListener{
            reviewText.text= "Question 1 - TRUE. " +
                    "Question 2 - FALSE , EXPLANATION: The Great Wall was built in the 7th century." +
                    "Question 3 - FALSE , EXPLANATION:The Cold War was not a direct conflict between the US and the Soviet Union. " +
                    "Question 4 - TRUE. " +
                    "Question 5 - TRUE. "

        }

        val exitButton = findViewById<Button>(R.id.btnExit)
        exitButton.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}