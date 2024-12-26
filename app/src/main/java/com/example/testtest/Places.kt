package com.example.testtest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtest.ui.theme.TesttestTheme



class PlacesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesttestTheme {
                PlacesScreen()
            }
        }
    }
}

@Composable
fun PlacesScreen() {
    val context = LocalContext.current // Получаем текущий контекст

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Заголовок "Места"
        Text(
            text = "Места",
            color = Color(0xFF469D3E), // Зеленый цвет
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(25.dp)
        )

        // Список фотографий (6 фото в 3 строки)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 колонки
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(places) { place ->
                PlaceItem(place)
            }
        }

        // Зеленый прямоугольник внизу
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFF469D3E)) // Зеленый цвет
        ) {
            // Иконка перехода на карту (справа по середине)
            IconButton(
                onClick = {
                    // Переход на MapActivity
                    val intent = Intent(context, MapActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .align(Alignment.CenterEnd) // Выравнивание по правому краю
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.map_icon), // Замените на ваш ресурс
                    contentDescription = "Переход на карту",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Composable
fun PlaceItem(place: Place) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Фотография места
        Image(
            painter = painterResource(id = place.imageRes), // Замените на ваш ресурс
            contentDescription = place.name,
            modifier = Modifier
                .size(150.dp)
                .background(Color.LightGray) // Заглушка для фото
        )
        // Надпись под фото
        Text(
            text = place.name,
            color = Color(0xFF469D3E),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

// Модель данных для места
data class Place(
    val id: Int, // Уникальный идентификатор места
    val name: String, // Название места
    val imageRes: Int // Ресурс изображения (замените на ваш ресурс)
)

// Список мест (пример данных)
val places = listOf(
    Place(
        id = 1,
        name = "озеро",
        imageRes = R.drawable.lake // Замените на ваш ресурс
    ),
    Place(
        id = 2,
        name = "горы",
        imageRes = R.drawable.mount // Замените на ваш ресурс
    ),
    Place(
        id = 3,
        name = "отдых",
        imageRes = R.drawable.rest // Замените на ваш ресурс
    ),
    Place(
        id = 4,
        name = "рыбалка",
        imageRes = R.drawable.fishing// Замените на ваш ресурс
    ),
    Place(
        id = 5,
        name = "водопад",
        imageRes = R.drawable.waterfall // Замените на ваш ресурс
    ),
    Place(
        id = 6,
        name = "город",
        imageRes = R.drawable.city // Замените на ваш ресурс
    )
)

