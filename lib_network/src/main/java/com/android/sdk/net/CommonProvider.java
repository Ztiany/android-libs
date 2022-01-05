package com.android.sdk.net;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.sdk.net.core.provider.ErrorMessage;
import com.android.sdk.net.coroutines.CoroutinesResultPostProcessor;
import com.android.sdk.net.rxjava.RxResultPostTransformer;

public interface CommonProvider {

    @NonNull
    ErrorMessage errorMessage();

    @Nullable
    RxResultPostTransformer<?> rxResultPostTransformer();

    @Nullable
    CoroutinesResultPostProcessor coroutinesResultPostProcessor();

}