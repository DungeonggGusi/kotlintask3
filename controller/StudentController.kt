package ru.dungeongg.kotlintask3.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.dungeongg.kotlintask3.service.StudentService

@RestController
class StudentController(private val studentService: StudentService) {

    @PostMapping("/students/upload")
    fun uploadStudents(@RequestBody xml: String): ResponseEntity<String> {
        studentService.processAndSave(xml)
        return ResponseEntity.ok("Студенты успешно сохранены")
    }
}
