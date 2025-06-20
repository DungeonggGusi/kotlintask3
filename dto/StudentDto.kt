package ru.dungeongg.kotlintask3.dto

data class StudentDto(
    val firstName: String,
    val lastName: String,
    val skills: List<SkillDto>
)
