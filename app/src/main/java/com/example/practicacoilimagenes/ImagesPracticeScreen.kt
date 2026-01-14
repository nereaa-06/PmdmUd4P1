package com.example.practicacoilimagenes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext

@Composable
fun ImagesPracticeScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Práctica 1 Imágenes",
            style = MaterialTheme.typography.titleLarge
        )

        Text(text = "Imagen local", style = MaterialTheme.typography.titleMedium)

        Image(
            painter = painterResource(id = R.drawable.local_image),
            contentDescription = "Imagen local del proyecto",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Text(text = "Imagen remota", style = MaterialTheme.typography.titleMedium)

        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_960_720.jpg")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            error = painterResource(R.drawable.error),
            contentDescription = "Imagen descargada desde Internet",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
    }
}