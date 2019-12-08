package com.wipro.exercise.model.bean

data class ExerciseResponse<out T>(val errorCode : Int, val errorMsg : String, val rows: List<Row>,
                                   val title: String)


data class AboutCanada(
    val rows: List<Row>,
    val title: String
)

data class Row(
    val description: String?,
    val imageHref: String?,
    val title: String?
)