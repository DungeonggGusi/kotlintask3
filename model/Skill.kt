package ru.dungeongg.kotlintask3.model

data class Skill(
    val id: Long? = null,
    val studentId: Long,
    val name: String,
    val isHard: Boolean
)
