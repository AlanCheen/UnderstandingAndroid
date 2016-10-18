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

package me.yifeiyuan.dagger2.module;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by 程序亦非猿 on 16/10/17.
 */
public class Hero {

    private static final String TAG = "Hero";

    Weapon mWeapon;

    @Inject
    public Hero(Weapon weapon) {
        mWeapon = weapon;
    }

    @Inject
    public void attack() {
        Log.d(TAG, "调用 attack: use weapon:"+mWeapon.name);
    }
}
