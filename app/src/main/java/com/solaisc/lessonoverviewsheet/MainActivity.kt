@file:OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3WindowSizeClassApi::class)

package com.solaisc.lessonoverviewsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.solaisc.lessonoverviewsheet.ui.theme.AvatarStroke1
import com.solaisc.lessonoverviewsheet.ui.theme.AvatarStroke2
import com.solaisc.lessonoverviewsheet.ui.theme.Background
import com.solaisc.lessonoverviewsheet.ui.theme.GreenPill
import com.solaisc.lessonoverviewsheet.ui.theme.GreenText
import com.solaisc.lessonoverviewsheet.ui.theme.LessonOverviewSheetTheme
import com.solaisc.lessonoverviewsheet.ui.theme.PrimaryText
import com.solaisc.lessonoverviewsheet.ui.theme.PurplePill
import com.solaisc.lessonoverviewsheet.ui.theme.SecondaryText
import com.solaisc.lessonoverviewsheet.ui.theme.SoftPink
import com.solaisc.lessonoverviewsheet.ui.theme.Stroke

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LessonOverviewSheetTheme {
                //val windowSize = calculateWindowSizeClass(this)
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    val activity = LocalActivity.current
    val windowSize = activity?.let { calculateWindowSizeClass(it) }
    val largerScreen = if (windowSize?.widthSizeClass == WindowWidthSizeClass.Compact) {
        false
    } else true

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {

        Box(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .fillMaxSize()
                .padding(top = 24.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    )
                )
                .clip(RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                ))

        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Physics Crash Course",
                    textAlign = if (!largerScreen) { TextAlign.Start } else TextAlign.Center,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryText,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                        .padding(horizontal = 16.dp)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "The Physics Crash Course offers a foundational overview of essential concepts, teaching learners to understand Newton's three laws of motion, explain the principle of energy conservation, distinguish between kinetic and potential energy with real-world examples, solve basic problems involving force and mass, and apply the concept of momentum in everyday situations",
                    textAlign = if (!largerScreen) { TextAlign.Start } else TextAlign.Center,
                    color = SecondaryText,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = if (!largerScreen) { Arrangement.Start } else { Arrangement.Center }
                ) {
                    Chip(
                        text = "Intermediate",
                        foreColor = Background,
                        backgroundColor = PurplePill,
                        icon = ImageVector.vectorResource(R.drawable.intermediate)
                    )
                    Chip(
                        text = "Science",
                        foreColor = GreenText,
                        backgroundColor = GreenPill,
                        icon = null
                    )
                    Chip(
                        text = "Physics",
                        foreColor = GreenText,
                        backgroundColor = GreenPill,
                        icon = null
                    )
                    Chip(
                        text = "15 Mins",
                        foreColor = SecondaryText,
                        backgroundColor = Color.White,
                        borderColor = Stroke,
                        icon = ImageVector.vectorResource(R.drawable.clock)
                    )
                }
                HorizontalDivider(
                    modifier = Modifier
                        .border(0.5.dp, Stroke)
                )
                Spacer(Modifier.height(24.dp))
                Text(
                    text = "What you'll learn:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryText,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp, top = 8.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    ListItem("Understand Newton's three laws of motion")
                    ListItem("Explain the principle of enery conservation")
                    ListItem("Identify real-world examples of kinetic and potential energy")
                    ListItem("Solve simple physics problems involving force and mass")
                    ListItem("Apply concepts of momentum in everyday scenarios")
                    ListItem("Understand Newton's three laws of motion")
                    ListItem("Explain the principle of enery conservation")
                    ListItem("Identify real-world examples of kinetic and potential energy")
                }
                Footer()
            }

        }
    }

}

@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(bottom = 36.dp)
            .background(
                color = SoftPink,
                shape = RoundedCornerShape(32.dp)
            )
            .clip(RoundedCornerShape(32.dp))
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.teacher),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.border(
                    width = 3.dp,
                    brush = Brush.linearGradient(listOf(AvatarStroke1, AvatarStroke2)),
                    shape = CircleShape
                )
                    .clip(CircleShape)
                    .size(48.dp)
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = "Dr. Eleanor Maxwell",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryText
            )
        }
    }
}

@Composable
fun ListItem(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = Background
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 20.sp,
            color = SecondaryText,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun Chip(
    text: String,
    foreColor: Color,
    backgroundColor: Color,
    borderColor: Color? = null,
    icon: ImageVector? = null
) {
    Box(
        modifier = Modifier
            .padding(end=8.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = borderColor ?: Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = foreColor
                )
                Spacer(Modifier.width(8.dp))
            }
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                color = foreColor
            )
        }

    }
}

@PreviewScreenSizes()
@Composable
fun GreetingPreview() {
    LessonOverviewSheetTheme {
        Content()
    }
}