package com.example.mos_parking.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mos_parking.Films
import com.example.mos_parking.R
import com.example.mos_parking.Screen
import com.example.mos_parking.ui.theme.Background

@Composable
fun ListScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Список фильмов",
                style = TextStyle(
                    fontSize =  25.sp,
                    fontFamily = fontFamilyArial,
                    color = Color.White
                )
            )
            ListFilms(film = listOf(
                Films(
                    title = "Однажды в Голливуде",
                    image = "https://avatars.dzeninfra.ru/get-zen_doc/8225917/pub_63fa5d10a4e0cd40a036dabb_63fa5d695b593f6f9cb7b5b0/scale_1200",
                    blackColor = Color(0xFF000000)
                ),
                Films(
                    title = "Экипаж",
                    image = "https://mors-novosibirsk.sibnet.ru/upload/file/fast/1454131763.jpg",
                    blackColor = Color(0xFF000000)
                ),
                Films(
                    title = "Крепкий орешек",
                    image = "https://images.justwatch.com/poster/10658091/s718/a-good-day-to-die-hard.jpg",
                    blackColor = Color(0xFF000000)
                ),
                Films(
                    title = "Мстители: Финал",
                    image = "https://i.pinimg.com/736x/4a/72/6f/4a726f614bd7712b091e13ea05440861.jpg",
                    blackColor = Color(0xFF000000)
                ),
            ))
        }
        var selectedItemIndex by remember { mutableStateOf(1) }
        BottomNavBar(items = listOf(
            BottomNavContent("Home", R.drawable.ic_home),
            BottomNavContent("Find", R.drawable.ic_search),
            BottomNavContent("Profile", R.drawable.ic_profile)
        ), modifier = Modifier.align(Alignment.BottomCenter),initialItemIndexSelected = selectedItemIndex){
                index -> selectedItemIndex = index
            when (index) {
                0 -> navController.navigate(Screen.HomeScreen.route)
                1 -> navController.navigate(Screen.ListScreen.route)
                2 -> navController.navigate(Screen.HomeScreen.route)
            }

        }
    }

}


@Composable
fun ListFilms(film: List<Films>){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp),
        )
    {
        items(film.size){
            CardFilm(films = film[it])
        }
    }
}
@Composable
fun CardFilm(films: Films){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)

    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(50f)
            ) {
                Image(
                    painter = rememberImagePainter(films.image),
                    contentDescription = "movie_poster",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(2 / 3f)
                )
            }

            Spacer(modifier = Modifier
                .width(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(75f)
            ) {
                Text(
                    text = films.title ?: "",
                    style = TextStyle(
                        fontSize =  18.sp,
                        fontFamily = fontFamilyMoscow,
                        color = Color.White
                    )
                )
            }
        }
    }
}
