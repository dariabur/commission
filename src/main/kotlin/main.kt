const val conv: Int = 100
fun main(){
    val recentAmount = 10000
    val monthlyAmount = 76000
    val cardType = "Visa"
    val res = commission(cardType, monthlyAmount, recentAmount) /conv

    println("Комиссия за перевод составила $res рублей")
}

fun commission(cardType:String = "Vk Pay", amountForMonth:Int = 0, amount:Int):Double{
    val requiredCommission:Double
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
    return result
}
