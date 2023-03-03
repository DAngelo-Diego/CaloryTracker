package com.study.tracker_domain.use_case


data class TrackerUseCases(
    val trackFood: TrackFoodUseCase,
    val searchFood: SearchFoodUseCase,
    val getFoodsForDate: GetFoodForDateUseCase,
    val deleteTrackedFood: DeleteTrackedFoodUseCase,
    val calculateMealNutrients: CalculateMealNutrients
)