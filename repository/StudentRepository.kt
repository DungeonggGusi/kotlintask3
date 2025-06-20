package ru.dungeongg.kotlintask3.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository
import ru.dungeongg.kotlintask3.model.Student
import java.sql.PreparedStatement

@Repository
class StudentRepository(private val jdbcTemplate: JdbcTemplate) {

    fun save(student: Student): Long {
        val sql = "INSERT INTO students (first_name, last_name) VALUES (?, ?)"
        val keyHolder: KeyHolder = GeneratedKeyHolder()

        jdbcTemplate.update({ connection ->
            val ps: PreparedStatement = connection.prepareStatement(sql, arrayOf("id"))
            ps.setString(1, student.firstName)
            ps.setString(2, student.lastName)
            ps
        }, keyHolder)

        return keyHolder.key!!.toLong()
    }
}
