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

package me.yifeiyuan.dagger2;

import android.util.Log;

import javax.inject.Inject;

import me.yifeiyuan.dagger2.module.Weapon;

/**
 * Created by 程序亦非猿 on 16/9/27.
 */
public class Man {

    private static final String TAG = "Man";

    // 注解字段 会直接通过 man.weapon = weaponProvider.get() 赋值
    // 不支持 private 修饰 , Dagger does not support injection into private fields
    @Inject
    Weapon weapon;

    // 注解构造方法, 会被dagger用来实例化的时候调用
    @Inject
    public Man() {
        Log.d(TAG, "Man: 实例化");
    }

    // inject 注解方法的时候 会在实例化后紧接着被调用
    @Inject
    public void attack() {
        Log.d(TAG, "调用 attack: use weapon:"+weapon.name);
    }

    public void sayHi() {
        Log.d(TAG, "sayHi: hi man");
    }
}
