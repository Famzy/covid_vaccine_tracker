package com.ehealth4everyone.dhismobile.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ehealth4everyone.dhismobile.R



@Composable
fun LoginPage(){


}
@Preview(showBackground = true)
@Composable
fun BgCard() {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.background)) {
        Image(
            painter = painterResource(R.drawable.log_in),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillHeight// Your contentscale
        )
        
        Column() {
            Row(horizontalArrangement = Arrangement.Center) {
                val padding = 16.dp
                Text(text = "DHIS  2",
                    )
                Spacer(Modifier.size(padding))
                Text(text = "Damler")


            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "DHIS  2")

            }
        }
    }
}