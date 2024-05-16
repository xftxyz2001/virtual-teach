package com.example.myapplication.ui.information;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class informationViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public informationViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.mText = mutableLiveData;
        mutableLiveData.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}
