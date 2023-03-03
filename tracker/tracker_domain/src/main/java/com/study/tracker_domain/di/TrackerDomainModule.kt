package com.study.tracker_domain.di

import com.study.core.domain.preferences.Preferences
import com.study.tracker_domain.repository.TrackerRepository
import com.study.tracker_domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFoodUseCase(repository),
            searchFood = SearchFoodUseCase(repository),
            getFoodsForDate = GetFoodForDateUseCase(repository),
            deleteTrackedFood = DeleteTrackedFoodUseCase(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}