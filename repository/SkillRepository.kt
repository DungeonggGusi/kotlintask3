package ru.dungeongg.kotlintask3.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ru.dungeongg.kotlintask3.model.Skill

@Repository
class SkillRepository(private val jdbcTemplate: JdbcTemplate) {

    fun save(skill: Skill) {
        val sql = "INSERT INTO skills (student_id, name, is_hard) VALUES (?, ?, ?)"
        jdbcTemplate.update(sql, skill.studentId, skill.name, skill.isHard)
    }
}
