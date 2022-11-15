
<h1 align="center">
NewsDemo
</h1>

:point_right: Clean Architecture: MVVM
-----------------
<div align="center">
<img src="https://camo.githubusercontent.com/0ff5a5738b5561398acfa8563660dafbb5a4fa1e844fc171f930f2228c358f0d/68747470733a2f2f6d69726f2e6d656469756d2e636f6d2f6d61782f313430302f312a3375354a6e6d714f4e5234556e7752453674455633512e706e67">
</div>


## Architecture:

- MVVM Architecture
- Repository pattern
- Applying SOLID principles, each class has a single job with separation of concerns by making classes independent
  of each other and communicating with interfaces.

### Tech Stack:
- [Kotlin](https://kotlinlang.org)
- [Jetpack](https://developer.android.com/jetpack)
  * [Android KTX](https://developer.android.com/kotlin/ktx)
  * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
  * [Data Binding](https://developer.android.com/topic/libraries/data-binding)
  * [View Binding](https://developer.android.com/topic/libraries/view-binding)
  *  [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  * [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started)
  * [Room](https://developer.android.com/training/data-storage/room)

- [Coroutines - Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html)
- [Retrofit](https://square.github.io/retrofit/)
- [DiffUtil](https://developer.android.com/reference/androidx/recyclerview/widget/DiffUtil) to improve RecyclerView's performance when handling list updates. 

## Features:

+ Get news (Open News Api)
+ Save news to BookMarked (Local Database)
+ Search for specific news (Open News Api)



# ScreenShots

<img height=300 width=150 src="https://user-images.githubusercontent.com/39746086/201097947-34dbb9bc-5c88-42cf-a075-4dab22dd207f.png" hspace=24/> <img height=300 width=150 src="https://user-images.githubusercontent.com/39746086/201099281-34b580af-d857-4b96-b68f-fee3a5b6026f.png" hspace=24/> <img height=300 width=150 src="https://user-images.githubusercontent.com/39746086/201099599-d8ff93e6-b8a4-4c32-b269-51794a0b9149.png" hspace=24/> <img height=300 width=150 src="https://user-images.githubusercontent.com/39746086/201099981-e3648857-b9e6-48a1-b5c8-d5022efe54fc.png" hspace=24/> 

:warning: License:
--------

```
MIT License

Copyright (c) 2022 Manar Elsebaay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```




