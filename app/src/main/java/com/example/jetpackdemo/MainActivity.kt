package com.example.jetpackdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.jetpackdemo.ui.theme.JetpackDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //    Text(text = "hello", fontSize = 30.sp)          //directly writing here
            //  Displaytxt1()            //calling displaytxt here from compose

            // Displaytxt2(name = "Compose")
            //Displaytxt3()
            //Displaytxt4()
            // styling()
            // RepeatingText()
            //SelectableText()
            //PartialSelectableText()
            // RowDemo()
            // HzlScrollable()
            //  VerticalScrollable()
            // LazyRowDemo()
            // IconDemo()
            // SurfaceColumnDemo()


        }
    }
}

@Composable
fun Displaytxt1(){
    Text(text = "This is first compose", fontSize = 25.sp)
}

@Composable
fun Displaytxt2(name:String){
    Text(text = "This is first jetpack $name", fontSize = 25.sp)
}

@Composable
fun Displaytxt3(){
    //to avoid overlapping of texts
    //method1
    Column() {
        Text(text = "The cat stretched",fontSize = 25.sp)
        Text(text = "Jacob stood on his tiptoes",fontSize = 25.sp)
        Text(text = "he car turned the corner",fontSize = 25.sp)
    }
    //method 2
//    Text(text = "The cat stretched.\n" +
//            "Jacob stood on his tiptoes.\n" +
//            "The car turned the corner.", fontSize = 25.sp)
}

@Composable
fun Displaytxt4(){
    val names = listOf<String>("RAHUL","DEEPAK","ROHIT")
    // Column() {
    //  Text(text = "Hello $name", fontSize = 25.sp)

    Column() {
        for (name in names)
            Text(text = "Hello $name", fontSize = 25.sp)
    }
}

//TEXT STYLING IN COMPOSE
@Composable
fun styling(){
    Text(text = "This is Jetpack Compose",
        fontSize = 25.sp,
        color= Color.Black,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        //fontFamily = MyFontFamily, and import
        //Aligning txt
        textAlign = TextAlign.Center,
        modifier= Modifier
            .background(color = Color.Transparent)
            .width(400.dp)
    )
}

//Repeating text
@Composable
fun RepeatingText(){
    Text(text = "JETPACK COMPOSE ".repeat(12), fontSize = 25.sp, maxLines = 3)
}

//Selectable text
@Composable
fun SelectableText(){
    SelectionContainer() {
        Text(text = "This is Jetpack Compose",
            fontSize = 25.sp,
            color= Color.Black,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier= Modifier
                .background(color = Color.Transparent)
                .width(400.dp))
    }
}

//PartialSelectable text
@Composable
fun PartialSelectableText(){
    Column() {
        SelectionContainer() {
            Text(text = "This is selectable Jetpack Compose",
                fontSize = 25.sp,
                color= Color.Black,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier= Modifier
                    .background(color = Color.Transparent)
                    .width(400.dp))
        }
        Text(text = "This is non-selectsble Jetpack Compose",
            fontSize = 25.sp,
            color= Color.Black,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier= Modifier
                .background(color = Color.Transparent)
                .width(400.dp))
    }
}

//ROW EXAMPLE
@Composable
fun RowDemo() {
    Row(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(color = Color.LightGray),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "This is ", fontSize = 25.sp)
        Text(text ="Android ", fontSize = 25.sp)
        Text(text ="Jetpack Compose", fontSize = 25.sp)

    }
}

//Hrzntl Scrollable

@Composable
fun HzlScrollable() {
    Row(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(color = Color.LightGray)
        .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "This is ", fontSize = 25.sp)
        Text(text ="Android ", fontSize = 25.sp)
        Text(text ="Jetpack Compose ", fontSize = 25.sp)
        Text(text = "The cat stretched ",fontSize = 25.sp)
        Text(text = "Jacob stood on his tiptoes ",fontSize = 25.sp)
        Text(text = "he car turned the corner ",fontSize = 25.sp)

    }
}

//Vrctl Scrollable
@Composable
fun VerticalScrollable() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.fillMaxHeight()
            //.fillMaxWidth()
            .background(color = Color.LightGray)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "I woke up at 10am", fontSize = 25.sp)
        for (i in 0..50) {
            Text(text = "Remaining time $i", fontSize = 25.sp)
        }
        Text(text = "I slept at 10pm", fontSize = 25.sp)
    }
}

//Lazy row
@Composable
fun LazyRowDemo(){
    //Adding single item
    LazyRow(){
        item { Text(text = "Item List: ", fontSize = 25.sp) }

        items (50){ i-> Text(text = "Item $i", fontSize = 25.sp)  }
    }
}

@Composable
fun IconDemo(){
    Icon(Icons.Filled.Menu,
        contentDescription = "Menu Bar",
        modifier = Modifier.size(50.dp),
        tint = Color.Gray)
}

@Preview
@Composable
fun SurfaceColumnDemo(){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween){

        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            color = MaterialTheme.colors.primary){
            Text(text = "List1", fontSize = 25.sp, color = Color.Black)
        }

        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            color = MaterialTheme.colors.primary){
            Text(text = "List2", fontSize = 25.sp,color = Color.Black)
        }

        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            color = MaterialTheme.colors.primary){
            Text(text = "List3", fontSize = 25.sp,color = Color.Black)
        }
    }
}

@Composable //extension fun columnscope
fun ColumnScope.CustomItem(weight:Float,color:Color=MaterialTheme.colors.primary){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .weight(weight),
        color = color){

    }
}

//@Preview
//@Composable
//fun SurfaceColumnDemo() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        CustomItem(weight = 3f, color = MaterialTheme.colors.secondary)
//        CustomItem(weight = 1f)
//    }
//}

//BOX Compose
@Composable
fun BoxDemo(){

}


