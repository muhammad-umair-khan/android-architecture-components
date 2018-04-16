# Android MVVM Architecture: Sample Application

This repository contains a sample app following Android Architecture Components(ViewModel, LiveData), Dagger2, Retrofit, Glide, RxJava2 and Butterknife. Its a basic level but very effective way to dive into Architecture Components and these librares. 

# Libray References:
1- RxJava2: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0

2- Dagger2: https://github.com/MindorksOpenSource/android-dagger2-example

3- Architecture Components: https://github.com/googlesamples/android-architecture-components

# Best Practices(Recommended by Android Official Documentation): 
https://developer.android.com/topic/libraries/architecture/lifecycle.html

Best practices for lifecycle-aware components

1- Keep your UI controllers (activities and fragments) as lean as possible. They should not try to acquire their own data; instead, use a ViewModel to do that, and observe a LiveData object to reflect the changes back to the views.

2- Try to write data-driven UIs where your UI controller’s responsibility is to update the views as data changes, or notify user actions back to the ViewModel.

3- Put your data logic in your ViewModel class. ViewModel should serve as the connector between your UI controller and the rest of your app. Be careful though, it isn't ViewModel's responsibility to fetch data (for example, from a network). Instead, ViewModel should call the appropriate component to fetch the data, then provide the result back to the UI controller.

4- Use Data Binding to maintain a clean interface between your views and the UI controller. This allows you to make your views more declarative and minimize the update code you need to write in your activities and fragments. If you prefer to do this in the Java programming language, use a library like Butter Knife to avoid boilerplate code and have a better abstraction.

5- If your UI is complex, consider creating a presenter class to handle UI modifications. This might be a laborious task, but it can make your UI components easier to test.

6- Avoid referencing a View or Activity context in your ViewModel. If the ViewModel outlives the activity (in case of configuration changes), your activity leaks and isn't properly disposed by the garbage collector.

# Future Updates:
Planned updates include: Databinding,Room and Paging.

# Contributions:
Any contributions will be highly appreciated.
