package com.study.core.data.preferences

import android.content.SharedPreferences
import com.study.core.domain.model.ActivityLevel
import com.study.core.domain.model.Gender
import com.study.core.domain.model.GoalType
import com.study.core.domain.model.UserInfo
import com.study.core.domain.preferences.Preferences
import com.study.core.domain.preferences.Preferences.Companion.KEY_ACTIVITY_LEVEL
import com.study.core.domain.preferences.Preferences.Companion.KEY_AGE
import com.study.core.domain.preferences.Preferences.Companion.KEY_CARB_RATIO
import com.study.core.domain.preferences.Preferences.Companion.KEY_FAT_RATIO
import com.study.core.domain.preferences.Preferences.Companion.KEY_GENDER
import com.study.core.domain.preferences.Preferences.Companion.KEY_GOAL_TYPE
import com.study.core.domain.preferences.Preferences.Companion.KEY_HEIGHT
import com.study.core.domain.preferences.Preferences.Companion.KEY_PROTEIN_RATIO
import com.study.core.domain.preferences.Preferences.Companion.KEY_SHOULD_SHOW_ONBOARDING
import com.study.core.domain.preferences.Preferences.Companion.KEY_WEIGHT

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {
    override fun saveGender(gender: Gender) {
        sharedPref.edit().putString(KEY_GENDER,gender.name).apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit().putInt(KEY_AGE,age).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit().putFloat(KEY_WEIGHT,weight).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit().putInt(KEY_HEIGHT,height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPref.edit().putString(KEY_ACTIVITY_LEVEL,level.name).apply()

    }

    override fun saveGoalType(goal: GoalType) {
        sharedPref.edit().putString(KEY_GOAL_TYPE,goal.name).apply()

    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref.edit().putFloat(KEY_CARB_RATIO,ratio).apply()

    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit().putFloat(KEY_PROTEIN_RATIO,ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit().putFloat(KEY_FAT_RATIO,ratio).apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPref.getInt(KEY_AGE, -1)
        val height = sharedPref.getInt(KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(KEY_WEIGHT, -1f)
        val genderString = sharedPref.getString(KEY_GENDER, null)
        val activityLevelString = sharedPref.getString(KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPref.getString(KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPref.getFloat(KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPref.getFloat(KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )

    }

    override fun saveShouldShowOnBoarding(shouldShow: Boolean) {
        return sharedPref.edit().putBoolean(KEY_SHOULD_SHOW_ONBOARDING, shouldShow).apply()
    }

    override fun loadShouldShowOnBoarding(): Boolean {
        return sharedPref.getBoolean(KEY_SHOULD_SHOW_ONBOARDING, true)
    }
}