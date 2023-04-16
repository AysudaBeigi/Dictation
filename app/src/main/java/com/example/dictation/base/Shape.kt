package com.example.dictation.base

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class DictationShapes(
    val small :Shape = RoundedCornerShape(6.dp),
    val medium :Shape = RoundedCornerShape(12.dp),
    val large :Shape = RoundedCornerShape(24.dp),
)
