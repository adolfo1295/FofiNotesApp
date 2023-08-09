package com.fofito.ac.fofinotesapp.di

import com.fofito.ac.fofinotesapp.data.repositories.CategoryRepositoryImpl
import com.fofito.ac.fofinotesapp.domain.repositories.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBinds {

    @Binds
    abstract fun bindCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository

}