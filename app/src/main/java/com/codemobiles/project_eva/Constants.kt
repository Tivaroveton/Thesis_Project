package com.codemobiles.project_eva

class Constants {
    companion object{
        var USER_BEAN = "USER_BEAN"

        // SQLite Database
        val DATABASE_NAME = "Account.db"
        val TABLE_NAME = "USERPASSWORD"
        val COLUMN_USERNAME = "USERNAME"
        val COLUMN_PASSWORD = "PASSWORD"
        val COLUMN_LEVEL = "LEVEL"
        val IS_LOGGED_IN = "IS_LOGGED_IN"

        // Feed Server
        val FEED_TRAININGS = "training"
        val FEED_FOODS = "foods"
        val FEED_SUPERHEROS = "superhero"
        val FEED_SONGS = "songs"
    }
}