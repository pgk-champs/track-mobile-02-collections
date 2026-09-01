import kotlin.test.Test
import kotlin.test.assertEquals

class ExercisesTest {

    @Test
    fun `filterAdults оставляет только совершеннолетних`() {
        val people = listOf(Person("Аня", 20), Person("Ваня", 15), Person("Игорь", 18))
        assertEquals(listOf(Person("Аня", 20), Person("Игорь", 18)), filterAdults(people))
        assertEquals(emptyList(), filterAdults(listOf(Person("Катя", 10))))
    }

    @Test
    fun `totalPrice считает сумму цен всех товаров в корзине`() {
        val cart = listOf(Item("Хлеб", 60, "Еда"), Item("Молоко", 90, "Еда"), Item("Тетрадь", 40, "Канцелярия"))
        assertEquals(190, totalPrice(cart))
        assertEquals(0, totalPrice(emptyList()))
    }

    @Test
    fun `groupByCategory группирует товары по категории`() {
        val items = listOf(Item("Хлеб", 60, "Еда"), Item("Тетрадь", 40, "Канцелярия"), Item("Молоко", 90, "Еда"))
        val expected = mapOf(
            "Еда" to listOf(Item("Хлеб", 60, "Еда"), Item("Молоко", 90, "Еда")),
            "Канцелярия" to listOf(Item("Тетрадь", 40, "Канцелярия"))
        )
        assertEquals(expected, groupByCategory(items))
        assertEquals(emptyMap(), groupByCategory(emptyList()))
    }

    @Test
    fun `topN возвращает n наибольших чисел по убыванию`() {
        assertEquals(listOf(9, 7, 5), topN(listOf(3, 9, 1, 7, 5), 3))
        assertEquals(listOf(4, 4, 2), topN(listOf(2, 4, 4), 3))
        assertEquals(emptyList(), topN(emptyList(), 3))
    }
}
