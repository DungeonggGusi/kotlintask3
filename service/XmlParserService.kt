package ru.dungeongg.kotlintask3.service

import org.springframework.stereotype.Service
import ru.dungeongg.kotlintask3.dto.StudentDto
import ru.dungeongg.kotlintask3.util.XmlMapper

@Service
class XmlParserService(private val xmlMapper: XmlMapper) {

    fun parse(xml: String): List<StudentDto> {
        return xmlMapper.parseStudents(xml)
    }
}
