package ru.dungeongg.kotlintask3.util

import ru.dungeongg.kotlintask3.dto.SkillDto
import ru.dungeongg.kotlintask3.dto.StudentDto
import java.io.StringReader
import javax.xml.bind.JAXBContext
import javax.xml.bind.annotation.*

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
class StudentsXml {
    @XmlElement(name = "student")
    var students: List<StudentXml> = mutableListOf()
}

@XmlAccessorType(XmlAccessType.FIELD)
class StudentXml {
    @XmlElement(name = "first_name")
    lateinit var firstName: String

    @XmlElement(name = "second_name")
    lateinit var lastName: String

    @XmlElement(name = "skills")
    lateinit var skills: SkillsXml
}

@XmlAccessorType(XmlAccessType.FIELD)
class SkillsXml {
    @XmlElement(name = "skill")
    var skillList: List<SkillXml> = mutableListOf()
}

@XmlAccessorType(XmlAccessType.FIELD)
class SkillXml {
    @XmlAttribute(name = "hard")
    var hard: Boolean = false

    @XmlAttribute(name = "soft")
    var soft: Boolean = false

    @XmlValue
    lateinit var value: String
}

class XmlMapper {
    fun parseStudents(xml: String): List<StudentDto> {
        val context = JAXBContext.newInstance(StudentsXml::class.java)
        val unmarshaller = context.createUnmarshaller()
        val studentsXml = unmarshaller.unmarshal(StringReader(xml)) as StudentsXml

        return studentsXml.students.map { s ->
            StudentDto(
                firstName = s.firstName,
                lastName = s.lastName,
                skills = s.skills.skillList.map { skillXml ->
                    SkillDto(
                        name = skillXml.value,
                        isHard = skillXml.hard
                    )
                }
            )
        }
    }
}
