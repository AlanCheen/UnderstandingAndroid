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
 * Created by 程序亦非猿 on 16/10/9.
 *
 *  多个构造方法注解练习 (不可以!)
 *
 *  疑问? 多个注解构造方法 会怎么样?
 *  结果: Error:(36, 12) 错误: Types may only contain one @Inject constructor.
 *
 *  当 Inject 注解多个构造方法时 dagger2不知道具体使用哪个,就出错啦。
 */
public class MultiConstructorsInject {

    private static final String TAG = "MultiConInject";

    String name = "default";

    @Inject
    public MultiConstructorsInject(String name) {
        this.name = name;
    }

//    @Inject
//    public MultiConsInject() {
//
//    }

    public void log() {
        Log.d(TAG, "log: MultiConInject");
    }
}
