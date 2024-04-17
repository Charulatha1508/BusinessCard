package com.example.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val logo = painterResource(id = R.drawable.android_logo_svgrepo_com)
            Image(painter = logo, contentDescription = null)
            Column(
                modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.full_name),
                    fontSize = 36.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = modifier
                )
                Text(
                    text = stringResource(id = R.string.title),
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = modifier
                )
            }
        }
        val whatsapp = painterResource(id = R.drawable.whatsapp_social_media_svgrepo_com)
        ContactInfo(
            icons = whatsapp,
            information = stringResource(id = R.string.phone_number)
        )
        val google = painterResource(id = R.drawable.google_plus_social_media_svgrepo_com)
        ContactInfo(
            icons = google,
            information = stringResource(id = R.string.email_id)
        )
        val linkedin = painterResource(id = R.drawable.linkedin_social_media_svgrepo_com)
        ContactInfo(
            icons = linkedin,
            information = stringResource(id = R.string.linkedin_url)
        )
    }
}

@Composable
fun ContactInfo(icons: Painter, information: String, modifier: Modifier = Modifier){
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = icons, contentDescription = null)
        Text(
            text = information,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            modifier = modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}