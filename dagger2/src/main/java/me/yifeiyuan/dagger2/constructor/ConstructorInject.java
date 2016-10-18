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

package me.yifeiyuan.dagger2.constructor;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by 程序亦非猿 on 16/9/27.
 *
 * 最简单的 inject构造方法练习
 */
public class ConstructorInject {

    private static final String TAG = "ConstructorInject";

    // Inject 来注解一个构造方法的时候,表示当其他类要实例化该类的时候,使用被Inject注解的构造方法实例化。
    @Inject
    public ConstructorInject() {
        Log.d(TAG, "ConstructorInject: 简单注解构造方法 ok");
    }

    public void log() {
        Log.d(TAG, "log: ConstructorInject");
    }
}
