package sample

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.seasar.doma.jdbc.Config

@ExtendWith(Env::class)
class SelectTest(config: Config) {

    private val dao: PersonDao = PersonDaoImpl(config)

    @Test
    fun selectBySqlFile() {
        val person = dao.selectById(1)
        assertEquals(Person(1,
                Name("SMITH"),
                10,
                Address("Tokyo", "Yaesu"),
                1,
                Gender.MALE,
                0), person)
    }

    @Test
    fun selectBySqlAnnotation() {
        val person = dao.selectByName("SMITH")
        assertEquals(Person(1,
                Name("SMITH"),
                10,
                Address("Tokyo", "Yaesu"),
                1,
                Gender.MALE,
                0), person)
    }

    @Test
    fun selectByCriteriaApi() {
        val persons = dao.findByDepartmentName("ACCOUNTING")
        assertEquals(1, persons.size)
        val person = persons[0]
        assertEquals("SMITH", person.name.value)
        assertNotNull(person.department)
        assertEquals(1, person.department?.id)
    }
}
