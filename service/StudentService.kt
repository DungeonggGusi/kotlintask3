package ru.dungeongg.kotlintask3.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.dungeongg.kotlintask3.dto.StudentDto
import ru.dungeongg.kotlintask3.model.Skill
import ru.dungeongg.kotlintask3.model.Student
import ru.dungeongg.kotlintask3.repository.SkillRepository
import ru.dungeongg.kotlintask3.repository.StudentRepository

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val skillRepository: SkillRepository,
    private val xmlParserService: XmlParserService
) {

    @Transactional
    fun processAndSave(xml: String) {
        val studentsDto: List<StudentDto> = xmlParserService.parse(xml)

        studentsDto.forEach { dto ->
            val studentId = studentRepository.save(
                Student(
                    firstName = dto.firstName,
                    lastName = dto.lastName
                )
            )
            dto.skills.forEach { skillDto ->
                skillRepository.save(
                    Skill(
                        studentId = studentId,
                        name = skillDto.name,
                        isHard = skillDto.isHard
                    )
                )
            }
        }
    }
}
