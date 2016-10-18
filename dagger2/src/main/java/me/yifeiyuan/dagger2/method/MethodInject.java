/*
 * Copyright (C) 2016, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.yifeiyuan.dagger2.method;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by 程序亦非猿 on 16/10/9.
 *
 *  Inject 注解方法练习 被 Inject 的方法会在构造方法被调用之后调用
 */
public class MethodInject {

    private static final String TAG = "MethodInject";

    @Inject
    public MethodInject() {
        Log.d(TAG, "MethodInject 构造方法被调用");
    }

    @Inject
    void init() {
        Log.d(TAG, "@Inject 调用 init");
    }

    @Inject
    void doSomething() {
        Log.d(TAG, "@Inject doSomething");
    }

    public void hi() {
        Log.d(TAG, "手动 hi~");
    }
}
