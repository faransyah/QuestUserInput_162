package com.example.pertemuan4

import android.provider.MediaStore.Audio.Radio
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun LatihanInputt(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var dataNama by remember { mutableStateOf("") }
    var dataEmail by remember { mutableStateOf("") }
    var dataNoHp by remember { mutableStateOf("") }
    var dataAlamat by remember { mutableStateOf("") }

    var jenisK by remember { mutableStateOf("")}
    var dataJenisK by remember { mutableStateOf("")}
    val dataJk = listOf("Laki - Laki", "Perempuan")



    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata", fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }

        )
        Row {
            dataJk.forEach{selectedJk ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = jenisK == selectedJk,
                    onClick ={
                        jenisK = selectedJk
                    } )
                Text(selectedJk)
            }}
        }
        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number )

        )
        TextField(
            value = noHp,
            onValueChange = {noHp = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("No HP")
            },
            placeholder = {
                Text("Masukkan Nomor HP Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Alamat")
            },
            placeholder = {
                Text("Masukkan Alamat Anda")
            }

        )
        Button(onClick = {dataNama = nama
                         dataJenisK = jenisK
                         dataEmail = email
                         dataNoHp = noHp
                         dataAlamat = alamat },
            modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Submit")

        }
        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column {
                TampilData(
                    judul = "Nama",
                    isinya = dataNama,
                )
                TampilData(
                    judul = "Jenis Kelamin",
                    isinya = dataJenisK,
                )
                TampilData(
                    judul = "email",
                    isinya = dataEmail,
                )
                TampilData(
                    judul = "noHp",
                    isinya = dataNoHp,
                )
                TampilData(
                    judul = "Alamat",
                    isinya = dataAlamat,
                )

            }
        }

    }
}
@Composable
fun TampilData(
    judul:String,
    isinya:String
){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya,  modifier = Modifier.weight(2f))
    }


}