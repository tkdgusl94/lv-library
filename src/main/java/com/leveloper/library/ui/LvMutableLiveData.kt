package com.leveloper.library.ui

import androidx.lifecycle.LiveData

/**
 * LvMutableLiveData
 * 동일한 값에 대해서는 콜백 이벤트가 발생하지 않는다.
 */
class LvMutableLiveData<T> : LiveData<T> {

    constructor(): super()

    constructor(value: T): super(value)

    public override fun setValue(value: T) {
        if (this.value == value) return
        super.setValue(value)
    }

    public override fun postValue(value: T) {
        if (this.value == value) return
        super.postValue(value)
    }
}