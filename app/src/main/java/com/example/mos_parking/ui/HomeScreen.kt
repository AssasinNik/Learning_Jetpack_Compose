package com.example.mos_parking.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.mos_parking.Films
import com.example.mos_parking.R
import com.example.mos_parking.ui.theme.Background
import com.example.mos_parking.ui.theme.FirstGradient
import com.example.mos_parking.ui.theme.SecondGradient

val fontFamilyArial = FontFamily(
    Font(R.font.arial, FontWeight.Bold)
)
val fontFamilyMoscow = FontFamily(
    Font(R.font.moscow, FontWeight.Normal)
)

@Composable
fun HomeScreen() {

    Box(modifier = Modifier
        .background(Background)
        .fillMaxSize()
    ){

        Column {
            GreetingSection()
            Text(
                modifier = Modifier
                    .padding(15.dp),
                text= "Подобрать фильм по настроению",
                style = TextStyle(
                    fontSize =  15.sp,
                    fontFamily = fontFamilyMoscow,
                    color = Color.White
                )
            )
            CurrentEmotion()
            MovieSection(films = listOf(
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
        BottomNavBar(items = listOf(
            BottomNavContent("Home", R.drawable.ic_home),
            BottomNavContent("Find", R.drawable.ic_search),
            BottomNavContent("Profile", R.drawable.ic_profile)
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }

}

@Composable
fun BottomNavBar(
    items: List<BottomNavContent>,
    modifier: Modifier = Modifier,
    initialItemIndexSelected: Int = 0
){
    var selectedItemIndex by remember{
        mutableStateOf(initialItemIndexSelected)
    }
    Row (
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Background)
            .padding(15.dp)
    ){
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex
            )
            {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item:BottomNavContent,
    isSelected: Boolean = false,
    onItemClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ){
        Icon(painter = painterResource(id = item.iconId),
            contentDescription = item.title,
            tint = (if(isSelected) Color.White else Color(0xff51535D)),
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun GreetingSection(name:String = "Никита"){
    Row (
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column {
            Text(
                text = "Привет, $name!",
                style = TextStyle(
                    fontSize =  25.sp,
                    fontFamily = fontFamilyArial,
                    color = Color.White
                )
            )
            Text(
                text= "У нас много новинок",
                style = TextStyle(
                    fontSize =  17.sp,
                    fontFamily = fontFamilyMoscow,
                    color = Color.White
                )
            )
        }
        Image(painter = painterResource(id = R.drawable.person),
            contentDescription = "Person",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(65.dp)
                .border(
                    width = 3.dp,
                    brush = Brush.verticalGradient(
                        colors = listOf(FirstGradient, SecondGradient),
                        startY = 50f
                    ),
                    shape = CircleShape
                )
                .clip(CircleShape)

        )
    }
}

@Composable
fun CurrentEmotion(
    color: Brush = Brush.verticalGradient(
        colors = listOf(FirstGradient, SecondGradient),
        startY = 50f
    )
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 10.dp) // уменьшаем вертикальный padding
            .fillMaxWidth()
    ) {
        Text(
            text = "Подобрать фильм",
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = fontFamilyArial
            ),
            color = Color.White
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun MovieSection(films: List<Films>){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Новинки",
            style = TextStyle(
                fontSize =  25.sp,
                fontFamily = fontFamilyArial
            ),
            color = Color.White,
            modifier = Modifier.padding(16.dp) // Увеличиваем отступ сверху
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp), // Вертикальный отступ между карточками
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Горизонтальный отступ между карточками
            contentPadding = PaddingValues(16.dp, 16.dp, 16.dp, 90.dp), // Отступы от краев экрана
            modifier = Modifier.fillMaxHeight()
        ) {
            items(films.size){
                MovieCard(films = films[it])
            }
        }
    }
}

@Composable
fun MovieCard(films: Films){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2 / 3f), // Соотношение сторон для корректного отображения
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = rememberImagePainter(films.image),
                contentDescription = "Film",
                contentScale = ContentScale.Crop, // Изменяем ContentScale для заполнения
                modifier = Modifier.fillMaxSize() // Заполняем всю доступную площадь
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            films.blackColor
                        ),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(
                    text = films.title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = fontFamilyMoscow
                    )
                )
            }
        }
    }
}