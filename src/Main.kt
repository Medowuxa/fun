import kotlin.random.Random

fun main() {
    val options = arrayOf("Камень", "Ножницы", "Бумага")

    while (true) {
        val pChoice = getPlayerChoice()
        val cChoice = getComputerChoice()

        println("Вы выбрали: ${options[pChoice - 1]}")
        println("Компьютер выбрал: ${options[cChoice - 1]}")

        val result = determineWinner(pChoice, cChoice)
        when (result) {
            0 -> println("Ничья! Переигровка.")
            1 -> {
                println("Вы выиграли!")
                return
            }
            -1 -> {
                println("Компьютер выиграл!")
                return
            }
        }
    }
}

fun getPlayerChoice(): Int {
    while (true) {
        println("Выберите: 1 - Камень, 2 - Ножницы, 3 - Бумага")
        val input = readLine()?.toIntOrNull()
        if (input in 1..3) {
            return input!!
        } else {
            println("Некорректный ввод. Попробуйте снова.")
        }
    }
}

fun getComputerChoice(): Int {
    return Random.nextInt(1, 4) // Случайное значение от 1 до 3
}

fun determineWinner(player: Int, computer: Int): Int {
    return when {
        player == computer -> 0 // Ничья
        (player == 1 && computer == 2) ||
                (player == 2 && computer == 3) ||
                (player == 3 && computer == 1) -> 1 // Игрок выиграл
        else -> -1 // Компьютер выиграл
    }
}
