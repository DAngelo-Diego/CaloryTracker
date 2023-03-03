package com.study.core.domain.preferences

import com.study.core.domain.model.ActivityLevel
import com.study.core.domain.model.Gender
import com.study.core.domain.model.GoalType
import com.study.core.domain.model.UserInfo

interface Preferences {
    fun saveGender(gender: Gender)
    fun saveAge(age: Int)
    fun saveWeight(weight: Float)
    fun saveHeight(height: Int)
    fun saveActivityLevel(level: ActivityLevel)
    fun saveGoalType(goal: GoalType)
    fun saveCarbRatio(ratio: Float)
    fun saveProteinRatio(ratio: Float)
    fun saveFatRatio(ratio: Float)

    fun loadUserInfo(): UserInfo

    //1 time onboarding if is true the onboarding doesnt gonna call again..we did it morty :DDDD eat tacos now!
    fun saveShouldShowOnBoarding(shouldShow: Boolean)
    fun loadShouldShowOnBoarding(): Boolean


    companion object{
        const val KEY_GENDER = "gender"
        const val KEY_AGE = "age"
        const val KEY_WEIGHT = "weight"
        const val KEY_HEIGHT = "height"
        const val KEY_ACTIVITY_LEVEL = "activity_level"
        const val KEY_GOAL_TYPE = "goal_type"
        const val KEY_CARB_RATIO = "carb_ratio"
        const val KEY_PROTEIN_RATIO = "protein_ratio"
        const val KEY_FAT_RATIO = "fat_ratio"
        const val KEY_SHOULD_SHOW_ONBOARDING = "should_show_onboarding"
    }
}