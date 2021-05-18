package com.decadev.rxjava

import android.app.TaskStackBuilder.create
import android.content.IntentFilter.create
import android.graphics.Typeface.create
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.net.URI.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /**
     * The code below will most likely result in OutofMemoryLeak if the device is not top quality.
     */

    /**
     *

    val observable = PublishSubject.create<Int>()
    observable.observeOn(Schedulers.computation())
    .subscribe (
    {
    println("The Number Is: the_result here")
    },
    {t->
    print(t.message)
    }
    )
    for (i in 0..1000000){
    observable.onNext(i)
    }


     */

    /** So in order to handle the backPressure, i converted it to flowable
     *
        The Code below is using the BackPressure strategy Drop which will drop some of the items in order
    to preserve memory capabilities.


    val observable = PublishSubject.create<Int>()
    observable
    .toFlowable(BackpressureStrategy.DROP)
    .observeOn(Schedulers.computation())
    .subscribe (
    {
    println("The Number Is: $it")
    },
    {t->
    print(t.message)
    }
    )
    for (i in 0..1000000){
    observable.onNext(i)
    }
    }

     */


    /** FLOWABLE
     *
     */

    /** Flowable is also an emitter (like Observable) but it supports BackPressure.
     * This is an en exmaple of using flowable as an emitter.

    Flowable.just("This is a Flowable")
    .subscribe(
        { value -> println("Received: $value") },
        { error -> println("Error: $error") },
        { println("Completed") }
    )

     */

    /**
     *  DISPOSABLE
     */

    /* A Disposable will release memory, resources and threads used by an  Observable

     */

    /**
    Observable.just("Apple", "Orange", "Banana")
    .subscribe(
    { v -> println("Received: $v") }
    ).dispose()
    */

//    Results:   Received: Apple
//               Received: Orange
//               Received: Banana
}
