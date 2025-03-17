package com.example.assignment2
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.net.Uri
import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity

//import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity<ActivityNotFoundException : Any> : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlInput = findViewById<EditText>(R.id.urlInput)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val launchButton = findViewById<Button>(R.id.launchButton)
        val ringButton = findViewById<Button>(R.id.ringButton)
        val closeButton = findViewById<Button>(R.id.closeButton)

        // Launch URL Button
        launchButton.setOnClickListener {
            val urlText = urlInput.text.toString()
            if (urlText.isNotEmpty()) {
                val uri = Uri.parse(urlText)
                val intent = Intent(Intent.ACTION_VIEW, uri)

                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(this, "No application can handle this request.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please enter a valid URL", Toast.LENGTH_SHORT).show()
            }
        }

        // Ring Button (Open Dialer)
        ringButton.setOnClickListener {
            val phoneNumber = phoneInput.text.toString()
            if (phoneNumber.isNotEmpty()) {
                val uri = Uri.parse("tel:$phoneNumber")
                val intent = Intent(Intent.ACTION_DIAL, uri)

                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(this, "No application can handle this request.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
            }
        }

        // Close App Button
        closeButton.setOnClickListener {
            finishAffinity() // Closes all activities and exits the app
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2Theme {
        Greeting("Android")
    }
}