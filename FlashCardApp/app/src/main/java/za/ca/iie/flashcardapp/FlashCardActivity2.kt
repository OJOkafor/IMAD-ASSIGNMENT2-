package za.ca.iie.flashcardapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class FlashCardActivity2 : AppCompatActivity() {
    // The list of true or false questions
    private val questions = arrayOf(
        "QUESTION 1: The declaration of independence was signed in 1776.",
        "QUESTION 2: The great wall of china was built in The 20th century ",
        "QUESTION 3: The cold war was a direct military conflict between the US and the Soviet Union",
        "QUESTION 4: Abraham Lincoln was the 16th President of the United States ",
        "QUESTION 5: The Magna Carta was signed in 1215"
    )

    // The answers for the true or false questions
    private val answers = booleanArrayOf(true, false, false, true , true )
    private var score = 0
    private var questionIndex = 0

    private lateinit var questionText: TextView
    private lateinit var nextButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash_card2)

        questionText = findViewById(R.id.questionText)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)
        // the
        loadQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        nextButton.setOnClickListener {
            //Load Score Screen
            questionIndex++
            if (questionIndex < questions.size) {
                loadQuestion()

            } else {
                val intent = Intent(this, ScoreActivity3::class.java)
                intent.putExtra("SCORE", score)

                startActivity(intent)
                finish() // Close current activity}
            }


        }

    }

    private fun loadQuestion() {
        questionText.text = questions[questionIndex]
        nextButton.visibility = View.GONE // to HIDE the next button
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[questionIndex]) {

            score ++

            //showing Feedback To The User
            questionText.text = "Correct Answer!"
        } else {
            // Showing incorrect feedback to the user
            questionText.text = "Incorrect Answer!"
        }
        nextButton.visibility = View.VISIBLE // to SHOW the next button
    }
    }


