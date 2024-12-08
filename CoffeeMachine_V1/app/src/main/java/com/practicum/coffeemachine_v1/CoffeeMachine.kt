package com.practicum.coffeemachine_v1
enum class CoffeeRecipes(val coffeeName: String, val water: Int, val milk: Int, val beans: Int) {
    ЭСПРЕССО("эспрессо", 60, 0, 10),
    АМЕРИКАНО("американо", 120, 0, 10),
    КАПУЧИНО("капучино", 120, 60, 20),
    ЛАТТЕ("латте", 240, 120, 20);

    companion object {
        // Поиск рецепта кофе по имени
        fun fromString(name: String): CoffeeRecipes? {
            return values().find { it.coffeeName == name.lowercase() }
        }
    }
}
class CoffeeMachine {  var water = 0
    var milk = 0
    var beans = 0
    private val scanner = Scanner(System.`in`)

    fun start() {
        println("Кофемашина готова к работе")

        while (true) {
            println("Введите команду:")
            val input = getInput() ?: continue

            when (input) {
                "выключить" -> {
                    println("До свидания!")
                    return
                }

                "наполнить" -> {
                    fillIngredients()
                }

                "статус" -> {
                    showStatus()
                }

                "кофе" -> {
                    prepareCoffee()
                }

                else -> {
                    //println("Неизвестная команда, попробуйте снова.")
                }
            }
        }
    }

    private fun fillIngredients() {
        water = 2000
        milk = 1000
        beans = 500
        println("Ингредиенты пополнены")
    }

    private fun showStatus() {
        println("Ингредиентов осталось:")
        println("$water мл воды\n$milk мл молока\n$beans гр кофе")

    }

    private fun prepareCoffee() {
        while (true) {
            println("Введите название напитка или \"назад\" для возврата в главное меню")
            val coffeeCommand = getInput() ?: return

            if (coffeeCommand == "назад") {
                return
            }

            val recipe = CoffeeRecipes.fromString(coffeeCommand)
            if (recipe == null) {
                println("Рецепт не найден!")
            } else {
                makeCoffee(recipe)
            }
        }
    }

    private fun makeCoffee(recipe: CoffeeRecipes) {
        if (water < recipe.water) {
            println("Недостаточно воды!")
            return
        }
        if (milk < recipe.milk) {
            println("Недостаточно молока!")
            return
        }
        if (beans < recipe.beans) {
            println("Недостаточно кофе!")
            return
        }

        // Если хватает всех ингредиентов, готовим кофе
        water -= recipe.water
        milk -= recipe.milk
        beans -= recipe.beans
        var coffeeName = recipe.coffeeName
        println("$coffeeName готов")
    }

    private fun getInput(): String? {
        return if (scanner.hasNextLine()) scanner.nextLine().trim().lowercase() else null
    }
}