# SimpleMoviesApp
The Movie DB app using Kotlin

## Project Overview
This project aims to demonstrate the usage of Android Architecture Components and how this components can be used in an application with a MVVM architecture in Kotlin 

![ScreenshotApp](https://user-images.githubusercontent.com/56521677/93236795-dfa21680-f744-11ea-8372-26f1117bc920.png)

## Project by Layers

![imagen](https://user-images.githubusercontent.com/56521677/93230546-63f09b80-f73d-11ea-80f6-001af7722dd3.png)

Ref: https://devexperto.com/clean-architecture-android/

![layers](https://user-images.githubusercontent.com/56521677/93237140-50493300-f745-11ea-892b-d1abbfc0689b.png)

## Framework layer
 - Inteface for ApiService.
 
## Data Layer
 - Interface and Implementation to get data from Network

## Domain Layer
 - Models: Movies, Series, Actors.
 - Utils: Constants, Extensions, Resource, Genres by Movies and series.
 - Classes to organize the list of movies and series by genres.
 
## UseCase Layer (Interactors)
 - To get Movies and Series already organized.
 - To get People (Actors)
  
## UI
 - Adapters: Movies and Series(Nested recyclerViews) and Actors.
 - Fragments: Movies List, Series List, Actors List and details of each.
  
- Also DI package for Dependency Injection with Hilt.

### Used libraries: ###

- [API](https://www.themoviedb.org/documentation/api)
- [Coroutines](https://developer.android.com/topic/libraries/architecture/coroutines?hl=es-419)
- [Retrofit2](https://github.com/square/retrofit)
- [Gson](https://github.com/google/gson)
- [GLide](https://github.com/bumptech/glide)
- [HILT](https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419)
- [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
- [View Model](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Live data](https://developer.android.com/topic/libraries/architecture/livedata.html)
- [Navigation](https://developer.android.com/guide/navigation)
- [CircleImage](https://github.com/hdodenhof/CircleImageView)


  
