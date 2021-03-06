package me.federicopeyrani.duetto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import me.federicopeyrani.duetto.databinding.ActivityMainBinding
import me.federicopeyrani.duetto.network.AccessTokenRepository
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /** The view binding for this activity. */
    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var accessTokenRepository: AccessTokenRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // check if a token has already been obtained, otherwise start the login activity
        if (accessTokenRepository.refreshToken == null) {
            // launch login activity
            val intent = Intent(this, FirstLaunchActivity::class.java)
            startActivity(intent)
            return
        }

        binding = setContentView(this, R.layout.activity_main)

        // Get the Intent that started this activity and extract the string
        val authOutcome = intent.getIntExtra(FirstLaunchActivity.AUTH_OUTCOME, -1)
        if (authOutcome == FirstLaunchActivity.AUTH_OUTCOME_SUCCESS) {
            // display success message
            val snackbar = Snackbar.make(
                binding.root,
                getString(R.string.login_success),
                Snackbar.LENGTH_LONG
            )
            snackbar.show()
        }
    }
}