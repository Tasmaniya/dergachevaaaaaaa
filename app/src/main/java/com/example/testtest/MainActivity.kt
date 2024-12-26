package com.example.testtest


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtest.ui.theme.TesttestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesttestTheme {
                AuthScreen(onStartClick = {
                    // Переход на PlacesActivity
                    val intent = Intent(this, PlacesActivity::class.java)
                    startActivity(intent)
                })
            }
        }
    }
}

@Composable
fun AuthScreen(onStartClick: () -> Unit) {
    var profile by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp) // Высота контейнера
                .padding(bottom = 32.dp)
        ) {
            // Картинка карты
            Image(
                painter = painterResource(id = R.drawable.google_pixel_2_map), // Замените на ваш ресурс
                contentDescription = "Карта",
                modifier = Modifier
                    .fillMaxSize(),
                //contentScale = ContentScale.Crop // Обрезает картинку, чтобы она заполнила область
            )

            // Зеленый прямоугольник
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp) // Высота прямоугольника
                    .background(Color(0xFF469D3E)) // Зеленый цвет
            ) {
                // Надпись "GPS локатор"

                Text(
                    text = "GPS локатор",
                    color = Color.White,
                    style = TextStyle(fontSize = 30.sp),
                    modifier = Modifier
                        .align(Alignment.CenterStart) // Выравнивание по левому краю
                        .padding(start = 16.dp)
                )

                // Иконка шестеренки в правом верхнем углу
                IconButton(
                    onClick = { /* Действие при нажатии */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd) // Выравнивание в правый верхний угол
                        .padding(18.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.setting), // Замените на ваш ресурс
                        contentDescription = "Настройки",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp), // Увеличиваем размер иконки

                    )
                }
            }
        }


        // Поле ввода имени (профиля)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            // Иконка профиля (зеленая)
            Icon(
                painter = painterResource(id = R.drawable.account), // Замените на ваш ресурс
                contentDescription = "Профиль",
                tint = Color(0xFF469D3E), // Зеленый цвет иконки
                modifier = Modifier.size(50.dp)
            )
            // Контейнер для черты и поля ввода
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                // Длинная черта
                Divider(
                    color = Color.Black, // Черный цвет черты
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter) // Черта внизу контейнера
                )
                // Поле ввода имени (профиля)
                TextField(
                    value = profile,
                    onValueChange = { profile = it },
                    label = { Text("") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter), // Поле ввода над чертой
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent, // Прозрачный фон
                        unfocusedContainerColor = Color.Transparent, // Прозрачный фон
                        focusedIndicatorColor = Color.Transparent, // Убираем индикатор
                        unfocusedIndicatorColor = Color.Transparent // Убираем индикатор
                    )
                )
            }
        }

        // Поле ввода пароля
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            // Иконка пароля (зеленая)
            Icon(
                painter = painterResource(id = R.drawable.lock), // Замените на ваш ресурс
                contentDescription = "Пароль",
                tint = Color(0xFF469D3E), // Зеленый цвет иконки
                modifier = Modifier.size(50.dp)
            )
            // Контейнер для черты и поля ввода
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                // Длинная черта
                Divider(
                    color = Color.Black, // Черный цвет черты
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter) // Черта внизу контейнера
                )
                // Поле ввода пароля
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter), // Поле ввода над чертой
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent, // Прозрачный фон
                        unfocusedContainerColor = Color.Transparent, // Прозрачный фон
                        focusedIndicatorColor = Color.Transparent, // Убираем индикатор
                        unfocusedIndicatorColor = Color.Transparent // Убираем индикатор
                    )
                )
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        // Большая зеленая кнопка "Start" внизу экрана
        Box(
            modifier = Modifier
                .width(280.dp)

                .padding(bottom = 160.dp), // Отступы вокруг кнопки

            contentAlignment = Alignment.Center // Центрируем кнопку
        ) {
            with(Button(
                onClick = onStartClick, // Обработчик нажатия
                modifier = Modifier
                    .fillMaxWidth() // Кнопка занимает всю ширину
                    .height(90.dp), // Высота кнопк


                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF469D3E) // Зеленый цвет кнопки
                )
            ) {
                Text(
                    text = "start",
                    fontSize = 50.sp, // Размер текста
                    color = Color.White // Белый цвет текста
                )
            }) {

            }
        }
    }
}

