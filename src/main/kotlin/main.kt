fun main(){
    val recentAmount = 10000
    val monthlyAmount = 76000
    val cardType = "Visa"

    commission(cardType, monthlyAmount, recentAmount)
}

fun commission(cardType:String, amountForMonth:Int = 0, amount:Int){
    var requiredCommission = 0.0
    val minCommissionVisaMir = 3500
    var result = 0.0

    when (cardType) {
        "Visa", "Мир" -> {
            requiredCommission = 0.75
            result = if (amount * requiredCommission <= minCommissionVisaMir) {
                minCommissionVisaMir.toDouble()
            } else {
                amount * requiredCommission
            }
        }
        "Mastercard", "Maestro" -> {
            if (amountForMonth > 75000){
                requiredCommission = 0.6
                result = amount * requiredCommission + 2000
            } else {
                result = 0.0
            }
        }
        "Vk Pay" ->  result = 0.0
    }
    println("Комиссия за перевод составила: " + (result / 100) + " рублей")
}