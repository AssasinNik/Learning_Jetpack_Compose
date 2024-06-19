package com.example.mos_parking

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mos_parking.ui.theme.Mos_parkingTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fontFamilyArial = FontFamily(
            Font(R.font.arial, FontWeight.Bold)
        )
        val fontFamilyMoscow = FontFamily(
            Font(R.font.moscow, FontWeight.Normal)
        )
        setContent{
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF09090F))){
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), ){
                Text(text = buildAnnotatedString {
                    append("Moscow ")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF68AD46),
                            fontSize = 30.sp
                        )
                    ){
                        append("parking")
                    }

                },
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = fontFamilyArial,
                        textAlign = TextAlign.Center
                    )
                )
            }
            val description = "Феррари одна из самых быстрых машин, которая колесила по Астрахани"
            val title = "Красная фуррия в Астрахани"
            LazyRow(modifier = Modifier.padding(top = 100.dp)){
                items(50){
                    val random = Random.nextInt(2)
                    val painter = if (random == 0) {
                        painterResource(id = R.drawable.car1)
                    } else {
                        painterResource(id = R.drawable.car2)
                    }
                    Box(modifier = Modifier
                        .padding(16.dp)){
                        CarCard(painter = painter, contentDescription = description, title = title + " " + it.toString(), fontFamily = fontFamilyMoscow)
                    }}
            }
        }
    }
}

@Composable
fun CarCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    fontFamily: FontFamily,
    modifier : Modifier =Modifier
){
    Card(modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ){
        Box(modifier = Modifier.height(200.dp).width(300.dp)){
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xFF68AD46)
                        ),
                        startY = 300f
                    )
                ))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(title, style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = fontFamily
                )
                )
            }
        }

    }
}
@Composable
fun BoxColor(modifier: Modifier = Modifier, updateColor: (Color)->Unit){

    Box( modifier = modifier
        .background(Color.Blue)
        .clickable {
            updateColor(
                Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
            )
        }
    )
}




