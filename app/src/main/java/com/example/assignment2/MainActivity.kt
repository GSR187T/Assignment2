package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCard(
                mainImageRes = R.drawable.edgeoftmrw,  // Replace with your image
                smallImageRes = R.drawable.edgeoftmrw,      // Replace with your image
                title = "Edge of Tomorrow",
                length = "1:53",
                language = "Eng",
                reviewCount = "600+",
                score = "7.9"
            )
        }
    }
}

@Composable
fun MovieCard(
    mainImageRes: Int,
    smallImageRes: Int,
    title: String,
    length: String,
    language: String,
    reviewCount: String,
    score: String
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            MovieImageSection(mainImageRes, smallImageRes, title)
            Spacer(modifier = Modifier.height(48.dp))
            MovieInfoSection(length, language, score, reviewCount)
        }
    }
}

@Composable
fun MovieImageSection(mainImageRes: Int, smallImageRes: Int, title: String) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(mainImageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 450.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(smallImageRes),
                contentDescription = null,
                modifier = Modifier
                    .width(160.dp)
                    .height(180.dp)

            )

            Spacer(modifier = Modifier.width(32.dp))

            Column {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(18.dp)
                    )
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(18.dp)
                    )
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(18.dp)
                    )
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(18.dp)
                    )
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(18.dp)
                    )
                }

            }
        }
    }
}

@Composable
fun MovieInfoSection(length: String, language: String, rating: String, reviewCount: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        InfoItem(label = "Length", value = length)
        InfoItem(label = "Lang", value = language)
        InfoItem(label = "Rating", value = rating)
        InfoItem(label = "Review", value = reviewCount)
    }
}

@Composable
fun InfoItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, fontSize = 20.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = value, fontSize = 22.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard(
        mainImageRes = R.drawable.edgeoftmrw,
        smallImageRes = R.drawable.edgeoftmrw,
        title = "Edge of Tomorrow",
        length = "1:53",
        language = "Eng",
        reviewCount = "600+",
        score = "7.9"
    )
}
