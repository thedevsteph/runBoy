package yass.stephanie.com.runboy.Utils

import kotlin.math.roundToInt


class ConverterUtils {

    companion object {
        private const val MALE_DISCOUNT_AGE_FACTOR: Float = 0.2017F
        private const val MALE_DISCOUNT_WEIGHT_FACTOR: Float = 0.09036F
        private const val MALE_DISCOUNT_HEART_RATE_FACTOR: Float = 0.6309F
        private const val MALE_HEART_RATE_DEDUCTION: Float = 55.0969F
        private const val FEMALE_DISCOUNT_AGE_FACTOR: Float = 0.074F
        private const val FEMALE_DISCOUNT_WEIGHT_FACTOR: Float = 0.05741F
        private const val FEMALE_DISCOUNT_HEART_RATE_FACTOR: Float = 0.4472F
        private const val FEMALE_HEART_RATE_DEDUCTION: Float = 20.4022F
        private const val TIME_DEDUCTION: Float = 4.184F
        private var discountedAgeFactor = MALE_DISCOUNT_AGE_FACTOR
        private var discountedWeightFactor = MALE_DISCOUNT_WEIGHT_FACTOR
        private var discountedHeartRateFactor = MALE_DISCOUNT_HEART_RATE_FACTOR
        private var heartRateDeduction = MALE_HEART_RATE_DEDUCTION
    }

    fun convertStepsToPoints(steps: Int): Int {
        var result = steps / 3.45
        return result.roundToInt()
    }

    fun getCaloriesBurned(userDetails: UserDetails, distanceDetails: DistanceDetails): Int {


        when (userDetails.gender) {
            Gender.FEMALE -> {
                discountedAgeFactor = FEMALE_DISCOUNT_AGE_FACTOR
                discountedWeightFactor = FEMALE_DISCOUNT_WEIGHT_FACTOR
                discountedHeartRateFactor = FEMALE_DISCOUNT_HEART_RATE_FACTOR
                heartRateDeduction = FEMALE_HEART_RATE_DEDUCTION
            }
        }

        var discountedAge = userDetails.age * discountedAgeFactor
        var discountedWeight = userDetails.weight * discountedWeightFactor
        var discountedHeartRate =
            (distanceDetails.calculatedHeartRate * discountedHeartRateFactor) - heartRateDeduction
        var timeAllowance = distanceDetails.time / TIME_DEDUCTION
        val result = timeAllowance * (discountedAge + discountedHeartRate + discountedWeight)
        return result.roundToInt()
    }


}



