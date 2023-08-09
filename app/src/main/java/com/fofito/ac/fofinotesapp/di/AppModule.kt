package com.fofito.ac.fofinotesapp.di

import android.app.Application
import androidx.room.Room
import com.fofito.ac.fofinotesapp.data.local.NotesDatabase
import com.fofito.ac.fofinotesapp.data.local.dao.CategoryDao
import com.fofito.ac.fofinotesapp.domain.typeconverter.AppConverters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNotesDatabase(application: Application): NotesDatabase {
        return Room.databaseBuilder(
            context = application,
            name = "notes_db",
            klass = NotesDatabase::class.java
        ).addTypeConverter(AppConverters()).build()
    }

    @Provides
    @Singleton
    fun providesCategoryDao(notesDatabase: NotesDatabase): CategoryDao {
        return notesDatabase.categoriesDao()
    }

}